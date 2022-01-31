package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$9
  implements TextureView.SurfaceTextureListener
{
  VideoTextureView$9(VideoTextureView paramVideoTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    VideoTextureView.d(this.snF, paramInt1);
    VideoTextureView.e(this.snF, paramInt2);
    this.snF.cBe();
    VideoTextureView.a(this.snF, new Surface(paramSurfaceTexture));
    y.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(this.snF.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(VideoTextureView.s(this.snF)), Integer.valueOf(VideoTextureView.u(this.snF).hashCode()) });
    if ((VideoTextureView.a(this.snF) == null) || (!VideoTextureView.s(this.snF)))
    {
      VideoTextureView.v(this.snF);
      if (VideoTextureView.x(this.snF) != null) {
        VideoTextureView.x(this.snF).Sh();
      }
      return;
    }
    VideoTextureView.a(this.snF).setSurface(VideoTextureView.u(this.snF));
    if (VideoTextureView.w(this.snF)) {
      VideoTextureView.a(this.snF).start();
    }
    for (;;)
    {
      VideoTextureView.b(this.snF, false);
      break;
      VideoTextureView.a(this.snF, true);
      VideoTextureView.a(this.snF).setVolume(0.0F, 0.0F);
      VideoTextureView.a(this.snF).start();
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(this.snF.hashCode()), Boolean.valueOf(VideoTextureView.s(this.snF)) });
    VideoTextureView.a(this.snF, null);
    if ((VideoTextureView.a(this.snF) != null) && (VideoTextureView.s(this.snF)))
    {
      if (this.snF.isPlaying())
      {
        VideoTextureView.b(this.snF, true);
        VideoTextureView.a(this.snF).pause();
      }
      return false;
    }
    VideoTextureView.t(this.snF);
    VideoTextureView.b(this.snF, false);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramInt1 + " height : " + paramInt2);
    if ((VideoTextureView.a(this.snF) != null) && (VideoTextureView.s(this.snF)) && (VideoTextureView.b(this.snF) == paramInt1) && (VideoTextureView.c(this.snF) == paramInt2)) {
      VideoTextureView.a(this.snF).start();
    }
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (VideoTextureView.j(this.snF)) {
      if (VideoTextureView.a(this.snF) != null)
      {
        VideoTextureView.a(this.snF).pause();
        if (!VideoTextureView.m(this.snF)) {
          break label204;
        }
        VideoTextureView.a(this.snF).setVolume(0.0F, 0.0F);
      }
    }
    for (;;)
    {
      VideoTextureView.a(this.snF, false);
      if ((VideoTextureView.n(this.snF) > 0L) && (VideoTextureView.o(this.snF) != null))
      {
        VideoTextureView.o(this.snF).bkk();
        VideoTextureView.p(this.snF);
      }
      VideoTextureView.a(this.snF, System.currentTimeMillis());
      if (VideoTextureView.q(this.snF))
      {
        y.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(this.snF.hashCode()), Integer.valueOf(this.snF.getCurrentPosition()) });
        if (VideoTextureView.a(this.snF) != null)
        {
          VideoTextureView.a(this.snF).pause();
          this.snF.setMute(VideoTextureView.m(this.snF));
        }
        VideoTextureView.r(this.snF);
      }
      return;
      label204:
      VideoTextureView.a(this.snF).setVolume(1.0F, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.9
 * JD-Core Version:    0.7.0.1
 */