package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.festival.a.a.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "T", "", "()V", "TAG", "", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "getCurrentLocation", "", "params", "getFestivalLiveInfo", "getFinderLivePreviewUrl", "getNetTypeAndSimCard", "getNetworkType", "getReportType", "", "getSearchDisplayNameList", "log", "onSearchWebQueryReady", "retCode", "errMsg", "json", "requestId", "openFinderFeed", "openFinderProfile", "openMusicPage", "playMusic", "querySearchWeb", "reportSearchRealTimeStatistics", "reportSearchStatistics", "returnFail", "Lorg/json/JSONObject;", "returnSuccess", "showWeDrawHomeView", "vibrateShort", "Companion", "ui-websearch_release"})
public class b<T>
{
  public static final a PBt;
  public d<T> PBs;
  private final String TAG = "MicroMsg.WebSearch.BaseWebSearchJSApi";
  
  static
  {
    AppMethodBeat.i(198815);
    PBt = new a((byte)0);
    AppMethodBeat.o(198815);
  }
  
  public static JSONObject gRB()
  {
    AppMethodBeat.i(198808);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", 0);
      label21:
      AppMethodBeat.o(198808);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public static JSONObject gRC()
  {
    AppMethodBeat.i(198813);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", -1);
      label21:
      AppMethodBeat.o(198813);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public int duR()
  {
    return 1;
  }
  
  @JavascriptInterface
  public void getCurrentLocation(String paramString)
  {
    AppMethodBeat.i(198771);
    paramString = ai.czn();
    Object localObject;
    if (paramString != null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("latitude", Float.valueOf(paramString.ScP));
      ((JSONObject)localObject).put("longitude", Float.valueOf(paramString.ScO));
      ((JSONObject)localObject).put("precision", paramString.Sxt);
      ((JSONObject)localObject).put("macAddr", Float.valueOf(paramString.ScP));
      ((JSONObject)localObject).put("cellId", Float.valueOf(paramString.ScP));
      ((JSONObject)localObject).put("gpsSource", Float.valueOf(paramString.ScP));
      ((JSONObject)localObject).put("address", Float.valueOf(paramString.ScP));
      paramString = new JSONObject();
      paramString.put("json", ((JSONObject)localObject).toString());
      localObject = this.PBs;
      if (localObject == null) {
        break label234;
      }
      localObject = ((d)localObject).esG();
      if (localObject == null) {
        break label234;
      }
      i locali = i.PBA;
      paramString = paramString.toString();
      p.j(paramString, "returnObj.toString()");
      i.a((WebSearchWebView)localObject, "onCurrentLocationReady", paramString);
    }
    label234:
    for (paramString = x.aazN;; paramString = null)
    {
      if (paramString == null)
      {
        paramString = ((b)this).PBs;
        if (paramString != null)
        {
          paramString = paramString.esG();
          if (paramString != null)
          {
            localObject = i.PBA;
            i.a(paramString, "onCurrentLocationReady", String.valueOf(gRC()));
            paramString = x.aazN;
          }
        }
      }
      AppMethodBeat.o(198771);
      return;
    }
  }
  
  @JavascriptInterface
  public String getFestivalLiveInfo(String paramString)
  {
    AppMethodBeat.i(198782);
    for (;;)
    {
      try
      {
        new JSONObject(paramString).optInt("fromScene", 0);
        paramString = ((com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class)).dmu();
        JSONObject localJSONObject = new JSONObject();
        if (!paramString.gZ) {
          continue;
        }
        i = 1;
        localJSONObject.put("isOpen", i);
        paramString = localJSONObject.toString();
      }
      catch (Exception paramString)
      {
        int i;
        paramString = String.valueOf(gRC());
        continue;
      }
      AppMethodBeat.o(198782);
      return paramString;
      i = 0;
    }
  }
  
  @JavascriptInterface
  public void getFinderLivePreviewUrl(final String paramString)
  {
    AppMethodBeat.i(198798);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Log.i(this.TAG, "getFinderLivePreviewUrl ".concat(String.valueOf(localJSONObject)));
        localObject2 = localJSONObject.optString("encryptedId");
        String str = localJSONObject.optString("nonceId");
        paramString = localJSONObject.optString("requestId");
        int i = localJSONObject.optInt("scene");
        if (i == 0)
        {
          i = 114;
          try
          {
            ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLivePreviewUrl((String)localObject2, str, i, (kotlin.g.a.q)new b(this, paramString));
            AppMethodBeat.o(198798);
            return;
          }
          catch (Exception localException)
          {
            Log.w(this.TAG, "GetFinderLivePreviewUrl exception:" + localException.getMessage());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).putOpt("ret", Integer.valueOf(-1));
            ((JSONObject)localObject1).putOpt("url", "");
            ((JSONObject)localObject1).putOpt("requestId", paramString);
            paramString = this.PBs;
            if (paramString == null) {
              continue;
            }
          }
          paramString = paramString.esG();
          if (paramString != null)
          {
            localObject2 = i.PBA;
            localObject1 = ((JSONObject)localObject1).toString();
            p.j(localObject1, "returnObj.toString()");
            i.a(paramString, "onGetFinderLivePreviewUrl", (String)localObject1);
            AppMethodBeat.o(198798);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        Object localObject2;
        paramString = new JSONObject();
        paramString.putOpt("ret", Integer.valueOf(-1));
        paramString.putOpt("url", "");
        paramString.putOpt("requestId", "");
        Object localObject1 = this.PBs;
        if (localObject1 != null)
        {
          localObject1 = ((d)localObject1).esG();
          if (localObject1 != null)
          {
            localObject2 = i.PBA;
            paramString = paramString.toString();
            p.j(paramString, "returnObj.toString()");
            i.a((WebSearchWebView)localObject1, "onGetFinderLivePreviewUrl", paramString);
            AppMethodBeat.o(198798);
            return;
            AppMethodBeat.o(198798);
            return;
          }
        }
        AppMethodBeat.o(198798);
        return;
      }
    }
  }
  
  @JavascriptInterface
  public String getNetworkType(String paramString)
  {
    AppMethodBeat.i(198743);
    Log.i(this.TAG, "getNetworkType %s", new Object[] { paramString });
    try
    {
      localJSONObject = gRB();
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        break label84;
      }
      paramString = "wifi";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label84:
        paramString = String.valueOf(gRC());
        continue;
        localJSONObject.put("err_msg", "network_type:wwan");
        continue;
        paramString = "";
      }
    }
    localJSONObject.put("subtype", paramString);
    if (p.h(paramString, "wifi")) {
      localJSONObject.put("err_msg", "network_type:wifi");
    }
    for (;;)
    {
      paramString = localJSONObject.toString();
      AppMethodBeat.o(198743);
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
        break label210;
      }
      paramString = "fail";
      break;
      if (!p.h(paramString, "fail")) {
        break label196;
      }
      localJSONObject.put("err_msg", "network_type:fail");
    }
  }
  
  @JavascriptInterface
  public String getSearchDisplayNameList(String paramString)
  {
    AppMethodBeat.i(198776);
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
        paramString = String.valueOf(gRC());
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
      str = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ((String)localObject1);
      localObject2 = h.ae(n.class);
      p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
      localObject2 = ((n)localObject2).bbL().RG((String)localObject1);
      localJSONObject = new JSONObject();
      localJSONObject.put("id", paramString);
      localJSONObject.put("userName", localObject1);
      localJSONObject.put("displayName", str);
      p.j(localObject2, "contact");
      localJSONObject.put("displaySex", ((as)localObject2).apt());
      localJSONArray1.put(localJSONObject);
      i += 1;
    }
    paramString = new JSONObject();
    paramString.put("ret", 0);
    paramString.put("data", localJSONArray1.toString());
    paramString = paramString.toString();
    AppMethodBeat.o(198776);
    return paramString;
  }
  
  public final void h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(198806);
    p.k(paramString1, "errMsg");
    p.k(paramString2, "json");
    p.k(paramString3, "requestId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramInt);
      localJSONObject.put("errMsg", paramString1);
      localJSONObject.put("json", paramString2);
      localJSONObject.put("requestId", paramString3);
      label74:
      paramString1 = this.PBs;
      if (paramString1 != null)
      {
        paramString1 = paramString1.esG();
        if (paramString1 != null)
        {
          paramString2 = i.PBA;
          paramString2 = localJSONObject.toString();
          p.j(paramString2, "requestObj.toString()");
          i.a(paramString1, "onSearchWebQueryReady", paramString2);
          AppMethodBeat.o(198806);
          return;
        }
      }
      AppMethodBeat.o(198806);
      return;
    }
    catch (Exception paramString1)
    {
      break label74;
    }
  }
  
  @JavascriptInterface
  public String log(String paramString)
  {
    AppMethodBeat.i(198762);
    Log.i(this.TAG, "log: %s", new Object[] { paramString });
    paramString = String.valueOf(gRB());
    AppMethodBeat.o(198762);
    return paramString;
  }
  
  @JavascriptInterface
  public String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(198749);
    try
    {
      Log.i(this.TAG, "openFinderFeed %s", new Object[] { paramString });
      Object localObject = new JSONObject(paramString);
      paramString = new JSONObject();
      paramString.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
      paramString.put("extInfo", new JSONObject(((JSONObject)localObject).optString("extInfo", "")));
      localObject = new Intent();
      ((ak)h.ag(ak.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((ak)h.ag(ak.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramString.toString(), (Intent)localObject);
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198749);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openFinderFeed", new Object[0]);
        paramString = String.valueOf(gRC());
      }
    }
  }
  
  @JavascriptInterface
  public String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(198759);
    for (;;)
    {
      try
      {
        Log.i(this.TAG, "openFinderProfile %s", new Object[] { paramString });
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("userName", "");
        i = ((JSONObject)localObject).optInt("commentScene", 0);
        localObject = ((JSONObject)localObject).optString("reportExtraInfo", "");
        if (i == 0) {
          continue;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("finder_username", paramString);
        localIntent.putExtra("key_from_profile_share_scene", 15);
        localIntent.putExtra("key_enter_profile_type", 1);
        localIntent.putExtra("key_extra_info", (String)localObject);
        ((ak)h.ag(ak.class)).fillContextIdToIntent(i, 2, 32, localIntent);
        ((ak)h.ag(ak.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
        paramString = String.valueOf(gRB());
      }
      catch (Exception paramString)
      {
        int i;
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openFinderProfile", new Object[0]);
        paramString = String.valueOf(gRC());
        continue;
      }
      AppMethodBeat.o(198759);
      return paramString;
      i = 7;
    }
  }
  
  @JavascriptInterface
  public String openMusicPage(String paramString)
  {
    AppMethodBeat.i(198788);
    try
    {
      paramString = new JSONObject(paramString);
      j.a locala = j.PBI;
      j.a.d(paramString, true);
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198788);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = String.valueOf(gRC());
      }
    }
  }
  
  @JavascriptInterface
  public String playMusic(String paramString)
  {
    AppMethodBeat.i(198785);
    try
    {
      paramString = new JSONObject(paramString);
      j.a locala = j.PBI;
      j.a.d(paramString, false);
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198785);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = String.valueOf(gRC());
      }
    }
  }
  
  @JavascriptInterface
  public String querySearchWeb(String paramString)
  {
    AppMethodBeat.i(198777);
    Log.i(this.TAG, "querySearchWeb ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      Object localObject = this.PBs;
      if (localObject != null)
      {
        localObject = ((d)localObject).esK();
        if (localObject != null)
        {
          p.k(paramString, "paramsStr");
          paramString = new JSONObject(paramString);
          paramString = new w(paramString.optString("requestId", ""), paramString.optString("commReq", ""), ((a)localObject).gQm());
          h.aGY().b((com.tencent.mm.an.q)paramString);
        }
      }
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198777);
      return paramString;
    }
    paramString = String.valueOf(gRC());
    AppMethodBeat.o(198777);
    return paramString;
  }
  
  @JavascriptInterface
  public final String reportSearchRealTimeStatistics(String paramString)
  {
    AppMethodBeat.i(198739);
    Log.i(this.TAG, "reportSearchRealTimeStatistics %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localdxu = new dxu();
        localdxu.Udk = paramString.optString("logString", "");
        if (duR() != 1) {
          continue;
        }
        paramString = new ad(localdxu);
        h.aGY().b((com.tencent.mm.an.q)paramString);
        paramString = String.valueOf(gRB());
      }
      catch (Exception paramString)
      {
        dxu localdxu;
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "reportSearchRealTimeStatistics", new Object[0]);
        paramString = String.valueOf(gRC());
        continue;
      }
      AppMethodBeat.o(198739);
      return paramString;
      paramString = new y(localdxu);
      h.aGY().b((com.tencent.mm.an.q)paramString);
    }
  }
  
  @JavascriptInterface
  public String reportSearchStatistics(String paramString)
  {
    AppMethodBeat.i(198737);
    Log.i(this.TAG, "reportSearchStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logId", 0);
      paramString = paramString.optString("logString", "");
      f.Iyx.kvStat(i, paramString);
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198737);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "reportSearchStatistics", new Object[0]);
        paramString = String.valueOf(gRC());
      }
    }
  }
  
  @JavascriptInterface
  public String showWeDrawHomeView(String paramString)
  {
    AppMethodBeat.i(198780);
    Log.i(this.TAG, "showWeDrawHomeView: ".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      com.tencent.mm.plugin.festival.a.a locala = (com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class);
      Context localContext = MMApplicationContext.getContext();
      paramString.optInt("fromScene", 0);
      locala.fp(localContext);
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198780);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(gRC());
      AppMethodBeat.o(198780);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public void vibrateShort(String paramString)
  {
    AppMethodBeat.i(198778);
    j.a locala = j.PBI;
    j.a.bjd(paramString);
    AppMethodBeat.o(198778);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi$Companion;", "", "()V", "REPORT_TYPE_TOPSTORY", "", "REPORT_TYPE_WEBSEARCH", "ui-websearch_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "url", "", "errMsg", "errCode", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<String, String, Integer, x>
  {
    b(b paramb, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.b
 * JD-Core Version:    0.7.0.1
 */