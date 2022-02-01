package com.tencent.mm.plugin.remittance.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBusiResultUI$4
  implements Runnable
{
  RemittanceBusiResultUI$4(RemittanceBusiResultUI paramRemittanceBusiResultUI, ImageView paramImageView, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    AppMethodBeat.i(67993);
    ViewGroup.LayoutParams localLayoutParams = this.CsQ.getLayoutParams();
    if (this.CsR != null)
    {
      localLayoutParams.width = this.CsR.getWidth();
      localLayoutParams.height = this.CsR.getHeight();
      this.CsQ.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(67993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.4
 * JD-Core Version:    0.7.0.1
 */