package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.a.f;
import com.tencent.tinker.loader.a.i;
import com.tencent.tinker.loader.a.j;
import com.tencent.tinker.loader.app.TinkerApplication;
import java.io.File;
import java.util.HashMap;

public class TinkerResourceLoader
{
  private static i akI = new i();
  
  public static boolean a(Context paramContext, String paramString, j paramj, Intent paramIntent)
  {
    Object localObject = (String)paramj.ol().get("assets/res_meta.txt");
    if (localObject == null) {
      return true;
    }
    paramj = akI;
    if ((localObject == null) || (((String)localObject).length() == 0)) {}
    while (akI.amm == null)
    {
      return true;
      String str = localObject.split("\n")[0];
      if ((str == null) || (str.length() <= 0)) {
        throw new TinkerRuntimeException("res meta Corrupted:" + (String)localObject);
      }
      localObject = str.split(",", 3);
      paramj.aml = localObject[1];
      paramj.amm = localObject[2];
    }
    paramj = akI;
    int i;
    if (paramj == null) {
      i = 0;
    }
    while (i == 0)
    {
      paramIntent.putExtra("intent_patch_package_patch_check", -8);
      e.a(paramIntent, -8);
      return false;
      paramj = paramj.amm;
      if ((paramj == null) || (paramj.length() != 32)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    paramString = paramString + "/res/";
    paramj = new File(paramString);
    if ((!paramj.exists()) || (!paramj.isDirectory()))
    {
      e.a(paramIntent, -21);
      return false;
    }
    if (!f.j(new File(paramString + "resources.apk")))
    {
      e.a(paramIntent, -22);
      return false;
    }
    try
    {
      TinkerResourcePatcher.I(paramContext);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.e("Tinker.ResourceLoader", "resource hook check failed.", paramContext);
      paramIntent.putExtra("intent_patch_exception", paramContext);
      e.a(paramIntent, -23);
    }
    return false;
  }
  
  public static boolean a(TinkerApplication paramTinkerApplication, String paramString, Intent paramIntent)
  {
    if ((akI == null) || (akI.amm == null)) {
      return true;
    }
    paramString = paramString + "/res/resources.apk";
    File localFile = new File(paramString);
    long l = System.currentTimeMillis();
    if (paramTinkerApplication.isTinkerLoadVerifyFlag())
    {
      if (!f.b(localFile, akI.amm))
      {
        Log.e("Tinker.ResourceLoader", "Failed to load resource file, path: " + localFile.getPath() + ", expect md5: " + akI.amm);
        e.a(paramIntent, -24);
        return false;
      }
      Log.i("Tinker.ResourceLoader", "verify resource file:" + localFile.getPath() + " md5, use time: " + (System.currentTimeMillis() - l));
    }
    try
    {
      TinkerResourcePatcher.j(paramTinkerApplication, paramString);
      Log.i("Tinker.ResourceLoader", "monkeyPatchExistingResources resource file:" + paramString + ", use time: " + (System.currentTimeMillis() - l));
      return true;
    }
    catch (Throwable paramString)
    {
      Log.e("Tinker.ResourceLoader", "install resources failed");
    }
    try
    {
      SystemClassLoaderAdder.a(paramTinkerApplication.getClassLoader());
      paramIntent.putExtra("intent_patch_exception", paramString);
      e.a(paramIntent, -23);
      return false;
    }
    catch (Throwable paramTinkerApplication)
    {
      for (;;)
      {
        Log.e("Tinker.ResourceLoader", "uninstallPatchDex failed", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourceLoader
 * JD-Core Version:    0.7.0.1
 */