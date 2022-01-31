package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsStrangerCommentDetailUI$7$1
  implements Runnable
{
  SnsStrangerCommentDetailUI$7$1(SnsStrangerCommentDetailUI.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(39317);
    ab.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
    SnsStrangerCommentDetailUI.d(this.rWx.rWw).a(null, null);
    if (SnsStrangerCommentDetailUI.e(this.rWx.rWw))
    {
      SnsStrangerCommentDetailUI.a(this.rWx.rWw, false);
      SnsStrangerCommentDetailUI localSnsStrangerCommentDetailUI = this.rWx.rWw;
      ag.bEf().postDelayed(new SnsStrangerCommentDetailUI.8(localSnsStrangerCommentDetailUI), 10L);
    }
    AppMethodBeat.o(39317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.7.1
 * JD-Core Version:    0.7.0.1
 */