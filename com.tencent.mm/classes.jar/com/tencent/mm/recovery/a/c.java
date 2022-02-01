package com.tencent.mm.recovery.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.recoveryv2.e;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  public static void a(final Context paramContext, dzp paramdzp, final a<Integer> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(242767);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramdzp = new com.tencent.mm.plugin.hp.net.b(paramdzp);
    e.i("MicroMsg.recovery.operatorFallback", "NetSceneBaseMMTLSCheck#doSceneSync()");
    paramdzp.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.b.b paramAnonymousb)
      {
        AppMethodBeat.i(242773);
        e.i("MicroMsg.recovery.operatorFallback", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          e.w("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp error, abort");
          c.this.set(Math.abs(paramAnonymousInt) + 20);
          parama.accept(Integer.valueOf(c.this.get()));
          AppMethodBeat.o(242773);
          return;
        }
        e.i("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.mOI)))
        {
          c.this.set(1);
          parama.accept(Integer.valueOf(c.this.get()));
          AppMethodBeat.o(242773);
          return;
        }
        String str = paramAnonymousb.mOI;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.vyS;
        com.tencent.mm.recovery.b.a(paramContext, str, l, paramAnonymousb, parama, paramBoolean);
        AppMethodBeat.o(242773);
      }
    });
    AppMethodBeat.o(242767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.a.c
 * JD-Core Version:    0.7.0.1
 */