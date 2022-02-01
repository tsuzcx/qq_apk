package com.tencent.mm.ui.l.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends s
{
  private static final int CTRL_INDEX = -2;
  public static final String NAME = "UnityEvent";
  private final a QmB;
  
  public b(a parama)
  {
    this.QmB = parama;
  }
  
  public final void L(f paramf)
  {
    AppMethodBeat.i(234452);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("event", this.QmB.gWV());
    localHashMap.put("param", null);
    g(paramf).K(localHashMap).bEo();
    AppMethodBeat.o(234452);
  }
  
  public static abstract interface a
  {
    public abstract String gWV();
  }
  
  public static final class b
    implements b.a
  {
    public final String gWV()
    {
      return "clearAllVFX";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */