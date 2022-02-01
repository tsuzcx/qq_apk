package com.tencent.mm.plugin.webview.h;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "checkParam", "itemShowType", "data", "Lorg/json/JSONObject;", "doHandleMPPageAction", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "fillNativePageMPMsgInfo", "fillNativePagePosData", "context", "Landroid/content/Context;", "currentInfoStr", "density", "", "intent", "Landroid/content/Intent;", "isFullScreen", "plugin-webview_release"})
public final class g
{
  public static final g JcO;
  private static final String TAG = "MicroMsg.WebViewNativePageUtil";
  
  static
  {
    AppMethodBeat.i(82516);
    JcO = new g();
    TAG = "MicroMsg.WebViewNativePageUtil";
    AppMethodBeat.o(82516);
  }
  
  public static final void a(Context paramContext, String paramString, float paramFloat, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(82513);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82513);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("pos");
      if (paramString != null)
      {
        int i = au.eu(paramContext);
        int n = au.getStatusBarHeight(paramContext);
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
          n = a.jo(paramContext);
          Log.d(TAG, "fillNativePagePosData left %d, top %d, w %d, h %d, density %f,screenHeight %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat), Integer.valueOf(n) });
          AppMethodBeat.o(82513);
          return;
          i += n;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "fillNativePagePosData exp " + paramContext.getMessage());
      AppMethodBeat.o(82513);
    }
  }
  
  public static final void a(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175654);
    p.h(paramBundle, "bundle");
    p.h(paramJSONObject, "data");
    Log.i(TAG, "fillNativePageData itemShowType ".concat(String.valueOf(paramInt)));
    paramBundle.putString("url", paramJSONObject.optString("url"));
    if (paramJSONObject.has("item_show_type")) {
      paramBundle.putInt("item_show_type", paramJSONObject.getInt("item_show_type"));
    }
    if (paramJSONObject.has("scene"))
    {
      paramBundle.putInt("scene", paramJSONObject.optInt("scene"));
      paramBundle.putInt(e.b.OyQ, paramJSONObject.optInt("scene"));
    }
    if (paramJSONObject.has("subscene"))
    {
      paramBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
      paramBundle.putInt(e.b.OyR, paramJSONObject.optInt("subscene"));
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
    paramBundle.putInt("biz_video_session_id", ab.getSessionId());
    b(paramBundle, paramInt, paramJSONObject);
    AppMethodBeat.o(175654);
  }
  
  public static final boolean a(n paramn, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, com.tencent.mm.plugin.webview.stub.f paramf1)
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(210369);
    p.h(paramn, "msg");
    p.h(paramf, "msgHandler");
    Object localObject2 = paramn.params.get("action");
    if (localObject2 == null)
    {
      paramn = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(210369);
      throw paramn;
    }
    Object localObject3 = (String)localObject2;
    Log.i(TAG, "doHandleMPPageAction action=%s", new Object[] { localObject3 });
    if (Util.isNullOrNil((String)localObject3))
    {
      paramf.a(paramn, "handleMPPageAction:fail action is empty", null);
      AppMethodBeat.o(210369);
      return false;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("action", (String)localObject3);
    long l;
    if (p.j("writeComment", localObject3))
    {
      localObject1 = paramn.params.get("style");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      localObject1 = (String)localObject1;
      localObject3 = paramn.params.get("comment_id");
      if (localObject3 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      l = Util.getLong((String)localObject3, 0L);
      ((Bundle)localObject2).putString("style", (String)localObject1);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.j("writeCommentReply", localObject3))
    {
      localObject1 = paramn.params.get("comment_id");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      l = Util.getLong((String)localObject1, 0L);
      localObject1 = paramn.params.get("reply_content");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      localObject1 = (String)localObject1;
      localObject3 = paramn.params.get("personal_comment_id");
      if (localObject3 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      i = Util.getInt((String)localObject3, 0);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      ((Bundle)localObject2).putString("reply_content", (String)localObject1);
      ((Bundle)localObject2).putInt("personal_comment_id", i);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.j("share", localObject3))
    {
      try
      {
        ((Bundle)localObject2).putString("extInfo", (String)paramn.params.get("extInfo"));
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
      paramf.a(paramn, "handleMPPageAction:ok", null);
      AppMethodBeat.o(210369);
      return true;
    }
    if (p.j("showToast", localObject3))
    {
      localObject1 = paramn.params.get("wording");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      localObject1 = (String)localObject1;
      localObject3 = paramn.params.get("status");
      if (localObject3 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      localObject3 = (String)localObject3;
      ((Bundle)localObject2).putString("wording", (String)localObject1);
      ((Bundle)localObject2).putString("status", (String)localObject3);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.j("switchVideo", localObject3))
    {
      localObject1 = paramn.ISf;
      p.g(localObject1, "msg.rawParams");
      a((Bundle)localObject2, 5, (JSONObject)localObject1);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.j("createAdWebview", localObject3))
    {
      localObject1 = paramn.params.get("adUrl");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      ((Bundle)localObject2).putString("adUrl", (String)localObject1);
      if (paramf1 != null) {}
      for (;;)
      {
        try
        {
          paramf1 = paramf1.j(201, (Bundle)localObject2);
          if (paramf1 == null) {
            p.hyc();
          }
          boolean bool = paramf1.getBoolean("ret");
          j = bool;
        }
        catch (RemoteException paramf1)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          continue;
          paramf.a(paramn, "handleMPPageAction:fail", null);
          continue;
        }
        if (j == 0) {
          continue;
        }
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
        paramf1 = null;
      }
    }
    if (p.j("closeAdWebview", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (p.j("adWebviewReady", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if ((p.j("closeDotWebview", localObject3)) || (p.j("hideDotWebview", localObject3)))
    {
      try
      {
        localObject1 = paramn.params.get("webviewId");
        if (localObject1 == null)
        {
          paramf1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210369);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
        ((Bundle)localObject2).putInt("webviewId", Util.getInt((String)localObject1, 0));
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
    }
    if (p.j("dotWebViewReady", localObject3))
    {
      try
      {
        localObject1 = paramn.params.get("webviewId");
        if (localObject1 == null)
        {
          paramf1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210369);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
        ((Bundle)localObject2).putInt("webviewId", Util.getInt((String)localObject1, 0));
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
    }
    if (p.j("setDotScriptData", localObject3))
    {
      try
      {
        localObject1 = paramn.params.get("data");
        if (localObject1 == null)
        {
          paramf1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210369);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
        ((Bundle)localObject2).putString("data", (String)localObject1);
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
    }
    if (p.j("getMPVideoState", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        for (paramf1 = paramf1.j(201, (Bundle)localObject2);; paramf1 = null)
        {
          localObject1 = new HashMap();
          if (paramf1 != null)
          {
            ((Map)localObject1).put("currentTime", Integer.valueOf(paramf1.getInt("currentTime")));
            ((Map)localObject1).put("duration", Integer.valueOf(paramf1.getInt("duration")));
            ((Map)localObject1).put("state", paramf1.getString("state"));
            ((Map)localObject1).put("vid", paramf1.getString("vid"));
          }
          paramf.a(paramn, "handleMPPageAction:ok", (Map)localObject1);
          AppMethodBeat.o(210369);
          return true;
        }
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          paramf1 = (com.tencent.mm.plugin.webview.stub.f)localObject1;
        }
      }
    }
    if (p.j("sendMPPageData", localObject3))
    {
      localObject1 = paramn.params.get("data");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      ((Bundle)localObject2).putString("data", (String)localObject1);
      localObject1 = paramn.params.get("sendTo");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
      ((Bundle)localObject2).putString("sendTo", (String)localObject1);
      if (!paramn.params.containsKey("webviewId")) {
        break label2594;
      }
      localObject1 = paramn.params.get("webviewId");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210369);
        throw paramn;
      }
    }
    label2589:
    label2594:
    for (i = Util.getInt((String)localObject1, 0);; i = 0)
    {
      ((Bundle)localObject2).putInt("webviewId", i);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
      if (p.j("setWebviewBackground", localObject3))
      {
        localObject1 = paramn.params.get("backgroundColor");
        if (localObject1 == null)
        {
          paramn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210369);
          throw paramn;
        }
        ((Bundle)localObject2).putString("backgroundColor", (String)localObject1);
        if (paramf1 != null) {}
        try
        {
          paramf1.j(201, (Bundle)localObject2);
          paramf.a(paramn, "handleMPPageAction:ok", null);
          AppMethodBeat.o(210369);
          return true;
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          }
        }
      }
      if (p.j("opPlayer", localObject3))
      {
        localObject1 = paramn.params.get("opType");
        if (localObject1 == null)
        {
          paramn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210369);
          throw paramn;
        }
        ((Bundle)localObject2).putString("opType", (String)localObject1);
        if (paramf1 != null) {}
        try
        {
          paramf1.j(201, (Bundle)localObject2);
          paramf.a(paramn, "handleMPPageAction:ok", null);
          AppMethodBeat.o(210369);
          return true;
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          }
        }
      }
      if (p.j("paySuccess", localObject3))
      {
        paramf1 = paramn.params;
        p.g(paramf1, "msg.params");
        if (paramf1.containsKey("fullUrl"))
        {
          paramf1 = paramn.params.get("fullUrl");
          if (paramf1 == null)
          {
            paramn = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210369);
            throw paramn;
          }
        }
        for (paramf1 = (String)paramf1;; paramf1 = (String)paramf1)
        {
          localObject1 = paramn.params;
          p.g(localObject1, "msg.params");
          if (!((Map)localObject1).containsKey("itemShowType")) {
            break label2589;
          }
          localObject1 = paramn.params.get("itemShowType");
          if (localObject1 != null) {
            break;
          }
          paramn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210369);
          throw paramn;
          paramf1 = paramn.params.get("url");
          if (paramf1 == null)
          {
            paramn = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210369);
            throw paramn;
          }
        }
      }
      for (i = Util.getInt((String)localObject1, -1);; i = -1)
      {
        if (Util.isNullOrNil(paramf1))
        {
          paramf.a(paramn, "handleMPPageAction:fail_url_is_null", null);
          AppMethodBeat.o(210369);
          return true;
        }
        ((b)com.tencent.mm.kernel.g.af(b.class)).cE(paramf1, i);
        paramf.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(210369);
        return true;
        if (p.j("isGPVersion", localObject3))
        {
          paramf1 = new HashMap();
          localObject1 = (Map)paramf1;
          if ((ChannelUtil.isGPVersion()) || (com.tencent.mm.model.z.aUn())) {
            i = 1;
          }
          ((Map)localObject1).put("GPVersion", Integer.valueOf(i));
          paramf.a(paramn, "handleMPPageAction:ok", (Map)paramf1);
          AppMethodBeat.o(210369);
          return true;
        }
        paramf.a(paramn, "handleMPPageAction:fail, action not support", null);
        AppMethodBeat.o(210369);
        return false;
      }
    }
  }
  
  private static void b(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175655);
    p.h(paramBundle, "bundle");
    p.h(paramJSONObject, "data");
    x localx;
    if (paramInt == 5)
    {
      localx = new x();
      localx.dHc = paramJSONObject.optString("srcUserName");
      localx.iAg = paramJSONObject.optString("srcDisplayName");
      if (!paramJSONObject.has("url")) {
        break label208;
      }
      localx.iAi.url = paramJSONObject.optString("url");
    }
    for (;;)
    {
      localx.iAi.title = paramJSONObject.optString("title");
      localx.iAi.iAq = paramJSONObject.optString("digest");
      localx.iAi.iAo = paramJSONObject.optString("cover");
      localx.iAi.type = paramInt;
      localx.iAi.time = paramJSONObject.optInt("pubTime");
      localx.iAi.iAs = paramJSONObject.optInt("duration");
      localx.iAi.videoWidth = paramJSONObject.optInt("videoWidth");
      localx.iAi.videoHeight = paramJSONObject.optInt("videoHeight");
      localx.iAi.vid = paramJSONObject.optString("vid");
      localx.z(paramBundle);
      AppMethodBeat.o(175655);
      return;
      label208:
      if (paramJSONObject.has("jumpUrl")) {
        localx.iAi.url = paramJSONObject.optString("jumpUrl");
      }
    }
  }
  
  public static final boolean b(n paramn, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, com.tencent.mm.plugin.webview.stub.f paramf1)
  {
    AppMethodBeat.i(210370);
    p.h(paramn, "msg");
    p.h(paramf, "msgHandler");
    if (!((b)com.tencent.mm.kernel.g.af(b.class)).CR(5))
    {
      AppMethodBeat.o(210370);
      return false;
    }
    int i = paramn.ISf.optInt("itemType", -1);
    paramf = new Bundle();
    if (i >= 0)
    {
      paramf.putString("url", paramn.ISf.optString("jumpUrl"));
      paramf.putInt("item_show_type", i);
      paramf.putInt("scene", paramn.ISf.optInt("scene"));
      paramf.putInt("openType", -1);
      if ((i == 5) && (((b)com.tencent.mm.kernel.g.af(b.class)).CQ(i)))
      {
        JSONObject localJSONObject = paramn.ISf;
        p.g(localJSONObject, "msg.rawParams");
        if (Util.isNullOrNil(c(i, localJSONObject)))
        {
          if (paramn.ISf.has("currentInfo")) {
            paramf.putString("currentInfo", paramn.ISf.optString("currentInfo"));
          }
          if (paramn.ISf.has("scene")) {
            paramf.putInt(e.b.OyQ, paramn.ISf.optInt("scene"));
          }
          paramf.putInt(e.b.OyR, paramn.ISf.optInt("subScene"));
          paramf.putString("KPublisherId", paramn.ISf.optString("publishId"));
          paramf.putInt("biz_video_session_id", ab.getSessionId());
          paramf.putBoolean("isNativePage", true);
          paramn = paramn.ISf;
          p.g(paramn, "msg.rawParams");
          b(paramf, i, paramn);
          h.CyF.idkeyStat(1061L, 20L, 1L, false);
        }
      }
      if (paramf1 == null) {
        break label346;
      }
    }
    label346:
    for (paramn = paramf1.j(200, paramf); (paramn != null) && (paramn.getBoolean("success")); paramn = null)
    {
      AppMethodBeat.o(210370);
      return true;
      AppMethodBeat.o(210370);
      return false;
    }
    AppMethodBeat.o(210370);
    return false;
  }
  
  public static final String c(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175656);
    p.h(paramJSONObject, "data");
    if ((paramInt == 5) && (((b)com.tencent.mm.kernel.g.af(b.class)).CQ(paramInt)) && (!com.tencent.mm.pluginsdk.ui.tools.z.gsK()))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.g
 * JD-Core Version:    0.7.0.1
 */