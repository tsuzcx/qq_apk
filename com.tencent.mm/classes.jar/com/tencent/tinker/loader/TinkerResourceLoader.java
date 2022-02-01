package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.lang.reflect.Field;
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
    catch (Throwable paramContext)
    {
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
        new StringBuilder("Failed to load resource file, path: ").append(localFile.getPath()).append(", expect md5: ").append(resPatchInfo.resArscMd5);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -24);
        return false;
      }
      new StringBuilder("verify resource file:").append(localFile.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
    }
    try
    {
      TinkerResourcePatcher.monkeyPatchExistingResources(paramTinkerApplication, paramString);
      new StringBuilder("monkeyPatchExistingResources resource file:").append(paramString).append(", use time: ").append(System.currentTimeMillis() - l);
      ResourceStateMonitor.tryStart(paramTinkerApplication);
      return true;
    }
    catch (Throwable paramString) {}
    try
    {
      SystemClassLoaderAdder.uninstallPatchDex(paramTinkerApplication.getClassLoader());
      label189:
      paramIntent.putExtra("intent_patch_exception", paramString);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -23);
      return false;
    }
    catch (Throwable paramTinkerApplication)
    {
      break label189;
    }
  }
  
  static class ResourceStateMonitor
  {
    private static boolean started = false;
    
    private static Handler fetchMHObject(Context paramContext)
    {
      paramContext = ShareReflectUtil.getActivityThread(paramContext, null);
      return (Handler)ShareReflectUtil.findField(paramContext, "mH").get(paramContext);
    }
    
    private static void interceptHandler(Handler paramHandler)
    {
      Field localField = ShareReflectUtil.findField(Handler.class, "mCallback");
      localField.set(paramHandler, new HackerCallback((Handler.Callback)localField.get(paramHandler), paramHandler.getClass()));
    }
    
    static void tryStart(Application paramApplication)
    {
      if ((Build.VERSION.SDK_INT < 26) || (started)) {
        return;
      }
      try
      {
        interceptHandler(fetchMHObject(paramApplication));
        started = true;
        return;
      }
      catch (Throwable paramApplication) {}
    }
    
    static class HackerCallback
      implements Handler.Callback
    {
      private final int APPLICATION_INFO_CHANGED;
      private Handler.Callback origin;
      
      HackerCallback(Handler.Callback paramCallback, Class paramClass)
      {
        this.origin = paramCallback;
        try
        {
          i = ShareReflectUtil.findField(paramClass, "APPLICATION_INFO_CHANGED").getInt(null);
          this.APPLICATION_INFO_CHANGED = i;
          return;
        }
        catch (Throwable paramCallback)
        {
          for (;;)
          {
            int i = 156;
          }
        }
      }
      
      private boolean hackMessage(Message paramMessage)
      {
        if (paramMessage.what == this.APPLICATION_INFO_CHANGED)
        {
          Process.killProcess(Process.myPid());
          return true;
        }
        return false;
      }
      
      public boolean handleMessage(Message paramMessage)
      {
        boolean bool = false;
        if (hackMessage(paramMessage)) {
          bool = true;
        }
        while (this.origin == null) {
          return bool;
        }
        return this.origin.handleMessage(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourceLoader
 * JD-Core Version:    0.7.0.1
 */