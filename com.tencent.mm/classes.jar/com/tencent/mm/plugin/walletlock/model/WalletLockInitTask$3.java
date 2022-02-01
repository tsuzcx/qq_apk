package com.tencent.mm.plugin.walletlock.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abq;
import com.tencent.mm.autogen.a.abq.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.g;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class WalletLockInitTask$3
  extends IListener<abq>
{
  WalletLockInitTask$3(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(266830);
    this.__eventId = abq.class.getName().hashCode();
    AppMethodBeat.o(266830);
  }
  
  private static boolean a(abq paramabq)
  {
    AppMethodBeat.i(129914);
    paramabq = paramabq.ifg.ifh;
    f localf = f.WhM;
    f.imH();
    boolean bool = g.b(paramabq);
    if (bool)
    {
      Log.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramabq.abgV.abwJ), Boolean.valueOf(bool), Integer.valueOf(paramabq.abgW), Integer.valueOf(paramabq.abgU) });
      com.tencent.mm.plugin.walletlock.gesture.a.f.a(paramabq);
    }
    for (;;)
    {
      bool = g.imQ();
      Log.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
      d.Id(bool);
      ((b)h.ax(b.class)).init();
      AppMethodBeat.o(129914);
      return false;
      Log.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.WalletLockInitTask.3
 * JD-Core Version:    0.7.0.1
 */