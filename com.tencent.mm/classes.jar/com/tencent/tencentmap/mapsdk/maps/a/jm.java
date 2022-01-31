package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class jm
  extends m
{
  static ArrayList<jn> g;
  public ArrayList<jn> a = null;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  static
  {
    AppMethodBeat.i(148714);
    g = new ArrayList();
    jn localjn = new jn();
    g.add(localjn);
    AppMethodBeat.o(148714);
  }
  
  public jm() {}
  
  public jm(ArrayList<jn> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramArrayList;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(148713);
    this.a = ((ArrayList)paramk.a(g, 0, true));
    this.b = paramk.a(1, false);
    this.c = paramk.a(2, false);
    this.d = paramk.a(3, false);
    this.e = paramk.a(4, false);
    this.f = paramk.a(5, false);
    AppMethodBeat.o(148713);
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(148712);
    paraml.a(this.a, 0);
    if (this.b != null) {
      paraml.a(this.b, 1);
    }
    if (this.c != null) {
      paraml.a(this.c, 2);
    }
    if (this.d != null) {
      paraml.a(this.d, 3);
    }
    if (this.e != null) {
      paraml.a(this.e, 4);
    }
    if (this.f != null) {
      paraml.a(this.f, 5);
    }
    AppMethodBeat.o(148712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jm
 * JD-Core Version:    0.7.0.1
 */