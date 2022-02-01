package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.findersdk.a.cb;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.r;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "T", "Lcom/tencent/mm/plugin/websearch/webview/MultiProcessWebSearchJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "doProfile", "", "username", "", "getBaseWebSearchUIComponent", "getCurrentLocation", "params", "getCurrentUsername", "getFinderItemDetail", "getFinderLivePreviewMicCover", "getFinderLivePreviewUrl", "getNetTypeAndSimCard", "getNetworkType", "getReportType", "", "getSearchDisplayNameList", "hideVKB", "log", "onSearchWebQueryReady", "retCode", "errMsg", "json", "requestId", "openFinderFeed", "openFinderProfile", "openFinderSearchView", "openFinderTimeLineView", "openFinderView", "openMusicPage", "playMusic", "preloadFinderItem", "profile", "querySearchWeb", "reportIDKey", "reportKV", "reportSearchRealTimeStatistics", "reportSearchStatistics", "showVKB", "vibrateShort", "", "Companion", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<T>
  extends g
{
  public static final a WrL;
  
  static
  {
    AppMethodBeat.i(315291);
    WrL = new a((byte)0);
    AppMethodBeat.o(315291);
  }
  
  public b(byte paramByte)
  {
    this();
  }
  
  public b(f<T> paramf)
  {
    super((c)paramf);
    AppMethodBeat.i(315264);
    AppMethodBeat.o(315264);
  }
  
  private final f<T> iqP()
  {
    c localc = this.WrO;
    if ((localc instanceof f)) {
      return (f)localc;
    }
    return null;
  }
  
  public int edC()
  {
    return 1;
  }
  
  @JavascriptInterface
  public String getCurrentLocation(String paramString)
  {
    AppMethodBeat.i(315342);
    paramString = aj.dch();
    Object localObject;
    if (paramString != null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("latitude", Float.valueOf(paramString.ZaH));
      ((JSONObject)localObject).put("longitude", Float.valueOf(paramString.ZaG));
      ((JSONObject)localObject).put("precision", paramString.Zyl);
      ((JSONObject)localObject).put("macAddr", paramString.Zym);
      ((JSONObject)localObject).put("cellId", paramString.Zyn);
      ((JSONObject)localObject).put("gpsSource", paramString.Zyo);
      ((JSONObject)localObject).put("address", paramString.aaMz);
      paramString = new JSONObject();
      paramString.put("json", ((JSONObject)localObject).toString());
      localObject = iqP();
      if (localObject != null)
      {
        localObject = ((f)localObject).getWebView();
        if (localObject != null)
        {
          m localm = m.WrX;
          paramString = paramString.toString();
          kotlin.g.b.s.s(paramString, "returnObj.toString()");
          m.a((WebSearchWebView)localObject, "onCurrentLocationReady", paramString);
        }
      }
      paramString = iqR().toString();
      AppMethodBeat.o(315342);
      return paramString;
    }
    paramString = ((b)this).iqP();
    if (paramString != null)
    {
      paramString = paramString.getWebView();
      if (paramString != null)
      {
        localObject = m.WrX;
        localObject = fqu().toString();
        kotlin.g.b.s.s(localObject, "returnFail().toString()");
        m.a(paramString, "onCurrentLocationReady", (String)localObject);
      }
    }
    paramString = fqu().toString();
    AppMethodBeat.o(315342);
    return paramString;
  }
  
  @JavascriptInterface
  public String getCurrentUsername(String paramString)
  {
    AppMethodBeat.i(315364);
    if (com.tencent.mm.kernel.h.baz())
    {
      paramString = new JSONObject();
      paramString.put("ret", 0);
      paramString.put("username", com.tencent.mm.model.z.bAM());
      paramString = paramString.toString();
      AppMethodBeat.o(315364);
      return paramString;
    }
    paramString = fqu().put("error", "not login").toString();
    AppMethodBeat.o(315364);
    return paramString;
  }
  
  /* Error */
  @JavascriptInterface
  public String getFinderItemDetail(final String paramString)
  {
    // Byte code:
    //   0: ldc 243
    //   2: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 111	com/tencent/mm/plugin/websearch/webview/b:iqP	()Lcom/tencent/mm/plugin/websearch/webview/f;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +87 -> 98
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_1
    //   17: ifnonnull +91 -> 108
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_2
    //   23: ifnull +150 -> 173
    //   26: aload_1
    //   27: ifnull +146 -> 173
    //   30: aload_2
    //   31: instanceof 245
    //   34: ifeq +125 -> 159
    //   37: getstatic 251	com/tencent/mm/ui/component/k:aeZF	Lcom/tencent/mm/ui/component/k;
    //   40: astore_3
    //   41: aload_2
    //   42: checkcast 253	androidx/appcompat/app/AppCompatActivity
    //   45: invokestatic 257	com/tencent/mm/ui/component/k:d	(Landroidx/appcompat/app/AppCompatActivity;)Lcom/tencent/mm/ui/component/k$b;
    //   48: ldc_w 259
    //   51: invokevirtual 265	com/tencent/mm/ui/component/k$b:q	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   54: checkcast 259	com/tencent/mm/plugin/mvvmbase/a/a
    //   57: invokevirtual 269	com/tencent/mm/plugin/mvvmbase/a/a:gsu	()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;
    //   60: astore_3
    //   61: aload_3
    //   62: aconst_null
    //   63: new 10	com/tencent/mm/plugin/websearch/webview/b$b
    //   66: dup
    //   67: aload_2
    //   68: aload_1
    //   69: aload_3
    //   70: aload_0
    //   71: aconst_null
    //   72: invokespecial 272	com/tencent/mm/plugin/websearch/webview/b$b:<init>	(Landroid/content/Context;Lorg/json/JSONObject;Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Lcom/tencent/mm/plugin/websearch/webview/b;Lkotlin/d/d;)V
    //   75: checkcast 274	kotlin/g/a/m
    //   78: iconst_1
    //   79: aconst_null
    //   80: invokestatic 280	com/tencent/mm/sdk/coroutines/LifecycleScope:launchDefault$default	(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Lkotlinx/coroutines/as;Lkotlin/g/a/m;ILjava/lang/Object;)Lkotlinx/coroutines/cb;
    //   83: pop
    //   84: invokestatic 217	com/tencent/mm/plugin/websearch/webview/b:iqR	()Lorg/json/JSONObject;
    //   87: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   90: astore_1
    //   91: ldc 243
    //   93: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: aload_2
    //   99: invokeinterface 284 1 0
    //   104: astore_2
    //   105: goto -89 -> 16
    //   108: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   111: astore_3
    //   112: new 131	org/json/JSONObject
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 292	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: astore_1
    //   124: aload_1
    //   125: astore_3
    //   126: aload_1
    //   127: invokestatic 300	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   130: ifeq +5 -> 135
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_3
    //   136: checkcast 131	org/json/JSONObject
    //   139: astore_1
    //   140: goto -118 -> 22
    //   143: astore_1
    //   144: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   147: astore_3
    //   148: aload_1
    //   149: invokestatic 306	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   152: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: astore_1
    //   156: goto -32 -> 124
    //   159: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   162: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: ldc 243
    //   168: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_1
    //   172: areturn
    //   173: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   176: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   179: astore_1
    //   180: ldc 243
    //   182: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_1
    //   186: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	b
    //   0	187	1	paramString	String
    //   9	96	2	localObject1	Object
    //   40	108	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   108	124	143	finally
  }
  
  @JavascriptInterface
  public final String getFinderLivePreviewMicCover(String paramString)
  {
    AppMethodBeat.i(315378);
    try
    {
      Object localObject2 = new JSONObject(paramString);
      Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("getFinderLivePreviewMicCover ", localObject2));
      paramString = ((JSONObject)localObject2).optString("encryptedId");
      String str1;
      if (paramString == null)
      {
        paramString = "";
        str1 = ((JSONObject)localObject2).optString("nonceId");
        if (str1 != null) {
          break label124;
        }
        str1 = "";
      }
      label124:
      for (;;)
      {
        String str2 = ((JSONObject)localObject2).optString("requestId");
        ((JSONObject)localObject2).optInt("scene");
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).loadMicInfos(paramString, str1, (r)new b.c(str2, this));
        paramString = iqR().toString();
        AppMethodBeat.o(315378);
        return paramString;
        break;
      }
      Object localObject1;
      return paramString;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("getFinderLivePreviewMicCover ex:", localException.getMessage()));
      paramString = new JSONObject();
      paramString.putOpt("ret", Integer.valueOf(-1));
      paramString.putOpt("err_msg", kotlin.g.b.s.X("Invalid input parameters:", localException.getMessage()));
      paramString.putOpt("requestId", "");
      localObject1 = iqP();
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).getWebView();
        if (localObject1 != null)
        {
          localObject2 = m.WrX;
          paramString = paramString.toString();
          kotlin.g.b.s.s(paramString, "returnObj.toString()");
          m.a((WebSearchWebView)localObject1, "onGetFinderLivePreviewMicCover", paramString);
        }
      }
      paramString = iqR().toString();
      AppMethodBeat.o(315378);
    }
  }
  
  @JavascriptInterface
  public String getFinderLivePreviewUrl(String paramString)
  {
    AppMethodBeat.i(315373);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("getFinderLivePreviewUrl ", localJSONObject));
      Object localObject2 = localJSONObject.optString("encryptedId");
      String str = localJSONObject.optString("nonceId");
      paramString = localJSONObject.optString("requestId");
      int i = localJSONObject.optInt("scene");
      if (i == 0) {
        i = 114;
      }
      Object localObject1;
      for (;;)
      {
        try
        {
          ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLivePreviewUrl((String)localObject2, str, i, (kotlin.g.a.q)new d(paramString, this));
          paramString = iqR().toString();
          AppMethodBeat.o(315373);
          return paramString;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("GetFinderLivePreviewUrl exception:", localException.getMessage()));
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).putOpt("ret", Integer.valueOf(-1));
          ((JSONObject)localObject1).putOpt("url", "");
          ((JSONObject)localObject1).putOpt("requestId", paramString);
          paramString = iqP();
          if (paramString != null)
          {
            paramString = paramString.getWebView();
            if (paramString != null)
            {
              localObject2 = m.WrX;
              localObject1 = ((JSONObject)localObject1).toString();
              kotlin.g.b.s.s(localObject1, "returnObj.toString()");
              m.a(paramString, "onGetFinderLivePreviewUrl", (String)localObject1);
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString = new JSONObject();
      paramString.putOpt("ret", Integer.valueOf(-1));
      paramString.putOpt("url", "");
      paramString.putOpt("requestId", "");
      localObject1 = iqP();
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).getWebView();
        if (localObject1 != null)
        {
          localObject2 = m.WrX;
          paramString = paramString.toString();
          kotlin.g.b.s.s(paramString, "returnObj.toString()");
          m.a((WebSearchWebView)localObject1, "onGetFinderLivePreviewUrl", paramString);
        }
      }
      paramString = fqu().toString();
      AppMethodBeat.o(315373);
      return paramString;
    }
  }
  
  @JavascriptInterface
  public String getNetworkType(String paramString)
  {
    AppMethodBeat.i(315321);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "getNetworkType %s", new Object[] { paramString });
    try
    {
      localJSONObject = iqR();
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        break label87;
      }
      paramString = "wifi";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        paramString = fqu().toString();
        continue;
        localJSONObject.put("err_msg", "network_type:wwan");
        continue;
        paramString = "";
      }
    }
    kotlin.g.b.s.checkNotNull(localJSONObject);
    localJSONObject.put("subtype", paramString);
    if (kotlin.g.b.s.p(paramString, "wifi")) {
      localJSONObject.put("err_msg", "network_type:wifi");
    }
    for (;;)
    {
      paramString = localJSONObject.toString();
      AppMethodBeat.o(315321);
      return paramString;
      label87:
      if (aj.isFreeSimCard())
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
        break label213;
      }
      paramString = "fail";
      break;
      if (!kotlin.g.b.s.p(paramString, "fail")) {
        break label199;
      }
      localJSONObject.put("err_msg", "network_type:fail");
    }
  }
  
  @JavascriptInterface
  public String getSearchDisplayNameList(String paramString)
  {
    AppMethodBeat.i(315349);
    try
    {
      localJSONArray2 = new JSONArray(new JSONObject(paramString).optString("data"));
      localJSONArray1 = new JSONArray();
      k = localJSONArray2.length();
      if (k <= 0) {
        break label215;
      }
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        JSONArray localJSONArray2;
        JSONArray localJSONArray1;
        int k;
        int j;
        Object localObject;
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "getSearchDisplayNameList", new Object[0]);
        paramString = fqu().toString();
        continue;
        int i = j;
      }
    }
    j = i + 1;
    localObject = localJSONArray2.getJSONObject(i);
    if (((JSONObject)localObject).has("id"))
    {
      paramString = ((JSONObject)localObject).getString("id");
      if (!((JSONObject)localObject).has("userName")) {
        break label264;
      }
    }
    label264:
    for (localObject = ((JSONObject)localObject).getString("userName");; localObject = "")
    {
      String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localObject);
      au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramString);
      localJSONObject.put("userName", localObject);
      localJSONObject.put("displayName", str);
      localJSONObject.put("displaySex", localau.sex);
      localJSONArray1.put(localJSONObject);
      if (j < k) {
        break label300;
      }
      label215:
      paramString = new JSONObject();
      paramString.put("ret", 0);
      paramString.put("data", localJSONArray1.toString());
      paramString = paramString.toString();
      AppMethodBeat.o(315349);
      return paramString;
      paramString = "";
      break;
    }
  }
  
  public final String h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(315389);
    kotlin.g.b.s.u(paramString1, "errMsg");
    kotlin.g.b.s.u(paramString2, "json");
    kotlin.g.b.s.u(paramString3, "requestId");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retCode", paramInt);
      localJSONObject.put("errMsg", paramString1);
      localJSONObject.put("json", paramString2);
      localJSONObject.put("requestId", paramString3);
      paramString1 = iqP();
      if (paramString1 != null)
      {
        paramString1 = paramString1.getWebView();
        if (paramString1 != null)
        {
          paramString2 = m.WrX;
          paramString2 = localJSONObject.toString();
          kotlin.g.b.s.s(paramString2, "requestObj.toString()");
          m.a(paramString1, "onSearchWebQueryReady", paramString2);
        }
      }
      paramString1 = iqR().toString();
      AppMethodBeat.o(315389);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1 = fqu().toString();
      AppMethodBeat.o(315389);
    }
    return paramString1;
  }
  
  @JavascriptInterface
  public final String hideVKB(String paramString)
  {
    AppMethodBeat.i(315380);
    paramString = iqP();
    if (paramString != null) {
      paramString.hideVKB();
    }
    paramString = iqR().toString();
    kotlin.g.b.s.s(paramString, "returnSuccess().toString()");
    AppMethodBeat.o(315380);
    return paramString;
  }
  
  @JavascriptInterface
  public String log(String paramString)
  {
    AppMethodBeat.i(315341);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "log: %s", new Object[] { paramString });
    paramString = iqR().toString();
    AppMethodBeat.o(315341);
    return paramString;
  }
  
  @JavascriptInterface
  public String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(315323);
    try
    {
      Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "openFinderFeed %s", new Object[] { paramString });
      Object localObject = new JSONObject(paramString);
      paramString = new JSONObject();
      paramString.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
      paramString.put("extInfo", new JSONObject(((JSONObject)localObject).optString("extInfo", "")));
      localObject = new Intent();
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramString.toString(), (Intent)localObject);
      paramString = iqR().toString();
      AppMethodBeat.o(315323);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "openFinderFeed", new Object[0]);
        paramString = fqu().toString();
      }
    }
  }
  
  @JavascriptInterface
  public String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(315327);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "openFinderProfile %s", new Object[] { paramString });
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
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(i, 2, 32, localIntent);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
        paramString = iqR().toString();
      }
      catch (Exception paramString)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "openFinderProfile", new Object[0]);
        paramString = fqu().toString();
        continue;
      }
      AppMethodBeat.o(315327);
      return paramString;
      i = 7;
    }
  }
  
  /* Error */
  @JavascriptInterface
  public String openFinderSearchView(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 596
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 111	com/tencent/mm/plugin/websearch/webview/b:iqP	()Lcom/tencent/mm/plugin/websearch/webview/f;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +53 -> 67
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_1
    //   20: ifnonnull +57 -> 77
    //   23: aload_3
    //   24: astore_1
    //   25: aload_2
    //   26: ifnull +117 -> 143
    //   29: aload_1
    //   30: ifnull +113 -> 143
    //   33: ldc_w 598
    //   36: invokestatic 487	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   39: checkcast 598	com/tencent/mm/plugin/findersdk/a/cb
    //   42: aload_2
    //   43: aload_1
    //   44: invokeinterface 602 3 0
    //   49: ifeq +79 -> 128
    //   52: invokestatic 217	com/tencent/mm/plugin/websearch/webview/b:iqR	()Lorg/json/JSONObject;
    //   55: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: ldc_w 596
    //   62: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: areturn
    //   67: aload_2
    //   68: invokeinterface 284 1 0
    //   73: astore_2
    //   74: goto -55 -> 19
    //   77: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   80: astore_3
    //   81: new 131	org/json/JSONObject
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 292	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_1
    //   93: aload_1
    //   94: astore_3
    //   95: aload_1
    //   96: invokestatic 300	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   99: ifeq +5 -> 104
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: checkcast 131	org/json/JSONObject
    //   108: astore_1
    //   109: goto -84 -> 25
    //   112: astore_1
    //   113: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   116: astore_3
    //   117: aload_1
    //   118: invokestatic 306	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   121: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_1
    //   125: goto -32 -> 93
    //   128: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   131: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   134: astore_1
    //   135: ldc_w 596
    //   138: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: areturn
    //   143: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   146: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   149: astore_1
    //   150: ldc_w 596
    //   153: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	b
    //   0	158	1	paramString	String
    //   12	62	2	localObject1	Object
    //   1	116	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   77	93	112	finally
  }
  
  /* Error */
  @JavascriptInterface
  public String openFinderTimeLineView(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 603
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 111	com/tencent/mm/plugin/websearch/webview/b:iqP	()Lcom/tencent/mm/plugin/websearch/webview/f;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +53 -> 67
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_1
    //   20: ifnonnull +57 -> 77
    //   23: aload_3
    //   24: astore_1
    //   25: aload_2
    //   26: ifnull +117 -> 143
    //   29: aload_1
    //   30: ifnull +113 -> 143
    //   33: ldc_w 598
    //   36: invokestatic 487	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   39: checkcast 598	com/tencent/mm/plugin/findersdk/a/cb
    //   42: aload_2
    //   43: aload_1
    //   44: invokeinterface 606 3 0
    //   49: ifeq +79 -> 128
    //   52: invokestatic 217	com/tencent/mm/plugin/websearch/webview/b:iqR	()Lorg/json/JSONObject;
    //   55: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: ldc_w 603
    //   62: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: areturn
    //   67: aload_2
    //   68: invokeinterface 284 1 0
    //   73: astore_2
    //   74: goto -55 -> 19
    //   77: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   80: astore_3
    //   81: new 131	org/json/JSONObject
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 292	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_1
    //   93: aload_1
    //   94: astore_3
    //   95: aload_1
    //   96: invokestatic 300	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   99: ifeq +5 -> 104
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: checkcast 131	org/json/JSONObject
    //   108: astore_1
    //   109: goto -84 -> 25
    //   112: astore_1
    //   113: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   116: astore_3
    //   117: aload_1
    //   118: invokestatic 306	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   121: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_1
    //   125: goto -32 -> 93
    //   128: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   131: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   134: astore_1
    //   135: ldc_w 603
    //   138: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: areturn
    //   143: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   146: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   149: astore_1
    //   150: ldc_w 603
    //   153: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	b
    //   0	158	1	paramString	String
    //   12	62	2	localObject1	Object
    //   1	116	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   77	93	112	finally
  }
  
  @JavascriptInterface
  public String openFinderView(String paramString)
  {
    AppMethodBeat.i(315339);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("openFinderView params=", paramString));
    if (paramString == null)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(315339);
      return paramString;
    }
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extInfo", new JSONObject(paramString.optString("extInfo", "")));
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderUI(MMApplicationContext.getContext(), localJSONObject.toString());
      paramString = iqR().toString();
      AppMethodBeat.o(315339);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "openFinderView", new Object[0]);
        paramString = fqu().toString();
      }
    }
  }
  
  @JavascriptInterface
  public String openMusicPage(String paramString)
  {
    AppMethodBeat.i(315359);
    try
    {
      paramString = new JSONObject(paramString);
      q.a locala = q.Wsi;
      q.a.d(paramString, true);
      paramString = iqR().toString();
      AppMethodBeat.o(315359);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = fqu().toString();
      }
    }
  }
  
  @JavascriptInterface
  public String playMusic(String paramString)
  {
    AppMethodBeat.i(315357);
    try
    {
      paramString = new JSONObject(paramString);
      q.a locala = q.Wsi;
      q.a.d(paramString, false);
      paramString = iqR().toString();
      AppMethodBeat.o(315357);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = fqu().toString();
      }
    }
  }
  
  /* Error */
  @JavascriptInterface
  public String preloadFinderItem(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 628
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 111	com/tencent/mm/plugin/websearch/webview/b:iqP	()Lcom/tencent/mm/plugin/websearch/webview/f;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +53 -> 67
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_1
    //   20: ifnonnull +57 -> 77
    //   23: aload_3
    //   24: astore_1
    //   25: aload_2
    //   26: ifnull +117 -> 143
    //   29: aload_1
    //   30: ifnull +113 -> 143
    //   33: ldc_w 598
    //   36: invokestatic 487	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   39: checkcast 598	com/tencent/mm/plugin/findersdk/a/cb
    //   42: aload_2
    //   43: aload_1
    //   44: invokeinterface 630 3 0
    //   49: ifeq +79 -> 128
    //   52: invokestatic 217	com/tencent/mm/plugin/websearch/webview/b:iqR	()Lorg/json/JSONObject;
    //   55: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: ldc_w 628
    //   62: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: areturn
    //   67: aload_2
    //   68: invokeinterface 284 1 0
    //   73: astore_2
    //   74: goto -55 -> 19
    //   77: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   80: astore_3
    //   81: new 131	org/json/JSONObject
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 292	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_1
    //   93: aload_1
    //   94: astore_3
    //   95: aload_1
    //   96: invokestatic 300	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   99: ifeq +5 -> 104
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: checkcast 131	org/json/JSONObject
    //   108: astore_1
    //   109: goto -84 -> 25
    //   112: astore_1
    //   113: getstatic 289	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   116: astore_3
    //   117: aload_1
    //   118: invokestatic 306	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   121: invokestatic 296	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_1
    //   125: goto -32 -> 93
    //   128: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   131: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   134: astore_1
    //   135: ldc_w 628
    //   138: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: areturn
    //   143: invokestatic 220	com/tencent/mm/plugin/websearch/webview/b:fqu	()Lorg/json/JSONObject;
    //   146: invokevirtual 190	org/json/JSONObject:toString	()Ljava/lang/String;
    //   149: astore_1
    //   150: ldc_w 628
    //   153: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	b
    //   0	158	1	paramString	String
    //   12	62	2	localObject1	Object
    //   1	116	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   77	93	112	finally
  }
  
  @JavascriptInterface
  public String profile(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(315325);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "profile %s", new Object[] { paramString });
        paramString = new JSONObject(paramString).optString("username", "");
        if ((paramString != null) && (paramString.length() != 0)) {
          continue;
        }
        Log.e("MicroMsg.WebSearch.BaseWebSearchJSApi", "doProfile fail, username is null");
        i = 0;
        if (i == 0) {
          continue;
        }
        paramString = iqR().toString();
      }
      catch (Exception paramString)
      {
        Intent localIntent;
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "openFinderProfile", new Object[0]);
        paramString = fqu().toString();
        continue;
        paramString = paramString.getActivityContext();
        continue;
        paramString = fqu().toString();
        continue;
      }
      AppMethodBeat.o(315325);
      return paramString;
      localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramString);
      localIntent.putExtra("Contact_Scene", 174);
      localIntent.putExtra("force_get_contact", true);
      localIntent.putExtra("key_use_new_contact_profile", true);
      paramString = iqP();
      if (paramString != null) {
        continue;
      }
      paramString = null;
      com.tencent.mm.br.c.b(paramString, "profile", ".ui.ContactInfoUI", localIntent);
    }
  }
  
  @JavascriptInterface
  public String querySearchWeb(String paramString)
  {
    AppMethodBeat.i(315351);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", kotlin.g.b.s.X("querySearchWeb ", paramString));
    if (paramString != null)
    {
      Object localObject = iqP();
      if (localObject != null)
      {
        localObject = ((f)localObject).fyS();
        if (localObject != null)
        {
          kotlin.g.b.s.u(paramString, "paramsStr");
          paramString = new JSONObject(paramString);
          paramString = new x(paramString.optString("requestId", ""), paramString.optString("commReq", ""), ((a)localObject).ipD());
          com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
        }
      }
      paramString = iqR().toString();
      AppMethodBeat.o(315351);
      return paramString;
    }
    paramString = fqu().toString();
    AppMethodBeat.o(315351);
    return paramString;
  }
  
  @JavascriptInterface
  public String reportIDKey(String paramString)
  {
    AppMethodBeat.i(315306);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "reportIDKey %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("id", 0);
      int j = paramString.optInt("key", 0);
      int k = paramString.optInt("value", 0);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(i, j, k, false);
      paramString = iqR().toString();
      AppMethodBeat.o(315306);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "reportIdKey", new Object[0]);
        paramString = fqu().toString();
      }
    }
  }
  
  @JavascriptInterface
  public final String reportKV(String paramString)
  {
    AppMethodBeat.i(315311);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "reportKV %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid");
      paramString = paramString.optString("msg", "");
      com.tencent.mm.plugin.report.f.Ozc.kvStat(i, paramString);
      paramString = iqR().toString();
      AppMethodBeat.o(315311);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "reportIdKey", new Object[0]);
      paramString = fqu().toString();
      AppMethodBeat.o(315311);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String reportSearchRealTimeStatistics(String paramString)
  {
    AppMethodBeat.i(315315);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "reportSearchRealTimeStatistics %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localeqy = new eqy();
        localeqy.abuE = paramString.optString("logString", "");
        if (edC() != 1) {
          continue;
        }
        paramString = new ae(localeqy);
        com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
        paramString = iqR().toString();
      }
      catch (Exception paramString)
      {
        eqy localeqy;
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "reportSearchRealTimeStatistics", new Object[0]);
        paramString = fqu().toString();
        continue;
      }
      AppMethodBeat.o(315315);
      return paramString;
      paramString = new com.tencent.mm.plugin.websearch.api.z(localeqy);
      com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
    }
  }
  
  @JavascriptInterface
  public String reportSearchStatistics(String paramString)
  {
    AppMethodBeat.i(315300);
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", "reportSearchStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logId", 0);
      paramString = paramString.optString("logString", "");
      com.tencent.mm.plugin.report.f.Ozc.kvStat(i, paramString);
      paramString = iqR().toString();
      AppMethodBeat.o(315300);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseWebSearchJSApi", (Throwable)paramString, "reportSearchStatistics", new Object[0]);
        paramString = fqu().toString();
      }
    }
  }
  
  @JavascriptInterface
  public final String showVKB(String paramString)
  {
    AppMethodBeat.i(315385);
    paramString = iqP();
    if (paramString != null) {
      paramString.showVKB();
    }
    paramString = iqR().toString();
    kotlin.g.b.s.s(paramString, "returnSuccess().toString()");
    AppMethodBeat.o(315385);
    return paramString;
  }
  
  @JavascriptInterface
  public void vibrateShort(String paramString)
  {
    AppMethodBeat.i(315354);
    q.a locala = q.Wsi;
    q.a.biO(paramString);
    AppMethodBeat.o(315354);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi$Companion;", "", "()V", "CACHE_EXPIRED_TIME", "", "REPORT_TYPE_TOPSTORY", "", "REPORT_TYPE_WEBSEARCH", "TAG", "", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(Context paramContext, JSONObject paramJSONObject, LifecycleScope paramLifecycleScope, b<T> paramb, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(315294);
      paramObject = (d)new b(this.$context, paramString, this.HzV, jdField_this, paramd);
      AppMethodBeat.o(315294);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(315288);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(315288);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = ((cb)com.tencent.mm.kernel.h.ax(cb.class)).h(this.$context, paramString);
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new b(this.HzV, jdField_this);
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(315288);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(315288);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements kotlin.g.a.m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(b<T> paramb, String paramString, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(315195);
        paramObject = (d)new a(this.WrM, this.WrN, paramd);
        AppMethodBeat.o(315195);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(315191);
        Object localObject = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(315191);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.a(this.WrM);
        if (paramObject != null)
        {
          paramObject = paramObject.getWebView();
          if (paramObject != null)
          {
            localObject = this.WrN;
            m localm = m.WrX;
            m.a(paramObject, "onFinderItemDetailReady", (String)localObject);
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(315191);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.h<String>
    {
      public b(LifecycleScope paramLifecycleScope, b paramb) {}
      
      public final Object a(String paramString, d<? super ah> paramd)
      {
        AppMethodBeat.i(315198);
        paramString = (String)paramString;
        paramString = j.a((aq)this.HzZ, (kotlin.d.f)bg.kCh(), null, (kotlin.g.a.m)new b.b.a(this.WrM, paramString, null), 2);
        if (paramString == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(315198);
          return paramString;
        }
        paramString = ah.aiuX;
        AppMethodBeat.o(315198);
        return paramString;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "url", "", "errMsg", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.q<String, String, Integer, ah>
  {
    d(String paramString, b<T> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.b
 * JD-Core Version:    0.7.0.1
 */