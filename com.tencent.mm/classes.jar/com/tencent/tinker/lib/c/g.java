package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends a
{
  public final boolean a(Context paramContext, String paramString, com.tencent.tinker.lib.service.a parama)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.kI(paramContext);
    File localFile1 = new File(paramString);
    if ((!ShareTinkerInternals.isTinkerEnabled(locala.tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences(paramContext)))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
      return false;
    }
    if (!SharePatchFileUtil.isLegalFile(localFile1))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
      return false;
    }
    Object localObject1 = new ShareSecurityCheck(paramContext);
    int i = ShareTinkerInternals.checkTinkerPackage(paramContext, locala.tinkerFlags, localFile1, (ShareSecurityCheck)localObject1);
    if (i != 0)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
      locala.IEM.e(localFile1, i);
      return false;
    }
    String str1 = SharePatchFileUtil.getMD5(localFile1);
    if (str1 == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
      return false;
    }
    parama.IED = str1;
    com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", new Object[] { str1 });
    Object localObject2 = locala.IEJ.getAbsolutePath();
    parama = SharePatchFileUtil.getPatchInfoLockFile((String)localObject2);
    File localFile2 = SharePatchFileUtil.getPatchInfoFile((String)localObject2);
    paramString = ((ShareSecurityCheck)localObject1).getPackagePropertiesIfPresent();
    if (paramString == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch packageProperties is null, do we process a valid patch apk ?", new Object[0]);
      return false;
    }
    paramString = (String)paramString.get("is_protected_app");
    if ((paramString != null) && (!paramString.isEmpty()) && (!"0".equals(paramString))) {}
    Object localObject3;
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject3 = SharePatchInfo.readAndCheckPropertyWithLock(localFile2, parama);
      if (localObject3 == null) {
        break label673;
      }
      if ((((SharePatchInfo)localObject3).oldVersion != null) && (((SharePatchInfo)localObject3).newVersion != null) && (((SharePatchInfo)localObject3).oatDir != null)) {
        break;
      }
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
      locala.IEM.b(localFile1, ((SharePatchInfo)localObject3).oldVersion, ((SharePatchInfo)localObject3).newVersion);
      return false;
    }
    if (!SharePatchFileUtil.checkIfMd5Valid(str1))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", new Object[] { str1 });
      locala.IEM.a(localFile1, (SharePatchInfo)localObject3, str1);
      return false;
    }
    boolean bool2 = ((SharePatchInfo)localObject3).oatDir.equals("interpet");
    if ((!bool2) && (!ShareTinkerInternals.isNullOrNil(((SharePatchInfo)localObject3).newVersion)) && (((SharePatchInfo)localObject3).newVersion.equals(str1)) && (!((SharePatchInfo)localObject3).isRemoveNewVersion))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "patch already applied, md5: %s", new Object[] { str1 });
      c.kN(paramContext).aOj(str1);
      return true;
    }
    if (bool2) {
      paramString = "changing";
    }
    label673:
    for (paramString = new SharePatchInfo(((SharePatchInfo)localObject3).oldVersion, str1, bool1, false, Build.FINGERPRINT, paramString);; paramString = new SharePatchInfo("", str1, bool1, false, Build.FINGERPRINT, "odex"))
    {
      localObject3 = SharePatchFileUtil.getPatchVersionDirectory(str1);
      localObject3 = (String)localObject2 + "/" + (String)localObject3;
      com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", new Object[] { localObject3 });
      localObject2 = new File((String)localObject3 + "/" + SharePatchFileUtil.getPatchVersionFile(str1));
      try
      {
        if (!str1.equals(SharePatchFileUtil.getMD5((File)localObject2)))
        {
          SharePatchFileUtil.copyFileUsingStream(localFile1, (File)localObject2);
          com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", new Object[] { localFile1.getAbsolutePath(), Long.valueOf(localFile1.length()), ((File)localObject2).getAbsolutePath(), Long.valueOf(((File)localObject2).length()) });
        }
        if (e.a(locala, (ShareSecurityCheck)localObject1, paramContext, (String)localObject3, (File)localObject2)) {
          break label746;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
        return false;
      }
      catch (IOException paramContext)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", new Object[] { localFile1.getPath(), ((File)localObject2).getPath() });
        locala.IEM.a(localFile1, (File)localObject2, localFile1.getName(), 1);
        return false;
      }
      paramString = ((SharePatchInfo)localObject3).oatDir;
      break;
    }
    label746:
    b.a((ShareSecurityCheck)localObject1, paramContext, (String)localObject3, (File)localObject2);
    if (!ShareTinkerInternals.isTinkerEnabledForNativeLib(locala.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
      bool1 = true;
    }
    long l;
    while (!bool1)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
      return false;
      String str2 = (String)((ShareSecurityCheck)localObject1).getMetaContentMap().get("assets/so_meta.txt");
      if (str2 == null)
      {
        com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
        bool1 = true;
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        bool1 = d.a(paramContext, (String)localObject3 + "/lib/", str2, (File)localObject2);
        com.tencent.tinker.lib.f.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(SystemClock.elapsedRealtime() - l) });
      }
    }
    if (!ShareTinkerInternals.isTinkerEnabledForResource(locala.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
      bool1 = true;
    }
    while (!bool1)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
      return false;
      localObject1 = (String)((ShareSecurityCheck)localObject1).getMetaContentMap().get("assets/res_meta.txt");
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
        bool1 = true;
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        if (!f.c(paramContext, (String)localObject3 + "/res/", (String)localObject1, (File)localObject2)) {
          com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
        }
        for (bool1 = false;; bool1 = true)
        {
          com.tencent.tinker.lib.f.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(SystemClock.elapsedRealtime() - l) });
          break;
        }
      }
    }
    if (!e.a(localFile1, locala))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
      return false;
    }
    if (!SharePatchInfo.rewritePatchInfoFileWithLock(localFile2, paramString, parama))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
      locala.IEM.b(localFile1, paramString.oldVersion, paramString.newVersion);
      return false;
    }
    c.kN(paramContext).aOj(str1);
    com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.c.g
 * JD-Core Version:    0.7.0.1
 */