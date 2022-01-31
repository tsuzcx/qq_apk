package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$14
  implements a.a
{
  SightCaptureUI$14(SightCaptureUI paramSightCaptureUI) {}
  
  public final void bjP()
  {
    y.i("MicroMsg.SightCaptureUI", "on video edit finish");
    if (SightCaptureUI.O(this.mqB) != null)
    {
      SightCaptureUI.a(this.mqB, bk.aM(SightCaptureUI.O(this.mqB).bIW, ""));
      SightCaptureUI.O(this.mqB).k(false, SightCaptureUI.a(this.mqB).mfz);
      SightCaptureUI.O(this.mqB).release();
      SightCaptureUI.P(this.mqB);
    }
    SightCaptureUI.G(this.mqB).setVisibility(0);
    SightCaptureUI.Q(this.mqB).setVisibility(0);
    SightCaptureUI.R(this.mqB).setVisibility(0);
    SightCaptureUI.S(this.mqB).stop();
    SightCaptureUI.S(this.mqB).setVideoPath(SightCaptureUI.n(this.mqB).bjl());
    SightCaptureUI.S(this.mqB).setLoop(true);
    SightCaptureUI.S(this.mqB).setForceScaleFullScreen(true);
    SightCaptureUI.S(this.mqB).setVideoCallback(SightCaptureUI.T(this.mqB));
    this.mqB.FS(8);
    e.post(new SightCaptureUI.14.1(this), "SightCaptureUI_edit_finish_save_new_thumb");
    SightCaptureUI.V(this.mqB);
  }
  
  public final void bjQ()
  {
    y.i("MicroMsg.SightCaptureUI", "on video edit exit");
    if (SightCaptureUI.O(this.mqB) != null)
    {
      SightCaptureUI.O(this.mqB).k(true, SightCaptureUI.a(this.mqB).mfz);
      SightCaptureUI.O(this.mqB).release();
      SightCaptureUI.P(this.mqB);
    }
    this.mqB.FS(8);
    SightCaptureUI.G(this.mqB).setVisibility(0);
    SightCaptureUI.Q(this.mqB).setVisibility(0);
    SightCaptureUI.R(this.mqB).setVisibility(0);
  }
  
  public final void onError()
  {
    y.i("MicroMsg.SightCaptureUI", "on video edit error");
    if (SightCaptureUI.O(this.mqB) != null)
    {
      SightCaptureUI.O(this.mqB).release();
      SightCaptureUI.P(this.mqB);
    }
    ai.d(new SightCaptureUI.14.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.14
 * JD-Core Version:    0.7.0.1
 */