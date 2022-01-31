package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bk;

final class SnsCommentDetailUI$25
  implements b.f
{
  SnsCommentDetailUI$25(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn, aj paramaj) {}
  
  public final void b(b paramb, long paramLong)
  {
    if (SnsCommentDetailUI.E(this.oWW) == null) {}
    do
    {
      return;
      int i = (int)paramb.bBe();
      SnsCommentDetailUI.E(this.oWW).b(this.oNX.field_snsId, bk.UZ(), false);
      SnsCommentDetailUI.E(this.oWW).d(this.oNX.field_snsId, i, false);
    } while (paramLong < 3L);
    SnsCommentDetailUI.E(this.oWW).G(this.oNX.field_snsId, this.oNX.field_snsId);
    this.oXf.ogP.setOnDecodeDurationListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.25
 * JD-Core Version:    0.7.0.1
 */