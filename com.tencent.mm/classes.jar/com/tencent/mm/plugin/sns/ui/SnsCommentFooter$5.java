package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsCommentFooter$5
  implements Runnable
{
  SnsCommentFooter$5(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(98635);
    Log.i("MicroMsg.SnsCommentFooter", "showSmileyPanel in run");
    SnsCommentFooter.a(this.KQR).setVisibility(0);
    AppMethodBeat.o(98635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.5
 * JD-Core Version:    0.7.0.1
 */