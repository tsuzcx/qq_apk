package com.tencent.mm.plugin.wallet_core.id_verify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2$2
  implements Runnable
{
  a$2$2(a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(155638);
    ab.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
    AppMethodBeat.o(155638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.2.2
 * JD-Core Version:    0.7.0.1
 */