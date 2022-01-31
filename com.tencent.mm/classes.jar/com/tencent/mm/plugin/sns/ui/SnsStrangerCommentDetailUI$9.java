package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsStrangerCommentDetailUI$9
  implements View.OnClickListener
{
  SnsStrangerCommentDetailUI$9(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39320);
    if ((paramView.getTag() instanceof ao)) {
      SnsStrangerCommentDetailUI.f(this.rWw).u(paramView, 2, 1);
    }
    AppMethodBeat.o(39320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.9
 * JD-Core Version:    0.7.0.1
 */