package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$19
  implements f.a
{
  SightCaptureUI$19(SightCaptureUI paramSightCaptureUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    if (SightCaptureUI.S(this.mqB) != null)
    {
      SightCaptureUI.S(this.mqB).start();
      SightCaptureUI.S(this.mqB).setLoop(true);
    }
    ai.S(SightCaptureUI.M(this.mqB));
    SightCaptureUI.S(this.mqB).setOneTimeVideoTextureUpdateCallback(new SightCaptureUI.19.1(this));
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(this.mqB.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void ug()
  {
    SightCaptureUI.S(this.mqB).d(0.0D, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.19
 * JD-Core Version:    0.7.0.1
 */