package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.HashMap;
import java.util.Map;

public class v
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<n>.a parama)
  {
    AppMethodBeat.i(78558);
    ac.i("MicroMsg.JsApiGetNetworkType", "invoke");
    if (!ax.isConnected(((n)parama.bWR).mContext))
    {
      ac.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
      parama.a("network_type:fail", null);
      AppMethodBeat.o(78558);
      return;
    }
    ac.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = ".concat(String.valueOf(ax.getNetType(((n)parama.bWR).mContext))));
    HashMap localHashMap = new HashMap();
    localHashMap.put("simtype", (IPCInteger)h.a("com.tencent.mm", null, a.class));
    if (ax.isWifi(((n)parama.bWR).mContext))
    {
      ac.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
      parama.c("network_type:wifi", localHashMap);
      AppMethodBeat.o(78558);
      return;
    }
    if (ax.is2G(((n)parama.bWR).mContext))
    {
      ac.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
      localHashMap.put("subtype", "2g");
    }
    for (;;)
    {
      parama.c("network_type:wwan", localHashMap);
      AppMethodBeat.o(78558);
      return;
      if (ax.is3G(((n)parama.bWR).mContext))
      {
        ac.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
        localHashMap.put("subtype", "3g");
      }
      else if (ax.is4G(((n)parama.bWR).mContext))
      {
        ac.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
        localHashMap.put("subtype", "4g");
      }
    }
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getNetworkType";
  }
  
  static class a
    implements k<IPCVoid, IPCInteger>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.v
 * JD-Core Version:    0.7.0.1
 */