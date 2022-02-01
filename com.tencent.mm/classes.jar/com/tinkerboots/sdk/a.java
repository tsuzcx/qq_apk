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
  public static a SKw;
  public final com.tencent.tinker.lib.e.a SKx;
  public final com.tinkerboots.sdk.a.a SKy;
  private final ApplicationLike dks;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    AppMethodBeat.i(3427);
    com.tinkerboots.sdk.b.c.context = paramContext;
    this.dks = paramApplicationLike;
    this.SKy = com.tinkerboots.sdk.a.a.a(paramb1);
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
    if (paramContext.SjU != null)
    {
      paramContext = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.SjU = paramc;
    if (paramb == null)
    {
      paramContext = new TinkerRuntimeException("listener must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.SjT != null)
    {
      paramContext = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.SjT = paramb;
    if (paramd == null)
    {
      paramContext = new TinkerRuntimeException("patchReporter must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.SjV != null)
    {
      paramContext = new TinkerRuntimeException("patchReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.SjV = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.Skd != null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.Skd = paramc;
    paramContext = paramContext.hpi();
    com.tencent.tinker.lib.e.a.a(paramContext);
    paramc = paramApplicationLike.getTinkerResultIntent();
    com.tencent.tinker.lib.e.a.sInstalled = true;
    TinkerPatchService.a(parama, paramClass);
    ShareTinkerLog.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags)), "1.9.14.10" });
    if (!ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags))
    {
      ShareTinkerLog.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      this.SKx = paramContext;
      AppMethodBeat.o(3427);
      return;
    }
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("intentResult must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.SjZ = new com.tencent.tinker.lib.e.d();
    paramd = paramContext.SjZ;
    paramb = paramContext.context;
    paramApplicationLike = com.tencent.tinker.lib.e.a.lk(paramb);
    paramd.Skq = ShareIntentUtil.getIntentReturnCode(paramc);
    paramd.costTime = ShareIntentUtil.getIntentPatchCostTime(paramc);
    paramd.Skg = ShareIntentUtil.getBooleanExtra(paramc, "intent_patch_system_ota", false);
    paramd.oatDir = ShareIntentUtil.getStringExtra(paramc, "intent_patch_oat_dir");
    paramd.useInterpretMode = "interpet".equals(paramd.oatDir);
    boolean bool2 = paramApplicationLike.FgY;
    ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramd.Skq), ShareTinkerInternals.getProcessName(paramb), Boolean.valueOf(bool2), Boolean.valueOf(paramd.Skg), Build.FINGERPRINT, paramd.oatDir, Boolean.valueOf(paramd.useInterpretMode) });
    paramb = ShareIntentUtil.getStringExtra(paramc, "intent_patch_old_version");
    parama = ShareIntentUtil.getStringExtra(paramc, "intent_patch_new_version");
    paramClass = paramApplicationLike.SjS;
    paramb1 = paramApplicationLike.SjW;
    label624:
    Object localObject;
    boolean bool1;
    if ((paramb != null) && (parama != null))
    {
      if (bool2)
      {
        paramd.Ske = parama;
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramb, parama, paramd.Ske });
        localObject = SharePatchFileUtil.getPatchVersionDirectory(paramd.Ske);
        if (!ShareTinkerInternals.isNullOrNil((String)localObject))
        {
          paramd.Skh = new File(paramClass.getAbsolutePath() + "/" + (String)localObject);
          paramd.Ski = new File(paramd.Skh.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(paramd.Ske));
          paramd.Skj = new File(paramd.Skh, "dex");
          paramd.Skk = new File(paramd.Skh, "lib");
          paramd.Skl = new File(paramd.Skh, "res");
          paramd.Skm = new File(paramd.Skl, "resources.apk");
        }
        paramd.patchInfo = new SharePatchInfo(paramb, parama, ShareIntentUtil.getBooleanExtra(paramc, "intent_is_protected_app", false), false, Build.FINGERPRINT, paramd.oatDir, false);
        if (paramb.equals(parama)) {
          break label1032;
        }
        bool1 = true;
        label868:
        paramd.Skf = bool1;
      }
    }
    else
    {
      localObject = ShareIntentUtil.getIntentPatchException(paramc);
      if (localObject == null) {
        break label1065;
      }
      ShareTinkerLog.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramd.Skq) });
      i = -1;
      switch (paramd.Skq)
      {
      default: 
        label960:
        paramApplicationLike.SjU.a((Throwable)localObject, i);
      }
    }
    for (;;)
    {
      paramContext.SjU.a(paramContext.SjS, paramContext.SjZ.Skq, paramContext.SjZ.costTime);
      if (paramContext.Ska) {
        break;
      }
      ShareTinkerLog.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      break;
      paramd.Ske = paramb;
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
      switch (paramd.Skq)
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
        paramApplicationLike.SjU.b(paramb, parama, paramb1);
        break;
      case -5: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramd.Ske });
        paramApplicationLike.SjU.a(paramd.Skh, 1, true);
        break;
      case -7: 
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramd.Ske });
        if (paramd.Ski == null)
        {
          paramContext = new TinkerRuntimeException("error load patch version file not exist, but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        paramApplicationLike.SjU.a(paramd.Ski, 1, false);
        break;
      case -8: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramd.Ski == null)
        {
          paramContext = new TinkerRuntimeException("error patch package check fail , but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        i = paramc.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.SjU.c(paramd.Ski, i);
        break;
      case -9: 
        if (paramd.Skj != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramd.Skj.getAbsolutePath() });
          paramApplicationLike.SjU.a(paramd.Skj, 3, true);
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
          paramApplicationLike.SjU.a(new File(paramc), 3, false);
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
          paramApplicationLike.SjU.a(new File(paramc), 4, false);
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
        if (paramd.Skh != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramd.Skk.getAbsolutePath() });
          paramApplicationLike.SjU.a(paramd.Skk, 5, true);
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
          paramApplicationLike.SjU.a(new File(paramc), 5, false);
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
        paramApplicationLike.SjU.b(new File(paramc), 3);
        break;
      case -19: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.SjU.b(paramb, parama, paramb1);
        break;
      case -21: 
        if (paramd.Skh != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramd.Skl.getAbsolutePath() });
          paramApplicationLike.SjU.a(paramd.Skl, 6, true);
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
        if (paramd.Skh != null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramd.Skm.getAbsolutePath() });
          paramApplicationLike.SjU.a(paramd.Skm, 6, false);
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
        if (paramd.Skm == null)
        {
          ShareTinkerLog.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          paramContext = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        ShareTinkerLog.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramd.Skm.getAbsolutePath() });
        paramApplicationLike.SjU.b(paramd.Skm, 6);
        break;
      case -15: 
        paramApplicationLike.SjU.b(1, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case -16: 
        paramApplicationLike.SjU.b(2, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case 0: 
        ShareTinkerLog.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.Ska = true;
        paramd.Skn = ShareIntentUtil.getIntentPatchDexPaths(paramc);
        paramd.Sko = ShareIntentUtil.getIntentPatchLibsPaths(paramc);
        paramd.Skp = ShareIntentUtil.getIntentPackageConfig(paramc);
        if (paramd.useInterpretMode) {
          paramApplicationLike.SjU.b(0, null);
        }
        if ((bool2) && (paramd.Skf)) {
          paramApplicationLike.SjU.a(paramb, parama, paramClass, paramd.Skh.getName());
        }
        break;
      }
    }
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(201268);
    if (parama == null)
    {
      parama = new TinkerRuntimeException("TinkerClient init, tinkerClient should not be null.");
      AppMethodBeat.o(201268);
      throw parama;
    }
    if (SKw != null)
    {
      parama = new TinkerRuntimeException("TinkerClient instance is already set.");
      AppMethodBeat.o(201268);
      throw parama;
    }
    SKw = parama;
    AppMethodBeat.o(201268);
    return parama;
  }
  
  public static a hvX()
  {
    AppMethodBeat.i(3428);
    if (SKw == null)
    {
      localObject = new TinkerRuntimeException("you must init TinkerClient sdk first");
      AppMethodBeat.o(3428);
      throw ((Throwable)localObject);
    }
    Object localObject = SKw;
    AppMethodBeat.o(3428);
    return localObject;
  }
  
  public final a Ey(final boolean paramBoolean)
  {
    AppMethodBeat.i(3429);
    if ((this.SKy == null) || (this.SKx == null))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject = SKw;
      AppMethodBeat.o(3429);
      return localObject;
    }
    Object localObject = com.tinkerboots.sdk.b.c.getContext();
    if (!com.tinkerboots.sdk.b.b.lL((Context)localObject))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
      localObject = SKw;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if ((!ShareTinkerInternals.isTinkerEnabled(this.SKx.tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences((Context)localObject)))
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      localObject = SKw;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if (this.SKx.FgY)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(3425);
          Object localObject1 = a.this.SKy;
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
            if ((bool) || (((com.tinkerboots.sdk.a.a)localObject1).cWq) || (l >= ((com.tinkerboots.sdk.a.a)localObject1).ldB))
            {
              ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
              localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).SKF;
              localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).SKD;
              if (localObject1 == null)
              {
                localObject1 = new RuntimeException("callback can't be null");
                AppMethodBeat.o(3425);
                throw ((Throwable)localObject1);
              }
              if (((com.tinkerboots.sdk.a.a.b)localObject1).dZo())
              {
                ((com.tinkerboots.sdk.a.a.b)localObject1).dZp();
                ((com.tinkerboots.sdk.a.a.b)localObject1).ao(((com.tinkerboots.sdk.a.b.a)localObject2).SKG.SKH);
              }
            }
            else
            {
              ShareTinkerLog.v("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).ldB - l) / 1000L) });
            }
          }
        }
      });
    }
    localObject = SKw;
    AppMethodBeat.o(3429);
    return localObject;
  }
  
  public final a atk(int paramInt)
  {
    AppMethodBeat.i(3431);
    if (this.SKy == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      locala = SKw;
      AppMethodBeat.o(3431);
      return locala;
    }
    ShareTinkerLog.v("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    this.SKy.atl(paramInt);
    a locala = SKw;
    AppMethodBeat.o(3431);
    return locala;
  }
  
  public final a ol(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3430);
    if (this.SKy == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      paramString1 = SKw;
      AppMethodBeat.o(3430);
      return paramString1;
    }
    ShareTinkerLog.v("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.SKy.om(paramString1, paramString2);
    paramString1 = SKw;
    AppMethodBeat.o(3430);
    return paramString1;
  }
  
  public static final class a
  {
    private com.tencent.tinker.lib.c.a SKB;
    public Class<? extends AbstractResultService> SKC;
    private com.tinkerboots.sdk.a.a.b SKD;
    public com.tencent.tinker.lib.b.b SjT;
    public com.tencent.tinker.lib.d.c SjU;
    private com.tencent.tinker.lib.d.d SjV;
    private final Context context;
    private final ApplicationLike dks;
    
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
      this.dks = paramApplicationLike;
      AppMethodBeat.o(3426);
    }
    
    public final a a(com.tencent.tinker.lib.d.d paramd)
    {
      AppMethodBeat.i(201266);
      if (this.SjV != null)
      {
        paramd = new TinkerRuntimeException("patchReporter is already set.");
        AppMethodBeat.o(201266);
        throw paramd;
      }
      this.SjV = paramd;
      AppMethodBeat.o(201266);
      return this;
    }
    
    public final a hvY()
    {
      AppMethodBeat.i(201267);
      if (this.SjU == null) {
        this.SjU = new com.tinkerboots.sdk.tinker.b.a(this.context);
      }
      if (this.SjV == null) {
        this.SjV = new com.tinkerboots.sdk.tinker.b.c(this.context);
      }
      if (this.SjT == null) {
        this.SjT = new com.tinkerboots.sdk.tinker.b.b(this.context);
      }
      if (this.SKB == null) {
        this.SKB = new g();
      }
      if (this.SKC == null) {
        this.SKC = TinkerServerResultService.class;
      }
      if (this.SKD == null) {
        this.SKD = new com.tinkerboots.sdk.a.a.a();
      }
      a locala = new a(this.context, this.dks, this.SjU, this.SjV, this.SjT, this.SKB, this.SKC, this.SKD);
      AppMethodBeat.o(201267);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */