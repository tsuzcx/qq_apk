package com.tencent.mm.plugin.multitalk.e;

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
import com.tencent.mm.plugin.ar.a.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.k;
import java.security.MessageDigest;

public final class b
{
  private static final String LAo;
  private static final String LAp;
  
  static
  {
    AppMethodBeat.i(284716);
    LAo = "https://" + WeChatHosts.domainString(a.h.host_meeting_qq_com) + "/mobile/wx-entry.html#/?scene=";
    LAp = "https://" + WeChatHosts.domainString(a.h.host_work_weixin_qq_com) + "/nl/meeting_intro_wxwork?scene=";
    AppMethodBeat.o(284716);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)paramContext).overridePendingTransition(a.a.sight_slide_bottom_in, -1);
    AppMethodBeat.o(164079);
    return true;
    return false;
  }
  
  public static void bw(Context paramContext, String paramString)
  {
    Intent localIntent = null;
    AppMethodBeat.i(164084);
    Log.i("MicroMsg.MeetingLinkHelper", "handleMeetingLinkClick, isAllowedToShowMeetingLink:%s, isAllowedToShowWorkWeChat:%s", new Object[] { Boolean.valueOf(giC()), Boolean.valueOf(giD()) });
    boolean bool;
    if (giB()) {
      if (giC())
      {
        bool = kq("com.tencent.wemeet.app", "EF1B5A11844923BB7515E6F6AFCBC45F");
        Log.i("MicroMsg.MeetingLinkHelper", "check meetting install result::%s", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      int j = giL();
      Object localObject;
      String str;
      if (!bool)
      {
        localObject = giK();
        if (paramString.equals("list")) {}
        for (int i = 2;; i = 1)
        {
          c.a(j, 0, 0, 0, i, 0, 0, 0, 0, (String)localObject, 0);
          Log.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url, ");
          localObject = giK() + paramString;
          Log.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url:%s", new Object[] { localObject });
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject);
          try
          {
            com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(164084);
            return;
          }
          catch (Exception paramContext)
          {
            paramContext = giK();
            if (!paramString.equals("list")) {
              break label381;
            }
          }
          if (giD())
          {
            bool = kq("com.tencent.wework", "011a40266c8c75d181ddd8e4ddc50075");
            Log.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", new Object[] { Boolean.valueOf(bool) });
            break;
          }
          if (!giE()) {
            break label637;
          }
          str = giN();
          localObject = giM();
          if (localObject != null) {}
          for (localObject = ((i)localObject).optString("md5");; localObject = null)
          {
            Log.i("MicroMsg.MeetingLinkHelper", "other app, packageName:%s, md5:%s", new Object[] { str, localObject });
            if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject))) {
              break label637;
            }
            bool = kq(str, (String)localObject);
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
      if (giC())
      {
        if (a(paramContext, "com.tencent.wemeet.app", "wemeet://launch?referer=wechat&from=".concat(String.valueOf(paramString)), paramString.equals("list")))
        {
          c.bn(j, paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        c.bo(j, paramString.equals("list"));
        AppMethodBeat.o(164084);
        return;
      }
      if (giD())
      {
        if (a(paramContext, "com.tencent.wework", "wxwork://jump?target=jump_to_third_app&businessid=10085&src=wx&scene=".concat(String.valueOf(paramString)), paramString.equals("list")))
        {
          c.bn(j, paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        c.bo(j, paramString.equals("list"));
        AppMethodBeat.o(164084);
        return;
      }
      if (giE())
      {
        str = giN();
        i locali = giM();
        localObject = localIntent;
        if (locali != null) {
          localObject = locali.optString("schema");
        }
        if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject)))
        {
          if (a(paramContext, str, (String)localObject + paramString, paramString.equals("list")))
          {
            c.bn(j, paramString.equals("list"));
            AppMethodBeat.o(164084);
            return;
          }
          c.bo(j, paramString.equals("list"));
        }
      }
      AppMethodBeat.o(164084);
      return;
      label637:
      bool = false;
    }
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
    String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znK, "");
    AppMethodBeat.o(164069);
    return str;
  }
  
  public static boolean giB()
  {
    AppMethodBeat.i(164065);
    if ((giC()) || (giD()) || (giE()))
    {
      AppMethodBeat.o(164065);
      return true;
    }
    AppMethodBeat.o(164065);
    return false;
  }
  
  public static boolean giC()
  {
    AppMethodBeat.i(164066);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znI, 0) == 1)
    {
      AppMethodBeat.o(164066);
      return true;
    }
    AppMethodBeat.o(164066);
    return false;
  }
  
  public static boolean giD()
  {
    AppMethodBeat.i(164067);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znI, 0) == 2)
    {
      AppMethodBeat.o(164067);
      return true;
    }
    AppMethodBeat.o(164067);
    return false;
  }
  
  private static boolean giE()
  {
    AppMethodBeat.i(164068);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znI, 0) == 3)
    {
      AppMethodBeat.o(164068);
      return true;
    }
    AppMethodBeat.o(164068);
    return false;
  }
  
  private static String giF()
  {
    AppMethodBeat.i(164070);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znM, "");
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
  
  private static String giG()
  {
    AppMethodBeat.i(164071);
    String str = giF();
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
  
  private static String giH()
  {
    AppMethodBeat.i(164072);
    String str = giF();
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
  
  public static String giI()
  {
    AppMethodBeat.i(164073);
    String str = giF();
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
  
  public static String giJ()
  {
    AppMethodBeat.i(164074);
    String str = giF();
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
  
  private static String giK()
  {
    AppMethodBeat.i(164075);
    String str2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znJ, "");
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      if (!giC()) {
        break label54;
      }
      str1 = LAo;
    }
    for (;;)
    {
      AppMethodBeat.o(164075);
      return str1;
      label54:
      str1 = str2;
      if (giD()) {
        str1 = LAp;
      }
    }
  }
  
  public static int giL()
  {
    AppMethodBeat.i(164076);
    if (giC())
    {
      AppMethodBeat.o(164076);
      return 1;
    }
    if (giD())
    {
      AppMethodBeat.o(164076);
      return 2;
    }
    if (giE())
    {
      AppMethodBeat.o(164076);
      return 3;
    }
    AppMethodBeat.o(164076);
    return 0;
  }
  
  private static i giM()
  {
    AppMethodBeat.i(164080);
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znN, "");
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
  
  private static String giN()
  {
    AppMethodBeat.i(164081);
    Object localObject = giM();
    if (localObject != null)
    {
      localObject = ((i)localObject).optString("package_name");
      AppMethodBeat.o(164081);
      return localObject;
    }
    AppMethodBeat.o(164081);
    return null;
  }
  
  public static void je(Context paramContext)
  {
    AppMethodBeat.i(284641);
    if (giB())
    {
      String str1 = "";
      String str2 = "";
      if ((!Util.isNullOrNil(giG())) && (!Util.isNullOrNil(giH())))
      {
        str1 = giG();
        str2 = giH();
      }
      while ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
        AppMethodBeat.o(284641);
        return;
        if (giC())
        {
          str1 = paramContext.getString(a.h.multitalk_more_than_limited_meeting);
          str2 = paramContext.getString(a.h.multitalk_link_to_meeting);
        }
        else if (giD())
        {
          str1 = paramContext.getString(a.h.multitalk_more_than_limited_work);
          str2 = paramContext.getString(a.h.multitalk_link_to_work);
        }
      }
      k.a(paramContext, str1, "", str2, paramContext.getString(a.h.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164063);
          b.bw(b.this, "dlg");
          c.a(b.giL(), 0, 0, 0, 0, 0, 0, 0, 0, null, 1);
          AppMethodBeat.o(164063);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164064);
          c.a(b.giL(), 0, 0, 1, 0, 0, 0, 0, 0, null, 0);
          paramAnonymousDialogInterface.cancel();
          AppMethodBeat.o(164064);
        }
      }, a.b.Link);
      c.a(giL(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
      AppMethodBeat.o(284641);
      return;
    }
    Toast.makeText(paramContext, MMApplicationContext.getContext().getString(a.h.multitalk_select_at, new Object[] { Integer.valueOf(f.giS()) }), 0).show();
    AppMethodBeat.o(284641);
  }
  
  private static boolean kq(String paramString1, String paramString2)
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
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.b
 * JD-Core Version:    0.7.0.1
 */