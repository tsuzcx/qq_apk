package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.toolkit.a.a.d;
import com.tencent.mm.toolkit.a.g;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  public static void a(final Context paramContext, cxv paramcxv, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(193903);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramcxv = new com.tencent.mm.recovery.a.a(paramcxv);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheckCopycat#doSceneSync()");
    paramcxv.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(193899);
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          com.tencent.mm.recoveryv2.f.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          this.NBe.set(Math.abs(paramAnonymousInt) + 20);
          paramc.accept(Integer.valueOf(this.NBe.get()));
          AppMethodBeat.o(193899);
          return;
        }
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.pkK)))
        {
          this.NBe.set(1);
          paramc.accept(Integer.valueOf(this.NBe.get()));
          AppMethodBeat.o(193899);
          return;
        }
        String str = paramAnonymousb.pkK;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.pkL;
        b.a(paramContext, str, l, paramAnonymousb, paramc, paramBoolean);
        AppMethodBeat.o(193899);
      }
    });
    AppMethodBeat.o(193903);
  }
  
  public static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(193905);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1).T(new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis()));
    paramString1.OvC = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(193900);
        paramAnonymousc = paramAnonymousc.Ovr;
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "download tinker path success");
        if (paramAnonymousc.exists())
        {
          this.NBe.set(0);
          if (paramBoolean) {
            com.tencent.tinker.lib.e.c.cY(paramContext, paramAnonymousc.getAbsolutePath());
          }
          paramc.accept(Integer.valueOf(this.NBe.get()));
          AppMethodBeat.o(193900);
          return;
        }
        this.NBe.set(2);
        paramc.accept(Integer.valueOf(this.NBe.get()));
        AppMethodBeat.o(193900);
      }
      
      public final void df(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(193901);
        com.tencent.mm.recoveryv2.f.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          this.NBe.set(i);
          paramc.accept(Integer.valueOf(this.NBe.get()));
          AppMethodBeat.o(193901);
          return;
          i = j;
          if (paramAnonymousInt >= 1101)
          {
            i = j;
            if (paramAnonymousInt <= 1106) {
              i = paramAnonymousInt - 1101 + 4;
            }
          }
        }
      }
    };
    if (paramLong > 0L) {
      paramString1.mContentLength = paramLong;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.OvA = new com.tencent.mm.toolkit.a.f(paramString2);
    }
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    new g().jG(paramContext).e(paramString1);
    AppMethodBeat.o(193905);
  }
  
  public static void a(Context paramContext, String paramString, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(193904);
    a(paramContext, paramString, 0L, null, paramc, true);
    AppMethodBeat.o(193904);
  }
  
  public static void b(Context paramContext, final android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(193902);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    com.tencent.mm.plugin.expansions.a.cMr();
    com.tencent.mm.plugin.expansions.a.aoa("wechathttp");
    paramc = new android.support.v4.e.c() {};
    String str = com.tencent.mm.loader.j.a.aKw();
    Log.i("MicroMsg.recovery.operator", "baseTinkerId = ".concat(String.valueOf(str)));
    cxv localcxv = new cxv();
    localcxv.MCI = str;
    localcxv.APx = com.tencent.mm.loader.j.a.aKx();
    localcxv.MCJ = com.tencent.mm.recovery.a.b.dZe();
    localcxv.MCJ.add(com.tencent.mm.recovery.a.b.ih("biz-scene", "recovery"));
    localcxv.MCL = 1;
    a(paramContext, localcxv, paramc, true);
    AppMethodBeat.o(193902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recovery.b
 * JD-Core Version:    0.7.0.1
 */