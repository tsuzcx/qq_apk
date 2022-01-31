package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentDetailUI$38
  implements View.OnClickListener
{
  SnsCommentDetailUI$38(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38823);
    ab.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
    SnsCommentDetailUI.g(this.rPu);
    if (!SnsCommentDetailUI.h(this.rPu))
    {
      AppMethodBeat.o(38823);
      return;
    }
    SnsCommentDetailUI.i(this.rPu);
    AppMethodBeat.o(38823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.38
 * JD-Core Version:    0.7.0.1
 */