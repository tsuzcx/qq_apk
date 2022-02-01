package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetNetWorkType;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final m Xne;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297779);
    Xne = new m();
    TAG = "MicroMsg.JsApiGetNetWorkType";
    OOk = 16;
    idA = "getNetworkType";
    AppMethodBeat.o(297779);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297797);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Context localContext = paramh.context;
    if (!NetStatusUtil.isConnected(localContext))
    {
      Log.i(TAG, "getNetworkType, not connected");
      paramh.WDy.doCallback(paramp.WEH, "network_type:fail", null);
      AppMethodBeat.o(297797);
      return true;
    }
    if (paramh.sLC != null) {}
    int i;
    for (;;)
    {
      try
      {
        Object localObject = paramh.sLC;
        s.checkNotNull(localObject);
        localObject = ((com.tencent.mm.plugin.webview.stub.e)localObject).m(110, new Bundle());
        s.s(localObject, "env.invoker!!.invokeAsRe…_SIM_CARD_TYPE, Bundle())");
        i = ((Bundle)localObject).getInt("sim_card_type", 0);
        switch (i)
        {
        default: 
          i = 2;
          int j = NetStatusUtil.getNetType(localContext);
          Log.i(TAG, "getNetworkType, type = %s, simType = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          localObject = (Map)new HashMap();
          if (!NetStatusUtil.is2G(localContext)) {
            break label287;
          }
          Log.i(TAG, "getNetworkType, 2g");
          ((Map)localObject).put("subtype", "2g");
          ((Map)localObject).put("simtype", Integer.valueOf(i));
          paramh.WDy.doCallback(paramp.WEH, "network_type:wwan", (Map)localObject);
          AppMethodBeat.o(297797);
          return true;
        case 0: 
          i = 0;
          break;
        }
        i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        Log.e(TAG, "invokeAsResult ex %s", new Object[] { localException.getMessage() });
      }
    }
    label287:
    if (NetStatusUtil.is3G(localContext))
    {
      Log.i(TAG, "getNetworkType, 3g");
      localException.put("subtype", "3g");
      localException.put("simtype", Integer.valueOf(i));
      paramh.WDy.doCallback(paramp.WEH, "network_type:wwan", localException);
      AppMethodBeat.o(297797);
      return true;
    }
    if (NetStatusUtil.is4G(localContext))
    {
      Log.i(TAG, "getNetworkType, 4g");
      localException.put("subtype", "4g");
      localException.put("simtype", Integer.valueOf(i));
      paramh.WDy.doCallback(paramp.WEH, "network_type:wwan", localException);
      AppMethodBeat.o(297797);
      return true;
    }
    if (NetStatusUtil.is5G(localContext))
    {
      Log.i(TAG, "getNetworkType, 5g");
      localException.put("subtype", "5g");
      localException.put("simtype", Integer.valueOf(i));
      paramh.WDy.doCallback(paramp.WEH, "network_type:wwan", localException);
      AppMethodBeat.o(297797);
      return true;
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      Log.i(TAG, "getNetworkType, wifi");
      localException.put("simtype", Integer.valueOf(i));
      paramh.WDy.doCallback(paramp.WEH, "network_type:wifi", localException);
      AppMethodBeat.o(297797);
      return true;
    }
    Log.w(TAG, "getNetworkType, unknown");
    paramh.WDy.doCallback(paramp.WEH, "network_type:fail", null);
    AppMethodBeat.o(297797);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.m
 * JD-Core Version:    0.7.0.1
 */