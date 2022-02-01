package com.tencent.mm.plugin.webview.g;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.e.b;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "checkParam", "itemShowType", "data", "Lorg/json/JSONObject;", "doHandleMPPageAction", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "fillNativePageMPMsgInfo", "fillNativePagePosData", "context", "Landroid/content/Context;", "currentInfoStr", "density", "", "intent", "Landroid/content/Intent;", "isFullScreen", "plugin-webview_release"})
public final class g
{
  public static final g EpJ;
  private static final String TAG = "MicroMsg.WebViewNativePageUtil";
  
  static
  {
    AppMethodBeat.i(82516);
    EpJ = new g();
    TAG = "MicroMsg.WebViewNativePageUtil";
    AppMethodBeat.o(82516);
  }
  
  public static final void a(Context paramContext, String paramString, float paramFloat, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(82513);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82513);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("pos");
      if (paramString != null)
      {
        int i = ar.dX(paramContext);
        int n = ar.jN(paramContext);
        int j = (int)(paramString.optDouble("width") * paramFloat);
        int k = (int)(paramString.optDouble("height") * paramFloat);
        int m = (int)(paramString.optDouble("x") * paramFloat);
        double d1 = paramString.optDouble("y");
        double d2 = paramFloat;
        if (paramBoolean) {
          i = 0;
        }
        for (;;)
        {
          i = (int)(i + d1 * d2);
          paramIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", m).putExtra("img_gallery_top", i);
          n = a.iv(paramContext);
          ae.d(TAG, "fillNativePagePosData left %d, top %d, w %d, h %d, density %f,screenHeight %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat), Integer.valueOf(n) });
          AppMethodBeat.o(82513);
          return;
          i += n;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      ae.e(TAG, "fillNativePagePosData exp " + paramContext.getMessage());
      AppMethodBeat.o(82513);
    }
  }
  
  public static final void a(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175654);
    p.h(paramBundle, "bundle");
    p.h(paramJSONObject, "data");
    ae.i(TAG, "fillNativePageData itemShowType ".concat(String.valueOf(paramInt)));
    paramBundle.putString("url", paramJSONObject.optString("url"));
    if (paramJSONObject.has("item_show_type")) {
      paramBundle.putInt("item_show_type", paramJSONObject.getInt("item_show_type"));
    }
    if (paramJSONObject.has("scene"))
    {
      paramBundle.putInt("scene", paramJSONObject.optInt("scene"));
      paramBundle.putInt(e.b.JoV, paramJSONObject.optInt("scene"));
    }
    if (paramJSONObject.has("subscene"))
    {
      paramBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
      paramBundle.putInt(e.b.JoW, paramJSONObject.optInt("subscene"));
    }
    if (paramJSONObject.has("openType")) {
      paramBundle.putInt("openType", paramJSONObject.optInt("openType"));
    }
    if (paramJSONObject.has("currentInfo")) {
      paramBundle.putString("currentInfo", paramJSONObject.optString("currentInfo"));
    }
    if (paramJSONObject.has("channelSessionId")) {
      paramBundle.putString("biz_video_channel_session_id", paramJSONObject.optString("channelSessionId"));
    }
    paramBundle.putBoolean("isNativePage", true);
    paramBundle.putInt("biz_video_session_id", y.getSessionId());
    b(paramBundle, paramInt, paramJSONObject);
    AppMethodBeat.o(175654);
  }
  
  public static final boolean a(com.tencent.mm.plugin.webview.c.l paraml, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, com.tencent.mm.plugin.webview.stub.f paramf1)
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(199353);
    p.h(paraml, "msg");
    p.h(paramf, "msgHandler");
    Object localObject2 = paraml.xqN.get("action");
    if (localObject2 == null)
    {
      paraml = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(199353);
      throw paraml;
    }
    Object localObject3 = (String)localObject2;
    ae.i(TAG, "doHandleMPPageAction action=%s", new Object[] { localObject3 });
    if (bu.isNullOrNil((String)localObject3))
    {
      paramf.a(paraml, "handleMPPageAction:fail action is empty", null);
      AppMethodBeat.o(199353);
      return false;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("action", (String)localObject3);
    long l;
    if (p.i("writeComment", localObject3))
    {
      localObject1 = paraml.xqN.get("style");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      localObject1 = (String)localObject1;
      localObject3 = paraml.xqN.get("comment_id");
      if (localObject3 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      l = bu.getLong((String)localObject3, 0L);
      ((Bundle)localObject2).putString("style", (String)localObject1);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.i("writeCommentReply", localObject3))
    {
      localObject1 = paraml.xqN.get("comment_id");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      l = bu.getLong((String)localObject1, 0L);
      localObject1 = paraml.xqN.get("reply_content");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      localObject1 = (String)localObject1;
      localObject3 = paraml.xqN.get("personal_comment_id");
      if (localObject3 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      i = bu.getInt((String)localObject3, 0);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      ((Bundle)localObject2).putString("reply_content", (String)localObject1);
      ((Bundle)localObject2).putInt("personal_comment_id", i);
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.i("share", localObject3))
    {
      try
      {
        ((Bundle)localObject2).putString("extInfo", (String)paraml.xqN.get("extInfo"));
        if (paramf1 != null) {
          paramf1.k(201, (Bundle)localObject2);
        }
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
      paramf.a(paraml, "handleMPPageAction:ok", null);
      AppMethodBeat.o(199353);
      return true;
    }
    if (p.i("showToast", localObject3))
    {
      localObject1 = paraml.xqN.get("wording");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      localObject1 = (String)localObject1;
      localObject3 = paraml.xqN.get("status");
      if (localObject3 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      localObject3 = (String)localObject3;
      ((Bundle)localObject2).putString("wording", (String)localObject1);
      ((Bundle)localObject2).putString("status", (String)localObject3);
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.i("switchVideo", localObject3))
    {
      localObject1 = paraml.Efz;
      p.g(localObject1, "msg.rawParams");
      a((Bundle)localObject2, 5, (JSONObject)localObject1);
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.i("createAdWebview", localObject3))
    {
      localObject1 = paraml.xqN.get("adUrl");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      ((Bundle)localObject2).putString("adUrl", (String)localObject1);
      if (paramf1 != null) {}
      for (;;)
      {
        try
        {
          paramf1 = paramf1.k(201, (Bundle)localObject2);
          if (paramf1 == null) {
            p.gkB();
          }
          boolean bool = paramf1.getBoolean("ret");
          j = bool;
        }
        catch (RemoteException paramf1)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          continue;
          paramf.a(paraml, "handleMPPageAction:fail", null);
          continue;
        }
        if (j == 0) {
          continue;
        }
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
        paramf1 = null;
      }
    }
    if (p.i("closeAdWebview", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.i("adWebviewReady", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if ((p.i("closeDotWebview", localObject3)) || (p.i("hideDotWebview", localObject3)))
    {
      try
      {
        localObject1 = paraml.xqN.get("webviewId");
        if (localObject1 == null)
        {
          paramf1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199353);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
        ((Bundle)localObject2).putInt("webviewId", bu.getInt((String)localObject1, 0));
        if (paramf1 != null) {
          paramf1.k(201, (Bundle)localObject2);
        }
      }
    }
    if (p.i("dotWebViewReady", localObject3))
    {
      try
      {
        localObject1 = paraml.xqN.get("webviewId");
        if (localObject1 == null)
        {
          paramf1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199353);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
        ((Bundle)localObject2).putInt("webviewId", bu.getInt((String)localObject1, 0));
        if (paramf1 != null) {
          paramf1.k(201, (Bundle)localObject2);
        }
      }
    }
    if (p.i("setDotScriptData", localObject3))
    {
      try
      {
        localObject1 = paraml.xqN.get("data");
        if (localObject1 == null)
        {
          paramf1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199353);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
        ((Bundle)localObject2).putString("data", (String)localObject1);
        if (paramf1 != null) {
          paramf1.k(201, (Bundle)localObject2);
        }
      }
    }
    if (p.i("getMPVideoState", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        for (paramf1 = paramf1.k(201, (Bundle)localObject2);; paramf1 = null)
        {
          localObject1 = new HashMap();
          if (paramf1 != null)
          {
            ((Map)localObject1).put("currentTime", Integer.valueOf(paramf1.getInt("currentTime")));
            ((Map)localObject1).put("duration", Integer.valueOf(paramf1.getInt("duration")));
            localObject2 = (Map)localObject1;
            localObject3 = paramf1.getString("state");
            p.g(localObject3, "retBundle.getString(\"state\")");
            ((Map)localObject2).put("state", localObject3);
            localObject2 = (Map)localObject1;
            paramf1 = paramf1.getString("vid");
            p.g(paramf1, "retBundle.getString(\"vid\")");
            ((Map)localObject2).put("vid", paramf1);
          }
          paramf.a(paraml, "handleMPPageAction:ok", (Map)localObject1);
          AppMethodBeat.o(199353);
          return true;
        }
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          paramf1 = (com.tencent.mm.plugin.webview.stub.f)localObject1;
        }
      }
    }
    if (p.i("sendMPPageData", localObject3))
    {
      localObject1 = paraml.xqN.get("data");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      ((Bundle)localObject2).putString("data", (String)localObject1);
      localObject1 = paraml.xqN.get("sendTo");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
      ((Bundle)localObject2).putString("sendTo", (String)localObject1);
      if (!paraml.xqN.containsKey("webviewId")) {
        break label2623;
      }
      localObject1 = paraml.xqN.get("webviewId");
      if (localObject1 == null)
      {
        paraml = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199353);
        throw paraml;
      }
    }
    label2618:
    label2623:
    for (i = bu.getInt((String)localObject1, 0);; i = 0)
    {
      ((Bundle)localObject2).putInt("webviewId", i);
      if (paramf1 != null) {}
      try
      {
        paramf1.k(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
      if (p.i("setWebviewBackground", localObject3))
      {
        localObject1 = paraml.xqN.get("backgroundColor");
        if (localObject1 == null)
        {
          paraml = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199353);
          throw paraml;
        }
        ((Bundle)localObject2).putString("backgroundColor", (String)localObject1);
        if (paramf1 != null) {}
        try
        {
          paramf1.k(201, (Bundle)localObject2);
          paramf.a(paraml, "handleMPPageAction:ok", null);
          AppMethodBeat.o(199353);
          return true;
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          }
        }
      }
      if (p.i("opPlayer", localObject3))
      {
        localObject1 = paraml.xqN.get("opType");
        if (localObject1 == null)
        {
          paraml = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199353);
          throw paraml;
        }
        ((Bundle)localObject2).putString("opType", (String)localObject1);
        if (paramf1 != null) {}
        try
        {
          paramf1.k(201, (Bundle)localObject2);
          paramf.a(paraml, "handleMPPageAction:ok", null);
          AppMethodBeat.o(199353);
          return true;
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            ae.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          }
        }
      }
      if (p.i("paySuccess", localObject3))
      {
        paramf1 = paraml.xqN;
        p.g(paramf1, "msg.params");
        if (paramf1.containsKey("fullUrl"))
        {
          paramf1 = paraml.xqN.get("fullUrl");
          if (paramf1 == null)
          {
            paraml = new d.v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(199353);
            throw paraml;
          }
        }
        for (paramf1 = (String)paramf1;; paramf1 = (String)paramf1)
        {
          localObject1 = paraml.xqN;
          p.g(localObject1, "msg.params");
          if (!((Map)localObject1).containsKey("itemShowType")) {
            break label2618;
          }
          localObject1 = paraml.xqN.get("itemShowType");
          if (localObject1 != null) {
            break;
          }
          paraml = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199353);
          throw paraml;
          paramf1 = paraml.xqN.get("url");
          if (paramf1 == null)
          {
            paraml = new d.v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(199353);
            throw paraml;
          }
        }
      }
      for (i = bu.getInt((String)localObject1, -1);; i = -1)
      {
        if (bu.isNullOrNil(paramf1))
        {
          paramf.a(paraml, "handleMPPageAction:fail_url_is_null", null);
          AppMethodBeat.o(199353);
          return true;
        }
        ((b)com.tencent.mm.kernel.g.ab(b.class)).cx(paramf1, i);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(199353);
        return true;
        if (p.i("isGPVersion", localObject3))
        {
          paramf1 = new HashMap();
          localObject1 = (Map)paramf1;
          if ((k.fnT()) || (com.tencent.mm.model.v.aAQ())) {
            i = 1;
          }
          ((Map)localObject1).put("GPVersion", Integer.valueOf(i));
          paramf.a(paraml, "handleMPPageAction:ok", (Map)paramf1);
          AppMethodBeat.o(199353);
          return true;
        }
        paramf.a(paraml, "handleMPPageAction:fail, action not support", null);
        AppMethodBeat.o(199353);
        return false;
      }
    }
  }
  
  public static final String b(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175656);
    p.h(paramJSONObject, "data");
    if ((paramInt == 5) && (((b)com.tencent.mm.kernel.g.ab(b.class)).zk(paramInt)) && (!com.tencent.mm.pluginsdk.ui.tools.x.fjk()))
    {
      if (!paramJSONObject.has("srcUserName"))
      {
        AppMethodBeat.o(175656);
        return "invalid srcUserName";
      }
      if (!paramJSONObject.has("srcDisplayName"))
      {
        AppMethodBeat.o(175656);
        return "invalid srcDisplayName";
      }
      if (!paramJSONObject.has("title"))
      {
        AppMethodBeat.o(175656);
        return "invalid title";
      }
      if (!paramJSONObject.has("pubTime"))
      {
        AppMethodBeat.o(175656);
        return "invalid cover";
      }
      if (!paramJSONObject.has("cover"))
      {
        AppMethodBeat.o(175656);
        return "invalid cover";
      }
      if (!paramJSONObject.has("vid"))
      {
        AppMethodBeat.o(175656);
        return "invalid vid";
      }
    }
    AppMethodBeat.o(175656);
    return "";
  }
  
  private static void b(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175655);
    p.h(paramBundle, "bundle");
    p.h(paramJSONObject, "data");
    com.tencent.mm.ah.x localx;
    if (paramInt == 5)
    {
      localx = new com.tencent.mm.ah.x();
      localx.dpP = paramJSONObject.optString("srcUserName");
      localx.hFW = paramJSONObject.optString("srcDisplayName");
      if (!paramJSONObject.has("url")) {
        break label208;
      }
      localx.hFY.url = paramJSONObject.optString("url");
    }
    for (;;)
    {
      localx.hFY.title = paramJSONObject.optString("title");
      localx.hFY.hGg = paramJSONObject.optString("digest");
      localx.hFY.hGe = paramJSONObject.optString("cover");
      localx.hFY.type = paramInt;
      localx.hFY.time = paramJSONObject.optInt("pubTime");
      localx.hFY.hGi = paramJSONObject.optInt("duration");
      localx.hFY.videoWidth = paramJSONObject.optInt("videoWidth");
      localx.hFY.videoHeight = paramJSONObject.optInt("videoHeight");
      localx.hFY.hCa = paramJSONObject.optString("vid");
      localx.t(paramBundle);
      AppMethodBeat.o(175655);
      return;
      label208:
      if (paramJSONObject.has("jumpUrl")) {
        localx.hFY.url = paramJSONObject.optString("jumpUrl");
      }
    }
  }
  
  public static final boolean b(com.tencent.mm.plugin.webview.c.l paraml, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, com.tencent.mm.plugin.webview.stub.f paramf1)
  {
    AppMethodBeat.i(199354);
    p.h(paraml, "msg");
    p.h(paramf, "msgHandler");
    if (!((b)com.tencent.mm.kernel.g.ab(b.class)).zl(5))
    {
      AppMethodBeat.o(199354);
      return false;
    }
    int i = paraml.Efz.optInt("itemType", -1);
    paramf = new Bundle();
    if (i >= 0)
    {
      paramf.putString("url", paraml.Efz.optString("jumpUrl"));
      paramf.putInt("item_show_type", i);
      paramf.putInt("scene", paraml.Efz.optInt("scene"));
      paramf.putInt("openType", -1);
      if ((i == 5) && (((b)com.tencent.mm.kernel.g.ab(b.class)).zk(i)))
      {
        JSONObject localJSONObject = paraml.Efz;
        p.g(localJSONObject, "msg.rawParams");
        if (bu.isNullOrNil(b(i, localJSONObject)))
        {
          if (paraml.Efz.has("currentInfo")) {
            paramf.putString("currentInfo", paraml.Efz.optString("currentInfo"));
          }
          if (paraml.Efz.has("scene")) {
            paramf.putInt(e.b.JoV, paraml.Efz.optInt("scene"));
          }
          paramf.putInt(e.b.JoW, paraml.Efz.optInt("subScene"));
          paramf.putString("KPublisherId", paraml.Efz.optString("publishId"));
          paramf.putInt("biz_video_session_id", y.getSessionId());
          paramf.putBoolean("isNativePage", true);
          paraml = paraml.Efz;
          p.g(paraml, "msg.rawParams");
          b(paramf, i, paraml);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1061L, 20L, 1L, false);
        }
      }
      if (paramf1 == null) {
        break label346;
      }
    }
    label346:
    for (paraml = paramf1.k(200, paramf); (paraml != null) && (paraml.getBoolean("success")); paraml = null)
    {
      AppMethodBeat.o(199354);
      return true;
      AppMethodBeat.o(199354);
      return false;
    }
    AppMethodBeat.o(199354);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.g
 * JD-Core Version:    0.7.0.1
 */