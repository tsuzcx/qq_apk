package com.tencent.mm.recovery.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.recoveryv2.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  public static void a(final Context paramContext, cxv paramcxv, final android.support.v4.e.c<Integer> paramc, final boolean paramBoolean)
  {
    AppMethodBeat.i(193914);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramcxv = new com.tencent.mm.plugin.hp.net.b(paramcxv);
    f.i("MicroMsg.recovery.operatorFallback", "NetSceneBaseMMTLSCheck#doSceneSync()");
    paramcxv.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(193913);
        f.i("MicroMsg.recovery.operatorFallback", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          f.w("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp error, abort");
          this.NBe.set(Math.abs(paramAnonymousInt) + 20);
          paramc.accept(Integer.valueOf(this.NBe.get()));
          AppMethodBeat.o(193913);
          return;
        }
        f.i("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.pkK)))
        {
          this.NBe.set(1);
          paramc.accept(Integer.valueOf(this.NBe.get()));
          AppMethodBeat.o(193913);
          return;
        }
        String str = paramAnonymousb.pkK;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.pkL;
        com.tencent.mm.recovery.b.a(paramContext, str, l, paramAnonymousb, paramc, paramBoolean);
        AppMethodBeat.o(193913);
      }
    });
    AppMethodBeat.o(193914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recovery.a.c
 * JD-Core Version:    0.7.0.1
 */