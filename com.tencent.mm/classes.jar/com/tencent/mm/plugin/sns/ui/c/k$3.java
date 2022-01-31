package com.tencent.mm.plugin.sns.ui.c;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.sdk.platformtools.bk;

final class k$3
  implements b.f
{
  k$3(k paramk, au paramau, long paramLong, a.c paramc) {}
  
  public final void b(b paramb, long paramLong)
  {
    if ((this.pnJ == null) || (this.pnJ.pec == null) || (this.pnJ.pec.oNB == null)) {
      return;
    }
    int i = (int)paramb.bBe();
    this.pnJ.pec.oNB.b(this.pmx, bk.UZ(), false);
    this.pnJ.pec.oNB.d(this.pmx, i, false);
    this.pnJ.pec.oNB.G(this.pmx, this.pmx);
    this.oNY.plQ.ogP.setOnDecodeDurationListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.k.3
 * JD-Core Version:    0.7.0.1
 */