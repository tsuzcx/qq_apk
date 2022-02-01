package com.tencent.mm.plugin.websearch.webview;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "T", "", "()V", "TAG", "", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "getCurrentLocation", "", "params", "getNetTypeAndSimCard", "getNetworkType", "getReportType", "", "getSearchDisplayNameList", "log", "onSearchWebQueryReady", "retCode", "errMsg", "json", "requestId", "openFinderFeed", "openFinderProfile", "querySearchWeb", "reportSearchRealTimeStatistics", "reportSearchStatistics", "returnFail", "Lorg/json/JSONObject;", "returnSuccess", "Companion", "ui-websearch_release"})
public class b<T>
{
  public static final a IHf;
  public d<T> IHe;
  private final String TAG = "MicroMsg.WebSearch.BaseWebSearchJSApi";
  
  static
  {
    AppMethodBeat.i(198057);
    IHf = new a((byte)0);
    AppMethodBeat.o(198057);
  }
  
  public static JSONObject fYQ()
  {
    AppMethodBeat.i(198055);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", 0);
      label21:
      AppMethodBeat.o(198055);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public static JSONObject fYR()
  {
    AppMethodBeat.i(198056);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", -1);
      label21:
      AppMethodBeat.o(198056);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public int ddN()
  {
    return 1;
  }
  
  @JavascriptInterface
  public void getCurrentLocation(String paramString)
  {
    AppMethodBeat.i(198051);
    paramString = ai.clJ();
    Object localObject;
    if (paramString != null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("latitude", Float.valueOf(paramString.LbD));
      ((JSONObject)localObject).put("longitude", Float.valueOf(paramString.LbC));
      ((JSONObject)localObject).put("precision", paramString.LuT);
      ((JSONObject)localObject).put("macAddr", Float.valueOf(paramString.LbD));
      ((JSONObject)localObject).put("cellId", Float.valueOf(paramString.LbD));
      ((JSONObject)localObject).put("gpsSource", Float.valueOf(paramString.LbD));
      ((JSONObject)localObject).put("address", Float.valueOf(paramString.LbD));
      paramString = new JSONObject();
      paramString.put("json", ((JSONObject)localObject).toString());
      localObject = this.IHe;
      if (localObject == null) {
        break label234;
      }
      localObject = ((d)localObject).dQg();
      if (localObject == null) {
        break label234;
      }
      i locali = i.IHk;
      paramString = paramString.toString();
      p.g(paramString, "returnObj.toString()");
      i.a((WebSearchWebView)localObject, "onCurrentLocationReady", paramString);
    }
    label234:
    for (paramString = x.SXb;; paramString = null)
    {
      if (paramString == null)
      {
        paramString = ((b)this).IHe;
        if (paramString != null)
        {
          paramString = paramString.dQg();
          if (paramString != null)
          {
            localObject = i.IHk;
            i.a(paramString, "onCurrentLocationReady", String.valueOf(fYR()));
            paramString = x.SXb;
          }
        }
      }
      AppMethodBeat.o(198051);
      return;
    }
  }
  
  @JavascriptInterface
  public String getNetworkType(String paramString)
  {
    AppMethodBeat.i(198047);
    Log.i(this.TAG, "getNetworkType %s", new Object[] { paramString });
    try
    {
      localJSONObject = fYQ();
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        break label76;
      }
      paramString = "wifi";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label76:
        paramString = String.valueOf(fYR());
        continue;
        localJSONObject.put("err_msg", "network_type:wwan");
        continue;
        paramString = "";
      }
    }
    localJSONObject.put("subtype", paramString);
    if (p.j(paramString, "wifi")) {
      localJSONObject.put("err_msg", "network_type:wifi");
    }
    for (;;)
    {
      paramString = localJSONObject.toString();
      AppMethodBeat.o(198047);
      return paramString;
      if (ai.isFreeSimCard())
      {
        paramString = "wangka";
        break;
      }
      if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
      {
        paramString = "4g";
        break;
      }
      if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
      {
        paramString = "3g";
        break;
      }
      if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
      {
        paramString = "2g";
        break;
      }
      if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
        break label192;
      }
      paramString = "fail";
      break;
      if (!p.j(paramString, "fail")) {
        break label180;
      }
      localJSONObject.put("err_msg", "network_type:fail");
    }
  }
  
  @JavascriptInterface
  public String getSearchDisplayNameList(String paramString)
  {
    AppMethodBeat.i(198052);
    for (;;)
    {
      try
      {
        JSONArray localJSONArray2 = new JSONArray(new JSONObject(paramString).optString("data"));
        localJSONArray1 = new JSONArray();
        int j = localJSONArray2.length();
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject1 = localJSONArray2.getJSONObject(i);
        if (!((JSONObject)localObject1).has("id")) {
          continue;
        }
        paramString = ((JSONObject)localObject1).getString("id");
      }
      catch (Exception paramString)
      {
        JSONArray localJSONArray1;
        int i;
        String str;
        Object localObject2;
        JSONObject localJSONObject;
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "getSearchDisplayNameList", new Object[0]);
        paramString = String.valueOf(fYR());
        continue;
        paramString = "";
        continue;
        Object localObject1 = "";
        continue;
      }
      if (!((JSONObject)localObject1).has("userName")) {
        continue;
      }
      localObject1 = ((JSONObject)localObject1).getString("userName");
      str = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localObject1);
      localObject2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).aSN().Kn((String)localObject1);
      localJSONObject = new JSONObject();
      localJSONObject.put("id", paramString);
      localJSONObject.put("userName", localObject1);
      localJSONObject.put("displayName", str);
      p.g(localObject2, "contact");
      localJSONObject.put("displaySex", ((as)localObject2).ajE());
      localJSONArray1.put(localJSONObject);
      i += 1;
    }
    paramString = new JSONObject();
    paramString.put("ret", 0);
    paramString.put("data", localJSONArray1.toString());
    paramString = paramString.toString();
    AppMethodBeat.o(198052);
    return paramString;
  }
  
  public final void h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(198054);
    p.h(paramString1, "errMsg");
    p.h(paramString2, "json");
    p.h(paramString3, "requestId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramInt);
      localJSONObject.put("errMsg", paramString1);
      localJSONObject.put("json", paramString2);
      localJSONObject.put("requestId", paramString3);
      label76:
      paramString1 = this.IHe;
      if (paramString1 != null)
      {
        paramString1 = paramString1.dQg();
        if (paramString1 != null)
        {
          paramString2 = i.IHk;
          paramString2 = localJSONObject.toString();
          p.g(paramString2, "requestObj.toString()");
          i.a(paramString1, "onSearchWebQueryReady", paramString2);
          AppMethodBeat.o(198054);
          return;
        }
      }
      AppMethodBeat.o(198054);
      return;
    }
    catch (Exception paramString1)
    {
      break label76;
    }
  }
  
  @JavascriptInterface
  public String log(String paramString)
  {
    AppMethodBeat.i(198050);
    Log.i(this.TAG, "log: %s", new Object[] { paramString });
    paramString = String.valueOf(fYQ());
    AppMethodBeat.o(198050);
    return paramString;
  }
  
  @JavascriptInterface
  public String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(198048);
    try
    {
      Log.i(this.TAG, "openFinderFeed %s", new Object[] { paramString });
      Object localObject = new JSONObject(paramString);
      paramString = new JSONObject();
      paramString.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
      paramString.put("extInfo", new JSONObject(((JSONObject)localObject).optString("extInfo", "")));
      localObject = new Intent();
      ((aj)g.ah(aj.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((aj)g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramString.toString(), (Intent)localObject);
      paramString = String.valueOf(fYQ());
      AppMethodBeat.o(198048);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openFinderFeed", new Object[0]);
        paramString = String.valueOf(fYR());
      }
    }
  }
  
  @JavascriptInterface
  public String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(198049);
    try
    {
      Log.i(this.TAG, "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString).optString("userName", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", paramString);
      localIntent.putExtra("key_from_profile_share_scene", 15);
      localIntent.putExtra("key_enter_profile_type", 1);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(7, 2, 32, localIntent);
      ((aj)g.ah(aj.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
      paramString = String.valueOf(fYQ());
      AppMethodBeat.o(198049);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openFinderProfile", new Object[0]);
        paramString = String.valueOf(fYR());
      }
    }
  }
  
  @JavascriptInterface
  public String querySearchWeb(String paramString)
  {
    AppMethodBeat.i(198053);
    Log.i(this.TAG, "querySearchWeb ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      Object localObject = this.IHe;
      if (localObject != null)
      {
        localObject = ((d)localObject).dQk();
        if (localObject != null)
        {
          p.h(paramString, "paramsStr");
          paramString = new JSONObject(paramString);
          paramString = new w(paramString.optString("requestId", ""), paramString.optString("commReq", ""), ((a)localObject).fXz());
          g.azz().b((q)paramString);
        }
      }
      paramString = String.valueOf(fYQ());
      AppMethodBeat.o(198053);
      return paramString;
    }
    paramString = String.valueOf(fYR());
    AppMethodBeat.o(198053);
    return paramString;
  }
  
  @JavascriptInterface
  public final String reportSearchRealTimeStatistics(String paramString)
  {
    AppMethodBeat.i(198046);
    Log.i(this.TAG, "reportSearchRealTimeStatistics %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localdoc = new doc();
        localdoc.MRe = paramString.optString("logString", "");
        if (ddN() != 1) {
          continue;
        }
        paramString = new ad(localdoc);
        g.azz().b((q)paramString);
        paramString = String.valueOf(fYQ());
      }
      catch (Exception paramString)
      {
        doc localdoc;
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "reportSearchRealTimeStatistics", new Object[0]);
        paramString = String.valueOf(fYR());
        continue;
      }
      AppMethodBeat.o(198046);
      return paramString;
      paramString = new y(localdoc);
      g.azz().b((q)paramString);
    }
  }
  
  @JavascriptInterface
  public String reportSearchStatistics(String paramString)
  {
    AppMethodBeat.i(198045);
    Log.i(this.TAG, "reportSearchStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logId", 0);
      paramString = paramString.optString("logString", "");
      e.Cxv.kvStat(i, paramString);
      paramString = String.valueOf(fYQ());
      AppMethodBeat.o(198045);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "reportSearchStatistics", new Object[0]);
        paramString = String.valueOf(fYR());
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi$Companion;", "", "()V", "REPORT_TYPE_TOPSTORY", "", "REPORT_TYPE_WEBSEARCH", "ui-websearch_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.b
 * JD-Core Version:    0.7.0.1
 */