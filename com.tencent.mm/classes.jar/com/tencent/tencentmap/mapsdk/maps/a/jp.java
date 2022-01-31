package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class jp
  extends m
{
  static ArrayList<jo> c;
  public int a = 0;
  public ArrayList<jo> b = null;
  
  static
  {
    AppMethodBeat.i(148721);
    c = new ArrayList();
    jo localjo = new jo();
    c.add(localjo);
    AppMethodBeat.o(148721);
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(148720);
    this.a = paramk.a(this.a, 0, true);
    this.b = ((ArrayList)paramk.a(c, 1, false));
    AppMethodBeat.o(148720);
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(148719);
    paraml.a(this.a, 0);
    if (this.b != null) {
      paraml.a(this.b, 1);
    }
    AppMethodBeat.o(148719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jp
 * JD-Core Version:    0.7.0.1
 */