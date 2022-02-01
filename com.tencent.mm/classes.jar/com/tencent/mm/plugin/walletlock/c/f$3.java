package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.g.a.wd.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

final class f$3
  extends c<wd>
{
  f$3(f paramf)
  {
    AppMethodBeat.i(161153);
    this.__eventId = wd.class.getName().hashCode();
    AppMethodBeat.o(161153);
  }
  
  private static boolean a(wd paramwd)
  {
    AppMethodBeat.i(129914);
    paramwd = paramwd.dBE.dBF;
    g localg = g.ADl;
    g.efV();
    boolean bool = e.b(paramwd);
    if (bool)
    {
      ad.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramwd.DVr.getILen()), Boolean.valueOf(bool), Integer.valueOf(paramwd.DVs), Integer.valueOf(paramwd.DVq) });
      d.a(paramwd);
    }
    for (;;)
    {
      bool = e.ege();
      ad.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.plugin.walletlock.gesture.a.b.sV(bool);
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).init();
      AppMethodBeat.o(129914);
      return false;
      ad.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.3
 * JD-Core Version:    0.7.0.1
 */