package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.a.c.1;
import com.tencent.mm.plugin.webview.luggage.j;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class p
  extends bs
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(78548);
    JSONObject localJSONObject = parama.ctb.csi;
    String str = localJSONObject.optString("eventName");
    localJSONObject = localJSONObject.optJSONObject("data");
    Iterator localIterator = j.gbV().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).ctS.a(new c.1(str, localJSONObject));
    }
    parama.c("", null);
    AppMethodBeat.o(78548);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "dispatchEvent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.p
 * JD-Core Version:    0.7.0.1
 */