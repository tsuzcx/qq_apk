package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.e.a.a;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class a
{
  public static a xnC;
  private final ApplicationLike applicationLike;
  public final com.tencent.tinker.lib.e.a xnD;
  public final com.tinkerboots.sdk.a.a xnE;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    com.tinkerboots.sdk.b.b.context = paramContext;
    this.applicationLike = paramApplicationLike;
    this.xnE = com.tinkerboots.sdk.a.a.a(paramb1);
    paramContext = new a.a(paramApplicationLike.getApplication());
    int i = paramApplicationLike.getTinkerFlags();
    if (paramContext.status != -1) {
      throw new TinkerRuntimeException("tinkerFlag is already set.");
    }
    paramContext.status = i;
    if (paramc == null) {
      throw new TinkerRuntimeException("loadReporter must not be null.");
    }
    if (paramContext.wWl != null) {
      throw new TinkerRuntimeException("loadReporter is already set.");
    }
    paramContext.wWl = paramc;
    if (paramb == null) {
      throw new TinkerRuntimeException("listener must not be null.");
    }
    if (paramContext.wWk != null) {
      throw new TinkerRuntimeException("listener is already set.");
    }
    paramContext.wWk = paramb;
    if (paramd == null) {
      throw new TinkerRuntimeException("patchReporter must not be null.");
    }
    if (paramContext.wWm != null) {
      throw new TinkerRuntimeException("patchReporter is already set.");
    }
    paramContext.wWm = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null) {
      throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
    }
    if (paramContext.wWu != null) {
      throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
    }
    paramContext.wWu = paramc;
    paramContext = paramContext.cQI();
    com.tencent.tinker.lib.e.a.a(paramContext);
    paramc = paramApplicationLike.getTinkerResultIntent();
    com.tencent.tinker.lib.e.a.wWi = true;
    TinkerPatchService.a(parama, paramClass);
    com.tencent.tinker.lib.f.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.Ko(paramContext.tinkerFlags)), "1.9.8" });
    if (!ShareTinkerInternals.Ko(paramContext.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      this.xnD = paramContext;
      return;
    }
    if (paramc == null) {
      throw new TinkerRuntimeException("intentResult must not be null.");
    }
    paramContext.wWq = new com.tencent.tinker.lib.e.d();
    paramd = paramContext.wWq;
    paramb = paramContext.context;
    paramApplicationLike = com.tencent.tinker.lib.e.a.hN(paramb);
    paramd.wWJ = ShareIntentUtil.aA(paramc);
    paramd.gYL = ShareIntentUtil.aB(paramc);
    paramd.wWz = ShareIntentUtil.r(paramc, "intent_patch_system_ota");
    paramd.wWw = ShareIntentUtil.j(paramc, "intent_patch_oat_dir");
    paramd.wWy = "interpet".equals(paramd.wWw);
    boolean bool2 = paramApplicationLike.prD;
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramd.wWJ), ShareTinkerInternals.ak(paramb), Boolean.valueOf(bool2), Boolean.valueOf(paramd.wWz), Build.FINGERPRINT, paramd.wWw, Boolean.valueOf(paramd.wWy) });
    paramb = ShareIntentUtil.j(paramc, "intent_patch_old_version");
    parama = ShareIntentUtil.j(paramc, "intent_patch_new_version");
    paramClass = paramApplicationLike.wWj;
    paramb1 = paramApplicationLike.wWn;
    label531:
    Object localObject;
    boolean bool1;
    if ((paramb != null) && (parama != null))
    {
      if (bool2)
      {
        paramd.wWv = parama;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramb, parama, paramd.wWv });
        localObject = SharePatchFileUtil.agk(paramd.wWv);
        if (!ShareTinkerInternals.bl((String)localObject))
        {
          paramd.wWA = new File(paramClass.getAbsolutePath() + "/" + (String)localObject);
          paramd.wWB = new File(paramd.wWA.getAbsolutePath(), SharePatchFileUtil.agl(paramd.wWv));
          paramd.wWC = new File(paramd.wWA, "dex");
          paramd.wWD = new File(paramd.wWA, "lib");
          paramd.wWE = new File(paramd.wWA, "res");
          paramd.wWF = new File(paramd.wWE, "resources.apk");
        }
        paramd.patchInfo = new SharePatchInfo(paramb, parama, Build.FINGERPRINT, paramd.wWw);
        if (paramb.equals(parama)) {
          break label928;
        }
        bool1 = true;
        label764:
        paramd.wWx = bool1;
      }
    }
    else
    {
      localObject = ShareIntentUtil.aC(paramc);
      if (localObject == null) {
        break label961;
      }
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramd.wWJ) });
      i = -1;
      switch (paramd.wWJ)
      {
      default: 
        label856:
        paramApplicationLike.wWl.a((Throwable)localObject, i);
      }
    }
    for (;;)
    {
      paramContext.wWl.a(paramContext.wWj, paramContext.wWq.wWJ, paramContext.wWq.gYL);
      if (paramContext.wWr) {
        break;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      break;
      paramd.wWv = paramb;
      break label531;
      label928:
      bool1 = false;
      break label764;
      i = -1;
      break label856;
      i = -2;
      break label856;
      i = -3;
      break label856;
      i = -4;
      break label856;
      label961:
      switch (paramd.wWJ)
      {
      default: 
        break;
      case -10000: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
        throw new TinkerRuntimeException("can't get the right intent return code");
      case -1: 
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
        break;
      case -3: 
      case -2: 
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
        break;
      case -4: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
        paramApplicationLike.wWl.a(paramb, parama, paramb1);
        break;
      case -5: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramd.wWv });
        paramApplicationLike.wWl.a(paramd.wWA, 1, true);
        break;
      case -7: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramd.wWv });
        if (paramd.wWB == null) {
          throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
        }
        paramApplicationLike.wWl.a(paramd.wWB, 1, false);
        break;
      case -8: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramd.wWB == null) {
          throw new TinkerRuntimeException("error patch package check fail , but file is null");
        }
        i = paramc.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.wWl.b(paramd.wWB, i);
        break;
      case -9: 
        if (paramd.wWC != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramd.wWC.getAbsolutePath() });
          paramApplicationLike.wWl.a(paramd.wWC, 3, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
        }
        break;
      case -10: 
        paramc = ShareIntentUtil.j(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[] { paramc });
          paramApplicationLike.wWl.a(new File(paramc), 3, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
        }
        break;
      case -11: 
        paramc = ShareIntentUtil.j(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[] { paramc });
          paramApplicationLike.wWl.a(new File(paramc), 4, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
        }
        break;
      case -17: 
        if (paramd.wWA != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramd.wWD.getAbsolutePath() });
          paramApplicationLike.wWl.a(paramd.wWD, 5, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
        }
        break;
      case -18: 
        paramc = ShareIntentUtil.j(paramc, "intent_patch_missing_lib_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[] { paramc });
          paramApplicationLike.wWl.a(new File(paramc), 5, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
        }
        break;
      case -12: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
        break;
      case -13: 
        paramc = ShareIntentUtil.j(paramc, "intent_patch_mismatch_dex_path");
        if (paramc == null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[] { paramc });
        paramApplicationLike.wWl.a(new File(paramc), 3);
        break;
      case -19: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.wWl.a(paramb, parama, paramb1);
        break;
      case -21: 
        if (paramd.wWA != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramd.wWE.getAbsolutePath() });
          paramApplicationLike.wWl.a(paramd.wWE, 6, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
        }
        break;
      case -22: 
        if (paramd.wWA != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramd.wWF.getAbsolutePath() });
          paramApplicationLike.wWl.a(paramd.wWF, 6, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
          throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
        }
        break;
      case -24: 
        if (paramd.wWF == null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramd.wWF.getAbsolutePath() });
        paramApplicationLike.wWl.a(paramd.wWF, 6);
        break;
      case -15: 
        paramApplicationLike.wWl.b(1, ShareIntentUtil.aD(paramc));
        break;
      case -16: 
        paramApplicationLike.wWl.b(2, ShareIntentUtil.aD(paramc));
        break;
      case 0: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.wWr = true;
        paramd.wWG = ShareIntentUtil.aE(paramc);
        paramd.wWH = ShareIntentUtil.aF(paramc);
        paramd.wWI = ShareIntentUtil.aG(paramc);
        if (paramd.wWy) {
          paramApplicationLike.wWl.b(0, null);
        }
        if ((bool2) && (paramd.wWx)) {
          paramApplicationLike.wWl.a(paramb, parama, paramClass, paramd.wWA.getName());
        }
        break;
      }
    }
  }
  
  public static a cTY()
  {
    if (xnC == null) {
      throw new TinkerRuntimeException("you must init TinkerClient sdk first");
    }
    return xnC;
  }
  
  public final a KL(int paramInt)
  {
    if (this.xnE == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      return xnC;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    com.tinkerboots.sdk.a.a locala = this.xnE;
    if (paramInt == -1L)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
      com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1L).commit();
    }
    for (;;)
    {
      return xnC;
      if ((paramInt < 0) || (paramInt > 24)) {
        throw new TinkerRuntimeException("hours must be between 0 and 24");
      }
      locala.fPi = (paramInt * 3600L * 1000L);
    }
  }
  
  public final a gV(String paramString1, String paramString2)
  {
    if (this.xnE == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      return xnC;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.xnE.xnL.xnM.xnN.put(paramString1, paramString2);
    return xnC;
  }
  
  public final a oy(boolean paramBoolean)
  {
    int k = 1;
    if ((this.xnE == null) || (this.xnD == null))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      return xnC;
    }
    Context localContext = com.tinkerboots.sdk.b.b.getContext();
    int i;
    if (Build.VERSION.SDK_INT < 23)
    {
      i = k;
      if (i == 0)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
        return xnC;
      }
    }
    else
    {
      if (localContext.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
      {
        i = 1;
        label84:
        if (localContext.checkSelfPermission("android.permission.INTERNET") != 0) {
          break label118;
        }
      }
      label118:
      for (int j = 1;; j = 0)
      {
        if (i != 0)
        {
          i = k;
          if (j != 0) {
            break;
          }
        }
        i = 0;
        break;
        i = 0;
        break label84;
      }
    }
    if ((!ShareTinkerInternals.Ko(this.xnD.tinkerFlags)) || (!ShareTinkerInternals.id(localContext)))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      return xnC;
    }
    if (this.xnD.prD)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new a.1(this, paramBoolean));
    }
    return xnC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */