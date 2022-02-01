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
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class v
{
  private static void a(Context paramContext, final Intent paramIntent, final com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151781);
    Log.i("MicroMsg.ApplicationUtil", "installApp");
    if ((paramBoolean) && (Build.BRAND.equals("vivo")))
    {
      paramIntent.putExtra("installDir", true);
      Log.i("MicroMsg.ApplicationUtil", "is vivo, try to prevent the interception");
    }
    try
    {
      if ((Build.VERSION.SDK_INT >= 26) && (!paramContext.getPackageManager().canRequestPackageInstalls()))
      {
        Log.i("MicroMsg.ApplicationUtil", "request install apk permission");
        b.a(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + paramContext.getPackageName())), MMApplicationContext.getContext().getString(c.h.permission_tips_title), MMApplicationContext.getContext().getString(c.h.install_unknow_app_nead_settings_permission), new d()
        {
          public final void aiW(int paramAnonymousInt)
          {
            AppMethodBeat.i(151777);
            Log.i("MicroMsg.ApplicationUtil", "onRequestPermissionsResult, resultCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == -1)
            {
              try
              {
                Context localContext = v.this;
                Object localObject = paramIntent;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil$1", "onRequestPermissionsResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil$1", "onRequestPermissionsResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (parama == null) {
                  break label181;
                }
                parama.iZ(true);
                AppMethodBeat.o(151777);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.ApplicationUtil", localException, "install app failed! %s", new Object[] { paramIntent });
                }
              }
            }
            else
            {
              Log.e("MicroMsg.ApplicationUtil", "no get!!!");
              Toast.makeText(MMApplicationContext.getContext(), c.h.no_install_unknow_app_permission, 1).show();
              if (parama != null) {
                parama.iZ(false);
              }
            }
            label181:
            AppMethodBeat.o(151777);
          }
        });
        AppMethodBeat.o(151781);
        return;
      }
      Log.i("MicroMsg.ApplicationUtil", "install directly");
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, locala.aYi(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/permission/InstallApkListener;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/permission/InstallApkListener;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ApplicationUtil", paramContext, "install app failed! %s", new Object[] { paramIntent });
        if (parama != null) {
          parama.iZ(false);
        }
      }
    }
    if (parama != null) {
      parama.iZ(true);
    }
    AppMethodBeat.o(151781);
  }
  
  protected static void a(Context paramContext, Uri paramUri, com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151784);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, paramUri, "application/vnd.android.package-archive", false);
    localIntent.addFlags(268435456);
    a(paramContext, localIntent, parama, paramBoolean);
    AppMethodBeat.o(151784);
  }
  
  protected static void a(Context paramContext, String paramString, com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151782);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    FileProviderHelper.setIntentDataAndType(paramContext, localIntent, new u(paramString), "application/vnd.android.package-archive", false);
    localIntent.addFlags(268435456);
    a(paramContext, localIntent, parama, paramBoolean);
    AppMethodBeat.o(151782);
  }
  
  public static void b(Context paramContext, String paramString, com.tencent.mm.pluginsdk.permission.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(151783);
    if (MMApplicationContext.isMainProcess())
    {
      a(paramContext, paramString, parama, paramBoolean);
      AppMethodBeat.o(151783);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, new IPCInstallApp.IPCInstallAppParam(1, paramString, null, paramBoolean), IPCInstallApp.class, new f() {});
    AppMethodBeat.o(151783);
  }
  
  public static String bpX(String paramString)
  {
    AppMethodBeat.i(151780);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString.toLowerCase());
    localStringBuffer.append("mMHc ItnStR");
    paramString = g.getMessageDigest(localStringBuffer.toString().getBytes());
    AppMethodBeat.o(151780);
    return paramString;
  }
  
  public static String bpY(String paramString)
  {
    AppMethodBeat.i(151789);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151789);
      return null;
    }
    Object localObject = MMApplicationContext.getContext().getPackageManager();
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
      Log.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151789);
      return null;
    }
    Log.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", new Object[] { paramString, ((PackageInfo)localObject).packageName });
    paramString = ((PackageInfo)localObject).packageName;
    AppMethodBeat.o(151789);
    return paramString;
  }
  
  public static int bpZ(String paramString)
  {
    AppMethodBeat.i(151790);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151790);
      return 0;
    }
    Object localObject = MMApplicationContext.getContext().getPackageManager();
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
      Log.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151790);
      return 0;
    }
    Log.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", new Object[] { paramString, Integer.valueOf(((PackageInfo)localObject).versionCode) });
    int i = ((PackageInfo)localObject).versionCode;
    AppMethodBeat.o(151790);
    return i;
  }
  
  public static boolean cH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151786);
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    localIntent.addFlags(268435456);
    if (getPackageInfo(paramContext, "com.android.vending") != null)
    {
      Log.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", new Object[] { paramString });
      localIntent.setPackage("com.android.vending");
    }
    for (;;)
    {
      try
      {
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(151786);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", new Object[] { paramString.getMessage() });
        try
        {
          paramString = new Intent("android.intent.action.VIEW", localUri);
          paramString.addFlags(268435456);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/model/app/ApplicationUtil", "installAppWithGP", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(151786);
          return true;
        }
        catch (Exception paramContext)
        {
          Log.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", new Object[] { paramContext.getMessage() });
          AppMethodBeat.o(151786);
        }
      }
      Log.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", new Object[] { paramString });
    }
    return false;
  }
  
  public static void f(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(151785);
    if (MMApplicationContext.isMainProcess())
    {
      a(paramContext, paramUri, null, false);
      AppMethodBeat.o(151785);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, new IPCInstallApp.IPCInstallAppParam(2, "", paramUri, false), IPCInstallApp.class, new f() {});
    AppMethodBeat.o(151785);
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(151788);
    if (paramString.length() == 0)
    {
      Log.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
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
        Log.w("MicroMsg.ApplicationUtil", "app not installed, packageName = ".concat(String.valueOf(paramString)));
        paramContext = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.v
 * JD-Core Version:    0.7.0.1
 */