package com.tencent.mm.plugin.webview.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.x;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/preload/WebViewNativePageUtil;", "", "()V", "SHARE_FUN_FLAG_FRIEND", "", "SHARE_FUN_FLAG_TIMELINE", "TAG", "", "doHandleMPPageAction", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "msgHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgHandler;", "callbacker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "doHandleSearchItemDetailPage", "fillNativePageData", "", "bundle", "Landroid/os/Bundle;", "itemShowType", "data", "Lorg/json/JSONObject;", "fillNativePageMPMsgInfo", "requestTeenModeTemporaryVisit", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  public static final f WQk;
  
  static
  {
    AppMethodBeat.i(82516);
    WQk = new f();
    TAG = "MicroMsg.WebViewNativePageUtil";
    AppMethodBeat.o(82516);
  }
  
  private static final void a(int paramInt, final j paramj, p paramp, final com.tencent.mm.plugin.webview.stub.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(294745);
    s.u(paramj, "$msgHandler");
    s.u(paramp, "$msg");
    if ((paramBoolean) && (paramInt == 2))
    {
      com.tencent.mm.ae.d.a(1500L, (a)new a(paramp, paramf, paramj));
      AppMethodBeat.o(294745);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramp.function).append(':');
    if (paramBoolean) {}
    for (paramf = "ok";; paramf = "fail")
    {
      paramj.callback(paramp, paramf, null);
      AppMethodBeat.o(294745);
      return;
    }
  }
  
  private static final void a(j paramj, p paramp, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(294754);
    s.u(paramj, "$msgHandler");
    s.u(paramp, "$msg");
    paramj.callback(paramp, s.X(paramp.function, ":ok"), null);
    AppMethodBeat.o(294754);
  }
  
  public static final boolean a(p paramp, j paramj, com.tencent.mm.plugin.webview.stub.f paramf)
  {
    int i = -1;
    AppMethodBeat.i(294678);
    s.u(paramp, "msg");
    s.u(paramj, "msgHandler");
    Object localObject = paramp.params.get("action");
    if (localObject == null)
    {
      paramp = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(294678);
      throw paramp;
    }
    localObject = (String)localObject;
    Log.i(TAG, "doHandleMPPageAction action=%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      paramj.callback(paramp, "handleMPPageAction:fail action is empty", null);
      AppMethodBeat.o(294678);
      return false;
    }
    new Bundle().putString("action", (String)localObject);
    if (s.p("paySuccess", localObject))
    {
      paramf = paramp.params;
      s.s(paramf, "msg.params");
      if (paramf.containsKey("fullUrl"))
      {
        paramf = paramp.params.get("fullUrl");
        if (paramf == null)
        {
          paramp = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(294678);
          throw paramp;
        }
      }
      for (paramf = (String)paramf;; paramf = (String)paramf)
      {
        localObject = paramp.params;
        s.s(localObject, "msg.params");
        if (!((Map)localObject).containsKey("itemShowType")) {
          break label296;
        }
        localObject = paramp.params.get("itemShowType");
        if (localObject != null) {
          break;
        }
        paramp = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(294678);
        throw paramp;
        paramf = paramp.params.get("url");
        if (paramf == null)
        {
          paramp = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(294678);
          throw paramp;
        }
      }
      i = Util.getInt((String)localObject, -1);
      label296:
      if (Util.isNullOrNil(paramf))
      {
        paramj.callback(paramp, "handleMPPageAction:fail_url_is_null", null);
        AppMethodBeat.o(294678);
        return true;
      }
      ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dB(paramf, i);
      paramj.callback(paramp, "handleMPPageAction:ok", null);
      AppMethodBeat.o(294678);
      return true;
    }
    if (s.p("isGPVersion", localObject))
    {
      paramf = new HashMap();
      localObject = (Map)paramf;
      if ((ChannelUtil.isGPVersion()) || (z.bBh())) {}
      for (i = 1;; i = 0)
      {
        ((Map)localObject).put("GPVersion", Integer.valueOf(i));
        paramj.callback(paramp, "handleMPPageAction:ok", (Map)paramf);
        AppMethodBeat.o(294678);
        return true;
      }
    }
    if (s.p("requestTeenModeTemporaryVisit", localObject))
    {
      boolean bool = b(paramp, paramj, paramf);
      AppMethodBeat.o(294678);
      return bool;
    }
    paramj.callback(paramp, "handleMPPageAction:fail, action not support", null);
    AppMethodBeat.o(294678);
    return false;
  }
  
  private static boolean b(p paramp, j paramj, com.tencent.mm.plugin.webview.stub.f paramf)
  {
    AppMethodBeat.i(294711);
    Object localObject1 = (r)com.tencent.mm.kernel.h.ax(r.class);
    if (localObject1 == null) {}
    for (boolean bool = false; !bool; bool = ((r)localObject1).aBu())
    {
      Log.w(TAG, s.X("requestTeenModeTemporaryVisit isTeenMode = ", Boolean.valueOf(bool)));
      paramj.callback(paramp, s.X(paramp.function, ":fail，not int teen mode now"), null);
      AppMethodBeat.o(294711);
      return true;
    }
    int k = Util.getInt((String)paramp.params.get("type"), 0);
    Object localObject2 = (String)paramp.params.get("title");
    localObject1 = (String)paramp.params.get("currentUrl");
    Object localObject5 = (String)paramp.params.get("coverUrl");
    Object localObject3 = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
    int i;
    if ((localObject3 != null) && (((com.tencent.mm.plugin.brandservice.api.c)localObject3).aiy((String)localObject1) == true))
    {
      i = 1;
      if (paramf != null) {
        break label614;
      }
    }
    Object localObject6;
    Object localObject4;
    String str1;
    int j;
    label416:
    label424:
    String str2;
    label450:
    label614:
    for (Object localObject7 = null;; localObject7 = paramf.m(206, new Bundle()))
    {
      if (localObject7 != null) {
        break label635;
      }
      try
      {
        localObject3 = new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        AppMethodBeat.o(294711);
        throw ((Throwable)localObject3);
      }
      catch (Exception localException1) {}
      Log.e(TAG, s.X("get info ex ", localException1.getMessage()));
      localObject6 = null;
      localObject4 = localObject5;
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject6;
      localObject6 = new k.b();
      ((k.b)localObject6).title = ((String)localObject1);
      ((k.b)localObject6).thumburl = ((String)localObject4);
      ((k.b)localObject6).url = ((String)localObject5);
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("<fromusr>").append(z.bAM()).append("</fromusr>");
      ((StringBuilder)localObject7).append("<type>49</type>");
      ((StringBuilder)localObject7).append("<content>").append(Util.escapeStringForXml(k.b.a((k.b)localObject6, null, null))).append("</content>");
      str1 = ((StringBuilder)localObject7).toString();
      s.s(str1, "sb.toString()");
      if (!Util.isNullOrNil((String)localObject4)) {
        break label794;
      }
      localObject6 = y.bi((String)localObject2, 0, -1);
      localObject7 = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
      if ((localObject7 == null) || (((com.tencent.mm.plugin.brandservice.api.c)localObject7).aiy((String)localObject5) != true)) {
        break label800;
      }
      j = 1;
      if (j == 0) {
        break label806;
      }
      j = 2;
      str2 = com.tencent.mm.plugin.webview.k.c.XsF.bmV((String)localObject5);
      if (i == 0) {
        break label812;
      }
      localObject7 = paramj.context.getString(c.i.webview_teen_mode_request_mp_article);
      s.s(localObject7, "if (isMpArticle) {\n     …quest_out_link)\n        }");
      Log.i(TAG, "requestTeenModeTemporaryVisit type=" + k + ", bizType=" + j + ", bizKey=" + str2 + " title=" + localObject1 + ", coverUrl=" + localObject4 + ", thumbPath=" + localObject2 + ", currentUrl=" + localObject5);
      localObject2 = paramj.context.getString(c.i.app_url);
      s.s(localObject2, "msgHandler.context.getString(R.string.app_url)");
      localObject4 = (com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class);
      localObject5 = paramj.context;
      if (localObject5 != null) {
        break label827;
      }
      paramp = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(294711);
      throw paramp;
      i = 0;
      break;
    }
    label635:
    if (i == 0)
    {
      localObject4 = ((Bundle)localObject7).getString("webview_current_url");
      localObject1 = localObject4;
    }
    for (;;)
    {
      for (;;)
      {
        label794:
        label800:
        label806:
        label812:
        label827:
        try
        {
          localObject4 = (CharSequence)localObject2;
          if (localObject4 == null) {
            break label929;
          }
          if (n.bp((CharSequence)localObject4))
          {
            break label929;
            if (j == 0) {
              break label923;
            }
            localObject4 = ((Bundle)localObject7).getString("webpageTitle");
            localObject2 = localObject4;
            localObject6 = localObject5;
          }
        }
        catch (Exception localException2) {}
        try
        {
          localObject4 = (CharSequence)localObject5;
          if (localObject4 == null) {
            break label935;
          }
          localObject6 = localObject5;
          if (n.bp((CharSequence)localObject4))
          {
            break label935;
            localObject4 = localObject5;
            if (j != 0)
            {
              localObject6 = localObject5;
              localObject4 = ((Bundle)localObject7).getString("thumbUrl");
            }
            localObject6 = localObject4;
            localObject5 = ((Bundle)localObject7).getString("thumbPath");
            localObject6 = localObject2;
            localObject2 = localObject5;
            localObject5 = localObject1;
            localObject1 = localObject6;
            break;
            j = 0;
            continue;
          }
          j = 0;
          continue;
          localObject6 = null;
        }
        catch (Exception localException3)
        {
          localObject5 = localObject6;
        }
      }
      j = 0;
      break label416;
      j = 3;
      break label424;
      localObject7 = paramj.context.getString(c.i.webview_teen_mode_request_out_link);
      break label450;
      if (!((com.tencent.mm.plugin.teenmode.a.d)localObject4).a((Activity)localObject5, k, j, str2, (String)localObject7, s.X((String)localObject2, Util.nullAsNil((String)localObject1)), str1, (byte[])localObject6, new f..ExternalSyntheticLambda1(k, paramj, paramp, paramf), new f..ExternalSyntheticLambda0(paramj, paramp))) {
        paramj.callback(paramp, s.X(paramp.function, ":fail"), null);
      }
      AppMethodBeat.o(294711);
      return true;
      break;
      break;
      label923:
      continue;
      continue;
      label929:
      j = 1;
      continue;
      label935:
      j = 1;
    }
  }
  
  public static final boolean c(p paramp, j paramj, com.tencent.mm.plugin.webview.stub.f paramf)
  {
    AppMethodBeat.i(294735);
    s.u(paramp, "msg");
    s.u(paramj, "msgHandler");
    if (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(5))
    {
      AppMethodBeat.o(294735);
      return false;
    }
    int i = paramp.WEI.optInt("itemType", -1);
    paramj = new Bundle();
    if (i >= 0)
    {
      paramj.putString("url", paramp.WEI.optString("jumpUrl"));
      paramj.putInt("item_show_type", i);
      paramj.putInt("scene", paramp.WEI.optInt("scene"));
      paramj.putInt("openType", -1);
      paramj.putString("KPublisherId", paramp.WEI.optString("publishId"));
      paramj.putInt("geta8key_scene", 65);
      if (i == 5)
      {
        if (paramp.WEI.has("currentInfo")) {
          paramj.putString("currentInfo", paramp.WEI.optString("currentInfo"));
        }
        if (paramp.WEI.has("scene")) {
          paramj.putInt("biz_video_scene", paramp.WEI.optInt("scene"));
        }
        paramj.putInt(f.b.adwc, paramp.WEI.optInt("subScene"));
        paramj.putInt("biz_video_session_id", ad.getSessionId());
        paramj.putBoolean("isNativePage", true);
        paramp = paramp.WEI;
        s.s(paramp, "msg.rawParams");
        s.u(paramj, "bundle");
        s.u(paramp, "data");
      }
      switch (i)
      {
      default: 
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1061L, 20L, 1L, false);
        if (paramf != null) {
          break;
        }
      }
    }
    for (paramp = null;; paramp = paramf.m(200, paramj))
    {
      if ((paramp == null) || (!paramp.getBoolean("success"))) {
        break label583;
      }
      AppMethodBeat.o(294735);
      return true;
      AppMethodBeat.o(294735);
      return false;
      x localx = new x();
      localx.hEE = paramp.optString("srcUserName");
      localx.nUF = paramp.optString("srcDisplayName");
      if (paramp.has("url")) {
        localx.nUG.url = paramp.optString("url");
      }
      for (;;)
      {
        localx.nUG.title = paramp.optString("title");
        localx.nUG.nUO = paramp.optString("digest");
        localx.nUG.nUM = paramp.optString("cover");
        localx.nUG.type = i;
        localx.nUG.time = paramp.optInt("pubTime");
        localx.nUG.nUQ = paramp.optInt("duration");
        localx.nUG.videoWidth = paramp.optInt("videoWidth");
        localx.nUG.videoHeight = paramp.optInt("videoHeight");
        localx.nUG.vid = paramp.optString("vid");
        localx.N(paramj);
        break;
        if (paramp.has("jumpUrl")) {
          localx.nUG.url = paramp.optString("jumpUrl");
        }
      }
    }
    label583:
    AppMethodBeat.o(294735);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(p paramp, com.tencent.mm.plugin.webview.stub.f paramf, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.f
 * JD-Core Version:    0.7.0.1
 */