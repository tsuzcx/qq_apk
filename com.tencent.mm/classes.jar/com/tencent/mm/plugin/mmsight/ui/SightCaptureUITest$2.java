package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightCaptureUITest$2
  implements View.OnClickListener
{
  SightCaptureUITest$2(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150442);
    if (SightCaptureUITest.e(this.oQq) == 4)
    {
      SightCaptureUITest.p(this.oQq);
      AppMethodBeat.o(150442);
      return;
    }
    if (SightCaptureUITest.e(this.oQq) == 3)
    {
      SightCaptureUITest.q(this.oQq);
      SightCaptureUITest.a(this.oQq, false);
    }
    AppMethodBeat.o(150442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.2
 * JD-Core Version:    0.7.0.1
 */