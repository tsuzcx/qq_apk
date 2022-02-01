package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$e
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(95057);
    wzs = new e("Samll", 0, 1);
    wzt = new e("Full", 1, 2);
    wzu = new e("Complete", 2, 3);
    wzv = new e[] { wzs, wzt, wzu };
    AppMethodBeat.o(95057);
  }
  
  private m$e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.m.e
 * JD-Core Version:    0.7.0.1
 */