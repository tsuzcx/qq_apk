package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;

public class x
  extends bv<s>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<s>.a paramb)
  {
    AppMethodBeat.i(78558);
    Log.i("MicroMsg.JsApiGetNetworkType", "invoke");
    if (!NetStatusUtil.isConnected(((s)paramb.eiY).mContext))
    {
      Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
      paramb.a("network_type:fail", null);
      AppMethodBeat.o(78558);
      return;
    }
    Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = ".concat(String.valueOf(NetStatusUtil.getNetType(((s)paramb.eiY).mContext))));
    HashMap localHashMap = new HashMap();
    localHashMap.put("simtype", (IPCInteger)j.a(MainProcessIPCService.PROCESS_NAME, null, a.class));
    if (NetStatusUtil.isWifi(((s)paramb.eiY).mContext))
    {
      Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
      paramb.d("network_type:wifi", localHashMap);
      AppMethodBeat.o(78558);
      return;
    }
    if (NetStatusUtil.is2G(((s)paramb.eiY).mContext))
    {
      Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
      localHashMap.put("subtype", "2g");
    }
    for (;;)
    {
      paramb.d("network_type:wwan", localHashMap);
      AppMethodBeat.o(78558);
      return;
      if (NetStatusUtil.is3G(((s)paramb.eiY).mContext))
      {
        Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
        localHashMap.put("subtype", "3g");
      }
      else if (NetStatusUtil.is4G(((s)paramb.eiY).mContext))
      {
        Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
        localHashMap.put("subtype", "4g");
      }
      else if (NetStatusUtil.is5G(((s)paramb.eiY).mContext))
      {
        Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 5g");
        localHashMap.put("subtype", "5g");
      }
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getNetworkType";
  }
  
  static class a
    implements m<IPCVoid, IPCInteger>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.x
 * JD-Core Version:    0.7.0.1
 */