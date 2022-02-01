package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetNetWorkType;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class i
  extends a
{
  private static final int EkT = 16;
  public static final i Epv;
  private static final String TAG = "MicroMsg.JsApiGetNetWorkType";
  private static final String dKm = "getNetworkType";
  
  static
  {
    AppMethodBeat.i(207643);
    Epv = new i();
    TAG = "MicroMsg.JsApiGetNetWorkType";
    EkT = 16;
    dKm = "getNetworkType";
    AppMethodBeat.o(207643);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207642);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Context localContext = paramd.context;
    if (!ay.isConnected(localContext))
    {
      ad.i(TAG, "getNetworkType, not connected");
      paramd.Dyx.i(paraml.DNz, "network_type:fail", null);
      AppMethodBeat.o(207642);
      return true;
    }
    if (paramd.lvv != null) {}
    int i;
    for (;;)
    {
      try
      {
        Object localObject = paramd.lvv;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((e)localObject).k(110, new Bundle());
        p.g(localObject, "env.invoker!!.invokeAsRe…_SIM_CARD_TYPE, Bundle())");
        i = ((Bundle)localObject).getInt("sim_card_type", 0);
        if (i == 0)
        {
          i = 0;
          int j = ay.getNetType(localContext);
          ad.i(TAG, "getNetworkType, type = %s, simType = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          localObject = (Map)new HashMap();
          if (!ay.is2G(localContext)) {
            break;
          }
          ad.i(TAG, "getNetworkType, 2g");
          ((Map)localObject).put("subtype", "2g");
          ((Map)localObject).put("simtype", Integer.valueOf(i));
          paramd.Dyx.i(paraml.DNz, "network_type:wwan", (Map)localObject);
          AppMethodBeat.o(207642);
          return true;
        }
        if (i == 1)
        {
          i = 1;
        }
        else
        {
          i = 2;
          continue;
          i = 0;
        }
      }
      catch (Exception localException)
      {
        ad.e(TAG, "invokeAsResult ex %s", new Object[] { localException.getMessage() });
      }
    }
    if (ay.is3G(localContext))
    {
      ad.i(TAG, "getNetworkType, 3g");
      localException.put("subtype", "3g");
      localException.put("simtype", Integer.valueOf(i));
      paramd.Dyx.i(paraml.DNz, "network_type:wwan", localException);
      AppMethodBeat.o(207642);
      return true;
    }
    if (ay.is4G(localContext))
    {
      ad.i(TAG, "getNetworkType, 4g");
      localException.put("subtype", "4g");
      localException.put("simtype", Integer.valueOf(i));
      paramd.Dyx.i(paraml.DNz, "network_type:wwan", localException);
      AppMethodBeat.o(207642);
      return true;
    }
    if (ay.is5G(localContext))
    {
      ad.i(TAG, "getNetworkType, 5g");
      localException.put("subtype", "5g");
      localException.put("simtype", Integer.valueOf(i));
      paramd.Dyx.i(paraml.DNz, "network_type:wwan", localException);
      AppMethodBeat.o(207642);
      return true;
    }
    if (ay.isWifi(localContext))
    {
      ad.i(TAG, "getNetworkType, wifi");
      localException.put("simtype", Integer.valueOf(i));
      paramd.Dyx.i(paraml.DNz, "network_type:wifi", localException);
      AppMethodBeat.o(207642);
      return true;
    }
    ad.w(TAG, "getNetworkType, unknown");
    paramd.Dyx.i(paraml.DNz, "network_type:fail", null);
    AppMethodBeat.o(207642);
    return true;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.i
 * JD-Core Version:    0.7.0.1
 */