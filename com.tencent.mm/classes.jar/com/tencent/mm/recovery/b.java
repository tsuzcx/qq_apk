package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.plugin.hp.net.e;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.toolkit.a.g;
import com.tinkerboots.sdk.a.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  static
  {
    AppMethodBeat.i(192833);
    j.load("wechathttp");
    AppMethodBeat.o(192833);
  }
  
  public static void a(Context paramContext, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(192827);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    a(paramContext, null, paramc, true);
    AppMethodBeat.o(192827);
  }
  
  private static void a(final Context paramContext, cgu paramcgu, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(192829);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramcgu = new com.tencent.mm.plugin.hp.net.b(paramcgu);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheck#doSceneSync()");
    paramcgu.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(192823);
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          com.tencent.mm.recoveryv2.f.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          this.HTz.set(Math.abs(paramAnonymousInt) + 20);
          paramc.accept(Integer.valueOf(this.HTz.get()));
          AppMethodBeat.o(192823);
          return;
        }
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.gHx)))
        {
          this.HTz.set(1);
          paramc.accept(Integer.valueOf(this.HTz.get()));
          AppMethodBeat.o(192823);
          return;
        }
        String str = paramAnonymousb.gHx;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.nUg;
        b.b(paramContext, str, l, paramAnonymousb, paramc, paramBoolean);
        AppMethodBeat.o(192823);
      }
    });
    AppMethodBeat.o(192829);
  }
  
  private static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(192831);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1).T(new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis()));
    paramString1.IRb = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(192824);
        paramAnonymousc = paramAnonymousc.IQQ;
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "download tinker path success");
        if (paramAnonymousc.exists())
        {
          this.HTz.set(0);
          if (paramBoolean) {
            com.tencent.tinker.lib.e.c.cD(paramContext, paramAnonymousc.getAbsolutePath());
          }
          paramc.accept(Integer.valueOf(this.HTz.get()));
          AppMethodBeat.o(192824);
          return;
        }
        this.HTz.set(2);
        paramc.accept(Integer.valueOf(this.HTz.get()));
        AppMethodBeat.o(192824);
      }
      
      public final void cL(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(192825);
        com.tencent.mm.recoveryv2.f.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          this.HTz.set(i);
          paramc.accept(Integer.valueOf(this.HTz.get()));
          AppMethodBeat.o(192825);
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
      paramString1.IQZ = new com.tencent.mm.toolkit.a.f(paramString2);
    }
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    new g().jD(paramContext).e(paramString1);
    AppMethodBeat.o(192831);
  }
  
  public static void a(Context paramContext, String paramString, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(192828);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#fetchTinkerPatchForTest");
    cgu localcgu = new cgu();
    localcgu.Hak = paramString;
    localcgu.wDT = com.tencent.mm.loader.j.a.arI();
    localcgu.Hal = e.dcs();
    localcgu.Han = 1;
    a(paramContext, localcgu, paramc, false);
    AppMethodBeat.o(192828);
  }
  
  public static void b(Context paramContext, String paramString, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(192830);
    a(paramContext, paramString, 0L, null, paramc, true);
    AppMethodBeat.o(192830);
  }
  
  public static void fgU() {}
  
  static void hI(Context paramContext)
  {
    AppMethodBeat.i(192826);
    com.tinkerboots.sdk.a.a(new a.a(com.tencent.mm.app.d.cTo).a(new com.tencent.tinker.lib.d.b(paramContext)
    {
      public final void e(File paramAnonymousFile, int paramAnonymousInt)
      {
        AppMethodBeat.i(192822);
        super.e(paramAnonymousFile, paramAnonymousInt);
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt != 0) {}
        for (paramAnonymousInt = Math.abs(paramAnonymousInt) + 10;; paramAnonymousInt = 0)
        {
          paramAnonymousFile = i.hR(this.context);
          paramAnonymousFile.HUs = false;
          paramAnonymousFile.HUr = paramAnonymousInt;
          paramAnonymousFile.save();
          AppMethodBeat.o(192822);
          return;
        }
      }
    }).gdV());
    AppMethodBeat.o(192826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recovery.b
 * JD-Core Version:    0.7.0.1
 */