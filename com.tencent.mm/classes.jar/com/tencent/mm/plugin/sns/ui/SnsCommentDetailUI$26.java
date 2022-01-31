package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.storage.ad;

final class SnsCommentDetailUI$26
  implements View.OnClickListener
{
  SnsCommentDetailUI$26(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn, ad paramad) {}
  
  public final void onClick(View paramView)
  {
    i.a(new SnsAdClick(SnsCommentDetailUI.f(this.oWW), 2, this.oNX.field_snsId, 24, 0));
    SnsCommentDetailUI.b(this.oWW).setCommentFlag(1);
    SnsCommentDetailUI.b(this.oWW).setCommentHint(this.drE.Bq());
    SnsCommentDetailUI.b(this.oWW).jw(true);
    SnsCommentDetailUI.F(this.oWW).setVisibility(8);
    SnsCommentDetailUI.y(this.oWW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.26
 * JD-Core Version:    0.7.0.1
 */