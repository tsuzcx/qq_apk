package com.tencent.mm.plugin.topstory.ui.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.websearch.webview.b<eii>
{
  private c Gqx;
  WebSearchWebView Gqy;
  private boolean Gqz = true;
  private eii eel;
  
  public e(WebSearchWebView paramWebSearchWebView, eii parameii, c paramc)
  {
    this.Gqy = paramWebSearchWebView;
    this.eel = parameii;
    this.Gqx = paramc;
  }
  
  private com.tencent.mm.plugin.topstory.ui.home.a fzV()
  {
    if (this.IHe != null) {
      return (com.tencent.mm.plugin.topstory.ui.home.a)this.IHe;
    }
    return null;
  }
  
  public final void aTA(String paramString)
  {
    AppMethodBeat.i(126603);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("json", paramString);
      localJSONObject.put("newQuery", this.Gqz);
      localJSONObject.put("isCache", false);
      MMHandlerThread.postToMainThread(new e.1(this, localJSONObject));
      AppMethodBeat.o(126603);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126603);
    }
  }
  
  public final void aTI(final String paramString)
  {
    AppMethodBeat.i(126606);
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  public final void aTJ(String paramString)
  {
    AppMethodBeat.i(126617);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramString);
      localJSONObject.put("sessionId", this.eel.sessionId);
      localJSONObject.put("subSessionId", this.eel.dVO);
      localJSONObject.put("scene", this.eel.scene);
      MMHandlerThread.postToMainThread(new e.9(this, localJSONObject));
      AppMethodBeat.o(126617);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126617);
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
      MMHandlerThread.postToMainThread(new Runnable()
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
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyNumReddotChange " + paramString1.getMessage());
      AppMethodBeat.o(126604);
    }
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  @JavascriptInterface
  public final String doGoToRecVideoList(String paramString)
  {
    AppMethodBeat.i(126600);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", new Object[] { paramString });
    try
    {
      paramString = h.br(new JSONObject(paramString));
      if (fzV() != null) {
        ai.a(fzV().eeF(), paramString, 1);
      }
      paramString = fYQ().toString();
      AppMethodBeat.o(126600);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doGoToRecVideoList", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(126600);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final void doNegFeedback(String paramString)
  {
    AppMethodBeat.i(126621);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doNegFeedback %s", new Object[] { paramString });
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
      ((com.tencent.mm.plugin.topstory.ui.b)g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().cD(i, str);
      AppMethodBeat.o(126621);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doNegFeedback", new Object[0]);
      AppMethodBeat.o(126621);
    }
  }
  
  @JavascriptInterface
  public final String fetchNumReddot(String paramString)
  {
    AppMethodBeat.i(126609);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", new Object[] { paramString });
    try
    {
      int i = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw();
      eiq localeiq = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxx();
      c(localeiq.msgId, paramString.msgId, localeiq.jlm, paramString.jlm, i, paramString.extInfo);
      paramString = fYQ().toString();
      AppMethodBeat.o(126609);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126609);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String fetchReddot(String paramString)
  {
    AppMethodBeat.i(126610);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchReddot %s", new Object[] { paramString });
    try
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
      if (paramString != null) {
        q(paramString.msgId, paramString.NhO, paramString.type);
      }
      paramString = fYQ().toString();
      AppMethodBeat.o(126610);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126610);
    }
    return paramString;
  }
  
  public final void fzW()
  {
    AppMethodBeat.i(126608);
    MMHandlerThread.postToMainThread(new Runnable()
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
  public final String getSearchData(String paramString)
  {
    AppMethodBeat.i(126590);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", new Object[] { paramString });
    if (fzV() != null) {
      fzV().fyj();
    }
    com.tencent.mm.plugin.topstory.ui.c.c(this.eel, "getSearchData", System.currentTimeMillis());
    Object localObject1;
    eii localeii;
    boolean bool;
    int i;
    try
    {
      localObject1 = new JSONObject(paramString);
      localeii = new eii();
      localeii.sGQ = this.eel.sGQ;
      localeii.dDv = ((JSONObject)localObject1).optString("query", "");
      localeii.offset = ((JSONObject)localObject1).optInt("offset", 0);
      localeii.scene = ((JSONObject)localObject1).optInt("scene", 21);
      localeii.sessionId = ((JSONObject)localObject1).optString("sessionId", "");
      localeii.dVO = ((JSONObject)localObject1).optString("subSessionId", "");
      localeii.hes = ((JSONObject)localObject1).optString("searchId", "");
      localeii.dPI = ((JSONObject)localObject1).optString("requestId", "");
      localeii.channelId = ((JSONObject)localObject1).optInt("tagId", 0);
      localeii.IDW = ((JSONObject)localObject1).optString("navigationId", "");
      localeii.wib = ai.ait();
      bool = ((JSONObject)localObject1).optBoolean("directRequest", false);
      paramString = ((JSONObject)localObject1).optString("extReqParams", "");
      localObject1 = ((JSONObject)localObject1).optString("homeMsgId", "");
      Object localObject3;
      if (!Util.isNullOrNil(paramString))
      {
        paramString = new JSONArray(paramString);
        i = 0;
        while (i < paramString.length())
        {
          localObject2 = paramString.getJSONObject(i);
          localObject3 = new aca();
          ((aca)localObject3).key = ((JSONObject)localObject2).optString("key", "");
          ((aca)localObject3).LmC = ((JSONObject)localObject2).optInt("uintValue", 0);
          ((aca)localObject3).LmD = ((JSONObject)localObject2).optString("textValue", "");
          localeii.IDO.add(localObject3);
          i += 1;
        }
      }
      if (((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).chQ().size() > 0)
      {
        localeii.NhC = new beo();
        paramString = ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).chQ().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (BallInfo)paramString.next();
          if (((BallInfo)localObject2).type == 2)
          {
            localObject2 = ((BallInfo)localObject2).eT("rawUrl", "");
            if ((!Util.isNullOrNil((String)localObject2)) && ((((String)localObject2).startsWith("https://" + WeChatHosts.domainString(2131761726) + "/s")) || (((String)localObject2).startsWith("http://" + WeChatHosts.domainString(2131761726) + "/s"))))
            {
              localObject3 = new bep();
              ((bep)localObject3).LOr = ((String)localObject2);
              localeii.NhC.LOq.add(localObject3);
              Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "add float ball url %s", new Object[] { localObject2 });
            }
          }
        }
      }
      if (localeii.channelId != 100) {
        break label822;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchData", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(126590);
      return paramString;
    }
    Object localObject2 = this.Gqx;
    if (((c)localObject2).Gqo == null)
    {
      paramString = null;
      if ((!Util.isNullOrNil(paramString)) && (!bool))
      {
        aTA(paramString);
        paramString = fYQ().toString();
        AppMethodBeat.o(126590);
        return paramString;
      }
    }
    else
    {
      if ((!((c)localObject2).Gqo.Gqw.sessionId.equals(localeii.sessionId)) || (System.currentTimeMillis() - ((c)localObject2).Gqo.pnE > 60000L)) {
        break label861;
      }
    }
    label822:
    label861:
    for (paramString = ((c)localObject2).Gqo.Gqv;; paramString = null)
    {
      ((c)localObject2).Gqo = null;
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
        break;
      }
      Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", new Object[] { Integer.valueOf(paramString.length()) });
      break;
      paramString = this.Gqx;
      if (fzV() == null) {}
      for (i = 0;; i = fzV().fyn())
      {
        paramString.a(localeii, true, bool, i, (String)localObject1);
        break;
      }
      paramString = this.Gqx;
      if (fzV() == null) {}
      for (i = 0;; i = fzV().fyn())
      {
        paramString.a(localeii, true, bool, i);
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
              break label243;
            }
            localObject = ((JSONObject)localObject).getString("userName");
            String str = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localObject);
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
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchDisplayNameList", new Object[0]);
        paramString = fYR().toString();
        AppMethodBeat.o(170150);
        return paramString;
      }
      paramString = "";
      continue;
      label243:
      Object localObject = "";
    }
  }
  
  @JavascriptInterface
  public final String hideNavBarShadow(String paramString)
  {
    AppMethodBeat.i(126616);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", new Object[] { paramString });
    try
    {
      fzV().fyl();
      paramString = fYQ().toString();
      AppMethodBeat.o(126616);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126616);
    }
    return paramString;
  }
  
  public final void m(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(126607);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
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
        Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected json exception: " + paramString1.getMessage());
      }
    }
  }
  
  @JavascriptInterface
  public final String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(236416);
    try
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      Object localObject = new JSONObject(paramString);
      paramString = new JSONObject();
      paramString.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
      paramString.put("extInfo", new JSONObject(((JSONObject)localObject).optString("extInfo", "")));
      paramString.put("extraInfo", ((JSONObject)localObject).optString("extraInfo", ""));
      localObject = new Intent();
      ((Intent)localObject).putExtra("tab_type", 7);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((aj)g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramString.toString(), (Intent)localObject);
      paramString = fYQ().toString();
      AppMethodBeat.o(236416);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(236416);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(236415);
    try
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString).optString("userName", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", paramString);
      localIntent.putExtra("key_from_profile_share_scene", 15);
      localIntent.putExtra("key_enter_profile_type", 1);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(7, 2, 32, localIntent);
      ((aj)g.ah(aj.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
      paramString = fYQ().toString();
      AppMethodBeat.o(236415);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(236415);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openProfileWithOpenId(String paramString)
  {
    AppMethodBeat.i(126598);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openProfileWithOpenId %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).getString("openId");
      if (!Util.isNullOrNil(paramString)) {
        com.tencent.mm.plugin.topstory.ui.c.aTz(paramString);
      }
      paramString = fYQ().toString();
      AppMethodBeat.o(126598);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126598);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(126620);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openSearchWebView %s", new Object[] { paramString });
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
          paramString = fYQ().toString();
          AppMethodBeat.o(126620);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString = fYR().toString();
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
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s srcUserName = %s", new Object[] { localObject1, paramString, localObject2 });
      com.tencent.mm.br.c.b(fzV().eeF(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject3);
      continue;
      localObject3 = ((JSONObject)localObject1).optString("query", "");
      int j = ((JSONObject)localObject1).optInt("scene", 0);
      String str1 = ((JSONObject)localObject1).optString("sessionId", "");
      String str2 = ai.afq(j);
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
            localObject2 = new eii();
            ((eii)localObject2).sGQ = com.tencent.mm.plugin.topstory.ui.c.fyi();
            ((eii)localObject2).scene = j;
            ((eii)localObject2).hes = "";
            ((eii)localObject2).dDv = ((String)localObject3);
            ((eii)localObject2).sessionId = str1;
            ((eii)localObject2).dVO = str1;
            ((eii)localObject2).Nhz = 2;
            ((eii)localObject2).url = h.n((HashMap)localObject4);
            ((eii)localObject2).nbg = paramString;
            ((eii)localObject2).channelId = k;
            if (bool) {
              ((eii)localObject2).dPI = ((String)localObject1);
            }
            ((eii)localObject2).wib = ai.ait();
            paramString = new aca();
            paramString.key = "rec_category";
            paramString.LmC = k;
            paramString.LmD = String.valueOf(k);
            ((eii)localObject2).IDO.add(paramString);
            ((eii)localObject2).wwG = i;
            localObject3 = MMApplicationContext.getContext();
            if (!bool) {
              break label749;
            }
            paramString = (String)localObject1;
            com.tencent.mm.plugin.topstory.ui.c.a((Context)localObject3, (eii)localObject2, paramString, bool);
          }
          catch (JSONException paramString)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "", new Object[0]);
            break label738;
          }
          i = ((JSONObject)localObject1).optInt("scene", 53);
          j = ((JSONObject)localObject1).optInt("subScene", 5);
          fzV().jo(i, j);
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
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWeAppPage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1115;
      ((r)g.af(r.class)).a(MMApplicationContext.getContext(), paramString.getString("userName"), paramString.getString("appid"), paramString.optInt("debugMode", 0), 0, paramString.getString("path"), localAppBrandStatObject);
      paramString = fYQ().toString();
      AppMethodBeat.o(126622);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWeAppPage", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(126622);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openWowColikeSetting(String paramString)
  {
    AppMethodBeat.i(126623);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWowColikeSetting %s", new Object[] { paramString });
    try
    {
      com.tencent.mm.plugin.topstory.ui.c.hw(MMApplicationContext.getContext());
      paramString = fYQ().toString();
      AppMethodBeat.o(126623);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWowColikeSetting", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(126623);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String postComments(String paramString)
  {
    AppMethodBeat.i(126614);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl postComments %s", new Object[] { paramString });
    try
    {
      paramString = new f(new JSONObject(paramString));
      g.azz().a(paramString, 0);
      paramString = fYQ().toString();
      AppMethodBeat.o(126614);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126614);
    }
    return paramString;
  }
  
  public final void q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(236413);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("msgId", paramString);
      localJSONObject.put("latestTimeStamp", paramLong);
      localJSONObject.put("reddotType", paramInt);
      MMHandlerThread.postToMainThread(new Runnable()
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
      AppMethodBeat.o(236413);
      return;
    }
    catch (JSONException paramString)
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
      AppMethodBeat.o(236413);
    }
  }
  
  @JavascriptInterface
  public final String queryWebCommCgi(String paramString)
  {
    AppMethodBeat.i(126611);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new com.tencent.mm.plugin.topstory.a.c.a(paramString.optString("requestId", ""), paramString.optString("commReq", ""));
      g.azz().a(paramString, 0);
      paramString = fYQ().toString();
      AppMethodBeat.o(126611);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126611);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String renderFinish(String paramString)
  {
    AppMethodBeat.i(126602);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "renderFinish %s", new Object[] { paramString });
    try
    {
      fzV().fym();
      paramString = fYQ().toString();
      AppMethodBeat.o(126602);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "renderFinish error", new Object[0]);
      }
    }
  }
  
  @JavascriptInterface
  public final String searchDataHasResult(String paramString)
  {
    AppMethodBeat.i(126591);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "searchDataHasResult %s", new Object[] { paramString });
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
        g.aAh().azQ().set(ar.a.Ohv, Integer.valueOf(1));
      }
      for (;;)
      {
        paramString = fYQ().toString();
        AppMethodBeat.o(126591);
        return paramString;
        label90:
        g.aAh().azQ().set(ar.a.Ohv, Integer.valueOf(0));
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "searchDataHasResult", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(126591);
    }
  }
  
  @JavascriptInterface
  public final String setComments(String paramString)
  {
    AppMethodBeat.i(126613);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl setComments %s", new Object[] { paramString });
    try
    {
      paramString = new j(new JSONObject(paramString));
      g.azz().a(paramString, 0);
      paramString = fYQ().toString();
      AppMethodBeat.o(126613);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126613);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String shareImage(final String paramString)
  {
    AppMethodBeat.i(236414);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("imagePath");
      if (TextUtils.isEmpty(paramString))
      {
        paramString = fYR().toString();
        AppMethodBeat.o(236414);
        return paramString;
      }
      final MMActivity localMMActivity = fzV().eeF();
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(localMMActivity, 1, false);
      locale.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(236407);
          paramAnonymousm.aS(0, 2131767110, 2131689844);
          paramAnonymousm.aS(1, 2131767111, 2131689830);
          AppMethodBeat.o(236407);
        }
      };
      locale.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(236408);
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(236408);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage ItemId click:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            e.a(e.this, localMMActivity, paramString);
            AppMethodBeat.o(236408);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 0) {
            e.b(e.this, localMMActivity, paramString);
          }
          AppMethodBeat.o(236408);
        }
      };
      locale.PGl = new e.b()
      {
        public final void onDismiss() {}
      };
      locale.dGm();
      paramString = fYQ().toString();
      AppMethodBeat.o(236414);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(236414);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String showNavBarShadow(String paramString)
  {
    AppMethodBeat.i(126615);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl showNavBarShadow %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("color");
      str = str.substring(1, str.length());
      int i = (int)(paramString.getDouble("alpha") * 255.0D);
      int j = Integer.parseInt(str, 16);
      fzV().jn(j, i);
      paramString = fYQ().toString();
      AppMethodBeat.o(126615);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
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
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      if (paramString.keys() != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          long l = paramString.optLong(str);
          com.tencent.mm.plugin.topstory.ui.c.c(this.eel, str, l);
        }
      }
      paramString = fYQ().toString();
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "stage", new Object[0]);
      paramString = fYR().toString();
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
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", new Object[] { paramString });
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
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", new Object[] { str, localObject });
        localIntent.putExtra("srcUsername", paramString.optString("srcUserName"));
        localIntent.putExtra("geta8key_scene", 64);
        int j = paramString.optInt("openScene", 10000);
        int k = paramString.optInt("subScene", -1);
        int m = paramString.optInt("itemType", -1);
        localIntent.putExtra(e.p.OzA, m);
        if ((m == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(m)))
        {
          if (paramString.has("srcUserName")) {
            continue;
          }
          Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid srcUserName");
          i = 0;
          if (i != 0)
          {
            localObject = new Bundle();
            x localx = new x();
            localx.dHc = paramString.optString("srcUserName");
            localx.iAg = paramString.optString("srcDisplayName");
            localx.iAi.url = str;
            localx.iAi.title = paramString.optString("title");
            localx.iAi.iAq = paramString.optString("digest");
            localx.iAi.iAo = paramString.optString("cover");
            localx.iAi.type = m;
            localx.iAi.time = paramString.optInt("pubTime");
            localx.iAi.iAs = paramString.optInt("duration");
            localx.iAi.videoWidth = paramString.optInt("videoWidth");
            localx.iAi.videoHeight = paramString.optInt("videoHeight");
            localx.iAi.vid = paramString.optString("vid");
            localx.z((Bundle)localObject);
            localIntent.putExtras((Bundle)localObject);
          }
        }
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(7)) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(fzV().eeF(), str, m, j, k, localIntent)))
        {
          Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
          paramString = fYQ().toString();
          AppMethodBeat.o(126595);
          return paramString;
          if (!paramString.has("cover"))
          {
            Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid cover");
            i = 0;
            continue;
          }
          if (!paramString.has("vid"))
          {
            Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid vid");
            i = 0;
          }
        }
        else
        {
          Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewMpUI");
          com.tencent.mm.br.c.b(fzV().eeF(), "webview", ".ui.tools.WebviewMpUI", localIntent);
          continue;
        }
        int i = 1;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeReport", new Object[0]);
        paramString = fYR().toString();
        AppMethodBeat.o(126595);
        return paramString;
      }
    }
  }
  
  @JavascriptInterface
  public final String updateNumReddot(String paramString)
  {
    AppMethodBeat.i(126612);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl updateNumReddot %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      long l = paramString.getLong("latestTimeStamp");
      int i = paramString.getInt("seq");
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().j(l, i, false);
      paramString = fYQ().toString();
      AppMethodBeat.o(126612);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "lxl updateNumReddot", new Object[0]);
      paramString = fYR().toString();
      AppMethodBeat.o(126612);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String updateReddotTimeStamps(String paramString)
  {
    AppMethodBeat.i(126599);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().KH(paramString.optLong("reddotTimeStamps", 0L));
      paramString = fYQ().toString();
      AppMethodBeat.o(126599);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "updateReddotTimeStamps", new Object[0]);
      paramString = fYR().toString();
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
      if (this.Gqz)
      {
        this.Gqz = false;
        if (fzV() != null) {
          fzV().fyk();
        }
        com.tencent.mm.plugin.topstory.ui.c.c(this.eel, "webViewUIReady", System.currentTimeMillis());
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", new Object[] { com.tencent.mm.plugin.topstory.ui.c.a(this.eel) });
      }
      paramString = fYQ().toString();
      AppMethodBeat.o(126601);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fYR().toString();
      AppMethodBeat.o(126601);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.e
 * JD-Core Version:    0.7.0.1
 */