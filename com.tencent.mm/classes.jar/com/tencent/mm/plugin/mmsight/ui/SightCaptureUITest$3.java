package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;

final class SightCaptureUITest$3
  implements View.OnClickListener
{
  SightCaptureUITest$3(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150443);
    if (SightCaptureUITest.r(this.oQq) != null) {
      SightCaptureUITest.r(this.oQq).Mh();
    }
    SightCaptureUITest.o(this.oQq);
    SightCaptureUITest.a(this.oQq, true);
    AppMethodBeat.o(150443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.3
 * JD-Core Version:    0.7.0.1
 */