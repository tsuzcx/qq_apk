package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.SlimWaistFilter;
import java.util.List;

public class PTFilter$PTSlimWaistFilter
  extends PTFilter
{
  private boolean enable;
  private SlimWaistFilter mSlimWaistFilter;
  private h mSlimWaistFrame;
  private float strength;
  
  public PTFilter$PTSlimWaistFilter()
  {
    AppMethodBeat.i(80664);
    this.mSlimWaistFilter = new SlimWaistFilter();
    this.mSlimWaistFrame = new h();
    this.enable = true;
    this.strength = 0.0F;
    AppMethodBeat.o(80664);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(80670);
    this.mSlimWaistFilter.clearGLSLSelf();
    this.mSlimWaistFrame.clear();
    super.destroy();
    AppMethodBeat.o(80670);
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    AppMethodBeat.i(80665);
    int i = super.init();
    this.mSlimWaistFilter.ApplyGLSLFilter();
    AppMethodBeat.o(80665);
    return i;
  }
  
  public h process(h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80666);
    this.mSlimWaistFilter.RenderProcess(paramh.texture[0], paramInt1, paramInt2, -1, 0.0D, this.mSlimWaistFrame);
    paramh = this.mSlimWaistFrame;
    AppMethodBeat.o(80666);
    return paramh;
  }
  
  public void setStatusReset()
  {
    AppMethodBeat.i(80667);
    this.mSlimWaistFilter.setStatusReset();
    AppMethodBeat.o(80667);
  }
  
  public void setStrength(float paramFloat)
  {
    AppMethodBeat.i(80669);
    this.mSlimWaistFilter.setStrength(paramFloat);
    this.strength = paramFloat;
    AppMethodBeat.o(80669);
  }
  
  public boolean setWaistRectangle(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80668);
    boolean bool = this.mSlimWaistFilter.setWaistRectangle(paramList, paramInt1, paramInt2);
    AppMethodBeat.o(80668);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTSlimWaistFilter
 * JD-Core Version:    0.7.0.1
 */