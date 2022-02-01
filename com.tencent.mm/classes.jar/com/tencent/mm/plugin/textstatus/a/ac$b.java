package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac$b
{
  public ac.a Tij;
  public int style = 0;
  
  public final int hGu()
  {
    if (this.style == 1) {
      return 2;
    }
    if (this.style == 2) {
      return 3;
    }
    return 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(289820);
    String str = "btnStyle{style=" + this.style + ", durationData=" + this.Tij + '}';
    AppMethodBeat.o(289820);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.ac.b
 * JD-Core Version:    0.7.0.1
 */