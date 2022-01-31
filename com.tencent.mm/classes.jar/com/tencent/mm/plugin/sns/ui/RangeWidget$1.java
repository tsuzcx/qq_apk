package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class RangeWidget$1
  implements View.OnClickListener
{
  RangeWidget$1(RangeWidget paramRangeWidget) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(RangeWidget.a(this.oSX), SnsLabelUI.class);
    paramView.putExtra("KLabel_range_index", RangeWidget.b(this.oSX));
    paramView.putExtra("Klabel_name_list", RangeWidget.c(this.oSX));
    paramView.putExtra("Kother_user_name_list", RangeWidget.d(this.oSX));
    paramView.putExtra("k_sns_label_ui_style", this.oSX.style);
    RangeWidget.a(this.oSX).startActivityForResult(paramView, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget.1
 * JD-Core Version:    0.7.0.1
 */