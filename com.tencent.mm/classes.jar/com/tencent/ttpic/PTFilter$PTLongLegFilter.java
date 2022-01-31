package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.LongLegFilter;
import java.util.List;

public class PTFilter$PTLongLegFilter
  extends PTFilter
{
  private boolean enable;
  private LongLegFilter mLongLegFilter;
  private h mLongLegFrame;
  private float strength;
  
  public PTFilter$PTLongLegFilter()
  {
    AppMethodBeat.i(80656);
    this.mLongLegFilter = new LongLegFilter();
    this.mLongLegFrame = new h();
    this.enable = true;
    this.strength = 0.0F;
    AppMethodBeat.o(80656);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(80661);
    this.mLongLegFilter.clearGLSLSelf();
    this.mLongLegFrame.clear();
    super.destroy();
    AppMethodBeat.o(80661);
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    AppMethodBeat.i(80657);
    int i = super.init();
    this.mLongLegFilter.ApplyGLSLFilter();
    AppMethodBeat.o(80657);
    return i;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public h process(h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80658);
    if (this.enable)
    {
      this.mLongLegFilter.RenderProcess(paramh.texture[0], paramInt1, paramInt2, -1, 0.0D, this.mLongLegFrame);
      paramh = this.mLongLegFrame;
      AppMethodBeat.o(80658);
      return paramh;
    }
    AppMethodBeat.o(80658);
    return paramh;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setStrength(float paramFloat)
  {
    AppMethodBeat.i(80660);
    this.mLongLegFilter.setStrength(paramFloat);
    this.strength = paramFloat;
    AppMethodBeat.o(80660);
  }
  
  public void setWaistLine(List<PointF> paramList, int paramInt)
  {
    AppMethodBeat.i(80659);
    this.mLongLegFilter.setWaistLine(paramList, paramInt);
    AppMethodBeat.o(80659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTLongLegFilter
 * JD-Core Version:    0.7.0.1
 */