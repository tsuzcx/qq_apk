package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RangeWidget$2
  implements View.OnClickListener
{
  RangeWidget$2(RangeWidget paramRangeWidget) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(145492);
    if (RangeWidget.f(this.rKU) != null) {
      RangeWidget.f(this.rKU).onClick(paramView);
    }
    AppMethodBeat.o(145492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget.2
 * JD-Core Version:    0.7.0.1
 */