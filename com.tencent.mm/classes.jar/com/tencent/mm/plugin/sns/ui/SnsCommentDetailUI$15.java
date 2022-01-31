package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentDetailUI$15
  implements SnsCommentFooter.b
{
  SnsCommentDetailUI$15(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void abT(String paramString)
  {
    int j = 8;
    AppMethodBeat.i(38794);
    if (!m.ZV(this.rFG.csH()))
    {
      if (this.rPu.rPq.EJ(0) != null) {
        a.f(this.rPu.getContext(), this.rPu.rPq.EJ(0));
      }
      AppMethodBeat.o(38794);
      return;
    }
    if (this.rFG.Ex(32)) {}
    for (int i = SnsCommentDetailUI.c(this.rPu).getCommentFlag();; i = 0)
    {
      if (d.fS(i, 8))
      {
        paramString = paramString.substring(SnsCommentDetailUI.c(this.rPu).getCommentAtPrefix().length());
        ab.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
        an.a.a(this.rFG, 16, paramString, SnsCommentDetailUI.c(this.rPu).getCommentInfo(), i, SnsCommentDetailUI.f(this.rPu));
        SnsCommentDetailUI.c(this.rPu).setText("");
        SnsCommentDetailUI.c(this.rPu).lC(false);
        ab.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
        SnsCommentDetailUI.w(this.rPu);
        AppMethodBeat.o(38794);
        return;
      }
      ab.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
      n localn = this.rFG;
      if (this.rFG.Ex(32)) {}
      for (;;)
      {
        an.a.a(localn, j, paramString, SnsCommentDetailUI.c(this.rPu).getCommentInfo(), i, SnsCommentDetailUI.f(this.rPu));
        break;
        j = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.15
 * JD-Core Version:    0.7.0.1
 */