package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SightCaptureUITest$10
  implements b.a
{
  SightCaptureUITest$10(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void bRC()
  {
    AppMethodBeat.i(150459);
    ab.i("MicroMsg.SightCaptureUI", "on video edit finish");
    if (SightCaptureUITest.E(this.oQq) != null)
    {
      SightCaptureUITest.b(this.oQq, SightCaptureUITest.E(this.oQq).bRW());
      SightCaptureUITest.E(this.oQq).p(false, SightCaptureUITest.d(this.oQq).oFX);
      SightCaptureUITest.E(this.oQq).release();
      SightCaptureUITest.F(this.oQq);
    }
    SightCaptureUITest.z(this.oQq).setVisibility(0);
    SightCaptureUITest.G(this.oQq).setVisibility(0);
    SightCaptureUITest.H(this.oQq).setVisibility(0);
    SightCaptureUITest.I(this.oQq).stop();
    SightCaptureUITest.I(this.oQq).setVideoPath(SightCaptureUITest.J(this.oQq).fbn);
    SightCaptureUITest.I(this.oQq).setLoop(true);
    SightCaptureUITest.I(this.oQq).setForceScaleFullScreen(true);
    SightCaptureUITest.I(this.oQq).setVideoCallback(SightCaptureUITest.K(this.oQq));
    this.oQq.setSelfNavigationBarVisible(8);
    d.post(new SightCaptureUITest.10.1(this), "SightCaptureUI_edit_finish_save_new_thumb");
    SightCaptureUITest.M(this.oQq);
    AppMethodBeat.o(150459);
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(150460);
    ab.i("MicroMsg.SightCaptureUI", "on video edit exit");
    if (SightCaptureUITest.E(this.oQq) != null)
    {
      SightCaptureUITest.E(this.oQq).p(true, SightCaptureUITest.d(this.oQq).oFX);
      SightCaptureUITest.E(this.oQq).release();
      SightCaptureUITest.F(this.oQq);
    }
    this.oQq.setSelfNavigationBarVisible(8);
    SightCaptureUITest.z(this.oQq).setVisibility(0);
    SightCaptureUITest.G(this.oQq).setVisibility(0);
    SightCaptureUITest.H(this.oQq).setVisibility(0);
    AppMethodBeat.o(150460);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(150461);
    ab.i("MicroMsg.SightCaptureUI", "on video edit error");
    if (SightCaptureUITest.E(this.oQq) != null)
    {
      SightCaptureUITest.E(this.oQq).release();
      SightCaptureUITest.F(this.oQq);
    }
    al.d(new SightCaptureUITest.10.2(this));
    AppMethodBeat.o(150461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.10
 * JD-Core Version:    0.7.0.1
 */