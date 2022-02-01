package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashMap;
import java.util.Map;

public class w
  extends bq<s>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<s>.a paramb)
  {
    AppMethodBeat.i(78558);
    ad.i("MicroMsg.JsApiGetNetworkType", "invoke");
    if (!ay.isConnected(((s)paramb.chg).mContext))
    {
      ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
      paramb.a("network_type:fail", null);
      AppMethodBeat.o(78558);
      return;
    }
    ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = ".concat(String.valueOf(ay.getNetType(((s)paramb.chg).mContext))));
    HashMap localHashMap = new HashMap();
    localHashMap.put("simtype", (IPCInteger)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, a.class));
    if (ay.isWifi(((s)paramb.chg).mContext))
    {
      ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
      paramb.d("network_type:wifi", localHashMap);
      AppMethodBeat.o(78558);
      return;
    }
    if (ay.is2G(((s)paramb.chg).mContext))
    {
      ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
      localHashMap.put("subtype", "2g");
    }
    for (;;)
    {
      paramb.d("network_type:wwan", localHashMap);
      AppMethodBeat.o(78558);
      return;
      if (ay.is3G(((s)paramb.chg).mContext))
      {
        ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
        localHashMap.put("subtype", "3g");
      }
      else if (ay.is4G(((s)paramb.chg).mContext))
      {
        ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
        localHashMap.put("subtype", "4g");
      }
      else if (ay.is5G(((s)paramb.chg).mContext))
      {
        ad.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 5g");
        localHashMap.put("subtype", "5g");
      }
    }
  }
  
  public final int ccO()
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
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.w
 * JD-Core Version:    0.7.0.1
 */