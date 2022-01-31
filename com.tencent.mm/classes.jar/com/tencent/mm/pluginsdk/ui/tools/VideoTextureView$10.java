package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$10
  implements TextureView.SurfaceTextureListener
{
  VideoTextureView$10(VideoTextureView paramVideoTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118020);
    VideoTextureView.d(this.wga, paramInt1);
    VideoTextureView.e(this.wga, paramInt2);
    this.wga.dEs();
    this.wga.h(VideoTextureView.t(this.wga));
    VideoTextureView.a(this.wga, new Surface(paramSurfaceTexture));
    ab.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(this.wga.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(VideoTextureView.s(this.wga)), Integer.valueOf(VideoTextureView.t(this.wga).hashCode()) });
    if ((VideoTextureView.a(this.wga) == null) || (!VideoTextureView.s(this.wga)))
    {
      VideoTextureView.v(this.wga);
      if (VideoTextureView.x(this.wga) != null) {
        VideoTextureView.x(this.wga).alr();
      }
      AppMethodBeat.o(118020);
      return;
    }
    VideoTextureView.a(this.wga).setSurface(VideoTextureView.t(this.wga));
    if (VideoTextureView.w(this.wga)) {
      VideoTextureView.a(this.wga).start();
    }
    for (;;)
    {
      VideoTextureView.b(this.wga, false);
      break;
      VideoTextureView.a(this.wga, true);
      VideoTextureView.a(this.wga).setVolume(0.0F, 0.0F);
      VideoTextureView.a(this.wga).start();
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(118019);
    ab.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(this.wga.hashCode()), Boolean.valueOf(VideoTextureView.s(this.wga)) });
    this.wga.h(VideoTextureView.t(this.wga));
    VideoTextureView.a(this.wga, null);
    if ((VideoTextureView.a(this.wga) != null) && (VideoTextureView.s(this.wga))) {
      if (this.wga.isPlaying())
      {
        VideoTextureView.b(this.wga, true);
        VideoTextureView.a(this.wga).pause();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(118019);
      return false;
      VideoTextureView.u(this.wga);
      VideoTextureView.b(this.wga, false);
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118018);
    ab.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramInt1 + " height : " + paramInt2);
    if ((VideoTextureView.a(this.wga) != null) && (VideoTextureView.s(this.wga)) && (VideoTextureView.b(this.wga) == paramInt1) && (VideoTextureView.c(this.wga) == paramInt2)) {
      VideoTextureView.a(this.wga).start();
    }
    AppMethodBeat.o(118018);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(118017);
    ab.d("MicroMsg.VideoTextureView", "on surface texture updated");
    if (VideoTextureView.j(this.wga)) {
      if (VideoTextureView.a(this.wga) != null)
      {
        VideoTextureView.a(this.wga).pause();
        if (!VideoTextureView.m(this.wga)) {
          break label221;
        }
        VideoTextureView.a(this.wga).setVolume(0.0F, 0.0F);
      }
    }
    for (;;)
    {
      VideoTextureView.a(this.wga, false);
      if ((VideoTextureView.n(this.wga) > 0L) && (VideoTextureView.o(this.wga) != null))
      {
        VideoTextureView.o(this.wga).bSk();
        VideoTextureView.p(this.wga);
      }
      VideoTextureView.a(this.wga, System.currentTimeMillis());
      if (VideoTextureView.q(this.wga))
      {
        ab.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(this.wga.hashCode()), Integer.valueOf(this.wga.getCurrentPosition()) });
        if (VideoTextureView.a(this.wga) != null)
        {
          VideoTextureView.a(this.wga).pause();
          this.wga.setMute(VideoTextureView.m(this.wga));
        }
        VideoTextureView.r(this.wga);
      }
      AppMethodBeat.o(118017);
      return;
      label221:
      VideoTextureView.a(this.wga).setVolume(1.0F, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.10
 * JD-Core Version:    0.7.0.1
 */