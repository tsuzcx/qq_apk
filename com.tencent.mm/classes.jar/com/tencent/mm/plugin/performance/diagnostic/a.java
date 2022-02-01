package com.tencent.mm.plugin.performance.diagnostic;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.backtrace.g.a;
import com.tencent.matrix.backtrace.g.d;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cq;
import com.tencent.mm.plugin.expt.b.b.a;
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
  public static final a GLt;
  private static volatile boolean[] GLu;
  private static boolean GLv;
  
  static
  {
    AppMethodBeat.i(201684);
    GLt = new a();
    GLu = new boolean[] { false };
    GLv = true;
    AppMethodBeat.o(201684);
  }
  
  private static void d(g.a parama)
  {
    AppMethodBeat.i(201678);
    com.tencent.matrix.backtrace.g.a(new b());
    b.setup();
    parama.VG();
    Object localObject2 = com.tencent.mm.kernel.h.aHD().aHf();
    if (((com.tencent.mm.kernel.b.g)localObject2).aIE()) {
      if (cq.bfI().equalsIgnoreCase(String.format("%x", new Object[] { Integer.valueOf(d.RAD) }))) {}
    }
    File localFile;
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup client version updated %s", new Object[] { Boolean.valueOf(bool) });
      localFile = g((com.tencent.mm.kernel.b.g)localObject2);
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
    ((Set)localObject3).add(com.tencent.matrix.backtrace.g.bf(((com.tencent.mm.kernel.b.g)localObject2).Zw));
    label251:
    Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup odex path %s", new Object[] { localObject3 });
    localObject2 = ((com.tencent.mm.kernel.b.g)localObject2).Zw.getApplicationInfo().nativeLibraryDir;
    Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup native library path %s", new Object[] { localObject2 });
    if (localObject1 != null) {
      Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace setup tinker native library path %s", new Object[] { localObject1 });
    }
    Object localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      parama.eK((String)((Iterator)localObject3).next());
    }
    if (localFile != null) {}
    for (;;)
    {
      parama.eK((String)localObject1).eK(com.tencent.matrix.backtrace.g.VD()).eL((String)localObject1 + "/libwechatxlog.so").VI().VH().cP(bool);
      AppMethodBeat.o(201678);
      return;
      localObject1 = localObject2;
    }
  }
  
  private static File g(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(201653);
    if (!paramg.aIE())
    {
      AppMethodBeat.o(201653);
      return null;
    }
    Object localObject = ((com.tencent.mm.kernel.b.h)paramg).kfv.getTinkerResultIntent();
    if (localObject == null)
    {
      AppMethodBeat.o(201653);
      return null;
    }
    if (ShareIntentUtil.getIntentReturnCode((Intent)localObject) != 0)
    {
      AppMethodBeat.o(201653);
      return null;
    }
    localObject = ShareIntentUtil.getStringExtra((Intent)localObject, "intent_patch_new_version");
    if (localObject == null)
    {
      AppMethodBeat.o(201653);
      return null;
    }
    paramg = SharePatchFileUtil.getPatchDirectory(paramg.Zw);
    if (paramg == null)
    {
      AppMethodBeat.o(201653);
      return null;
    }
    paramg = new File(paramg.getAbsolutePath(), SharePatchFileUtil.getPatchVersionDirectory((String)localObject));
    AppMethodBeat.o(201653);
    return paramg;
  }
  
  public static boolean vS(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(201666);
    Log.i("MicroMsg.BacktraceLogic", "setup WeChatBacktrace");
    if (GLu[0] != 0)
    {
      AppMethodBeat.o(201666);
      return true;
    }
    for (;;)
    {
      g.a locala;
      synchronized (GLu)
      {
        if (GLu[0] != 0)
        {
          AppMethodBeat.o(201666);
          return true;
        }
        boolean[] arrayOfBoolean2 = GLu;
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          break label343;
        }
        if (WeChatEnvironment.hasDebugger())
        {
          break label343;
          if ((paramBoolean) || (i != 0)) {
            break label348;
          }
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXT, false))
          {
            break label348;
            if (j != 0) {
              continue;
            }
            Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace not enabled");
            paramBoolean = false;
            arrayOfBoolean2[0] = paramBoolean;
            paramBoolean = GLu[0];
            AppMethodBeat.o(201666);
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
          break label353;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXU, false))
        {
          break label353;
          GLv = paramBoolean;
          Log.i("MicroMsg.BacktraceLogic", "WeChat backtrace enabled, pthread quicken %s.", new Object[] { Boolean.valueOf(GLv) });
          locala = com.tencent.matrix.backtrace.g.VE().bg(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw);
          if (!BuildInfo.IS_ARM64) {
            break label326;
          }
          locala.b(g.d.cSs);
          if (GLv)
          {
            d(locala);
            if (!locala.UY) {
              locala.cSi = true;
            }
          }
          paramBoolean = bool;
          if (locala.UY) {
            continue;
          }
          locala.UY = true;
          com.tencent.matrix.backtrace.g.a(locala.cSr, locala);
          paramBoolean = bool;
        }
      }
      paramBoolean = false;
      continue;
      label326:
      d(locala);
      locala.b(g.d.cSt);
      continue;
      label343:
      int i = 1;
      continue;
      label348:
      int j = 1;
      continue;
      label353:
      paramBoolean = true;
    }
  }
  
  public final void fno()
  {
    AppMethodBeat.i(201680);
    try
    {
      vS(true);
      AppMethodBeat.o(201680);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.BacktraceLogic", localThrowable, "", new Object[0]);
      AppMethodBeat.o(201680);
    }
  }
  
  public final void fnp()
  {
    AppMethodBeat.i(201682);
    if (GLv)
    {
      PthreadHook localPthreadHook = PthreadHook.cYv;
      localPthreadHook.cYx = true;
      if (localPthreadHook.mConfigured) {
        localPthreadHook.enableQuickenNative(localPthreadHook.cYx);
      }
    }
    AppMethodBeat.o(201682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */