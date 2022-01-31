package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;

final class SightCaptureUI$3
  implements View.OnClickListener
{
  SightCaptureUI$3(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55182);
    if (SightCaptureUI.v(this.oQf) != null) {
      SightCaptureUI.v(this.oQf).Mh();
    }
    SightCaptureUI.s(this.oQf);
    SightCaptureUI.a(this.oQf, true);
    AppMethodBeat.o(55182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.3
 * JD-Core Version:    0.7.0.1
 */