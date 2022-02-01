package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zt;
import com.tencent.mm.f.a.zt.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

final class f$3
  extends IListener<zt>
{
  f$3(f paramf)
  {
    AppMethodBeat.i(161153);
    this.__eventId = zt.class.getName().hashCode();
    AppMethodBeat.o(161153);
  }
  
  private static boolean a(zt paramzt)
  {
    AppMethodBeat.i(129914);
    paramzt = paramzt.fZa.fZb;
    g localg = g.PqZ;
    g.gNs();
    boolean bool = e.b(paramzt);
    if (bool)
    {
      Log.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramzt.TQw.Ufv), Boolean.valueOf(bool), Integer.valueOf(paramzt.TQx), Integer.valueOf(paramzt.TQv) });
      d.a(paramzt);
    }
    for (;;)
    {
      bool = e.gNB();
      Log.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.plugin.walletlock.gesture.a.b.Cy(bool);
      ((com.tencent.mm.plugin.walletlock.a.b)h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).init();
      AppMethodBeat.o(129914);
      return false;
      Log.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.3
 * JD-Core Version:    0.7.0.1
 */