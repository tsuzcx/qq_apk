package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class f
  extends a
{
  public final boolean a(Context paramContext, String paramString, com.tencent.tinker.lib.service.a parama)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.hN(paramContext);
    File localFile1 = new File(paramString);
    if ((!ShareTinkerInternals.Ko(locala.tinkerFlags)) || (!ShareTinkerInternals.id(paramContext)))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
      return false;
    }
    if (!SharePatchFileUtil.ae(localFile1))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
      return false;
    }
    Object localObject1 = new ShareSecurityCheck(paramContext);
    int i = ShareTinkerInternals.a(paramContext, locala.tinkerFlags, localFile1, (ShareSecurityCheck)localObject1);
    if (i != 0)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
      locala.wWm.d(localFile1, i);
      return false;
    }
    String str = SharePatchFileUtil.ai(localFile1);
    if (str == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
      return false;
    }
    parama.wWb = str;
    com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", new Object[] { str });
    Object localObject2 = locala.wWj.getAbsolutePath();
    parama = SharePatchFileUtil.agj((String)localObject2);
    File localFile2 = SharePatchFileUtil.agi((String)localObject2);
    Object localObject3 = SharePatchInfo.l(localFile2, parama);
    if (localObject3 != null)
    {
      if ((((SharePatchInfo)localObject3).wZr == null) || (((SharePatchInfo)localObject3).wZs == null) || (((SharePatchInfo)localObject3).wWw == null))
      {
        com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
        locala.wWm.a(localFile1, ((SharePatchInfo)localObject3).wZr, ((SharePatchInfo)localObject3).wZs);
        return false;
      }
      if (!SharePatchFileUtil.agm(str))
      {
        com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", new Object[] { str });
        locala.wWm.a(localFile1, (SharePatchInfo)localObject3, str);
        return false;
      }
      if (((SharePatchInfo)localObject3).wWw.equals("interpet")) {
        paramString = "changing";
      }
    }
    for (paramString = new SharePatchInfo(((SharePatchInfo)localObject3).wZr, str, Build.FINGERPRINT, paramString);; paramString = new SharePatchInfo("", str, Build.FINGERPRINT, "odex"))
    {
      localObject3 = SharePatchFileUtil.agk(str);
      localObject3 = (String)localObject2 + "/" + (String)localObject3;
      com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", new Object[] { localObject3 });
      localObject2 = new File((String)localObject3 + "/" + SharePatchFileUtil.agl(str));
      try
      {
        if (!str.equals(SharePatchFileUtil.ai((File)localObject2)))
        {
          SharePatchFileUtil.j(localFile1, (File)localObject2);
          com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", new Object[] { localFile1.getAbsolutePath(), Long.valueOf(localFile1.length()), ((File)localObject2).getAbsolutePath(), Long.valueOf(((File)localObject2).length()) });
        }
        if (d.a(locala, (ShareSecurityCheck)localObject1, paramContext, (String)localObject3, (File)localObject2)) {
          break label607;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
        return false;
      }
      catch (IOException paramContext)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", new Object[] { localFile1.getPath(), ((File)localObject2).getPath() });
        locala.wWm.a(localFile1, (File)localObject2, localFile1.getName(), 1);
        return false;
      }
      paramString = ((SharePatchInfo)localObject3).wWw;
      break;
    }
    label607:
    boolean bool;
    if (!ShareTinkerInternals.Kl(locala.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
      bool = true;
    }
    long l;
    while (!bool)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
      return false;
      str = (String)((ShareSecurityCheck)localObject1).wZE.get("assets/so_meta.txt");
      if (str == null)
      {
        com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
        bool = true;
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        bool = c.a(paramContext, (String)localObject3 + "/lib/", str, (File)localObject2);
        com.tencent.tinker.lib.f.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", new Object[] { Boolean.valueOf(bool), Long.valueOf(SystemClock.elapsedRealtime() - l) });
      }
    }
    if (!ShareTinkerInternals.Km(locala.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
      bool = true;
    }
    while (!bool)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
      return false;
      localObject1 = (String)((ShareSecurityCheck)localObject1).wZE.get("assets/res_meta.txt");
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
        bool = true;
      }
      else
      {
        l = SystemClock.elapsedRealtime();
        if (!e.c(paramContext, (String)localObject3 + "/res/", (String)localObject1, (File)localObject2)) {
          com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
        }
        for (bool = false;; bool = true)
        {
          com.tencent.tinker.lib.f.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", new Object[] { Boolean.valueOf(bool), Long.valueOf(SystemClock.elapsedRealtime() - l) });
          break;
        }
      }
    }
    if (!d.a(localFile1, locala))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
      return false;
    }
    if (!SharePatchInfo.a(localFile2, paramString, parama))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
      locala.wWm.a(localFile1, paramString.wZr, paramString.wZs);
      return false;
    }
    com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tinker.lib.c.f
 * JD-Core Version:    0.7.0.1
 */