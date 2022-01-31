package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.bw;
import com.tencent.mm.h.a.hs;
import com.tencent.mm.h.a.hs.a;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  public static String rSx = "";
  private static final Map<String, Long> rSy;
  
  static
  {
    HashMap localHashMap = new HashMap();
    rSy = localHashMap;
    localHashMap.put("weixin://", Long.valueOf(0L));
    rSy.put("weixin://dl/stickers", Long.valueOf(1L));
    rSy.put("weixin://dl/games", Long.valueOf(2L));
    rSy.put("weixin://dl/moments", Long.valueOf(4L));
    rSy.put("weixin://dl/add", Long.valueOf(8L));
    rSy.put("weixin://dl/shopping", Long.valueOf(16L));
    rSy.put("weixin://dl/groupchat", Long.valueOf(32L));
    rSy.put("weixin://dl/scan", Long.valueOf(64L));
    rSy.put("weixin://dl/profile", Long.valueOf(128L));
    rSy.put("weixin://dl/settings", Long.valueOf(256L));
    rSy.put("weixin://dl/general", Long.valueOf(512L));
    rSy.put("weixin://dl/help", Long.valueOf(1024L));
    rSy.put("weixin://dl/notifications", Long.valueOf(2048L));
    rSy.put("weixin://dl/terms", Long.valueOf(4096L));
    rSy.put("weixin://dl/chat", Long.valueOf(8192L));
    rSy.put("weixin://dl/features", Long.valueOf(16384L));
    rSy.put("weixin://dl/clear", Long.valueOf(32768L));
    rSy.put("weixin://dl/feedback", Long.valueOf(65536L));
    rSy.put("weixin://dl/faq", Long.valueOf(131072L));
    rSy.put("weixin://dl/recommendation", Long.valueOf(262144L));
    rSy.put("weixin://dl/groups", Long.valueOf(524288L));
    rSy.put("weixin://dl/tags", Long.valueOf(1048576L));
    rSy.put("weixin://dl/officialaccounts", Long.valueOf(2097152L));
    rSy.put("weixin://dl/posts", Long.valueOf(4194304L));
    rSy.put("weixin://dl/favorites", Long.valueOf(8388608L));
    rSy.put("weixin://dl/privacy", Long.valueOf(16777216L));
    rSy.put("weixin://dl/security", Long.valueOf(33554432L));
    rSy.put("weixin://dl/wallet", Long.valueOf(67108864L));
    rSy.put("weixin://dl/businessPay", Long.valueOf(134217728L));
    rSy.put("weixin://dl/businessPay/", Long.valueOf(134217728L));
    rSy.put("weixin://dl/wechatout", Long.valueOf(268435456L));
    rSy.put("weixin://dl/protection", Long.valueOf(1073741824L));
    rSy.put("weixin://dl/card", Long.valueOf(2147483648L));
    rSy.put("weixin://dl/about", Long.valueOf(1125899906842624L));
    rSy.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
    rSy.put("weixin://dl/textsize", Long.valueOf(8589934592L));
    rSy.put("weixin://dl/sight", Long.valueOf(17179869184L));
    rSy.put("weixin://dl/languages", Long.valueOf(34359738368L));
    rSy.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
    rSy.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
    rSy.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
    rSy.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
    rSy.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
    rSy.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
    rSy.put("weixin://dl/setname", Long.valueOf(4398046511104L));
    rSy.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
    rSy.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
    rSy.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
    rSy.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
    rSy.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
    rSy.put("weixin://dl/log", Long.valueOf(281474976710656L));
    rSy.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
    rSy.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
    rSy.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
    rSy.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
    rSy.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
    rSy.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    rSy.put("weixin://dl/offlinepay/", Long.valueOf(576460752303423490L));
  }
  
  private static void Q(Context paramContext, int paramInt)
  {
    String str;
    if ((!e.uen) && (com.tencent.mm.sdk.platformtools.x.cqJ().equals("zh_CN"))) {
      str = paramContext.getString(R.l.wechat_faq_url);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.DeepLinkHelper", "using faq webpage");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("show_feedback", false);
      localIntent.putExtra("KShowFixToolsBtn", true);
      localIntent.putExtra("geta8key_session_id", paramInt);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      if (com.tencent.mm.sdk.platformtools.x.cqJ().equals("zh_HK")) {
        str = paramContext.getString(R.l.wechat_faq_url_cht);
      } else if (com.tencent.mm.sdk.platformtools.x.cqJ().equals("zh_TW")) {
        str = paramContext.getString(R.l.wechat_faq_url_cht_tw);
      } else {
        str = paramContext.getString(R.l.wechat_faq_url_en);
      }
    }
  }
  
  public static boolean VA(String paramString)
  {
    return (!bk.bl(paramString)) && (paramString.startsWith("weixin://dl/business"));
  }
  
  public static boolean VB(String paramString)
  {
    return (!bk.bl(paramString)) && (paramString.startsWith("weixin://dl/openbusinesswebview"));
  }
  
  private static boolean VC(String paramString)
  {
    if (((paramString.equals("weixin://dl/wechatout")) || (paramString.equals("weixin://dl/wechatoutcoupon")) || (paramString.equals("weixin://dl/wechatoutshare"))) && (!Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.bbM()).booleanValue()))
    {
      paramString = new Intent();
      paramString.setFlags(268435456);
      paramString.setClassName(ae.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      ae.getContext().startActivity(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean VD(String paramString)
  {
    return a(null, paramString, 0, null, (int)System.currentTimeMillis(), new byte[0], null);
  }
  
  private static String VE(String paramString)
  {
    String str = null;
    if (!bk.bl(paramString))
    {
      paramString = Uri.parse(paramString);
      str = paramString.getScheme() + "://" + paramString.getHost() + paramString.getPath();
    }
    return str;
  }
  
  public static boolean Vz(String paramString)
  {
    paramString = VE(paramString);
    return (rSy.containsKey(paramString)) || (VA(paramString)) || (VB(paramString));
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Bundle paramBundle, a parama)
  {
    a(paramContext, paramString, paramInt, paramBundle, parama, null, null);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, a parama, String paramString2, String paramString3)
  {
    LinkedList localLinkedList = new LinkedList();
    cw localcw = new cw();
    if ((!bk.bl(paramString2)) && (!bk.bl(paramString3)))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[] { paramString2, paramString3 });
      localcw.iQe = paramString2;
      localcw.signature = paramString3;
      localLinkedList.add(localcw);
    }
    if (VC(paramString1)) {
      return;
    }
    paramString2 = new aa(paramString1, paramInt, localLinkedList);
    paramContext = new d.2(paramBundle, paramContext, paramInt, paramString1, parama);
    au.Dk().a(1200, paramContext);
    au.Dk().a(paramString2, 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, a parama)
  {
    a(paramContext, paramString, paramInt, null, parama, null, null);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, a parama, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramInt, null, parama, paramString2, paramString3);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, a parama)
  {
    if (bk.bl(paramString1)) {
      paramString1 = paramString3;
    }
    while (VC(paramString1)) {
      return;
    }
    paramString3 = new com.tencent.mm.modelsimple.h(paramString1, paramString2, paramInt, 0, (int)System.currentTimeMillis(), new byte[0]);
    paramContext = new d.1(paramContext, paramInt, paramString2, paramString1, parama);
    au.Dk().a(233, paramContext);
    au.Dk().a(paramString3, 0);
  }
  
  public static boolean a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    return a(paramContext, paramString, 0, null, paramInt, paramArrayOfByte, null);
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt1, Bundle paramBundle, int paramInt2, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject1 = VE(paramString1);
    if (bk.bl((String)localObject1)) {
      return false;
    }
    long l;
    String str1;
    if (rSy.containsKey(localObject1))
    {
      l = ((Long)rSy.get(localObject1)).longValue();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", new Object[] { Long.valueOf(l) });
      str1 = null;
      localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      if (l == 0L)
      {
        paramBundle = "com.tencent.mm.ui.LauncherUI";
        paramString2 = (String)localObject1;
        if (bk.bl(paramBundle)) {
          break label3391;
        }
        paramString2.setClassName(ae.getContext(), paramBundle);
        if (paramContext == null) {
          break label3350;
        }
      }
    }
    for (;;)
    {
      String str2;
      int i;
      try
      {
        String str3;
        String str4;
        String str5;
        Object localObject2;
        for (;;)
        {
          paramContext.startActivity(paramString2);
          return true;
          if (l == 1L)
          {
            paramBundle = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
            com.tencent.mm.plugin.report.service.h.nFQ.f(12065, new Object[] { Integer.valueOf(7) });
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
            if ((com.tencent.mm.model.q.Gu() & 0x8000) == 0) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              paramBundle = str1;
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
            paramString1 = new hs();
            com.tencent.mm.sdk.b.a.udP.m(paramString1);
            paramString1 = paramString1.bPM.url;
            paramBundle = str1;
            paramString2 = (String)localObject1;
            if (bk.bl(paramString1)) {
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
            ((Intent)localObject1).putExtra("titile", ae.getContext().getString(R.l.address_title_launch_chatting));
            ((Intent)localObject1).putExtra("list_type", 0);
            ((Intent)localObject1).putExtra("list_attr", com.tencent.mm.ui.contact.s.v(new int[] { com.tencent.mm.ui.contact.s.vMt, 256, 512 }));
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
            Q(ae.getContext(), paramInt2);
            paramBundle = str1;
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
            ((Intent)localObject1).putExtra("title", ae.getContext().getResources().getString(R.l.privacy_tip));
            ((Intent)localObject1).putExtra("rawUrl", ae.getContext().getResources().getString(R.l.url_agreement));
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
                break label4847;
              }
              paramString1 = paramString1.substring(paramInt1 + 1);
              com.tencent.mm.kernel.g.DN();
              paramInt1 = com.tencent.mm.kernel.a.CK();
              paramBundle = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
              paramString2 = URLEncoder.encode(bk.crV(), "utf-8");
              str2 = URLEncoder.encode(com.tencent.mm.compatible.e.q.zf(), "utf-8");
              str3 = URLEncoder.encode(com.tencent.mm.protocal.d.soU, "utf-8");
              str4 = URLEncoder.encode(com.tencent.mm.protocal.d.soV, "utf-8");
              str5 = URLEncoder.encode(com.tencent.mm.protocal.d.soW, "utf-8");
              localObject2 = URLEncoder.encode(au.Df(), "utf-8");
              String str6 = URLEncoder.encode(bk.fU(ae.getContext()), "utf-8");
              paramBundle = new StringBuilder("&uin=").append(paramInt1).append("&deviceName=").append(paramBundle).append("&timeZone=").append(paramString2).append("&imei=").append(str2).append("&deviceBrand=").append(str3).append("&deviceModel=").append(str4).append("&ostype=").append(str5).append("&clientSeqID=").append((String)localObject2).append("&signature=").append(str6).append("&scene=");
              if (bk.bl(paramString1)) {}
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                paramBundle = paramInt1;
                paramString1 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.spa + "&lang=" + com.tencent.mm.sdk.platformtools.x.fB(ae.getContext()) + "&" + bk.pm(paramString1) + paramBundle;
                ((Intent)localObject1).putExtra("showShare", false);
                ((Intent)localObject1).putExtra("rawUrl", paramString1);
                ((Intent)localObject1).putExtra("neverGetA8Key", true);
                ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
                ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
                ((Intent)localObject1).putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
                ((Intent)localObject1).putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
                paramBundle = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                paramString2 = (String)localObject1;
                break;
              }
            }
            catch (UnsupportedEncodingException paramString1)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", new Object[] { paramString1.getMessage() });
              paramBundle = str1;
              paramString2 = (String)localObject1;
            }
          }
        }
        if (l == 131072L)
        {
          com.tencent.mm.kernel.g.DN();
          paramInt1 = com.tencent.mm.kernel.a.CK();
          au.Hx();
          i = bk.g((Integer)c.Dz().get(12304, null));
          paramString1 = ae.getContext().getString(R.l.settings_system_notice_url, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
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
          com.tencent.mm.br.d.b(ae.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject1);
          return true;
        }
        if (l == 4194304L)
        {
          au.Hx();
          ((Intent)localObject1).putExtra("sns_userName", (String)c.Dz().get(2, null));
          ((Intent)localObject1).addFlags(67108864);
          au.Hx();
          paramInt1 = bk.a((Integer)c.Dz().get(68389, null), 0);
          au.Hx();
          c.Dz().o(68389, Integer.valueOf(paramInt1 + 1));
          paramBundle = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
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
          if ((paramContext != null) && (!bk.bl(paramString1)) && (paramString1.startsWith("weixin://dl/businessPay")))
          {
            paramBundle = Uri.parse(paramString1);
            if (paramBundle == null) {
              continue;
            }
            paramString1 = paramBundle.getQueryParameter("reqkey");
            paramArrayOfByte = paramBundle.getQueryParameter("appid");
            if (!bk.bl(paramString1))
            {
              paramBundle = new PayInfo();
              paramBundle.bMX = paramString1;
              paramBundle.appId = paramArrayOfByte;
              paramBundle.bUV = 36;
              paramBundle.kPR = false;
              paramString2 = new Intent();
              paramString2.putExtra("key_pay_info", paramBundle);
              if (com.tencent.mm.model.q.Gw())
              {
                com.tencent.mm.br.d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramString2, 1);
                paramBundle = str1;
                break;
              }
              com.tencent.mm.br.d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramString2, 1);
              paramBundle = str1;
              break;
            }
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.DeepLinkHelper", "reqkey null");
          }
          paramString2 = null;
          paramBundle = str1;
          break;
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.DeepLinkHelper", "payUri null");
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
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
          paramBundle = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 4294967296L)
        {
          ((Intent)localObject1).putExtra("filter_type", com.tencent.mm.model.y.il(ae.getContext().getString(R.l.group_blacklist)).getType());
          ((Intent)localObject1).putExtra("titile", ae.getContext().getString(R.l.settings_private_blacklist));
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
          ((Intent)localObject1).setClassName(ae.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindQQUI");
          MMWizardActivity.C(paramContext, (Intent)localObject1);
          return true;
        }
        if (l == 274877906944L)
        {
          ((Intent)localObject1).setClassName(ae.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI");
          MMWizardActivity.C(paramContext, (Intent)localObject1);
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
          com.tencent.mm.br.d.b(ae.getContext(), "profile", ".ui.ContactInfoUI", ((Intent)localObject1).putExtra("Contact_User", "qqsync"));
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
          com.tencent.mm.br.d.c(ae.getContext(), "address", ".ui.WalletSelectAddrUI", (Intent)localObject1);
          return true;
        }
        if (l == 35184372088832L)
        {
          ((Intent)localObject1).putExtra("k_sns_tag_id", 4L);
          ((Intent)localObject1).putExtra("k_sns_from_settings_about_sns", 1);
          com.tencent.mm.br.d.b(ae.getContext(), "sns", ".ui.SnsBlackDetailUI", (Intent)localObject1);
          return true;
        }
        if (l == 70368744177664L)
        {
          ((Intent)localObject1).putExtra("k_sns_tag_id", 5L);
          ((Intent)localObject1).putExtra("k_sns_from_settings_about_sns", 2);
          ((Intent)localObject1).putExtra("k_tag_detail_sns_block_scene", 8);
          com.tencent.mm.br.d.b(ae.getContext(), "sns", ".ui.SnsTagDetailUI", (Intent)localObject1);
          paramBundle = str1;
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
          paramContext = new bw();
          paramContext.bIb.bId = "//uplog";
          paramContext.bIb.context = ae.getContext();
          com.tencent.mm.sdk.b.a.udP.m(paramContext);
          return true;
        }
        if (l == 562949953421312L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.br.d.b(ae.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject1);
          com.tencent.mm.br.d.b(ae.getContext(), "ipcall", ".ui.IPCallShareCouponUI", (Intent)localObject1);
          return true;
        }
        if (l == 18014398509481984L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          com.tencent.mm.br.d.b(ae.getContext(), "ipcall", ".ui.IPCallAddressUI", (Intent)localObject1);
          com.tencent.mm.br.d.b(ae.getContext(), "ipcall", ".ui.IPCallShareCouponUI", (Intent)localObject1);
          com.tencent.mm.br.d.b(ae.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", (Intent)localObject1);
          paramBundle = str1;
          paramString2 = (String)localObject1;
          break;
        }
        if (l == 576460752303423488L)
        {
          ((Intent)localObject1).putExtra("IPCallAddressUI_KFrom", 1);
          ((Intent)localObject1).setClassName(ae.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
          ae.getContext().startActivity((Intent)localObject1);
          paramBundle = str1;
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
          com.tencent.mm.plugin.report.service.h.nFQ.f(12065, new Object[] { Integer.valueOf(7) });
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
          str1 = paramString1.getQueryParameter("path");
          i = bk.getInt(bk.pm(paramString1.getQueryParameter("pathType")), 0);
          str2 = paramString1.getQueryParameter("invokeData");
          str3 = paramString1.getQueryParameter("runtimeSessionId");
          str4 = paramString1.getQueryParameter("runtimeTicket");
          str5 = paramString1.getQueryParameter("runtimeAppid");
          paramInt2 = 0;
          paramString1 = u.Hc().v("key_data_center_session_id", false);
          if (paramString1 != null) {
            paramInt2 = ((Integer)paramString1.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", new Object[] { paramArrayOfByte, localObject1, str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          u.Hc().ii("key_data_center_session_id");
          localObject2 = new AppBrandStatObject();
          ((AppBrandStatObject)localObject2).bFv = URLEncoder.encode(paramString2);
          if (paramInt1 == 2)
          {
            ((AppBrandStatObject)localObject2).scene = 1065;
            ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, str1, (AppBrandStatObject)localObject2);
            return true;
          }
          if (paramInt1 == 1)
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.DeepLinkHelper", "pathType:%d invokeData:%s", new Object[] { Integer.valueOf(i), str2 });
            if ((i == 1) && (!bk.bl(str2)))
            {
              paramString1 = "";
              try
              {
                paramBundle = new com.tencent.mm.ab.i(str2).optString("name");
                paramString1 = paramBundle;
              }
              catch (com.tencent.mm.ab.g paramBundle)
              {
                com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramBundle, "", new Object[0]);
                continue;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "runtimeSessionId:%s runtimeTicket:%s runtimeAppId:%s functionName:%s", new Object[] { str3, str4, str5, paramString1 });
              ((AppBrandStatObject)localObject2).scene = 1111;
              ((AppBrandStatObject)localObject2).bFv = (str5 + ":" + paramString1);
              ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramContext, (String)localObject1, paramInt2, str1, (AppBrandStatObject)localObject2, paramArrayOfByte, str2);
              continue;
            }
            ((AppBrandStatObject)localObject2).scene = 1069;
            ((AppBrandStatObject)localObject2).bFv = paramArrayOfByte;
            ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, str1, (AppBrandStatObject)localObject2, paramArrayOfByte);
            continue;
          }
          if (paramInt1 == 6)
          {
            ((AppBrandStatObject)localObject2).scene = 1007;
            ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, str1, (AppBrandStatObject)localObject2);
            continue;
          }
          if (paramInt1 == 7)
          {
            ((AppBrandStatObject)localObject2).scene = 1008;
            ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramContext, (String)localObject1, null, paramInt2, 0, str1, (AppBrandStatObject)localObject2);
            continue;
          }
          ((AppBrandStatObject)localObject2).scene = 1000;
          ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramContext, (String)localObject1, null, 0, 0, str1, (AppBrandStatObject)localObject2);
          continue;
        }
        paramBundle = str1;
        paramString2 = (String)localObject1;
        if (l != 576460752303423490L) {
          break;
        }
        paramString1 = Uri.parse(paramString1).getQueryParameter("appid");
        paramBundle = new Intent();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletManager", "start offline from sdk: %s", new Object[] { paramString1 });
        paramBundle.putExtra("key_from_scene", 8);
        paramBundle.putExtra("key_appid", paramString1);
        com.tencent.mm.br.d.b(paramContext, "offline", ".ui.WalletOfflineEntranceUI", paramBundle, 0);
        paramBundle = str1;
        paramString2 = (String)localObject1;
        break;
        label3350:
        ae.getContext().startActivity(paramString2);
        b.D(ae.getContext(), paramString2);
        continue;
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
        continue;
      }
      label3391:
      return false;
      if (((String)localObject1).startsWith("weixin://dl/businessTempSession/"))
      {
        paramString2 = new Intent();
        paramString2.setFlags(268435456);
        localObject1 = Uri.parse(paramString1);
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
          return false;
        }
        str1 = ((Uri)localObject1).getQueryParameter("sessionFrom");
        str2 = ((Uri)localObject1).getQueryParameter("showtype");
        paramArrayOfByte = ((Uri)localObject1).getQueryParameter("username");
        paramBundle = paramArrayOfByte;
        if (bk.bl(paramArrayOfByte)) {
          paramBundle = ((Uri)localObject1).getQueryParameter("userName");
        }
        if (bk.bl(paramBundle))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
          return false;
        }
        i = bk.getInt(bk.pm(((Uri)localObject1).getQueryParameter("scene")), 0);
        paramInt2 = paramInt1;
        if (i != 0)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == 4)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i);
            paramInt2 = i;
          }
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", new Object[] { paramBundle, str1, Integer.valueOf(paramInt2), paramString1, str2 });
        paramString2.setClassName(ae.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
        paramString2.putExtra("Chat_User", paramBundle);
        paramString2.putExtra("finish_direct", true);
        paramString2.putExtra("key_is_temp_session", true);
        paramString2.putExtra("key_temp_session_from", str1);
        paramString2.putExtra("key_temp_session_scene", paramInt2);
        paramString2.putExtra("key_temp_session_show_type", bk.getInt(str2, 0));
        au.Hx();
        paramString1 = c.Fw().abl(paramBundle);
        if ((paramString1 == null) || ((int)paramString1.dBe <= 0)) {
          am.a.dVy.a(paramBundle, "", new d.3(paramString2, paramContext));
        }
        for (;;)
        {
          return true;
          paramContext.startActivity(paramString2);
        }
      }
      if ((((String)localObject1).startsWith("weixin://dl/businessGame/detail/")) || (((String)localObject1).startsWith("weixin://dl/businessGame/detail")))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
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
        if (!bk.bl(paramString1))
        {
          paramBundle.setClassName(ae.getContext(), paramString1);
          if (paramContext != null) {}
          try
          {
            paramContext.startActivity(paramBundle);
          }
          catch (Exception paramContext)
          {
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
          }
          ae.getContext().startActivity(paramBundle);
          b.D(ae.getContext(), paramBundle);
          break label4853;
        }
        return false;
      }
      if ((((String)localObject1).startsWith("weixin://dl/businessGame/library/")) || (((String)localObject1).startsWith("weixin://dl/businessGame/library")))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
        paramString1 = new Intent();
        if (!bk.bl("com.tencent.mm.plugin.game.ui.GameLibraryUI"))
        {
          paramString1.putExtra("game_report_from_scene", 6);
          paramString1.setClassName(ae.getContext(), "com.tencent.mm.plugin.game.ui.GameLibraryUI");
          if (paramContext != null) {}
          try
          {
            paramContext.startActivity(paramString1);
          }
          catch (Exception paramContext)
          {
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
          }
          ae.getContext().startActivity(paramString1);
          b.D(ae.getContext(), paramString1);
          break label4855;
        }
        return false;
      }
      if ((((String)localObject1).startsWith("weixin://dl/businessWebview/link/")) || (((String)localObject1).startsWith("weixin://dl/businessWebview/link")))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
        paramString2 = Uri.parse(paramString1);
        localObject1 = new Intent();
        paramString1 = null;
        int j;
        if (paramString2 != null)
        {
          paramString1 = paramString2.getQueryParameter("url");
          i = bk.getInt(paramString2.getQueryParameter("type"), 0);
          str1 = bk.pm(paramString2.getQueryParameter("appid"));
          j = bk.getInt(bk.pm(paramString2.getQueryParameter("outer")), 0);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", new Object[] { paramString1, str1, Integer.valueOf(paramInt1), Integer.valueOf(j) });
          paramString2 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          ((Intent)localObject1).putExtra("rawUrl", paramString1);
          ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
          ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
          if (paramInt1 != 1) {
            break label4390;
          }
          if (j == 1)
          {
            ((Intent)localObject1).putExtra("geta8key_open_webview_appid", str1);
            ((Intent)localObject1).putExtra("geta8key_scene", 53);
          }
          ((Intent)localObject1).putExtra("show_openapp_dialog", false);
          ((Intent)localObject1).putExtra("pay_channel", 40);
          com.tencent.mm.pluginsdk.wallet.i.Ez(39);
        }
        for (;;)
        {
          if (i == 5)
          {
            ((Intent)localObject1).putExtra("webview_invoke_launch_app_when_back", true);
            ((Intent)localObject1).putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[] { str1, Integer.valueOf(i), Integer.valueOf(-2) }));
            ((Intent)localObject1).putExtra("KAppId", str1);
          }
          ((Intent)localObject1).putExtra("transaction_for_openapi_openwebview", rSx);
          paramString1 = paramString2;
          if (paramBundle != null)
          {
            ((Intent)localObject1).putExtras(paramBundle);
            paramString1 = paramString2;
          }
          if (!bk.bl(paramString1))
          {
            ((Intent)localObject1).setClassName(ae.getContext(), paramString1);
            if (paramContext != null) {}
            try
            {
              paramContext.startActivity((Intent)localObject1);
              for (;;)
              {
                return true;
                label4390:
                if (paramInt1 != 2) {
                  break;
                }
                if (j == 1)
                {
                  ((Intent)localObject1).putExtra("geta8key_open_webview_appid", str1);
                  ((Intent)localObject1).putExtra("geta8key_scene", 52);
                }
                ((Intent)localObject1).putExtra("pay_channel", 39);
                com.tencent.mm.pluginsdk.wallet.i.Ez(39);
                break;
                ae.getContext().startActivity((Intent)localObject1);
                b.D(ae.getContext(), (Intent)localObject1);
              }
            }
            catch (Exception paramContext)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
              }
            }
          }
        }
        return false;
      }
      if (((String)localObject1).startsWith("weixin://dl/openbusinesswebview/link/"))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith openbusinesswebview");
        paramString2 = Uri.parse(paramString1);
        localObject1 = new Intent();
        paramString1 = null;
        if (paramString2 != null)
        {
          paramString1 = paramString2.getQueryParameter("url");
          i = bk.getInt(paramString2.getQueryParameter("type"), 0);
          str1 = bk.pm(paramString2.getQueryParameter("appid"));
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", new Object[] { paramString1, str1, Integer.valueOf(paramInt1), Integer.valueOf(bk.getInt(bk.pm(paramString2.getQueryParameter("outer")), 0)) });
          paramString2 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
          ((Intent)localObject1).putExtra("rawUrl", paramString1);
          ((Intent)localObject1).putExtra("geta8key_session_id", paramInt2);
          ((Intent)localObject1).putExtra("geta8key_cookie", paramArrayOfByte);
          ((Intent)localObject1).putExtra("geta8key_open_webview_appid", str1);
          ((Intent)localObject1).putExtra("geta8key_scene", 57);
          ((Intent)localObject1).putExtra("show_openapp_dialog", false);
          ((Intent)localObject1).putExtra("webview_invoke_launch_app_when_back", true);
          ((Intent)localObject1).putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://openbusinesswebview?type=%d&ret=%d", new Object[] { str1, Integer.valueOf(i), Integer.valueOf(-2) }));
          ((Intent)localObject1).putExtra("KAppId", str1);
          ((Intent)localObject1).putExtra("transaction_for_openapi_openwebview", rSx);
          paramString1 = paramString2;
          if (paramBundle != null)
          {
            ((Intent)localObject1).putExtras(paramBundle);
            paramString1 = paramString2;
          }
        }
        if (!bk.bl(paramString1))
        {
          ((Intent)localObject1).setClassName(ae.getContext(), paramString1);
          if (paramContext != null) {}
          try
          {
            paramContext.startActivity((Intent)localObject1);
          }
          catch (Exception paramContext)
          {
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramContext, "", new Object[] { "" });
          }
          ae.getContext().startActivity((Intent)localObject1);
          b.D(ae.getContext(), (Intent)localObject1);
          break label4857;
        }
        return false;
      }
      return false;
      label4847:
      paramString1 = "";
    }
    label4853:
    return true;
    label4855:
    return true;
    label4857:
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    return a(paramContext, paramString1, paramInt, paramBundle, (int)System.currentTimeMillis(), new byte[0], paramString2);
  }
  
  public static boolean ao(String paramString, long paramLong)
  {
    if (!bk.bl(paramString))
    {
      paramString = VE(paramString);
      if (!rSy.containsKey(paramString)) {
        break label66;
      }
    }
    label66:
    for (long l = ((Long)rSy.get(paramString)).longValue();; l = -1L) {
      return (l != -1L) && ((l == 0L) || ((l & paramLong) == l));
    }
  }
  
  public static void bf(Context paramContext, String paramString)
  {
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
      return;
    }
    Object localObject;
    if (paramString.startsWith("weixin://dl/login/phone_view"))
    {
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("cc");
      localObject = ((Uri)localObject).getQueryParameter("num");
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[] { paramString, localObject });
      Intent localIntent = new Intent(paramContext, MobileInputUI.class);
      localIntent.putExtra("couttry_code", paramString);
      localIntent.putExtra("input_mobile_number", (String)localObject);
      localIntent.putExtra("from_deep_link", true);
      localIntent.putExtra("mobile_input_purpose", 1);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    if (paramString.startsWith("weixin://dl/login/common_view"))
    {
      paramString = Uri.parse(paramString).getQueryParameter("username");
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[] { paramString });
      localObject = new Intent(paramContext, LoginUI.class);
      ((Intent)localObject).putExtra("login_username", paramString);
      ((Intent)localObject).putExtra("from_deep_link", true);
      ((Intent)localObject).addFlags(268435456);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[] { paramString });
  }
  
  public static void eJ(Context paramContext)
  {
    Q(paramContext, (int)System.currentTimeMillis());
  }
  
  public static boolean j(Uri paramUri)
  {
    if (paramUri == null) {
      return false;
    }
    if (!bk.bl(paramUri.getQueryParameter("ticket"))) {
      return true;
    }
    return k(paramUri);
  }
  
  public static boolean k(Uri paramUri)
  {
    if (paramUri == null) {}
    while ((!paramUri.toString().startsWith("weixin://dl/business/tempsession/")) && (!paramUri.toString().startsWith("weixin://dl/businessTempSession/"))) {
      return false;
    }
    return true;
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2)
  {
    if (VC(paramString2)) {
      return;
    }
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramContext, "", true, null);
    int j = 6;
    int i = j;
    if (!bk.bl(paramString1))
    {
      if (!com.tencent.mm.model.s.fn(paramString1)) {
        break label59;
      }
      i = 7;
    }
    for (;;)
    {
      a(paramContext, paramString2, i, new d.4(localp, paramContext));
      return;
      label59:
      i = j;
      if (com.tencent.mm.model.s.hl(paramString1)) {
        i = 9;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d
 * JD-Core Version:    0.7.0.1
 */