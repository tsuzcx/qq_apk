package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;

public final class r
{
  private static void a(Context paramContext, final Intent paramIntent, final com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151781);
    ac.i("MicroMsg.ApplicationUtil", "installApp");
    if ((paramBoolean) && (Build.BRAND.equals("vivo")))
    {
      paramIntent.putExtra("installDir", true);
      ac.i("MicroMsg.ApplicationUtil", "is vivo, try to prevent the interception");
    }
    try
    {
      if ((Build.VERSION.SDK_INT >= 26) && (!paramContext.getPackageManager().canRequestPackageInstalls()))
      {
        ac.i("MicroMsg.ApplicationUtil", "request install apk permission");
        b.a(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + paramContext.getPackageName())), ai.getContext().getString(2131761885), ai.getContext().getString(2131760344), new com.tencent.mm.pluginsdk.permission.d()
        {
          public final void ND(int paramAnonymousInt)
          {
            AppMethodBeat.i(151777);
            ac.i("MicroMsg.ApplicationUtil", "onRequestPermissionsResult, resultCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == -1)
            {
              try
              {
                Context localContext = this.val$context;
                Object localObject = paramIntent;
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil$1", "onRequestPermissionsResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil$1", "onRequestPermissionsResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (parama == null) {
                  break label180;
                }
                parama.gk(true);
                AppMethodBeat.o(151777);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.ApplicationUtil", localException, "install app failed! %s", new Object[] { paramIntent });
                }
              }
            }
            else
            {
              ac.e("MicroMsg.ApplicationUtil", "no get!!!");
              Toast.makeText(ai.getContext(), 2131761620, 1).show();
              if (parama != null) {
                parama.gk(false);
              }
            }
            label180:
            AppMethodBeat.o(151777);
          }
        });
        AppMethodBeat.o(151781);
        return;
      }
      ac.i("MicroMsg.ApplicationUtil", "install directly");
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, locala.aeD(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/permission/InstallApkListener;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)locala.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/permission/InstallApkListener;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ApplicationUtil", paramContext, "install app failed! %s", new Object[] { paramIntent });
        if (parama != null) {
          parama.gk(false);
        }
      }
    }
    if (parama != null) {
      parama.gk(true);
    }
    AppMethodBeat.o(151781);
  }
  
  protected static void a(Context paramContext, Uri paramUri, com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151784);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    m.a(paramContext, localIntent, paramUri, "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    a(paramContext, localIntent, parama, paramBoolean);
    AppMethodBeat.o(151784);
  }
  
  protected static void a(Context paramContext, String paramString, com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151782);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    m.a(paramContext, localIntent, new e(paramString), "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    a(paramContext, localIntent, parama, paramBoolean);
    AppMethodBeat.o(151782);
  }
  
  public static String aGq(String paramString)
  {
    AppMethodBeat.i(151780);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString.toLowerCase());
    localStringBuffer.append("mMHc ItnStR");
    paramString = g.getMessageDigest(localStringBuffer.toString().getBytes());
    AppMethodBeat.o(151780);
    return paramString;
  }
  
  public static String aGr(String paramString)
  {
    AppMethodBeat.i(151789);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151789);
      return null;
    }
    Object localObject = ai.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      if (localObject == null)
      {
        paramString = new RuntimeException("info is null; ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(151789);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151789);
      return null;
    }
    ac.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", new Object[] { paramString, ((PackageInfo)localObject).packageName });
    paramString = ((PackageInfo)localObject).packageName;
    AppMethodBeat.o(151789);
    return paramString;
  }
  
  public static int aGs(String paramString)
  {
    AppMethodBeat.i(151790);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151790);
      return 0;
    }
    Object localObject = ai.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      if (localObject == null)
      {
        paramString = new RuntimeException("info is null; ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(151790);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151790);
      return 0;
    }
    ac.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", new Object[] { paramString, Integer.valueOf(((PackageInfo)localObject).versionCode) });
    int i = ((PackageInfo)localObject).versionCode;
    AppMethodBeat.o(151790);
    return i;
  }
  
  public static void b(Context paramContext, String paramString, com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151783);
    if (ai.cin())
    {
      a(paramContext, paramString, parama, paramBoolean);
      AppMethodBeat.o(151783);
      return;
    }
    h.a("com.tencent.mm", new IPCInstallApp.IPCInstallAppParam(1, paramString, null, paramBoolean), IPCInstallApp.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(151783);
  }
  
  public static boolean bL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151786);
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    localIntent.addFlags(268435456);
    if (getPackageInfo(paramContext, "com.android.vending") != null)
    {
      ac.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", new Object[] { paramString });
      localIntent.setPackage("com.android.vending");
    }
    for (;;)
    {
      try
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(151786);
        return true;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", new Object[] { paramString.getMessage() });
        try
        {
          paramString = new Intent("android.intent.action.VIEW", localUri);
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(151786);
          return true;
        }
        catch (Exception paramContext)
        {
          ac.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", new Object[] { paramContext.getMessage() });
          AppMethodBeat.o(151786);
        }
      }
      ac.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", new Object[] { paramString });
    }
    return false;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(151788);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
      AppMethodBeat.o(151788);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(151788);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ac.w("MicroMsg.ApplicationUtil", "app not installed, packageName = ".concat(String.valueOf(paramString)));
        paramContext = localObject;
      }
    }
  }
  
  public static void i(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(151785);
    if (ai.cin())
    {
      a(paramContext, paramUri, null, false);
      AppMethodBeat.o(151785);
      return;
    }
    h.a("com.tencent.mm", new IPCInstallApp.IPCInstallAppParam(2, "", paramUri, false), IPCInstallApp.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(151785);
  }
  
  public static boolean t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151787);
    if (getPackageInfo(paramContext, paramString) != null)
    {
      AppMethodBeat.o(151787);
      return true;
    }
    AppMethodBeat.o(151787);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.r
 * JD-Core Version:    0.7.0.1
 */