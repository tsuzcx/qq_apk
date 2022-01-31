package com.tencent.ttpic.filter;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ThinShoulderFilter$ThinShoulderParameters
{
  private RectF rect;
  
  public ThinShoulderFilter$ThinShoulderParameters(ThinShoulderFilter paramThinShoulderFilter)
  {
    AppMethodBeat.i(82988);
    this.rect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(82988);
  }
  
  public ThinShoulderFilter$ThinShoulderParameters(ThinShoulderFilter paramThinShoulderFilter, RectF paramRectF)
  {
    this.rect = paramRectF;
  }
  
  public ThinShoulderParameters copy()
  {
    AppMethodBeat.i(82990);
    ThinShoulderParameters localThinShoulderParameters = new ThinShoulderParameters(this.this$0, new RectF(this.rect));
    AppMethodBeat.o(82990);
    return localThinShoulderParameters;
  }
  
  public void reset()
  {
    AppMethodBeat.i(82989);
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(82989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ThinShoulderFilter.ThinShoulderParameters
 * JD-Core Version:    0.7.0.1
 */