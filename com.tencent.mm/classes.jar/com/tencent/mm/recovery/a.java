package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.e;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.toolkit.a.f;
import com.tencent.mm.toolkit.a.g;
import com.tinkerboots.sdk.a.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  static
  {
    AppMethodBeat.i(194725);
    j.load("wechathttp");
    AppMethodBeat.o(194725);
  }
  
  public static void a(final Context paramContext, final android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(194723);
    e.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    com.tencent.mm.plugin.hp.net.b localb = new com.tencent.mm.plugin.hp.net.b();
    e.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheck#doSceneSync()");
    localb.tFZ = new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.c.b paramAnonymousb)
      {
        AppMethodBeat.i(194719);
        e.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          e.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          this.Gil.set(Math.abs(paramAnonymousInt) + 20);
          paramc.accept(Integer.valueOf(this.Gil.get()));
          AppMethodBeat.o(194719);
          return;
        }
        e.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.gnO)))
        {
          this.Gil.set(1);
          paramc.accept(Integer.valueOf(this.Gil.get()));
          AppMethodBeat.o(194719);
          return;
        }
        String str = paramAnonymousb.gnO;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.ntk;
        a.a(paramContext, str, l, paramAnonymousb, paramc);
        AppMethodBeat.o(194719);
      }
    };
    if (localb.tFX == null)
    {
      ac.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      localb.tFZ.a(-3, null);
      AppMethodBeat.o(194723);
      return;
    }
    ac.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    paramContext = "";
    if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
      paramContext = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(localb.tFX, localb.tFY, paramContext);
    AppMethodBeat.o(194723);
  }
  
  public static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(194724);
    e.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1);
    File localFile = new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis());
    paramString1.HdA = localFile;
    paramString1.Hdz = new File(localFile.getAbsolutePath() + ".tmp");
    paramString1.HdL = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(194720);
        paramAnonymousc = paramAnonymousc.HdA;
        e.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        if (paramAnonymousc.exists())
        {
          this.Gil.set(0);
          com.tencent.tinker.lib.e.c.cz(paramContext, paramAnonymousc.getAbsolutePath());
          paramc.accept(Integer.valueOf(this.Gil.get()));
          AppMethodBeat.o(194720);
          return;
        }
        this.Gil.set(2);
        paramc.accept(Integer.valueOf(this.Gil.get()));
        AppMethodBeat.o(194720);
      }
      
      public final void cE(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(194721);
        e.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          this.Gil.set(i);
          paramc.accept(Integer.valueOf(this.Gil.get()));
          AppMethodBeat.o(194721);
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
      paramString1.HdJ = new f(paramString2);
    }
    e.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    paramString2 = new g();
    paramString2.HdT.fX(paramContext);
    paramString2.e(paramString1);
    AppMethodBeat.o(194724);
  }
  
  static void hD(Context paramContext)
  {
    AppMethodBeat.i(194722);
    com.tinkerboots.sdk.a.a(new a.a(com.tencent.mm.app.d.cIg).a(new com.tencent.tinker.lib.d.b(paramContext)
    {
      public final void e(File paramAnonymousFile, int paramAnonymousInt)
      {
        AppMethodBeat.i(194718);
        super.e(paramAnonymousFile, paramAnonymousInt);
        e.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt != 0) {}
        for (paramAnonymousInt = Math.abs(paramAnonymousInt) + 10;; paramAnonymousInt = 0)
        {
          paramAnonymousFile = com.tencent.mm.bz.h.hJ(this.context);
          paramAnonymousFile.GiR = false;
          paramAnonymousFile.GiQ = paramAnonymousInt;
          paramAnonymousFile.save();
          AppMethodBeat.o(194718);
          return;
        }
      }
    }).fMy());
    AppMethodBeat.o(194722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.a
 * JD-Core Version:    0.7.0.1
 */