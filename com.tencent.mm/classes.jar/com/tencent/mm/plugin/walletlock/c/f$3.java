package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.g.a.wo.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

final class f$3
  extends c<wo>
{
  f$3(f paramf)
  {
    AppMethodBeat.i(161153);
    this.__eventId = wo.class.getName().hashCode();
    AppMethodBeat.o(161153);
  }
  
  private static boolean a(wo paramwo)
  {
    AppMethodBeat.i(129914);
    paramwo = paramwo.dzs.dzt;
    g localg = g.BVG;
    g.evp();
    boolean bool = e.b(paramwo);
    if (bool)
    {
      ac.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramwo.Fsf.getILen()), Boolean.valueOf(bool), Integer.valueOf(paramwo.Fsg), Integer.valueOf(paramwo.Fse) });
      d.a(paramwo);
    }
    for (;;)
    {
      bool = e.evy();
      ac.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.plugin.walletlock.gesture.a.b.tW(bool);
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).init();
      AppMethodBeat.o(129914);
      return false;
      ac.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.3
 * JD-Core Version:    0.7.0.1
 */