package com.tencent.mm.plugin.sns.ui.b.a;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.platformtools.bk;

final class b$2
  implements b.f
{
  b$2(b paramb) {}
  
  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramb, long paramLong)
  {
    int i = (int)paramb.bBe();
    if (this.pmc.oWw != null)
    {
      this.pmc.oWw.b(this.pmc.oUH.field_snsId, bk.UZ(), false);
      this.pmc.oWw.d(this.pmc.oUH.field_snsId, i, false);
      this.pmc.oWw.G(this.pmc.oUH.field_snsId, this.pmc.oUH.field_snsId);
    }
    this.pmc.plQ.ogP.setOnDecodeDurationListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.b.2
 * JD-Core Version:    0.7.0.1
 */