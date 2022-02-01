package com.tencent.mm.plugin.websearch.webview;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/MultiProcessWebSearchJSApi;", "", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;)V", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;", "setUiComponent", "webSearchMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getWebSearchMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webSearchMMKV$delegate", "Lkotlin/Lazy;", "getPermanentData", "", "params", "isAppForeground", "onAppBackground", "activity", "onAppForeground", "removePermanentData", "returnFail", "Lorg/json/JSONObject;", "returnSuccess", "savePermanentData", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
{
  public c WrO;
  private final j WrP;
  
  public g(c paramc)
  {
    AppMethodBeat.i(315230);
    this.WrO = paramc;
    this.WrP = k.cm((a)a.WrQ);
    AppMethodBeat.o(315230);
  }
  
  public static JSONObject fqu()
  {
    AppMethodBeat.i(315249);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", -1);
      label21:
      AppMethodBeat.o(315249);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  private final MultiProcessMMKV iqQ()
  {
    AppMethodBeat.i(315239);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.WrP.getValue();
    AppMethodBeat.o(315239);
    return localMultiProcessMMKV;
  }
  
  public static JSONObject iqR()
  {
    AppMethodBeat.i(315243);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", 0);
      label21:
      AppMethodBeat.o(315243);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final String biI(String paramString)
  {
    AppMethodBeat.i(315285);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("activity", paramString);
      ((JSONObject)localObject).put("timestamp", cn.bDw());
      paramString = this.WrO;
      if (paramString != null)
      {
        paramString = paramString.getWebView();
        if (paramString != null)
        {
          m localm = m.WrX;
          localObject = ((JSONObject)localObject).toString();
          s.s(localObject, "requestObj.toString()");
          m.a(paramString, "onAppForeground", (String)localObject);
        }
      }
      paramString = iqR().toString();
      s.s(paramString, "returnSuccess().toString()");
      AppMethodBeat.o(315285);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      s.s(paramString, "returnFail().toString()");
      AppMethodBeat.o(315285);
    }
    return paramString;
  }
  
  public final String biJ(String paramString)
  {
    AppMethodBeat.i(315293);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("activity", paramString);
      ((JSONObject)localObject).put("timestamp", cn.bDw());
      paramString = this.WrO;
      if (paramString != null)
      {
        paramString = paramString.getWebView();
        if (paramString != null)
        {
          m localm = m.WrX;
          localObject = ((JSONObject)localObject).toString();
          s.s(localObject, "requestObj.toString()");
          m.a(paramString, "onAppBackground", (String)localObject);
        }
      }
      paramString = iqR().toString();
      s.s(paramString, "returnSuccess().toString()");
      AppMethodBeat.o(315293);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      s.s(paramString, "returnFail().toString()");
      AppMethodBeat.o(315293);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String getPermanentData(String paramString)
  {
    AppMethodBeat.i(315266);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", s.X("getPermanentData ", paramString));
    try
    {
      localObject1 = new JSONObject(paramString).optString("key", "");
      Object localObject2 = iqQ().decodeString((String)localObject1, "");
      paramString = new JSONObject();
      paramString.put("ret", 0);
      paramString.put("key", localObject1);
      paramString.put("value", localObject2);
      localObject1 = this.WrO;
      if (localObject1 != null)
      {
        localObject1 = ((c)localObject1).getWebView();
        if (localObject1 != null)
        {
          localObject2 = m.WrX;
          paramString = paramString.toString();
          s.s(paramString, "returnObj.toString()");
          m.a((WebSearchWebView)localObject1, "onPermanentDataReady", paramString);
        }
      }
      paramString = iqR().toString();
      s.s(paramString, "returnSuccess().toString()");
      AppMethodBeat.o(315266);
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      paramString = this.WrO;
      if (paramString != null)
      {
        paramString = paramString.getWebView();
        if (paramString != null)
        {
          localObject1 = m.WrX;
          localObject1 = fqu().toString();
          s.s(localObject1, "returnFail().toString()");
          m.a(paramString, "onPermanentDataReady", (String)localObject1);
        }
      }
      paramString = fqu().toString();
      s.s(paramString, "returnFail().toString()");
      AppMethodBeat.o(315266);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String isAppForeground(String paramString)
  {
    AppMethodBeat.i(315278);
    paramString = iqR();
    if (AppForegroundDelegate.heY.eLx) {}
    for (int i = 1;; i = 0)
    {
      paramString = paramString.put("isAppForeground", i).toString();
      AppMethodBeat.o(315278);
      return paramString;
    }
  }
  
  @JavascriptInterface
  public final String removePermanentData(String paramString)
  {
    AppMethodBeat.i(315271);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", s.X("removePermanentData ", paramString));
    try
    {
      paramString = new JSONObject(paramString).optString("key", "");
      iqQ().remove(paramString);
      paramString = iqR().toString();
      AppMethodBeat.o(315271);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315271);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String savePermanentData(String paramString)
  {
    AppMethodBeat.i(315257);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("key", "");
      localObject = ((JSONObject)localObject).optString("value", "");
      boolean bool = iqQ().encode(paramString, (String)localObject);
      Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "savePermanentData key:" + paramString + " value:" + localObject + " result:" + bool);
      if (bool)
      {
        paramString = iqR().toString();
        AppMethodBeat.o(315257);
        return paramString;
      }
      paramString = fqu().toString();
      AppMethodBeat.o(315257);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315257);
    }
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final a WrQ;
    
    static
    {
      AppMethodBeat.i(315190);
      WrQ = new a();
      AppMethodBeat.o(315190);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.g
 * JD-Core Version:    0.7.0.1
 */