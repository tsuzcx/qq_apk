package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jo
  extends m
{
  public String a = "";
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public String e = "";
  public String f = "";
  public int g = 0;
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(148718);
    this.a = paramk.a(0, true);
    this.b = paramk.a(this.b, 1, true);
    this.c = paramk.a(this.c, 2, true);
    this.d = paramk.a(this.d, 3, false);
    this.e = paramk.a(4, false);
    this.f = paramk.a(5, false);
    this.g = paramk.a(this.g, 6, false);
    AppMethodBeat.o(148718);
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(148717);
    paraml.a(this.a, 0);
    paraml.a(this.b, 1);
    paraml.a(this.c, 2);
    paraml.a(this.d, 3);
    if (this.e != null) {
      paraml.a(this.e, 4);
    }
    if (this.f != null) {
      paraml.a(this.f, 5);
    }
    paraml.a(this.g, 6);
    AppMethodBeat.o(148717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jo
 * JD-Core Version:    0.7.0.1
 */