package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.ue.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class f$3
  extends c<ue>
{
  f$3(f paramf)
  {
    AppMethodBeat.i(51711);
    this.__eventId = ue.class.getName().hashCode();
    AppMethodBeat.o(51711);
  }
  
  private static boolean a(ue paramue)
  {
    AppMethodBeat.i(51712);
    paramue = paramue.cKH.cKI;
    g localg = g.uGh;
    g.cXB();
    boolean bool = e.b(paramue);
    if (bool)
    {
      ab.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramue.xzk.getILen()), Boolean.valueOf(bool), Integer.valueOf(paramue.xzl), Integer.valueOf(paramue.xzj) });
      d.a(paramue);
    }
    for (;;)
    {
      bool = e.cXK();
      ab.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.plugin.walletlock.gesture.a.b.oa(bool);
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).init();
      AppMethodBeat.o(51712);
      return false;
      ab.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.3
 * JD-Core Version:    0.7.0.1
 */