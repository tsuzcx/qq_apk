package com.tencent.mm.plugin.topstory.ui.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.x;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.websearch.webview.b<esk>
{
  private c Ndi;
  WebSearchWebView Ndj;
  public LinkedList<aci> Ndk;
  private boolean Ndl;
  private esk fYA;
  
  public e(WebSearchWebView paramWebSearchWebView, esk paramesk, c paramc, LinkedList<aci> paramLinkedList)
  {
    AppMethodBeat.i(206809);
    this.Ndk = new LinkedList();
    this.Ndl = true;
    this.Ndj = paramWebSearchWebView;
    this.fYA = paramesk;
    this.Ndi = paramc;
    this.Ndk = paramLinkedList;
    AppMethodBeat.o(206809);
  }
  
  private com.tencent.mm.plugin.topstory.ui.home.a grW()
  {
    if (this.PBs != null) {
      return (com.tencent.mm.plugin.topstory.ui.home.a)this.PBs;
    }
    return null;
  }
  
  public final void beY(String paramString)
  {
    AppMethodBeat.i(126603);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("json", paramString);
      localJSONObject.put("newQuery", this.Ndl);
      localJSONObject.put("isCache", false);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(126577);
          String str = localJSONObject.toString();
          a.a(e.this, "onSearchDataReady", str);
          com.tencent.mm.plugin.topstory.ui.d.c(e.a(e.this), "dataReady", System.currentTimeMillis());
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
  
  public final void bfg(final String paramString)
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
  
  public final void bfh(String paramString)
  {
    AppMethodBeat.i(126617);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramString);
      localJSONObject.put("sessionId", this.fYA.sessionId);
      localJSONObject.put("subSessionId", this.fYA.fPs);
      localJSONObject.put("scene", this.fYA.scene);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        @TargetApi(7)
        public final void run()
        {
          AppMethodBeat.i(205576);
          String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { localJSONObject.toString() });
          e.this.Ndj.evaluateJavascript(str, null);
          AppMethodBeat.o(205576);
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
  
  @JavascriptInterface
  public final String doGoToRecVideoList(String paramString)
  {
    AppMethodBeat.i(126600);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", new Object[] { paramString });
    try
    {
      paramString = com.tencent.mm.plugin.topstory.a.h.bA(new JSONObject(paramString));
      if (grW() != null) {
        ai.a(grW().eOa(), paramString, 1);
      }
      paramString = gRB().toString();
      AppMethodBeat.o(126600);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doGoToRecVideoList", new Object[0]);
      paramString = gRC().toString();
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
      ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().cE(i, str);
      AppMethodBeat.o(126621);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doNegFeedback", new Object[0]);
      AppMethodBeat.o(126621);
    }
  }
  
  public final int duR()
  {
    return 2;
  }
  
  @JavascriptInterface
  public final String fetchNumReddot(String paramString)
  {
    AppMethodBeat.i(126609);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", new Object[] { paramString });
    try
    {
      int i = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpp();
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpr();
      ess localess = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gps();
      c(localess.msgId, paramString.msgId, localess.mbp, paramString.mbp, i, paramString.extInfo);
      paramString = gRB().toString();
      AppMethodBeat.o(126609);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
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
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj();
      if (paramString != null) {
        q(paramString.msgId, paramString.Uuu, paramString.type);
      }
      paramString = gRB().toString();
      AppMethodBeat.o(126610);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
      AppMethodBeat.o(126610);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String getSearchData(String paramString)
  {
    AppMethodBeat.i(126590);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", new Object[] { paramString });
    if (grW() != null) {
      grW().gqg();
    }
    com.tencent.mm.plugin.topstory.ui.d.c(this.fYA, "getSearchData", System.currentTimeMillis());
    Object localObject1;
    esk localesk;
    boolean bool;
    int i;
    try
    {
      localObject1 = new JSONObject(paramString);
      localesk = new esk();
      localesk.wmL = this.fYA.wmL;
      localesk.fwe = ((JSONObject)localObject1).optString("query", "");
      localesk.offset = ((JSONObject)localObject1).optInt("offset", 0);
      localesk.scene = ((JSONObject)localObject1).optInt("scene", 21);
      localesk.sessionId = ((JSONObject)localObject1).optString("sessionId", "");
      localesk.fPs = ((JSONObject)localObject1).optString("subSessionId", "");
      localesk.jQi = ((JSONObject)localObject1).optString("searchId", "");
      localesk.fIY = ((JSONObject)localObject1).optString("requestId", "");
      localesk.channelId = ((JSONObject)localObject1).optInt("tagId", 0);
      localesk.Pym = ((JSONObject)localObject1).optString("navigationId", "");
      localesk.ARR = ai.anV();
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
          localObject3 = new aci();
          ((aci)localObject3).key = ((JSONObject)localObject2).optString("key", "");
          ((aci)localObject3).SnV = ((JSONObject)localObject2).optInt("uintValue", 0);
          ((aci)localObject3).SnW = ((JSONObject)localObject2).optString("textValue", "");
          localesk.Pye.add(localObject3);
          i += 1;
        }
      }
      if ((this.Ndk != null) && (!this.Ndk.isEmpty())) {
        localesk.Pye.addAll(this.Ndk);
      }
      if (((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).cvc().size() > 0)
      {
        localesk.Uui = new bls();
        paramString = ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).cvc().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (BallInfo)paramString.next();
          if (((BallInfo)localObject2).type == 2)
          {
            localObject2 = ((BallInfo)localObject2).fh("rawUrl", "");
            if ((!Util.isNullOrNil((String)localObject2)) && ((((String)localObject2).startsWith("https://" + WeChatHosts.domainString(c.g.host_mp_weixin_qq_com) + "/s")) || (((String)localObject2).startsWith("http://" + WeChatHosts.domainString(c.g.host_mp_weixin_qq_com) + "/s"))))
            {
              localObject3 = new blt();
              ((blt)localObject3).SWP = ((String)localObject2);
              localesk.Uui.SWO.add(localObject3);
              Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "add float ball url %s", new Object[] { localObject2 });
            }
          }
        }
      }
      if (localesk.channelId != 100) {
        break label852;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchData", new Object[0]);
      paramString = gRC().toString();
      AppMethodBeat.o(126590);
      return paramString;
    }
    Object localObject2 = this.Ndi;
    if (((c)localObject2).Nda == null)
    {
      paramString = null;
      if ((!Util.isNullOrNil(paramString)) && (!bool))
      {
        beY(paramString);
        paramString = gRB().toString();
        AppMethodBeat.o(126590);
        return paramString;
      }
    }
    else
    {
      if ((!((c)localObject2).Nda.Ndh.sessionId.equals(localesk.sessionId)) || (System.currentTimeMillis() - ((c)localObject2).Nda.swE > 60000L)) {
        break label894;
      }
    }
    label852:
    label894:
    for (paramString = ((c)localObject2).Nda.Ndg;; paramString = null)
    {
      ((c)localObject2).Nda = null;
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
        break;
      }
      Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", new Object[] { Integer.valueOf(paramString.length()) });
      break;
      paramString = this.Ndi;
      if (grW() == null) {}
      for (i = 0;; i = grW().gqk())
      {
        paramString.a(localesk, true, bool, i, (String)localObject1);
        break;
      }
      paramString = this.Ndi;
      if (grW() == null) {}
      for (i = 0;; i = grW().gqk())
      {
        paramString.a(localesk, true, bool, i, "");
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
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ((String)localObject);
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
        paramString = gRC().toString();
        AppMethodBeat.o(170150);
        return paramString;
      }
      paramString = "";
      continue;
      label243:
      Object localObject = "";
    }
  }
  
  public final void grX()
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
  public final String hideNavBarShadow(String paramString)
  {
    AppMethodBeat.i(126616);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", new Object[] { paramString });
    try
    {
      grW().gqi();
      paramString = gRB().toString();
      AppMethodBeat.o(126616);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
      AppMethodBeat.o(126616);
    }
    return paramString;
  }
  
  public final void o(String paramString1, int paramInt1, int paramInt2, String paramString2)
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
    AppMethodBeat.i(206829);
    try
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderFeed %s", new Object[] { paramString });
      Object localObject = new JSONObject(paramString);
      paramString = new JSONObject();
      paramString.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
      paramString.put("extInfo", new JSONObject(((JSONObject)localObject).optString("extInfo", "")));
      paramString.put("extraInfo", ((JSONObject)localObject).optString("extraInfo", ""));
      localObject = new Intent();
      ((Intent)localObject).putExtra("tab_type", 7);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramString.toString(), (Intent)localObject);
      paramString = gRB().toString();
      AppMethodBeat.o(206829);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = gRC().toString();
      AppMethodBeat.o(206829);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(206828);
    try
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString).optString("userName", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", paramString);
      localIntent.putExtra("key_from_profile_share_scene", 15);
      localIntent.putExtra("key_enter_profile_type", 1);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(7, 2, 32, localIntent);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
      paramString = gRB().toString();
      AppMethodBeat.o(206828);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = gRC().toString();
      AppMethodBeat.o(206828);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderView(String paramString)
  {
    AppMethodBeat.i(206830);
    try
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderView %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extInfo", new JSONObject(paramString.optString("extInfo", "")));
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderUI(MMApplicationContext.getContext(), localJSONObject.toString());
      paramString = gRB().toString();
      AppMethodBeat.o(206830);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderView", new Object[0]);
      paramString = gRC().toString();
      AppMethodBeat.o(206830);
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
        com.tencent.mm.plugin.topstory.ui.d.beX(paramString);
      }
      paramString = gRB().toString();
      AppMethodBeat.o(126598);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
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
          paramString = gRB().toString();
          AppMethodBeat.o(126620);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString = gRC().toString();
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
      com.tencent.mm.by.c.b(grW().eOa(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject3);
      continue;
      localObject3 = ((JSONObject)localObject1).optString("query", "");
      int j = ((JSONObject)localObject1).optInt("scene", 0);
      String str1 = ((JSONObject)localObject1).optString("sessionId", "");
      String str2 = ai.ane(j);
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
            localObject2 = new esk();
            ((esk)localObject2).wmL = com.tencent.mm.plugin.topstory.ui.d.gqf();
            ((esk)localObject2).scene = j;
            ((esk)localObject2).jQi = "";
            ((esk)localObject2).fwe = ((String)localObject3);
            ((esk)localObject2).sessionId = str1;
            ((esk)localObject2).fPs = str1;
            ((esk)localObject2).Uuf = 2;
            ((esk)localObject2).url = com.tencent.mm.plugin.topstory.a.h.q((HashMap)localObject4);
            ((esk)localObject2).qbv = paramString;
            ((esk)localObject2).channelId = k;
            if (bool) {
              ((esk)localObject2).fIY = ((String)localObject1);
            }
            ((esk)localObject2).ARR = ai.anV();
            paramString = new aci();
            paramString.key = "rec_category";
            paramString.SnV = k;
            paramString.SnW = String.valueOf(k);
            ((esk)localObject2).Pye.add(paramString);
            ((esk)localObject2).BkW = i;
            localObject3 = MMApplicationContext.getContext();
            if (!bool) {
              break label749;
            }
            paramString = (String)localObject1;
            com.tencent.mm.plugin.topstory.ui.d.a((Context)localObject3, (esk)localObject2, paramString, bool);
          }
          catch (JSONException paramString)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "", new Object[0]);
            break label738;
          }
          i = ((JSONObject)localObject1).optInt("scene", 53);
          j = ((JSONObject)localObject1).optInt("subScene", 5);
          grW().kA(i, j);
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
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(MMApplicationContext.getContext(), paramString.getString("userName"), paramString.getString("appid"), paramString.optInt("debugMode", 0), 0, paramString.getString("path"), localAppBrandStatObject);
      paramString = gRB().toString();
      AppMethodBeat.o(126622);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWeAppPage", new Object[0]);
      paramString = gRC().toString();
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
      com.tencent.mm.plugin.topstory.ui.d.iC(MMApplicationContext.getContext());
      paramString = gRB().toString();
      AppMethodBeat.o(126623);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWowColikeSetting", new Object[0]);
      paramString = gRC().toString();
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
      c.bB(new JSONObject(paramString));
      paramString = gRB().toString();
      AppMethodBeat.o(126614);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
      AppMethodBeat.o(126614);
    }
    return paramString;
  }
  
  public final void q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(206816);
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
      AppMethodBeat.o(206816);
      return;
    }
    catch (JSONException paramString)
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
      AppMethodBeat.o(206816);
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
      c.lG(paramString.optString("requestId", ""), paramString.optString("commReq", ""));
      paramString = gRB().toString();
      AppMethodBeat.o(126611);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
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
      grW().gqj();
      paramString = gRB().toString();
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
      if (com.tencent.mm.plugin.topstory.a.h.aju(i))
      {
        if (j <= 0) {
          break label91;
        }
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvL, Integer.valueOf(1));
      }
      for (;;)
      {
        paramString = gRB().toString();
        AppMethodBeat.o(126591);
        return paramString;
        label91:
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvL, Integer.valueOf(0));
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "searchDataHasResult", new Object[0]);
      paramString = gRC().toString();
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
      c.bC(new JSONObject(paramString));
      paramString = gRB().toString();
      AppMethodBeat.o(126613);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
      AppMethodBeat.o(126613);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String shareImage(final String paramString)
  {
    AppMethodBeat.i(206818);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("imagePath");
      if (TextUtils.isEmpty(paramString))
      {
        paramString = gRC().toString();
        AppMethodBeat.o(206818);
        return paramString;
      }
      final MMActivity localMMActivity = grW().eOa();
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(localMMActivity, 1, false);
      locale.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(203990);
          paramAnonymouso.aW(0, c.g.video_share_to_friend, c.f.bottomsheet_icon_transmit);
          paramAnonymouso.aW(1, c.g.video_share_to_sns, c.f.bottomsheet_icon_moment);
          AppMethodBeat.o(203990);
        }
      };
      locale.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(202695);
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(202695);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage ItemId click:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            e.a(e.this, localMMActivity, paramString);
            AppMethodBeat.o(202695);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 0) {
            e.b(e.this, localMMActivity, paramString);
          }
          AppMethodBeat.o(202695);
        }
      };
      locale.XbB = new e.b()
      {
        public final void onDismiss() {}
      };
      locale.eik();
      paramString = gRB().toString();
      AppMethodBeat.o(206818);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = gRC().toString();
      AppMethodBeat.o(206818);
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
      grW().kz(j, i);
      paramString = gRB().toString();
      AppMethodBeat.o(126615);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
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
          com.tencent.mm.plugin.topstory.ui.d.c(this.fYA, str, l);
        }
      }
      paramString = gRB().toString();
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "stage", new Object[0]);
      paramString = gRC().toString();
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
      int i = paramString.optInt("openScene", 10000);
      int j = paramString.optInt("subScene", -1);
      int k = paramString.optInt("itemType", -1);
      localIntent.putExtra(f.r.VSO, k);
      if (k == 5)
      {
        localObject = new Bundle();
        x localx = new x();
        localx.fzT = paramString.optString("srcUserName");
        localx.lpC = paramString.optString("srcDisplayName");
        localx.lpE.url = str;
        localx.lpE.title = paramString.optString("title");
        localx.lpE.lpM = paramString.optString("digest");
        localx.lpE.lpK = paramString.optString("cover");
        localx.lpE.type = k;
        localx.lpE.time = paramString.optInt("pubTime");
        localx.lpE.lpO = paramString.optInt("duration");
        localx.lpE.videoWidth = paramString.optInt("videoWidth");
        localx.lpE.videoHeight = paramString.optInt("videoHeight");
        localx.lpE.vid = paramString.optString("vid");
        localx.G((Bundle)localObject);
        localIntent.putExtras((Bundle)localObject);
      }
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(7)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(grW().eOa(), str, k, i, j, localIntent))) {
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
      }
      for (;;)
      {
        paramString = gRB().toString();
        AppMethodBeat.o(126595);
        return paramString;
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewMpUI");
        com.tencent.mm.by.c.b(grW().eOa(), "webview", ".ui.tools.WebviewMpUI", localIntent);
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeReport", new Object[0]);
      paramString = gRC().toString();
      AppMethodBeat.o(126595);
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
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().j(l, i, false);
      paramString = gRB().toString();
      AppMethodBeat.o(126612);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "lxl updateNumReddot", new Object[0]);
      paramString = gRC().toString();
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
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().Sd(paramString.optLong("reddotTimeStamps", 0L));
      paramString = gRB().toString();
      AppMethodBeat.o(126599);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "updateReddotTimeStamps", new Object[0]);
      paramString = gRC().toString();
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
      if (this.Ndl)
      {
        this.Ndl = false;
        if (grW() != null) {
          grW().gqh();
        }
        com.tencent.mm.plugin.topstory.ui.d.c(this.fYA, "webViewUIReady", System.currentTimeMillis());
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", new Object[] { com.tencent.mm.plugin.topstory.ui.d.a(this.fYA) });
      }
      paramString = gRB().toString();
      AppMethodBeat.o(126601);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = gRC().toString();
      AppMethodBeat.o(126601);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.e
 * JD-Core Version:    0.7.0.1
 */