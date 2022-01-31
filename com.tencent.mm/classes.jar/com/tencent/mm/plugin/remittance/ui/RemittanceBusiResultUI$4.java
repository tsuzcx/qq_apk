package com.tencent.mm.plugin.remittance.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBusiResultUI$4
  implements Runnable
{
  RemittanceBusiResultUI$4(RemittanceBusiResultUI paramRemittanceBusiResultUI, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(142167);
    ViewGroup localViewGroup = (ViewGroup)this.qnm.findViewById(2131827181);
    ViewGroup.LayoutParams localLayoutParams = this.qnn.getLayoutParams();
    localLayoutParams.width = localViewGroup.getWidth();
    localLayoutParams.height = localViewGroup.getHeight();
    this.qnn.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(142167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.4
 * JD-Core Version:    0.7.0.1
 */