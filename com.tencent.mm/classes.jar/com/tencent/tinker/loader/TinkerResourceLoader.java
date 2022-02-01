package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.HashMap;

public class TinkerResourceLoader
{
  protected static final String RESOURCE_FILE = "resources.apk";
  protected static final String RESOURCE_META_FILE = "assets/res_meta.txt";
  protected static final String RESOURCE_PATH = "res";
  private static final String TAG = "Tinker.ResourceLoader";
  private static ShareResPatchInfo resPatchInfo = new ShareResPatchInfo();
  
  public static boolean checkComplete(Context paramContext, String paramString, ShareSecurityCheck paramShareSecurityCheck, Intent paramIntent)
  {
    paramShareSecurityCheck = (String)paramShareSecurityCheck.getMetaContentMap().get("assets/res_meta.txt");
    if (paramShareSecurityCheck == null) {
      return true;
    }
    ShareResPatchInfo.parseResPatchInfoFirstLine(paramShareSecurityCheck, resPatchInfo);
    if (resPatchInfo.resArscMd5 == null) {
      return true;
    }
    if (!ShareResPatchInfo.checkResPatchInfo(resPatchInfo))
    {
      paramIntent.putExtra("intent_patch_package_patch_check", -8);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -8);
      return false;
    }
    paramString = paramString + "/res/";
    paramShareSecurityCheck = new File(paramString);
    if ((!paramShareSecurityCheck.exists()) || (!paramShareSecurityCheck.isDirectory()))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -21);
      return false;
    }
    if (!SharePatchFileUtil.isLegalFile(new File(paramString + "resources.apk")))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -22);
      return false;
    }
    try
    {
      TinkerResourcePatcher.isResourceCanPatch(paramContext);
      return true;
    }
    finally
    {
      ShareTinkerLog.e("Tinker.ResourceLoader", "resource hook check failed.", new Object[] { paramContext });
      paramIntent.putExtra("intent_patch_exception", paramContext);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -23);
    }
    return false;
  }
  
  public static boolean loadTinkerResources(TinkerApplication paramTinkerApplication, String paramString, Intent paramIntent)
  {
    if ((resPatchInfo == null) || (resPatchInfo.resArscMd5 == null)) {
      return true;
    }
    paramString = paramString + "/res/resources.apk";
    File localFile = new File(paramString);
    long l = System.currentTimeMillis();
    if (paramTinkerApplication.isTinkerLoadVerifyFlag())
    {
      if (!SharePatchFileUtil.checkResourceArscMd5(localFile, resPatchInfo.resArscMd5))
      {
        ShareTinkerLog.e("Tinker.ResourceLoader", "Failed to load resource file, path: " + localFile.getPath() + ", expect md5: " + resPatchInfo.resArscMd5, new Object[0]);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -24);
        return false;
      }
      ShareTinkerLog.i("Tinker.ResourceLoader", "verify resource file:" + localFile.getPath() + " md5, use time: " + (System.currentTimeMillis() - l), new Object[0]);
    }
    try
    {
      TinkerResourcePatcher.monkeyPatchExistingResources(paramTinkerApplication, paramString);
      ShareTinkerLog.i("Tinker.ResourceLoader", "monkeyPatchExistingResources resource file:" + paramString + ", use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return true;
    }
    finally
    {
      ShareTinkerLog.e("Tinker.ResourceLoader", "install resources failed", new Object[0]);
    }
    try
    {
      SystemClassLoaderAdder.uninstallPatchDex(paramTinkerApplication.getClassLoader());
      paramIntent.putExtra("intent_patch_exception", paramString);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -23);
      return false;
    }
    finally
    {
      for (;;)
      {
        ShareTinkerLog.e("Tinker.ResourceLoader", "uninstallPatchDex failed", new Object[] { paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourceLoader
 * JD-Core Version:    0.7.0.1
 */