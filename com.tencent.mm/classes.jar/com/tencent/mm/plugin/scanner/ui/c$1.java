package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.jk;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements w.a
{
  c$1(c paramc, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = this.nIg;
    paramString.nIa += 1;
    paramString = (jk)paramb.ecF.ecN;
    c.a(this.nIg, paramInt2, this.nIf, paramString.sEb);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c.1
 * JD-Core Version:    0.7.0.1
 */