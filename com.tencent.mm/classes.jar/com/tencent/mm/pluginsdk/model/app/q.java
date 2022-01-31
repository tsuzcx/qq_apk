package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
{
  public static String Wb(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = ae.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      if (localObject == null) {
        throw new RuntimeException("info is null; " + paramString);
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      return null;
    }
    y.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", new Object[] { paramString, ((PackageInfo)localObject).packageName });
    paramString = ((PackageInfo)localObject).packageName;
    return paramString;
  }
  
  public static int Wc(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    Object localObject = ae.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageArchiveInfo(paramString, 0);
      if (localObject == null) {
        throw new RuntimeException("info is null; " + paramString);
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", new Object[] { paramString.getMessage() });
      return 0;
    }
    y.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", new Object[] { paramString, Integer.valueOf(((PackageInfo)localObject).versionCode) });
    int i = ((PackageInfo)localObject).versionCode;
    return i;
  }
  
  public static boolean bk(Context paramContext, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    localIntent.addFlags(268435456);
    if (getPackageInfo(paramContext, "com.android.vending") != null)
    {
      y.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", new Object[] { paramString });
      localIntent.setPackage("com.android.vending");
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", new Object[] { paramString.getMessage() });
        try
        {
          paramString = new Intent("android.intent.action.VIEW", localUri);
          paramString.addFlags(268435456);
          paramContext.startActivity(paramString);
          return true;
        }
        catch (Exception paramContext)
        {
          y.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", new Object[] { paramContext.getMessage() });
        }
      }
      y.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", new Object[] { paramString });
    }
    return false;
  }
  
  public static boolean g(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramUri, "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.ApplicationUtil", "install app failed: " + paramUri.toString() + ", ex = " + paramContext.getMessage());
    }
    return false;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if (paramString.length() == 0)
    {
      y.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.w("MicroMsg.ApplicationUtil", "app not installed, packageName = " + paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q
 * JD-Core Version:    0.7.0.1
 */