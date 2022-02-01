package com.tencent.mm.plugin.performance.diagnostic;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.backtrace.g.a;
import com.tencent.matrix.backtrace.g.d;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cr;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements c.b
{
  public static final a MIo;
  private static volatile boolean[] MIp;
  private static boolean MIq;
  
  static
  {
    AppMethodBeat.i(300899);
    MIo = new a();
    MIp = new boolean[] { false };
    MIq = true;
    AppMethodBeat.o(300899);
  }
  
  public static boolean Ao(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(300882);
    Log.i("MicroMsg.BacktraceLogic", "setup WeChatBacktrace");
    if (MIp[0] != 0)
    {
      AppMethodBeat.o(300882);
      return true;
    }
    for (;;)
    {
      g.a locala;
      synchronized (MIp)
      {
        if (MIp[0] != 0)
        {
          AppMethodBeat.o(300882);
          return true;
        }
        boolean[] arrayOfBoolean2 = MIp;
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          break label333;
        }
        if (WeChatEnvironment.hasDebugger())
        {
          break label333;
          if ((paramBoolean) || (i != 0)) {
            break label338;
          }
          if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zqI, false))
          {
            break label338;
            if (j != 0) {
              continue;
            }
            Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace not enabled");
            paramBoolean = false;
            arrayOfBoolean2[0] = paramBoolean;
            paramBoolean = MIp[0];
            AppMethodBeat.o(300882);
            return paramBoolean;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        j = 0;
        continue;
        if (i != 0) {
          break label343;
        }
        if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zqJ, false))
        {
          break label343;
          MIq = paramBoolean;
          Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace enabled, pthread quicken %s.", new Object[] { Boolean.valueOf(MIq) });
          locala = com.tencent.matrix.backtrace.g.awo().bQ(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP);
          if (!BuildInfo.IS_ARM64) {
            break label316;
          }
          locala.b(g.d.eNI);
          if (MIq)
          {
            d(locala);
            if (!locala.bBe) {
              locala.eNz = true;
            }
          }
          paramBoolean = bool;
          if (locala.bBe) {
            continue;
          }
          locala.bBe = true;
          com.tencent.matrix.backtrace.g.a(locala.eNH, locala);
          paramBoolean = bool;
        }
      }
      paramBoolean = false;
      continue;
      label316:
      d(locala);
      locala.b(g.d.eNJ);
      continue;
      label333:
      int i = 1;
      continue;
      label338:
      int j = 1;
      continue;
      label343:
      paramBoolean = true;
    }
  }
  
  private static void d(g.a parama)
  {
    AppMethodBeat.i(300893);
    com.tencent.matrix.backtrace.g.a(new b());
    b.setup();
    parama.awq();
    Object localObject2 = com.tencent.mm.kernel.h.baB().bad();
    if (((com.tencent.mm.kernel.b.g)localObject2).bbA()) {
      if (cr.bDz().equalsIgnoreCase(String.format("%x", new Object[] { Integer.valueOf(d.Yxh) }))) {}
    }
    File localFile;
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup client version updated %s", new Object[] { Boolean.valueOf(bool) });
      localFile = h((com.tencent.mm.kernel.b.g)localObject2);
      localObject1 = null;
      if (localFile != null) {
        localObject1 = localFile.getAbsolutePath() + "/lib";
      }
      localObject3 = new HashSet();
      if (localFile == null) {
        break;
      }
      Object localObject4 = new File(localFile, "dex");
      if ((!((File)localObject4).isDirectory()) || (((File)localObject4).listFiles() == null)) {
        break label251;
      }
      localObject4 = ((File)localObject4).listFiles();
      int j = localObject4.length;
      int i = 0;
      while (i < j)
      {
        ((Set)localObject3).add(new File(SharePatchFileUtil.optimizedPathFor(localObject4[i], new File(localFile, "odex"))).getAbsolutePath());
        i += 1;
      }
    }
    ((Set)localObject3).add(com.tencent.matrix.backtrace.g.bP(((com.tencent.mm.kernel.b.g)localObject2).bGP));
    label251:
    Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup odex path %s", new Object[] { localObject3 });
    localObject2 = ((com.tencent.mm.kernel.b.g)localObject2).bGP.getApplicationInfo().nativeLibraryDir;
    Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup native library path %s", new Object[] { localObject2 });
    if (localObject1 != null) {
      Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup tinker native library path %s", new Object[] { localObject1 });
    }
    Object localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      parama.gj((String)((Iterator)localObject3).next());
    }
    if (localFile != null) {}
    for (;;)
    {
      parama.gj((String)localObject1).gj(com.tencent.matrix.backtrace.g.awn()).gk((String)localObject1 + "/libwechatxlog.so").aws().awr().dw(bool);
      AppMethodBeat.o(300893);
      return;
      localObject1 = localObject2;
    }
  }
  
  private static File h(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(300872);
    if (!paramg.bbA())
    {
      AppMethodBeat.o(300872);
      return null;
    }
    Object localObject = ((com.tencent.mm.kernel.b.h)paramg).mFT.getTinkerResultIntent();
    if (localObject == null)
    {
      AppMethodBeat.o(300872);
      return null;
    }
    if (ShareIntentUtil.getIntentReturnCode((Intent)localObject) != 0)
    {
      AppMethodBeat.o(300872);
      return null;
    }
    localObject = ShareIntentUtil.getStringExtra((Intent)localObject, "intent_patch_new_version");
    if (localObject == null)
    {
      AppMethodBeat.o(300872);
      return null;
    }
    paramg = SharePatchFileUtil.getPatchDirectory(paramg.bGP);
    if (paramg == null)
    {
      AppMethodBeat.o(300872);
      return null;
    }
    paramg = new File(paramg.getAbsolutePath(), SharePatchFileUtil.getPatchVersionDirectory((String)localObject));
    AppMethodBeat.o(300872);
    return paramg;
  }
  
  public final void gyb()
  {
    AppMethodBeat.i(300902);
    try
    {
      Ao(true);
      AppMethodBeat.o(300902);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.BacktraceLogic", localThrowable, "", new Object[0]);
      AppMethodBeat.o(300902);
    }
  }
  
  public final void gyc()
  {
    AppMethodBeat.i(300909);
    if (MIq)
    {
      PthreadHook localPthreadHook = PthreadHook.eVl;
      localPthreadHook.eVn = true;
      if (localPthreadHook.mConfigured) {
        localPthreadHook.enableQuickenNative(localPthreadHook.eVn);
      }
    }
    AppMethodBeat.o(300909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */