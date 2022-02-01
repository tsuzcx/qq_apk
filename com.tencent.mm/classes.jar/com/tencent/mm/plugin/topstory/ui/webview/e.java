package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.e.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private c AgH;
  TopStoryWebView AgI;
  private boolean AgJ = true;
  public com.tencent.mm.plugin.topstory.ui.home.a Agw;
  dia dyS;
  
  public e(TopStoryWebView paramTopStoryWebView, dia paramdia, c paramc)
  {
    this.AgI = paramTopStoryWebView;
    this.dyS = paramdia;
    this.AgH = paramc;
  }
  
  private static JSONObject eeE()
  {
    AppMethodBeat.i(126618);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", 0);
      label21:
      AppMethodBeat.o(126618);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  private static JSONObject eeF()
  {
    AppMethodBeat.i(126619);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", -1);
      label21:
      AppMethodBeat.o(126619);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final void axM(String paramString)
  {
    AppMethodBeat.i(126603);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("json", paramString);
      localJSONObject.put("newQuery", this.AgJ);
      localJSONObject.put("isCache", false);
      ap.f(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126577);
          String str = localJSONObject.toString();
          a.a(e.this, "onSearchDataReady", str);
          com.tencent.mm.plugin.topstory.ui.d.c(e.this.dyS, "dataReady", System.currentTimeMillis());
          AppMethodBeat.o(126577);
        }
      });
      AppMethodBeat.o(126603);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126603);
    }
  }
  
  public final void axU(final String paramString)
  {
    AppMethodBeat.i(126606);
    ap.f(new Runnable()
    {
      @TargetApi(7)
      public final void run()
      {
        AppMethodBeat.i(126585);
        a.a(e.this, "onWebCommendEnterFromFindPage", paramString);
        AppMethodBeat.o(126585);
      }
    });
    AppMethodBeat.o(126606);
  }
  
  public final void axV(String paramString)
  {
    AppMethodBeat.i(126617);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramString);
      localJSONObject.put("sessionId", this.dyS.sessionId);
      localJSONObject.put("subSessionId", this.dyS.drf);
      localJSONObject.put("scene", this.dyS.scene);
      ap.f(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126580);
          String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { localJSONObject.toString() });
          e.this.AgI.evaluateJavascript(str, null);
          AppMethodBeat.o(126580);
        }
      });
      AppMethodBeat.o(126617);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126617);
    }
  }
  
  public final void br(String paramString, long paramLong)
  {
    AppMethodBeat.i(126605);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("msgId", paramString);
      localJSONObject.put("latestTimeStamp", paramLong);
      ap.f(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126583);
          String str = localJSONObject.toString();
          a.a(e.this, "notifyReddot", str);
          AppMethodBeat.o(126583);
        }
      });
      AppMethodBeat.o(126605);
      return;
    }
    catch (JSONException paramString)
    {
      ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
      AppMethodBeat.o(126605);
    }
  }
  
  public final void c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(126604);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("beginMsgId", paramString1);
      localJSONObject.put("endMsgId", paramString2);
      localJSONObject.put("beginSeq", paramInt1);
      localJSONObject.put("endSeq", paramInt2);
      localJSONObject.put("reddotNum", paramInt3);
      localJSONObject.put("extInfo", paramString3);
      ap.f(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126582);
          String str = localJSONObject.toString();
          a.a(e.this, "notifyNumReddotChange", str);
          AppMethodBeat.o(126582);
        }
      });
      AppMethodBeat.o(126604);
      return;
    }
    catch (JSONException paramString1)
    {
      ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyNumReddotChange " + paramString1.getMessage());
      AppMethodBeat.o(126604);
    }
  }
  
  @JavascriptInterface
  public final String doGoToRecVideoList(String paramString)
  {
    AppMethodBeat.i(126600);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", new Object[] { paramString });
    try
    {
      paramString = h.aK(new JSONObject(paramString));
      if (this.Agw != null) {
        z.a(this.Agw.cYC(), paramString, 1);
      }
      paramString = eeE().toString();
      AppMethodBeat.o(126600);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doGoToRecVideoList", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126600);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final void doNegFeedback(String paramString)
  {
    AppMethodBeat.i(126621);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doNegFeedback %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("filterDocid"))
      {
        boolean bool = paramString.has("category");
        if (bool) {}
      }
      else
      {
        AppMethodBeat.o(126621);
        return;
      }
      String str = paramString.getString("filterDocid");
      int i = paramString.getInt("category");
      ((com.tencent.mm.plugin.topstory.ui.b)g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().cf(i, str);
      AppMethodBeat.o(126621);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doNegFeedback", new Object[0]);
      AppMethodBeat.o(126621);
    }
  }
  
  public final void eeD()
  {
    AppMethodBeat.i(126608);
    ap.f(new Runnable()
    {
      @TargetApi(7)
      public final void run()
      {
        AppMethodBeat.i(126579);
        a.a(e.this, "onNavBarShadowManuallyHidden", "");
        AppMethodBeat.o(126579);
      }
    });
    AppMethodBeat.o(126608);
  }
  
  @JavascriptInterface
  public final String fetchNumReddot(String paramString)
  {
    AppMethodBeat.i(126609);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", new Object[] { paramString });
    try
    {
      int i = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eca();
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecc();
      dii localdii = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ecd();
      c(localdii.dtG, paramString.dtG, localdii.hTM, paramString.hTM, i, paramString.extInfo);
      paramString = eeE().toString();
      AppMethodBeat.o(126609);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126609);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String fetchReddot(String paramString)
  {
    AppMethodBeat.i(126610);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchReddot %s", new Object[] { paramString });
    try
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebT();
      if (paramString != null) {
        br(paramString.dtG, paramString.FRm);
      }
      paramString = eeE().toString();
      AppMethodBeat.o(126610);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126610);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String getNetworkType(String paramString)
  {
    AppMethodBeat.i(126597);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getNetworkType %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        paramString = eeE();
        String str = h.ecx();
        paramString.put("subtype", str);
        if (str.equals("wifi"))
        {
          paramString.put("err_msg", "network_type:wifi");
          paramString = paramString.toString();
          AppMethodBeat.o(126597);
          return paramString;
        }
        if (str.equals("fail")) {
          paramString.put("err_msg", "network_type:fail");
        } else {
          paramString.put("err_msg", "network_type:wwan");
        }
      }
      catch (Exception paramString)
      {
        paramString = eeF().toString();
        AppMethodBeat.o(126597);
        return paramString;
      }
    }
  }
  
  @JavascriptInterface
  public final String getSearchData(String paramString)
  {
    AppMethodBeat.i(126590);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", new Object[] { paramString });
    if (this.Agw != null) {
      this.Agw.ecN();
    }
    com.tencent.mm.plugin.topstory.ui.d.c(this.dyS, "getSearchData", System.currentTimeMillis());
    Object localObject1;
    dia localdia;
    boolean bool;
    int i;
    try
    {
      localObject1 = new JSONObject(paramString);
      localdia = new dia();
      localdia.qox = this.dyS.qox;
      localdia.cZL = ((JSONObject)localObject1).optString("query", "");
      localdia.offset = ((JSONObject)localObject1).optInt("offset", 0);
      localdia.scene = ((JSONObject)localObject1).optInt("scene", 21);
      localdia.sessionId = ((JSONObject)localObject1).optString("sessionId", "");
      localdia.drf = ((JSONObject)localObject1).optString("subSessionId", "");
      localdia.jKB = ((JSONObject)localObject1).optString("searchId", "");
      localdia.dlj = ((JSONObject)localObject1).optString("requestId", "");
      localdia.cGY = ((JSONObject)localObject1).optInt("tagId", 0);
      localdia.BYy = ((JSONObject)localObject1).optString("navigationId", "");
      localdia.rzt = z.dkv();
      bool = ((JSONObject)localObject1).optBoolean("directRequest", false);
      paramString = ((JSONObject)localObject1).optString("extReqParams", "");
      localObject1 = ((JSONObject)localObject1).optString("homeMsgId", "");
      Object localObject3;
      if (!bs.isNullOrNil(paramString))
      {
        paramString = new JSONArray(paramString);
        i = 0;
        while (i < paramString.length())
        {
          localObject2 = paramString.getJSONObject(i);
          localObject3 = new yh();
          ((yh)localObject3).key = ((JSONObject)localObject2).optString("key", "");
          ((yh)localObject3).ErV = ((JSONObject)localObject2).optInt("uintValue", 0);
          ((yh)localObject3).ErW = ((JSONObject)localObject2).optString("textValue", "");
          localdia.BYq.add(localObject3);
          i += 1;
        }
      }
      if (((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).bFR().size() > 0)
      {
        localdia.FQZ = new ape();
        paramString = ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).bFR().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (BallInfo)paramString.next();
          if (((BallInfo)localObject2).type == 2)
          {
            localObject2 = ((BallInfo)localObject2).eq("rawUrl", "");
            if ((!bs.isNullOrNil((String)localObject2)) && ((((String)localObject2).startsWith("https://mp.weixin.qq.com/s")) || (((String)localObject2).startsWith("http://mp.weixin.qq.com/s"))))
            {
              localObject3 = new apf();
              ((apf)localObject3).EIi = ((String)localObject2);
              localdia.FQZ.EIh.add(localObject3);
              ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "add float ball url %s", new Object[] { localObject2 });
            }
          }
        }
      }
      if (localdia.cGY != 100) {
        break label772;
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchData", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126590);
      return paramString;
    }
    Object localObject2 = this.AgH;
    if (((c)localObject2).Agy == null)
    {
      paramString = null;
      if ((!bs.isNullOrNil(paramString)) && (!bool))
      {
        axM(paramString);
        paramString = eeE().toString();
        AppMethodBeat.o(126590);
        return paramString;
      }
    }
    else
    {
      if ((!((c)localObject2).Agy.AgG.sessionId.equals(localdia.sessionId)) || (System.currentTimeMillis() - ((c)localObject2).Agy.nvA > 60000L)) {
        break label811;
      }
    }
    label772:
    label811:
    for (paramString = ((c)localObject2).Agy.AgF;; paramString = null)
    {
      ((c)localObject2).Agy = null;
      if (bs.isNullOrNil(paramString))
      {
        ac.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
        break;
      }
      ac.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", new Object[] { Integer.valueOf(paramString.length()) });
      break;
      paramString = this.AgH;
      if (this.Agw == null) {}
      for (i = 0;; i = this.Agw.ecR())
      {
        paramString.a(localdia, true, bool, i, (String)localObject1);
        break;
      }
      paramString = this.AgH;
      if (this.Agw == null) {}
      for (i = 0;; i = this.Agw.ecR())
      {
        paramString.a(localdia, true, bool, i);
        break;
      }
    }
  }
  
  @JavascriptInterface
  public final String getSearchDisplayNameList(String paramString)
  {
    AppMethodBeat.i(170150);
    for (;;)
    {
      try
      {
        JSONArray localJSONArray2 = new JSONArray(new JSONObject(paramString).optString("data"));
        JSONArray localJSONArray1 = new JSONArray();
        int i = 0;
        if (i < localJSONArray2.length())
        {
          localObject = localJSONArray2.getJSONObject(i);
          if (((JSONObject)localObject).has("id"))
          {
            paramString = ((JSONObject)localObject).getString("id");
            if (!((JSONObject)localObject).has("userName")) {
              break label242;
            }
            localObject = ((JSONObject)localObject).getString("userName");
            String str = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk((String)localObject);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("id", paramString);
            localJSONObject.put("userName", localObject);
            localJSONObject.put("displayName", str);
            localJSONArray1.put(localJSONObject);
            i += 1;
          }
        }
        else
        {
          paramString = new JSONObject();
          paramString.put("ret", 0);
          paramString.put("data", localJSONArray1.toString());
          paramString = paramString.toString();
          AppMethodBeat.o(170150);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchDisplayNameList", new Object[0]);
        paramString = eeF().toString();
        AppMethodBeat.o(170150);
        return paramString;
      }
      paramString = "";
      continue;
      label242:
      Object localObject = "";
    }
  }
  
  @JavascriptInterface
  public final String hideNavBarShadow(String paramString)
  {
    AppMethodBeat.i(126616);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", new Object[] { paramString });
    try
    {
      this.Agw.ecP();
      paramString = eeE().toString();
      AppMethodBeat.o(126616);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126616);
    }
    return paramString;
  }
  
  public final void l(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(126607);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tabInfo", paramString1);
      localJSONObject.put("contentReddot", paramInt1);
      localJSONObject.put("numberReddot", paramInt2);
      localJSONObject.put("msgId", paramString2);
      a.a(this, "onTabSelected", localJSONObject.toString());
      AppMethodBeat.o(126607);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ac.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected json exception: " + paramString1.getMessage());
      }
    }
  }
  
  @JavascriptInterface
  public final String log(String paramString)
  {
    AppMethodBeat.i(126596);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "log: %s", new Object[] { paramString });
    paramString = eeE().toString();
    AppMethodBeat.o(126596);
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(206784);
    try
    {
      ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", paramString.optString("feedId", ""));
      localJSONObject.put("extInfo", new JSONObject(paramString.optString("extInfo", "")));
      ((l)g.ad(l.class)).enterFinderShareFeedUI(ai.getContext(), localJSONObject.toString());
      paramString = eeE().toString();
      AppMethodBeat.o(206784);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(206784);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(206783);
    try
    {
      ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString).optString("userName", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", paramString);
      localIntent.putExtra("key_from_profile_share_scene", 15);
      localIntent.putExtra("key_enter_profile_type", 1);
      ((l)g.ad(l.class)).enterFinderProfileUI(ai.getContext(), localIntent);
      paramString = eeE().toString();
      AppMethodBeat.o(206783);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(206783);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openProfileWithOpenId(String paramString)
  {
    AppMethodBeat.i(126598);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openProfileWithOpenId %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).getString("openId");
      if (!bs.isNullOrNil(paramString)) {
        com.tencent.mm.plugin.topstory.ui.d.axL(paramString);
      }
      paramString = eeE().toString();
      AppMethodBeat.o(126598);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126598);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(126620);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openSearchWebView %s", new Object[] { paramString });
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(paramString);
        i = ((JSONObject)localObject1).optInt("actionType");
        localObject2 = ((JSONObject)localObject1).optString("extParams", "");
        paramString = ((JSONObject)localObject1).optString("publishId", "");
        switch (i)
        {
        case 4: 
        case 5: 
          paramString = eeE().toString();
          AppMethodBeat.o(126620);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString = eeF().toString();
        AppMethodBeat.o(126620);
        return paramString;
      }
      Object localObject2 = ((JSONObject)localObject1).optString("srcUserName");
      Object localObject3 = new Intent();
      Object localObject1 = ((JSONObject)localObject1).optString("jumpUrl", "");
      ((Intent)localObject3).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject3).putExtra("KPublisherId", paramString);
      ((Intent)localObject3).putExtra("srcUsername", (String)localObject2);
      ((Intent)localObject3).putExtra("geta8key_scene", 64);
      ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s srcUserName = %s", new Object[] { localObject1, paramString, localObject2 });
      com.tencent.mm.br.d.b(this.Agw.cYC(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject3);
      continue;
      localObject3 = ((JSONObject)localObject1).optString("query", "");
      int j = ((JSONObject)localObject1).optInt("scene", 0);
      String str1 = ((JSONObject)localObject1).optString("sessionId", "");
      String str2 = z.Ui(j);
      int k = ((JSONObject)localObject1).optInt("tagId", 0);
      try
      {
        i = Color.parseColor(((JSONObject)localObject1).optString("navBarColor", ""));
        Object localObject4 = ((JSONObject)localObject1).optString("nativeConfig", "");
        paramString = null;
        bool = TextUtils.isEmpty((CharSequence)localObject4);
        if (!bool)
        {
          try
          {
            localObject4 = new JSONObject((String)localObject4);
            if (((JSONObject)localObject4).has("title")) {
              paramString = ((JSONObject)localObject4).optString("title");
            }
            if (((JSONObject)localObject1).optInt("preRequest", 1) != 1) {
              break label743;
            }
            bool = true;
            localObject1 = String.valueOf(System.currentTimeMillis());
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("scene", String.valueOf(j));
            ((HashMap)localObject4).put("query", localObject3);
            ((HashMap)localObject4).put("sessionId", str1);
            ((HashMap)localObject4).put("extParams", localObject2);
            ((HashMap)localObject4).put("subSessionId", str2);
            if (bool)
            {
              ((HashMap)localObject4).put("requestId", localObject1);
              ((HashMap)localObject4).put("pRequestId", localObject1);
              ((HashMap)localObject4).put("seq", localObject1);
            }
            localObject2 = new dia();
            ((dia)localObject2).qox = com.tencent.mm.plugin.topstory.ui.d.ecM();
            ((dia)localObject2).scene = j;
            ((dia)localObject2).jKB = "";
            ((dia)localObject2).cZL = ((String)localObject3);
            ((dia)localObject2).sessionId = str1;
            ((dia)localObject2).drf = str1;
            ((dia)localObject2).FQW = 2;
            ((dia)localObject2).url = h.l((HashMap)localObject4);
            ((dia)localObject2).EDw = paramString;
            ((dia)localObject2).cGY = k;
            if (bool) {
              ((dia)localObject2).dlj = ((String)localObject1);
            }
            ((dia)localObject2).rzt = z.dkv();
            paramString = new yh();
            paramString.key = "rec_category";
            paramString.ErV = k;
            paramString.ErW = String.valueOf(k);
            ((dia)localObject2).BYq.add(paramString);
            ((dia)localObject2).tCS = i;
            localObject3 = ai.getContext();
            if (!bool) {
              break label749;
            }
            paramString = (String)localObject1;
            com.tencent.mm.plugin.topstory.ui.d.a((Context)localObject3, (dia)localObject2, paramString, bool);
          }
          catch (JSONException paramString)
          {
            ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "", new Object[0]);
            break label738;
          }
          i = ((JSONObject)localObject1).optInt("scene", 53);
          j = ((JSONObject)localObject1).optInt("subScene", 5);
          this.Agw.hV(i, j);
          continue;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          i = 0;
          continue;
          label738:
          paramString = null;
          continue;
          label743:
          boolean bool = false;
          continue;
          label749:
          paramString = "";
        }
      }
    }
  }
  
  @JavascriptInterface
  public final String openWeAppPage(String paramString)
  {
    AppMethodBeat.i(126622);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWeAppPage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1115;
      ((n)g.ab(n.class)).a(ai.getContext(), paramString.getString("userName"), paramString.getString("appid"), paramString.optInt("debugMode", 0), 0, paramString.getString("path"), localAppBrandStatObject);
      paramString = eeE().toString();
      AppMethodBeat.o(126622);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWeAppPage", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126622);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openWowColikeSetting(String paramString)
  {
    AppMethodBeat.i(126623);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWowColikeSetting %s", new Object[] { paramString });
    try
    {
      com.tencent.mm.plugin.topstory.ui.d.gv(ai.getContext());
      paramString = eeE().toString();
      AppMethodBeat.o(126623);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWowColikeSetting", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126623);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String postComments(String paramString)
  {
    AppMethodBeat.i(126614);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl postComments %s", new Object[] { paramString });
    try
    {
      paramString = new f(new JSONObject(paramString));
      g.agi().a(paramString, 0);
      paramString = eeE().toString();
      AppMethodBeat.o(126614);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126614);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String queryWebCommCgi(String paramString)
  {
    AppMethodBeat.i(126611);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new com.tencent.mm.plugin.topstory.a.c.a(paramString.optString("requestId", ""), paramString.optString("commReq", ""));
      g.agi().a(paramString, 0);
      paramString = eeE().toString();
      AppMethodBeat.o(126611);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126611);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String renderFinish(String paramString)
  {
    AppMethodBeat.i(126602);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "renderFinish %s", new Object[] { paramString });
    try
    {
      this.Agw.ecQ();
      paramString = eeE().toString();
      AppMethodBeat.o(126602);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "renderFinish error", new Object[0]);
      }
    }
  }
  
  @JavascriptInterface
  public final String reportSearchRealTimeStatistics(String paramString)
  {
    AppMethodBeat.i(126593);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchRealTimeStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      cpk localcpk = new cpk();
      localcpk.FCf = paramString.optString("logString", "");
      paramString = new r(localcpk);
      g.agi().a(paramString, 0);
      paramString = eeE().toString();
      AppMethodBeat.o(126593);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeStatistics", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126593);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String reportSearchStatistics(String paramString)
  {
    AppMethodBeat.i(126592);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logId", 0);
      if (i != 14904)
      {
        paramString = paramString.optString("logString", "");
        com.tencent.mm.plugin.report.e.wTc.kvStat(i, paramString);
      }
      paramString = eeE().toString();
      AppMethodBeat.o(126592);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchStatistics", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126592);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String searchDataHasResult(String paramString)
  {
    AppMethodBeat.i(126591);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "searchDataHasResult %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("tagId", 0);
      int j = paramString.optInt("resultCount", 0);
      if (i == 110)
      {
        if (j <= 0) {
          break label90;
        }
        g.agR().agA().set(ah.a.GRU, Integer.valueOf(1));
      }
      for (;;)
      {
        paramString = eeE().toString();
        AppMethodBeat.o(126591);
        return paramString;
        label90:
        g.agR().agA().set(ah.a.GRU, Integer.valueOf(0));
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "searchDataHasResult", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126591);
    }
  }
  
  @JavascriptInterface
  public final String setComments(String paramString)
  {
    AppMethodBeat.i(126613);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl setComments %s", new Object[] { paramString });
    try
    {
      paramString = new j(new JSONObject(paramString));
      g.agi().a(paramString, 0);
      paramString = eeE().toString();
      AppMethodBeat.o(126613);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126613);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String showNavBarShadow(String paramString)
  {
    AppMethodBeat.i(126615);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl showNavBarShadow %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("color");
      str = str.substring(1, str.length());
      int i = (int)(paramString.getDouble("alpha") * 255.0D);
      int j = Integer.parseInt(str, 16);
      this.Agw.hU(j, i);
      paramString = eeE().toString();
      AppMethodBeat.o(126615);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126615);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String stage(String paramString)
  {
    AppMethodBeat.i(126594);
    try
    {
      ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      if (paramString.keys() != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          long l = paramString.optLong(str);
          com.tencent.mm.plugin.topstory.ui.d.c(this.dyS, str, l);
        }
      }
      paramString = eeE().toString();
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "stage", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126594);
      return paramString;
    }
    AppMethodBeat.o(126594);
    return paramString;
  }
  
  @JavascriptInterface
  public final String startSearchItemDetailPage(String paramString)
  {
    AppMethodBeat.i(126595);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str = paramString.optString("jumpUrl", "");
        Object localObject = paramString.optString("publishId", "");
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("KPublisherId", (String)localObject);
        ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", new Object[] { str, localObject });
        localIntent.putExtra("srcUsername", paramString.optString("srcUserName"));
        localIntent.putExtra("geta8key_scene", 64);
        int j = paramString.optInt("openScene", 10000);
        int k = paramString.optInt("subScene", -1);
        int m = paramString.optInt("itemType", -1);
        localIntent.putExtra(e.m.HhB, m);
        if ((m == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yr(m)))
        {
          if (paramString.has("srcUserName")) {
            continue;
          }
          ac.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid srcUserName");
          i = 0;
          if (i != 0)
          {
            localObject = new Bundle();
            x localx = new x();
            localx.ddo = paramString.optString("srcUserName");
            localx.hkV = paramString.optString("srcDisplayName");
            localx.hkX.url = str;
            localx.hkX.title = paramString.optString("title");
            localx.hkX.hlf = paramString.optString("digest");
            localx.hkX.hld = paramString.optString("cover");
            localx.hkX.type = m;
            localx.hkX.time = paramString.optInt("pubTime");
            localx.hkX.hlh = paramString.optInt("duration");
            localx.hkX.videoWidth = paramString.optInt("videoWidth");
            localx.hkX.videoHeight = paramString.optInt("videoHeight");
            localx.hkX.hhd = paramString.optString("vid");
            localx.s((Bundle)localObject);
            localIntent.putExtras((Bundle)localObject);
          }
        }
        ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        if ((((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(7)) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.Agw.cYC(), str, m, j, k, localIntent)))
        {
          ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
          paramString = eeE().toString();
          AppMethodBeat.o(126595);
          return paramString;
          if (!paramString.has("cover"))
          {
            ac.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid cover");
            i = 0;
            continue;
          }
          if (!paramString.has("vid"))
          {
            ac.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid vid");
            i = 0;
          }
        }
        else
        {
          ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewMpUI");
          com.tencent.mm.br.d.b(this.Agw.cYC(), "webview", ".ui.tools.WebviewMpUI", localIntent);
          continue;
        }
        int i = 1;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeReport", new Object[0]);
        paramString = eeF().toString();
        AppMethodBeat.o(126595);
        return paramString;
      }
    }
  }
  
  @JavascriptInterface
  public final String updateNumReddot(String paramString)
  {
    AppMethodBeat.i(126612);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl updateNumReddot %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      long l = paramString.getLong("latestTimeStamp");
      int i = paramString.getInt("seq");
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().h(l, i, false);
      paramString = eeE().toString();
      AppMethodBeat.o(126612);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "lxl updateNumReddot", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126612);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String updateReddotTimeStamps(String paramString)
  {
    AppMethodBeat.i(126599);
    ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().yE(paramString.optLong("reddotTimeStamps", 0L));
      paramString = eeE().toString();
      AppMethodBeat.o(126599);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "updateReddotTimeStamps", new Object[0]);
      paramString = eeF().toString();
      AppMethodBeat.o(126599);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String webViewUIReady(String paramString)
  {
    AppMethodBeat.i(126601);
    try
    {
      if (this.AgJ)
      {
        this.AgJ = false;
        if (this.Agw != null) {
          this.Agw.ecO();
        }
        com.tencent.mm.plugin.topstory.ui.d.c(this.dyS, "webViewUIReady", System.currentTimeMillis());
        ac.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", new Object[] { com.tencent.mm.plugin.topstory.ui.d.a(this.dyS) });
      }
      paramString = eeE().toString();
      AppMethodBeat.o(126601);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eeF().toString();
      AppMethodBeat.o(126601);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e
 * JD-Core Version:    0.7.0.1
 */