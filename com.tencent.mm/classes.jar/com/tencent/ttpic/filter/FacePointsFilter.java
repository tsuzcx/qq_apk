package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.a;
import com.tencent.filter.m.b;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FacePointsFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "DrawPoints.glsl");
  private int heigth;
  private double mFaceDetScale = 1.0D;
  private int width;
  
  public FacePointsFilter()
  {
    super(FRAGMENT_SHADER);
  }
  
  public static FacePointsFilter createFaceFilter()
  {
    return new FacePointsFilter();
  }
  
  public void ApplyGLSLFilter()
  {
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.b("faceDetectImageSize", 0.0F, 0.0F));
    addParam(new m.a("facePoints", new float[0]));
    super.ApplyGLSLFilter();
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      updatePoints(VideoMaterialUtil.toFlatArray(FaceOffUtil.getFullCoords((List)paramList.get(0), 3.0F)));
    }
  }
  
  public void updatePoints(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null) {
      addParam(new m.a("facePoints", paramArrayOfFloat));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.heigth = paramInt2;
    this.mFaceDetScale = paramDouble;
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    addParam(new m.b("faceDetectImageSize", (float)(paramInt1 * this.mFaceDetScale), (float)(paramInt2 * this.mFaceDetScale)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.FacePointsFilter
 * JD-Core Version:    0.7.0.1
 */