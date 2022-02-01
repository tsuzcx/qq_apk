package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.h;

final class SnsCommentDetailUI$32
  implements View.OnClickListener
{
  SnsCommentDetailUI$32(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98572);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    h.a(this.AsY, 2131764024, 2131755906, new SnsCommentDetailUI.32.1(this), null);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.32
 * JD-Core Version:    0.7.0.1
 */