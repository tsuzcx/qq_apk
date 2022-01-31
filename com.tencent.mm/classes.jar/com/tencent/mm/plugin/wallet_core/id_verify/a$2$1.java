package com.tencent.mm.plugin.wallet_core.id_verify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(46576);
    ab.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
    AppMethodBeat.o(46576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.2.1
 * JD-Core Version:    0.7.0.1
 */