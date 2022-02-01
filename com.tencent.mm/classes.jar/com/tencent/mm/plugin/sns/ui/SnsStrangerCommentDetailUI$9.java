package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsStrangerCommentDetailUI$9
  implements View.OnClickListener
{
  SnsStrangerCommentDetailUI$9(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99148);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getTag() instanceof bf)) {
      SnsStrangerCommentDetailUI.f(this.RxU).C(paramView, 2, 1);
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.9
 * JD-Core Version:    0.7.0.1
 */