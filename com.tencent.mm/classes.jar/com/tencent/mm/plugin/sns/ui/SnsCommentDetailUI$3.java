package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class SnsCommentDetailUI$3
  implements View.OnClickListener
{
  SnsCommentDetailUI$3(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163081);
    ac.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
    SnsCommentDetailUI.a(this.yKq, paramView);
    AppMethodBeat.o(163081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.3
 * JD-Core Version:    0.7.0.1
 */