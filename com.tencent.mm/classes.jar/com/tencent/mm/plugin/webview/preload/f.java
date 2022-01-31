package com.tencent.mm.plugin.webview.preload;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.am;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "checkParam", "itemShowType", "msg", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgWrapper;", "doHandleMPPageAction", "", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "fillNativePageMPMsgInfo", "fillNativePagePosData", "context", "Landroid/content/Context;", "currentInfoStr", "density", "", "intent", "Landroid/content/Intent;", "isFullScreen", "plugin-webview_release"})
public final class f
{
  private static final String TAG = "MicroMsg.WebViewNativePageUtil";
  public static final f uZd;
  
  static
  {
    AppMethodBeat.i(153462);
    uZd = new f();
    TAG = "MicroMsg.WebViewNativePageUtil";
    AppMethodBeat.o(153462);
  }
  
  public static final String a(int paramInt, i parami)
  {
    AppMethodBeat.i(153458);
    j.q(parami, "msg");
    if ((paramInt == 5) && (((b)com.tencent.mm.kernel.g.E(b.class)).rT(paramInt)))
    {
      if (!parami.vrO.has("srcUserName"))
      {
        AppMethodBeat.o(153458);
        return "invalid srcUserName";
      }
      if (!parami.vrO.has("srcDisplayName"))
      {
        AppMethodBeat.o(153458);
        return "invalid srcDisplayName";
      }
      if (!parami.vrO.has("title"))
      {
        AppMethodBeat.o(153458);
        return "invalid title";
      }
      if (!parami.vrO.has("pubTime"))
      {
        AppMethodBeat.o(153458);
        return "invalid cover";
      }
      if (!parami.vrO.has("cover"))
      {
        AppMethodBeat.o(153458);
        return "invalid cover";
      }
      if (!parami.vrO.has("vid"))
      {
        AppMethodBeat.o(153458);
        return "invalid vid";
      }
    }
    AppMethodBeat.o(153458);
    return "";
  }
  
  public static final void a(Context paramContext, String paramString, float paramFloat, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(153459);
    j.q(paramContext, "context");
    j.q(paramIntent, "intent");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153459);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("pos");
      if (paramString != null)
      {
        int i = am.di(paramContext);
        int n = am.getStatusBarHeight(paramContext);
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
          n = a.gx(paramContext);
          ab.d(TAG, "fillNativePagePosData left %d, top %d, w %d, h %d, density %f,screenHeight %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat), Integer.valueOf(n) });
          AppMethodBeat.o(153459);
          return;
          i += n;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      ab.e(TAG, "fillNativePagePosData exp " + paramContext.getMessage());
      AppMethodBeat.o(153459);
    }
  }
  
  public static final void a(Bundle paramBundle, int paramInt, i parami)
  {
    AppMethodBeat.i(153456);
    j.q(paramBundle, "bundle");
    j.q(parami, "msg");
    ab.i(TAG, "fillNativePageData itemShowType ".concat(String.valueOf(paramInt)));
    paramBundle.putString("url", parami.vrO.optString("url"));
    if (parami.vrO.has("item_show_type")) {
      paramBundle.putInt("item_show_type", parami.vrO.getInt("item_show_type"));
    }
    if (parami.vrO.has("scene"))
    {
      paramBundle.putInt("scene", parami.vrO.optInt("scene"));
      paramBundle.putInt("biz_video_scene", parami.vrO.optInt("scene"));
    }
    if (parami.vrO.has("openType")) {
      paramBundle.putInt("openType", parami.vrO.optInt("openType"));
    }
    if (parami.vrO.has("currentInfo")) {
      paramBundle.putString("currentInfo", parami.vrO.optString("currentInfo"));
    }
    paramBundle.putBoolean("isNativePage", true);
    paramBundle.putInt("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
    b(paramBundle, paramInt, parami);
    AppMethodBeat.o(153456);
  }
  
  public static final boolean a(i parami, com.tencent.mm.plugin.webview.ui.tools.jsapi.g paramg, e parame)
  {
    int i = 0;
    Object localObject1 = null;
    AppMethodBeat.i(153460);
    j.q(parami, "msg");
    j.q(paramg, "msgHandler");
    Object localObject2 = parami.pJb.get("action");
    if (localObject2 == null)
    {
      parami = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(153460);
      throw parami;
    }
    Object localObject3 = (String)localObject2;
    ab.i(TAG, "doHandleMPPageAction action=%s", new Object[] { localObject3 });
    if (bo.isNullOrNil((String)localObject3))
    {
      paramg.a(parami, "handleMPPageAction:fail action is empty", null);
      AppMethodBeat.o(153460);
      return false;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("action", (String)localObject3);
    if (j.e("writeComment", localObject3))
    {
      localObject1 = parami.pJb.get("style");
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      localObject1 = (String)localObject1;
      localObject3 = parami.pJb.get("comment_id");
      if (localObject3 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      long l = bo.getLong((String)localObject3, 0L);
      ((Bundle)localObject2).putString("style", (String)localObject1);
      ((Bundle)localObject2).putLong("commentTopicId", l);
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleHaoKanAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("share", localObject3))
    {
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("showToast", localObject3))
    {
      localObject1 = parami.pJb.get("wording");
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      localObject1 = (String)localObject1;
      localObject3 = parami.pJb.get("status");
      if (localObject3 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      localObject3 = (String)localObject3;
      ((Bundle)localObject2).putString("wording", (String)localObject1);
      ((Bundle)localObject2).putString("status", (String)localObject3);
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("switchVideo", localObject3))
    {
      a((Bundle)localObject2, 5, parami);
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("createAdWebview", localObject3))
    {
      localObject1 = parami.pJb.get("adUrl");
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      ((Bundle)localObject2).putString("adUrl", (String)localObject1);
      if (parame != null) {}
      for (;;)
      {
        try
        {
          parame = parame.i(201, (Bundle)localObject2);
          if (parame == null) {
            j.ebi();
          }
          boolean bool = parame.getBoolean("ret");
          i = bool;
        }
        catch (RemoteException parame)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
          continue;
          paramg.a(parami, "handleMPPageAction:fail", null);
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
        parame = null;
      }
    }
    if (j.e("closeAdWebview", localObject3))
    {
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("adWebviewReady", localObject3))
    {
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("getMPVideoState", localObject3))
    {
      if (parame != null) {}
      try
      {
        for (parame = parame.i(201, (Bundle)localObject2);; parame = null)
        {
          localObject1 = new HashMap();
          if (parame != null)
          {
            ((Map)localObject1).put("currentTime", Integer.valueOf(parame.getInt("currentTime")));
            ((Map)localObject1).put("duration", Integer.valueOf(parame.getInt("duration")));
            localObject2 = (Map)localObject1;
            localObject3 = parame.getString("state");
            j.p(localObject3, "retBundle.getString(\"state\")");
            ((Map)localObject2).put("state", localObject3);
            localObject2 = (Map)localObject1;
            parame = parame.getString("vid");
            j.p(parame, "retBundle.getString(\"vid\")");
            ((Map)localObject2).put("vid", parame);
          }
          paramg.a(parami, "handleMPPageAction:ok", (Map)localObject1);
          AppMethodBeat.o(153460);
          return true;
        }
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
          parame = (e)localObject1;
        }
      }
    }
    if (j.e("sendMPPageData", localObject3))
    {
      localObject1 = parami.pJb.get("data");
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      ((Bundle)localObject2).putString("data", (String)localObject1);
      localObject1 = parami.pJb.get("sendTo");
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      ((Bundle)localObject2).putString("sendTo", (String)localObject1);
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    if (j.e("getFuncFlag", localObject3))
    {
      if (parame != null) {}
      try
      {
        for (parame = parame.i(201, (Bundle)localObject2); (parame != null) && (parame.getInt("funcFlag", 0) != -1); parame = null)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("shareFuncFlag", Integer.valueOf(parame.getInt("funcFlag", 0)));
          paramg.a(parami, "handleMPPageAction:ok", (Map)localObject1);
          AppMethodBeat.o(153460);
          return true;
        }
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
          parame = null;
          continue;
          paramg.a(parami, "handleMPPageAction:fail", null);
        }
      }
    }
    if (j.e("setWebviewBackground", localObject3))
    {
      localObject1 = parami.pJb.get("backgroundColor");
      if (localObject1 == null)
      {
        parami = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(153460);
        throw parami;
      }
      ((Bundle)localObject2).putString("backgroundColor", (String)localObject1);
      if (parame != null) {}
      try
      {
        parame.i(201, (Bundle)localObject2);
        paramg.a(parami, "handleMPPageAction:ok", null);
        AppMethodBeat.o(153460);
        return true;
      }
      catch (RemoteException parame)
      {
        for (;;)
        {
          ab.e(TAG, "doHandleMPPageAction e=%s", new Object[] { parame.getMessage() });
        }
      }
    }
    paramg.a(parami, "handleMPPageAction:fail, action not support", null);
    AppMethodBeat.o(153460);
    return false;
  }
  
  private static void b(Bundle paramBundle, int paramInt, i parami)
  {
    AppMethodBeat.i(153457);
    j.q(paramBundle, "bundle");
    j.q(parami, "msg");
    com.tencent.mm.af.s locals;
    if (paramInt == 5)
    {
      locals = new com.tencent.mm.af.s();
      locals.cqX = parami.vrO.optString("srcUserName");
      locals.fjB = parami.vrO.optString("srcDisplayName");
      if (!parami.vrO.has("url")) {
        break label238;
      }
      locals.fjD.url = parami.vrO.optString("url");
    }
    for (;;)
    {
      locals.fjD.title = parami.vrO.optString("title");
      locals.fjD.fjL = parami.vrO.optString("digest");
      locals.fjD.fjJ = parami.vrO.optString("cover");
      locals.fjD.type = paramInt;
      locals.fjD.time = parami.vrO.optInt("pubTime");
      locals.fjD.fjN = parami.vrO.optInt("duration");
      locals.fjD.videoWidth = parami.vrO.optInt("videoWidth");
      locals.fjD.videoHeight = parami.vrO.optInt("videoHeight");
      locals.fjD.fgl = parami.vrO.optString("vid");
      locals.q(paramBundle);
      AppMethodBeat.o(153457);
      return;
      label238:
      if (parami.vrO.has("jumpUrl")) {
        locals.fjD.url = parami.vrO.optString("jumpUrl");
      }
    }
  }
  
  public static final boolean b(i parami, com.tencent.mm.plugin.webview.ui.tools.jsapi.g paramg, e parame)
  {
    AppMethodBeat.i(153461);
    j.q(parami, "msg");
    j.q(paramg, "msgHandler");
    if (!((b)com.tencent.mm.kernel.g.E(b.class)).rU(5))
    {
      AppMethodBeat.o(153461);
      return false;
    }
    int i = parami.vrO.optInt("itemType", -1);
    paramg = new Bundle();
    if (i >= 0)
    {
      paramg.putString("url", parami.vrO.optString("jumpUrl"));
      paramg.putInt("item_show_type", i);
      paramg.putInt("scene", parami.vrO.optInt("scene"));
      paramg.putInt("openType", -1);
      if ((i == 5) && (((b)com.tencent.mm.kernel.g.E(b.class)).rT(i)) && (bo.isNullOrNil(a(i, parami))))
      {
        if (parami.vrO.has("currentInfo")) {
          paramg.putString("currentInfo", parami.vrO.optString("currentInfo"));
        }
        if (parami.vrO.has("scene")) {
          paramg.putInt("biz_video_scene", parami.vrO.optInt("scene"));
        }
        paramg.putInt("biz_video_subscene", parami.vrO.optInt("subScene"));
        paramg.putString("KPublisherId", parami.vrO.optString("publishId"));
        paramg.putInt("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
        paramg.putBoolean("isNativePage", true);
        b(paramg, i, parami);
        h.qsU.idkeyStat(1061L, 20L, 1L, false);
      }
      if (parame == null) {
        break label326;
      }
    }
    label326:
    for (parami = parame.i(200, paramg); (parami != null) && (parami.getBoolean("success")); parami = null)
    {
      AppMethodBeat.o(153461);
      return true;
      AppMethodBeat.o(153461);
      return false;
    }
    AppMethodBeat.o(153461);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.f
 * JD-Core Version:    0.7.0.1
 */