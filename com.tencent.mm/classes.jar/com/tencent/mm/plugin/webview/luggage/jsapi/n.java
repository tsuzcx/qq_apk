package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.a.d.1;
import com.tencent.mm.plugin.webview.luggage.i;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class n
  extends bi
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(153118);
    JSONObject localJSONObject = parama.byF.bxK;
    String str = localJSONObject.optString("eventName");
    localJSONObject = localJSONObject.optJSONObject("data");
    Object localObject = i.dbp();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.luggage.d.n)((Iterator)localObject).next()).bzs.a(new d.1(str, localJSONObject));
      }
    }
    parama.a("", null);
    AppMethodBeat.o(153118);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "dispatchEvent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.n
 * JD-Core Version:    0.7.0.1
 */