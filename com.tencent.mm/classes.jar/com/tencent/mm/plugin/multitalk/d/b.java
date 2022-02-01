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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.security.MessageDigest;

public final class b
{
  private static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(164079);
    ae.i("MicroMsg.MeetingLinkHelper", "jumpApp, packageName:%s, schema:%s", new Object[] { paramString1, paramString2 });
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString2));
    localIntent.setPackage(paramString1);
    localIntent.setFlags(268435456);
    if ((!(paramContext instanceof Activity)) || (paramBoolean)) {}
    try
    {
      paramBoolean = h.b(paramContext, localIntent, getAppName(paramContext, paramString1));
      AppMethodBeat.o(164079);
      return paramBoolean;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(164079);
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahE(), "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)paramContext).overridePendingTransition(2130772137, -1);
    AppMethodBeat.o(164079);
    return true;
    return false;
  }
  
  public static void aV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(164084);
    ae.i("MicroMsg.MeetingLinkHelper", "handleMeetingLinkClick, isAllowedToShowMeetingLink:%s, isAllowedToShowWorkWeChat:%s", new Object[] { Boolean.valueOf(dun()), Boolean.valueOf(duo()) });
    boolean bool;
    if (dum()) {
      if (dun())
      {
        bool = ih("com.tencent.wemeet.app", "EF1B5A11844923BB7515E6F6AFCBC45F");
        ae.i("MicroMsg.MeetingLinkHelper", "check meetting install result::%s", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      int i = duw();
      String str;
      Object localObject;
      if (!bool)
      {
        c.f(i, duv(), paramString.equals("list"));
        ae.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url, ");
        str = duv() + paramString;
        ae.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url:%s", new Object[] { str });
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", str);
        try
        {
          d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(164084);
          return;
        }
        catch (Exception paramContext)
        {
          c.g(i, duv(), paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        if (duo())
        {
          bool = ih("com.tencent.wework", "011a40266c8c75d181ddd8e4ddc50075");
          ae.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", new Object[] { Boolean.valueOf(bool) });
          continue;
        }
        if (!dup()) {
          break label539;
        }
        str = duy();
        localObject = duA();
        ae.i("MicroMsg.MeetingLinkHelper", "other app, packageName:%s, md5:%s", new Object[] { str, localObject });
        if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject))) {
          break label539;
        }
        bool = ih(str, (String)localObject);
        ae.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", new Object[] { Boolean.valueOf(bool) });
        continue;
      }
      ae.i("MicroMsg.MeetingLinkHelper", "already installed, jump app");
      if (dun())
      {
        if (a(paramContext, "com.tencent.wemeet.app", "wemeet://launch?referer=wechat&from=".concat(String.valueOf(paramString)), paramString.equals("list")))
        {
          c.au(i, paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        c.av(i, paramString.equals("list"));
        AppMethodBeat.o(164084);
        return;
      }
      if (duo())
      {
        if (a(paramContext, "com.tencent.wework", "wxwork://jump?target=jump_to_third_app&businessid=10085&src=wx&scene=".concat(String.valueOf(paramString)), paramString.equals("list")))
        {
          c.au(i, paramString.equals("list"));
          AppMethodBeat.o(164084);
          return;
        }
        c.av(i, paramString.equals("list"));
        AppMethodBeat.o(164084);
        return;
      }
      if (dup())
      {
        str = duy();
        localObject = duz();
        if ((!bu.isNullOrNil(str)) && (!bu.isNullOrNil((String)localObject)))
        {
          if (a(paramContext, str, (String)localObject + paramString, paramString.equals("list")))
          {
            c.au(i, paramString.equals("list"));
            AppMethodBeat.o(164084);
            return;
          }
          c.av(i, paramString.equals("list"));
        }
      }
      AppMethodBeat.o(164084);
      return;
      label539:
      bool = false;
    }
  }
  
  private static String duA()
  {
    AppMethodBeat.i(164083);
    Object localObject = dux();
    if (localObject != null)
    {
      localObject = ((i)localObject).optString("md5");
      AppMethodBeat.o(164083);
      return localObject;
    }
    AppMethodBeat.o(164083);
    return null;
  }
  
  public static boolean dum()
  {
    AppMethodBeat.i(164065);
    if ((dun()) || (duo()) || (dup()))
    {
      AppMethodBeat.o(164065);
      return true;
    }
    AppMethodBeat.o(164065);
    return false;
  }
  
  public static boolean dun()
  {
    AppMethodBeat.i(164066);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNF, 0) == 1)
    {
      AppMethodBeat.o(164066);
      return true;
    }
    AppMethodBeat.o(164066);
    return false;
  }
  
  public static boolean duo()
  {
    AppMethodBeat.i(164067);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNF, 0) == 2)
    {
      AppMethodBeat.o(164067);
      return true;
    }
    AppMethodBeat.o(164067);
    return false;
  }
  
  private static boolean dup()
  {
    AppMethodBeat.i(164068);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNF, 0) == 3)
    {
      AppMethodBeat.o(164068);
      return true;
    }
    AppMethodBeat.o(164068);
    return false;
  }
  
  private static String duq()
  {
    AppMethodBeat.i(164070);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNJ, "");
    if (!bu.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        String str = ad.fom();
        ae.i("MicroMsg.MeetingLinkHelper", "getLocalConfigWording, langCode:%s", new Object[] { str });
        localObject = ((i)localObject).optString(str);
        AppMethodBeat.o(164070);
        return localObject;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getLocalConfigWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164070);
    return null;
  }
  
  public static String dur()
  {
    AppMethodBeat.i(164071);
    String str = duq();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("dialog");
        AppMethodBeat.o(164071);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigDialogContentWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164071);
    return null;
  }
  
  public static String dus()
  {
    AppMethodBeat.i(164072);
    String str = duq();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("dialog_goto");
        AppMethodBeat.o(164072);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigDialogGotoWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164072);
    return null;
  }
  
  public static String dut()
  {
    AppMethodBeat.i(164073);
    String str = duq();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("banner_title");
        AppMethodBeat.o(164073);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigBannerTitleWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164073);
    return null;
  }
  
  public static String duu()
  {
    AppMethodBeat.i(164074);
    String str = duq();
    if (!bu.isNullOrNil(str)) {
      try
      {
        str = new i(str).optString("banner_content");
        AppMethodBeat.o(164074);
        return str;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigBannerContentWording error", new Object[0]);
      }
    }
    AppMethodBeat.o(164074);
    return null;
  }
  
  private static String duv()
  {
    AppMethodBeat.i(164075);
    String str2 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNG, "");
    String str1 = str2;
    if (bu.isNullOrNil(str2))
    {
      if (!dun()) {
        break label54;
      }
      str1 = "https://meeting.qq.com/mobile/wx-entry.html#/?scene=";
    }
    for (;;)
    {
      AppMethodBeat.o(164075);
      return str1;
      label54:
      str1 = str2;
      if (duo()) {
        str1 = "https://work.weixin.qq.com/nl/meeting_intro_wxwork?scene=";
      }
    }
  }
  
  public static int duw()
  {
    AppMethodBeat.i(164076);
    if (dun())
    {
      AppMethodBeat.o(164076);
      return 1;
    }
    if (duo())
    {
      AppMethodBeat.o(164076);
      return 2;
    }
    if (dup())
    {
      AppMethodBeat.o(164076);
      return 3;
    }
    AppMethodBeat.o(164076);
    return 0;
  }
  
  private static i dux()
  {
    AppMethodBeat.i(164080);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNK, "");
    if (!bu.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new i((String)localObject);
        AppMethodBeat.o(164080);
        return localObject;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", localException, "getConfigExtraInfoJsonObject error", new Object[0]);
      }
    }
    AppMethodBeat.o(164080);
    return null;
  }
  
  private static String duy()
  {
    AppMethodBeat.i(164081);
    Object localObject = dux();
    if (localObject != null)
    {
      localObject = ((i)localObject).optString("package_name");
      AppMethodBeat.o(164081);
      return localObject;
    }
    AppMethodBeat.o(164081);
    return null;
  }
  
  private static String duz()
  {
    AppMethodBeat.i(164082);
    Object localObject = dux();
    if (localObject != null)
    {
      localObject = ((i)localObject).optString("schema");
      AppMethodBeat.o(164082);
      return localObject;
    }
    AppMethodBeat.o(164082);
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
    String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNH, "");
    AppMethodBeat.o(164069);
    return str;
  }
  
  private static boolean ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(164077);
    for (;;)
    {
      try
      {
        paramString1 = ak.getContext().getPackageManager().getPackageInfo(paramString1, 64);
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
        if (!bu.lX(paramString1, paramString2.toUpperCase()))
        {
          bool = bu.lX(paramString1, paramString2.toLowerCase());
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
        ae.printErrStackTrace("MicroMsg.MeetingLinkHelper", paramString1, "checkPackageInstalled Exception: %s", new Object[] { paramString1.getMessage() });
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      ae.i("MicroMsg.MeetingLinkHelper", "checkPackageInstalled result:%s", new Object[] { Boolean.valueOf(bool) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.b
 * JD-Core Version:    0.7.0.1
 */