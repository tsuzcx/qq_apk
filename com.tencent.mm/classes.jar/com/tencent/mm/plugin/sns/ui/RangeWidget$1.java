package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RangeWidget$1
  implements View.OnClickListener
{
  RangeWidget$1(RangeWidget paramRangeWidget) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38539);
    paramView = new Intent(RangeWidget.a(this.rKU), SnsLabelUI.class);
    paramView.putExtra("KLabel_range_index", RangeWidget.b(this.rKU));
    paramView.putExtra("Klabel_name_list", RangeWidget.c(this.rKU));
    paramView.putExtra("Kother_user_name_list", RangeWidget.d(this.rKU));
    paramView.putExtra("Kchat_room_name_list", RangeWidget.e(this.rKU));
    paramView.putExtra("k_sns_label_ui_style", this.rKU.style);
    RangeWidget.a(this.rKU).startActivityForResult(paramView, 5);
    AppMethodBeat.o(38539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget.1
 * JD-Core Version:    0.7.0.1
 */