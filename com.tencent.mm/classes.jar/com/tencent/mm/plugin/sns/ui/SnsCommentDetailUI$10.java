package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentDetailUI$10
  implements Runnable
{
  SnsCommentDetailUI$10(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(38787);
    SnsCommentDetailUI.a(this.rPu, SnsCommentDetailUI.a(this.rPu).getBottom());
    ab.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(this.rPu));
    AppMethodBeat.o(38787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.10
 * JD-Core Version:    0.7.0.1
 */