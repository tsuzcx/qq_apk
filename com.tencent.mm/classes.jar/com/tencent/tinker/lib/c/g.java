package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.util.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends a
{
  public final boolean a(Context paramContext, String paramString, com.tencent.tinker.lib.service.a parama)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lk(paramContext);
    File localFile1 = new File(paramString);
    if ((!ShareTinkerInternals.isTinkerEnabled(locala.tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences(paramContext)))
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
      return false;
    }
    if (!SharePatchFileUtil.isLegalFile(localFile1))
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
      return false;
    }
    ShareSecurityCheck localShareSecurityCheck = new ShareSecurityCheck(paramContext);
    int i = ShareTinkerInternals.checkTinkerPackage(paramContext, locala.tinkerFlags, localFile1, localShareSecurityCheck);
    if (i != 0)
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
      locala.MgW.e(localFile1, i);
      return false;
    }
    String str = SharePatchFileUtil.getMD5(localFile1);
    if (str == null)
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
      return false;
    }
    parama.MgN = str;
    ShareTinkerLog.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", new Object[] { str });
    Object localObject1 = locala.MgT.getAbsolutePath();
    File localFile2 = SharePatchFileUtil.getPatchInfoLockFile((String)localObject1);
    File localFile3 = SharePatchFileUtil.getPatchInfoFile((String)localObject1);
    paramString = localShareSecurityCheck.getPackagePropertiesIfPresent();
    if (paramString == null)
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch packageProperties is null, do we process a valid patch apk ?", new Object[0]);
      return false;
    }
    paramString = (String)paramString.get("is_protected_app");
    if ((paramString != null) && (!paramString.isEmpty()) && (!"0".equals(paramString))) {}
    Object localObject2;
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = SharePatchInfo.readAndCheckPropertyWithLock(localFile3, localFile2);
      if (localObject2 == null) {
        break label676;
      }
      if ((((SharePatchInfo)localObject2).oldVersion != null) && (((SharePatchInfo)localObject2).newVersion != null) && (((SharePatchInfo)localObject2).oatDir != null)) {
        break;
      }
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
      locala.MgW.b(localFile1, ((SharePatchInfo)localObject2).oldVersion, ((SharePatchInfo)localObject2).newVersion);
      return false;
    }
    if (!SharePatchFileUtil.checkIfMd5Valid(str))
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", new Object[] { str });
      locala.MgW.a(localFile1, (SharePatchInfo)localObject2, str);
      return false;
    }
    boolean bool2 = ((SharePatchInfo)localObject2).oatDir.equals("interpet");
    if ((!bool2) && (!ShareTinkerInternals.isNullOrNil(((SharePatchInfo)localObject2).newVersion)) && (((SharePatchInfo)localObject2).newVersion.equals(str)) && (!((SharePatchInfo)localObject2).isRemoveNewVersion))
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "patch already applied, md5: %s", new Object[] { str });
      c.lp(paramContext).aZS(str);
      return true;
    }
    if (bool2) {
      paramString = "changing";
    }
    label676:
    for (paramString = new SharePatchInfo(((SharePatchInfo)localObject2).oldVersion, str, bool1, false, Build.FINGERPRINT, paramString);; paramString = new SharePatchInfo("", str, bool1, false, Build.FINGERPRINT, "odex"))
    {
      localObject2 = SharePatchFileUtil.getPatchVersionDirectory(str);
      localObject2 = (String)localObject1 + "/" + (String)localObject2;
      ShareTinkerLog.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", new Object[] { localObject2 });
      localObject1 = new File((String)localObject2 + "/" + SharePatchFileUtil.getPatchVersionFile(str));
      try
      {
        if (!str.equals(SharePatchFileUtil.getMD5((File)localObject1)))
        {
          SharePatchFileUtil.copyFileUsingStream(localFile1, (File)localObject1);
          ShareTinkerLog.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", new Object[] { localFile1.getAbsolutePath(), Long.valueOf(localFile1.length()), ((File)localObject1).getAbsolutePath(), Long.valueOf(((File)localObject1).length()) });
        }
        if (e.a(locala, localShareSecurityCheck, paramContext, (String)localObject2, (File)localObject1, parama)) {
          break label749;
        }
        ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
        return false;
      }
      catch (IOException paramContext)
      {
        ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", new Object[] { localFile1.getPath(), ((File)localObject1).getPath() });
        locala.MgW.a(localFile1, (File)localObject1, localFile1.getName(), 1);
        return false;
      }
      paramString = ((SharePatchInfo)localObject2).oatDir;
      break;
    }
    label749:
    b.a(localShareSecurityCheck, paramContext, (String)localObject2, (File)localObject1);
    if (!ShareTinkerInternals.isTinkerEnabledForNativeLib(locala.tinkerFlags))
    {
      ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
      bool1 = true;
    }
    long l;
    while (!bool1)
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
      return false;
      parama = (String)localShareSecurityCheck.getMetaContentMap().get("assets/so_meta.txt");
      if (parama == null)
      {
        ShareTinkerLog.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
        bool1 = true;
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        bool1 = d.a(paramContext, (String)localObject2 + "/lib/", parama, (File)localObject1);
        ShareTinkerLog.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(SystemClock.elapsedRealtime() - l) });
      }
    }
    if (!ShareTinkerInternals.isTinkerEnabledForResource(locala.tinkerFlags))
    {
      ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
      bool1 = true;
    }
    while (!bool1)
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
      return false;
      parama = (String)localShareSecurityCheck.getMetaContentMap().get("assets/res_meta.txt");
      if ((parama == null) || (parama.length() == 0))
      {
        ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
        bool1 = true;
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        if (!f.c(paramContext, (String)localObject2 + "/res/", parama, (File)localObject1)) {
          ShareTinkerLog.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
        }
        for (bool1 = false;; bool1 = true)
        {
          ShareTinkerLog.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(SystemClock.elapsedRealtime() - l) });
          break;
        }
      }
    }
    if (!e.a(localFile1, locala))
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
      return false;
    }
    if (!SharePatchInfo.rewritePatchInfoFileWithLock(localFile3, paramString, localFile2))
    {
      ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
      locala.MgW.b(localFile1, paramString.oldVersion, paramString.newVersion);
      return false;
    }
    c.lp(paramContext).aZS(str);
    ShareTinkerLog.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.c.g
 * JD-Core Version:    0.7.0.1
 */