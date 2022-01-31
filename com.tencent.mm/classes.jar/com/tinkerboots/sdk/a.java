package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.a.a;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class a
{
  public static a BLy;
  public final com.tinkerboots.sdk.a.a BLA;
  public final com.tencent.tinker.lib.e.a BLz;
  private final ApplicationLike bXD;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    AppMethodBeat.i(65520);
    com.tinkerboots.sdk.b.c.context = paramContext;
    this.bXD = paramApplicationLike;
    this.BLA = com.tinkerboots.sdk.a.a.a(paramb1);
    paramContext = new a.a(paramApplicationLike.getApplication());
    int i = paramApplicationLike.getTinkerFlags();
    if (paramContext.status != -1)
    {
      paramContext = new TinkerRuntimeException("tinkerFlag is already set.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    paramContext.status = i;
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("loadReporter must not be null.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    if (paramContext.BsO != null)
    {
      paramContext = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    paramContext.BsO = paramc;
    if (paramb == null)
    {
      paramContext = new TinkerRuntimeException("listener must not be null.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    if (paramContext.BsN != null)
    {
      paramContext = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    paramContext.BsN = paramb;
    if (paramd == null)
    {
      paramContext = new TinkerRuntimeException("patchReporter must not be null.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    if (paramContext.BsP != null)
    {
      paramContext = new TinkerRuntimeException("patchReporter is already set.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    paramContext.BsP = paramd;
    paramc = Boolean.valueOf(paramApplicationLike.getTinkerLoadVerifyFlag());
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    if (paramContext.BsX != null)
    {
      paramContext = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    paramContext.BsX = paramc;
    paramContext = paramContext.dWx();
    com.tencent.tinker.lib.e.a.a(paramContext);
    paramc = paramApplicationLike.getTinkerResultIntent();
    com.tencent.tinker.lib.e.a.BsL = true;
    TinkerPatchService.a(parama, paramClass);
    com.tencent.tinker.lib.f.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[] { Boolean.valueOf(ShareTinkerInternals.Ti(paramContext.tinkerFlags)), "1.9.13.1" });
    if (!ShareTinkerInternals.Ti(paramContext.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
      this.BLz = paramContext;
      AppMethodBeat.o(65520);
      return;
    }
    if (paramc == null)
    {
      paramContext = new TinkerRuntimeException("intentResult must not be null.");
      AppMethodBeat.o(65520);
      throw paramContext;
    }
    paramContext.BsT = new com.tencent.tinker.lib.e.d();
    paramd = paramContext.BsT;
    paramb = paramContext.context;
    paramApplicationLike = com.tencent.tinker.lib.e.a.jo(paramb);
    paramd.Btm = ShareIntentUtil.bc(paramc);
    paramd.iHc = ShareIntentUtil.bd(paramc);
    paramd.Btc = ShareIntentUtil.w(paramc, "intent_patch_system_ota");
    paramd.BsZ = ShareIntentUtil.n(paramc, "intent_patch_oat_dir");
    paramd.Btb = "interpet".equals(paramd.BsZ);
    boolean bool2 = paramApplicationLike.snC;
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[] { Integer.valueOf(paramd.Btm), ShareTinkerInternals.aI(paramb), Boolean.valueOf(bool2), Boolean.valueOf(paramd.Btc), Build.FINGERPRINT, paramd.BsZ, Boolean.valueOf(paramd.Btb) });
    paramb = ShareIntentUtil.n(paramc, "intent_patch_old_version");
    parama = ShareIntentUtil.n(paramc, "intent_patch_new_version");
    paramClass = paramApplicationLike.BsM;
    paramb1 = paramApplicationLike.BsQ;
    label611:
    Object localObject;
    boolean bool1;
    if ((paramb != null) && (parama != null))
    {
      if (bool2)
      {
        paramd.BsY = parama;
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[] { paramb, parama, paramd.BsY });
        localObject = SharePatchFileUtil.axb(paramd.BsY);
        if (!ShareTinkerInternals.isNullOrNil((String)localObject))
        {
          paramd.Btd = new File(paramClass.getAbsolutePath() + "/" + (String)localObject);
          paramd.Bte = new File(paramd.Btd.getAbsolutePath(), SharePatchFileUtil.axc(paramd.BsY));
          paramd.Btf = new File(paramd.Btd, "dex");
          paramd.Btg = new File(paramd.Btd, "lib");
          paramd.Bth = new File(paramd.Btd, "res");
          paramd.Bti = new File(paramd.Bth, "resources.apk");
        }
        paramd.patchInfo = new SharePatchInfo(paramb, parama, ShareIntentUtil.w(paramc, "intent_is_protected_app"), false, Build.FINGERPRINT, paramd.BsZ);
        if (paramb.equals(parama)) {
          break label1016;
        }
        bool1 = true;
        label853:
        paramd.Bta = bool1;
      }
    }
    else
    {
      localObject = ShareIntentUtil.be(paramc);
      if (localObject == null) {
        break label1049;
      }
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[] { Integer.valueOf(paramd.Btm) });
      i = -1;
      switch (paramd.Btm)
      {
      default: 
        label944:
        paramApplicationLike.BsO.a((Throwable)localObject, i);
      }
    }
    for (;;)
    {
      paramContext.BsO.a(paramContext.BsM, paramContext.BsT.Btm, paramContext.BsT.iHc);
      if (paramContext.BsU) {
        break;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
      break;
      paramd.BsY = paramb;
      break label611;
      label1016:
      bool1 = false;
      break label853;
      i = -1;
      break label944;
      i = -2;
      break label944;
      i = -3;
      break label944;
      i = -4;
      break label944;
      label1049:
      switch (paramd.Btm)
      {
      default: 
        break;
      case -10000: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
        paramContext = new TinkerRuntimeException("can't get the right intent return code");
        AppMethodBeat.o(65520);
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
        paramApplicationLike.BsO.a(paramb, parama, paramb1);
        break;
      case -5: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
        break;
      case -6: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[] { paramd.BsY });
        paramApplicationLike.BsO.a(paramd.Btd, 1, true);
        break;
      case -7: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[] { paramd.BsY });
        if (paramd.Bte == null)
        {
          paramContext = new TinkerRuntimeException("error load patch version file not exist, but file is null");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        paramApplicationLike.BsO.a(paramd.Bte, 1, false);
        break;
      case -8: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
        if (paramd.Bte == null)
        {
          paramContext = new TinkerRuntimeException("error patch package check fail , but file is null");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        i = paramc.getIntExtra("intent_patch_package_patch_check", -10000);
        paramApplicationLike.BsO.c(paramd.Bte, i);
        break;
      case -9: 
        if (paramd.Btf != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[] { paramd.Btf.getAbsolutePath() });
          paramApplicationLike.BsO.a(paramd.Btf, 3, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -10: 
        paramc = ShareIntentUtil.n(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[] { paramc });
          paramApplicationLike.BsO.a(new File(paramc), 3, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -11: 
        paramc = ShareIntentUtil.n(paramc, "intent_patch_missing_dex_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[] { paramc });
          paramApplicationLike.BsO.a(new File(paramc), 4, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -17: 
        if (paramd.Btd != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[] { paramd.Btg.getAbsolutePath() });
          paramApplicationLike.BsO.a(paramd.Btg, 5, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -18: 
        paramc = ShareIntentUtil.n(paramc, "intent_patch_missing_lib_path");
        if (paramc != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[] { paramc });
          paramApplicationLike.BsO.a(new File(paramc), 5, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -12: 
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
        break;
      case -13: 
        paramc = ShareIntentUtil.n(paramc, "intent_patch_mismatch_dex_path");
        if (paramc == null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[] { paramc });
        paramApplicationLike.BsO.b(new File(paramc), 3);
        break;
      case -19: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
        paramApplicationLike.BsO.a(paramb, parama, paramb1);
        break;
      case -21: 
        if (paramd.Btd != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[] { paramd.Bth.getAbsolutePath() });
          paramApplicationLike.BsO.a(paramd.Bth, 6, true);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -22: 
        if (paramd.Btd != null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[] { paramd.Bti.getAbsolutePath() });
          paramApplicationLike.BsO.a(paramd.Bti, 6, false);
        }
        else
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
          paramContext = new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        break;
      case -24: 
        if (paramd.Bti == null)
        {
          com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
          paramContext = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
          AppMethodBeat.o(65520);
          throw paramContext;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[] { paramd.Bti.getAbsolutePath() });
        paramApplicationLike.BsO.b(paramd.Bti, 6);
        break;
      case -15: 
        paramApplicationLike.BsO.b(1, ShareIntentUtil.bf(paramc));
        break;
      case -16: 
        paramApplicationLike.BsO.b(2, ShareIntentUtil.bf(paramc));
        break;
      case 0: 
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
        paramApplicationLike.BsU = true;
        paramd.Btj = ShareIntentUtil.bg(paramc);
        paramd.Btk = ShareIntentUtil.bh(paramc);
        paramd.Btl = ShareIntentUtil.bi(paramc);
        if (paramd.Btb) {
          paramApplicationLike.BsO.b(0, null);
        }
        if ((bool2) && (paramd.Bta)) {
          paramApplicationLike.BsO.a(paramb, parama, paramClass, paramd.Btd.getName());
        }
        break;
      }
    }
  }
  
  public static a eaJ()
  {
    AppMethodBeat.i(65521);
    if (BLy == null)
    {
      localObject = new TinkerRuntimeException("you must init TinkerClient sdk first");
      AppMethodBeat.o(65521);
      throw ((Throwable)localObject);
    }
    Object localObject = BLy;
    AppMethodBeat.o(65521);
    return localObject;
  }
  
  public final a TO(int paramInt)
  {
    AppMethodBeat.i(65524);
    if (this.BLA == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      locala = BLy;
      AppMethodBeat.o(65524);
      return locala;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    this.BLA.TP(paramInt);
    a locala = BLy;
    AppMethodBeat.o(65524);
    return locala;
  }
  
  public final a ji(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65523);
    if (this.BLA == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      paramString1 = BLy;
      AppMethodBeat.o(65523);
      return paramString1;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.BLA.jj(paramString1, paramString2);
    paramString1 = BLy;
    AppMethodBeat.o(65523);
    return paramString1;
  }
  
  public final a sm(boolean paramBoolean)
  {
    AppMethodBeat.i(65522);
    if ((this.BLA == null) || (this.BLz == null))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject = BLy;
      AppMethodBeat.o(65522);
      return localObject;
    }
    Object localObject = com.tinkerboots.sdk.b.c.getContext();
    if (!com.tinkerboots.sdk.b.b.jZ((Context)localObject))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
      localObject = BLy;
      AppMethodBeat.o(65522);
      return localObject;
    }
    if ((!ShareTinkerInternals.Ti(this.BLz.tinkerFlags)) || (!ShareTinkerInternals.jE((Context)localObject)))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      localObject = BLy;
      AppMethodBeat.o(65522);
      return localObject;
    }
    if (this.BLz.snC)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new a.1(this, paramBoolean));
    }
    localObject = BLy;
    AppMethodBeat.o(65522);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */