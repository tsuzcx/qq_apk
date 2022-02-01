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
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;
import java.io.File;

public final class a
{
  public static a IWj;
  public final com.tencent.tinker.lib.e.a IWk;
  public final com.tinkerboots.sdk.a.a IWl;
  private final ApplicationLike cKY;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    AppMethodBeat.i(3427);
    com.tinkerboots.sdk.b.c.context = paramContext;
    this.cKY = paramApplicationLike;
    this.IWl = com.tinkerboots.sdk.a.a.a(paramb1);
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
    if (paramContext.IEL != null)
    {
      paramContext = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.IEL = paramc;
    if (paramb == null)
    {
      paramContext = new TinkerRuntimeException("listener must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.IEK != null)
    {
      paramContext = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.IEK = paramb;
    if (paramd == null)
    {
      paramContext = new TinkerRuntimeException("patchReporter must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.IEM != null)
    {
      paramContext = new TinkerRuntimeException("patchReporter is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.IEM = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    if (paramContext.IEU != null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.IEU = paramc;
    paramContext = paramContext.fpc();
    com.tencent.tinker.lib.e.a.a(paramContext);
    paramc = paramApplicationLike.getTinkerResultIntent();
    com.tencent.tinker.lib.e.a.sInstalled = true;
    TinkerPatchService.a(parama, paramClass);
    com.tencent.tinker.lib.f.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags)), "1.9.14.6-INTERNALv1-mz" });
    if (!ShareTinkerInternals.isTinkerEnabled(paramContext.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      this.IWk = paramContext;
      AppMethodBeat.o(3427);
      return;
    }
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("intentResult must not be null.");
      AppMethodBeat.o(3427);
      throw paramContext;
    }
    paramContext.IEQ = new com.tencent.tinker.lib.e.d();
    paramd = paramContext.IEQ;
    paramb = paramContext.context;
    paramApplicationLike = com.tencent.tinker.lib.e.a.kI(paramb);
    paramd.IFh = ShareIntentUtil.getIntentReturnCode(paramc);
    paramd.lrf = ShareIntentUtil.getIntentPatchCostTime(paramc);
    paramd.IEX = ShareIntentUtil.getBooleanExtra(paramc, "intent_patch_system_ota", false);
    paramd.oatDir = ShareIntentUtil.getStringExtra(paramc, "intent_patch_oat_dir");
    paramd.useInterpretMode = "interpet".equals(paramd.oatDir);
    boolean bool2 = paramApplicationLike.xZI;
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramd.IFh), ShareTinkerInternals.getProcessName(paramb), Boolean.valueOf(bool2), Boolean.valueOf(paramd.IEX), Build.FINGERPRINT, paramd.oatDir, Boolean.valueOf(paramd.useInterpretMode) });
    paramb = ShareIntentUtil.getStringExtra(paramc, "intent_patch_old_version");
    parama = ShareIntentUtil.getStringExtra(paramc, "intent_patch_new_version");
    paramClass = paramApplicationLike.IEJ;
    paramb1 = paramApplicationLike.IEN;
    label624:
    Object localObject;
    boolean bool1;
    if ((paramb != null) && (parama != null))
    {
      if (bool2)
      {
        paramd.IEV = parama;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramb, parama, paramd.IEV });
        localObject = SharePatchFileUtil.getPatchVersionDirectory(paramd.IEV);
        if (!ShareTinkerInternals.isNullOrNil((String)localObject))
        {
          paramd.IEY = new File(paramClass.getAbsolutePath() + "/" + (String)localObject);
          paramd.IEZ = new File(paramd.IEY.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(paramd.IEV));
          paramd.IFa = new File(paramd.IEY, "dex");
          paramd.IFb = new File(paramd.IEY, "lib");
          paramd.IFc = new File(paramd.IEY, "res");
          paramd.IFd = new File(paramd.IFc, "resources.apk");
        }
        paramd.patchInfo = new SharePatchInfo(paramb, parama, ShareIntentUtil.getBooleanExtra(paramc, "intent_is_protected_app", false), false, Build.FINGERPRINT, paramd.oatDir);
        if (paramb.equals(parama)) {
          break label1032;
        }
        bool1 = true;
        label867:
        paramd.IEW = bool1;
      }
    }
    else
    {
      localObject = ShareIntentUtil.getIntentPatchException(paramc);
      if (localObject == null) {
        break label1065;
      }
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramd.IFh) });
      i = -1;
      switch (paramd.IFh)
      {
      default: 
        label960:
        paramApplicationLike.IEL.a((Throwable)localObject, i);
      }
    }
    for (;;)
    {
      paramContext.IEL.a(paramContext.IEJ, paramContext.IEQ.IFh, paramContext.IEQ.lrf);
      if (paramContext.IER) {
        break;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      break;
      paramd.IEV = paramb;
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
      switch (paramd.IFh)
      {
      default: 
        break;
      case -10000: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
        paramContext = new TinkerRuntimeException("can't get the right intent return code");
        AppMethodBeat.o(3427);
        throw paramContext;
      case -1: 
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
        break;
      case -3: 
      case -2: 
        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
        break;
      case -4: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
        paramApplicationLike.IEL.b(paramb, parama, paramb1);
        break;
      case -5: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramd.IEV });
        paramApplicationLike.IEL.a(paramd.IEY, 1, true);
        break;
      case -7: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramd.IEV });
        if (paramd.IEZ == null)
        {
          paramContext = new TinkerRuntimeException("error load patch version file not exist, but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        paramApplicationLike.IEL.a(paramd.IEZ, 1, false);
        break;
      case -8: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramd.IEZ == null)
        {
          paramContext = new TinkerRuntimeException("error patch package check fail , but file is null");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        i = paramc.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.IEL.c(paramd.IEZ, i);
        break;
      case -9: 
        if (paramd.IFa != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramd.IFa.getAbsolutePath() });
          paramApplicationLike.IEL.a(paramd.IFa, 3, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -10: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[] { paramc });
          paramApplicationLike.IEL.a(new File(paramc), 3, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -11: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[] { paramc });
          paramApplicationLike.IEL.a(new File(paramc), 4, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -17: 
        if (paramd.IEY != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramd.IFb.getAbsolutePath() });
          paramApplicationLike.IEL.a(paramd.IFb, 5, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -18: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_missing_lib_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[] { paramc });
          paramApplicationLike.IEL.a(new File(paramc), 5, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -12: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
        break;
      case -13: 
        paramc = ShareIntentUtil.getStringExtra(paramc, "intent_patch_mismatch_dex_path");
        if (paramc == null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[] { paramc });
        paramApplicationLike.IEL.b(new File(paramc), 3);
        break;
      case -19: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.IEL.b(paramb, parama, paramb1);
        break;
      case -21: 
        if (paramd.IEY != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramd.IFc.getAbsolutePath() });
          paramApplicationLike.IEL.a(paramd.IFc, 6, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -22: 
        if (paramd.IEY != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramd.IFd.getAbsolutePath() });
          paramApplicationLike.IEL.a(paramd.IFd, 6, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        break;
      case -24: 
        if (paramd.IFd == null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          paramContext = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
          AppMethodBeat.o(3427);
          throw paramContext;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramd.IFd.getAbsolutePath() });
        paramApplicationLike.IEL.b(paramd.IFd, 6);
        break;
      case -15: 
        paramApplicationLike.IEL.b(1, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case -16: 
        paramApplicationLike.IEL.b(2, ShareIntentUtil.getIntentInterpretException(paramc));
        break;
      case 0: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.IER = true;
        paramd.IFe = ShareIntentUtil.getIntentPatchDexPaths(paramc);
        paramd.IFf = ShareIntentUtil.getIntentPatchLibsPaths(paramc);
        paramd.IFg = ShareIntentUtil.getIntentPackageConfig(paramc);
        if (paramd.useInterpretMode) {
          paramApplicationLike.IEL.b(0, null);
        }
        if ((bool2) && (paramd.IEW)) {
          paramApplicationLike.IEL.a(paramb, parama, paramClass, paramd.IEY.getName());
        }
        break;
      }
    }
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(189820);
    if (parama == null)
    {
      parama = new TinkerRuntimeException("TinkerClient init, tinkerClient should not be null.");
      AppMethodBeat.o(189820);
      throw parama;
    }
    if (IWj != null)
    {
      parama = new TinkerRuntimeException("TinkerClient instance is already set.");
      AppMethodBeat.o(189820);
      throw parama;
    }
    IWj = parama;
    AppMethodBeat.o(189820);
    return parama;
  }
  
  public static a ftM()
  {
    AppMethodBeat.i(3428);
    if (IWj == null)
    {
      localObject = new TinkerRuntimeException("you must init TinkerClient sdk first");
      AppMethodBeat.o(3428);
      throw ((Throwable)localObject);
    }
    Object localObject = IWj;
    AppMethodBeat.o(3428);
    return localObject;
  }
  
  public final a adw(int paramInt)
  {
    AppMethodBeat.i(3431);
    if (this.IWl == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      locala = IWj;
      AppMethodBeat.o(3431);
      return locala;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    this.IWl.adx(paramInt);
    a locala = IWj;
    AppMethodBeat.o(3431);
    return locala;
  }
  
  public final a mn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3430);
    if (this.IWl == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      paramString1 = IWj;
      AppMethodBeat.o(3430);
      return paramString1;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.IWl.mo(paramString1, paramString2);
    paramString1 = IWj;
    AppMethodBeat.o(3430);
    return paramString1;
  }
  
  public final a xP(final boolean paramBoolean)
  {
    AppMethodBeat.i(3429);
    if ((this.IWl == null) || (this.IWk == null))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject = IWj;
      AppMethodBeat.o(3429);
      return localObject;
    }
    Object localObject = com.tinkerboots.sdk.b.c.getContext();
    if (!com.tinkerboots.sdk.b.b.lg((Context)localObject))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
      localObject = IWj;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if ((!ShareTinkerInternals.isTinkerEnabled(this.IWk.tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences((Context)localObject)))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      localObject = IWj;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if (this.IWk.xZI)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(3425);
          Object localObject1 = a.this.IWl;
          boolean bool = paramBoolean;
          Object localObject2 = com.tinkerboots.sdk.b.c.getContext().getSharedPreferences("patch_server_config", 0);
          long l = ((SharedPreferences)localObject2).getLong("fetch_patch_last_check", 0L);
          if (l == -1L) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
          }
          for (;;)
          {
            AppMethodBeat.o(3425);
            return false;
            l = System.currentTimeMillis() - l;
            if ((bool) || (((com.tinkerboots.sdk.a.a)localObject1).cxf) || (l >= ((com.tinkerboots.sdk.a.a)localObject1).jcZ))
            {
              ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
              localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).IWs;
              localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).IWq;
              if (localObject1 == null)
              {
                localObject1 = new RuntimeException("callback can't be null");
                AppMethodBeat.o(3425);
                throw ((Throwable)localObject1);
              }
              if (((com.tinkerboots.sdk.a.a.b)localObject1).cGi())
              {
                ((com.tinkerboots.sdk.a.a.b)localObject1).cGj();
                ((com.tinkerboots.sdk.a.a.b)localObject1).ab(((com.tinkerboots.sdk.a.b.a)localObject2).IWt.IWu);
              }
            }
            else
            {
              com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).jcZ - l) / 1000L) });
            }
          }
        }
      });
    }
    localObject = IWj;
    AppMethodBeat.o(3429);
    return localObject;
  }
  
  public static final class a
  {
    public com.tencent.tinker.lib.b.b IEK;
    public com.tencent.tinker.lib.d.c IEL;
    private com.tencent.tinker.lib.d.d IEM;
    private com.tencent.tinker.lib.c.a IWo;
    public Class<? extends AbstractResultService> IWp;
    private com.tinkerboots.sdk.a.a.b IWq;
    private final ApplicationLike cKY;
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
      this.cKY = paramApplicationLike;
      AppMethodBeat.o(3426);
    }
    
    public final a a(com.tencent.tinker.lib.d.d paramd)
    {
      AppMethodBeat.i(189818);
      if (this.IEM != null)
      {
        paramd = new TinkerRuntimeException("patchReporter is already set.");
        AppMethodBeat.o(189818);
        throw paramd;
      }
      this.IEM = paramd;
      AppMethodBeat.o(189818);
      return this;
    }
    
    public final a ftN()
    {
      AppMethodBeat.i(189819);
      if (this.IEL == null) {
        this.IEL = new com.tinkerboots.sdk.tinker.b.a(this.context);
      }
      if (this.IEM == null) {
        this.IEM = new com.tinkerboots.sdk.tinker.b.c(this.context);
      }
      if (this.IEK == null) {
        this.IEK = new com.tinkerboots.sdk.tinker.b.b(this.context);
      }
      if (this.IWo == null) {
        this.IWo = new g();
      }
      if (this.IWp == null) {
        this.IWp = TinkerServerResultService.class;
      }
      if (this.IWq == null) {
        this.IWq = new com.tinkerboots.sdk.a.a.a();
      }
      a locala = new a(this.context, this.cKY, this.IEL, this.IEM, this.IEK, this.IWo, this.IWp, this.IWq);
      AppMethodBeat.o(189819);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */