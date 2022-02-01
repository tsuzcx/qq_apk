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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/jsapi/JsApiOpenFinderCreateAcctView;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageMMBaseJsApi;", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends bw<g>
{
  public static final a WJg;
  
  static
  {
    AppMethodBeat.i(296022);
    WJg = new a((byte)0);
    AppMethodBeat.o(296022);
  }
  
  private static final void a(bv.a parama, Integer paramInteger)
  {
    AppMethodBeat.i(296021);
    JSONObject localJSONObject = new JSONObject();
    if (paramInteger == null)
    {
      if (paramInteger != null) {
        break label83;
      }
      label21:
      if (paramInteger != null) {
        break label122;
      }
      label25:
      if (paramInteger != null) {
        break label161;
      }
    }
    for (;;)
    {
      if (parama != null) {
        parama.j(null, localJSONObject);
      }
      AppMethodBeat.o(296021);
      return;
      if (paramInteger.intValue() != 1) {
        break;
      }
      localJSONObject.put("message", "创建成功");
      localJSONObject.put("code", 100);
      localJSONObject.put("err_msg", "openFinderCreateAcctView:ok");
      continue;
      label83:
      if (paramInteger.intValue() != 2) {
        break label21;
      }
      localJSONObject.put("message", "用户取消");
      localJSONObject.put("code", 200);
      localJSONObject.put("err_msg", "openFinderCreateAcctView:cancel");
      continue;
      label122:
      if (paramInteger.intValue() != 3) {
        break label25;
      }
      localJSONObject.put("message", "参数为空");
      localJSONObject.put("code", 300);
      localJSONObject.put("err_msg", "openFinderCreateAcctView:fail");
      continue;
      label161:
      if (paramInteger.intValue() == 4)
      {
        localJSONObject.put("message", "账号已存在");
        localJSONObject.put("code", 301);
        localJSONObject.put("err_msg", "openFinderCreateAcctView:fail");
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(296030);
    Log.i("MicroMsg.JsApiOpenFinderCreateAcctView", "invokeInOwn");
    if (paramString == null)
    {
      parama.j("data is null", null);
      AppMethodBeat.o(296030);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramContext = new JSONObject();
      return;
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext.put("scene", paramString.optInt("scene"));
        paramString = paramString.optJSONObject("tipsWording");
        s.s(paramString, "data.optJSONObject(\"tipsWording\")");
        paramContext.put("tipsWording", paramString);
      }
      catch (JSONException paramContext)
      {
        parama.j("fail", null);
        AppMethodBeat.o(296030);
        return;
      }
      try
      {
        ((cn)h.az(cn.class)).createAccount(MMApplicationContext.getContext(), null, paramContext.toString(), new ao..ExternalSyntheticLambda0(parama));
        AppMethodBeat.o(296030);
        return;
      }
      catch (Exception paramContext)
      {
        parama.j("fail", null);
        AppMethodBeat.o(296030);
      }
      paramContext = paramContext;
      Log.e("MicroMsg.JsApiOpenFinderCreateAcctView", s.X("paras data error: ", paramContext.getMessage()));
      parama.j("data is null", null);
      AppMethodBeat.o(296030);
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
    return "openFinderCreateAcctView";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/jsapi/JsApiOpenFinderCreateAcctView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */