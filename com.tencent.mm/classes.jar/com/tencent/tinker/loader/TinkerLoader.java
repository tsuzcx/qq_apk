package com.tencent.tinker.loader;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader
  extends AbstractTinkerLoader
{
  private static final String TAG = "Tinker.TinkerLoader";
  private SharePatchInfo patchInfo;
  
  private boolean checkSafeModeCount(TinkerApplication paramTinkerApplication)
  {
    int i = ShareTinkerInternals.getSafeModeCount(paramTinkerApplication);
    if (i >= 2)
    {
      ShareTinkerInternals.setSafeModeCount(paramTinkerApplication, 0);
      return false;
    }
    paramTinkerApplication.setUseSafeMode(true);
    ShareTinkerInternals.setSafeModeCount(paramTinkerApplication, i + 1);
    return true;
  }
  
  private void tryLoadPatchFilesInternal(TinkerApplication paramTinkerApplication, Intent paramIntent)
  {
    int j = paramTinkerApplication.getTinkerFlags();
    if (!ShareTinkerInternals.isTinkerEnabled(j))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -1);
      return;
    }
    if (ShareTinkerInternals.isInPatchProcess(paramTinkerApplication))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -1);
      return;
    }
    Object localObject1 = SharePatchFileUtil.getPatchDirectory(paramTinkerApplication);
    if (localObject1 == null)
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -2);
      return;
    }
    Object localObject4 = ((File)localObject1).getAbsolutePath();
    if (!((File)localObject1).exists())
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -2);
      return;
    }
    File localFile1 = SharePatchFileUtil.getPatchInfoFile((String)localObject4);
    if (!localFile1.exists())
    {
      new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(localFile1.getAbsolutePath());
      ShareIntentUtil.setIntentReturnCode(paramIntent, -3);
      return;
    }
    File localFile2 = SharePatchFileUtil.getPatchInfoLockFile((String)localObject4);
    this.patchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    if (this.patchInfo == null)
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -4);
      return;
    }
    boolean bool3 = this.patchInfo.isProtectedApp;
    paramIntent.putExtra("intent_is_protected_app", bool3);
    localObject1 = this.patchInfo.oldVersion;
    Object localObject3 = this.patchInfo.newVersion;
    String str = this.patchInfo.oatDir;
    if ((localObject1 == null) || (localObject3 == null) || (str == null))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -4);
      return;
    }
    boolean bool2 = ShareTinkerInternals.isInMainProcess(paramTinkerApplication);
    boolean bool1 = this.patchInfo.isRemoveNewVersion;
    Object localObject2;
    if ((bool2) && (bool1))
    {
      localObject2 = SharePatchFileUtil.getPatchVersionDirectory((String)localObject3);
      if (localObject2 != null)
      {
        bool1 = ((String)localObject1).equals(localObject3);
        if (bool1) {
          localObject1 = "";
        }
        this.patchInfo.oldVersion = ((String)localObject1);
        this.patchInfo.newVersion = ((String)localObject1);
        this.patchInfo.isRemoveNewVersion = false;
        SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2);
        SharePatchFileUtil.deleteDir((String)localObject4 + "/" + (String)localObject2);
        if (bool1)
        {
          ShareTinkerInternals.killProcessExceptMain(paramTinkerApplication);
          ShareIntentUtil.setIntentReturnCode(paramIntent, -2);
          return;
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
      }
    }
    for (localObject1 = localObject3;; localObject1 = localObject3)
    {
      paramIntent.putExtra("intent_patch_old_version", (String)localObject2);
      paramIntent.putExtra("intent_patch_new_version", (String)localObject1);
      if (!((String)localObject2).equals(localObject1)) {}
      boolean bool8;
      for (int i = 1;; i = 0)
      {
        bool8 = str.equals("changing");
        str = ShareTinkerInternals.getCurrentOatMode(paramTinkerApplication, str);
        paramIntent.putExtra("intent_patch_oat_dir", str);
        localObject3 = localObject2;
        if (i != 0)
        {
          localObject3 = localObject2;
          if (bool2) {
            localObject3 = localObject1;
          }
        }
        if (!ShareTinkerInternals.isNullOrNil((String)localObject3)) {
          break;
        }
        ShareIntentUtil.setIntentReturnCode(paramIntent, -5);
        return;
      }
      localObject1 = SharePatchFileUtil.getPatchVersionDirectory((String)localObject3);
      if (localObject1 == null)
      {
        ShareIntentUtil.setIntentReturnCode(paramIntent, -6);
        return;
      }
      localObject2 = (String)localObject4 + "/" + (String)localObject1;
      localObject1 = new File((String)localObject2);
      if (!((File)localObject1).exists())
      {
        ShareIntentUtil.setIntentReturnCode(paramIntent, -6);
        return;
      }
      localObject4 = SharePatchFileUtil.getPatchVersionFile((String)localObject3);
      if (localObject4 != null) {}
      for (localObject1 = new File(((File)localObject1).getAbsolutePath(), (String)localObject4); !SharePatchFileUtil.isLegalFile((File)localObject1); localObject1 = null)
      {
        ShareIntentUtil.setIntentReturnCode(paramIntent, -7);
        return;
      }
      localObject4 = new ShareSecurityCheck(paramTinkerApplication);
      int k = ShareTinkerInternals.checkTinkerPackage(paramTinkerApplication, j, (File)localObject1, (ShareSecurityCheck)localObject4);
      if (k != 0)
      {
        paramIntent.putExtra("intent_patch_package_patch_check", k);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -8);
        return;
      }
      paramIntent.putExtra("intent_patch_package_config", ((ShareSecurityCheck)localObject4).getPackagePropertiesIfPresent());
      boolean bool4 = ShareTinkerInternals.isTinkerEnabledForDex(j);
      boolean bool5 = ShareTinkerInternals.isArkHotRuning();
      if ((!bool5) && (bool4) && (!TinkerDexLoader.checkComplete((String)localObject2, (ShareSecurityCheck)localObject4, str, paramIntent))) {
        break;
      }
      boolean bool6 = ShareTinkerInternals.isTinkerEnabledForArkHot(j);
      if (((bool5) && (bool6) && (!TinkerArkHotLoader.checkComplete((String)localObject2, (ShareSecurityCheck)localObject4, paramIntent))) || ((ShareTinkerInternals.isTinkerEnabledForNativeLib(j)) && (!TinkerSoLoader.checkComplete((String)localObject2, (ShareSecurityCheck)localObject4, paramIntent)))) {
        break;
      }
      boolean bool7 = ShareTinkerInternals.isTinkerEnabledForResource(j);
      if ((bool7) && (!TinkerResourceLoader.checkComplete(paramTinkerApplication, (String)localObject2, (ShareSecurityCheck)localObject4, paramIntent))) {
        break;
      }
      if ((ShareTinkerInternals.isVmArt()) && (ShareTinkerInternals.isSystemOTA(this.patchInfo.fingerPrint)) && (Build.VERSION.SDK_INT >= 21) && (!ShareTinkerInternals.isAfterAndroidO())) {}
      for (bool1 = true;; bool1 = false)
      {
        paramIntent.putExtra("intent_patch_system_ota", bool1);
        if (bool2)
        {
          if (i != 0) {
            this.patchInfo.oldVersion = ((String)localObject3);
          }
          if (bool8)
          {
            this.patchInfo.oatDir = str;
            SharePatchFileUtil.deleteDir((String)localObject2 + "/interpet");
          }
        }
        if (checkSafeModeCount(paramTinkerApplication)) {
          break;
        }
        paramIntent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
        ShareIntentUtil.setIntentReturnCode(paramIntent, -25);
        return;
      }
      if ((!bool5) && (bool4))
      {
        bool3 = TinkerDexLoader.loadTinkerJars(paramTinkerApplication, (String)localObject2, str, paramIntent, bool1, bool3);
        if (bool1)
        {
          this.patchInfo.fingerPrint = Build.FINGERPRINT;
          localObject3 = this.patchInfo;
          if (bool3) {}
          for (localObject1 = "interpet";; localObject1 = "odex")
          {
            ((SharePatchInfo)localObject3).oatDir = ((String)localObject1);
            if (SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2)) {
              break;
            }
            ShareIntentUtil.setIntentReturnCode(paramIntent, -19);
            return;
          }
          paramIntent.putExtra("intent_patch_oat_dir", this.patchInfo.oatDir);
        }
        if (!bool3) {
          break;
        }
      }
      if (((bool5) && (bool6) && (!TinkerArkHotLoader.loadTinkerArkHot(paramTinkerApplication, (String)localObject2, paramIntent))) || ((bool7) && (!TinkerResourceLoader.loadTinkerResources(paramTinkerApplication, (String)localObject2, paramIntent)))) {
        break;
      }
      if (((bool4) || (bool6)) && (bool7)) {
        ComponentHotplug.install(paramTinkerApplication, (ShareSecurityCheck)localObject4);
      }
      if ((bool2) && (i != 0))
      {
        if (!SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2))
        {
          ShareIntentUtil.setIntentReturnCode(paramIntent, -19);
          return;
        }
        ShareTinkerInternals.killProcessExceptMain(paramTinkerApplication);
      }
      ShareIntentUtil.setIntentReturnCode(paramIntent, 0);
      return;
      localObject2 = localObject1;
    }
  }
  
  public Intent tryLoad(TinkerApplication paramTinkerApplication)
  {
    Intent localIntent = new Intent();
    long l = SystemClock.elapsedRealtime();
    tryLoadPatchFilesInternal(paramTinkerApplication, localIntent);
    ShareIntentUtil.setIntentPatchCostTime(localIntent, SystemClock.elapsedRealtime() - l);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerLoader
 * JD-Core Version:    0.7.0.1
 */