package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUI$11$1
  implements Runnable
{
  SightCaptureUI$11$1(SightCaptureUI.11 param11, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(55196);
    ab.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", new Object[] { this.oQj });
    k.bRq();
    if (!k.isDebug())
    {
      AppMethodBeat.o(55196);
      return;
    }
    TextView localTextView = (TextView)this.oQk.oQf.findViewById(2131821751);
    localTextView.setVisibility(0);
    localTextView.setText(this.oQj);
    AppMethodBeat.o(55196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.11.1
 * JD-Core Version:    0.7.0.1
 */