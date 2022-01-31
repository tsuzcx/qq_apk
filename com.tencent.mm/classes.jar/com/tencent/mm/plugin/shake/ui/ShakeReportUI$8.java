package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class ShakeReportUI$8
  implements View.OnClickListener
{
  ShakeReportUI$8(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.odm, ShakeSayHiListUI.class);
    paramView.putExtra("IntentSayHiType", 1);
    this.odm.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.8
 * JD-Core Version:    0.7.0.1
 */