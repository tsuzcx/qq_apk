package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LocationWidget$1
  implements View.OnClickListener
{
  LocationWidget$1(LocationWidget paramLocationWidget, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38285);
    if (LocationWidget.a(this.rIm) == this.val$index + 1) {
      LocationWidget.b(this.rIm);
    }
    for (;;)
    {
      LocationWidget.c(this.rIm);
      AppMethodBeat.o(38285);
      return;
      LocationWidget.a(this.rIm, this.val$index + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LocationWidget.1
 * JD-Core Version:    0.7.0.1
 */