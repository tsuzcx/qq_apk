package com.tencent.mm.ui.l.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.Map;

public enum d
{
  static
  {
    AppMethodBeat.i(234435);
    Qmi = new d("INSTANCE");
    Qmj = new d[] { Qmi };
    AppMethodBeat.o(234435);
  }
  
  private d() {}
  
  public static void a(Map<String, p> paramMap, p paramp)
  {
    AppMethodBeat.i(234434);
    paramMap.put(paramp.getName(), paramp);
    AppMethodBeat.o(234434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.b.d
 * JD-Core Version:    0.7.0.1
 */