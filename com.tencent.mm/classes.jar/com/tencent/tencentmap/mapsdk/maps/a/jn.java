package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jn
  extends m
{
  public String a = "";
  public int b = 0;
  public String c = "";
  
  public jn() {}
  
  public jn(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(148716);
    this.a = paramk.a(0, true);
    this.b = paramk.a(this.b, 1, true);
    this.c = paramk.a(2, false);
    AppMethodBeat.o(148716);
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(148715);
    paraml.a(this.a, 0);
    paraml.a(this.b, 1);
    if (this.c != null) {
      paraml.a(this.c, 2);
    }
    AppMethodBeat.o(148715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jn
 * JD-Core Version:    0.7.0.1
 */