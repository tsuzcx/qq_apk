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
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
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
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles: tinker is disable, just return", new Object[0]);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -1);
      return;
    }
    if (ShareTinkerInternals.isInPatchProcess(paramTinkerApplication))
    {
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles: we don't load patch with :patch process itself, just return", new Object[0]);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -1);
      return;
    }
    Object localObject1 = SharePatchFileUtil.getPatchDirectory(paramTinkerApplication);
    if (localObject1 == null)
    {
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:getPatchDirectory == null", new Object[0]);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -2);
      return;
    }
    String str2 = ((File)localObject1).getAbsolutePath();
    if (!((File)localObject1).exists())
    {
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patch dir not exist:".concat(String.valueOf(str2)), new Object[0]);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -2);
      return;
    }
    File localFile1 = SharePatchFileUtil.getPatchInfoFile(str2);
    if (!localFile1.exists())
    {
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patch info not exist:" + localFile1.getAbsolutePath(), new Object[0]);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -3);
      return;
    }
    File localFile2 = SharePatchFileUtil.getPatchInfoLockFile(str2);
    this.patchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    if (this.patchInfo == null)
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -4);
      return;
    }
    boolean bool8 = this.patchInfo.isProtectedApp;
    paramIntent.putExtra("intent_is_protected_app", bool8);
    Object localObject3 = this.patchInfo.oldVersion;
    String str1 = this.patchInfo.newVersion;
    String str3 = this.patchInfo.oatDir;
    if ((localObject3 == null) || (str1 == null) || (str3 == null))
    {
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchInfoCorrupted", new Object[0]);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -4);
      return;
    }
    boolean bool3 = ShareTinkerInternals.isInMainProcess(paramTinkerApplication);
    boolean bool1 = this.patchInfo.isRemoveNewVersion;
    Object localObject2 = localObject3;
    localObject1 = str1;
    Object localObject4;
    if (bool3)
    {
      localObject4 = SharePatchFileUtil.getPatchVersionDirectory(str1);
      if (!bool1) {
        break label1609;
      }
      ShareTinkerLog.w("Tinker.TinkerLoader", "found clean patch mark and we are in main process, delete patch file now.", new Object[0]);
      if (localObject4 == null) {
        break label1609;
      }
      bool1 = ((String)localObject3).equals(str1);
      localObject1 = localObject3;
      if (bool1) {
        localObject1 = "";
      }
      this.patchInfo.oldVersion = ((String)localObject1);
      this.patchInfo.newVersion = ((String)localObject1);
      this.patchInfo.isRemoveNewVersion = false;
      SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2);
      SharePatchFileUtil.deleteDir(str2 + "/" + (String)localObject4);
      if (bool1)
      {
        ShareTinkerInternals.killProcessExceptMain(paramTinkerApplication);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -2);
        return;
      }
      localObject3 = localObject1;
      localObject2 = localObject1;
    }
    for (localObject1 = localObject3;; localObject1 = str1)
    {
      if (this.patchInfo.isRemoveInterpretOATDir)
      {
        ShareTinkerLog.i("Tinker.TinkerLoader", "tryLoadPatchFiles: isRemoveInterpretOATDir is true, try to delete interpret optimize files", new Object[0]);
        this.patchInfo.isRemoveInterpretOATDir = false;
        SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2);
        ShareTinkerInternals.killProcessExceptMain(paramTinkerApplication);
        localObject3 = str2 + "/" + (String)localObject4;
        SharePatchFileUtil.deleteDir((String)localObject3 + "/interpet");
      }
      paramIntent.putExtra("intent_patch_old_version", (String)localObject2);
      paramIntent.putExtra("intent_patch_new_version", (String)localObject1);
      if (!((String)localObject2).equals(localObject1)) {}
      for (int i = 1;; i = 0)
      {
        bool1 = str3.equals("changing");
        str1 = ShareTinkerInternals.getCurrentOatMode(paramTinkerApplication, str3);
        paramIntent.putExtra("intent_patch_oat_dir", str1);
        localObject3 = localObject2;
        if (i != 0)
        {
          localObject3 = localObject2;
          if (bool3) {
            localObject3 = localObject1;
          }
        }
        if (!ShareTinkerInternals.isNullOrNil((String)localObject3)) {
          break;
        }
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:version is blank, wait main process to restart", new Object[0]);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -5);
        return;
      }
      str3 = SharePatchFileUtil.getPatchVersionDirectory((String)localObject3);
      if (str3 == null)
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patchName is null", new Object[0]);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -6);
        return;
      }
      localObject2 = str2 + "/" + str3;
      localObject1 = new File((String)localObject2);
      if (!((File)localObject1).exists())
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchVersionDirectoryNotFound", new Object[0]);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -6);
        return;
      }
      localObject4 = SharePatchFileUtil.getPatchVersionFile((String)localObject3);
      if (localObject4 != null) {}
      for (localObject1 = new File(((File)localObject1).getAbsolutePath(), (String)localObject4); !SharePatchFileUtil.isLegalFile((File)localObject1); localObject1 = null)
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchVersionFileNotFound", new Object[0]);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -7);
        return;
      }
      localObject4 = new ShareSecurityCheck(paramTinkerApplication);
      int k = ShareTinkerInternals.checkTinkerPackage(paramTinkerApplication, j, (File)localObject1, (ShareSecurityCheck)localObject4);
      if (k != 0)
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkTinkerPackage", new Object[0]);
        paramIntent.putExtra("intent_patch_package_patch_check", k);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -8);
        return;
      }
      paramIntent.putExtra("intent_patch_package_config", ((ShareSecurityCheck)localObject4).getPackagePropertiesIfPresent());
      boolean bool4 = ShareTinkerInternals.isTinkerEnabledForDex(j);
      boolean bool5 = ShareTinkerInternals.isArkHotRuning();
      if ((!bool5) && (bool4) && (!TinkerDexLoader.checkComplete((String)localObject2, (ShareSecurityCheck)localObject4, str1, paramIntent)))
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:dex check fail", new Object[0]);
        return;
      }
      boolean bool6 = ShareTinkerInternals.isTinkerEnabledForArkHot(j);
      if ((bool5) && (bool6) && (!TinkerArkHotLoader.checkComplete((String)localObject2, (ShareSecurityCheck)localObject4, paramIntent)))
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:dex check fail", new Object[0]);
        return;
      }
      if ((ShareTinkerInternals.isTinkerEnabledForNativeLib(j)) && (!TinkerSoLoader.checkComplete((String)localObject2, (ShareSecurityCheck)localObject4, paramIntent)))
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:native lib check fail", new Object[0]);
        return;
      }
      boolean bool7 = ShareTinkerInternals.isTinkerEnabledForResource(j);
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:isEnabledForResource:".concat(String.valueOf(bool7)), new Object[0]);
      if ((bool7) && (!TinkerResourceLoader.checkComplete(paramTinkerApplication, (String)localObject2, (ShareSecurityCheck)localObject4, paramIntent)))
      {
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:resource check fail", new Object[0]);
        return;
      }
      if ((ShareTinkerInternals.isVmArt()) && (ShareTinkerInternals.isSystemOTA(this.patchInfo.fingerPrint)) && (Build.VERSION.SDK_INT >= 21) && (!ShareTinkerInternals.isAfterAndroidO())) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        paramIntent.putExtra("intent_patch_system_ota", bool2);
        if (bool3)
        {
          if (i != 0) {
            this.patchInfo.oldVersion = ((String)localObject3);
          }
          if (bool1)
          {
            this.patchInfo.oatDir = str1;
            this.patchInfo.isRemoveInterpretOATDir = true;
          }
        }
        if (checkSafeModeCount(paramTinkerApplication)) {
          break label1290;
        }
        if (!bool3) {
          break;
        }
        this.patchInfo.oldVersion = "";
        this.patchInfo.newVersion = "";
        this.patchInfo.isRemoveNewVersion = false;
        SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2);
        ShareTinkerInternals.killProcessExceptMain(paramTinkerApplication);
        SharePatchFileUtil.deleteDir(str2 + "/" + str3);
        paramIntent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
        ShareIntentUtil.setIntentReturnCode(paramIntent, -25);
        ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkSafeModeCount fail, patch was deleted.", new Object[0]);
        return;
      }
      ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkSafeModeCount fail, but we are not in main process, mark the patch to be deleted and continue load patch.", new Object[0]);
      ShareTinkerInternals.cleanPatch(paramTinkerApplication);
      label1290:
      if ((!bool5) && (bool4))
      {
        bool8 = TinkerDexLoader.loadTinkerJars(paramTinkerApplication, (String)localObject2, str1, paramIntent, bool2, bool8);
        if (!bool2) {
          break label1606;
        }
        this.patchInfo.fingerPrint = Build.FINGERPRINT;
        localObject3 = this.patchInfo;
        if (bool8) {}
        for (localObject1 = "interpet";; localObject1 = "odex")
        {
          ((SharePatchInfo)localObject3).oatDir = ((String)localObject1);
          bool1 = false;
          if (SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2)) {
            break;
          }
          ShareIntentUtil.setIntentReturnCode(paramIntent, -19);
          ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onReWritePatchInfoCorrupted", new Object[0]);
          return;
        }
        paramIntent.putExtra("intent_patch_oat_dir", this.patchInfo.oatDir);
      }
      label1606:
      for (;;)
      {
        if (!bool8)
        {
          ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadDexesFail", new Object[0]);
          return;
        }
        if ((bool5) && (bool6) && (!TinkerArkHotLoader.loadTinkerArkHot(paramTinkerApplication, (String)localObject2, paramIntent)))
        {
          ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadArkApkFail", new Object[0]);
          return;
        }
        if ((bool7) && (!TinkerResourceLoader.loadTinkerResources(paramTinkerApplication, (String)localObject2, paramIntent)))
        {
          ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadResourcesFail", new Object[0]);
          return;
        }
        if (((bool4) || (bool6)) && (bool7)) {
          ComponentHotplug.install(paramTinkerApplication, (ShareSecurityCheck)localObject4);
        }
        if (!AppInfoChangedBlocker.tryStart(paramTinkerApplication))
        {
          ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:AppInfoChangedBlocker install fail.", new Object[0]);
          ShareIntentUtil.setIntentReturnCode(paramIntent, -28);
          return;
        }
        if ((bool3) && ((i != 0) || (bool1)))
        {
          if (!SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, this.patchInfo, localFile2))
          {
            ShareIntentUtil.setIntentReturnCode(paramIntent, -19);
            ShareTinkerLog.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onReWritePatchInfoCorrupted", new Object[0]);
            return;
          }
          ShareTinkerInternals.killProcessExceptMain(paramTinkerApplication);
        }
        ShareIntentUtil.setIntentReturnCode(paramIntent, 0);
        ShareTinkerLog.i("Tinker.TinkerLoader", "tryLoadPatchFiles: load end, ok!", new Object[0]);
        return;
      }
      label1609:
      localObject2 = localObject3;
    }
  }
  
  public Intent tryLoad(TinkerApplication paramTinkerApplication)
  {
    ShareTinkerLog.d("Tinker.TinkerLoader", "tryLoad test test", new Object[0]);
    Intent localIntent = new Intent();
    long l = SystemClock.elapsedRealtime();
    tryLoadPatchFilesInternal(paramTinkerApplication, localIntent);
    ShareIntentUtil.setIntentPatchCostTime(localIntent, SystemClock.elapsedRealtime() - l);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerLoader
 * JD-Core Version:    0.7.0.1
 */