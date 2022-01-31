package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HeadCropFilter
  extends VideoFilterBase
{
  private static final String TAG = HeadCropFilter.class.getSimpleName();
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private h inputFrame;
  
  public HeadCropFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.HEAD_CROP);
    initParams();
  }
  
  public h getInputFrame()
  {
    return this.inputFrame;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP), 3.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP);
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new m.k("inputImageTexture2", localBitmap, 33986, true));
    addParam(new m.i("enableFaceOff", 1));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.inputFrame.texture[0], this.inputFrame.width, this.inputFrame.height);
  }
  
  public void setInputFrame(h paramh)
  {
    this.inputFrame = paramh;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    if ((paramList1 == null) || (paramList1.size() < 90))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList1), 3.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.HeadCropFilter
 * JD-Core Version:    0.7.0.1
 */