package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

final class i$5
  implements View.OnLongClickListener
{
  i$5(i parami) {}
  
  public final boolean onLongClick(View paramView)
  {
    g.DQ();
    if (!((Boolean)g.DP().Dz().get(7490, Boolean.valueOf(true))).booleanValue())
    {
      paramView = new Intent();
      paramView.setClass(i.c(this.oNT), SnsCommentUI.class);
      paramView.putExtra("sns_comment_type", 1);
      ((MMActivity)i.c(this.oNT)).startActivityForResult(paramView, 9);
      return true;
    }
    i.c(this.oNT).startActivity(new Intent().setClass(i.c(this.oNT), SnsLongMsgUI.class));
    g.DQ();
    g.DP().Dz().o(7490, Boolean.valueOf(false));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.5
 * JD-Core Version:    0.7.0.1
 */