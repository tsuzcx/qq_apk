package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.uz.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class l$1
  implements f
{
  l$1(l paraml, uz paramuz, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45841);
    g.RM();
    g.RK().eHt.b(1767, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.tUy.cLy.buffer = this.tUz;
      this.tUy.cLy.cLC.run();
      AppMethodBeat.o(45841);
      return;
    }
    ab.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    this.tUy.cLy.retCode = -1;
    this.tUy.cLy.cLC.run();
    AppMethodBeat.o(45841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l.1
 * JD-Core Version:    0.7.0.1
 */