package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsCommentDetailUI$3
  implements View.OnClickListener
{
  SnsCommentDetailUI$3(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163081);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
    SnsCommentDetailUI.a(this.ECd, paramView);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.3
 * JD-Core Version:    0.7.0.1
 */