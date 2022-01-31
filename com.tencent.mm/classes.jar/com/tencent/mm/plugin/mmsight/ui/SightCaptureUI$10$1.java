package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$10$1
  implements Runnable
{
  SightCaptureUI$10$1(SightCaptureUI.10 param10, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", new Object[] { this.mqF });
    k.bjA();
    if (!k.isDebug()) {
      return;
    }
    TextView localTextView = (TextView)this.mqG.mqB.findViewById(a.e.video_debug_info);
    localTextView.setVisibility(0);
    localTextView.setText(this.mqF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.10.1
 * JD-Core Version:    0.7.0.1
 */