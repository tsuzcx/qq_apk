package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f$l
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(194150);
      VSt = new a("SUCCESS", 0);
      VSu = new a("FAIL", 1);
      VSv = new a("CANCEL", 2);
      VSw = new a[] { VSt, VSu, VSv };
      AppMethodBeat.o(194150);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.l
 * JD-Core Version:    0.7.0.1
 */