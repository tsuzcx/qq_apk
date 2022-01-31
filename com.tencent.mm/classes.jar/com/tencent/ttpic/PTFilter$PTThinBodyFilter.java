package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.ThinBodyFilter;
import java.util.List;

public class PTFilter$PTThinBodyFilter
  extends PTFilter
{
  private boolean enable;
  private ThinBodyFilter mThinBodyFilter;
  private h mThinBodyFrame;
  private float strength;
  
  public PTFilter$PTThinBodyFilter()
  {
    AppMethodBeat.i(80678);
    this.mThinBodyFilter = new ThinBodyFilter();
    this.mThinBodyFrame = new h();
    this.enable = true;
    this.strength = 0.0F;
    AppMethodBeat.o(80678);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(80684);
    this.mThinBodyFilter.clearGLSLSelf();
    this.mThinBodyFrame.clear();
    super.destroy();
    AppMethodBeat.o(80684);
  }
  
  public float getStrength()
  {
    return this.strength;
  }
  
  public int init()
  {
    AppMethodBeat.i(80679);
    int i = super.init();
    this.mThinBodyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(80679);
    return i;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public h process(h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80682);
    if (this.enable)
    {
      this.mThinBodyFilter.RenderProcess(paramh.texture[0], paramInt1, paramInt2, -1, 0.0D, this.mThinBodyFrame);
      paramh = this.mThinBodyFrame;
      AppMethodBeat.o(80682);
      return paramh;
    }
    AppMethodBeat.o(80682);
    return paramh;
  }
  
  public void setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80681);
    if ((paramList != null) && (paramList.size() > 0)) {
      this.mThinBodyFilter.setupBodyPoints(paramList, paramInt1, paramInt2);
    }
    AppMethodBeat.o(80681);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80680);
    this.mThinBodyFilter.setShowMark(true);
    this.mThinBodyFilter.setEnable(paramBoolean);
    this.enable = paramBoolean;
    AppMethodBeat.o(80680);
  }
  
  public void setStrength(float paramFloat)
  {
    AppMethodBeat.i(80683);
    this.mThinBodyFilter.setStrength(paramFloat);
    this.strength = paramFloat;
    AppMethodBeat.o(80683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTThinBodyFilter
 * JD-Core Version:    0.7.0.1
 */