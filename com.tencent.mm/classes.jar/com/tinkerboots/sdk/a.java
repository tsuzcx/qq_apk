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
  public static a MXo;
  public final com.tencent.tinker.lib.e.a MXp;
  public final com.tinkerboots.sdk.a.a MXq;
  private final ApplicationLike cTZ;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    AppMethodBeat.i(3427);
    com.tinkerboots.sdk.b.c.context = paramContext;
    this.cTZ = paramApplicationLike;
    this.MXq = com.tinkerboots.sdk.a.a.a(paramb1);
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
    if (paramContext.MDS != null)
    {
      paramContext = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MDS = paramc;
    if (paramb == null)
    {
      paramContext = new TinkerRuntimeException("listener must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.MDR != null)
    {
      paramContext = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MDR = paramb;
    if (paramd == null)
    {
      paramContext = new TinkerRuntimeException("patchReporter must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.MDT != null)
    {
      paramContext = new TinkerRuntimeException("patchReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MDT = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.MEb != null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MEb = paramc;
    paramContext = paramContext.gda();
    com.tencent.tinker.lib.e.a.a(paramContext);
    paramc = paramApplicationLike.getTinkerResultIntent();
    com.tencent.tinker.lib.e.a.sInstalled = true;
    TinkerPatchService.a(parama, paramClass);
    ShareTinkerLog.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags)), "1.9.14.8" });
    if (!ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags))
    {
      ShareTinkerLog.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      this.MXp = paramContext;
      AppMethodBeat.o(3427);
      return;
    }
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("intentResult must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.MDX = new com.tencent.tinker.lib.e.d();
    paramd = paramContext.MDX;
    paramb = paramContext.context;
    paramApplicationLike = com.tencent.tinker.lib.e.a.lq(paramb);
    paramd.MEo = ShareIntentUtil.getIntentReturnCode(paramc);
    paramd.mxN = ShareIntentUtil.getIntentPatchCostTime(paramc);
    paramd.MEe = ShareIntentUtil.getBooleanExtra(paramc, "intent_patch_system_ota", false);
    paramd.oatDir = ShareIntentUtil.getStringExtra(paramc, "intent_patch_oat_dir");
    paramd.useInterpretMode = "interpet".equals(paramd.oatDir);
    boolean bool2 = paramApplicationLike.AWf;
    ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramd.MEo), ShareTinkerInternals.getProcessName(paramb), Boolean.valueOf(bool2), Boolean.valueOf(paramd.MEe), Build.FINGERPRINT, paramd.oatDir, Boolean.valueOf(paramd.useInterpretMode) });
    paramb = ShareIntentUtil.getStringExtra(paramc, "intent_patch_old_version");
    parama = ShareIntentUtil.getStringExtra(paramc, "intent_patch_new_version");
    paramClass = paramApplicationLike.MDQ;
    paramb1 = paramApplicationLike.MDU;
    label624:
    Object localObject;
    boolean bool1;
    if ((paramb != null) && (parama != null))
    {
      if (bool2)
      {
        paramd.MEc = parama;
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramb, parama, paramd.MEc });
        localObject = SharePatchFileUtil.getPatchVersionDirectory(paramd.MEc);
        if (!ShareTinkerInternals.isNullOrNil((String)localObject))
        {
          paramd.MEf = new File(paramClass.getAbsolutePath() + "/" + (String)localObject);
          paramd.MEg = new File(paramd.MEf.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(paramd.MEc));
          paramd.MEh = new File(paramd.MEf, "dex");
          paramd.MEi = new File(paramd.MEf, "lib");
          paramd.MEj = new File(paramd.MEf, "res");
          paramd.MEk = new File(paramd.MEj, "resources.apk");
        }
        paramd.patchInfo = new SharePatchInfo(paramb, parama, ShareIntentUtil.getBooleanExtra(paramc, "intent_is_protected_app", false), false, Build.FINGERPRINT, paramd.oatDir, false);
        if (paramb.equals(parama)) {
          break label1032;
        }
        bool1 = true;
        label868:
        paramd.MEd = bool1;
      }
    }
    else
    {
      localObject = ShareIntentUtil.getIntentPatchException(paramc);
      if (localObject == null) {
        break label1065;
      }
      ShareTinkerLog.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramd.MEo) });
      i = -1;
      switch (paramd.MEo)
      {
      default: 
        label960:
        paramApplicationLike.MDS.a((Throwable)localObject, i);
      }
    }
    for (;;)
    {
      paramContext.MDS.a(paramContext.MDQ, paramContext.MDX.MEo, paramContext.MDX.mxN);
      if (paramContext.MDY) {
        break;
      }
      ShareTinkerLog.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      break;
      paramd.MEc = paramb;
      break label624;
      label1032:
      bool1 = false;
      break label868;
      i = -1;
      break label960;
      i = -2;
      break label960;
      i = -3;
      break label960;
      i = -4;
      break label960;
      label1065:
      switch (paramd.MEo)
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
        paramApplicationLike.MDS.b(paramb, parama, paramb1);
        break;
      case -5: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramd.MEc });
        paramApplicationLike.MDS.a(paramd.MEf, 1, true);
        break;
      case -7: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramd.MEc });
        if (paramd.MEg == null)
        {
          paramContext = new TinkerRuntimeException("error load patch version file not exist, but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        paramApplicationLike.MDS.a(paramd.MEg, 1, false);
        break;
      case -8: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramd.MEg == null)
        {
          paramContext = new TinkerRuntimeException("error patch package check fail , but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        i = paramc.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.MDS.c(paramd.MEg, i);
        break;
      case -9: 
        if (paramd.MEh != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramd.MEh.getAbsolutePath() });
          paramApplicationLike.MDS.a(paramd.MEh, 3, true);
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
          paramApplicationLike.MDS.a(new File(paramc), 3, false);
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
          paramApplicationLike.MDS.a(new File(paramc), 4, false);
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
        if (paramd.MEf != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramd.MEi.getAbsolutePath() });
          paramApplicationLike.MDS.a(paramd.MEi, 5, true);
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
          paramApplicationLike.MDS.a(new File(paramc), 5, false);
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
        paramApplicationLike.MDS.b(new File(paramc), 3);
        break;
      case -19: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.MDS.b(paramb, parama, paramb1);
        break;
      case -21: 
        if (paramd.MEf != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramd.MEj.getAbsolutePath() });
          paramApplicationLike.MDS.a(paramd.MEj, 6, true);
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
        if (paramd.MEf != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramd.MEk.getAbsolutePath() });
          paramApplicationLike.MDS.a(paramd.MEk, 6, false);
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
        if (paramd.MEk == null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          paramContext = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramd.MEk.getAbsolutePath() });
        paramApplicationLike.MDS.b(paramd.MEk, 6);
        break;
      case -15: 
        paramApplicationLike.MDS.b(1, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case -16: 
        paramApplicationLike.MDS.b(2, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case 0: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.MDY = true;
        paramd.MEl = ShareIntentUtil.getIntentPatchDexPaths(paramc);
        paramd.MEm = ShareIntentUtil.getIntentPatchLibsPaths(paramc);
        paramd.MEn = ShareIntentUtil.getIntentPackageConfig(paramc);
        if (paramd.useInterpretMode) {
          paramApplicationLike.MDS.b(0, null);
        }
        if ((bool2) && (paramd.MEd)) {
          paramApplicationLike.MDS.a(paramb, parama, paramClass, paramd.MEf.getName());
        }
        break;
      }
    }
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(188695);
    if (parama == null)
    {
      parama = new TinkerRuntimeException("TinkerClient init, tinkerClient should not be null.");
      AppMethodBeat.o(188695);
      throw parama;
    }
    if (MXo != null)
    {
      parama = new TinkerRuntimeException("TinkerClient instance is already set.");
      AppMethodBeat.o(188695);
      throw parama;
    }
    MXo = parama;
    AppMethodBeat.o(188695);
    return parama;
  }
  
  public static a gix()
  {
    AppMethodBeat.i(3428);
    if (MXo == null)
    {
      localObject = new TinkerRuntimeException("you must init TinkerClient sdk first");
      AppMethodBeat.o(3428);
      throw ((Throwable)localObject);
    }
    Object localObject = MXo;
    AppMethodBeat.o(3428);
    return localObject;
  }
  
  public final a Ai(final boolean paramBoolean)
  {
    AppMethodBeat.i(3429);
    if ((this.MXq == null) || (this.MXp == null))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject = MXo;
      AppMethodBeat.o(3429);
      return localObject;
    }
    Object localObject = com.tinkerboots.sdk.b.c.getContext();
    if (!com.tinkerboots.sdk.b.b.lM((Context)localObject))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
      localObject = MXo;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if ((!ShareTinkerInternals.isTinkerEnabled(this.MXp.tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences((Context)localObject)))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      localObject = MXo;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if (this.MXp.AWf)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(3425);
          Object localObject1 = a.this.MXq;
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
            if ((bool) || (((com.tinkerboots.sdk.a.a)localObject1).cFS) || (l >= ((com.tinkerboots.sdk.a.a)localObject1).kax))
            {
              ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
              localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).MXx;
              localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).MXv;
              if (localObject1 == null)
              {
                localObject1 = new RuntimeException("callback can't be null");
                AppMethodBeat.o(3425);
                throw ((Throwable)localObject1);
              }
              if (((com.tinkerboots.sdk.a.a.b)localObject1).dfu())
              {
                ((com.tinkerboots.sdk.a.a.b)localObject1).dfv();
                ((com.tinkerboots.sdk.a.a.b)localObject1).an(((com.tinkerboots.sdk.a.b.a)localObject2).MXy.MXz);
              }
            }
            else
            {
              ShareTinkerLog.v("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).kax - l) / 1000L) });
            }
          }
        }
      });
    }
    localObject = MXo;
    AppMethodBeat.o(3429);
    return localObject;
  }
  
  public final a ajC(int paramInt)
  {
    AppMethodBeat.i(3431);
    if (this.MXq == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      locala = MXo;
      AppMethodBeat.o(3431);
      return locala;
    }
    ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    this.MXq.ajD(paramInt);
    a locala = MXo;
    AppMethodBeat.o(3431);
    return locala;
  }
  
  public final a ns(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3430);
    if (this.MXq == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      paramString1 = MXo;
      AppMethodBeat.o(3430);
      return paramString1;
    }
    ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.MXq.nt(paramString1, paramString2);
    paramString1 = MXo;
    AppMethodBeat.o(3430);
    return paramString1;
  }
  
  public static final class a
  {
    public com.tencent.tinker.lib.b.b MDR;
    public com.tencent.tinker.lib.d.c MDS;
    private com.tencent.tinker.lib.d.d MDT;
    private com.tencent.tinker.lib.c.a MXt;
    public Class<? extends AbstractResultService> MXu;
    private com.tinkerboots.sdk.a.a.b MXv;
    private final ApplicationLike cTZ;
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
      this.cTZ = paramApplicationLike;
      AppMethodBeat.o(3426);
    }
    
    public final a a(com.tencent.tinker.lib.d.d paramd)
    {
      AppMethodBeat.i(188693);
      if (this.MDT != null)
      {
        paramd = new TinkerRuntimeException("patchReporter is already set.");
        AppMethodBeat.o(188693);
        throw paramd;
      }
      this.MDT = paramd;
      AppMethodBeat.o(188693);
      return this;
    }
    
    public final a giy()
    {
      AppMethodBeat.i(188694);
      if (this.MDS == null) {
        this.MDS = new com.tinkerboots.sdk.tinker.b.a(this.context);
      }
      if (this.MDT == null) {
        this.MDT = new com.tinkerboots.sdk.tinker.b.c(this.context);
      }
      if (this.MDR == null) {
        this.MDR = new com.tinkerboots.sdk.tinker.b.b(this.context);
      }
      if (this.MXt == null) {
        this.MXt = new g();
      }
      if (this.MXu == null) {
        this.MXu = TinkerServerResultService.class;
      }
      if (this.MXv == null) {
        this.MXv = new com.tinkerboots.sdk.a.a.a();
      }
      a locala = new a(this.context, this.cTZ, this.MDS, this.MDT, this.MDR, this.MXt, this.MXu, this.MXv);
      AppMethodBeat.o(188694);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */