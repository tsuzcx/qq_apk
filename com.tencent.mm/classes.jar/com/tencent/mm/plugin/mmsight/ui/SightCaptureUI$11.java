package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$11
  implements Runnable
{
  SightCaptureUI$11(SightCaptureUI paramSightCaptureUI, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", new Object[] { this.mqF });
    k.bjA();
    if (!k.isDebug()) {
      return;
    }
    TextView localTextView = (TextView)this.mqB.findViewById(a.e.video_debug_info);
    localTextView.setVisibility(0);
    localTextView.setText(this.mqF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.11
 * JD-Core Version:    0.7.0.1
 */