package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface HorizontalListViewV2$d
{
  public abstract void a(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(141709);
      adPg = new a("SCROLL_STATE_IDLE", 0);
      adPh = new a("SCROLL_STATE_TOUCH_SCROLL", 1);
      adPi = new a("SCROLL_STATE_FLING", 2);
      adPj = new a[] { adPg, adPh, adPi };
      AppMethodBeat.o(141709);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.d
 * JD-Core Version:    0.7.0.1
 */