package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUI$4
  implements View.OnClickListener
{
  SightCaptureUI$4(SightCaptureUI paramSightCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55183);
    if (!SightCaptureUI.w(this.oQf))
    {
      AppMethodBeat.o(55183);
      return;
    }
    this.oQf.finish();
    this.oQf.overridePendingTransition(-1, 2131034260);
    AppMethodBeat.o(55183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.4
 * JD-Core Version:    0.7.0.1
 */