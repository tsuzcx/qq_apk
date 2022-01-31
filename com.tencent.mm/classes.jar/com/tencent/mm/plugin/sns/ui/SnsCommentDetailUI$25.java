package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsCommentDetailUI$25
  implements b.f
{
  SnsCommentDetailUI$25(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn, aj paramaj) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(38807);
    if (SnsCommentDetailUI.x(this.rPu) == null)
    {
      AppMethodBeat.o(38807);
      return;
    }
    int i = (int)paramb.cmE();
    SnsCommentDetailUI.x(this.rPu).c(this.rFG.field_snsId, bo.yB(), false);
    SnsCommentDetailUI.x(this.rPu).f(this.rFG.field_snsId, i, false);
    if (paramLong >= 3L)
    {
      SnsCommentDetailUI.x(this.rPu).V(this.rFG.field_snsId, this.rFG.field_snsId);
      this.rPD.qVe.setOnDecodeDurationListener(null);
    }
    AppMethodBeat.o(38807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.25
 * JD-Core Version:    0.7.0.1
 */