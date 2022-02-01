package com.tencent.mm.recovery.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.recoveryv2.g;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  public static void a(final Context paramContext, dhg paramdhg, final a<Integer> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(201799);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramdhg = new com.tencent.mm.plugin.hp.net.b(paramdhg);
    g.i("MicroMsg.recovery.operatorFallback", "NetSceneBaseMMTLSCheck#doSceneSync()");
    paramdhg.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(202515);
        g.i("MicroMsg.recovery.operatorFallback", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          g.w("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp error, abort");
          this.UOH.set(Math.abs(paramAnonymousInt) + 20);
          parama.accept(Integer.valueOf(this.UOH.get()));
          AppMethodBeat.o(202515);
          return;
        }
        g.i("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.smT)))
        {
          this.UOH.set(1);
          parama.accept(Integer.valueOf(this.UOH.get()));
          AppMethodBeat.o(202515);
          return;
        }
        String str = paramAnonymousb.smT;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.smU;
        com.tencent.mm.recovery.b.a(paramContext, str, l, paramAnonymousb, parama, paramBoolean);
        AppMethodBeat.o(202515);
      }
    });
    AppMethodBeat.o(201799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.a.c
 * JD-Core Version:    0.7.0.1
 */