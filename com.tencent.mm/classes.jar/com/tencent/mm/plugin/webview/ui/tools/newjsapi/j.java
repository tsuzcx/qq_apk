package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetNetWorkType;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class j
  extends a
{
  private static final int CDJ = 16;
  public static final j Jxl;
  private static final String TAG = "MicroMsg.JsApiGetNetWorkType";
  private static final String edq = "getNetworkType";
  
  static
  {
    AppMethodBeat.i(210597);
    Jxl = new j();
    TAG = "MicroMsg.JsApiGetNetWorkType";
    CDJ = 16;
    edq = "getNetworkType";
    AppMethodBeat.o(210597);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210596);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Context localContext = paramf.context;
    if (!NetStatusUtil.isConnected(localContext))
    {
      Log.i(TAG, "getNetworkType, not connected");
      paramf.IQZ.h(paramn.ISe, "network_type:fail", null);
      AppMethodBeat.o(210596);
      return true;
    }
    if (paramf.mHh != null) {}
    int i;
    for (;;)
    {
      try
      {
        Object localObject = paramf.mHh;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((e)localObject).j(110, new Bundle());
        p.g(localObject, "env.invoker!!.invokeAsRe…_SIM_CARD_TYPE, Bundle())");
        i = ((Bundle)localObject).getInt("sim_card_type", 0);
        if (i == 0)
        {
          i = 0;
          int j = NetStatusUtil.getNetType(localContext);
          Log.i(TAG, "getNetworkType, type = %s, simType = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          localObject = (Map)new HashMap();
          if (!NetStatusUtil.is2G(localContext)) {
            break;
          }
          Log.i(TAG, "getNetworkType, 2g");
          ((Map)localObject).put("subtype", "2g");
          ((Map)localObject).put("simtype", Integer.valueOf(i));
          paramf.IQZ.h(paramn.ISe, "network_type:wwan", (Map)localObject);
          AppMethodBeat.o(210596);
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
        Log.e(TAG, "invokeAsResult ex %s", new Object[] { localException.getMessage() });
      }
    }
    if (NetStatusUtil.is3G(localContext))
    {
      Log.i(TAG, "getNetworkType, 3g");
      localException.put("subtype", "3g");
      localException.put("simtype", Integer.valueOf(i));
      paramf.IQZ.h(paramn.ISe, "network_type:wwan", localException);
      AppMethodBeat.o(210596);
      return true;
    }
    if (NetStatusUtil.is4G(localContext))
    {
      Log.i(TAG, "getNetworkType, 4g");
      localException.put("subtype", "4g");
      localException.put("simtype", Integer.valueOf(i));
      paramf.IQZ.h(paramn.ISe, "network_type:wwan", localException);
      AppMethodBeat.o(210596);
      return true;
    }
    if (NetStatusUtil.is5G(localContext))
    {
      Log.i(TAG, "getNetworkType, 5g");
      localException.put("subtype", "5g");
      localException.put("simtype", Integer.valueOf(i));
      paramf.IQZ.h(paramn.ISe, "network_type:wwan", localException);
      AppMethodBeat.o(210596);
      return true;
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      Log.i(TAG, "getNetworkType, wifi");
      localException.put("simtype", Integer.valueOf(i));
      paramf.IQZ.h(paramn.ISe, "network_type:wifi", localException);
      AppMethodBeat.o(210596);
      return true;
    }
    Log.w(TAG, "getNetworkType, unknown");
    paramf.IQZ.h(paramn.ISe, "network_type:fail", null);
    AppMethodBeat.o(210596);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.j
 * JD-Core Version:    0.7.0.1
 */