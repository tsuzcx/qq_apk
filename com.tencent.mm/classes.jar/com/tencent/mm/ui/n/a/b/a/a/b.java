package com.tencent.mm.ui.n.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends r
{
  private static final int CTRL_INDEX = -2;
  public static final String NAME = "UnityEvent";
  private final a XKx;
  
  public b(a parama)
  {
    this.XKx = parama;
  }
  
  public final void O(e parame)
  {
    AppMethodBeat.i(286065);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("event", this.XKx.hXy());
    localHashMap.put("param", null);
    i(parame).D(localHashMap).bPO();
    AppMethodBeat.o(286065);
  }
  
  public static abstract interface a
  {
    public abstract String hXy();
  }
  
  public static final class b
    implements b.a
  {
    public final String hXy()
    {
      return "clearAllVFX";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */