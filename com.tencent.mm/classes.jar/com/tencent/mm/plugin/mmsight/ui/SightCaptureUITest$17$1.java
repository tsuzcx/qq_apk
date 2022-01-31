package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUITest$17$1
  implements Runnable
{
  SightCaptureUITest$17$1(SightCaptureUITest.17 param17, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(150475);
    ab.i("MicroMsg.SightCaptureUI", "DEBUG showVideoDebugInfo %s", new Object[] { this.oQj });
    k.bRq();
    if (!k.isDebug())
    {
      AppMethodBeat.o(150475);
      return;
    }
    TextView localTextView = (TextView)this.oQx.oQq.findViewById(2131821751);
    localTextView.setVisibility(0);
    localTextView.setText(this.oQj);
    AppMethodBeat.o(150475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.17.1
 * JD-Core Version:    0.7.0.1
 */