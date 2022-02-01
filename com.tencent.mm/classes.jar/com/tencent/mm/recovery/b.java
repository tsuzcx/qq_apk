package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.plugin.hp.net.e;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.toolkit.a.g;
import com.tinkerboots.sdk.a.a;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  static
  {
    AppMethodBeat.i(186156);
    j.load("wechathttp");
    AppMethodBeat.o(186156);
  }
  
  public static void a(Context paramContext, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(186150);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    String str = com.tencent.mm.loader.j.a.arW();
    ae.i("MicroMsg.recovery.operator", "baseTinkerId = ".concat(String.valueOf(str)));
    cho localcho = new cho();
    localcho.HtK = str;
    localcho.wTE = com.tencent.mm.loader.j.a.arX();
    localcho.HtL = e.dfk();
    localcho.HtL.add(e.hz("biz-scene", "recovery"));
    localcho.HtN = 1;
    a(paramContext, localcho, paramc, true);
    AppMethodBeat.o(186150);
  }
  
  private static void a(final Context paramContext, cho paramcho, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(186152);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramcho = new com.tencent.mm.plugin.hp.net.b(paramcho);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheck#doSceneSync()");
    paramcho.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(186146);
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          com.tencent.mm.recoveryv2.f.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          this.InG.set(Math.abs(paramAnonymousInt) + 20);
          paramc.accept(Integer.valueOf(this.InG.get()));
          AppMethodBeat.o(186146);
          return;
        }
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.gKg)))
        {
          this.InG.set(1);
          paramc.accept(Integer.valueOf(this.InG.get()));
          AppMethodBeat.o(186146);
          return;
        }
        String str = paramAnonymousb.gKg;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.nZM;
        b.b(paramContext, str, l, paramAnonymousb, paramc, paramBoolean);
        AppMethodBeat.o(186146);
      }
    });
    AppMethodBeat.o(186152);
  }
  
  private static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(186154);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1).T(new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis()));
    paramString1.JlJ = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(186147);
        paramAnonymousc = paramAnonymousc.Jly;
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "download tinker path success");
        if (paramAnonymousc.exists())
        {
          this.InG.set(0);
          if (paramBoolean) {
            com.tencent.tinker.lib.e.c.cE(paramContext, paramAnonymousc.getAbsolutePath());
          }
          paramc.accept(Integer.valueOf(this.InG.get()));
          AppMethodBeat.o(186147);
          return;
        }
        this.InG.set(2);
        paramc.accept(Integer.valueOf(this.InG.get()));
        AppMethodBeat.o(186147);
      }
      
      public final void cL(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(186148);
        com.tencent.mm.recoveryv2.f.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          this.InG.set(i);
          paramc.accept(Integer.valueOf(this.InG.get()));
          AppMethodBeat.o(186148);
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
      paramString1.JlH = new com.tencent.mm.toolkit.a.f(paramString2);
    }
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    new g().jK(paramContext).e(paramString1);
    AppMethodBeat.o(186154);
  }
  
  public static void a(Context paramContext, String paramString, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(186151);
    com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#fetchTinkerPatchForTest");
    cho localcho = new cho();
    localcho.HtK = paramString;
    localcho.wTE = com.tencent.mm.loader.j.a.arX();
    localcho.HtL = e.dfk();
    localcho.HtN = 1;
    a(paramContext, localcho, paramc, false);
    AppMethodBeat.o(186151);
  }
  
  public static void b(Context paramContext, String paramString, android.support.v4.e.c<Integer> paramc)
  {
    AppMethodBeat.i(186153);
    a(paramContext, paramString, 0L, null, paramc, true);
    AppMethodBeat.o(186153);
  }
  
  public static void fkM() {}
  
  static void hO(Context paramContext)
  {
    AppMethodBeat.i(186149);
    com.tinkerboots.sdk.a.a(new a.a(com.tencent.mm.app.d.cTZ).a(new com.tencent.tinker.lib.d.b(paramContext)
    {
      public final void e(File paramAnonymousFile, int paramAnonymousInt)
      {
        AppMethodBeat.i(186145);
        super.e(paramAnonymousFile, paramAnonymousInt);
        com.tencent.mm.recoveryv2.f.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt != 0) {}
        for (paramAnonymousInt = Math.abs(paramAnonymousInt) + 10;; paramAnonymousInt = 0)
        {
          paramAnonymousFile = i.hX(this.context);
          paramAnonymousFile.IoA = false;
          paramAnonymousFile.Ioz = paramAnonymousInt;
          paramAnonymousFile.save();
          AppMethodBeat.o(186145);
          return;
        }
      }
    }).giy());
    AppMethodBeat.o(186149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recovery.b
 * JD-Core Version:    0.7.0.1
 */