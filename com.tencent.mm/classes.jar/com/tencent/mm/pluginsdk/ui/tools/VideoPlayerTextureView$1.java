package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoPlayerTextureView$1
  implements c
{
  VideoPlayerTextureView$1(VideoPlayerTextureView paramVideoPlayerTextureView) {}
  
  public final void Es()
  {
    AppMethodBeat.i(117980);
    if (this.wfG.lxA != null) {
      this.wfG.lxA.Es();
    }
    AppMethodBeat.o(117980);
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117983);
    ab.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.wfG.wfF.reset();
    this.wfG.wfB = paramInt3;
    this.wfG.mVideoWidth = paramInt1;
    this.wfG.mVideoHeight = paramInt2;
    this.wfG.dpH();
    if (this.wfG.lxA != null) {
      this.wfG.lxA.dQ(this.wfG.mVideoWidth, this.wfG.mVideoHeight);
    }
    AppMethodBeat.o(117983);
  }
  
  public final void boW()
  {
    AppMethodBeat.i(117982);
    if (VideoPlayerTextureView.a(this.wfG) != null) {
      VideoPlayerTextureView.a(this.wfG).dg(this.wfG.lxx);
    }
    if (!this.wfG.lxx)
    {
      ab.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
      this.wfG.lxx = true;
      AppMethodBeat.o(117982);
      return;
    }
    if (this.wfG.lxw != null)
    {
      ab.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { this.wfG.lxw.bau() });
      this.wfG.lxw.start();
    }
    AppMethodBeat.o(117982);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(117979);
    ab.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", new Object[] { Integer.valueOf(hashCode()), this.wfG.getVideoPath() });
    this.wfG.Pz = true;
    this.wfG.setMute(this.wfG.efg);
    if (this.wfG.lxA != null) {
      this.wfG.lxA.mG();
    }
    this.wfG.requestLayout();
    AppMethodBeat.o(117979);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117981);
    if (this.wfG.lxA != null) {
      this.wfG.lxA.onError(paramInt1, paramInt2);
    }
    AppMethodBeat.o(117981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView.1
 * JD-Core Version:    0.7.0.1
 */