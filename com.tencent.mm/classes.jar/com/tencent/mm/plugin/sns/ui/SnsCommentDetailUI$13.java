package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.n;

final class SnsCommentDetailUI$13
  implements SnsCommentFooter.a
{
  SnsCommentDetailUI$13(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void cvb()
  {
    AppMethodBeat.i(38792);
    if (!m.ZV(this.rFG.csH()))
    {
      if ((SnsCommentDetailUI.y(this.rPu) != null) && (SnsCommentDetailUI.y(this.rPu).isShowing()))
      {
        AppMethodBeat.o(38792);
        return;
      }
      SnsCommentDetailUI.a(this.rPu, a.f(this.rPu.getContext(), this.rPu.rPq.EJ(0)));
      AppMethodBeat.o(38792);
      return;
    }
    if ((this.rPu.keyboardState() == 1) || (SnsCommentDetailUI.c(this.rPu).cvd()))
    {
      AppMethodBeat.o(38792);
      return;
    }
    SnsCommentDetailUI.z(this.rPu);
    AppMethodBeat.o(38792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.13
 * JD-Core Version:    0.7.0.1
 */