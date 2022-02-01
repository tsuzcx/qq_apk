package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.jg.a;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.b.a.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.t;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  private static boolean EJt;
  public static String EJu;
  private static final Map<String, Long> EJv;
  
  static
  {
    AppMethodBeat.i(124372);
    EJt = false;
    EJu = "";
    HashMap localHashMap = new HashMap();
    EJv = localHashMap;
    localHashMap.put("weixin://", Long.valueOf(0L));
    EJv.put("weixin://dl/stickers", Long.valueOf(1L));
    EJv.put("weixin://dl/games", Long.valueOf(2L));
    EJv.put("weixin://dl/moments", Long.valueOf(4L));
    EJv.put("weixin://dl/add", Long.valueOf(8L));
    EJv.put("weixin://dl/shopping", Long.valueOf(16L));
    EJv.put("weixin://dl/groupchat", Long.valueOf(32L));
    EJv.put("weixin://dl/scan", Long.valueOf(64L));
    EJv.put("weixin://dl/profile", Long.valueOf(128L));
    EJv.put("weixin://dl/settings", Long.valueOf(256L));
    EJv.put("weixin://dl/general", Long.valueOf(512L));
    EJv.put("weixin://dl/help", Long.valueOf(1024L));
    EJv.put("weixin://dl/notifications", Long.valueOf(2048L));
    EJv.put("weixin://dl/terms", Long.valueOf(4096L));
    EJv.put("weixin://dl/chat", Long.valueOf(8192L));
    EJv.put("weixin://dl/features", Long.valueOf(16384L));
    EJv.put("weixin://dl/clear", Long.valueOf(32768L));
    EJv.put("weixin://dl/feedback", Long.valueOf(65536L));
    EJv.put("weixin://dl/faq", Long.valueOf(131072L));
    EJv.put("weixin://dl/recommendation", Long.valueOf(262144L));
    EJv.put("weixin://dl/groups", Long.valueOf(524288L));
    EJv.put("weixin://dl/tags", Long.valueOf(1048576L));
    EJv.put("weixin://dl/officialaccounts", Long.valueOf(2097152L));
    EJv.put("weixin://dl/posts", Long.valueOf(4194304L));
    EJv.put("weixin://dl/favorites", Long.valueOf(8388608L));
    EJv.put("weixin://dl/privacy", Long.valueOf(16777216L));
    EJv.put("weixin://dl/security", Long.valueOf(33554432L));
    EJv.put("weixin://dl/wallet", Long.valueOf(67108864L));
    EJv.put("weixin://dl/businessPay", Long.valueOf(134217728L));
    EJv.put("weixin://dl/businessPay/", Long.valueOf(134217728L));
    EJv.put("weixin://dl/wechatout", Long.valueOf(268435456L));
    EJv.put("weixin://dl/protection", Long.valueOf(1073741824L));
    EJv.put("weixin://dl/card", Long.valueOf(2147483648L));
    EJv.put("weixin://dl/about", Long.valueOf(1125899906842624L));
    EJv.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
    EJv.put("weixin://dl/textsize", Long.valueOf(8589934592L));
    EJv.put("weixin://dl/sight", Long.valueOf(17179869184L));
    EJv.put("weixin://dl/languages", Long.valueOf(34359738368L));
    EJv.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
    EJv.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
    EJv.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
    EJv.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
    EJv.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
    EJv.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
    EJv.put("weixin://dl/setname", Long.valueOf(4398046511104L));
    EJv.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
    EJv.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
    EJv.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
    EJv.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
    EJv.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
    EJv.put("weixin://dl/log", Long.valueOf(281474976710656L));
    EJv.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
    EJv.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
    EJv.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
    EJv.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
    EJv.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
    EJv.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    EJv.put("weixin://dl/offlinepay/", Long.valueOf(576460752303423490L));
    AppMethodBeat.o(124372);
  }
  
  public static boolean J(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124362);
    boolean bool = a(paramContext, paramString1, 1, (int)System.currentTimeMillis(), new byte[0], paramString2);
    AppMethodBeat.o(124362);
    return bool;
  }
  
  public static void K(final Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124369);
    if (aLm(paramString2))
    {
      AppMethodBeat.o(124369);
      return;
    }
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramContext, "", true, null);
    int j = 6;
    int i = j;
    if (!bt.isNullOrNil(paramString1))
    {
      if (!w.vF(paramString1)) {
        break label77;
      }
      i = 7;
    }
    for (;;)
    {
      a(paramContext, paramString2, i, new g.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(124346);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          if ((this.EJx != null) && (this.EJx.isShowing())) {
            this.EJx.dismiss();
          }
          if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
          {
            paramAnonymousString = ((ab)paramAnonymousn).aLd();
            if ((paramAnonymousString != null) && (paramContext != null)) {
              t.makeText(paramContext, paramContext.getString(2131755906) + " : " + bt.nullAsNil(paramAnonymousString.HDY), 0).show();
            }
          }
          AppMethodBeat.o(124346);
        }
      });
      AppMethodBeat.o(124369);
      return;
      label77:
      i = j;
      if (w.zE(paramString1)) {
        i = 9;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Bundle paramBundle, g.a parama)
  {
    AppMethodBeat.i(124359);
    a(paramContext, paramString, paramInt, paramBundle, parama, null, null);
    AppMethodBeat.o(124359);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, g.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124357);
    LinkedList localLinkedList = new LinkedList();
    du localdu = new du();
    if ((!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(paramString3)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[] { paramString2, paramString3 });
      localdu.pkf = paramString2;
      localdu.signature = paramString3;
      localLinkedList.add(localdu);
    }
    if (aLm(paramString1))
    {
      AppMethodBeat.o(124357);
      return;
    }
    paramString2 = new ab(paramString1, paramInt, localLinkedList);
    paramContext = new g.2(paramBundle, paramContext, paramInt, paramString1, parama);
    com.tencent.mm.kernel.g.aiU().a(1200, paramContext);
    com.tencent.mm.kernel.g.aiU().a(paramString2, 0);
    AppMethodBeat.o(124357);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, g.a parama)
  {
    AppMethodBeat.i(124358);
    a(paramContext, paramString, paramInt, null, parama, null, null);
    AppMethodBeat.o(124358);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, g.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124356);
    a(paramContext, paramString1, paramInt, null, parama, paramString2, paramString3);
    AppMethodBeat.o(124356);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, g.a parama)
  {
    AppMethodBeat.i(124355);
    if (bt.isNullOrNil(paramString1)) {
      paramString1 = paramString3;
    }
    while (aLm(paramString1))
    {
      AppMethodBeat.o(124355);
      return;
    }
    paramString3 = new k(paramString1, paramString2, paramInt, 0, (int)System.currentTimeMillis(), new byte[0]);
    paramContext = new g.1(paramContext, paramInt, paramString2, paramString1, parama);
    com.tencent.mm.kernel.g.aiU().a(233, paramContext);
    com.tencent.mm.kernel.g.aiU().a(paramString3, 0);
    AppMethodBeat.o(124355);
  }
  
  private static void a(com.tencent.mm.ac.i parami)
  {
    AppMethodBeat.i(124370);
    parami = parami.optString("package_info");
    if (bt.isNullOrNil(parami))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "package_info is null in invokeData");
      AppMethodBeat.o(124370);
      return;
    }
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      Object localObject1;
      String str2;
      long l;
      String str3;
      try
      {
        parami = new com.tencent.mm.ac.f(parami);
        i = parami.length();
        if (i <= 0)
        {
          AppMethodBeat.o(124370);
          return;
        }
        String str1 = com.tencent.mm.kernel.g.ajC().cachePath + "TempMiniProgram/";
        localArrayList = new ArrayList();
        i = 0;
        if (i >= parami.length()) {
          break label428;
        }
        localObject1 = new com.tencent.mm.ac.i(parami.getString(i));
        str2 = ((com.tencent.mm.ac.i)localObject1).optString("downloadUrl");
        l = ((com.tencent.mm.ac.i)localObject1).optLong("expireTime");
        localObject2 = ((com.tencent.mm.ac.i)localObject1).optString("extraBytes");
        localObject3 = ((com.tencent.mm.ac.i)localObject1).optString("filePath");
        localObject1 = ((com.tencent.mm.ac.i)localObject1).optString("fileMd5");
        if ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil(str2)) || (bt.isNullOrNil((String)localObject3)) || (bt.isNullOrNil((String)localObject2)) || (l <= 0L)) {
          break label451;
        }
        if ((!((String)localObject3).startsWith("content")) || (!com.tencent.mm.vfs.i.fv((String)localObject3)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "file not Exists, path = %s", new Object[] { localObject3 });
        }
        else
        {
          if (!com.tencent.mm.vfs.i.fv(str1)) {
            com.tencent.mm.vfs.i.aYg(str1);
          }
          str3 = bt.x("%s.%s", new Object[] { localObject1, com.tencent.mm.vfs.i.ZF((String)localObject3) });
          str3 = str1 + str3;
          if (com.tencent.mm.vfs.i.mz((String)localObject3, str3) <= 0L) {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", "file copy failed");
          }
        }
      }
      catch (Exception parami)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", parami.getMessage());
        AppMethodBeat.o(124370);
        return;
      }
      Object localObject2 = bt.aRa((String)localObject2);
      Object localObject3 = new a.a();
      ((a.a)localObject3).ax((byte[])localObject2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", ((a.a)localObject3).toString());
      ((a.a)localObject3).lMu = l;
      ((a.a)localObject3).lMs = ((String)localObject1);
      ((a.a)localObject3).lMt = str2;
      localArrayList.add(new Pair(localObject3, str3));
      break label451;
      label428:
      ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).by(localArrayList);
      AppMethodBeat.o(124370);
      return;
      label451:
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(124361);
    boolean bool = a(paramContext, paramString, 0, paramInt, paramArrayOfByte, null);
    AppMethodBeat.o(124361);
    return bool;
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(124364);
    boolean bool = a(paramContext, paramString1, paramInt1, null, paramInt2, paramArrayOfByte, paramString2, null);
    AppMethodBeat.o(124364);
    return bool;
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt1, Bundle paramBundle, int paramInt2, byte[] paramArrayOfByte, String paramString2, g.a parama)
  {
    AppMethodBeat.i(124365);
    String str1 = aLn(paramString1);
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(124365);
      return false;
    }
    long l;
    if (EJv.containsKey(str1))
    {
      l = ((Long)EJv.get(str1)).longValue();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", new Object[] { Long.valueOf(l) });
      str1 = null;
      parama = new Intent();
      parama.setFlags(268435456);
      if (l == 0L)
      {
        paramBundle = "com.tencent.mm.ui.LauncherUI";
        paramString2 = parama;
        if (bt.isNullOrNil(paramBundle)) {
          break label4158;
        }
        paramString2.setClassName(aj.getContext(), paramBundle);
        if (paramContext == null) {
          break label4043;
        }
      }
    }
    for (;;)
    {
      String str2;
      Object localObject1;
      int i;
      boolean bool;
      try
      {
        String str3;
        String str4;
        Object localObject2;
        for (;;)
        {
          if (!paramBundle.contains("WebViewUI")) {
            break label3945;
          }
          com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
          AppMethodBeat.o(124365);
          return true;
          if (l == 1L)
          {
            paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
            com.tencent.mm.plugin.report.service.g.yhR.f(12065, new Object[] { Integer.valueOf(7) });
            paramString2 = parama;
            break;
          }
          if (l == 2L)
          {
            parama.putExtra("from_deeplink", true);
            parama.putExtra("game_report_from_scene", 6);
            paramBundle = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            paramString2 = parama;
            break;
          }
          if (l == 4L)
          {
            if ((com.tencent.mm.model.u.aAy() & 0x8000) == 0) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label6648;
              }
              paramString1 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
              parama.putExtra("sns_timeline_NeedFirstLoadint", true);
              paramBundle = paramString1;
              paramString2 = parama;
              break;
            }
          }
          if (l == 8L)
          {
            paramBundle = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            paramString2 = parama;
            break;
          }
          if (l == 16L)
          {
            paramString1 = new jg();
            com.tencent.mm.sdk.b.a.IbL.l(paramString1);
            paramString1 = paramString1.dwd.url;
            paramBundle = str1;
            paramString2 = parama;
            if (bt.isNullOrNil(paramString1)) {
              break;
            }
            parama.putExtra("rawUrl", paramString1);
            parama.putExtra("useJs", true);
            parama.putExtra("vertical_scroll", true);
            parama.putExtra("geta8key_session_id", paramInt2);
            parama.putExtra("geta8key_cookie", paramArrayOfByte);
            paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            paramString2 = parama;
            break;
          }
          if (l == 32L)
          {
            parama.putExtra("titile", aj.getContext().getString(2131755232));
            parama.putExtra("list_type", 0);
            parama.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.Knz, 256, 512 }));
            parama.putExtra("create_group_recommend", true);
            parama.putExtra("menu_mode", 2);
            paramBundle = "com.tencent.mm.ui.contact.SelectContactUI";
            paramString2 = parama;
            break;
          }
          if (l == 64L)
          {
            paramBundle = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
            parama.putExtra("animation_pop_in", true);
            paramString2 = parama;
            break;
          }
          if (l == 128L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            paramString2 = parama;
            break;
          }
          if (l == 256L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            paramString2 = parama;
            break;
          }
          if (l == 512L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            paramString2 = parama;
            break;
          }
          if (l == 1024L)
          {
            ao(aj.getContext(), paramInt2);
            paramBundle = str1;
            paramString2 = parama;
            break;
          }
          if (l == 2048L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            paramString2 = parama;
            break;
          }
          if (l == 4096L)
          {
            parama.putExtra("title", aj.getContext().getResources().getString(2131762012));
            parama.putExtra("rawUrl", aj.getContext().getResources().getString(2131764600, new Object[] { com.tencent.mm.sdk.platformtools.ac.fks(), com.tencent.mm.sdk.platformtools.ac.fkr() }));
            parama.putExtra("showShare", false);
            parama.putExtra("geta8key_session_id", paramInt2);
            parama.putExtra("geta8key_cookie", paramArrayOfByte);
            paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            paramString2 = parama;
            break;
          }
          if (l == 8192L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            paramString2 = parama;
            break;
          }
          if (l == 16384L)
          {
            paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            paramString2 = parama;
            break;
          }
          if (l == 32768L)
          {
            paramBundle = "com.tencent.mm.plugin.clean.ui.CleanUI";
            paramString2 = parama;
            break;
          }
          if (l == 65536L) {
            try
            {
              paramInt1 = paramString1.indexOf("?");
              if (paramInt1 <= 0) {
                break label6642;
              }
              paramString1 = paramString1.substring(paramInt1 + 1);
              com.tencent.mm.kernel.g.ajA();
              paramInt1 = com.tencent.mm.kernel.a.getUin();
              paramBundle = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
              paramString2 = URLEncoder.encode(bt.flM(), "utf-8");
              str2 = URLEncoder.encode(com.tencent.mm.compatible.deviceinfo.q.cH(true), "utf-8");
              localObject1 = URLEncoder.encode(com.tencent.mm.protocal.d.Fnd, "utf-8");
              str3 = URLEncoder.encode(com.tencent.mm.protocal.d.Fne, "utf-8");
              str4 = URLEncoder.encode(com.tencent.mm.protocal.d.Fnf, "utf-8");
              localObject2 = URLEncoder.encode(com.tencent.mm.kernel.a.aiO(), "utf-8");
              String str5 = URLEncoder.encode(bt.jj(aj.getContext()), "utf-8");
              paramBundle = new StringBuilder("&uin=").append(paramInt1).append("&deviceName=").append(paramBundle).append("&timeZone=").append(paramString2).append("&imei=").append(str2).append("&deviceBrand=").append((String)localObject1).append("&deviceModel=").append(str3).append("&ostype=").append(str4).append("&clientSeqID=").append((String)localObject2).append("&signature=").append(str5).append("&scene=");
              if (bt.isNullOrNil(paramString1)) {}
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                paramBundle = paramInt1;
                paramString1 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.Fnj + "&lang=" + com.tencent.mm.sdk.platformtools.ac.iM(aj.getContext()) + "&" + bt.nullAsNil(paramString1) + paramBundle;
                parama.putExtra("showShare", false);
                parama.putExtra("rawUrl", paramString1);
                parama.putExtra("neverGetA8Key", true);
                parama.putExtra("geta8key_session_id", paramInt2);
                parama.putExtra("geta8key_cookie", paramArrayOfByte);
                parama.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
                parama.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
                paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                paramString2 = parama;
                break;
              }
            }
            catch (UnsupportedEncodingException paramString1)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramString1.getMessage() });
              paramBundle = str1;
              paramString2 = parama;
            }
          }
        }
        if (l == 131072L)
        {
          com.tencent.mm.kernel.g.ajA();
          paramInt1 = com.tencent.mm.kernel.a.getUin();
          i = bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(12304, null));
          paramString1 = aj.getContext().getString(2131763450, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          parama.putExtra("showShare", false);
          parama.putExtra("rawUrl", paramString1);
          parama.putExtra("geta8key_session_id", paramInt2);
          parama.putExtra("geta8key_cookie", paramArrayOfByte);
          paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          paramString2 = parama;
          break;
        }
        if (l == 262144L)
        {
          paramBundle = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
          paramString2 = parama;
          break;
        }
        if (l == 524288L)
        {
          paramBundle = "com.tencent.mm.ui.contact.ChatroomContactUI";
          paramString2 = parama;
          break;
        }
        if (l == 1048576L)
        {
          paramBundle = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
          paramString2 = parama;
          break;
        }
        if (l == 2097152L)
        {
          paramBundle = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
          paramString2 = parama;
          break;
        }
        if (l == 268435456L)
        {
          parama.putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bs.d.b(aj.getContext(), "ipcall", ".ui.IPCallAddressUI", parama);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 4194304L)
        {
          parama.putExtra("sns_userName", (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null));
          parama.addFlags(67108864);
          parama.putExtra("sns_adapter_type", 1);
          paramBundle = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI";
          paramInt1 = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(68389, null), 0);
          com.tencent.mm.kernel.g.ajC().ajl().set(68389, Integer.valueOf(paramInt1 + 1));
          paramString2 = parama;
          break;
        }
        if (l == 8388608L)
        {
          paramBundle = "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI";
          paramString2 = parama;
          break;
        }
        if (l == 16777216L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
          paramString2 = parama;
          break;
        }
        if (l == 33554432L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
          paramString2 = parama;
          break;
        }
        if (l == 67108864L)
        {
          bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramBundle = "com.tencent.mm.plugin.mall.ui.MallIndexUIv2";
            paramString2 = parama;
            break;
          }
          paramBundle = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
          paramString2 = parama;
          break;
        }
        if (l == 134217728L)
        {
          if ((paramContext != null) && (!bt.isNullOrNil(paramString1)) && (paramString1.startsWith("weixin://dl/businessPay")))
          {
            paramBundle = Uri.parse(paramString1);
            if (paramBundle == null) {
              continue;
            }
            paramString1 = paramBundle.getQueryParameter("reqkey");
            paramArrayOfByte = paramBundle.getQueryParameter("appid");
            if (!bt.isNullOrNil(paramString1))
            {
              paramBundle = new PayInfo();
              paramBundle.dlu = paramString1;
              paramBundle.appId = paramArrayOfByte;
              paramBundle.dCC = 36;
              paramBundle.ucG = false;
              paramString1 = new Intent();
              paramString1.putExtra("key_pay_info", paramBundle);
              if ((paramContext instanceof Activity))
              {
                paramString1.putExtra("key_context_hashcode", paramContext.hashCode());
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "startPay context %s %s", new Object[] { paramContext, Integer.valueOf(paramContext.hashCode()) });
              }
              if (com.tencent.mm.model.u.aAB())
              {
                com.tencent.mm.bs.d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramString1, 1);
                paramBundle = str1;
                paramString2 = paramString1;
                break;
              }
              com.tencent.mm.bs.d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramString1, 1);
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.DeepLinkHelper", "reqkey null");
          }
          paramString1 = null;
          continue;
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.DeepLinkHelper", "payUri null");
          continue;
        }
        if (l == 1073741824L)
        {
          paramBundle = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
          paramString2 = parama;
          break;
        }
        if (l == 2147483648L)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
          paramString1 = new jv();
          paramString1.dwO.context = paramContext;
          com.tencent.mm.sdk.b.a.IbL.l(paramString1);
          paramBundle = str1;
          paramString2 = parama;
          break;
        }
        if (l == 4294967296L)
        {
          parama.putExtra("filter_type", com.tencent.mm.model.ad.AL(aj.getContext().getString(2131760084)).getType());
          parama.putExtra("titile", aj.getContext().getString(2131763373));
          parama.putExtra("list_attr", 32768);
          paramBundle = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
          paramString2 = parama;
          break;
        }
        if (l == 8589934592L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
          paramString2 = parama;
          break;
        }
        if (l == 17179869184L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
          paramString2 = parama;
          break;
        }
        if (l == 34359738368L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
          paramString2 = parama;
          break;
        }
        if (l == 68719476736L)
        {
          paramBundle = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
          paramString2 = parama;
          break;
        }
        if (l == 137438953472L)
        {
          parama.setClassName(aj.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindQQUI");
          MMWizardActivity.al(paramContext, parama);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 274877906944L)
        {
          parama.setClassName(aj.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI");
          MMWizardActivity.al(paramContext, parama);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 549755813888L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
          paramString2 = parama;
          break;
        }
        if (l == 1099511627776L)
        {
          com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", parama.putExtra("Contact_User", "qqsync"));
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 2199023255552L)
        {
          paramBundle = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
          paramString2 = parama;
          break;
        }
        if (l == 4398046511104L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
          paramString2 = parama;
          break;
        }
        if (l == 8796093022208L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
          paramString2 = parama;
          break;
        }
        if (l == 17592186044416L)
        {
          parama.putExtra("launch_from_webview", false);
          com.tencent.mm.bs.d.c(aj.getContext(), "address", ".ui.WalletSelectAddrUI", parama);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 35184372088832L)
        {
          parama.putExtra("k_sns_tag_id", 4L);
          parama.putExtra("k_sns_from_settings_about_sns", 1);
          com.tencent.mm.bs.d.b(aj.getContext(), "sns", ".ui.SnsBlackDetailUI", parama);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 70368744177664L)
        {
          parama.putExtra("k_sns_tag_id", 5L);
          parama.putExtra("k_sns_from_settings_about_sns", 2);
          parama.putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.bs.d.b(aj.getContext(), "sns", ".ui.SnsTagDetailUI", parama);
          paramBundle = str1;
          paramString2 = parama;
          break;
        }
        if (l == 140737488355328L)
        {
          paramBundle = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
          paramString2 = parama;
          break;
        }
        if (l == 281474976710656L)
        {
          paramContext = new ch();
          paramContext.dnl.dnn = "//uplog";
          paramContext.dnl.context = aj.getContext();
          com.tencent.mm.sdk.b.a.IbL.l(paramContext);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 562949953421312L)
        {
          parama.putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bs.d.b(aj.getContext(), "ipcall", ".ui.IPCallAddressUI", parama);
          com.tencent.mm.bs.d.b(aj.getContext(), "ipcall", ".ui.IPCallShareCouponUI", parama);
          AppMethodBeat.o(124365);
          return true;
        }
        if (l == 18014398509481984L)
        {
          parama.putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.bs.d.b(aj.getContext(), "ipcall", ".ui.IPCallAddressUI", parama);
          com.tencent.mm.bs.d.b(aj.getContext(), "ipcall", ".ui.IPCallShareCouponUI", parama);
          com.tencent.mm.bs.d.b(aj.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", parama);
          paramBundle = str1;
          paramString2 = parama;
          break;
        }
        if (l == 576460752303423488L)
        {
          parama.putExtra("IPCallAddressUI_KFrom", 1);
          parama.setClassName(aj.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
          paramString1 = aj.getContext();
          paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramBundle.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString1.startActivity((Intent)paramBundle.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramBundle = str1;
          paramString2 = parama;
          break;
        }
        if (l == 1125899906842624L)
        {
          paramBundle = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
          paramString2 = parama;
          break;
        }
        if (l == 4503599627370496L)
        {
          parama.putExtra("emoji_tab", 1);
          paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
          com.tencent.mm.plugin.report.service.g.yhR.f(12065, new Object[] { Integer.valueOf(7) });
          paramString2 = parama;
          break;
        }
        if (l == 9007199254740992L)
        {
          paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
          paramString2 = parama;
          break;
        }
        if (l == 576460752303423489L)
        {
          paramString1 = Uri.parse(paramString1);
          paramArrayOfByte = paramString1.getQueryParameter("appid");
          parama = paramString1.getQueryParameter("userName");
          str1 = paramString1.getQueryParameter("path");
          i = bt.getInt(bt.nullAsNil(paramString1.getQueryParameter("pathType")), 0);
          str2 = paramString1.getQueryParameter("invokeData");
          localObject1 = paramString1.getQueryParameter("runtimeSessionId");
          str3 = paramString1.getQueryParameter("runtimeTicket");
          str4 = paramString1.getQueryParameter("runtimeAppid");
          paramInt2 = 0;
          paramContext = y.aBq().F("key_data_center_session_id", false);
          if (paramContext != null) {
            paramInt2 = ((Integer)paramContext.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", new Object[] { paramArrayOfByte, parama, str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          y.aBq().AG("key_data_center_session_id");
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).dkh = URLEncoder.encode(paramString2);
          if (paramInt1 == 2)
          {
            paramContext = new com.tencent.mm.plugin.appbrand.api.f();
            paramContext.username = parama;
            paramContext.hQh = paramInt2;
            paramContext.version = 0;
            paramContext.jCN = str1;
            paramContext.scene = 1065;
            paramContext.dkh = paramArrayOfByte;
            paramContext.jCW = new AppBrandLaunchReferrer();
            paramContext.jCW.appId = paramArrayOfByte;
            paramContext.jCW.jXR = 8;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), paramContext);
            AppMethodBeat.o(124365);
            return true;
          }
          if (paramInt1 == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DeepLinkHelper", "pathType:%d invokeData:%s", new Object[] { Integer.valueOf(i), str2 });
            paramContext = "";
            if (!bt.isNullOrNil(str2))
            {
              try
              {
                paramBundle = new com.tencent.mm.ac.i(str2);
                a(paramBundle);
                paramBundle = paramBundle.optString("ad_trace_data");
                if (!bt.isNullOrNil(paramBundle)) {
                  paramContext = new com.tencent.mm.ac.i(paramBundle).optString("click_id");
                }
                if ((1 != i) || (bt.isNullOrNil(str2))) {
                  continue;
                }
                paramString1 = "";
              }
              catch (Exception paramContext)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[0]);
              }
            }
            else
            {
              try
              {
                paramBundle = new com.tencent.mm.ac.i(str2).optString("name");
                paramString1 = paramBundle;
              }
              catch (com.tencent.mm.ac.g paramBundle)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramBundle, "", new Object[0]);
                continue;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "runtimeSessionId:%s runtimeTicket:%s runtimeAppId:%s functionName:%s", new Object[] { localObject1, str3, str4, paramString1 });
              ((AppBrandStatObject)localObject2).scene = 1111;
              ((AppBrandStatObject)localObject2).dkh = (str4 + ":" + paramString1);
              if (!bt.isNullOrNil(paramContext)) {
                ((AppBrandStatObject)localObject2).dkh = bt.x("%s:%s", new Object[] { ((AppBrandStatObject)localObject2).dkh, paramContext });
              }
              ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), parama, paramInt2, str1, (AppBrandStatObject)localObject2, paramArrayOfByte, str2);
              continue;
              paramContext = "";
              continue;
            }
            paramString1 = paramString1.getQueryParameter("ad_trace_key");
            paramBundle = new com.tencent.mm.plugin.appbrand.api.f();
            paramBundle.username = parama;
            paramBundle.hQh = paramInt2;
            paramBundle.version = 0;
            paramBundle.jCN = str1;
            if (3 == i)
            {
              paramBundle.scene = 1113;
              paramBundle.dkh = paramArrayOfByte;
              if (!bt.isNullOrNil(paramContext)) {
                paramBundle.dkh = bt.x("%s:%s", new Object[] { paramArrayOfByte, paramContext });
              }
              paramBundle.jCV = paramString1;
              paramBundle.jCW = new AppBrandLaunchReferrer();
              paramBundle.jCW.appId = paramArrayOfByte;
              paramBundle.jCW.jXR = 4;
              ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), paramBundle);
              continue;
            }
            paramBundle.scene = 1069;
            continue;
          }
          if (paramInt1 == 6)
          {
            ((AppBrandStatObject)localObject2).scene = 1007;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), parama, null, paramInt2, 0, str1, (AppBrandStatObject)localObject2);
            continue;
          }
          if (paramInt1 == 7)
          {
            ((AppBrandStatObject)localObject2).scene = 1008;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), parama, null, paramInt2, 0, str1, (AppBrandStatObject)localObject2);
            continue;
          }
          ((AppBrandStatObject)localObject2).scene = 1000;
          ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), parama, null, 0, 0, str1, (AppBrandStatObject)localObject2);
          continue;
        }
        paramBundle = str1;
        paramString2 = parama;
        if (l != 576460752303423490L) {
          break;
        }
        paramString1 = Uri.parse(paramString1).getQueryParameter("appid");
        paramBundle = new Intent();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletManager", "start offline from sdk: %s", new Object[] { paramString1 });
        paramBundle.putExtra("key_from_scene", 8);
        paramBundle.putExtra("key_appid", paramString1);
        com.tencent.mm.bs.d.b(paramContext, "offline", ".ui.WalletOfflineEntranceUI", paramBundle, 0);
        paramBundle = str1;
        paramString2 = parama;
        break;
        label3945:
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString2);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
        continue;
      }
      label4043:
      if (paramBundle.contains("WebViewUI")) {
        com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramString2);
      }
      for (;;)
      {
        com.tencent.mm.ui.base.b.am(aj.getContext(), paramString2);
        break;
        paramContext = aj.getContext();
        paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString2);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label4158:
      AppMethodBeat.o(124365);
      return false;
      if (str1.startsWith("weixin://dl/businessTempSession/"))
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setFlags(268435456);
        paramString2 = Uri.parse(paramString1);
        if (paramString2 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
          AppMethodBeat.o(124365);
          return false;
        }
        parama = paramString2.getQueryParameter("sessionFrom");
        str1 = paramString2.getQueryParameter("showtype");
        paramBundle = paramString2.getQueryParameter("username");
        if (!bt.isNullOrNil(paramBundle)) {
          break label6639;
        }
        paramBundle = paramString2.getQueryParameter("userName");
      }
      label5573:
      label5588:
      label6619:
      label6639:
      for (;;)
      {
        if (bt.isNullOrNil(paramBundle))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
          AppMethodBeat.o(124365);
          return false;
        }
        i = bt.getInt(bt.nullAsNil(paramString2.getQueryParameter("scene")), 0);
        paramInt2 = paramInt1;
        if (i != 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == 4)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to ".concat(String.valueOf(i)));
            paramInt2 = i;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", new Object[] { paramBundle, parama, Integer.valueOf(paramInt2), paramString1, str1 });
        paramArrayOfByte.setClassName(aj.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
        paramArrayOfByte.putExtra("Chat_User", paramBundle);
        paramArrayOfByte.putExtra("finish_direct", true);
        paramArrayOfByte.putExtra("key_is_temp_session", true);
        paramArrayOfByte.putExtra("key_temp_session_from", parama);
        paramArrayOfByte.putExtra("key_temp_session_scene", paramInt2);
        paramArrayOfByte.putExtra("key_temp_session_show_type", bt.getInt(str1, 0));
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramBundle);
        if ((paramString1 == null) || ((int)paramString1.gfj <= 0)) {
          as.a.hFO.a(paramBundle, "", new g.3(paramArrayOfByte, paramContext));
        }
        for (;;)
        {
          AppMethodBeat.o(124365);
          return true;
          paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfByte);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString1.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        if ((str1.startsWith("weixin://dl/businessGame/detail/")) || (str1.startsWith("weixin://dl/businessGame/detail")))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
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
          if (!bt.isNullOrNil(paramString1))
          {
            paramBundle.setClassName(aj.getContext(), paramString1);
            if (paramContext != null) {}
            try
            {
              paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramContext.startActivity((Intent)paramString1.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              for (;;)
              {
                AppMethodBeat.o(124365);
                return true;
                paramContext = aj.getContext();
                paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
                com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramContext.startActivity((Intent)paramString1.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.am(aj.getContext(), paramBundle);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
          AppMethodBeat.o(124365);
          return false;
        }
        if ((str1.startsWith("weixin://dl/businessGame/library/")) || (str1.startsWith("weixin://dl/businessGame/library")))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
          paramString1 = new Intent();
          if (!bt.isNullOrNil("com.tencent.mm.plugin.game.ui.GameLibraryUI"))
          {
            paramString1.putExtra("game_report_from_scene", 6);
            paramString1.setClassName(aj.getContext(), "com.tencent.mm.plugin.game.ui.GameLibraryUI");
            if (paramContext != null) {}
            try
            {
              paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramContext.startActivity((Intent)paramString1.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              for (;;)
              {
                AppMethodBeat.o(124365);
                return true;
                paramContext = aj.getContext();
                paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
                com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramContext.startActivity((Intent)paramBundle.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.am(aj.getContext(), paramString1);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
          AppMethodBeat.o(124365);
          return false;
        }
        if ((str1.startsWith("weixin://dl/businessWebview/link/")) || (str1.startsWith("weixin://dl/businessWebview/link")))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
          paramString1 = Uri.parse(paramString1);
          paramString2 = new Intent();
          if (paramString1 != null)
          {
            parama = paramString1.getQueryParameter("url");
            i = bt.getInt(paramString1.getQueryParameter("type"), 0);
            str1 = bt.nullAsNil(paramString1.getQueryParameter("appid"));
            int j = bt.getInt(bt.nullAsNil(paramString1.getQueryParameter("outer")), 0);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", new Object[] { parama, str1, Integer.valueOf(paramInt1), Integer.valueOf(j) });
            paramString2.putExtra("rawUrl", parama);
            paramString2.putExtra("geta8key_session_id", paramInt2);
            paramString2.putExtra("geta8key_cookie", paramArrayOfByte);
            if (paramInt1 == 1)
            {
              if (j == 1)
              {
                paramString2.putExtra("geta8key_open_webview_appid", str1);
                paramString2.putExtra("geta8key_scene", 53);
              }
              paramString2.putExtra("show_openapp_dialog", false);
              paramString2.putExtra("pay_channel", 40);
              com.tencent.mm.pluginsdk.wallet.h.Zx(39);
              if (i == 5)
              {
                paramString2.putExtra("webview_invoke_launch_app_when_back", true);
                paramString2.putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[] { str1, Integer.valueOf(i), Integer.valueOf(-2) }));
                paramString2.putExtra("KAppId", str1);
              }
              paramString2.putExtra("transaction_for_openapi_openwebview", EJu);
              if (paramBundle != null) {
                paramString2.putExtras(paramBundle);
              }
              if (paramContext == null) {
                break label5588;
              }
              if (paramInt1 != 2) {
                break label5573;
              }
              com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.CustomSchemeEntryWebViewUI", paramString2);
            }
            for (;;)
            {
              AppMethodBeat.o(124365);
              return true;
              if (paramInt1 != 2) {
                break;
              }
              if (j == 1)
              {
                paramString2.putExtra("geta8key_open_webview_appid", str1);
                paramString2.putExtra("geta8key_scene", 52);
              }
              paramString2.putExtra("pay_channel", 39);
              com.tencent.mm.pluginsdk.wallet.h.Zx(39);
              break;
              com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString2);
              continue;
              com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramString2);
              com.tencent.mm.ui.base.b.am(aj.getContext(), paramString2);
            }
          }
          AppMethodBeat.o(124365);
          return false;
        }
        if (str1.startsWith("weixin://dl/openbusinesswebview/link/"))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith openbusinesswebview");
          paramString2 = Uri.parse(paramString1);
          parama = new Intent();
          paramString1 = null;
          if (paramString2 != null)
          {
            paramString1 = paramString2.getQueryParameter("url");
            i = bt.getInt(paramString2.getQueryParameter("type"), 0);
            str1 = bt.nullAsNil(paramString2.getQueryParameter("appid"));
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s", new Object[] { paramString1, str1, Integer.valueOf(paramInt1) });
            paramString2 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            parama.putExtra("rawUrl", paramString1);
            parama.putExtra("geta8key_session_id", paramInt2);
            parama.putExtra("geta8key_cookie", paramArrayOfByte);
            parama.putExtra("geta8key_open_webview_appid", str1);
            parama.putExtra("geta8key_scene", 57);
            parama.putExtra("show_openapp_dialog", false);
            parama.putExtra("webview_invoke_launch_app_when_back", true);
            parama.putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://openbusinesswebview?type=%d&ret=%d", new Object[] { str1, Integer.valueOf(i), Integer.valueOf(-2) }));
            parama.putExtra("KAppId", str1);
            parama.putExtra("transaction_for_openapi_openwebview", EJu);
            paramString1 = paramString2;
            if (paramBundle != null)
            {
              parama.putExtras(paramBundle);
              paramString1 = paramString2;
            }
          }
          if (!bt.isNullOrNil(paramString1))
          {
            parama.setClassName(aj.getContext(), paramString1);
            if (paramContext != null) {}
            try
            {
              paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramContext.startActivity((Intent)paramString1.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              for (;;)
              {
                AppMethodBeat.o(124365);
                return true;
                paramContext = aj.getContext();
                paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
                com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramContext.startActivity((Intent)paramString1.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/DeepLinkHelper", "gotoUri", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;ILandroid/os/Bundle;I[BLjava/lang/String;Lcom/tencent/mm/pluginsdk/DeepLinkHelper$DeepLinkCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.am(aj.getContext(), parama);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
          AppMethodBeat.o(124365);
          return false;
        }
        if ((str1.startsWith("weixin://dl/jumpFakeWxa/")) || (str1.startsWith("weixin://dl/openNativeView/")))
        {
          paramString1 = Uri.parse(paramString1);
          paramString2 = paramString1.getQueryParameter("appid");
          str2 = paramString1.getQueryParameter("businessType");
          paramString1 = null;
          paramBundle = null;
          paramArrayOfByte = null;
          paramInt2 = 0;
          localObject1 = y.aBq().F("key_data_center_session_id", false);
          if (localObject1 != null)
          {
            paramInt2 = ((Integer)((y.b)localObject1).get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
            paramString1 = (String)((y.b)localObject1).get("key_launch_miniprogram_query_info", "");
            paramBundle = (String)((y.b)localObject1).get("key_open_business_view_ext_info", "");
            paramArrayOfByte = (String)((y.b)localObject1).get("key_launch_mini_program_open_id", "");
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DeepLinkHelper", "appid = %s, translateLinkScene = %d, type = %d", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          y.aBq().AG("key_data_center_session_id");
          if (str1.startsWith("weixin://dl/jumpFakeWxa/"))
          {
            if (paramInt1 == 1)
            {
              paramBundle = null;
              if ((parama instanceof o.a)) {
                paramBundle = (o.a)parama;
              }
              ((o)com.tencent.mm.kernel.g.ab(o.class)).a(paramContext, paramString2, str2, paramString1, paramInt2, paramBundle);
              AppMethodBeat.o(124365);
              return true;
            }
            AppMethodBeat.o(124365);
            return false;
          }
          paramContext = d.EJl;
          if (str2 != null)
          {
            bool = com.tencent.mm.pluginsdk.ui.tools.l.lA(paramString2, paramArrayOfByte);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BusinessViewHandler", "handle businessType=" + str2 + ", isSameAccount = " + bool);
          }
          switch (str2.hashCode())
          {
          default: 
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label6619;
            }
            AppMethodBeat.o(124365);
            return true;
            if (!str2.equals("nativeEmergencyContact")) {
              break;
            }
            d.g.b.p.h(str2, "businessType");
            com.tencent.mm.pluginsdk.ui.tools.l.d(str2, "testExtMsg", paramString2, -3, "testErrMsg");
            paramInt1 = 1;
            continue;
            if (!str2.equals("nativeShareToHaokan")) {
              break;
            }
            d.g.b.p.h(str2, "businessType");
            com.tencent.mm.plugin.topstory.ui.d.aL(str2, paramString2, paramBundle);
            paramInt1 = 1;
            continue;
            if (!str2.equals("nativeUpdateRoomToOpenImChatroom")) {
              break;
            }
            d.g.b.p.h(str2, "businessType");
            com.tencent.mm.pluginsdk.ui.tools.l.g(str2, paramString2, paramBundle, bool);
            paramInt1 = 1;
            continue;
            if (!str2.equals("nativeShareToGameHaoWan")) {
              break;
            }
            d.g.b.p.h(str2, "businessType");
            ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).ag(str2, paramString2, paramBundle);
            paramInt1 = 1;
          }
          EJt = true;
          AppMethodBeat.o(124365);
          return false;
        }
        AppMethodBeat.o(124365);
        return false;
      }
      label6642:
      paramString1 = "";
      continue;
      label6648:
      paramString1 = null;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2, g.a parama)
  {
    AppMethodBeat.i(124363);
    boolean bool = a(paramContext, paramString1, paramInt, paramBundle, (int)System.currentTimeMillis(), new byte[0], paramString2, parama);
    AppMethodBeat.o(124363);
    return bool;
  }
  
  public static boolean aLj(String paramString)
  {
    AppMethodBeat.i(124348);
    paramString = aLn(paramString);
    if ((!EJv.containsKey(paramString)) && (!aLk(paramString)) && (!aLl(paramString))) {
      if ((bt.isNullOrNil(paramString)) || ((!paramString.startsWith("weixin://dl/jumpFakeWxa/")) && (!paramString.startsWith("weixin://dl/openNativeView/")))) {
        break label78;
      }
    }
    label78:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(124348);
      return true;
    }
    AppMethodBeat.o(124348);
    return false;
  }
  
  public static boolean aLk(String paramString)
  {
    AppMethodBeat.i(124349);
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/business")))
    {
      AppMethodBeat.o(124349);
      return true;
    }
    AppMethodBeat.o(124349);
    return false;
  }
  
  public static boolean aLl(String paramString)
  {
    AppMethodBeat.i(124350);
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("weixin://dl/openbusinesswebview")))
    {
      AppMethodBeat.o(124350);
      return true;
    }
    AppMethodBeat.o(124350);
    return false;
  }
  
  private static boolean aLm(String paramString)
  {
    AppMethodBeat.i(124354);
    if (((paramString.equals("weixin://dl/wechatout")) || (paramString.equals("weixin://dl/wechatoutcoupon")) || (paramString.equals("weixin://dl/wechatoutshare"))) && (!eYV()))
    {
      paramString = new Intent();
      paramString.setFlags(268435456);
      paramString.setClassName(aj.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(124354);
      return true;
    }
    AppMethodBeat.o(124354);
    return false;
  }
  
  private static String aLn(String paramString)
  {
    AppMethodBeat.i(124368);
    String str = null;
    if (!bt.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString);
      str = paramString.getScheme() + "://" + paramString.getHost() + paramString.getPath();
    }
    AppMethodBeat.o(124368);
    return str;
  }
  
  private static void ao(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(124367);
    String str;
    if ((!j.IcA) && (com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_CN"))) {
      str = paramContext.getString(2131766184);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DeepLinkHelper", "using faq webpage");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("show_feedback", false);
      localIntent.putExtra("KShowFixToolsBtn", true);
      localIntent.putExtra("geta8key_session_id", paramInt);
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(124367);
      return;
      if (com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_HK")) {
        str = paramContext.getString(2131766185);
      } else if (com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_TW")) {
        str = paramContext.getString(2131766186);
      } else {
        str = paramContext.getString(2131766187);
      }
    }
  }
  
  public static boolean bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207214);
    boolean bool = a(paramContext, paramString, 0, (int)System.currentTimeMillis(), new byte[0], null);
    AppMethodBeat.o(207214);
    return bool;
  }
  
  public static void bK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124371);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
      AppMethodBeat.o(124371);
      return;
    }
    Object localObject;
    if (paramString.startsWith("weixin://dl/login/phone_view"))
    {
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("cc");
      localObject = ((Uri)localObject).getQueryParameter("num");
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[] { paramString, localObject });
      Intent localIntent = new Intent();
      localIntent.putExtra("couttry_code", paramString);
      localIntent.putExtra("input_mobile_number", (String)localObject);
      localIntent.putExtra("from_deep_link", true);
      localIntent.putExtra("mobile_input_purpose", 1);
      localIntent.addFlags(268435456);
      com.tencent.mm.bs.d.b(paramContext, "account", ".ui.MobileInputUI", localIntent);
      AppMethodBeat.o(124371);
      return;
    }
    if (paramString.startsWith("weixin://dl/login/common_view"))
    {
      paramString = Uri.parse(paramString).getQueryParameter("username");
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[] { paramString });
      localObject = new Intent();
      ((Intent)localObject).putExtra("login_username", paramString);
      ((Intent)localObject).putExtra("from_deep_link", true);
      ((Intent)localObject).addFlags(268435456);
      com.tencent.mm.bs.d.b(paramContext, "account", ".ui.LoginUI", (Intent)localObject);
      AppMethodBeat.o(124371);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[] { paramString });
    AppMethodBeat.o(124371);
  }
  
  public static boolean bK(String paramString, long paramLong)
  {
    AppMethodBeat.i(124347);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = aLn(paramString);
      if (!EJv.containsKey(paramString)) {
        break label86;
      }
    }
    label86:
    for (long l = ((Long)EJv.get(paramString)).longValue();; l = -1L)
    {
      if ((l != -1L) && ((l == 0L) || ((l & paramLong) == l))) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(124347);
        return bool;
      }
    }
  }
  
  private static boolean eYV()
  {
    AppMethodBeat.i(124353);
    if (com.tencent.mm.kernel.g.ajx())
    {
      if (com.tencent.mm.n.g.acA().getInt("WCOEntranceSwitch", 0) > 0)
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IsS, Boolean.TRUE);
        AppMethodBeat.o(124353);
        return true;
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IsS, Boolean.FALSE);
      AppMethodBeat.o(124353);
      return false;
    }
    AppMethodBeat.o(124353);
    return false;
  }
  
  public static void hl(Context paramContext)
  {
    AppMethodBeat.i(124366);
    ao(paramContext, (int)System.currentTimeMillis());
    AppMethodBeat.o(124366);
  }
  
  public static boolean v(Uri paramUri)
  {
    AppMethodBeat.i(124351);
    if (paramUri == null)
    {
      AppMethodBeat.o(124351);
      return false;
    }
    if (!bt.isNullOrNil(paramUri.getQueryParameter("ticket")))
    {
      AppMethodBeat.o(124351);
      return true;
    }
    boolean bool = w(paramUri);
    AppMethodBeat.o(124351);
    return bool;
  }
  
  public static boolean w(Uri paramUri)
  {
    AppMethodBeat.i(124352);
    if (paramUri == null)
    {
      AppMethodBeat.o(124352);
      return false;
    }
    if ((paramUri.toString().startsWith("weixin://dl/business/tempsession/")) || (paramUri.toString().startsWith("weixin://dl/businessTempSession/")))
    {
      AppMethodBeat.o(124352);
      return true;
    }
    AppMethodBeat.o(124352);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g
 * JD-Core Version:    0.7.0.1
 */