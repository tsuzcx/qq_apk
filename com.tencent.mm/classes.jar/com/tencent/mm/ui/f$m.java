package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f$m
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(249428);
      adwC = new a("SUCCESS", 0);
      adwD = new a("FAIL", 1);
      adwE = new a("CANCEL", 2);
      adwF = new a[] { adwC, adwD, adwE };
      AppMethodBeat.o(249428);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.m
 * JD-Core Version:    0.7.0.1
 */