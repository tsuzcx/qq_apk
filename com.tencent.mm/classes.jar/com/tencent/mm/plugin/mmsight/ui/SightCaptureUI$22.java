package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUI$22
  implements View.OnClickListener
{
  SightCaptureUI$22(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55219);
    if (SightCaptureUI.g(this.oQf) == 3)
    {
      SightCaptureUI.h(this.oQf);
      AppMethodBeat.o(55219);
      return;
    }
    if (SightCaptureUI.g(this.oQf) == 4) {
      SightCaptureUI.i(this.oQf);
    }
    AppMethodBeat.o(55219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.22
 * JD-Core Version:    0.7.0.1
 */