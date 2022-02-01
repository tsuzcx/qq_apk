package com.tencent.mm.plugin.webview.h;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.f.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "doHandleMPPageAction", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "itemShowType", "data", "Lorg/json/JSONObject;", "fillNativePageMPMsgInfo", "plugin-webview_release"})
public final class f
{
  public static final f PZw;
  private static final String TAG = "MicroMsg.WebViewNativePageUtil";
  
  static
  {
    AppMethodBeat.i(82516);
    PZw = new f();
    TAG = "MicroMsg.WebViewNativePageUtil";
    AppMethodBeat.o(82516);
  }
  
  private static void a(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175654);
    p.k(paramBundle, "bundle");
    p.k(paramJSONObject, "data");
    x localx;
    if (paramInt == 5)
    {
      localx = new x();
      localx.fzT = paramJSONObject.optString("srcUserName");
      localx.lpC = paramJSONObject.optString("srcDisplayName");
      if (!paramJSONObject.has("url")) {
        break label196;
      }
      localx.lpE.url = paramJSONObject.optString("url");
    }
    for (;;)
    {
      localx.lpE.title = paramJSONObject.optString("title");
      localx.lpE.lpM = paramJSONObject.optString("digest");
      localx.lpE.lpK = paramJSONObject.optString("cover");
      localx.lpE.type = paramInt;
      localx.lpE.time = paramJSONObject.optInt("pubTime");
      localx.lpE.lpO = paramJSONObject.optInt("duration");
      localx.lpE.videoWidth = paramJSONObject.optInt("videoWidth");
      localx.lpE.videoHeight = paramJSONObject.optInt("videoHeight");
      localx.lpE.vid = paramJSONObject.optString("vid");
      localx.G(paramBundle);
      AppMethodBeat.o(175654);
      return;
      label196:
      if (paramJSONObject.has("jumpUrl")) {
        localx.lpE.url = paramJSONObject.optString("jumpUrl");
      }
    }
  }
  
  public static final boolean a(n paramn, com.tencent.mm.plugin.webview.ui.tools.jsapi.h paramh, com.tencent.mm.plugin.webview.stub.f paramf)
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(234789);
    p.k(paramn, "msg");
    p.k(paramh, "msgHandler");
    Object localObject2 = paramn.params.get("action");
    if (localObject2 == null)
    {
      paramn = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(234789);
      throw paramn;
    }
    Object localObject3 = (String)localObject2;
    Log.i(TAG, "doHandleMPPageAction action=%s", new Object[] { localObject3 });
    if (Util.isNullOrNil((String)localObject3))
    {
      paramh.a(paramn, "handleMPPageAction:fail action is empty", null);
      AppMethodBeat.o(234789);
      return false;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("action", (String)localObject3);
    long l;
    if (p.h("writeComment", localObject3))
    {
      localObject1 = paramn.params.get("style");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      localObject1 = (String)localObject1;
      localObject3 = paramn.params.get("comment_id");
      if (localObject3 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      l = Util.getLong((String)localObject3, 0L);
      ((Bundle)localObject2).putString("style", (String)localObject1);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
    }
    if (p.h("writeCommentReply", localObject3))
    {
      localObject1 = paramn.params.get("comment_id");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      l = Util.getLong((String)localObject1, 0L);
      localObject1 = paramn.params.get("reply_content");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      localObject1 = (String)localObject1;
      localObject3 = paramn.params.get("personal_comment_id");
      if (localObject3 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      i = Util.getInt((String)localObject3, 0);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      ((Bundle)localObject2).putString("reply_content", (String)localObject1);
      ((Bundle)localObject2).putInt("personal_comment_id", i);
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
    }
    if (p.h("share", localObject3))
    {
      try
      {
        ((Bundle)localObject2).putString("extInfo", (String)paramn.params.get("extInfo"));
        if (paramf != null) {
          paramf.l(201, (Bundle)localObject2);
        }
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
      paramh.a(paramn, "handleMPPageAction:ok", null);
      AppMethodBeat.o(234789);
      return true;
    }
    if (p.h("showToast", localObject3))
    {
      localObject1 = paramn.params.get("wording");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      localObject1 = (String)localObject1;
      localObject3 = paramn.params.get("status");
      if (localObject3 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      localObject3 = (String)localObject3;
      ((Bundle)localObject2).putString("wording", (String)localObject1);
      ((Bundle)localObject2).putString("status", (String)localObject3);
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
    }
    if (p.h("switchVideo", localObject3))
    {
      localObject1 = paramn.POv;
      p.j(localObject1, "msg.rawParams");
      p.k(localObject2, "bundle");
      p.k(localObject1, "data");
      Log.i(TAG, "fillNativePageData itemShowType 5");
      ((Bundle)localObject2).putString("url", ((JSONObject)localObject1).optString("url"));
      if (((JSONObject)localObject1).has("item_show_type")) {
        ((Bundle)localObject2).putInt("item_show_type", ((JSONObject)localObject1).getInt("item_show_type"));
      }
      if (((JSONObject)localObject1).has("scene"))
      {
        ((Bundle)localObject2).putInt("scene", ((JSONObject)localObject1).optInt("scene"));
        ((Bundle)localObject2).putInt(f.b.VRT, ((JSONObject)localObject1).optInt("scene"));
      }
      if (((JSONObject)localObject1).has("subscene"))
      {
        ((Bundle)localObject2).putInt("subscene", ((JSONObject)localObject1).optInt("subscene"));
        ((Bundle)localObject2).putInt(f.b.VRU, ((JSONObject)localObject1).optInt("subscene"));
      }
      if (((JSONObject)localObject1).has("openType")) {
        ((Bundle)localObject2).putInt("openType", ((JSONObject)localObject1).optInt("openType"));
      }
      if (((JSONObject)localObject1).has("currentInfo")) {
        ((Bundle)localObject2).putString("currentInfo", ((JSONObject)localObject1).optString("currentInfo"));
      }
      if (((JSONObject)localObject1).has("channelSessionId")) {
        ((Bundle)localObject2).putString("biz_video_channel_session_id", ((JSONObject)localObject1).optString("channelSessionId"));
      }
      ((Bundle)localObject2).putBoolean("isNativePage", true);
      ((Bundle)localObject2).putInt("biz_video_session_id", ab.getSessionId());
      a((Bundle)localObject2, 5, (JSONObject)localObject1);
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
    }
    if (p.h("createAdWebview", localObject3))
    {
      localObject1 = paramn.params.get("adUrl");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      ((Bundle)localObject2).putString("adUrl", (String)localObject1);
      if (paramf != null) {}
      for (;;)
      {
        try
        {
          paramf = paramf.l(201, (Bundle)localObject2);
          if (paramf == null) {
            p.iCn();
          }
          boolean bool = paramf.getBoolean("ret");
          j = bool;
        }
        catch (RemoteException paramf)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
          continue;
          paramh.a(paramn, "handleMPPageAction:fail", null);
          continue;
        }
        if (j == 0) {
          continue;
        }
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
        paramf = null;
      }
    }
    if (p.h("closeAdWebview", localObject3))
    {
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
    }
    if (p.h("adWebviewReady", localObject3))
    {
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
    }
    if ((p.h("closeDotWebview", localObject3)) || (p.h("hideDotWebview", localObject3)))
    {
      try
      {
        localObject1 = paramn.params.get("webviewId");
        if (localObject1 == null)
        {
          paramf = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(234789);
          throw paramf;
        }
      }
      catch (RemoteException paramf)
      {
        Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
      }
      for (;;)
      {
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
        ((Bundle)localObject2).putInt("webviewId", Util.getInt((String)localObject1, 0));
        if (paramf != null) {
          paramf.l(201, (Bundle)localObject2);
        }
      }
    }
    if (p.h("dotWebViewReady", localObject3))
    {
      try
      {
        localObject1 = paramn.params.get("webviewId");
        if (localObject1 == null)
        {
          paramf = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(234789);
          throw paramf;
        }
      }
      catch (RemoteException paramf)
      {
        Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
      }
      for (;;)
      {
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
        ((Bundle)localObject2).putInt("webviewId", Util.getInt((String)localObject1, 0));
        if (paramf != null) {
          paramf.l(201, (Bundle)localObject2);
        }
      }
    }
    if (p.h("setDotScriptData", localObject3))
    {
      try
      {
        localObject1 = paramn.params.get("data");
        if (localObject1 == null)
        {
          paramf = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(234789);
          throw paramf;
        }
      }
      catch (RemoteException paramf)
      {
        Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
      }
      for (;;)
      {
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
        ((Bundle)localObject2).putString("data", (String)localObject1);
        if (paramf != null) {
          paramf.l(201, (Bundle)localObject2);
        }
      }
    }
    if (p.h("getMPVideoState", localObject3))
    {
      if (paramf != null) {}
      try
      {
        for (paramf = paramf.l(201, (Bundle)localObject2);; paramf = null)
        {
          localObject1 = new HashMap();
          if (paramf != null)
          {
            ((Map)localObject1).put("currentTime", Integer.valueOf(paramf.getInt("currentTime")));
            ((Map)localObject1).put("duration", Integer.valueOf(paramf.getInt("duration")));
            ((Map)localObject1).put("state", paramf.getString("state"));
            ((Map)localObject1).put("vid", paramf.getString("vid"));
          }
          paramh.a(paramn, "handleMPPageAction:ok", (Map)localObject1);
          AppMethodBeat.o(234789);
          return true;
        }
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
          paramf = (com.tencent.mm.plugin.webview.stub.f)localObject1;
        }
      }
    }
    if (p.h("sendMPPageData", localObject3))
    {
      localObject1 = paramn.params.get("data");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      ((Bundle)localObject2).putString("data", (String)localObject1);
      localObject1 = paramn.params.get("sendTo");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
      ((Bundle)localObject2).putString("sendTo", (String)localObject1);
      if (!paramn.params.containsKey("webviewId")) {
        break label2743;
      }
      localObject1 = paramn.params.get("webviewId");
      if (localObject1 == null)
      {
        paramn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(234789);
        throw paramn;
      }
    }
    label2738:
    label2743:
    for (i = Util.getInt((String)localObject1, 0);; i = 0)
    {
      ((Bundle)localObject2).putInt("webviewId", i);
      if (paramf != null) {}
      try
      {
        paramf.l(201, (Bundle)localObject2);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
      }
      catch (RemoteException paramf)
      {
        for (;;)
        {
          Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
        }
      }
      if (p.h("setWebviewBackground", localObject3))
      {
        localObject1 = paramn.params.get("backgroundColor");
        if (localObject1 == null)
        {
          paramn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(234789);
          throw paramn;
        }
        ((Bundle)localObject2).putString("backgroundColor", (String)localObject1);
        if (paramf != null) {}
        try
        {
          paramf.l(201, (Bundle)localObject2);
          paramh.a(paramn, "handleMPPageAction:ok", null);
          AppMethodBeat.o(234789);
          return true;
        }
        catch (RemoteException paramf)
        {
          for (;;)
          {
            Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
          }
        }
      }
      if (p.h("opPlayer", localObject3))
      {
        localObject1 = paramn.params.get("opType");
        if (localObject1 == null)
        {
          paramn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(234789);
          throw paramn;
        }
        ((Bundle)localObject2).putString("opType", (String)localObject1);
        if (paramf != null) {}
        try
        {
          paramf.l(201, (Bundle)localObject2);
          paramh.a(paramn, "handleMPPageAction:ok", null);
          AppMethodBeat.o(234789);
          return true;
        }
        catch (RemoteException paramf)
        {
          for (;;)
          {
            Log.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf.getMessage() });
          }
        }
      }
      if (p.h("paySuccess", localObject3))
      {
        paramf = paramn.params;
        p.j(paramf, "msg.params");
        if (paramf.containsKey("fullUrl"))
        {
          paramf = paramn.params.get("fullUrl");
          if (paramf == null)
          {
            paramn = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(234789);
            throw paramn;
          }
        }
        for (paramf = (String)paramf;; paramf = (String)paramf)
        {
          localObject1 = paramn.params;
          p.j(localObject1, "msg.params");
          if (!((Map)localObject1).containsKey("itemShowType")) {
            break label2738;
          }
          localObject1 = paramn.params.get("itemShowType");
          if (localObject1 != null) {
            break;
          }
          paramn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(234789);
          throw paramn;
          paramf = paramn.params.get("url");
          if (paramf == null)
          {
            paramn = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(234789);
            throw paramn;
          }
        }
      }
      for (i = Util.getInt((String)localObject1, -1);; i = -1)
      {
        if (Util.isNullOrNil(paramf))
        {
          paramh.a(paramn, "handleMPPageAction:fail_url_is_null", null);
          AppMethodBeat.o(234789);
          return true;
        }
        ((c)com.tencent.mm.kernel.h.ae(c.class)).cZ(paramf, i);
        paramh.a(paramn, "handleMPPageAction:ok", null);
        AppMethodBeat.o(234789);
        return true;
        if (p.h("isGPVersion", localObject3))
        {
          paramf = new HashMap();
          localObject1 = (Map)paramf;
          if ((ChannelUtil.isGPVersion()) || (z.bdp())) {
            i = 1;
          }
          ((Map)localObject1).put("GPVersion", Integer.valueOf(i));
          paramh.a(paramn, "handleMPPageAction:ok", (Map)paramf);
          AppMethodBeat.o(234789);
          return true;
        }
        paramh.a(paramn, "handleMPPageAction:fail, action not support", null);
        AppMethodBeat.o(234789);
        return false;
      }
    }
  }
  
  public static final boolean b(n paramn, com.tencent.mm.plugin.webview.ui.tools.jsapi.h paramh, com.tencent.mm.plugin.webview.stub.f paramf)
  {
    AppMethodBeat.i(234791);
    p.k(paramn, "msg");
    p.k(paramh, "msgHandler");
    if (!((c)com.tencent.mm.kernel.h.ae(c.class)).Gw(5))
    {
      AppMethodBeat.o(234791);
      return false;
    }
    int i = paramn.POv.optInt("itemType", -1);
    paramh = new Bundle();
    if (i >= 0)
    {
      paramh.putString("url", paramn.POv.optString("jumpUrl"));
      paramh.putInt("item_show_type", i);
      paramh.putInt("scene", paramn.POv.optInt("scene"));
      paramh.putInt("openType", -1);
      paramh.putString("KPublisherId", paramn.POv.optString("publishId"));
      if (i == 5)
      {
        if (paramn.POv.has("currentInfo")) {
          paramh.putString("currentInfo", paramn.POv.optString("currentInfo"));
        }
        if (paramn.POv.has("scene")) {
          paramh.putInt(f.b.VRT, paramn.POv.optInt("scene"));
        }
        paramh.putInt(f.b.VRU, paramn.POv.optInt("subScene"));
        paramh.putInt("biz_video_session_id", ab.getSessionId());
        paramh.putBoolean("isNativePage", true);
        paramn = paramn.POv;
        p.j(paramn, "msg.rawParams");
        a(paramh, i, paramn);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1061L, 20L, 1L, false);
      }
      if (paramf == null) {
        break label310;
      }
    }
    label310:
    for (paramn = paramf.l(200, paramh); (paramn != null) && (paramn.getBoolean("success")); paramn = null)
    {
      AppMethodBeat.o(234791);
      return true;
      AppMethodBeat.o(234791);
      return false;
    }
    AppMethodBeat.o(234791);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.f
 * JD-Core Version:    0.7.0.1
 */