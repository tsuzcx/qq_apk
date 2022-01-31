package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightVideoTextureView$2
  implements Runnable
{
  SightVideoTextureView$2(SightVideoTextureView paramSightVideoTextureView, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    if (SightVideoTextureView.e(this.oiV) != null) {}
    try
    {
      SightVideoTextureView.e(this.oiV).stop();
      SightVideoTextureView.e(this.oiV).release();
    }
    catch (Exception localException1)
    {
      try
      {
        SightVideoTextureView.a(this.oiV, new j());
        SightVideoTextureView.e(this.oiV).setOnCompletionListener(new SightVideoTextureView.2.1(this));
        SightVideoTextureView.e(this.oiV).setOnErrorListener(new SightVideoTextureView.2.2(this));
        SightVideoTextureView.e(this.oiV).setDataSource(this.oiW);
        SightVideoTextureView.a(this.oiV, this.oiV.getPreviewSurface());
        SightVideoTextureView.e(this.oiV).setSurface(SightVideoTextureView.f(this.oiV));
        SightVideoTextureView.e(this.oiV).setAudioStreamType(3);
        if (this.iFZ) {
          SightVideoTextureView.e(this.oiV).setVolume(0.0F, 0.0F);
        }
        for (;;)
        {
          SightVideoTextureView.e(this.oiV).setScreenOnWhilePlaying(true);
          SightVideoTextureView.e(this.oiV).setLooping(true);
          SightVideoTextureView.e(this.oiV).prepare();
          SightVideoTextureView.e(this.oiV).start();
          return;
          localException1 = localException1;
          y.printErrStackTrace("MicroMsg.SightVideoTextureView", localException1, "", new Object[0]);
          y.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
          break;
          this.oiV.bBT();
        }
        return;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", new Object[] { this.oiW, localException2.getMessage(), bk.j(localException2) });
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|playVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */