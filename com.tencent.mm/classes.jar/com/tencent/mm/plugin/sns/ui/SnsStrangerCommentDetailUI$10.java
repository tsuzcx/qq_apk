package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsStrangerCommentDetailUI$10
  implements Runnable
{
  SnsStrangerCommentDetailUI$10(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39321);
    SnsStrangerCommentDetailUI.a(this.rWw, SnsStrangerCommentDetailUI.a(this.rWw).getBottom());
    ab.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.g(this.rWw));
    AppMethodBeat.o(39321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.10
 * JD-Core Version:    0.7.0.1
 */