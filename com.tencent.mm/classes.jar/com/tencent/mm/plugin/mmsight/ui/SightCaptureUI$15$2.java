package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUI$15$2
  implements Runnable
{
  SightCaptureUI$15$2(SightCaptureUI.15 param15) {}
  
  public final void run()
  {
    AppMethodBeat.i(55203);
    Toast.makeText(this.oQl.oQf, 2131301571, 1).show();
    this.oQl.oQf.setSelfNavigationBarVisible(8);
    SightCaptureUI.H(this.oQl.oQf).setVisibility(0);
    SightCaptureUI.R(this.oQl.oQf).setVisibility(0);
    SightCaptureUI.S(this.oQl.oQf).setVisibility(0);
    AppMethodBeat.o(55203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.15.2
 * JD-Core Version:    0.7.0.1
 */