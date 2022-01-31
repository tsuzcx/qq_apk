package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tf;
import com.tencent.mm.h.a.tf.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class j$1
  implements f
{
  j$1(j paramj, tf paramtf, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    g.DO().dJT.b(1767, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qln.ccP.buffer = this.qlo;
      this.qln.ccP.ccT.run();
      return;
    }
    y.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    this.qln.ccP.retCode = -1;
    this.qln.ccP.ccT.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j.1
 * JD-Core Version:    0.7.0.1
 */