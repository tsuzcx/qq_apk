package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.sdk.platformtools.ab;

final class SightCaptureUI$13
  implements Runnable
{
  SightCaptureUI$13(SightCaptureUI paramSightCaptureUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(55200);
    ab.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", new Object[] { this.oQj });
    k.bRq();
    if (!k.isDebug())
    {
      AppMethodBeat.o(55200);
      return;
    }
    TextView localTextView = (TextView)this.oQf.findViewById(2131821751);
    localTextView.setVisibility(0);
    localTextView.setText(this.oQj);
    AppMethodBeat.o(55200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.13
 * JD-Core Version:    0.7.0.1
 */