package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;

final class SnsCommentDetailUI$32
  implements View.OnClickListener
{
  SnsCommentDetailUI$32(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98572);
    try
    {
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = new Intent();
      paramView.putExtra("sns_label_sns_info", i);
      a.iyx.u(paramView, this.yKq);
      AppMethodBeat.o(98572);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(98572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.32
 * JD-Core Version:    0.7.0.1
 */