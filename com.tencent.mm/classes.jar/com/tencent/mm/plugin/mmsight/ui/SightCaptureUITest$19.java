package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUITest$19
  implements View.OnClickListener
{
  SightCaptureUITest$19(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150480);
    if (SightCaptureUITest.e(this.oQq) == 3)
    {
      SightCaptureUITest.f(this.oQq);
      AppMethodBeat.o(150480);
      return;
    }
    if (SightCaptureUITest.e(this.oQq) == 4) {
      SightCaptureUITest.g(this.oQq);
    }
    AppMethodBeat.o(150480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.19
 * JD-Core Version:    0.7.0.1
 */