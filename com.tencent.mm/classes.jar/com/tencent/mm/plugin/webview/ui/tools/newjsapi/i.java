package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetNetWorkType;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class i
  extends a
{
  private static final int ECX = 16;
  public static final i EHD;
  private static final String TAG = "MicroMsg.JsApiGetNetWorkType";
  private static final String dLB = "getNetworkType";
  
  static
  {
    AppMethodBeat.i(199402);
    EHD = new i();
    TAG = "MicroMsg.JsApiGetNetWorkType";
    ECX = 16;
    dLB = "getNetworkType";
    AppMethodBeat.o(199402);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199401);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Context localContext = paramd.context;
    if (!az.isConnected(localContext))
    {
      ae.i(TAG, "getNetworkType, not connected");
      paramd.DQe.i(paraml.Efy, "network_type:fail", null);
      AppMethodBeat.o(199401);
      return true;
    }
    if (paramd.lzT != null) {}
    int i;
    for (;;)
    {
      try
      {
        Object localObject = paramd.lzT;
        if (localObject == null) {
          p.gkB();
        }
        localObject = ((e)localObject).k(110, new Bundle());
        p.g(localObject, "env.invoker!!.invokeAsRe…_SIM_CARD_TYPE, Bundle())");
        i = ((Bundle)localObject).getInt("sim_card_type", 0);
        if (i == 0)
        {
          i = 0;
          int j = az.getNetType(localContext);
          ae.i(TAG, "getNetworkType, type = %s, simType = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          localObject = (Map)new HashMap();
          if (!az.is2G(localContext)) {
            break;
          }
          ae.i(TAG, "getNetworkType, 2g");
          ((Map)localObject).put("subtype", "2g");
          ((Map)localObject).put("simtype", Integer.valueOf(i));
          paramd.DQe.i(paraml.Efy, "network_type:wwan", (Map)localObject);
          AppMethodBeat.o(199401);
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
        ae.e(TAG, "invokeAsResult ex %s", new Object[] { localException.getMessage() });
      }
    }
    if (az.is3G(localContext))
    {
      ae.i(TAG, "getNetworkType, 3g");
      localException.put("subtype", "3g");
      localException.put("simtype", Integer.valueOf(i));
      paramd.DQe.i(paraml.Efy, "network_type:wwan", localException);
      AppMethodBeat.o(199401);
      return true;
    }
    if (az.is4G(localContext))
    {
      ae.i(TAG, "getNetworkType, 4g");
      localException.put("subtype", "4g");
      localException.put("simtype", Integer.valueOf(i));
      paramd.DQe.i(paraml.Efy, "network_type:wwan", localException);
      AppMethodBeat.o(199401);
      return true;
    }
    if (az.is5G(localContext))
    {
      ae.i(TAG, "getNetworkType, 5g");
      localException.put("subtype", "5g");
      localException.put("simtype", Integer.valueOf(i));
      paramd.DQe.i(paraml.Efy, "network_type:wwan", localException);
      AppMethodBeat.o(199401);
      return true;
    }
    if (az.isWifi(localContext))
    {
      ae.i(TAG, "getNetworkType, wifi");
      localException.put("simtype", Integer.valueOf(i));
      paramd.DQe.i(paraml.Efy, "network_type:wifi", localException);
      AppMethodBeat.o(199401);
      return true;
    }
    ae.w(TAG, "getNetworkType, unknown");
    paramd.DQe.i(paraml.Efy, "network_type:fail", null);
    AppMethodBeat.o(199401);
    return true;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.i
 * JD-Core Version:    0.7.0.1
 */