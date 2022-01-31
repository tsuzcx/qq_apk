package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.plugin.u.a.h;

final class SightCaptureUI$14$2
  implements Runnable
{
  SightCaptureUI$14$2(SightCaptureUI.14 param14) {}
  
  public final void run()
  {
    Toast.makeText(this.mqH.mqB, a.h.mmsight_clip_failed, 1).show();
    this.mqH.mqB.FS(8);
    SightCaptureUI.G(this.mqH.mqB).setVisibility(0);
    SightCaptureUI.Q(this.mqH.mqB).setVisibility(0);
    SightCaptureUI.R(this.mqH.mqB).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.14.2
 * JD-Core Version:    0.7.0.1
 */