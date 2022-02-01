package com.tencent.mm.plugin.webview.g;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.e.b;
import d.g.b.k;
import d.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "checkParam", "itemShowType", "data", "Lorg/json/JSONObject;", "doHandleMPPageAction", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "fillNativePageMPMsgInfo", "fillNativePagePosData", "context", "Landroid/content/Context;", "currentInfoStr", "density", "", "intent", "Landroid/content/Intent;", "isFullScreen", "plugin-webview_release"})
public final class g
{
  public static final g BbO;
  private static final String TAG = "MicroMsg.WebViewNativePageUtil";
  
  static
  {
    AppMethodBeat.i(82516);
    BbO = new g();
    TAG = "MicroMsg.WebViewNativePageUtil";
    AppMethodBeat.o(82516);
  }
  
  public static final void a(Context paramContext, String paramString, float paramFloat, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(82513);
    k.h(paramContext, "context");
    k.h(paramIntent, "intent");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(82513);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("pos");
      if (paramString != null)
      {
        int i = ap.dL(paramContext);
        int n = ap.iX(paramContext);
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
          n = a.hW(paramContext);
          ad.d(TAG, "fillNativePagePosData left %d, top %d, w %d, h %d, density %f,screenHeight %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat), Integer.valueOf(n) });
          AppMethodBeat.o(82513);
          return;
          i += n;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      ad.e(TAG, "fillNativePagePosData exp " + paramContext.getMessage());
      AppMethodBeat.o(82513);
    }
  }
  
  public static final void a(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175654);
    k.h(paramBundle, "bundle");
    k.h(paramJSONObject, "data");
    ad.i(TAG, "fillNativePageData itemShowType ".concat(String.valueOf(paramInt)));
    paramBundle.putString("url", paramJSONObject.optString("url"));
    if (paramJSONObject.has("item_show_type")) {
      paramBundle.putInt("item_show_type", paramJSONObject.getInt("item_show_type"));
    }
    if (paramJSONObject.has("scene"))
    {
      paramBundle.putInt("scene", paramJSONObject.optInt("scene"));
      paramBundle.putInt(e.b.FHP, paramJSONObject.optInt("scene"));
    }
    if (paramJSONObject.has("subscene"))
    {
      paramBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
      paramBundle.putInt(e.b.FHQ, paramJSONObject.optInt("subscene"));
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
    paramBundle.putInt("biz_video_session_id", com.tencent.mm.storage.u.getSessionId());
    b(paramBundle, paramInt, paramJSONObject);
    AppMethodBeat.o(175654);
  }
  
  public static final boolean a(com.tencent.mm.plugin.webview.c.l paraml, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, com.tencent.mm.plugin.webview.stub.f paramf1)
  {
    Object localObject1 = null;
    int i = 0;
    int j = 0;
    AppMethodBeat.i(188893);
    k.h(paraml, "msg");
    k.h(paramf, "msgHandler");
    Object localObject2 = paraml.uLu.get("action");
    if (localObject2 == null)
    {
      paraml = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(188893);
      throw paraml;
    }
    Object localObject3 = (String)localObject2;
    ad.i(TAG, "doHandleMPPageAction action=%s", new Object[] { localObject3 });
    if (bt.isNullOrNil((String)localObject3))
    {
      paramf.a(paraml, "handleMPPageAction:fail action is empty", null);
      AppMethodBeat.o(188893);
      return false;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("action", (String)localObject3);
    long l;
    if (k.g("writeComment", localObject3))
    {
      localObject1 = paraml.uLu.get("style");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      localObject1 = (String)localObject1;
      localObject3 = paraml.uLu.get("comment_id");
      if (localObject3 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      l = bt.getLong((String)localObject3, 0L);
      ((Bundle)localObject2).putString("style", (String)localObject1);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (k.g("writeCommentReply", localObject3))
    {
      localObject1 = paraml.uLu.get("comment_id");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      l = bt.getLong((String)localObject1, 0L);
      localObject1 = paraml.uLu.get("reply_content");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      localObject1 = (String)localObject1;
      localObject3 = paraml.uLu.get("personal_comment_id");
      if (localObject3 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      i = bt.getInt((String)localObject3, 0);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      ((Bundle)localObject2).putString("reply_content", (String)localObject1);
      ((Bundle)localObject2).putInt("personal_comment_id", i);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (k.g("share", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (k.g("showToast", localObject3))
    {
      localObject1 = paraml.uLu.get("wording");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      localObject1 = (String)localObject1;
      localObject3 = paraml.uLu.get("status");
      if (localObject3 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      localObject3 = (String)localObject3;
      ((Bundle)localObject2).putString("wording", (String)localObject1);
      ((Bundle)localObject2).putString("status", (String)localObject3);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (k.g("switchVideo", localObject3))
    {
      localObject1 = paraml.ASh;
      k.g(localObject1, "msg.rawParams");
      a((Bundle)localObject2, 5, (JSONObject)localObject1);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (k.g("createAdWebview", localObject3))
    {
      localObject1 = paraml.uLu.get("adUrl");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      ((Bundle)localObject2).putString("adUrl", (String)localObject1);
      if (paramf1 != null) {}
      for (;;)
      {
        try
        {
          paramf1 = paramf1.j(201, (Bundle)localObject2);
          if (paramf1 == null) {
            k.fvU();
          }
          boolean bool = paramf1.getBoolean("ret");
          j = bool;
        }
        catch (RemoteException paramf1)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          continue;
          paramf.a(paraml, "handleMPPageAction:fail", null);
          continue;
        }
        if (j == 0) {
          continue;
        }
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
        paramf1 = null;
      }
    }
    if (k.g("closeAdWebview", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if (k.g("adWebviewReady", localObject3))
    {
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
    }
    if ((k.g("closeDotWebview", localObject3)) || (k.g("hideDotWebview", localObject3)))
    {
      try
      {
        localObject1 = paraml.uLu.get("webviewId");
        if (localObject1 == null)
        {
          paramf1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188893);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
        ((Bundle)localObject2).putInt("webviewId", bt.getInt((String)localObject1, 0));
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
    }
    if (k.g("dotWebViewReady", localObject3))
    {
      try
      {
        localObject1 = paraml.uLu.get("webviewId");
        if (localObject1 == null)
        {
          paramf1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188893);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
        ((Bundle)localObject2).putInt("webviewId", bt.getInt((String)localObject1, 0));
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
    }
    if (k.g("setDotScriptData", localObject3))
    {
      try
      {
        localObject1 = paraml.uLu.get("data");
        if (localObject1 == null)
        {
          paramf1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188893);
          throw paramf1;
        }
      }
      catch (RemoteException paramf1)
      {
        ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
      }
      for (;;)
      {
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
        ((Bundle)localObject2).putString("data", (String)localObject1);
        if (paramf1 != null) {
          paramf1.j(201, (Bundle)localObject2);
        }
      }
    }
    if (k.g("getMPVideoState", localObject3))
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
            localObject2 = (Map)localObject1;
            localObject3 = paramf1.getString("state");
            k.g(localObject3, "retBundle.getString(\"state\")");
            ((Map)localObject2).put("state", localObject3);
            localObject2 = (Map)localObject1;
            paramf1 = paramf1.getString("vid");
            k.g(paramf1, "retBundle.getString(\"vid\")");
            ((Map)localObject2).put("vid", paramf1);
          }
          paramf.a(paraml, "handleMPPageAction:ok", (Map)localObject1);
          AppMethodBeat.o(188893);
          return true;
        }
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          paramf1 = (com.tencent.mm.plugin.webview.stub.f)localObject1;
        }
      }
    }
    if (k.g("sendMPPageData", localObject3))
    {
      localObject1 = paraml.uLu.get("data");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      ((Bundle)localObject2).putString("data", (String)localObject1);
      localObject1 = paraml.uLu.get("sendTo");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
      ((Bundle)localObject2).putString("sendTo", (String)localObject1);
      if (!paraml.uLu.containsKey("webviewId")) {
        break label2741;
      }
      localObject1 = paraml.uLu.get("webviewId");
      if (localObject1 == null)
      {
        paraml = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188893);
        throw paraml;
      }
    }
    label2736:
    label2741:
    for (i = bt.getInt((String)localObject1, 0);; i = 0)
    {
      ((Bundle)localObject2).putInt("webviewId", i);
      if (paramf1 != null) {}
      try
      {
        paramf1.j(201, (Bundle)localObject2);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
      }
      catch (RemoteException paramf1)
      {
        for (;;)
        {
          ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
        }
      }
      if (k.g("getFuncFlag", localObject3))
      {
        if (paramf1 != null) {}
        try
        {
          for (paramf1 = paramf1.j(201, (Bundle)localObject2); (paramf1 != null) && (paramf1.getInt("funcFlag", 0) != -1); paramf1 = null)
          {
            localObject1 = new HashMap();
            ((Map)localObject1).put("shareFuncFlag", Integer.valueOf(paramf1.getInt("funcFlag", 0)));
            paramf.a(paraml, "handleMPPageAction:ok", (Map)localObject1);
            AppMethodBeat.o(188893);
            return true;
          }
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
            paramf1 = null;
            continue;
            paramf.a(paraml, "handleMPPageAction:fail", null);
          }
        }
      }
      if (k.g("setWebviewBackground", localObject3))
      {
        localObject1 = paraml.uLu.get("backgroundColor");
        if (localObject1 == null)
        {
          paraml = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188893);
          throw paraml;
        }
        ((Bundle)localObject2).putString("backgroundColor", (String)localObject1);
        if (paramf1 != null) {}
        try
        {
          paramf1.j(201, (Bundle)localObject2);
          paramf.a(paraml, "handleMPPageAction:ok", null);
          AppMethodBeat.o(188893);
          return true;
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          }
        }
      }
      if (k.g("opPlayer", localObject3))
      {
        localObject1 = paraml.uLu.get("opType");
        if (localObject1 == null)
        {
          paraml = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188893);
          throw paraml;
        }
        ((Bundle)localObject2).putString("opType", (String)localObject1);
        if (paramf1 != null) {}
        try
        {
          paramf1.j(201, (Bundle)localObject2);
          paramf.a(paraml, "handleMPPageAction:ok", null);
          AppMethodBeat.o(188893);
          return true;
        }
        catch (RemoteException paramf1)
        {
          for (;;)
          {
            ad.e(TAG, "doHandleMPPageAction e=%s", new Object[] { paramf1.getMessage() });
          }
        }
      }
      if (k.g("paySuccess", localObject3))
      {
        paramf1 = paraml.uLu;
        k.g(paramf1, "msg.params");
        if (paramf1.containsKey("fullUrl"))
        {
          paramf1 = paraml.uLu.get("fullUrl");
          if (paramf1 == null)
          {
            paraml = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(188893);
            throw paraml;
          }
        }
        for (paramf1 = (String)paramf1;; paramf1 = (String)paramf1)
        {
          localObject1 = paraml.uLu;
          k.g(localObject1, "msg.params");
          if (!((Map)localObject1).containsKey("itemShowType")) {
            break label2736;
          }
          localObject1 = paraml.uLu.get("itemShowType");
          if (localObject1 != null) {
            break;
          }
          paraml = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(188893);
          throw paraml;
          paramf1 = paraml.uLu.get("url");
          if (paramf1 == null)
          {
            paraml = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(188893);
            throw paraml;
          }
        }
      }
      for (i = bt.getInt((String)localObject1, -1);; i = -1)
      {
        if (bt.isNullOrNil(paramf1))
        {
          paramf.a(paraml, "handleMPPageAction:fail_url_is_null", null);
          AppMethodBeat.o(188893);
          return true;
        }
        ((b)com.tencent.mm.kernel.g.ab(b.class)).cl(paramf1, i);
        paramf.a(paraml, "handleMPPageAction:ok", null);
        AppMethodBeat.o(188893);
        return true;
        if (k.g("isGPVersion", localObject3))
        {
          paramf1 = new HashMap();
          localObject1 = (Map)paramf1;
          if ((i.eFb()) || (com.tencent.mm.model.u.aqU())) {
            i = 1;
          }
          ((Map)localObject1).put("GPVersion", Integer.valueOf(i));
          paramf.a(paraml, "handleMPPageAction:ok", (Map)paramf1);
          AppMethodBeat.o(188893);
          return true;
        }
        paramf.a(paraml, "handleMPPageAction:fail, action not support", null);
        AppMethodBeat.o(188893);
        return false;
      }
    }
  }
  
  public static final String b(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(175656);
    k.h(paramJSONObject, "data");
    if ((paramInt == 5) && (((b)com.tencent.mm.kernel.g.ab(b.class)).xz(paramInt)))
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
    k.h(paramBundle, "bundle");
    k.h(paramJSONObject, "data");
    x localx;
    if (paramInt == 5)
    {
      localx = new x();
      localx.dfT = paramJSONObject.optString("srcUserName");
      localx.gKv = paramJSONObject.optString("srcDisplayName");
      if (!paramJSONObject.has("url")) {
        break label208;
      }
      localx.gKx.url = paramJSONObject.optString("url");
    }
    for (;;)
    {
      localx.gKx.title = paramJSONObject.optString("title");
      localx.gKx.gKF = paramJSONObject.optString("digest");
      localx.gKx.gKD = paramJSONObject.optString("cover");
      localx.gKx.type = paramInt;
      localx.gKx.time = paramJSONObject.optInt("pubTime");
      localx.gKx.gKH = paramJSONObject.optInt("duration");
      localx.gKx.videoWidth = paramJSONObject.optInt("videoWidth");
      localx.gKx.videoHeight = paramJSONObject.optInt("videoHeight");
      localx.gKx.gGC = paramJSONObject.optString("vid");
      localx.s(paramBundle);
      AppMethodBeat.o(175655);
      return;
      label208:
      if (paramJSONObject.has("jumpUrl")) {
        localx.gKx.url = paramJSONObject.optString("jumpUrl");
      }
    }
  }
  
  public static final boolean b(com.tencent.mm.plugin.webview.c.l paraml, com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf, com.tencent.mm.plugin.webview.stub.f paramf1)
  {
    AppMethodBeat.i(188894);
    k.h(paraml, "msg");
    k.h(paramf, "msgHandler");
    if (!((b)com.tencent.mm.kernel.g.ab(b.class)).xA(5))
    {
      AppMethodBeat.o(188894);
      return false;
    }
    int i = paraml.ASh.optInt("itemType", -1);
    paramf = new Bundle();
    if (i >= 0)
    {
      paramf.putString("url", paraml.ASh.optString("jumpUrl"));
      paramf.putInt("item_show_type", i);
      paramf.putInt("scene", paraml.ASh.optInt("scene"));
      paramf.putInt("openType", -1);
      if ((i == 5) && (((b)com.tencent.mm.kernel.g.ab(b.class)).xz(i)))
      {
        JSONObject localJSONObject = paraml.ASh;
        k.g(localJSONObject, "msg.rawParams");
        if (bt.isNullOrNil(b(i, localJSONObject)))
        {
          if (paraml.ASh.has("currentInfo")) {
            paramf.putString("currentInfo", paraml.ASh.optString("currentInfo"));
          }
          if (paraml.ASh.has("scene")) {
            paramf.putInt(e.b.FHP, paraml.ASh.optInt("scene"));
          }
          paramf.putInt(e.b.FHQ, paraml.ASh.optInt("subScene"));
          paramf.putString("KPublisherId", paraml.ASh.optString("publishId"));
          paramf.putInt("biz_video_session_id", com.tencent.mm.storage.u.getSessionId());
          paramf.putBoolean("isNativePage", true);
          paraml = paraml.ASh;
          k.g(paraml, "msg.rawParams");
          b(paramf, i, paraml);
          h.vKh.idkeyStat(1061L, 20L, 1L, false);
        }
      }
      if (paramf1 == null) {
        break label346;
      }
    }
    label346:
    for (paraml = paramf1.j(200, paramf); (paraml != null) && (paraml.getBoolean("success")); paraml = null)
    {
      AppMethodBeat.o(188894);
      return true;
      AppMethodBeat.o(188894);
      return false;
    }
    AppMethodBeat.o(188894);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.g
 * JD-Core Version:    0.7.0.1
 */