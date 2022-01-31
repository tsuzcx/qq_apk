package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUI$2
  implements View.OnClickListener
{
  SightCaptureUI$2(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55181);
    if (SightCaptureUI.g(this.oQf) == 4)
    {
      SightCaptureUI.t(this.oQf);
      AppMethodBeat.o(55181);
      return;
    }
    if (SightCaptureUI.g(this.oQf) == 3)
    {
      SightCaptureUI.u(this.oQf);
      SightCaptureUI.a(this.oQf, false);
    }
    AppMethodBeat.o(55181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.2
 * JD-Core Version:    0.7.0.1
 */