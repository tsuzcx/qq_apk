package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.e;
import com.tencent.luggage.e.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public class q
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<n>.a parama)
  {
    y.i("MicroMsg.JsApiGetNetworkType", "invoke");
    if (!aq.isConnected(((n)parama.big).mContext))
    {
      y.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
      parama.a("network_type:fail", null);
      return;
    }
    int i = aq.getNetType(((n)parama.big).mContext);
    y.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = " + i);
    HashMap localHashMap = new HashMap();
    if (aq.isWifi(((n)parama.big).mContext))
    {
      y.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
      parama.a("network_type:wifi", null);
      return;
    }
    if (aq.is2G(((n)parama.big).mContext))
    {
      y.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
      localHashMap.put("subtype", "2g");
    }
    for (;;)
    {
      parama.c("network_type:wwan", localHashMap);
      return;
      if (aq.is3G(((n)parama.big).mContext))
      {
        y.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
        localHashMap.put("subtype", "3g");
      }
      else if (aq.is4G(((n)parama.big).mContext))
      {
        y.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
        localHashMap.put("subtype", "4g");
      }
    }
  }
  
  public final String name()
  {
    return "getNetworkType";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.q
 * JD-Core Version:    0.7.0.1
 */