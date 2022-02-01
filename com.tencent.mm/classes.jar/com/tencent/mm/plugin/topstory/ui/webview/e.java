package com.tencent.mm.plugin.topstory.ui.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public com.tencent.mm.plugin.topstory.ui.home.a Byi;
  private c Byt;
  TopStoryWebView Byu;
  private boolean Byv = true;
  dnp dLe;
  
  public e(TopStoryWebView paramTopStoryWebView, dnp paramdnp, c paramc)
  {
    this.Byu = paramTopStoryWebView;
    this.dLe = paramdnp;
    this.Byt = paramc;
  }
  
  private static JSONObject eqV()
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
  
  private static JSONObject eqW()
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
  
  public final void aCR(String paramString)
  {
    AppMethodBeat.i(126603);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("json", paramString);
      localJSONObject.put("newQuery", this.Byv);
      localJSONObject.put("isCache", false);
      aq.f(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126577);
          String str = localJSONObject.toString();
          a.a(e.this, "onSearchDataReady", str);
          com.tencent.mm.plugin.topstory.ui.d.c(e.this.dLe, "dataReady", System.currentTimeMillis());
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
  
  public final void aCZ(final String paramString)
  {
    AppMethodBeat.i(126606);
    aq.f(new Runnable()
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
  
  public final void aDa(String paramString)
  {
    AppMethodBeat.i(126617);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramString);
      localJSONObject.put("sessionId", this.dLe.sessionId);
      localJSONObject.put("subSessionId", this.dLe.dCW);
      localJSONObject.put("scene", this.dLe.scene);
      aq.f(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126580);
          String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { localJSONObject.toString() });
          e.this.Byu.evaluateJavascript(str, null);
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
  
  public final void bu(String paramString, long paramLong)
  {
    AppMethodBeat.i(126605);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("msgId", paramString);
      localJSONObject.put("latestTimeStamp", paramLong);
      aq.f(new Runnable()
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
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
      aq.f(new Runnable()
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyNumReddotChange " + paramString1.getMessage());
      AppMethodBeat.o(126604);
    }
  }
  
  @JavascriptInterface
  public final String doGoToRecVideoList(String paramString)
  {
    AppMethodBeat.i(126600);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", new Object[] { paramString });
    try
    {
      paramString = h.aS(new JSONObject(paramString));
      if (this.Byi != null) {
        com.tencent.mm.plugin.websearch.api.ad.a(this.Byi.dhO(), paramString, 1);
      }
      paramString = eqV().toString();
      AppMethodBeat.o(126600);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doGoToRecVideoList", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126600);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final void doNegFeedback(String paramString)
  {
    AppMethodBeat.i(126621);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doNegFeedback %s", new Object[] { paramString });
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
      ((com.tencent.mm.plugin.topstory.ui.b)g.ad(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().cm(i, str);
      AppMethodBeat.o(126621);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doNegFeedback", new Object[0]);
      AppMethodBeat.o(126621);
    }
  }
  
  public final void eqU()
  {
    AppMethodBeat.i(126608);
    aq.f(new Runnable()
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", new Object[] { paramString });
    try
    {
      int i = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eor();
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eot();
      dnx localdnx = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eou();
      c(localdnx.msgId, paramString.msgId, localdnx.inh, paramString.inh, i, paramString.extInfo);
      paramString = eqV().toString();
      AppMethodBeat.o(126609);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126609);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String fetchReddot(String paramString)
  {
    AppMethodBeat.i(126610);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchReddot %s", new Object[] { paramString });
    try
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().eok();
      if (paramString != null) {
        bu(paramString.msgId, paramString.HBS);
      }
      paramString = eqV().toString();
      AppMethodBeat.o(126610);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126610);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String getNetworkType(String paramString)
  {
    AppMethodBeat.i(126597);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getNetworkType %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        paramString = eqV();
        String str = h.eoO();
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
        paramString = eqW().toString();
        AppMethodBeat.o(126597);
        return paramString;
      }
    }
  }
  
  @JavascriptInterface
  public final String getSearchData(String paramString)
  {
    AppMethodBeat.i(126590);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", new Object[] { paramString });
    if (this.Byi != null) {
      this.Byi.epe();
    }
    com.tencent.mm.plugin.topstory.ui.d.c(this.dLe, "getSearchData", System.currentTimeMillis());
    Object localObject1;
    dnp localdnp;
    boolean bool;
    int i;
    try
    {
      localObject1 = new JSONObject(paramString);
      localdnp = new dnp();
      localdnp.qXu = this.dLe.qXu;
      localdnp.dld = ((JSONObject)localObject1).optString("query", "");
      localdnp.offset = ((JSONObject)localObject1).optInt("offset", 0);
      localdnp.scene = ((JSONObject)localObject1).optInt("scene", 21);
      localdnp.sessionId = ((JSONObject)localObject1).optString("sessionId", "");
      localdnp.dCW = ((JSONObject)localObject1).optString("subSessionId", "");
      localdnp.keN = ((JSONObject)localObject1).optString("searchId", "");
      localdnp.dwW = ((JSONObject)localObject1).optString("requestId", "");
      localdnp.cSc = ((JSONObject)localObject1).optInt("tagId", 0);
      localdnp.DBr = ((JSONObject)localObject1).optString("navigationId", "");
      localdnp.srd = com.tencent.mm.plugin.websearch.api.ad.Ux();
      bool = ((JSONObject)localObject1).optBoolean("directRequest", false);
      paramString = ((JSONObject)localObject1).optString("extReqParams", "");
      localObject1 = ((JSONObject)localObject1).optString("homeMsgId", "");
      Object localObject3;
      if (!bt.isNullOrNil(paramString))
      {
        paramString = new JSONArray(paramString);
        i = 0;
        while (i < paramString.length())
        {
          localObject2 = paramString.getJSONObject(i);
          localObject3 = new aag();
          ((aag)localObject3).key = ((JSONObject)localObject2).optString("key", "");
          ((aag)localObject3).FZe = ((JSONObject)localObject2).optInt("uintValue", 0);
          ((aag)localObject3).FZf = ((JSONObject)localObject2).optString("textValue", "");
          localdnp.DBj.add(localObject3);
          i += 1;
        }
      }
      if (((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).bKb().size() > 0)
      {
        localdnp.HBF = new asy();
        paramString = ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).bKb().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (BallInfo)paramString.next();
          if (((BallInfo)localObject2).type == 2)
          {
            localObject2 = ((BallInfo)localObject2).ez("rawUrl", "");
            if ((!bt.isNullOrNil((String)localObject2)) && ((((String)localObject2).startsWith("https://mp.weixin.qq.com/s")) || (((String)localObject2).startsWith("http://mp.weixin.qq.com/s"))))
            {
              localObject3 = new asz();
              ((asz)localObject3).GqZ = ((String)localObject2);
              localdnp.HBF.GqY.add(localObject3);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "add float ball url %s", new Object[] { localObject2 });
            }
          }
        }
      }
      if (localdnp.cSc != 100) {
        break label772;
      }
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchData", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126590);
      return paramString;
    }
    Object localObject2 = this.Byt;
    if (((c)localObject2).Byk == null)
    {
      paramString = null;
      if ((!bt.isNullOrNil(paramString)) && (!bool))
      {
        aCR(paramString);
        paramString = eqV().toString();
        AppMethodBeat.o(126590);
        return paramString;
      }
    }
    else
    {
      if ((!((c)localObject2).Byk.Bys.sessionId.equals(localdnp.sessionId)) || (System.currentTimeMillis() - ((c)localObject2).Byk.nWY > 60000L)) {
        break label811;
      }
    }
    label772:
    label811:
    for (paramString = ((c)localObject2).Byk.Byr;; paramString = null)
    {
      ((c)localObject2).Byk = null;
      if (bt.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", new Object[] { Integer.valueOf(paramString.length()) });
      break;
      paramString = this.Byt;
      if (this.Byi == null) {}
      for (i = 0;; i = this.Byi.epi())
      {
        paramString.a(localdnp, true, bool, i, (String)localObject1);
        break;
      }
      paramString = this.Byt;
      if (this.Byi == null) {}
      for (i = 0;; i = this.Byi.epi())
      {
        paramString.a(localdnp, true, bool, i);
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
            String str = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf((String)localObject);
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchDisplayNameList", new Object[0]);
        paramString = eqW().toString();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", new Object[] { paramString });
    try
    {
      this.Byi.epg();
      paramString = eqV().toString();
      AppMethodBeat.o(126616);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126616);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String log(String paramString)
  {
    AppMethodBeat.i(126596);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "log: %s", new Object[] { paramString });
    paramString = eqV().toString();
    AppMethodBeat.o(126596);
    return paramString;
  }
  
  public final void m(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(126607);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
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
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected json exception: " + paramString1.getMessage());
      }
    }
  }
  
  @JavascriptInterface
  public final String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(199602);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      Object localObject = new JSONObject(paramString);
      paramString = new JSONObject();
      paramString.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
      paramString.put("extInfo", new JSONObject(((JSONObject)localObject).optString("extInfo", "")));
      localObject = new Intent();
      ((t)g.ad(t.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((t)g.ad(t.class)).enterFinderShareFeedUI(aj.getContext(), paramString.toString(), (Intent)localObject);
      paramString = eqV().toString();
      AppMethodBeat.o(199602);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(199602);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(199601);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString).optString("userName", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", paramString);
      localIntent.putExtra("key_from_profile_share_scene", 15);
      localIntent.putExtra("key_enter_profile_type", 1);
      ((t)g.ad(t.class)).fillContextIdToIntent(7, 2, 32, localIntent);
      ((t)g.ad(t.class)).enterFinderProfileUI(aj.getContext(), localIntent);
      paramString = eqV().toString();
      AppMethodBeat.o(199601);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(199601);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openProfileWithOpenId(String paramString)
  {
    AppMethodBeat.i(126598);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openProfileWithOpenId %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).getString("openId");
      if (!bt.isNullOrNil(paramString)) {
        com.tencent.mm.plugin.topstory.ui.d.aCQ(paramString);
      }
      paramString = eqV().toString();
      AppMethodBeat.o(126598);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126598);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(126620);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openSearchWebView %s", new Object[] { paramString });
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
          paramString = eqV().toString();
          AppMethodBeat.o(126620);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString = eqW().toString();
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s srcUserName = %s", new Object[] { localObject1, paramString, localObject2 });
      com.tencent.mm.bs.d.b(this.Byi.dhO(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject3);
      continue;
      localObject3 = ((JSONObject)localObject1).optString("query", "");
      int j = ((JSONObject)localObject1).optInt("scene", 0);
      String str1 = ((JSONObject)localObject1).optString("sessionId", "");
      String str2 = com.tencent.mm.plugin.websearch.api.ad.Wb(j);
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
            localObject2 = new dnp();
            ((dnp)localObject2).qXu = com.tencent.mm.plugin.topstory.ui.d.epd();
            ((dnp)localObject2).scene = j;
            ((dnp)localObject2).keN = "";
            ((dnp)localObject2).dld = ((String)localObject3);
            ((dnp)localObject2).sessionId = str1;
            ((dnp)localObject2).dCW = str1;
            ((dnp)localObject2).HBC = 2;
            ((dnp)localObject2).url = h.l((HashMap)localObject4);
            ((dnp)localObject2).Glg = paramString;
            ((dnp)localObject2).cSc = k;
            if (bool) {
              ((dnp)localObject2).dwW = ((String)localObject1);
            }
            ((dnp)localObject2).srd = com.tencent.mm.plugin.websearch.api.ad.Ux();
            paramString = new aag();
            paramString.key = "rec_category";
            paramString.FZe = k;
            paramString.FZf = String.valueOf(k);
            ((dnp)localObject2).DBj.add(paramString);
            ((dnp)localObject2).uFB = i;
            localObject3 = aj.getContext();
            if (!bool) {
              break label749;
            }
            paramString = (String)localObject1;
            com.tencent.mm.plugin.topstory.ui.d.a((Context)localObject3, (dnp)localObject2, paramString, bool);
          }
          catch (JSONException paramString)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "", new Object[0]);
            break label738;
          }
          i = ((JSONObject)localObject1).optInt("scene", 53);
          j = ((JSONObject)localObject1).optInt("subScene", 5);
          this.Byi.il(i, j);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWeAppPage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1115;
      ((o)g.ab(o.class)).a(aj.getContext(), paramString.getString("userName"), paramString.getString("appid"), paramString.optInt("debugMode", 0), 0, paramString.getString("path"), localAppBrandStatObject);
      paramString = eqV().toString();
      AppMethodBeat.o(126622);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWeAppPage", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126622);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openWowColikeSetting(String paramString)
  {
    AppMethodBeat.i(126623);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWowColikeSetting %s", new Object[] { paramString });
    try
    {
      com.tencent.mm.plugin.topstory.ui.d.gy(aj.getContext());
      paramString = eqV().toString();
      AppMethodBeat.o(126623);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWowColikeSetting", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126623);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String postComments(String paramString)
  {
    AppMethodBeat.i(126614);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl postComments %s", new Object[] { paramString });
    try
    {
      paramString = new f(new JSONObject(paramString));
      g.aiU().a(paramString, 0);
      paramString = eqV().toString();
      AppMethodBeat.o(126614);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126614);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String queryWebCommCgi(String paramString)
  {
    AppMethodBeat.i(126611);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new com.tencent.mm.plugin.topstory.a.c.a(paramString.optString("requestId", ""), paramString.optString("commReq", ""));
      g.aiU().a(paramString, 0);
      paramString = eqV().toString();
      AppMethodBeat.o(126611);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126611);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String renderFinish(String paramString)
  {
    AppMethodBeat.i(126602);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "renderFinish %s", new Object[] { paramString });
    try
    {
      this.Byi.eph();
      paramString = eqV().toString();
      AppMethodBeat.o(126602);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "renderFinish error", new Object[0]);
      }
    }
  }
  
  @JavascriptInterface
  public final String reportSearchRealTimeStatistics(String paramString)
  {
    AppMethodBeat.i(126593);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchRealTimeStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      cup localcup = new cup();
      localcup.Hmu = paramString.optString("logString", "");
      paramString = new u(localcup);
      g.aiU().a(paramString, 0);
      paramString = eqV().toString();
      AppMethodBeat.o(126593);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeStatistics", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126593);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String reportSearchStatistics(String paramString)
  {
    AppMethodBeat.i(126592);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "reportSearchStatistics %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logId", 0);
      if (i != 14904)
      {
        paramString = paramString.optString("logString", "");
        com.tencent.mm.plugin.report.e.ygI.kvStat(i, paramString);
      }
      paramString = eqV().toString();
      AppMethodBeat.o(126592);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchStatistics", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126592);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String searchDataHasResult(String paramString)
  {
    AppMethodBeat.i(126591);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "searchDataHasResult %s", new Object[] { paramString });
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
        g.ajC().ajl().set(al.a.IEy, Integer.valueOf(1));
      }
      for (;;)
      {
        paramString = eqV().toString();
        AppMethodBeat.o(126591);
        return paramString;
        label90:
        g.ajC().ajl().set(al.a.IEy, Integer.valueOf(0));
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "searchDataHasResult", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126591);
    }
  }
  
  @JavascriptInterface
  public final String setComments(String paramString)
  {
    AppMethodBeat.i(126613);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl setComments %s", new Object[] { paramString });
    try
    {
      paramString = new j(new JSONObject(paramString));
      g.aiU().a(paramString, 0);
      paramString = eqV().toString();
      AppMethodBeat.o(126613);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126613);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String showNavBarShadow(String paramString)
  {
    AppMethodBeat.i(126615);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl showNavBarShadow %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("color");
      str = str.substring(1, str.length());
      int i = (int)(paramString.getDouble("alpha") * 255.0D);
      int j = Integer.parseInt(str, 16);
      this.Byi.ik(j, i);
      paramString = eqV().toString();
      AppMethodBeat.o(126615);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      if (paramString.keys() != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          long l = paramString.optLong(str);
          com.tencent.mm.plugin.topstory.ui.d.c(this.dLe, str, l);
        }
      }
      paramString = eqV().toString();
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "stage", new Object[0]);
      paramString = eqW().toString();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", new Object[] { paramString });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", new Object[] { str, localObject });
        localIntent.putExtra("srcUsername", paramString.optString("srcUserName"));
        localIntent.putExtra("geta8key_scene", 64);
        int j = paramString.optInt("openScene", 10000);
        int k = paramString.optInt("subScene", -1);
        int m = paramString.optInt("itemType", -1);
        localIntent.putExtra(e.m.IUR, m);
        if ((m == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zb(m)))
        {
          if (paramString.has("srcUserName")) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid srcUserName");
          i = 0;
          if (i != 0)
          {
            localObject = new Bundle();
            x localx = new x();
            localx.doK = paramString.optString("srcUserName");
            localx.hDe = paramString.optString("srcDisplayName");
            localx.hDg.url = str;
            localx.hDg.title = paramString.optString("title");
            localx.hDg.hDo = paramString.optString("digest");
            localx.hDg.hDm = paramString.optString("cover");
            localx.hDg.type = m;
            localx.hDg.time = paramString.optInt("pubTime");
            localx.hDg.hDq = paramString.optInt("duration");
            localx.hDg.videoWidth = paramString.optInt("videoWidth");
            localx.hDg.videoHeight = paramString.optInt("videoHeight");
            localx.hDg.hzm = paramString.optString("vid");
            localx.s((Bundle)localObject);
            localIntent.putExtras((Bundle)localObject);
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        if ((((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(7)) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.Byi.dhO(), str, m, j, k, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
          paramString = eqV().toString();
          AppMethodBeat.o(126595);
          return paramString;
          if (!paramString.has("cover"))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid cover");
            i = 0;
            continue;
          }
          if (!paramString.has("vid"))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid vid");
            i = 0;
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewMpUI");
          com.tencent.mm.bs.d.b(this.Byi.dhO(), "webview", ".ui.tools.WebviewMpUI", localIntent);
          continue;
        }
        int i = 1;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeReport", new Object[0]);
        paramString = eqW().toString();
        AppMethodBeat.o(126595);
        return paramString;
      }
    }
  }
  
  @JavascriptInterface
  public final String updateNumReddot(String paramString)
  {
    AppMethodBeat.i(126612);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl updateNumReddot %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      long l = paramString.getLong("latestTimeStamp");
      int i = paramString.getInt("seq");
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().h(l, i, false);
      paramString = eqV().toString();
      AppMethodBeat.o(126612);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "lxl updateNumReddot", new Object[0]);
      paramString = eqW().toString();
      AppMethodBeat.o(126612);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String updateReddotTimeStamps(String paramString)
  {
    AppMethodBeat.i(126599);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().Bc(paramString.optLong("reddotTimeStamps", 0L));
      paramString = eqV().toString();
      AppMethodBeat.o(126599);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "updateReddotTimeStamps", new Object[0]);
      paramString = eqW().toString();
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
      if (this.Byv)
      {
        this.Byv = false;
        if (this.Byi != null) {
          this.Byi.epf();
        }
        com.tencent.mm.plugin.topstory.ui.d.c(this.dLe, "webViewUIReady", System.currentTimeMillis());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", new Object[] { com.tencent.mm.plugin.topstory.ui.d.a(this.dLe) });
      }
      paramString = eqV().toString();
      AppMethodBeat.o(126601);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = eqW().toString();
      AppMethodBeat.o(126601);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.e
 * JD-Core Version:    0.7.0.1
 */