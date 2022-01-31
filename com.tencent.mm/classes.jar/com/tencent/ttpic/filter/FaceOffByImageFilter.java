package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceOffByImageFilter
  extends VideoFilterBase
{
  private static final String TAG = FaceOffByImageFilter.class.getSimpleName();
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private FaceItem item;
  private float[] texVertices = new float[1380];
  
  public FaceOffByImageFilter(FaceItem paramFaceItem)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF);
    this.item = paramFaceItem;
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    List localList2 = FaceOffUtil.genPoints(this.item.facePoints);
    List localList1 = FaceOffUtil.getGrayCoords(this.item.featureType);
    localList2 = FaceOffUtil.getFullCoords(localList2, 2.0F);
    localList1 = FaceOffUtil.getFullCoords(localList1, 2.0F);
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(localList2, this.faceImageWidth, this.faceImageHeight, this.texVertices));
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(localList1, this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    Bitmap localBitmap1 = FaceOffUtil.getFaceBitmap(this.item.faceExchangeImage);
    Bitmap localBitmap2 = FaceOffUtil.getGrayBitmap(this.item.featureType);
    if ((!VideoBitmapUtil.isLegal(localBitmap1)) || (!VideoBitmapUtil.isLegal(localBitmap2))) {
      return;
    }
    this.faceImageWidth = localBitmap1.getWidth();
    this.faceImageHeight = localBitmap1.getHeight();
    this.grayImageWidth = localBitmap2.getWidth();
    this.grayImageHeight = localBitmap2.getHeight();
    addParam(new m.k("inputImageTexture2", localBitmap1, 33986, true));
    addParam(new m.k("inputImageTexture3", localBitmap2, 33987, true));
    addParam(new m.i("enableFaceOff", 1));
    addParam(new m.f("alpha", this.item.blendAlpha));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.f("positionRotate", 0.0F));
    addParam(new m.i("enableAlphaFromGray", this.item.grayScale));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    if (!paramSet.contains(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value)))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    paramList1 = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList1), 2.0F);
    VideoMaterialUtil.flipYPoints(paramList1, (int)(this.height * this.mFaceDetScale));
    setPositions(FaceOffUtil.initFacePositions(paramList1, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    addParam(new m.f("positionRotate", -paramFloat));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffByImageFilter
 * JD-Core Version:    0.7.0.1
 */