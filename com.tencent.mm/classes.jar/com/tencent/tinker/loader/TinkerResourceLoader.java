package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.HashMap;

public class TinkerResourceLoader
{
  private static ShareResPatchInfo wXi = new ShareResPatchInfo();
  
  public static boolean a(Context paramContext, String paramString, ShareSecurityCheck paramShareSecurityCheck, Intent paramIntent)
  {
    paramShareSecurityCheck = (String)paramShareSecurityCheck.wZE.get("assets/res_meta.txt");
    if (paramShareSecurityCheck == null) {
      return true;
    }
    ShareResPatchInfo.b(paramShareSecurityCheck, wXi);
    if (wXi.wZv == null) {
      return true;
    }
    if (!ShareResPatchInfo.a(wXi))
    {
      paramIntent.putExtra("intent_patch_package_patch_check", -8);
      ShareIntentUtil.a(paramIntent, -8);
      return false;
    }
    paramString = paramString + "/res/";
    paramShareSecurityCheck = new File(paramString);
    if ((!paramShareSecurityCheck.exists()) || (!paramShareSecurityCheck.isDirectory()))
    {
      ShareIntentUtil.a(paramIntent, -21);
      return false;
    }
    if (!SharePatchFileUtil.ae(new File(paramString + "resources.apk")))
    {
      ShareIntentUtil.a(paramIntent, -22);
      return false;
    }
    try
    {
      TinkerResourcePatcher.hT(paramContext);
      return true;
    }
    catch (Throwable paramContext)
    {
      paramIntent.putExtra("intent_patch_exception", paramContext);
      ShareIntentUtil.a(paramIntent, -23);
    }
    return false;
  }
  
  public static boolean a(TinkerApplication paramTinkerApplication, String paramString, Intent paramIntent)
  {
    if ((wXi == null) || (wXi.wZv == null)) {
      return true;
    }
    paramString = paramString + "/res/resources.apk";
    File localFile = new File(paramString);
    long l = System.currentTimeMillis();
    if (paramTinkerApplication.isTinkerLoadVerifyFlag())
    {
      if (!SharePatchFileUtil.h(localFile, wXi.wZv))
      {
        new StringBuilder("Failed to load resource file, path: ").append(localFile.getPath()).append(", expect md5: ").append(wXi.wZv);
        ShareIntentUtil.a(paramIntent, -24);
        return false;
      }
      new StringBuilder("verify resource file:").append(localFile.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
    }
    try
    {
      TinkerResourcePatcher.bS(paramTinkerApplication, paramString);
      new StringBuilder("monkeyPatchExistingResources resource file:").append(paramString).append(", use time: ").append(System.currentTimeMillis() - l);
      return true;
    }
    catch (Throwable paramString) {}
    try
    {
      SystemClassLoaderAdder.a(paramTinkerApplication.getClassLoader());
      label185:
      paramIntent.putExtra("intent_patch_exception", paramString);
      ShareIntentUtil.a(paramIntent, -23);
      return false;
    }
    catch (Throwable paramTinkerApplication)
    {
      break label185;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourceLoader
 * JD-Core Version:    0.7.0.1
 */