package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.uz.a;
import com.tencent.mm.g.a.uz.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class l$2
  implements f
{
  l$2(l paraml, int paramInt, uz paramuz) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45842);
    g.RM();
    g.RK().eHt.b(1767, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = this.tUB;
      paramString = this.tUy.cLx.buffer;
      switch (paramInt1)
      {
      }
      for (;;)
      {
        this.tUy.cLy.cLC.run();
        AppMethodBeat.o(45842);
        return;
        g.RM();
        g.RL().Ru().set(ac.a.yIh, paramString);
        continue;
        g.RM();
        g.RL().Ru().set(ac.a.yIi, paramString);
        continue;
        g.RM();
        g.RL().Ru().set(ac.a.yIj, paramString);
        continue;
        g.RM();
        g.RL().Ru().set(ac.a.yIk, paramString);
      }
    }
    ab.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    this.tUy.cLy.retCode = -1;
    this.tUy.cLy.cLC.run();
    AppMethodBeat.o(45842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.l.2
 * JD-Core Version:    0.7.0.1
 */