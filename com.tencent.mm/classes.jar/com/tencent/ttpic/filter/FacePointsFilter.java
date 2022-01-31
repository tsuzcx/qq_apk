package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.a;
import com.tencent.filter.m.b;
import com.tencent.filter.m.e;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FacePointsFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER;
  
  static
  {
    AppMethodBeat.i(82442);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "DrawPoints.glsl");
    AppMethodBeat.o(82442);
  }
  
  public FacePointsFilter()
  {
    super(FRAGMENT_SHADER);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82439);
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.b("faceDetectImageSize", 0.0F, 0.0F));
    addParam(new m.a("facePoints", new float[0]));
    addParam(new m.e("pointColor", 1.0F, 0.0F, 0.0F, 1.0F));
    addParam(new m.f("pointSize", 3.0F));
    super.ApplyGLSLFilter();
    AppMethodBeat.o(82439);
  }
  
  public void updateMultiPoints(List<List<PointF>> paramList)
  {
    AppMethodBeat.i(82441);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(82441);
      return;
    }
    updatePoints(VideoMaterialUtil.toFlatArray((List)paramList.get(0)));
    AppMethodBeat.o(82441);
  }
  
  public void updatePointColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(82437);
    addParam(new m.e("pointColor", paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    AppMethodBeat.o(82437);
  }
  
  public void updatePointSize(float paramFloat)
  {
    AppMethodBeat.i(82438);
    addParam(new m.f("pointSize", paramFloat));
    AppMethodBeat.o(82438);
  }
  
  public void updatePoints(List<PointF> paramList)
  {
    AppMethodBeat.i(82440);
    updatePoints(VideoMaterialUtil.toFlatArray(paramList));
    AppMethodBeat.o(82440);
  }
  
  public void updatePoints(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82436);
    if (paramArrayOfFloat != null) {
      addParam(new m.a("facePoints", paramArrayOfFloat));
    }
    AppMethodBeat.o(82436);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82435);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    addParam(new m.b("faceDetectImageSize", (float)(paramInt1 * paramDouble), (float)(paramInt2 * paramDouble)));
    AppMethodBeat.o(82435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.FacePointsFilter
 * JD-Core Version:    0.7.0.1
 */