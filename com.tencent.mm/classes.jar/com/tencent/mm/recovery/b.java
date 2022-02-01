package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.toolkit.a.a.d;
import com.tencent.mm.toolkit.a.f;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  public static void a(final Context paramContext, dhg paramdhg, final androidx.core.f.a<Integer> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(201929);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramdhg = new com.tencent.mm.recovery.a.a(paramdhg);
    com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheckCopycat#doSceneSync()");
    paramdhg.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(202294);
        com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          com.tencent.mm.recoveryv2.g.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          this.UOH.set(Math.abs(paramAnonymousInt) + 20);
          parama.accept(Integer.valueOf(this.UOH.get()));
          AppMethodBeat.o(202294);
          return;
        }
        com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.smT)))
        {
          this.UOH.set(1);
          parama.accept(Integer.valueOf(this.UOH.get()));
          AppMethodBeat.o(202294);
          return;
        }
        String str = paramAnonymousb.smT;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.smU;
        b.a(paramContext, str, l, paramAnonymousb, parama, paramBoolean);
        AppMethodBeat.o(202294);
      }
    });
    AppMethodBeat.o(201929);
  }
  
  public static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final androidx.core.f.a<Integer> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(201939);
    com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1).L(new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis()));
    paramString1.VOS = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(202549);
        paramAnonymousc = paramAnonymousc.VOH;
        com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "download tinker path success");
        if (paramAnonymousc.exists())
        {
          this.UOH.set(0);
          if (paramBoolean) {
            com.tencent.tinker.lib.e.c.dj(paramContext, paramAnonymousc.getAbsolutePath());
          }
          parama.accept(Integer.valueOf(this.UOH.get()));
          AppMethodBeat.o(202549);
          return;
        }
        this.UOH.set(2);
        parama.accept(Integer.valueOf(this.UOH.get()));
        AppMethodBeat.o(202549);
      }
      
      public final void df(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(202552);
        com.tencent.mm.recoveryv2.g.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          this.UOH.set(i);
          parama.accept(Integer.valueOf(this.UOH.get()));
          AppMethodBeat.o(202552);
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
      paramString1.VOQ = new f(paramString2);
    }
    com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    new com.tencent.mm.toolkit.a.g().kF(paramContext).e(paramString1);
    AppMethodBeat.o(201939);
  }
  
  public static void a(Context paramContext, String paramString, androidx.core.f.a<Integer> parama)
  {
    AppMethodBeat.i(201931);
    a(paramContext, paramString, 0L, null, parama, true);
    AppMethodBeat.o(201931);
  }
  
  public static void b(Context paramContext, final androidx.core.f.a<Integer> parama)
  {
    AppMethodBeat.i(201924);
    com.tencent.mm.recoveryv2.g.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    com.tencent.mm.plugin.expansions.a.dbf();
    com.tencent.mm.plugin.expansions.a.avY("wechathttp");
    parama = new androidx.core.f.a() {};
    String str = com.tencent.mm.loader.j.a.aSy();
    Log.i("MicroMsg.recovery.operator", "baseTinkerId = ".concat(String.valueOf(str)));
    dhg localdhg = new dhg();
    localdhg.TOo = str;
    localdhg.GIL = com.tencent.mm.loader.j.a.aSz();
    localdhg.TOp = com.tencent.mm.recovery.a.b.eIb();
    localdhg.TOp.add(com.tencent.mm.recovery.a.b.iu("biz-scene", "recovery"));
    localdhg.TOr = 1;
    a(paramContext, localdhg, parama, true);
    AppMethodBeat.o(201924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.b
 * JD-Core Version:    0.7.0.1
 */