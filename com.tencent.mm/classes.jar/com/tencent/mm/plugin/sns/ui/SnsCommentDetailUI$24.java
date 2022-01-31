package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.n;

final class SnsCommentDetailUI$24
  implements b.e
{
  SnsCommentDetailUI$24(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(38806);
    if (paramInt != -1)
    {
      if (SnsCommentDetailUI.x(this.rPu) == null)
      {
        AppMethodBeat.o(38806);
        return;
      }
      SnsCommentDetailUI.x(this.rPu).v(this.rFG.field_snsId, false);
    }
    AppMethodBeat.o(38806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.24
 * JD-Core Version:    0.7.0.1
 */