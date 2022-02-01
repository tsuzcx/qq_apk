package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/jsapi/JsApiOpenFinderTopicView;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageMMBaseJsApi;", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends bw<g>
{
  public static final a WJh;
  
  static
  {
    AppMethodBeat.i(296020);
    WJh = new a((byte)0);
    AppMethodBeat.o(296020);
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(296028);
    int i;
    try
    {
      paramContext = new JSONObject(paramString);
      paramContext = paramContext.getString("extInfo");
      Log.v("MicroMsg.JsApiOpenFinderTopicView", "openFinderTopic in mm process");
    }
    catch (JSONException paramContext)
    {
      label74:
      Log.e("MicroMsg.JsApiOpenFinderTopicView", s.X("paras data error: ", paramContext.getMessage()));
      parama.j("fail", null);
      AppMethodBeat.o(296028);
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("extInfo", new JSONObject(paramContext));
      ((cn)h.az(cn.class)).enterFinderTopicUI(MMApplicationContext.getContext(), paramString.toString());
      i = 1;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.JsApiOpenFinderTopicView", (Throwable)paramContext, "openFinderTopic exception", new Object[0]);
      i = 0;
      break label74;
      parama.j("fail", null);
      AppMethodBeat.o(296028);
    }
    if (i != 0)
    {
      parama.j(null, null);
      AppMethodBeat.o(296028);
      return;
    }
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openFinderTopicView";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/jsapi/JsApiOpenFinderTopicView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */