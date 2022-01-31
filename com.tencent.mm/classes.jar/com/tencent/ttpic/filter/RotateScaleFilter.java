package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RotateScaleFilter
  extends VideoFilterBase
{
  public RotateScaleFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.ROTATE_SCALE);
    initParams();
  }
  
  public void initParams()
  {
    updateParams(1.0F, 0.0F, 1.0F, new PointF(), new PointF(), new PointF(1.0F, 1.0F));
  }
  
  public void updateParams(float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    addParam(new m.f("texScale", paramFloat1));
    addParam(new m.f("texRotate", paramFloat2));
    addParam(new m.b("translate", paramPointF2.x, paramPointF2.y));
    addParam(new m.b("anchor", paramPointF1.x, paramPointF1.y));
    addParam(new m.f("alpha", paramFloat3));
    addParam(new m.b("canvasSize", paramPointF3.x, paramPointF3.y));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.RotateScaleFilter
 * JD-Core Version:    0.7.0.1
 */