package com.tencent.mm.ui.n.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import java.util.Map;

public enum d
{
  static
  {
    AppMethodBeat.i(280298);
    XJX = new d("INSTANCE");
    XJY = new d[] { XJX };
    AppMethodBeat.o(280298);
  }
  
  private d() {}
  
  public static void a(Map<String, o> paramMap, o paramo)
  {
    AppMethodBeat.i(280297);
    paramMap.put(paramo.getName(), paramo);
    AppMethodBeat.o(280297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.d
 * JD-Core Version:    0.7.0.1
 */