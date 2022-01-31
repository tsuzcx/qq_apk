package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;

public final class q
{
  private static void a(Context paramContext, Intent paramIntent, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(79352);
    ab.i("MicroMsg.ApplicationUtil", "installApp");
    if ((paramBoolean) && (Build.BRAND.equals("vivo")))
    {
      paramIntent.putExtra("installDir", true);
      ab.i("MicroMsg.ApplicationUtil", "is vivo, try to prevent the interception");
    }
    try
    {
      if ((Build.VERSION.SDK_INT >= 26) && (!paramContext.getPackageManager().canRequestPackageInstalls()))
      {
        ab.i("MicroMsg.ApplicationUtil", "request install apk permission");
        b.a(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + paramContext.getPackageName())), ah.getContext().getString(2131302083), ah.getContext().getString(2131300743), new q.1(paramContext, paramIntent, parama));
        AppMethodBeat.o(79352);
        return;
      }
      ab.i("MicroMsg.ApplicationUtil", "install directly");
      paramContext.startActivity(paramIntent);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ApplicationUtil", paramContext, "install app failed! %s", new Object[] { paramIntent });
        if (parama != null) {
          parama.eb(false);
        }
      }
    }
    if (parama != null) {
      parama.eb(true);
    }
    AppMethodBeat.o(79352);
  }
  
  public static void a(Context paramContext, Uri paramUri, a parama)
  {
    AppMethodBeat.i(79354);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    k.a(paramContext, localIntent, paramUri, "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    a(paramContext, localIntent, parama, false);
    AppMethodBeat.o(79354);
  }
  
  public static void a(Context paramContext, File paramFile, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(79353);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    k.a(paramContext, localIntent, paramFile, "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    a(paramContext, localIntent, parama, paramBoolean);
    AppMethodBeat.o(79353);
  }
  
  public static int alA(String paramString)
  {
    AppMethodBeat.i(79359);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79359);
      return 0;
    }
    Object localObject = ah.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      if (localObject == null)
      {
        paramString = new RuntimeException("info is null; ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(79359);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79359);
      return 0;
    }
    ab.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", new Object[] { paramString, Integer.valueOf(((PackageInfo)localObject).versionCode) });
    int i = ((PackageInfo)localObject).versionCode;
    AppMethodBeat.o(79359);
    return i;
  }
  
  public static String aly(String paramString)
  {
    AppMethodBeat.i(79351);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString.toLowerCase());
    localStringBuffer.append("mMHc ItnStR");
    paramString = g.w(localStringBuffer.toString().getBytes());
    AppMethodBeat.o(79351);
    return paramString;
  }
  
  public static String alz(String paramString)
  {
    AppMethodBeat.i(79358);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79358);
      return null;
    }
    Object localObject = ah.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      if (localObject == null)
      {
        paramString = new RuntimeException("info is null; ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(79358);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79358);
      return null;
    }
    ab.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", new Object[] { paramString, ((PackageInfo)localObject).packageName });
    paramString = ((PackageInfo)localObject).packageName;
    AppMethodBeat.o(79358);
    return paramString;
  }
  
  public static boolean bw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79355);
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    localIntent.addFlags(268435456);
    if (getPackageInfo(paramContext, "com.android.vending") != null)
    {
      ab.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", new Object[] { paramString });
      localIntent.setPackage("com.android.vending");
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        AppMethodBeat.o(79355);
        return true;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", new Object[] { paramString.getMessage() });
        try
        {
          paramString = new Intent("android.intent.action.VIEW", localUri);
          paramString.addFlags(268435456);
          paramContext.startActivity(paramString);
          AppMethodBeat.o(79355);
          return true;
        }
        catch (Exception paramContext)
        {
          ab.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", new Object[] { paramContext.getMessage() });
          AppMethodBeat.o(79355);
        }
      }
      ab.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", new Object[] { paramString });
    }
    return false;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(79357);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
      AppMethodBeat.o(79357);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(79357);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ab.w("MicroMsg.ApplicationUtil", "app not installed, packageName = ".concat(String.valueOf(paramString)));
        paramContext = localObject;
      }
    }
  }
  
  public static boolean u(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79356);
    if (getPackageInfo(paramContext, paramString) != null)
    {
      AppMethodBeat.o(79356);
      return true;
    }
    AppMethodBeat.o(79356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q
 * JD-Core Version:    0.7.0.1
 */