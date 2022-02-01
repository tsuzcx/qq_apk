package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.e;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.toolkit.a.f;
import com.tencent.mm.toolkit.a.g;
import com.tinkerboots.sdk.a.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  static
  {
    AppMethodBeat.i(190215);
    j.load("wechathttp");
    AppMethodBeat.o(190215);
  }
  
  public static void a(final Context paramContext, final android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(190213);
    e.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    com.tencent.mm.plugin.hp.net.b localb = new com.tencent.mm.plugin.hp.net.b();
    e.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheck#doSceneSync()");
    localb.syk = new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.c.b paramAnonymousb)
      {
        AppMethodBeat.i(190209);
        e.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          e.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          this.EKZ.set(Math.abs(paramAnonymousInt) + 20);
          paramc.accept(Integer.valueOf(this.EKZ.get()));
          AppMethodBeat.o(190209);
          return;
        }
        e.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.syH)))
        {
          this.EKZ.set(1);
          paramc.accept(Integer.valueOf(this.EKZ.get()));
          AppMethodBeat.o(190209);
          return;
        }
        String str = paramAnonymousb.syH;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.syI;
        a.a(paramContext, str, l, paramAnonymousb, paramc);
        AppMethodBeat.o(190209);
      }
    };
    if (localb.syi == null)
    {
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      localb.syk.a(-3, null);
      AppMethodBeat.o(190213);
      return;
    }
    ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    paramContext = "";
    if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
      paramContext = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(localb.syi, localb.syj, paramContext);
    AppMethodBeat.o(190213);
  }
  
  public static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(190214);
    e.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1);
    File localFile = new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis());
    paramString1.FEx = localFile;
    paramString1.FEw = new File(localFile.getAbsolutePath() + ".tmp");
    paramString1.FEI = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(190210);
        paramAnonymousc = paramAnonymousc.FEx;
        e.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        if (paramAnonymousc.exists())
        {
          this.EKZ.set(0);
          com.tencent.tinker.lib.e.c.cx(paramContext, paramAnonymousc.getAbsolutePath());
          paramc.accept(Integer.valueOf(this.EKZ.get()));
          AppMethodBeat.o(190210);
          return;
        }
        this.EKZ.set(2);
        paramc.accept(Integer.valueOf(this.EKZ.get()));
        AppMethodBeat.o(190210);
      }
      
      public final void cB(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(190211);
        e.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          this.EKZ.set(i);
          paramc.accept(Integer.valueOf(this.EKZ.get()));
          AppMethodBeat.o(190211);
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
      paramString1.FEG = new f(paramString2);
    }
    e.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    paramString2 = new g();
    paramString2.FEQ.fM(paramContext);
    paramString2.e(paramString1);
    AppMethodBeat.o(190214);
  }
  
  static void hs(Context paramContext)
  {
    AppMethodBeat.i(190212);
    com.tinkerboots.sdk.a.a(new a.a(com.tencent.mm.app.d.cKY).a(new com.tencent.tinker.lib.d.b(paramContext)
    {
      public final void e(File paramAnonymousFile, int paramAnonymousInt)
      {
        AppMethodBeat.i(190208);
        super.e(paramAnonymousFile, paramAnonymousInt);
        e.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt != 0) {}
        for (paramAnonymousInt = Math.abs(paramAnonymousInt) + 10;; paramAnonymousInt = 0)
        {
          paramAnonymousFile = com.tencent.mm.ca.h.hy(this.context);
          paramAnonymousFile.ELF = false;
          paramAnonymousFile.ELE = paramAnonymousInt;
          paramAnonymousFile.save();
          AppMethodBeat.o(190208);
          return;
        }
      }
    }).ftN());
    AppMethodBeat.o(190212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recovery.a
 * JD-Core Version:    0.7.0.1
 */