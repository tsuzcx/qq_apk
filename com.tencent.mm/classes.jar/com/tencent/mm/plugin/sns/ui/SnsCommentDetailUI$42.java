package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class SnsCommentDetailUI$42
  implements View.OnClickListener
{
  SnsCommentDetailUI$42(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163116);
    ac.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
    SnsCommentDetailUI.g(this.yKq);
    if (!SnsCommentDetailUI.h(this.yKq))
    {
      AppMethodBeat.o(163116);
      return;
    }
    SnsCommentDetailUI.i(this.yKq);
    AppMethodBeat.o(163116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.42
 * JD-Core Version:    0.7.0.1
 */