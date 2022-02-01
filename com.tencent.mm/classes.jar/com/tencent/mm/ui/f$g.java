package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f$g
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(249349);
      adwi = new a("SUCCESS", 0);
      adwj = new a("FAIL", 1);
      adwk = new a("CANCEL", 2);
      adwl = new a[] { adwi, adwj, adwk };
      AppMethodBeat.o(249349);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.g
 * JD-Core Version:    0.7.0.1
 */