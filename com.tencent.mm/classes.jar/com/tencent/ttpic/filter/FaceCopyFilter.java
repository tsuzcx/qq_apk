package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.n;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.SwitchFaceUtil;
import com.tencent.ttpic.util.SwitchFaceUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceCopyFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
  private float[] faceVertices = new float[276];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[276];
  private List<List<PointF>> mFaceLists;
  private int mFaceTex;
  private float[] texVertices = new float[276];
  
  public FaceCopyFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF);
    initParams();
    this.mFaceLists = new ArrayList();
    this.mFaceTex = -1;
  }
  
  float distanceFrom(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  List<PointF> faceSwapFacePoint(List<PointF> paramList)
  {
    if (paramList.size() != 97) {
      return null;
    }
    float f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    PointF localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(41), (PointF)paramList.get(51));
    double d = 3.141592653589793D + Math.atan2(f1 - f2, f3 + f4);
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 19)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    localArrayList.add(paramList.get(90));
    localArrayList.add(paramList.get(91));
    localArrayList.add(paramList.get(92));
    localArrayList.add(paramList.get(93));
    localArrayList.add(paramList.get(94));
    localArrayList.add(paramList.get(95));
    localArrayList.add(paramList.get(96));
    PointF localPointF2 = midBetween((PointF)paramList.get(56), (PointF)paramList.get(62));
    PointF localPointF3 = new PointF();
    f1 = distanceFrom((PointF)paramList.get(9), localPointF2);
    localPointF3.x = (((PointF)paramList.get(9)).x + 2.0F * f1 / 8.0F * (float)Math.sin(0.0D));
    localPointF3.y = (((PointF)paramList.get(9)).y - 2.0F * f1 / 8.0F * (float)Math.cos(0.0D));
    localArrayList.add(localPointF3);
    i = 1;
    while (i < 6)
    {
      localPointF3 = new PointF();
      localPointF3.x = (((PointF)paramList.get(9)).x + (i + 2) * f1 / 8.0F * (float)Math.sin(0.0D));
      localPointF3.y = (((PointF)paramList.get(9)).y - (i + 2) * f1 / 8.0F * (float)Math.cos(0.0D));
      localArrayList.add(localPointF3);
      i += 1;
    }
    localArrayList.add(localPointF2);
    localArrayList.add(paramList.get(83));
    localArrayList.add(paramList.get(84));
    localArrayList.add(midBetween((PointF)paramList.get(89), (PointF)paramList.get(84)));
    localArrayList.add(paramList.get(89));
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(d));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    return AlgoUtils.mapPoints(localArrayList, localMatrix);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setGrayCords(SwitchFaceUtil.initMaterialFaceTexCoords(faceSwapFacePoint(SwitchFaceUtil.getFullCoords(SwitchFaceUtil.getGrayCoords(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY))), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(138);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = SwitchFaceUtil.getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY);
    if (!VideoBitmapUtil.isLegal(localBitmap)) {
      return;
    }
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new m.n("inputImageTexture2", this.mFaceTex, 33986));
    addParam(new m.k("inputImageTexture3", localBitmap, 33987, true));
    addParam(new m.i("enableFaceOff", 1));
    addParam(new m.f("alpha", 1.0F));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.f("positionRotate", 0.0F));
    addParam(new m.i("enableAlphaFromGray", 1));
  }
  
  PointF midBetween(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public void renderProcess(Set<Integer> paramSet)
  {
    if ((!paramSet.contains(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value))) || (this.mFaceLists.size() < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      OnDrawFrameGLSL();
      renderTexture(this.mFaceTex, this.width, this.height);
    }
    for (;;)
    {
      return;
      paramSet = faceSwapFacePoint(SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList((List)this.mFaceLists.get(0))));
      VideoMaterialUtil.flipYPoints(paramSet, (int)(this.height * this.mFaceDetScale));
      setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
      int i = 1;
      while (i < this.mFaceLists.size())
      {
        paramSet = faceSwapFacePoint(SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList((List)this.mFaceLists.get(i))));
        VideoMaterialUtil.flipYPoints(paramSet, (int)(this.height * this.mFaceDetScale));
        setPositions(SwitchFaceUtil.initFacePositions(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
        setCoordNum(138);
        OnDrawFrameGLSL();
        renderTexture(this.mFaceTex, this.width, this.height);
        i += 1;
      }
    }
  }
  
  public void setFaceParams(List<List<PointF>> paramList, int paramInt)
  {
    this.mFaceLists = paramList;
    this.mFaceTex = paramInt;
    addParam(new m.n("inputImageTexture2", this.mFaceTex, 33986));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceCopyFilter
 * JD-Core Version:    0.7.0.1
 */