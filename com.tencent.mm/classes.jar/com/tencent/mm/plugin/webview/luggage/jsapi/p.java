package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.a.d.1;
import com.tencent.mm.plugin.webview.luggage.i;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class p
  extends bo
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(78548);
    JSONObject localJSONObject = parama.bZV.bZb;
    String str = localJSONObject.optString("eventName");
    localJSONObject = localJSONObject.optJSONObject("data");
    Iterator localIterator = i.elk().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).caI.a(new d.1(str, localJSONObject));
    }
    parama.a("", null);
    AppMethodBeat.o(78548);
  }
  
  public final int bQV()
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