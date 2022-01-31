package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.storage.ad;

final class SnsCommentDetailUI$27
  implements View.OnClickListener
{
  SnsCommentDetailUI$27(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn, ad paramad) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38809);
    i.a(new SnsAdClick(SnsCommentDetailUI.f(this.rPu), 2, this.rFG.field_snsId, 24, 0));
    SnsCommentDetailUI.c(this.rPu).setCommentFlag(1);
    SnsCommentDetailUI.c(this.rPu).setCommentHint(this.ejm.Of());
    SnsCommentDetailUI.c(this.rPu).lC(true);
    SnsCommentDetailUI.E(this.rPu).setVisibility(8);
    SnsCommentDetailUI.z(this.rPu);
    AppMethodBeat.o(38809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.27
 * JD-Core Version:    0.7.0.1
 */