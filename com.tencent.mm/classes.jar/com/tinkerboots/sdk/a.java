package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.c.g;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;
import java.io.File;

public final class a
{
  public static a MAh;
  public final com.tencent.tinker.lib.e.a MAi;
  public final com.tinkerboots.sdk.a.a MAj;
  private final ApplicationLike cTo;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    AppMethodBeat.i(3427);
    com.tinkerboots.sdk.b.c.context = paramContext;
    this.cTo = paramApplicationLike;
    this.MAj = com.tinkerboots.sdk.a.a.a(paramb1);
    paramContext = new com.tencent.tinker.lib.e.a.a(paramApplicationLike.getApplication());
    int i = paramApplicationLike.getTinkerFlags();
    if (paramContext.status != -1)
    {
      paramContext = new TinkerRuntimeException("tinkerFlag is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.status = i;
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("loadReporter must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.MgV != null)
    {
      paramContext = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MgV = paramc;
    if (paramb == null)
    {
      paramContext = new TinkerRuntimeException("listener must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.MgU != null)
    {
      paramContext = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MgU = paramb;
    if (paramd == null)
    {
      paramContext = new TinkerRuntimeException("patchReporter must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.MgW != null)
    {
      paramContext = new TinkerRuntimeException("patchReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MgW = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.Mhe != null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.Mhe = paramc;
    paramContext = paramContext.fYB();
    com.tencent.tinker.lib.e.a.a(paramContext);
    paramc = paramApplicationLike.getTinkerResultIntent();
    com.tencent.tinker.lib.e.a.sInstalled = true;
    TinkerPatchService.a(parama, paramClass);
    ShareTinkerLog.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags)), "1.9.14.7-fix7-INTERNALv4" });
    if (!ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags))
    {
      ShareTinkerLog.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      this.MAi = paramContext;
      AppMethodBeat.o(3427);
      return;
    }
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("intentResult must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.Mha = new com.tencent.tinker.lib.e.d();
    paramd = paramContext.Mha;
    paramb = paramContext.context;
    paramApplicationLike = com.tencent.tinker.lib.e.a.lk(paramb);
    paramd.Mhr = ShareIntentUtil.getIntentReturnCode(paramc);
    paramd.msQ = ShareIntentUtil.getIntentPatchCostTime(paramc);
    paramd.Mhh = ShareIntentUtil.getBooleanExtra(paramc, "intent_patch_system_ota", false);
    paramd.oatDir = ShareIntentUtil.getStringExtra(paramc, "intent_patch_oat_dir");
    paramd.useInterpretMode = "interpet".equals(paramd.oatDir);
    boolean bool2 = paramApplicationLike.AEC;
    ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramd.Mhr), ShareTinkerInternals.getProcessName(paramb), Boolean.valueOf(bool2), Boolean.valueOf(paramd.Mhh), Build.FINGERPRINT, paramd.oatDir, Boolean.valueOf(paramd.useInterpretMode) });
    paramb = ShareIntentUtil.getStringExtra(paramc, "intent_patch_old_version");
    parama = ShareIntentUtil.getStringExtra(paramc, "intent_patch_new_version");
    paramClass = paramApplicationLike.MgT;
    paramb1 = paramApplicationLike.MgX;
    label624:
    Object localObject;
    boolean bool1;
    if ((paramb != null) && (parama != null))
    {
      if (bool2)
      {
        paramd.Mhf = parama;
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramb, parama, paramd.Mhf });
        localObject = SharePatchFileUtil.getPatchVersionDirectory(paramd.Mhf);
        if (!ShareTinkerInternals.isNullOrNil((String)localObject))
        {
          paramd.Mhi = new File(paramClass.getAbsolutePath() + "/" + (String)localObject);
          paramd.Mhj = new File(paramd.Mhi.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(paramd.Mhf));
          paramd.Mhk = new File(paramd.Mhi, "dex");
          paramd.Mhl = new File(paramd.Mhi, "lib");
          paramd.Mhm = new File(paramd.Mhi, "res");
          paramd.Mhn = new File(paramd.Mhm, "resources.apk");
        }
        paramd.patchInfo = new SharePatchInfo(paramb, parama, ShareIntentUtil.getBooleanExtra(paramc, "intent_is_protected_app", false), false, Build.FINGERPRINT, paramd.oatDir);
        if (paramb.equals(parama)) {
          break label1032;
        }
        bool1 = true;
        label867:
        paramd.Mhg = bool1;
      }
    }
    else
    {
      localObject = ShareIntentUtil.getIntentPatchException(paramc);
      if (localObject == null) {
        break label1065;
      }
      ShareTinkerLog.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramd.Mhr) });
      i = -1;
      switch (paramd.Mhr)
      {
      default: 
        label960:
        paramApplicationLike.MgV.a((Throwable)localObject, i);
      }
    }
    for (;;)
    {
      paramContext.MgV.a(paramContext.MgT, paramContext.Mha.Mhr, paramContext.Mha.msQ);
      if (paramContext.Mhb) {
        break;
      }
      ShareTinkerLog.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      break;
      paramd.Mhf = paramb;
      break label624;
      label1032:
      bool1 = false;
      break label867;
      i = -1;
      break label960;
      i = -2;
      break label960;
      i = -3;
      break label960;
      i = -4;
      break label960;
      label1065:
      switch (paramd.Mhr)
      {
      default: 
        break;
      case -10000: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
        paramContext = new TinkerRuntimeException("can't get the right intent return code");
        AppMethodBeat.o(3427);
        throw paramContext;
      case -1: 
        ShareTinkerLog.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
        break;
      case -3: 
      case -2: 
        ShareTinkerLog.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
        break;
      case -4: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
        paramApplicationLike.MgV.b(paramb, parama, paramb1);
        break;
      case -5: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramd.Mhf });
        paramApplicationLike.MgV.a(paramd.Mhi, 1, true);
        break;
      case -7: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramd.Mhf });
        if (paramd.Mhj == null)
        {
          paramContext = new TinkerRuntimeException("error load patch version file not exist, but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        paramApplicationLike.MgV.a(paramd.Mhj, 1, false);
        break;
      case -8: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramd.Mhj == null)
        {
          paramContext = new TinkerRuntimeException("error patch package check fail , but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        i = paramc.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.MgV.c(paramd.Mhj, i);
        break;
      case -9: 
        if (paramd.Mhk != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramd.Mhk.getAbsolutePath() });
          paramApplicationLike.MgV.a(paramd.Mhk, 3, true);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -10: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[] { paramc });
          paramApplicationLike.MgV.a(new File(paramc), 3, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -11: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[] { paramc });
          paramApplicationLike.MgV.a(new File(paramc), 4, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -17: 
        if (paramd.Mhi != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramd.Mhl.getAbsolutePath() });
          paramApplicationLike.MgV.a(paramd.Mhl, 5, true);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -18: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_missing_lib_path");
        if (paramc != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[] { paramc });
          paramApplicationLike.MgV.a(new File(paramc), 5, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -12: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
        break;
      case -13: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_mismatch_dex_path");
        if (paramc == null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[] { paramc });
        paramApplicationLike.MgV.b(new File(paramc), 3);
        break;
      case -19: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.MgV.b(paramb, parama, paramb1);
        break;
      case -21: 
        if (paramd.Mhi != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramd.Mhm.getAbsolutePath() });
          paramApplicationLike.MgV.a(paramd.Mhm, 6, true);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -22: 
        if (paramd.Mhi != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramd.Mhn.getAbsolutePath() });
          paramApplicationLike.MgV.a(paramd.Mhn, 6, false);
        }
        else
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -24: 
        if (paramd.Mhn == null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          paramContext = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramd.Mhn.getAbsolutePath() });
        paramApplicationLike.MgV.b(paramd.Mhn, 6);
        break;
      case -15: 
        paramApplicationLike.MgV.b(1, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case -16: 
        paramApplicationLike.MgV.b(2, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case 0: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.Mhb = true;
        paramd.Mho = ShareIntentUtil.getIntentPatchDexPaths(paramc);
        paramd.Mhp = ShareIntentUtil.getIntentPatchLibsPaths(paramc);
        paramd.Mhq = ShareIntentUtil.getIntentPackageConfig(paramc);
        if (paramd.useInterpretMode) {
          paramApplicationLike.MgV.b(0, null);
        }
        if ((bool2) && (paramd.Mhg)) {
          paramApplicationLike.MgV.a(paramb, parama, paramClass, paramd.Mhi.getName());
        }
        break;
      }
    }
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(186135);
    if (parama == null)
    {
      parama = new TinkerRuntimeException("TinkerClient init, tinkerClient should not be null.");
      AppMethodBeat.o(186135);
      throw parama;
    }
    if (MAh != null)
    {
      parama = new TinkerRuntimeException("TinkerClient instance is already set.");
      AppMethodBeat.o(186135);
      throw parama;
    }
    MAh = parama;
    AppMethodBeat.o(186135);
    return parama;
  }
  
  public static a gdU()
  {
    AppMethodBeat.i(3428);
    if (MAh == null)
    {
      localObject = new TinkerRuntimeException("you must init TinkerClient sdk first");
      AppMethodBeat.o(3428);
      throw ((Throwable)localObject);
    }
    Object localObject = MAh;
    AppMethodBeat.o(3428);
    return localObject;
  }
  
  public final a aiS(int paramInt)
  {
    AppMethodBeat.i(3431);
    if (this.MAj == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      locala = MAh;
      AppMethodBeat.o(3431);
      return locala;
    }
    ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    this.MAj.aiT(paramInt);
    a locala = MAh;
    AppMethodBeat.o(3431);
    return locala;
  }
  
  public final a nm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3430);
    if (this.MAj == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      paramString1 = MAh;
      AppMethodBeat.o(3430);
      return paramString1;
    }
    ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.MAj.nn(paramString1, paramString2);
    paramString1 = MAh;
    AppMethodBeat.o(3430);
    return paramString1;
  }
  
  public final a zV(final boolean paramBoolean)
  {
    AppMethodBeat.i(3429);
    if ((this.MAj == null) || (this.MAi == null))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject = MAh;
      AppMethodBeat.o(3429);
      return localObject;
    }
    Object localObject = com.tinkerboots.sdk.b.c.getContext();
    if (!com.tinkerboots.sdk.b.b.lG((Context)localObject))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
      localObject = MAh;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if ((!ShareTinkerInternals.isTinkerEnabled(this.MAi.tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences((Context)localObject)))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      localObject = MAh;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if (this.MAi.AEC)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(3425);
          Object localObject1 = a.this.MAj;
          boolean bool = paramBoolean;
          Object localObject2 = com.tinkerboots.sdk.b.c.getContext().getSharedPreferences("patch_server_config", 0);
          long l = ((SharedPreferences)localObject2).getLong("fetch_patch_last_check", 0L);
          if (l == -1L) {
            ShareTinkerLog.v("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
          }
          for (;;)
          {
            AppMethodBeat.o(3425);
            return false;
            l = System.currentTimeMillis() - l;
            if ((bool) || (((com.tinkerboots.sdk.a.a)localObject1).cFj) || (l >= ((com.tinkerboots.sdk.a.a)localObject1).jXi))
            {
              ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
              localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).MAq;
              localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).MAo;
              if (localObject1 == null)
              {
                localObject1 = new RuntimeException("callback can't be null");
                AppMethodBeat.o(3425);
                throw ((Throwable)localObject1);
              }
              if (((com.tinkerboots.sdk.a.a.b)localObject1).dcC())
              {
                ((com.tinkerboots.sdk.a.a.b)localObject1).dcD();
                ((com.tinkerboots.sdk.a.a.b)localObject1).ah(((com.tinkerboots.sdk.a.b.a)localObject2).MAr.MAs);
              }
            }
            else
            {
              ShareTinkerLog.v("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).jXi - l) / 1000L) });
            }
          }
        }
      });
    }
    localObject = MAh;
    AppMethodBeat.o(3429);
    return localObject;
  }
  
  public static final class a
  {
    private com.tencent.tinker.lib.c.a MAm;
    public Class<? extends AbstractResultService> MAn;
    private com.tinkerboots.sdk.a.a.b MAo;
    public com.tencent.tinker.lib.b.b MgU;
    public com.tencent.tinker.lib.d.c MgV;
    private com.tencent.tinker.lib.d.d MgW;
    private final ApplicationLike cTo;
    private final Context context;
    
    public a(ApplicationLike paramApplicationLike)
    {
      AppMethodBeat.i(3426);
      if (paramApplicationLike == null)
      {
        paramApplicationLike = new TinkerRuntimeException("applicationLike must not be null.");
        AppMethodBeat.o(3426);
        throw paramApplicationLike;
      }
      this.context = paramApplicationLike.getApplication();
      this.cTo = paramApplicationLike;
      AppMethodBeat.o(3426);
    }
    
    public final a a(com.tencent.tinker.lib.d.d paramd)
    {
      AppMethodBeat.i(186133);
      if (this.MgW != null)
      {
        paramd = new TinkerRuntimeException("patchReporter is already set.");
        AppMethodBeat.o(186133);
        throw paramd;
      }
      this.MgW = paramd;
      AppMethodBeat.o(186133);
      return this;
    }
    
    public final a gdV()
    {
      AppMethodBeat.i(186134);
      if (this.MgV == null) {
        this.MgV = new com.tinkerboots.sdk.tinker.b.a(this.context);
      }
      if (this.MgW == null) {
        this.MgW = new com.tinkerboots.sdk.tinker.b.c(this.context);
      }
      if (this.MgU == null) {
        this.MgU = new com.tinkerboots.sdk.tinker.b.b(this.context);
      }
      if (this.MAm == null) {
        this.MAm = new g();
      }
      if (this.MAn == null) {
        this.MAn = TinkerServerResultService.class;
      }
      if (this.MAo == null) {
        this.MAo = new com.tinkerboots.sdk.a.a.a();
      }
      a locala = new a(this.context, this.cTo, this.MgV, this.MgW, this.MgU, this.MAm, this.MAn, this.MAo);
      AppMethodBeat.o(186134);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */