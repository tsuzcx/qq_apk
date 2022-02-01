package com.tencent.tinker.lib.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public final class c
{
  public static a a(ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, b paramb, Class<? extends AbstractResultService> paramClass, com.tencent.tinker.lib.c.a parama)
  {
    Object localObject1 = new a.a(paramApplicationLike.getApplication());
    int i = paramApplicationLike.getTinkerFlags();
    if (((a.a)localObject1).status != -1) {
      throw new TinkerRuntimeException("tinkerFlag is already set.");
    }
    ((a.a)localObject1).status = i;
    if (paramc == null) {
      throw new TinkerRuntimeException("loadReporter must not be null.");
    }
    if (((a.a)localObject1).ahRH != null) {
      throw new TinkerRuntimeException("loadReporter is already set.");
    }
    ((a.a)localObject1).ahRH = paramc;
    if (paramb == null) {
      throw new TinkerRuntimeException("listener must not be null.");
    }
    if (((a.a)localObject1).ahRG != null) {
      throw new TinkerRuntimeException("listener is already set.");
    }
    ((a.a)localObject1).ahRG = paramb;
    if (paramd == null) {
      throw new TinkerRuntimeException("patchReporter must not be null.");
    }
    if (((a.a)localObject1).ahRI != null) {
      throw new TinkerRuntimeException("patchReporter is already set.");
    }
    ((a.a)localObject1).ahRI = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null) {
      throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
    }
    if (((a.a)localObject1).ahRQ != null) {
      throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
    }
    ((a.a)localObject1).ahRQ = paramc;
    paramc = ((a.a)localObject1).kcg();
    a.a(paramc);
    paramd = paramApplicationLike.getTinkerResultIntent();
    a.sInstalled = true;
    TinkerPatchService.a(parama, paramClass);
    ShareTinkerLog.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.isTinkerEnabled(paramc.tinkerFlags)), "1.9.14.19-beta4" });
    if (!ShareTinkerInternals.isTinkerEnabled(paramc.tinkerFlags))
    {
      ShareTinkerLog.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      return paramc;
    }
    if (paramd == null) {
      throw new TinkerRuntimeException("intentResult must not be null.");
    }
    paramc.ahRM = new d();
    paramb = paramc.ahRM;
    paramClass = paramc.context;
    paramApplicationLike = a.oy(paramClass);
    paramb.ahSd = ShareIntentUtil.getIntentReturnCode(paramd);
    paramb.costTime = ShareIntentUtil.getIntentPatchCostTime(paramd);
    paramb.ahRT = ShareIntentUtil.getBooleanExtra(paramd, "intent_patch_system_ota", false);
    paramb.oatDir = ShareIntentUtil.getStringExtra(paramd, "intent_patch_oat_dir");
    paramb.useInterpretMode = "interpet".equals(paramb.oatDir);
    boolean bool2 = paramApplicationLike.rgc;
    ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramb.ahSd), ShareTinkerInternals.getProcessName(paramClass), Boolean.valueOf(bool2), Boolean.valueOf(paramb.ahRT), Build.FINGERPRINT, paramb.oatDir, Boolean.valueOf(paramb.useInterpretMode) });
    paramClass = ShareIntentUtil.getStringExtra(paramd, "intent_patch_old_version");
    parama = ShareIntentUtil.getStringExtra(paramd, "intent_patch_new_version");
    localObject1 = paramApplicationLike.ahRF;
    File localFile = paramApplicationLike.ahRJ;
    label502:
    Object localObject2;
    boolean bool1;
    if ((paramClass != null) && (parama != null))
    {
      if (bool2)
      {
        paramb.ahRR = parama;
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramClass, parama, paramb.ahRR });
        localObject2 = SharePatchFileUtil.getPatchVersionDirectory(paramb.ahRR);
        if (!ShareTinkerInternals.isNullOrNil((String)localObject2))
        {
          paramb.ahRU = new File(((File)localObject1).getAbsolutePath() + "/" + (String)localObject2);
          paramb.ahRV = new File(paramb.ahRU.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(paramb.ahRR));
          paramb.ahRW = new File(paramb.ahRU, "dex");
          paramb.ahRX = new File(paramb.ahRU, "lib");
          paramb.ahRY = new File(paramb.ahRU, "res");
          paramb.ahRZ = new File(paramb.ahRY, "resources.apk");
        }
        paramb.patchInfo = new SharePatchInfo(paramClass, parama, ShareIntentUtil.getBooleanExtra(paramd, "intent_is_protected_app", false), false, Build.FINGERPRINT, paramb.oatDir, false);
        if (paramClass.equals(parama)) {
          break label886;
        }
        bool1 = true;
        label728:
        paramb.ahRS = bool1;
      }
    }
    else
    {
      localObject2 = ShareIntentUtil.getIntentPatchException(paramd);
      if (localObject2 == null) {
        break label919;
      }
      ShareTinkerLog.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramb.ahSd) });
      i = -1;
      switch (paramb.ahSd)
      {
      default: 
        label816:
        paramApplicationLike.ahRH.a((Throwable)localObject2, i);
      }
    }
    for (;;)
    {
      paramc.ahRH.a(paramc.ahRF, paramc.ahRM.ahSd, paramc.ahRM.costTime);
      if (paramc.ahRN) {
        break;
      }
      ShareTinkerLog.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      return paramc;
      paramb.ahRR = paramClass;
      break label502;
      label886:
      bool1 = false;
      break label728;
      i = -1;
      break label816;
      i = -2;
      break label816;
      i = -3;
      break label816;
      i = -4;
      break label816;
      label919:
      switch (paramb.ahSd)
      {
      default: 
        break;
      case -10000: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
        throw new TinkerRuntimeException("can't get the right intent return code");
      case -1: 
        ShareTinkerLog.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
        break;
      case -3: 
      case -2: 
        ShareTinkerLog.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
        break;
      case -4: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
        paramApplicationLike.ahRH.b(paramClass, parama, localFile);
        break;
      case -5: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramb.ahRR });
        paramApplicationLike.ahRH.a(paramb.ahRU, 1, true);
        break;
      case -7: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramb.ahRR });
        if (paramb.ahRV == null) {
          throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
        }
        paramApplicationLike.ahRH.a(paramb.ahRV, 1, false);
        break;
      case -8: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramb.ahRV == null) {
          throw new TinkerRuntimeException("error patch package check fail , but file is null");
        }
        i = paramd.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.ahRH.f(paramb.ahRV, i);
        break;
      case -9: 
        if (paramb.ahRW != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramb.ahRW.getAbsolutePath() });
          paramApplicationLike.ahRH.a(paramb.ahRW, 3, true);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
        }
        break;
      case -10: 
        paramd = ShareIntentUtil.getStringExtra(paramd, "intent_patch_missing_dex_path");
        if (paramd != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[] { paramd });
          paramApplicationLike.ahRH.a(new File(paramd), 3, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
        }
        break;
      case -11: 
        paramd = ShareIntentUtil.getStringExtra(paramd, "intent_patch_missing_dex_path");
        if (paramd != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[] { paramd });
          paramApplicationLike.ahRH.a(new File(paramd), 4, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
        }
        break;
      case -17: 
        if (paramb.ahRU != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramb.ahRX.getAbsolutePath() });
          paramApplicationLike.ahRH.a(paramb.ahRX, 5, true);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
        }
        break;
      case -18: 
        paramd = ShareIntentUtil.getStringExtra(paramd, "intent_patch_missing_lib_path");
        if (paramd != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[] { paramd });
          paramApplicationLike.ahRH.a(new File(paramd), 5, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
        }
        break;
      case -12: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
        break;
      case -13: 
        paramd = ShareIntentUtil.getStringExtra(paramd, "intent_patch_mismatch_dex_path");
        if (paramd == null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
        }
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[] { paramd });
        paramApplicationLike.ahRH.e(new File(paramd), 3);
        break;
      case -19: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.ahRH.b(paramClass, parama, localFile);
        break;
      case -21: 
        if (paramb.ahRU != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramb.ahRY.getAbsolutePath() });
          paramApplicationLike.ahRH.a(paramb.ahRY, 6, true);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
        }
        break;
      case -22: 
        if (paramb.ahRU != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramb.ahRZ.getAbsolutePath() });
          paramApplicationLike.ahRH.a(paramb.ahRZ, 6, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
        }
        break;
      case -24: 
        if (paramb.ahRZ == null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
        }
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramb.ahRZ.getAbsolutePath() });
        paramApplicationLike.ahRH.e(paramb.ahRZ, 6);
        break;
      case -15: 
        paramApplicationLike.ahRH.c(1, ShareIntentUtil.getIntentInterpretException(paramd));
        break;
      case -16: 
        paramApplicationLike.ahRH.c(2, ShareIntentUtil.getIntentInterpretException(paramd));
        break;
      case 0: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.ahRN = true;
        paramb.ahSa = ShareIntentUtil.getIntentPatchDexPaths(paramd);
        paramb.ahSb = ShareIntentUtil.getIntentPatchLibsPaths(paramd);
        paramb.ahSc = ShareIntentUtil.getIntentPackageConfig(paramd);
        if (paramb.useInterpretMode) {
          paramApplicationLike.ahRH.c(0, null);
        }
        if ((bool2) && (paramb.ahRS)) {
          paramApplicationLike.ahRH.a(paramClass, parama, (File)localObject1, paramb.ahRU.getName());
        }
        break;
      }
    }
  }
  
  public static void ds(Context paramContext, String paramString)
  {
    a.oy(paramContext).ahRG.bGk(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.e.c
 * JD-Core Version:    0.7.0.1
 */