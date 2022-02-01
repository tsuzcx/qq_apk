package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.capability.TPCapability;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getPluginType", "handleJsApi", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "isVCodecCapabilityCanSupport", "params", "", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private final String TAG = "MicroMsg.BasePluginJsApi";
  
  public static c c(h paramh)
  {
    s.u(paramh, "env");
    if ((paramh.context instanceof com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a)) {
      return ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a)paramh.context).getWebViewPluginClientProxy();
    }
    return null;
  }
  
  public abstract String cog();
  
  public final boolean cr(Map<String, Object> paramMap)
  {
    for (;;)
    {
      try
      {
        localObject = k.Xtc;
        if (!k.iCU())
        {
          Log.w(this.TAG, "isVCodecCapabilityCanSupport  is not use thumbPlayer, return false");
          return false;
        }
        if (paramMap == null) {
          break label318;
        }
        if (!paramMap.isEmpty()) {
          break label323;
        }
      }
      catch (Exception paramMap)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramMap, "", new Object[0]);
        Log.e(this.TAG, "isVCodecCapabilityCanSupport exception:" + paramMap + "  return false");
        return false;
      }
      if (i != 0)
      {
        Log.e(this.TAG, "isVCodecCapabilityCanSupport  params is empty, return false");
        return false;
      }
      Object localObject = paramMap.get("codecId");
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
      }
      int i = Util.getInt((String)localObject, 0);
      localObject = paramMap.get("width");
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
      }
      int j = Util.getInt((String)localObject, 0);
      localObject = paramMap.get("height");
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
      }
      int k = Util.getInt((String)localObject, 0);
      paramMap = paramMap.get("frameRate");
      if (paramMap == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
      }
      int m = Util.getInt((String)paramMap, 0);
      boolean bool = TPCapability.isVCodecCapabilityCanSupport(i, j, k, 0, 0, m);
      Log.i(this.TAG, "isVCodecCapabilityCanSupport , codecId:" + i + " , width:" + j + " , height:" + k + " , frameRate:" + m + ", result:" + bool);
      return bool;
      label318:
      i = 1;
      continue;
      label323:
      i = 0;
    }
  }
  
  public final boolean d(h paramh, p paramp)
  {
    s.u(paramh, "env");
    s.u(paramp, "msg");
    JSONObject localJSONObject = paramp.WEI;
    if ((localJSONObject == null) || (!localJSONObject.has("viewId")))
    {
      Log.w(this.TAG, "no viewId in data");
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, "fail:no viewId in data"), null);
      return false;
    }
    c localc = c(paramh);
    if (localc == null)
    {
      Log.w(this.TAG, "webview has no plugin client");
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, "fail:webview has no plugin client"), null);
      return false;
    }
    int i = localJSONObject.optInt("viewId");
    paramh = new f(paramh, paramp);
    localc.a(cog(), i, (com.tencent.luggage.xweb_ext.extendplugin.a)paramh);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.a
 * JD-Core Version:    0.7.0.1
 */