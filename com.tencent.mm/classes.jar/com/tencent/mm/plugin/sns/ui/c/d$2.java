package com.tencent.mm.plugin.sns.ui.c;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.sdk.platformtools.bk;

final class d$2
  implements b.f
{
  d$2(d paramd, au paramau, ax paramax, d.a parama) {}
  
  public final void b(b paramb, long paramLong)
  {
    if ((this.pnJ == null) || (this.pnJ.pec == null) || (this.pnJ.pec.oNB == null)) {
      return;
    }
    int i = (int)paramb.bBe();
    this.pnJ.pec.oNB.b(this.pnK.pgP, bk.UZ(), false);
    this.pnJ.pec.oNB.d(this.pnK.pgP, i, false);
    this.pnJ.pec.oNB.G(this.pnK.pgP, this.pnK.pgP);
    this.pnX.plQ.ogP.setOnDecodeDurationListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.d.2
 * JD-Core Version:    0.7.0.1
 */