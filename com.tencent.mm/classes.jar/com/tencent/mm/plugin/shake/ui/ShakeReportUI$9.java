package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;

final class ShakeReportUI$9
  implements View.OnClickListener
{
  ShakeReportUI$9(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.odm, ShakeMsgListUI.class);
    paramView.putExtra("shake_msg_from", 1);
    paramView.putExtra("shake_msg_list_title", this.odm.getString(R.l.shake_tv_msg_center_title));
    this.odm.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.9
 * JD-Core Version:    0.7.0.1
 */