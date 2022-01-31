package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.sdk.platformtools.y;

final class VideoPlayerTextureView$1
  implements c
{
  VideoPlayerTextureView$1(VideoPlayerTextureView paramVideoPlayerTextureView) {}
  
  public final void F(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    VideoPlayerTextureView.b(this.snm).reset();
    VideoPlayerTextureView.b(this.snm, paramInt3);
    VideoPlayerTextureView.c(this.snm, paramInt1);
    VideoPlayerTextureView.a(this.snm, paramInt2);
    this.snm.cor();
    if (this.snm.joM != null) {
      this.snm.joM.cw(VideoPlayerTextureView.c(this.snm), VideoPlayerTextureView.d(this.snm));
    }
  }
  
  public final void aKN()
  {
    if (VideoPlayerTextureView.a(this.snm) != null) {
      VideoPlayerTextureView.a(this.snm).cd(this.snm.joJ);
    }
    if (!this.snm.joJ)
    {
      y.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
      this.snm.joJ = true;
    }
    while (this.snm.joI == null) {
      return;
    }
    y.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { this.snm.joI.ayN() });
    this.snm.joI.start();
  }
  
  public final void kA()
  {
    this.snm.PT = true;
    this.snm.setMute(this.snm.dnJ);
    if (this.snm.joM != null) {
      this.snm.joM.kA();
    }
    this.snm.requestLayout();
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    if (this.snm.joM != null) {
      this.snm.joM.onError(paramInt1, paramInt2);
    }
  }
  
  public final void ug()
  {
    if (this.snm.joM != null) {
      this.snm.joM.ug();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView.1
 * JD-Core Version:    0.7.0.1
 */