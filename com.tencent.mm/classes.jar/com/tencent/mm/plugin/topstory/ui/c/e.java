package com.tencent.mm.plugin.topstory.ui.c;

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
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.message.x;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.q;
import com.tencent.mm.plugin.websearch.webview.q.a.a;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.websearch.webview.b<fnt>
{
  private c TPT;
  WebSearchWebView TPU;
  public LinkedList<aem> TPV;
  private boolean TPW;
  private fnt ieC;
  
  public e(WebSearchWebView paramWebSearchWebView, fnt paramfnt, c paramc, LinkedList<aem> paramLinkedList)
  {
    super((byte)0);
    AppMethodBeat.i(271706);
    this.TPV = new LinkedList();
    this.TPW = true;
    this.TPU = paramWebSearchWebView;
    this.ieC = paramfnt;
    this.TPT = paramc;
    this.TPV = paramLinkedList;
    AppMethodBeat.o(271706);
  }
  
  private com.tencent.mm.plugin.topstory.ui.home.a hOX()
  {
    if (this.WrO != null) {
      return (com.tencent.mm.plugin.topstory.ui.home.a)this.WrO;
    }
    return null;
  }
  
  private void n(final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(271712);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyJsEvent, fun = %s, granted = %s, dialogShowed = %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271698);
        Object localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("granted", paramBoolean1);
          ((JSONObject)localObject).put("retCode", 0);
          ((JSONObject)localObject).put("dialogShowed", paramBoolean2);
          label43:
          localObject = ((JSONObject)localObject).toString();
          a.a(e.this, paramString, (String)localObject);
          AppMethodBeat.o(271698);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label43;
        }
      }
    });
    AppMethodBeat.o(271712);
  }
  
  public final void b(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(271745);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s, %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tabInfo", paramString1);
      localJSONObject.put("contentReddot", paramInt1);
      localJSONObject.put("numberReddot", paramInt2);
      localJSONObject.put("msgId", paramString2);
      localJSONObject.put("isByScroll", paramBoolean);
      a.a(this, "onTabSelected", localJSONObject.toString());
      AppMethodBeat.o(271745);
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
  
  public final void beD(final String paramString)
  {
    AppMethodBeat.i(126606);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126585);
        a.a(e.this, "onWebCommendEnterFromFindPage", paramString);
        AppMethodBeat.o(126585);
      }
    });
    AppMethodBeat.o(126606);
  }
  
  public final void beE(String paramString)
  {
    AppMethodBeat.i(126617);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramString);
      localJSONObject.put("sessionId", this.ieC.sessionId);
      localJSONObject.put("subSessionId", this.ieC.hVn);
      localJSONObject.put("scene", this.ieC.scene);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271692);
          String str = String.format("javascript:window.activity_state_change && activity_state_change(%s)", new Object[] { localJSONObject.toString() });
          e.this.TPU.evaluateJavascript(str, null);
          AppMethodBeat.o(271692);
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
  
  public final void bev(String paramString)
  {
    AppMethodBeat.i(126603);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("json", paramString);
      localJSONObject.put("newQuery", this.TPW);
      localJSONObject.put("isCache", false);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126577);
          String str = localJSONObject.toString();
          a.a(e.this, "onSearchDataReady", str);
          com.tencent.mm.plugin.topstory.ui.d.c(e.a(e.this), "dataReady", com.tencent.mm.model.cn.bDw());
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
  public final void checkHaoKanCommentPermission(String paramString)
  {
    AppMethodBeat.i(271796);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanCommentPermission, params = %s.", new Object[] { paramString });
    paramString = null;
    try
    {
      WeakReference localWeakReference = AppForegroundDelegate.aCe();
      if (localWeakReference.get() != null) {
        paramString = (Context)localWeakReference.get();
      }
      if (paramString == null)
      {
        n("notifyHaoKanCommentPermission", false, false);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanCommentPermission, context = null.");
        AppMethodBeat.o(271796);
        return;
      }
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("tophitory_show_comment_dialog", false))
      {
        q.a(paramString, new q.a.a()
        {
          public final void hNq()
          {
            AppMethodBeat.i(271699);
            e.a(e.this, "notifyHaoKanCommentPermission", true);
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanCommentPermission, onPosition.");
            q.t(1L, 2L, 2L);
            AppMethodBeat.o(271699);
          }
          
          public final void hNr()
          {
            AppMethodBeat.i(271702);
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanCommentPermission, dismiss.");
            e.a(e.this, "notifyHaoKanCommentPermission", false);
            q.t(2L, 2L, 2L);
            AppMethodBeat.o(271702);
          }
        }, false);
        AppMethodBeat.o(271796);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
      AppMethodBeat.o(271796);
      return;
    }
    n("notifyHaoKanCommentPermission", true, false);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanCommentPermission, isgrant no dilaog.");
    AppMethodBeat.o(271796);
  }
  
  @JavascriptInterface
  public final void checkHaoKanPermission(String paramString)
  {
    AppMethodBeat.i(271795);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanPermission, params = %s.", new Object[] { paramString });
    paramString = null;
    WeakReference localWeakReference = AppForegroundDelegate.aCe();
    if (localWeakReference.get() != null) {
      paramString = (Context)localWeakReference.get();
    }
    if (paramString == null)
    {
      n("notifyHaoKanPermission", false, false);
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanPermission context = null.");
      AppMethodBeat.o(271795);
      return;
    }
    try
    {
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("tophitory_show_init_dialog", false))
      {
        q.a(paramString, new q.a.a()
        {
          public final void hNq()
          {
            AppMethodBeat.i(271701);
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanPermission onPosition");
            e.a(e.this, "notifyHaoKanPermission", true);
            q.t(1L, 1L, 2L);
            AppMethodBeat.o(271701);
          }
          
          public final void hNr()
          {
            AppMethodBeat.i(271704);
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanPermission, dismiss");
            e.a(e.this, "notifyHaoKanPermission", false);
            q.t(2L, 1L, 2L);
            AppMethodBeat.o(271704);
          }
        }, paramString.getString(c.g.top_story_video_click_haokan_education_ontop));
        AppMethodBeat.o(271795);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
      AppMethodBeat.o(271795);
      return;
    }
    n("notifyHaoKanPermission", true, false);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "checkHaoKanPermission, is grant no dilaog.");
    AppMethodBeat.o(271795);
  }
  
  @JavascriptInterface
  public final String doGoToRecVideoList(String paramString)
  {
    AppMethodBeat.i(126600);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", new Object[] { paramString });
    try
    {
      paramString = com.tencent.mm.plugin.topstory.a.g.bS(new JSONObject(paramString));
      if (hOX() != null) {
        aj.a(hOX().fWt(), paramString, 1);
      }
      paramString = iqR().toString();
      AppMethodBeat.o(126600);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doGoToRecVideoList", new Object[0]);
      paramString = fqu().toString();
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
      ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().dt(i, str);
      AppMethodBeat.o(126621);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "doNegFeedback", new Object[0]);
      AppMethodBeat.o(126621);
    }
  }
  
  public final int edC()
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
      int i = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMf();
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMh();
      fob localfob = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMi();
      c(localfob.msgId, paramString.msgId, localfob.oUj, paramString.oUj, i, paramString.extInfo);
      paramString = iqR().toString();
      AppMethodBeat.o(126609);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
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
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLV();
      if (paramString != null) {
        t(paramString.msgId, paramString.UGO, paramString.type);
      }
      paramString = iqR().toString();
      AppMethodBeat.o(126610);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(126610);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String getSearchData(String paramString)
  {
    AppMethodBeat.i(126590);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", new Object[] { paramString });
    if (hOX() != null) {
      hOX().hNc();
    }
    com.tencent.mm.plugin.topstory.ui.d.c(this.ieC, "getSearchData", com.tencent.mm.model.cn.bDw());
    fnt localfnt;
    Object localObject1;
    try
    {
      paramString = new JSONObject(paramString);
      localfnt = new fnt();
      localfnt.zIO = this.ieC.zIO;
      localfnt.hAB = paramString.optString("query", "");
      localfnt.offset = paramString.optInt("offset", 0);
      localfnt.scene = paramString.optInt("scene", 21);
      localfnt.sessionId = paramString.optString("sessionId", "");
      localfnt.hVn = paramString.optString("subSessionId", "");
      localfnt.mpa = paramString.optString("searchId", "");
      localfnt.hOG = paramString.optString("requestId", "");
      localfnt.channelId = paramString.optInt("tagId", 0);
      localfnt.Wot = paramString.optString("navigationId", "");
      localfnt.GtP = aj.gtA();
      localfnt.abNL = paramString.optBoolean("directRequest", false);
      localfnt.abNJ = paramString.optString("homeMsgId", "");
      localfnt.abNK = paramString.optString("redPointMsgId", "");
      paramString = paramString.optString("extReqParams", "");
      Object localObject2;
      if (!Util.isNullOrNil(paramString))
      {
        paramString = new JSONArray(paramString);
        i = 0;
        while (i < paramString.length())
        {
          localObject1 = paramString.getJSONObject(i);
          localObject2 = new aem();
          ((aem)localObject2).key = ((JSONObject)localObject1).optString("key", "");
          ((aem)localObject2).Zmx = ((JSONObject)localObject1).optInt("uintValue", 0);
          ((aem)localObject2).Zmy = ((JSONObject)localObject1).optString("textValue", "");
          localfnt.Wol.add(localObject2);
          i += 1;
        }
      }
      if ((this.TPV != null) && (!this.TPV.isEmpty())) {
        localfnt.Wol.addAll(this.TPV);
      }
      if (((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXM().size() > 0)
      {
        localfnt.abNI = new bzk();
        paramString = ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXM().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (BallInfo)paramString.next();
          if (((BallInfo)localObject1).type == 2)
          {
            localObject1 = ((BallInfo)localObject1).fy("rawUrl", "");
            if ((!Util.isNullOrNil((String)localObject1)) && ((((String)localObject1).startsWith("https://" + WeChatHosts.domainString(c.g.host_mp_weixin_qq_com) + "/s")) || (((String)localObject1).startsWith("http://" + WeChatHosts.domainString(c.g.host_mp_weixin_qq_com) + "/s"))))
            {
              localObject2 = new bzl();
              ((bzl)localObject2).aaiG = ((String)localObject1);
              localfnt.abNI.aaiF.add(localObject2);
              Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "add float ball url %s", new Object[] { localObject1 });
            }
          }
        }
      }
      paramString = i.agtt;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "getSearchData", new Object[0]);
      paramString = fqu().toString();
      AppMethodBeat.o(126590);
      return paramString;
    }
    int i = i.a(b.a.agqN, 0);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "channelId = %s directRequest = %s preRequestMode = %s", new Object[] { Integer.valueOf(localfnt.channelId), Boolean.valueOf(localfnt.abNL), Integer.valueOf(i) });
    boolean bool;
    if (i == 1)
    {
      paramString = this.TPT;
      bool = localfnt.abNL;
      if (hOX() == null)
      {
        i = 0;
        paramString.a(localfnt, true, bool, i);
      }
    }
    for (;;)
    {
      paramString = iqR().toString();
      AppMethodBeat.o(126590);
      return paramString;
      i = hOX().hNg();
      break;
      if (i == 2) {
        localfnt.abNL = false;
      }
      localObject1 = this.TPT;
      i = localfnt.channelId;
      paramString = (c.b)((c)localObject1).TPK.get(Integer.valueOf(i));
      if (paramString != null) {
        break label854;
      }
      paramString = null;
      label823:
      if ((Util.isNullOrNil(paramString)) || (localfnt.abNL)) {
        break label984;
      }
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "use cache callback");
      bev(paramString);
    }
    label854:
    Log.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromCache,channelId = ".concat(String.valueOf(i)));
    if ((paramString.TPS.sessionId.equals(localfnt.sessionId)) && (paramString.TPS.hOG.equals(localfnt.hOG)) && (com.tencent.mm.model.cn.bDw() - paramString.vCl <= 60000L)) {}
    for (paramString = paramString.TPR;; paramString = null)
    {
      ((c)localObject1).TPK.remove(Integer.valueOf(i));
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
        break label823;
      }
      Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", new Object[] { Integer.valueOf(paramString.length()) });
      break label823;
      label984:
      paramString = this.TPT;
      bool = localfnt.abNL;
      if (hOX() == null) {}
      for (i = 0;; i = hOX().hNg())
      {
        paramString.a(localfnt, true, bool, i);
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
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localObject);
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
        paramString = fqu().toString();
        AppMethodBeat.o(170150);
        return paramString;
      }
      paramString = "";
      continue;
      label243:
      Object localObject = "";
    }
  }
  
  public final void hOY()
  {
    AppMethodBeat.i(126608);
    MMHandlerThread.postToMainThread(new Runnable()
    {
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
      hOX().hNe();
      paramString = iqR().toString();
      AppMethodBeat.o(126616);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(126616);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final void onWebPageUrlExposed(String paramString)
  {
    AppMethodBeat.i(271791);
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        Log.d("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebPageUrlExposed %s", new Object[] { paramString });
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optJSONArray("urlList");
        if ((paramString == null) || (paramString.length() <= 0))
        {
          Log.e("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebPageUrlExposed url list is empty");
          AppMethodBeat.o(271791);
          return;
        }
        int j = ((JSONObject)localObject).optInt("bizType", 0);
        localObject = new ArrayList();
        int k = paramString.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject == null) {
            break label339;
          }
          String str = localJSONObject.optString("url", "");
          if (Util.isNullOrNil(str)) {
            break label339;
          }
          h.a locala = new h.a();
          locala.url = str;
          locala.extInfo = localJSONObject.optString("extInfo", "");
          locala.vAZ = 213;
          locala.vBa = localJSONObject.optInt("bizScene", 0);
          locala.vAY = localJSONObject.optString("prefetchId", "");
          ((ArrayList)localObject).add(locala);
          break label339;
        }
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebPageUrlExposed bizType: %s, preAuthInfoList size: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(((ArrayList)localObject).size()) });
        if (((ArrayList)localObject).isEmpty())
        {
          Log.e("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebPageUrlExposed preAuthList is empty");
          AppMethodBeat.o(271791);
          return;
        }
        if (j == 1)
        {
          ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ej((List)localObject);
          AppMethodBeat.o(271791);
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "onWebPageUrlExposed exception", new Object[0]);
        AppMethodBeat.o(271791);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ei((List)localObject);
      AppMethodBeat.o(271791);
      return;
      label339:
      i += 1;
    }
  }
  
  @JavascriptInterface
  public final String openFinderFeed(String paramString)
  {
    AppMethodBeat.i(271789);
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
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(7, 2, 25, (Intent)localObject);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramString.toString(), (Intent)localObject);
      paramString = iqR().toString();
      AppMethodBeat.o(271789);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = fqu().toString();
      AppMethodBeat.o(271789);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openFinderProfile(String paramString)
  {
    AppMethodBeat.i(271787);
    try
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", new Object[] { paramString });
      paramString = new JSONObject(paramString).optString("userName", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", paramString);
      localIntent.putExtra("key_from_profile_share_scene", 15);
      localIntent.putExtra("key_enter_profile_type", 1);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(7, 2, 32, localIntent);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderProfileUI(MMApplicationContext.getContext(), localIntent);
      paramString = iqR().toString();
      AppMethodBeat.o(271787);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openFinderProfile", new Object[0]);
      paramString = fqu().toString();
      AppMethodBeat.o(271787);
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
        com.tencent.mm.plugin.topstory.ui.d.beu(paramString);
      }
      paramString = iqR().toString();
      AppMethodBeat.o(126598);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
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
          paramString = iqR().toString();
          AppMethodBeat.o(126620);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString = fqu().toString();
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
      com.tencent.mm.br.c.b(hOX().fWt(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject3);
      continue;
      localObject3 = ((JSONObject)localObject1).optString("query", "");
      int j = ((JSONObject)localObject1).optInt("scene", 0);
      String str1 = ((JSONObject)localObject1).optString("sessionId", "");
      String str2 = aj.asV(j);
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
              break label746;
            }
            bool = true;
            localObject1 = String.valueOf(com.tencent.mm.model.cn.bDw());
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
            localObject2 = new fnt();
            ((fnt)localObject2).zIO = com.tencent.mm.plugin.topstory.ui.d.hNb();
            ((fnt)localObject2).scene = j;
            ((fnt)localObject2).mpa = "";
            ((fnt)localObject2).hAB = ((String)localObject3);
            ((fnt)localObject2).sessionId = str1;
            ((fnt)localObject2).hVn = str1;
            ((fnt)localObject2).tBy = 2;
            ((fnt)localObject2).url = com.tencent.mm.plugin.topstory.a.g.t((HashMap)localObject4);
            ((fnt)localObject2).tgw = paramString;
            ((fnt)localObject2).channelId = k;
            if (bool) {
              ((fnt)localObject2).hOG = ((String)localObject1);
            }
            ((fnt)localObject2).GtP = aj.gtA();
            paramString = new aem();
            paramString.key = "rec_category";
            paramString.Zmx = k;
            paramString.Zmy = String.valueOf(k);
            ((fnt)localObject2).Wol.add(paramString);
            ((fnt)localObject2).GRg = i;
            localObject3 = MMApplicationContext.getContext();
            if (!bool) {
              break label752;
            }
            paramString = (String)localObject1;
            com.tencent.mm.plugin.topstory.ui.d.a((Context)localObject3, (fnt)localObject2, paramString, bool);
          }
          catch (JSONException paramString)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "", new Object[0]);
            break label741;
          }
          i = ((JSONObject)localObject1).optInt("scene", 53);
          j = ((JSONObject)localObject1).optInt("subScene", 5);
          hOX().mo(i, j);
          continue;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          i = 0;
          continue;
          label741:
          paramString = null;
          continue;
          label746:
          boolean bool = false;
          continue;
          label752:
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
      ((t)com.tencent.mm.kernel.h.ax(t.class)).a(MMApplicationContext.getContext(), paramString.getString("userName"), paramString.getString("appid"), paramString.optInt("debugMode", 0), 0, paramString.getString("path"), localAppBrandStatObject);
      paramString = iqR().toString();
      AppMethodBeat.o(126622);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWeAppPage", new Object[0]);
      paramString = fqu().toString();
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
      com.tencent.mm.plugin.topstory.ui.d.ku(MMApplicationContext.getContext());
      paramString = iqR().toString();
      AppMethodBeat.o(126623);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "openWowColikeSetting", new Object[0]);
      paramString = fqu().toString();
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
      c.bT(new JSONObject(paramString));
      paramString = iqR().toString();
      AppMethodBeat.o(126614);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(126614);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String queryWebCommCgi(String paramString)
  {
    AppMethodBeat.i(126611);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      c.no(paramString.optString("requestId", ""), paramString.optString("commReq", ""));
      paramString = iqR().toString();
      AppMethodBeat.o(126611);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
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
      hOX().hNf();
      paramString = iqR().toString();
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
      if (com.tencent.mm.plugin.topstory.a.g.aoJ(i))
      {
        if (j <= 0) {
          break label91;
        }
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXv, Integer.valueOf(1));
      }
      for (;;)
      {
        paramString = iqR().toString();
        AppMethodBeat.o(126591);
        return paramString;
        label91:
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acXv, Integer.valueOf(0));
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "searchDataHasResult", new Object[0]);
      paramString = fqu().toString();
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
      c.bU(new JSONObject(paramString));
      paramString = iqR().toString();
      AppMethodBeat.o(126613);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(126613);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String shareImage(final String paramString)
  {
    AppMethodBeat.i(271758);
    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("imagePath");
      if (TextUtils.isEmpty(paramString)) {
        return paramString;
      }
      final MMActivity localMMActivity = hOX().fWt();
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(localMMActivity, 1, false);
      localf.Vtg = new u.g()
      {
        public final void onCreateMMMenu(s paramAnonymouss)
        {
          AppMethodBeat.i(271690);
          paramAnonymouss.bx(0, c.g.video_share_to_friend, c.f.bottomsheet_icon_transmit);
          paramAnonymouss.bx(1, c.g.video_share_to_sns, c.f.bottomsheet_icon_moment);
          AppMethodBeat.o(271690);
        }
      };
      localf.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(271689);
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(271689);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage ItemId click:%s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()) });
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            e.a(e.this, localMMActivity, paramString);
            AppMethodBeat.o(271689);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 0) {
            e.b(e.this, localMMActivity, paramString);
          }
          AppMethodBeat.o(271689);
        }
      };
      localf.aeLi = new f.b()
      {
        public final void onDismiss() {}
      };
      localf.dDn();
      return paramString;
    }
    finally
    {
      paramString = fqu().toString();
      AppMethodBeat.o(271758);
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
      hOX().mn(j, i);
      paramString = iqR().toString();
      AppMethodBeat.o(126615);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
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
          com.tencent.mm.plugin.topstory.ui.d.c(this.ieC, str, l);
        }
      }
      paramString = iqR().toString();
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "stage", new Object[0]);
      paramString = fqu().toString();
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
      localIntent.putExtra("KPublisherId", (String)localObject);
      localIntent.putExtra("srcUsername", paramString.optString("srcUserName"));
      localIntent.putExtra("geta8key_scene", 64);
      int i = paramString.optInt("openScene", 10000);
      int j = paramString.optInt("subScene", -1);
      int k = paramString.optInt("itemType", -1);
      localIntent.putExtra(f.s.adwW, k);
      localIntent.putExtra("KWebPrefetcherId", paramString.optString("prefetchId", ""));
      str = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e(str, i, j, (int)System.currentTimeMillis() / 1000);
      localIntent.putExtra("rawUrl", str);
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", new Object[] { str, localObject });
      if (k == 5)
      {
        localObject = new Bundle();
        x localx = new x();
        localx.hEE = paramString.optString("srcUserName");
        localx.nUF = paramString.optString("srcDisplayName");
        localx.nUG.url = str;
        localx.nUG.title = paramString.optString("title");
        localx.nUG.nUO = paramString.optString("digest");
        localx.nUG.nUM = paramString.optString("cover");
        localx.nUG.type = k;
        localx.nUG.time = paramString.optInt("pubTime");
        localx.nUG.nUQ = paramString.optInt("duration");
        localx.nUG.videoWidth = paramString.optInt("videoWidth");
        localx.nUG.videoHeight = paramString.optInt("videoHeight");
        localx.nUG.vid = paramString.optString("vid");
        localx.N((Bundle)localObject);
        localIntent.putExtras((Bundle)localObject);
      }
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(7)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(hOX().fWt(), str, k, i, j, localIntent))) {
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
      }
      for (;;)
      {
        paramString = iqR().toString();
        AppMethodBeat.o(126595);
        return paramString;
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewMpUI");
        com.tencent.mm.br.c.b(hOX().fWt(), "webview", ".ui.tools.WebviewMpUI", localIntent);
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "reportSearchRealTimeReport", new Object[0]);
      paramString = fqu().toString();
      AppMethodBeat.o(126595);
    }
  }
  
  public final void t(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(271740);
    try
    {
      final JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("msgId", paramString);
      localJSONObject.put("latestTimeStamp", paramLong);
      localJSONObject.put("reddotType", paramInt);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126583);
          String str = localJSONObject.toString();
          a.a(e.this, "notifyReddot", str);
          AppMethodBeat.o(126583);
        }
      });
      AppMethodBeat.o(271740);
      return;
    }
    catch (JSONException paramString)
    {
      Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + paramString.getMessage());
      AppMethodBeat.o(271740);
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
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().k(l, i, false);
      paramString = iqR().toString();
      AppMethodBeat.o(126612);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "lxl updateNumReddot", new Object[0]);
      paramString = fqu().toString();
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
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().wp(paramString.optLong("reddotTimeStamps", 0L));
      paramString = iqR().toString();
      AppMethodBeat.o(126599);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", paramString, "updateReddotTimeStamps", new Object[0]);
      paramString = fqu().toString();
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
      if (this.TPW)
      {
        this.TPW = false;
        if (hOX() != null) {
          hOX().hNd();
        }
        com.tencent.mm.plugin.topstory.ui.d.c(this.ieC, "webViewUIReady", com.tencent.mm.model.cn.bDw());
        paramString = i.agtt;
        if (i.a(b.a.agqO, 0) == 1) {
          Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", com.tencent.mm.plugin.topstory.ui.d.a(this.ieC));
        }
      }
      paramString = iqR().toString();
      AppMethodBeat.o(126601);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = fqu().toString();
      AppMethodBeat.o(126601);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.e
 * JD-Core Version:    0.7.0.1
 */