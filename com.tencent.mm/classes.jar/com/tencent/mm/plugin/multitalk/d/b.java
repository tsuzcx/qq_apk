package com.tencent.mm.plugin.multitalk.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.aq.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.security.MessageDigest;

public final class b
{
  private static final String FED;
  private static final String FEE;
  
  static
  {
    AppMethodBeat.i(202080);
    FED = "https://" + WeChatHosts.domainString(a.h.host_meeting_qq_com) + "/mobile/wx-entry.html#/?scene=";
    FEE = "https://" + WeChatHosts.domainString(a.h.host_work_weixin_qq_com) + "/nl/meeting_intro_wxwork?scene=";
    AppMethodBeat.o(202080);
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(164079);
    Log.i("MicroMsg.MeetingLinkHelper", "jumpApp, packageName:%s, schema:%s", new Object[] { paramString1, paramString2 });
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString2));
    localIntent.setPackage(paramString1);
    localIntent.setFlags(268435456);
    if ((!(paramContext instanceof Activity)) || (paramBoolean)) {}
    try
    {
      paramBoolean = com.tencent.mm.pluginsdk.model.app.h.b(paramContext, localIntent, getAppName(paramContext, paramString1));
      AppMethodBeat.o(164079);
      return paramBoolean;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(164079);
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
    AppMethodBeat.o(164079);
    return true;
    return false;
  }
  
  public static void bu(Context paramContext, String paramString)
  {
    Intent localIntent = null;
    AppMethodBeat.i(164084);
    Log.i("MicroMsg.MeetingLinkHelper", "handleMeetingLinkClick, isAllowedToShowMeetingLink:%s, isAllowedToShowWorkWeChat:%s", new Object[] { Boolean.valueOf(eZB()), Boolean.valueOf(eZC()) });
    boolean bool;
    if (eZA()) {
      if (eZB())
      {
        bool = jb("com.tencent.wemeet.app", "EF1B5A11844923BB7515E6F6AFCBC45F");
        Log.i("MicroMsg.MeetingLinkHelper", "check meetting install result::%s", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      int j = eZK();
      Object localObject;
      String str;
      if (!bool)
      {
        localObject = eZJ();
        if (paramString.equals("list")) {}
        for (int i = 2;; i = 1)
        {
          c.a(j, 0, 0, 0, i, 0, 0, 0, 0, (String)localObject, 0);
          Log.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url, ");
          localObject = eZJ() + paramString;
          Log.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url:%s", new Object[] { localObject });
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          try
          {
            com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(164084);
            return;
          }
          catch (Exception paramContext)
          {
            paramContext = eZJ();
            if (!paramString.equals("list")) {
              break label381;
            }
          }
          if (eZC())
          {
            bool = jb("com.tencent.wework", "011a40266c8c75d181ddd8e4ddc50075");
            Log.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", new Object[] { Boolean.valueOf(bool) });
            break;
          }
          if (!eZD()) {
            break label637;
          }
          str = eZM();
          localObject = eZL();
          if (localObject != null) {}
          for (localObject = ((i)localObject).optString("md5");; localObject = null)
          {
            Log.i("MicroMsg.MeetingLinkHelper", "other app, packageName:%s, md5:%s", new Object[] { str, localObject });
            if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject))) {
              break label637;
            }
            bool = jb(str, (String)localObject);
            Log.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", new Object[] { Boolean.valueOf(bool) });
            break;
          }
        }
        label381:
        for (i = 2;; i = 1)
        {
          c.a(j, 0, 0, 0, 0, i, 0, 0, 0, paramContext, 0);
          AppMethodBeat.o(164084);
          return;
        }
      }
      Log.i("MicroMsg.MeetingLinkHelper", "already installed, jump app");
      if (eZB())
      {
        if (a(paramContext, "com.tencent.wemeet.app", "wemeet://launch?referer=wechat&from=".concat(String.valueOf(paramString)), paramString.equals("list")))
        {
          c.aM(j, paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        c.aN(j, paramString.equals("list"));
        AppMethodBeat.o(164084);
        return;
      }
      if (eZC())
      {
        if (a(paramContext, "com.tencent.wework", "wxwork://jump?target=jump_to_third_app&businessid=10085&src=wx&scene=".concat(String.valueOf(paramString)), paramString.equals("list")))
        {
          c.aM(j, paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        c.aN(j, paramString.equals("list"));
        AppMethodBeat.o(164084);
        return;
      }
      if (eZD())
      {
        str = eZM();
        i locali = eZL();
        localObject = localIntent;
        if (locali != null) {
          localObject = locali.optString("schema");
        }
        if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject)))
        {
          if (a(paramContext, str, (String)localObject + paramString, paramString.equals("list")))
          {
            c.aM(j, paramString.equals("list"));
            AppMethodBeat.o(164084);
            return;
          }
          c.aN(j, paramString.equals("list"));
        }
      }
      AppMethodBeat.o(164084);
      return;
      label637:
      bool = false;
    }
  }
  
  public static boolean eZA()
  {
    AppMethodBeat.i(164065);
    if ((eZB()) || (eZC()) || (eZD()))
    {
      AppMethodBeat.o(164065);
      return true;
    }
    AppMethodBeat.o(164065);
    return false;
  }
  
  public static boolean eZB()
  {
    AppMethodBeat.i(164066);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVe, 0) == 1)
    {
      AppMethodBeat.o(164066);
      return true;
    }
    AppMethodBeat.o(164066);
    return false;
  }
  
  public static boolean eZC()
  {
    AppMethodBeat.i(164067);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVe, 0) == 2)
    {
      AppMethodBeat.o(164067);
      return true;
    }
    AppMethodBeat.o(164067);
    return false;
  }
  
  private static boolean eZD()
  {
    AppMethodBeat.i(164068);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVe, 0) == 3)
    {
      AppMethodBeat.o(164068);
      return true;
    }
    AppMethodBeat.o(164068);
    return false;
  }
  
  private static String eZE()
  {
    AppMethodBeat.i(164070);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVi, "");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        String str = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.MeetingLinkHelper", "getLocalConfigWording, langCode:%s", new Object[] { str });
        localObject = ((i)localObject).optString(str);
        AppMethodBeat.o(164070);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getLocalConfigWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164070);
    return null;
  }
  
  private static String eZF()
  {
    AppMethodBeat.i(164071);
    String str = eZE();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("dialog");
        AppMethodBeat.o(164071);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigDialogContentWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164071);
    return null;
  }
  
  private static String eZG()
  {
    AppMethodBeat.i(164072);
    String str = eZE();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("dialog_goto");
        AppMethodBeat.o(164072);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigDialogGotoWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164072);
    return null;
  }
  
  public static String eZH()
  {
    AppMethodBeat.i(164073);
    String str = eZE();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("banner_title");
        AppMethodBeat.o(164073);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigBannerTitleWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164073);
    return null;
  }
  
  public static String eZI()
  {
    AppMethodBeat.i(164074);
    String str = eZE();
    if (!Util.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("banner_content");
        AppMethodBeat.o(164074);
        return str;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigBannerContentWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164074);
    return null;
  }
  
  private static String eZJ()
  {
    AppMethodBeat.i(164075);
    String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVf, "");
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      if (!eZB()) {
        break label54;
      }
      str1 = FED;
    }
    for (;;)
    {
      AppMethodBeat.o(164075);
      return str1;
      label54:
      str1 = str2;
      if (eZC()) {
        str1 = FEE;
      }
    }
  }
  
  public static int eZK()
  {
    AppMethodBeat.i(164076);
    if (eZB())
    {
      AppMethodBeat.o(164076);
      return 1;
    }
    if (eZC())
    {
      AppMethodBeat.o(164076);
      return 2;
    }
    if (eZD())
    {
      AppMethodBeat.o(164076);
      return 3;
    }
    AppMethodBeat.o(164076);
    return 0;
  }
  
  private static i eZL()
  {
    AppMethodBeat.i(164080);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVj, "");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        AppMethodBeat.o(164080);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigExtraInfoJsonObject error", new Object[0]);
      }
    }
    AppMethodBeat.o(164080);
    return null;
  }
  
  private static String eZM()
  {
    AppMethodBeat.i(164081);
    Object localObject = eZL();
    if (localObject != null)
    {
      localObject = ((i)localObject).optString("package_name");
      AppMethodBeat.o(164081);
      return localObject;
    }
    AppMethodBeat.o(164081);
    return null;
  }
  
  private static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(164078);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationInfo(paramString, 0).loadLabel(paramContext).toString();
      AppMethodBeat.o(164078);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(164078);
    }
    return null;
  }
  
  public static String getIconUrl()
  {
    AppMethodBeat.i(164069);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVg, "");
    AppMethodBeat.o(164069);
    return str;
  }
  
  public static void hD(Context paramContext)
  {
    AppMethodBeat.i(202020);
    if (eZA())
    {
      String str1 = "";
      String str2 = "";
      if ((!Util.isNullOrNil(eZF())) && (!Util.isNullOrNil(eZG())))
      {
        str1 = eZF();
        str2 = eZG();
      }
      while ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
        AppMethodBeat.o(202020);
        return;
        if (eZB())
        {
          str1 = paramContext.getString(a.h.multitalk_more_than_limited_meeting);
          str2 = paramContext.getString(a.h.multitalk_link_to_meeting);
        }
        else if (eZC())
        {
          str1 = paramContext.getString(a.h.multitalk_more_than_limited_work);
          str2 = paramContext.getString(a.h.multitalk_link_to_work);
        }
      }
      com.tencent.mm.ui.base.h.a(paramContext, str1, "", str2, paramContext.getString(a.h.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164063);
          b.bu(this.pIC, "dlg");
          c.a(b.eZK(), 0, 0, 0, 0, 0, 0, 0, 0, null, 1);
          AppMethodBeat.o(164063);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164064);
          c.a(b.eZK(), 0, 0, 1, 0, 0, 0, 0, 0, null, 0);
          paramAnonymousDialogInterface.cancel();
          AppMethodBeat.o(164064);
        }
      }, a.b.Link);
      c.a(eZK(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
      AppMethodBeat.o(202020);
      return;
    }
    Toast.makeText(paramContext, MMApplicationContext.getContext().getString(a.h.multitalk_select_at, new Object[] { Integer.valueOf(e.eZN()) }), 0).show();
    AppMethodBeat.o(202020);
  }
  
  private static boolean jb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(164077);
    for (;;)
    {
      try
      {
        paramString1 = MMApplicationContext.getContext().getPackageManager().getPackageInfo(paramString1, 64);
        if (paramString1 == null) {
          continue;
        }
        paramString1 = paramString1.signatures[0].toByteArray();
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString1);
        paramString1 = ((MessageDigest)localObject).digest();
        if (paramString1 != null) {
          continue;
        }
        paramString1 = null;
        if (!Util.isEqual(paramString1, paramString2.toUpperCase()))
        {
          bool = Util.isEqual(paramString1, paramString2.toLowerCase());
          if (!bool) {
            continue;
          }
        }
        bool = true;
      }
      catch (Exception paramString1)
      {
        Object localObject;
        int i;
        String str;
        Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", paramString1, "checkPackageInstalled Exception: %s", new Object[] { paramString1.getMessage() });
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      Log.i("MicroMsg.MeetingLinkHelper", "checkPackageInstalled result:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(164077);
      return bool;
      localObject = new StringBuffer(paramString1.length);
      i = 0;
      if (i < paramString1.length)
      {
        str = Integer.toHexString(paramString1[i] & 0xFF);
        if (str.length() < 2) {
          ((StringBuffer)localObject).append(0);
        }
        ((StringBuffer)localObject).append(str.toLowerCase());
        i += 1;
      }
      else
      {
        paramString1 = ((StringBuffer)localObject).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.b
 * JD-Core Version:    0.7.0.1
 */