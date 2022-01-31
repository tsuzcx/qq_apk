package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;

public class RotateScaleFilter
  extends VideoFilterBase
{
  public RotateScaleFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.ROTATE_SCALE);
    AppMethodBeat.i(82827);
    initParams();
    AppMethodBeat.o(82827);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82829);
    updateParams(1.0F, 0.0F, 1.0F, new PointF(), new PointF(), new PointF(1.0F, 1.0F));
    AppMethodBeat.o(82829);
  }
  
  public void updateParams(float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    AppMethodBeat.i(82828);
    addParam(new m.f("texScale", paramFloat1));
    addParam(new m.f("texRotate", paramFloat2));
    addParam(new m.b("translate", paramPointF2.x, paramPointF2.y));
    addParam(new m.b("anchor", paramPointF1.x, paramPointF1.y));
    addParam(new m.f("alpha", paramFloat3));
    addParam(new m.b("canvasSize", paramPointF3.x, paramPointF3.y));
    AppMethodBeat.o(82828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.RotateScaleFilter
 * JD-Core Version:    0.7.0.1
 */