package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class SnsCommentDetailUI$43
  implements View.OnClickListener
{
  SnsCommentDetailUI$43(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163116);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
    SnsCommentDetailUI.g(this.AsY);
    if (!SnsCommentDetailUI.h(this.AsY))
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163116);
      return;
    }
    SnsCommentDetailUI.i(this.AsY);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.43
 * JD-Core Version:    0.7.0.1
 */