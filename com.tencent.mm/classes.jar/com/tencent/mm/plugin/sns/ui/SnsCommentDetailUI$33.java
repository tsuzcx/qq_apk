package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;

final class SnsCommentDetailUI$33
  implements View.OnClickListener
{
  SnsCommentDetailUI$33(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98573);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    try
    {
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = new Intent();
      paramView.putExtra("sns_label_sns_info", i);
      com.tencent.mm.plugin.sns.c.a.iUz.u(paramView, this.AsY);
      label74:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98573);
      return;
    }
    catch (Exception paramView)
    {
      break label74;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.33
 * JD-Core Version:    0.7.0.1
 */