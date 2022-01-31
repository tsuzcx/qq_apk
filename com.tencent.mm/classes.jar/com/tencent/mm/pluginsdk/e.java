package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.hw.a;
import com.tencent.mm.g.a.il;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e
{
  private static boolean vJs;
  public static String vJt;
  private static final Map<String, Long> vJu;
  
  static
  {
    AppMethodBeat.i(11681);
    vJs = false;
    vJt = "";
    HashMap localHashMap = new HashMap();
    vJu = localHashMap;
    localHashMap.put("weixin://", Long.valueOf(0L));
    vJu.put("weixin://dl/stickers", Long.valueOf(1L));
    vJu.put("weixin://dl/games", Long.valueOf(2L));
    vJu.put("weixin://dl/moments", Long.valueOf(4L));
    vJu.put("weixin://dl/add", Long.valueOf(8L));
    vJu.put("weixin://dl/shopping", Long.valueOf(16L));
    vJu.put("weixin://dl/groupchat", Long.valueOf(32L));
    vJu.put("weixin://dl/scan", Long.valueOf(64L));
    vJu.put("weixin://dl/profile", Long.valueOf(128L));
    vJu.put("weixin://dl/settings", Long.valueOf(256L));
    vJu.put("weixin://dl/general", Long.valueOf(512L));
    vJu.put("weixin://dl/help", Long.valueOf(1024L));
    vJu.put("weixin://dl/notifications", Long.valueOf(2048L));
    vJu.put("weixin://dl/terms", Long.valueOf(4096L));
    vJu.put("weixin://dl/chat", Long.valueOf(8192L));
    vJu.put("weixin://dl/features", Long.valueOf(16384L));
    vJu.put("weixin://dl/clear", Long.valueOf(32768L));
    vJu.put("weixin://dl/feedback", Long.valueOf(65536L));
    vJu.put("weixin://dl/faq", Long.valueOf(131072L));
    vJu.put("weixin://dl/recommendation", Long.valueOf(262144L));
    vJu.put("weixin://dl/groups", Long.valueOf(524288L));
    vJu.put("weixin://dl/tags", Long.valueOf(1048576L));
    vJu.put("weixin://dl/officialaccounts", Long.valueOf(2097152L));
    vJu.put("weixin://dl/posts", Long.valueOf(4194304L));
    vJu.put("weixin://dl/favorites", Long.valueOf(8388608L));
    vJu.put("weixin://dl/privacy", Long.valueOf(16777216L));
    vJu.put("weixin://dl/security", Long.valueOf(33554432L));
    vJu.put("weixin://dl/wallet", Long.valueOf(67108864L));
    vJu.put("weixin://dl/businessPay", Long.valueOf(134217728L));
    vJu.put("weixin://dl/businessPay/", Long.valueOf(134217728L));
    vJu.put("weixin://dl/wechatout", Long.valueOf(268435456L));
    vJu.put("weixin://dl/protection", Long.valueOf(1073741824L));
    vJu.put("weixin://dl/card", Long.valueOf(2147483648L));
    vJu.put("weixin://dl/about", Long.valueOf(1125899906842624L));
    vJu.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
    vJu.put("weixin://dl/textsize", Long.valueOf(8589934592L));
    vJu.put("weixin://dl/sight", Long.valueOf(17179869184L));
    vJu.put("weixin://dl/languages", Long.valueOf(34359738368L));
    vJu.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
    vJu.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
    vJu.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
    vJu.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
    vJu.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
    vJu.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
    vJu.put("weixin://dl/setname", Long.valueOf(4398046511104L));
    vJu.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
    vJu.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
    vJu.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
    vJu.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
    vJu.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
    vJu.put("weixin://dl/log", Long.valueOf(281474976710656L));
    vJu.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
    vJu.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
    vJu.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
    vJu.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
    vJu.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
    vJu.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    vJu.put("weixin://dl/offlinepay/", Long.valueOf(576460752303423490L));
    AppMethodBeat.o(11681);
  }
  
  public static void A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(11679);
    if (akY(paramString2))
    {
      AppMethodBeat.o(11679);
      return;
    }
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramContext, "", true, null);
    int j = 6;
    int i = j;
    if (!bo.isNullOrNil(paramString1))
    {
      if (!com.tencent.mm.model.t.lA(paramString1)) {
        break label77;
      }
      i = 7;
    }
    for (;;)
    {
      a(paramContext, paramString2, i, new e.4(localp, paramContext));
      AppMethodBeat.o(11679);
      return;
      label77:
      i = j;
      if (com.tencent.mm.model.t.nU(paramString1)) {
        i = 9;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Bundle paramBundle, e.a parama)
  {
    AppMethodBeat.i(11671);
    a(paramContext, paramString, paramInt, paramBundle, parama, null, null);
    AppMethodBeat.o(11671);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, e.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(11669);
    LinkedList localLinkedList = new LinkedList();
    df localdf = new df();
    if ((!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(paramString3)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[] { paramString2, paramString3 });
      localdf.kWn = paramString2;
      localdf.signature = paramString3;
      localLinkedList.add(localdf);
    }
    if (akY(paramString1))
    {
      AppMethodBeat.o(11669);
      return;
    }
    paramString2 = new com.tencent.mm.modelsimple.ab(paramString1, paramInt, localLinkedList);
    paramContext = new e.2(paramBundle, paramContext, paramInt, paramString1, parama);
    com.tencent.mm.kernel.g.Rc().a(1200, paramContext);
    com.tencent.mm.kernel.g.Rc().a(paramString2, 0);
    AppMethodBeat.o(11669);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, e.a parama)
  {
    AppMethodBeat.i(11670);
    a(paramContext, paramString, paramInt, null, parama, null, null);
    AppMethodBeat.o(11670);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, e.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(11668);
    a(paramContext, paramString1, paramInt, null, parama, paramString2, paramString3);
    AppMethodBeat.o(11668);
  }
  
  public static void a(Context paramContext, final String paramString1, final String paramString2, final int paramInt, String paramString3, final e.a parama)
  {
    AppMethodBeat.i(11667);
    if (bo.isNullOrNil(paramString1)) {
      paramString1 = paramString3;
    }
    while (akY(paramString1))
    {
      AppMethodBeat.o(11667);
      return;
    }
    paramString3 = new com.tencent.mm.modelsimple.j(paramString1, paramString2, paramInt, 0, (int)System.currentTimeMillis(), new byte[0]);
    paramContext = new com.tencent.mm.ai.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(11655);
        com.tencent.mm.kernel.g.Rc().b(233, this);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        boolean bool2 = false;
        boolean bool3 = false;
        boolean bool1 = bool3;
        com.tencent.mm.modelsimple.j localj;
        String str;
        if (paramAnonymousm != null)
        {
          bool1 = bool3;
          if ((paramAnonymousm instanceof com.tencent.mm.modelsimple.j))
          {
            localj = (com.tencent.mm.modelsimple.j)paramAnonymousm;
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DeepLinkHelper", "bitset:" + localj.ajr());
            long l = localj.ajr();
            str = localj.ajl();
            if (!e.aW(str, l)) {
              break label338;
            }
          }
        }
        for (bool1 = bool2;; bool1 = true)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
            bool1 = bool2;
            bool2 = e.a(this.val$context, localj.ajt(), localj.ajv(), str);
            bool1 = bool2;
            com.tencent.mm.plugin.report.service.h.qsU.e(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(paramInt), paramString2, bo.nullAsNil(paramString1) });
            bool1 = bool2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
              com.tencent.mm.plugin.report.service.h.qsU.e(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(paramInt), paramString2, bo.nullAsNil(paramString1) });
            }
          }
          if (parama != null) {
            parama.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousm, bool1);
          }
          AppMethodBeat.o(11655);
          return;
          label338:
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
          Intent localIntent = new Intent();
          localIntent.setFlags(268435456);
          localIntent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          localIntent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
          localIntent.putExtra("geta8key_session_id", localException.ajt());
          localIntent.putExtra("geta8key_cookie", localException.ajv());
          ah.getContext().startActivity(localIntent);
          com.tencent.mm.plugin.report.service.h.qsU.e(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(paramInt), paramString2, bo.nullAsNil(paramString1) });
        }
      }
    };
    com.tencent.mm.kernel.g.Rc().a(233, paramContext);
    com.tencent.mm.kernel.g.Rc().a(paramString3, 0);
    AppMethodBeat.o(11667);
  }
  
  public static boolean a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(11673);
    boolean bool = a(paramContext, paramString, 0, null, paramInt, paramArrayOfByte, null);
    AppMethodBeat.o(11673);
    return bool;
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt1, Bundle paramBundle, int paramInt2, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(11675);
    Object localObject1 = ala(paramString1);
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(11675);
      return false;
    }
    long l;
    Object localObject2;
    if (vJu.containsKey(localObject1))
    {
      l = ((Long)vJu.get(localObject1)).longValue();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", new Object[] { Long.valueOf(l) });
      localObject2 = null;
      localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      if (l == 0L)
      {
        paramBundle = "com.tencent.mm.ui.LauncherUI";
        paramString2 = (String)localObject1;
        if (bo.isNullOrNil(paramBundle)) {
          break label3540;
        }
        paramString2.setClassName(ah.getContext(), paramBundle);
        if (paramContext == null) {
          break label3499;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        String str1;
        String str2;
        String str3;
        String str4;
        Object localObject3;
        for (;;)
        {
          paramContext.startActivity(paramString2);
          AppMethodBeat.o(11675);
          return true;
          if (l == 1L)
          {
            paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
            com.tencent.mm.plugin.report.service.h.qsU.e(12065, new Object[] { Integer.valueOf(7) });
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 2L)
          {
            ((Intent)localObject1).putExtra("from_deeplink", true);
            ((Intent)localObject1).putExtra("game_report_from_scene", 6);
            paramBundle = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 4L)
          {
            if ((r.Zy() & 0x8000) == 0) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              paramBundle = (Bundle)localObject2;
              paramString2 = (String)localObject1;
              if (paramInt1 == 0) {
                break;
              }
              paramBundle = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
              ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", true);
              paramString2 = (String)localObject1;
              break;
            }
          }
          if (l == 8L)
          {
            paramBundle = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 16L)
          {
            paramString1 = new hw();
            com.tencent.mm.sdk.b.a.ymk.l(paramString1);
            paramString1 = paramString1.cxf.url;
            paramBundle = (Bundle)localObject2;
            paramString2 = (String)localObject1;
            if (bo.isNullOrNil(paramString1)) {
              break;
            }
            ((Intent)localObject1).putExtra("rawUrl", paramString1);
            ((Intent)localObject1).putExtra("useJs", true);
            ((Intent)localObject1).putExtra("vertical_scroll", true);
            ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
            ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
            paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 32L)
          {
            ((Intent)localObject1).putExtra("titile", ah.getContext().getString(2131296500));
            ((Intent)localObject1).putExtra("list_type", 0);
            ((Intent)localObject1).putExtra("list_attr", com.tencent.mm.ui.contact.t.F(new int[] { com.tencent.mm.ui.contact.t.AdV, 256, 512 }));
            paramBundle = "com.tencent.mm.ui.contact.SelectContactUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 64L)
          {
            paramBundle = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
            ((Intent)localObject1).putExtra("animation_pop_in", true);
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 128L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 256L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 512L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 1024L)
          {
            af(ah.getContext(), paramInt2);
            paramBundle = (Bundle)localObject2;
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 2048L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 4096L)
          {
            ((Intent)localObject1).putExtra("title", ah.getContext().getResources().getString(2131302170));
            ((Intent)localObject1).putExtra("rawUrl", ah.getContext().getResources().getString(2131304454));
            ((Intent)localObject1).putExtra("showShare", false);
            ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
            ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
            paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 8192L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 16384L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 32768L)
          {
            paramBundle = "com.tencent.mm.plugin.clean.ui.CleanUI";
            paramString2 = (String)localObject1;
            break;
          }
          if (l == 65536L) {
            try
            {
              paramInt1 = paramString1.indexOf("?");
              if (paramInt1 <= 0) {
                break label5452;
              }
              paramString1 = paramString1.substring(paramInt1 + 1);
              com.tencent.mm.kernel.g.RJ();
              paramInt1 = com.tencent.mm.kernel.a.getUin();
              paramBundle = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
              paramString2 = URLEncoder.encode(bo.dtS(), "utf-8");
              str1 = URLEncoder.encode(q.bP(true), "utf-8");
              str2 = URLEncoder.encode(com.tencent.mm.protocal.d.whB, "utf-8");
              str3 = URLEncoder.encode(com.tencent.mm.protocal.d.whC, "utf-8");
              str4 = URLEncoder.encode(com.tencent.mm.protocal.d.whD, "utf-8");
              localObject3 = URLEncoder.encode(com.tencent.mm.kernel.a.QX(), "utf-8");
              String str5 = URLEncoder.encode(bo.hk(ah.getContext()), "utf-8");
              paramBundle = new StringBuilder("&uin=").append(paramInt1).append("&deviceName=").append(paramBundle).append("&timeZone=").append(paramString2).append("&imei=").append(str1).append("&deviceBrand=").append(str2).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append((String)localObject3).append("&signature=").append(str5).append("&scene=");
              if (bo.isNullOrNil(paramString1)) {}
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                paramBundle = paramInt1;
                paramString1 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.whH + "&lang=" + aa.gP(ah.getContext()) + "&" + bo.nullAsNil(paramString1) + paramBundle;
                ((Intent)localObject1).putExtra("showShare", false);
                ((Intent)localObject1).putExtra("rawUrl", paramString1);
                ((Intent)localObject1).putExtra("neverGetA8Key", true);
                ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
                ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
                ((Intent)localObject1).putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
                ((Intent)localObject1).putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
                paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                paramString2 = (String)localObject1;
                break;
              }
            }
            catch (UnsupportedEncodingException paramString1)
            {
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramString1.getMessage() });
              paramBundle = (Bundle)localObject2;
              paramString2 = (String)localObject1;
            }
          }
        }
        if (l == 131072L)
        {
          com.tencent.mm.kernel.g.RJ();
          paramInt1 = com.tencent.mm.kernel.a.getUin();
          i = bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12304, null));
          paramString1 = ah.getContext().getString(2131303468, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          ((Intent)localObject1).putExtra("showShare", false);
          ((Intent)localObject1).putExtra("rawUrl", paramString1);
          ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
          ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
          paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 262144L)
        {
          paramBundle = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 524288L)
        {
          paramBundle = "com.tencent.mm.ui.contact.ChatroomContactUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 1048576L)
        {
          paramBundle = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 2097152L)
        {
          paramBundle = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 268435456L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bq.d.b(ah.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject1);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 4194304L)
        {
          ((Intent)localObject1).putExtra("sns_userName", (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null));
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("sns_adapter_type", 1);
          paramInt1 = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(68389, null), 0);
          com.tencent.mm.kernel.g.RL().Ru().set(68389, Integer.valueOf(paramInt1 + 1));
          paramBundle = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 8388608L)
        {
          paramBundle = "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 16777216L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 33554432L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 67108864L)
        {
          paramBundle = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 134217728L)
        {
          if ((paramContext != null) && (!bo.isNullOrNil(paramString1)) && (paramString1.startsWith("weixin://dl/businessPay")))
          {
            paramBundle = Uri.parse(paramString1);
            if (paramBundle == null) {
              continue;
            }
            paramString1 = paramBundle.getQueryParameter("reqkey");
            paramArrayOfByte = paramBundle.getQueryParameter("appid");
            if (!bo.isNullOrNil(paramString1))
            {
              paramBundle = new PayInfo();
              paramBundle.cnI = paramString1;
              paramBundle.appId = paramArrayOfByte;
              paramBundle.cCD = 36;
              paramBundle.nnQ = false;
              paramString2 = new Intent();
              paramString2.putExtra("key_pay_info", paramBundle);
              if ((paramContext instanceof Activity))
              {
                paramString2.putExtra("key_context_hashcode", paramContext.hashCode());
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "startPay context %s %s", new Object[] { paramContext, Integer.valueOf(paramContext.hashCode()) });
              }
              if (r.ZB())
              {
                com.tencent.mm.bq.d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramString2, 1);
                paramBundle = (Bundle)localObject2;
                break;
              }
              com.tencent.mm.bq.d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramString2, 1);
              paramBundle = (Bundle)localObject2;
              break;
            }
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.DeepLinkHelper", "reqkey null");
          }
          paramString2 = null;
          paramBundle = (Bundle)localObject2;
          break;
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.DeepLinkHelper", "payUri null");
          continue;
        }
        if (l == 1073741824L)
        {
          paramBundle = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 2147483648L)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
          paramString1 = new il();
          paramString1.cxQ.context = paramContext;
          com.tencent.mm.sdk.b.a.ymk.l(paramString1);
          paramBundle = (Bundle)localObject2;
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 4294967296L)
        {
          ((Intent)localObject1).putExtra("filter_type", com.tencent.mm.model.z.oS(ah.getContext().getString(2131300540)).getType());
          ((Intent)localObject1).putExtra("titile", ah.getContext().getString(2131303391));
          ((Intent)localObject1).putExtra("list_attr", 32768);
          paramBundle = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 8589934592L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 17179869184L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 34359738368L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 68719476736L)
        {
          paramBundle = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 137438953472L)
        {
          ((Intent)localObject1).setClassName(ah.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindQQUI");
          MMWizardActivity.J(paramContext, (Intent)localObject1);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 274877906944L)
        {
          ((Intent)localObject1).setClassName(ah.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI");
          MMWizardActivity.J(paramContext, (Intent)localObject1);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 549755813888L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 1099511627776L)
        {
          com.tencent.mm.bq.d.b(ah.getContext(), "profile", ".ui.ContactInfoUI", ((Intent)localObject1).putExtra("Contact_User", "qqsync"));
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 2199023255552L)
        {
          paramBundle = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 4398046511104L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 8796093022208L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 17592186044416L)
        {
          ((Intent)localObject1).putExtra("launch_from_webview", false);
          com.tencent.mm.bq.d.c(ah.getContext(), "address", ".ui.WalletSelectAddrUI", (Intent)localObject1);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 35184372088832L)
        {
          ((Intent)localObject1).putExtra("k_sns_tag_id", 4L);
          ((Intent)localObject1).putExtra("k_sns_from_settings_about_sns", 1);
          com.tencent.mm.bq.d.b(ah.getContext(), "sns", ".ui.SnsBlackDetailUI", (Intent)localObject1);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 70368744177664L)
        {
          ((Intent)localObject1).putExtra("k_sns_tag_id", 5L);
          ((Intent)localObject1).putExtra("k_sns_from_settings_about_sns", 2);
          ((Intent)localObject1).putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.bq.d.b(ah.getContext(), "sns", ".ui.SnsTagDetailUI", (Intent)localObject1);
          paramBundle = (Bundle)localObject2;
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 140737488355328L)
        {
          paramBundle = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 281474976710656L)
        {
          paramContext = new bz();
          paramContext.cpw.cpy = "//uplog";
          paramContext.cpw.context = ah.getContext();
          com.tencent.mm.sdk.b.a.ymk.l(paramContext);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 562949953421312L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bq.d.b(ah.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject1);
          com.tencent.mm.bq.d.b(ah.getContext(), "ipcall", ".ui.IPCallShareCouponUI", (Intent)localObject1);
          AppMethodBeat.o(11675);
          return true;
        }
        if (l == 18014398509481984L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bq.d.b(ah.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject1);
          com.tencent.mm.bq.d.b(ah.getContext(), "ipcall", ".ui.IPCallShareCouponUI", (Intent)localObject1);
          com.tencent.mm.bq.d.b(ah.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", (Intent)localObject1);
          paramBundle = (Bundle)localObject2;
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 576460752303423488L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          ((Intent)localObject1).setClassName(ah.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
          ah.getContext().startActivity((Intent)localObject1);
          paramBundle = (Bundle)localObject2;
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 1125899906842624L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 4503599627370496L)
        {
          ((Intent)localObject1).putExtra("emoji_tab", 1);
          paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
          com.tencent.mm.plugin.report.service.h.qsU.e(12065, new Object[] { Integer.valueOf(7) });
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 9007199254740992L)
        {
          paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 576460752303423489L)
        {
          paramString1 = Uri.parse(paramString1);
          paramArrayOfByte = paramString1.getQueryParameter("appid");
          localObject1 = paramString1.getQueryParameter("userName");
          localObject2 = paramString1.getQueryParameter("path");
          i = bo.getInt(bo.nullAsNil(paramString1.getQueryParameter("pathType")), 0);
          str1 = paramString1.getQueryParameter("invokeData");
          str2 = paramString1.getQueryParameter("runtimeSessionId");
          str3 = paramString1.getQueryParameter("runtimeTicket");
          str4 = paramString1.getQueryParameter("runtimeAppid");
          paramInt2 = 0;
          paramString1 = v.aae().z("key_data_center_session_id", false);
          if (paramString1 != null) {
            paramInt2 = ((Integer)paramString1.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", new Object[] { paramArrayOfByte, localObject1, localObject2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          v.aae().oP("key_data_center_session_id");
          localObject3 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject3).cmF = URLEncoder.encode(paramString2);
          if (paramInt1 == 2)
          {
            ((AppBrandStatObject)localObject3).scene = 1065;
            ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, (String)localObject2, (AppBrandStatObject)localObject3);
            AppMethodBeat.o(11675);
            return true;
          }
          if (paramInt1 == 1)
          {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DeepLinkHelper", "pathType:%d invokeData:%s", new Object[] { Integer.valueOf(i), str1 });
            if ((1 == i) && (!bo.isNullOrNil(str1)))
            {
              paramString1 = "";
              try
              {
                paramBundle = new com.tencent.mm.aa.i(str1).optString("name");
                paramString1 = paramBundle;
              }
              catch (com.tencent.mm.aa.g paramBundle)
              {
                com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramBundle, "", new Object[0]);
                continue;
              }
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "runtimeSessionId:%s runtimeTicket:%s runtimeAppId:%s functionName:%s", new Object[] { str2, str3, str4, paramString1 });
              ((AppBrandStatObject)localObject3).scene = 1111;
              ((AppBrandStatObject)localObject3).cmF = (str4 + ":" + paramString1);
              ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, (String)localObject1, paramInt2, (String)localObject2, (AppBrandStatObject)localObject3, paramArrayOfByte, str1);
              continue;
            }
            ((AppBrandStatObject)localObject3).scene = 1069;
            ((AppBrandStatObject)localObject3).cmF = paramArrayOfByte;
            ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, (String)localObject2, (AppBrandStatObject)localObject3, paramArrayOfByte);
            continue;
          }
          if (paramInt1 == 6)
          {
            ((AppBrandStatObject)localObject3).scene = 1007;
            ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, (String)localObject2, (AppBrandStatObject)localObject3);
            continue;
          }
          if (paramInt1 == 7)
          {
            ((AppBrandStatObject)localObject3).scene = 1008;
            ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, (String)localObject2, (AppBrandStatObject)localObject3);
            continue;
          }
          ((AppBrandStatObject)localObject3).scene = 1000;
          ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, (String)localObject1, null, 0, 0, (String)localObject2, (AppBrandStatObject)localObject3);
          continue;
        }
        paramBundle = (Bundle)localObject2;
        paramString2 = (String)localObject1;
        if (l != 576460752303423490L) {
          break;
        }
        paramString1 = Uri.parse(paramString1).getQueryParameter("appid");
        paramBundle = new Intent();
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletManager", "start offline from sdk: %s", new Object[] { paramString1 });
        paramBundle.putExtra("key_from_scene", 8);
        paramBundle.putExtra("key_appid", paramString1);
        com.tencent.mm.bq.d.b(paramContext, "offline", ".ui.WalletOfflineEntranceUI", paramBundle, 0);
        paramBundle = (Bundle)localObject2;
        paramString2 = (String)localObject1;
        break;
        label3499:
        ah.getContext().startActivity(paramString2);
        com.tencent.mm.ui.base.b.K(ah.getContext(), paramString2);
        continue;
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
        continue;
      }
      label3540:
      AppMethodBeat.o(11675);
      return false;
      if (((String)localObject1).startsWith("weixin://dl/businessTempSession/"))
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setFlags(268435456);
        paramString2 = Uri.parse(paramString1);
        if (paramString2 == null)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
          AppMethodBeat.o(11675);
          return false;
        }
        localObject1 = paramString2.getQueryParameter("sessionFrom");
        localObject2 = paramString2.getQueryParameter("showtype");
        paramBundle = paramString2.getQueryParameter("username");
        if (!bo.isNullOrNil(paramBundle)) {
          break label5449;
        }
        paramBundle = paramString2.getQueryParameter("userName");
      }
      label5429:
      label5449:
      for (;;)
      {
        if (bo.isNullOrNil(paramBundle))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
          AppMethodBeat.o(11675);
          return false;
        }
        i = bo.getInt(bo.nullAsNil(paramString2.getQueryParameter("scene")), 0);
        paramInt2 = paramInt1;
        if (i != 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == 4)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to ".concat(String.valueOf(i)));
            paramInt2 = i;
          }
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", new Object[] { paramBundle, localObject1, Integer.valueOf(paramInt2), paramString1, localObject2 });
        paramArrayOfByte.setClassName(ah.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
        paramArrayOfByte.putExtra("Chat_User", paramBundle);
        paramArrayOfByte.putExtra("finish_direct", true);
        paramArrayOfByte.putExtra("key_is_temp_session", true);
        paramArrayOfByte.putExtra("key_temp_session_from", (String)localObject1);
        paramArrayOfByte.putExtra("key_temp_session_scene", paramInt2);
        paramArrayOfByte.putExtra("key_temp_session_show_type", bo.getInt((String)localObject2, 0));
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramBundle);
        if ((paramString1 == null) || ((int)paramString1.euF <= 0)) {
          ao.a.flI.a(paramBundle, "", new e.3(paramArrayOfByte, paramContext));
        }
        for (;;)
        {
          AppMethodBeat.o(11675);
          return true;
          paramContext.startActivity(paramArrayOfByte);
        }
        if ((((String)localObject1).startsWith("weixin://dl/businessGame/detail/")) || (((String)localObject1).startsWith("weixin://dl/businessGame/detail")))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
          paramArrayOfByte = Uri.parse(paramString1);
          paramString1 = null;
          paramBundle = new Intent();
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = paramArrayOfByte.getQueryParameter("appid");
            paramString1 = "com.tencent.mm.plugin.game.ui.GameDetailUI";
            paramBundle.putExtra("game_app_id", paramArrayOfByte);
            paramBundle.putExtra("game_report_from_scene", 6);
          }
          if (!bo.isNullOrNil(paramString1))
          {
            paramBundle.setClassName(ah.getContext(), paramString1);
            if (paramContext != null) {}
            try
            {
              paramContext.startActivity(paramBundle);
              for (;;)
              {
                AppMethodBeat.o(11675);
                return true;
                ah.getContext().startActivity(paramBundle);
                com.tencent.mm.ui.base.b.K(ah.getContext(), paramBundle);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
          AppMethodBeat.o(11675);
          return false;
        }
        if ((((String)localObject1).startsWith("weixin://dl/businessGame/library/")) || (((String)localObject1).startsWith("weixin://dl/businessGame/library")))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
          paramString1 = new Intent();
          if (!bo.isNullOrNil("com.tencent.mm.plugin.game.ui.GameLibraryUI"))
          {
            paramString1.putExtra("game_report_from_scene", 6);
            paramString1.setClassName(ah.getContext(), "com.tencent.mm.plugin.game.ui.GameLibraryUI");
            if (paramContext != null) {}
            try
            {
              paramContext.startActivity(paramString1);
              for (;;)
              {
                AppMethodBeat.o(11675);
                return true;
                ah.getContext().startActivity(paramString1);
                com.tencent.mm.ui.base.b.K(ah.getContext(), paramString1);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
          AppMethodBeat.o(11675);
          return false;
        }
        if ((((String)localObject1).startsWith("weixin://dl/businessWebview/link/")) || (((String)localObject1).startsWith("weixin://dl/businessWebview/link")))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
          paramString2 = Uri.parse(paramString1);
          localObject1 = new Intent();
          paramString1 = null;
          int j;
          if (paramString2 != null)
          {
            paramString1 = paramString2.getQueryParameter("url");
            i = bo.getInt(paramString2.getQueryParameter("type"), 0);
            localObject2 = bo.nullAsNil(paramString2.getQueryParameter("appid"));
            j = bo.getInt(bo.nullAsNil(paramString2.getQueryParameter("outer")), 0);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", new Object[] { paramString1, localObject2, Integer.valueOf(paramInt1), Integer.valueOf(j) });
            paramString2 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            ((Intent)localObject1).putExtra("rawUrl", paramString1);
            ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
            ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
            if (paramInt1 != 1) {
              break label4586;
            }
            if (j == 1)
            {
              ((Intent)localObject1).putExtra("geta8key_open_webview_appid", (String)localObject2);
              ((Intent)localObject1).putExtra("geta8key_scene", 53);
            }
            ((Intent)localObject1).putExtra("show_openapp_dialog", false);
            ((Intent)localObject1).putExtra("pay_channel", 40);
            com.tencent.mm.pluginsdk.wallet.j.Mx(39);
          }
          for (;;)
          {
            if (i == 5)
            {
              ((Intent)localObject1).putExtra("webview_invoke_launch_app_when_back", true);
              ((Intent)localObject1).putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(-2) }));
              ((Intent)localObject1).putExtra("KAppId", (String)localObject2);
            }
            ((Intent)localObject1).putExtra("transaction_for_openapi_openwebview", vJt);
            paramString1 = paramString2;
            if (paramBundle != null)
            {
              ((Intent)localObject1).putExtras(paramBundle);
              paramString1 = paramString2;
            }
            if (!bo.isNullOrNil(paramString1))
            {
              ((Intent)localObject1).setClassName(ah.getContext(), paramString1);
              if (paramContext != null) {}
              try
              {
                paramContext.startActivity((Intent)localObject1);
                for (;;)
                {
                  AppMethodBeat.o(11675);
                  return true;
                  label4586:
                  if (paramInt1 != 2) {
                    break;
                  }
                  if (j == 1)
                  {
                    ((Intent)localObject1).putExtra("geta8key_open_webview_appid", (String)localObject2);
                    ((Intent)localObject1).putExtra("geta8key_scene", 52);
                  }
                  ((Intent)localObject1).putExtra("pay_channel", 39);
                  com.tencent.mm.pluginsdk.wallet.j.Mx(39);
                  break;
                  ah.getContext().startActivity((Intent)localObject1);
                  com.tencent.mm.ui.base.b.K(ah.getContext(), (Intent)localObject1);
                }
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
                }
              }
            }
          }
          AppMethodBeat.o(11675);
          return false;
        }
        if (((String)localObject1).startsWith("weixin://dl/openbusinesswebview/link/"))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith openbusinesswebview");
          paramString2 = Uri.parse(paramString1);
          localObject1 = new Intent();
          paramString1 = null;
          if (paramString2 != null)
          {
            paramString1 = paramString2.getQueryParameter("url");
            i = bo.getInt(paramString2.getQueryParameter("type"), 0);
            localObject2 = bo.nullAsNil(paramString2.getQueryParameter("appid"));
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s", new Object[] { paramString1, localObject2, Integer.valueOf(paramInt1) });
            paramString2 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            ((Intent)localObject1).putExtra("rawUrl", paramString1);
            ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
            ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
            ((Intent)localObject1).putExtra("geta8key_open_webview_appid", (String)localObject2);
            ((Intent)localObject1).putExtra("geta8key_scene", 57);
            ((Intent)localObject1).putExtra("show_openapp_dialog", false);
            ((Intent)localObject1).putExtra("webview_invoke_launch_app_when_back", true);
            ((Intent)localObject1).putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://openbusinesswebview?type=%d&ret=%d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(-2) }));
            ((Intent)localObject1).putExtra("KAppId", (String)localObject2);
            ((Intent)localObject1).putExtra("transaction_for_openapi_openwebview", vJt);
            paramString1 = paramString2;
            if (paramBundle != null)
            {
              ((Intent)localObject1).putExtras(paramBundle);
              paramString1 = paramString2;
            }
          }
          if (!bo.isNullOrNil(paramString1))
          {
            ((Intent)localObject1).setClassName(ah.getContext(), paramString1);
            if (paramContext != null) {}
            try
            {
              paramContext.startActivity((Intent)localObject1);
              for (;;)
              {
                AppMethodBeat.o(11675);
                return true;
                ah.getContext().startActivity((Intent)localObject1);
                com.tencent.mm.ui.base.b.K(ah.getContext(), (Intent)localObject1);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
          AppMethodBeat.o(11675);
          return false;
        }
        if ((((String)localObject1).startsWith("weixin://dl/jumpFakeWxa/")) || (((String)localObject1).startsWith("weixin://dl/openNativeView/")))
        {
          paramString1 = Uri.parse(paramString1);
          paramArrayOfByte = paramString1.getQueryParameter("appid");
          paramString2 = paramString1.getQueryParameter("businessType");
          paramBundle = null;
          paramString1 = null;
          paramInt2 = 0;
          localObject2 = v.aae().z("key_data_center_session_id", false);
          if (localObject2 != null)
          {
            paramInt2 = ((Integer)((v.b)localObject2).get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
            paramBundle = (String)((v.b)localObject2).get("key_launch_miniprogram_query_info", "");
            paramString1 = (String)((v.b)localObject2).get("key_open_business_view_ext_info", "");
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "appid = %s, translateLinkScene = %d, type = %d", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          v.aae().oP("key_data_center_session_id");
          if (((String)localObject1).startsWith("weixin://dl/jumpFakeWxa/"))
          {
            if (paramInt1 == 1)
            {
              ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(paramContext, paramArrayOfByte, paramString2, paramBundle, paramInt2);
              AppMethodBeat.o(11675);
              return true;
            }
            AppMethodBeat.o(11675);
            return false;
          }
          paramContext = b.vJo;
          if (paramString2 != null) {}
          switch (paramString2.hashCode())
          {
          default: 
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label5429;
            }
            AppMethodBeat.o(11675);
            return true;
            if (!paramString2.equals("nativeEmergencyContact")) {
              break;
            }
            a.f.b.j.q(paramString2, "businessType");
            com.tencent.mm.pluginsdk.ui.tools.i.c(paramString2, "testExtMsg", paramArrayOfByte, -3, "testErrMsg");
            paramInt1 = 1;
            continue;
            if (!paramString2.equals("nativeShareToHaokan")) {
              break;
            }
            a.f.b.j.q(paramString2, "businessType");
            com.tencent.mm.plugin.topstory.ui.d.ar(paramString2, paramArrayOfByte, paramString1);
            paramInt1 = 1;
            continue;
            if (!paramString2.equals("nativeShareToGameHaoWan")) {
              break;
            }
            a.f.b.j.q(paramString2, "businessType");
            ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.f.class)).U(paramString2, paramArrayOfByte, paramString1);
            paramInt1 = 1;
          }
          vJs = true;
          AppMethodBeat.o(11675);
          return false;
        }
        AppMethodBeat.o(11675);
        return false;
      }
      label5452:
      paramString1 = "";
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    AppMethodBeat.i(11674);
    boolean bool = a(paramContext, paramString1, paramInt, paramBundle, (int)System.currentTimeMillis(), new byte[0], paramString2);
    AppMethodBeat.o(11674);
    return bool;
  }
  
  public static boolean aW(String paramString, long paramLong)
  {
    AppMethodBeat.i(11659);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = ala(paramString);
      if (!vJu.containsKey(paramString)) {
        break label86;
      }
    }
    label86:
    for (long l = ((Long)vJu.get(paramString)).longValue();; l = -1L)
    {
      if ((l != -1L) && ((l == 0L) || ((l & paramLong) == l))) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(11659);
        return bool;
      }
    }
  }
  
  private static void af(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(11677);
    String str;
    if ((!com.tencent.mm.sdk.platformtools.g.ymO) && (aa.dsG().equals("zh_CN"))) {
      str = paramContext.getString(2131305938);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DeepLinkHelper", "using faq webpage");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("show_feedback", false);
      localIntent.putExtra("KShowFixToolsBtn", true);
      localIntent.putExtra("geta8key_session_id", paramInt);
      com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(11677);
      return;
      if (aa.dsG().equals("zh_HK")) {
        str = paramContext.getString(2131305939);
      } else if (aa.dsG().equals("zh_TW")) {
        str = paramContext.getString(2131305940);
      } else {
        str = paramContext.getString(2131305941);
      }
    }
  }
  
  public static boolean akV(String paramString)
  {
    AppMethodBeat.i(11660);
    paramString = ala(paramString);
    if ((!vJu.containsKey(paramString)) && (!akW(paramString)) && (!akX(paramString))) {
      if ((bo.isNullOrNil(paramString)) || ((!paramString.startsWith("weixin://dl/jumpFakeWxa/")) && (!paramString.startsWith("weixin://dl/openNativeView/")))) {
        break label78;
      }
    }
    label78:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(11660);
      return true;
    }
    AppMethodBeat.o(11660);
    return false;
  }
  
  public static boolean akW(String paramString)
  {
    AppMethodBeat.i(11661);
    if ((!bo.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/business")))
    {
      AppMethodBeat.o(11661);
      return true;
    }
    AppMethodBeat.o(11661);
    return false;
  }
  
  public static boolean akX(String paramString)
  {
    AppMethodBeat.i(11662);
    if ((!bo.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/openbusinesswebview")))
    {
      AppMethodBeat.o(11662);
      return true;
    }
    AppMethodBeat.o(11662);
    return false;
  }
  
  private static boolean akY(String paramString)
  {
    AppMethodBeat.i(11666);
    if (((paramString.equals("weixin://dl/wechatout")) || (paramString.equals("weixin://dl/wechatoutcoupon")) || (paramString.equals("weixin://dl/wechatoutshare"))) && (!dkQ()))
    {
      paramString = new Intent();
      paramString.setFlags(268435456);
      paramString.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      ah.getContext().startActivity(paramString);
      AppMethodBeat.o(11666);
      return true;
    }
    AppMethodBeat.o(11666);
    return false;
  }
  
  public static boolean akZ(String paramString)
  {
    AppMethodBeat.i(11672);
    boolean bool = a(null, paramString, 0, null, (int)System.currentTimeMillis(), new byte[0], null);
    AppMethodBeat.o(11672);
    return bool;
  }
  
  private static String ala(String paramString)
  {
    AppMethodBeat.i(11678);
    String str = null;
    if (!bo.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString);
      str = paramString.getScheme() + "://" + paramString.getHost() + paramString.getPath();
    }
    AppMethodBeat.o(11678);
    return str;
  }
  
  public static void bs(Context paramContext, String paramString)
  {
    AppMethodBeat.i(11680);
    if (bo.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
      AppMethodBeat.o(11680);
      return;
    }
    Object localObject;
    if (paramString.startsWith("weixin://dl/login/phone_view"))
    {
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("cc");
      localObject = ((Uri)localObject).getQueryParameter("num");
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[] { paramString, localObject });
      Intent localIntent = new Intent();
      localIntent.putExtra("couttry_code", paramString);
      localIntent.putExtra("input_mobile_number", (String)localObject);
      localIntent.putExtra("from_deep_link", true);
      localIntent.putExtra("mobile_input_purpose", 1);
      localIntent.addFlags(268435456);
      com.tencent.mm.bq.d.b(paramContext, "account", ".ui.MobileInputUI", localIntent);
      AppMethodBeat.o(11680);
      return;
    }
    if (paramString.startsWith("weixin://dl/login/common_view"))
    {
      paramString = Uri.parse(paramString).getQueryParameter("username");
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[] { paramString });
      localObject = new Intent();
      ((Intent)localObject).putExtra("login_username", paramString);
      ((Intent)localObject).putExtra("from_deep_link", true);
      ((Intent)localObject).addFlags(268435456);
      com.tencent.mm.bq.d.b(paramContext, "account", ".ui.LoginUI", (Intent)localObject);
      AppMethodBeat.o(11680);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[] { paramString });
    AppMethodBeat.o(11680);
  }
  
  private static boolean dkQ()
  {
    AppMethodBeat.i(11665);
    if (com.tencent.mm.kernel.g.RG())
    {
      if (com.tencent.mm.m.g.Nq().getInt("WCOEntranceSwitch", 0) > 0)
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAp, Boolean.TRUE);
        AppMethodBeat.o(11665);
        return true;
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yAp, Boolean.FALSE);
      AppMethodBeat.o(11665);
      return false;
    }
    AppMethodBeat.o(11665);
    return false;
  }
  
  public static void fJ(Context paramContext)
  {
    AppMethodBeat.i(11676);
    af(paramContext, (int)System.currentTimeMillis());
    AppMethodBeat.o(11676);
  }
  
  public static boolean l(Uri paramUri)
  {
    AppMethodBeat.i(11663);
    if (paramUri == null)
    {
      AppMethodBeat.o(11663);
      return false;
    }
    if (!bo.isNullOrNil(paramUri.getQueryParameter("ticket")))
    {
      AppMethodBeat.o(11663);
      return true;
    }
    boolean bool = m(paramUri);
    AppMethodBeat.o(11663);
    return bool;
  }
  
  public static boolean m(Uri paramUri)
  {
    AppMethodBeat.i(11664);
    if (paramUri == null)
    {
      AppMethodBeat.o(11664);
      return false;
    }
    if ((paramUri.toString().startsWith("weixin://dl/business/tempsession/")) || (paramUri.toString().startsWith("weixin://dl/businessTempSession/")))
    {
      AppMethodBeat.o(11664);
      return true;
    }
    AppMethodBeat.o(11664);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e
 * JD-Core Version:    0.7.0.1
 */