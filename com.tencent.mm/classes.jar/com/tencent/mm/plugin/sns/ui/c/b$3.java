package com.tencent.mm.plugin.sns.ui.c;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.sdk.platformtools.bk;

final class b$3
  implements b.f
{
  b$3(b paramb, au paramau, ax paramax, b.a parama) {}
  
  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramb, long paramLong)
  {
    if ((this.pnJ == null) || (this.pnJ.pec == null) || (this.pnJ.pec.oNB == null)) {
      return;
    }
    int i = (int)paramb.bBe();
    this.pnJ.pec.oNB.b(this.pnK.pgP, bk.UZ(), false);
    this.pnJ.pec.oNB.d(this.pnK.pgP, i, false);
    this.pnJ.pec.oNB.G(this.pnK.pgP, this.pnK.pgP);
    this.pnH.plQ.ogP.setOnDecodeDurationListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.b.3
 * JD-Core Version:    0.7.0.1
 */