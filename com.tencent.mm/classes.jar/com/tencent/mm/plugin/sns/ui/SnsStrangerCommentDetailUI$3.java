package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsStrangerCommentDetailUI$3
  implements SnsCommentFooter.b
{
  SnsStrangerCommentDetailUI$3(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void abT(String paramString)
  {
    AppMethodBeat.i(39313);
    ab.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
    SnsStrangerCommentDetailUI.a(this.rWw, true);
    SnsStrangerCommentDetailUI.a(this.rWw, SnsStrangerCommentDetailUI.k(this.rWw), paramString);
    AppMethodBeat.o(39313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.3
 * JD-Core Version:    0.7.0.1
 */