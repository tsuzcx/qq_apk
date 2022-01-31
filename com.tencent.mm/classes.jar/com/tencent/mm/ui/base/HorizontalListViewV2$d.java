package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface HorizontalListViewV2$d
{
  public abstract void a(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(106343);
      zin = new a("SCROLL_STATE_IDLE", 0);
      zio = new a("SCROLL_STATE_TOUCH_SCROLL", 1);
      ziq = new a("SCROLL_STATE_FLING", 2);
      zir = new a[] { zin, zio, ziq };
      AppMethodBeat.o(106343);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.d
 * JD-Core Version:    0.7.0.1
 */