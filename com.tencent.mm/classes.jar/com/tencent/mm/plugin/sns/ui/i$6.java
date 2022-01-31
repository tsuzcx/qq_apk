package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

final class i$6
  implements View.OnLongClickListener
{
  i$6(i parami) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(38183);
    g.RM();
    if (!((Boolean)g.RL().Ru().get(7490, Boolean.TRUE)).booleanValue())
    {
      paramView = new Intent();
      paramView.setClass(i.c(this.rFD), SnsCommentUI.class);
      paramView.putExtra("sns_comment_type", 1);
      ((MMActivity)i.c(this.rFD)).startActivityForResult(paramView, 9);
    }
    for (;;)
    {
      AppMethodBeat.o(38183);
      return true;
      i.c(this.rFD).startActivity(new Intent().setClass(i.c(this.rFD), SnsLongMsgUI.class));
      g.RM();
      g.RL().Ru().set(7490, Boolean.FALSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.6
 * JD-Core Version:    0.7.0.1
 */