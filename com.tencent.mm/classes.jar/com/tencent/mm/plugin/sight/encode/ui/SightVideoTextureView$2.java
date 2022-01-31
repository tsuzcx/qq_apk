package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SightVideoTextureView$2
  implements Runnable
{
  SightVideoTextureView$2(SightVideoTextureView paramSightVideoTextureView, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(25120);
    if (SightVideoTextureView.e(this.qXi) != null) {}
    try
    {
      SightVideoTextureView.e(this.qXi).stop();
      SightVideoTextureView.e(this.qXi).release();
    }
    catch (Exception localException1)
    {
      try
      {
        SightVideoTextureView.a(this.qXi, new k());
        SightVideoTextureView.e(this.qXi).setOnCompletionListener(new SightVideoTextureView.2.1(this));
        SightVideoTextureView.e(this.qXi).setOnErrorListener(new SightVideoTextureView.2.2(this));
        SightVideoTextureView.e(this.qXi).setDataSource(this.qXj);
        SightVideoTextureView.a(this.qXi, this.qXi.getPreviewSurface());
        SightVideoTextureView.e(this.qXi).setSurface(SightVideoTextureView.f(this.qXi));
        SightVideoTextureView.e(this.qXi).setAudioStreamType(3);
        if (this.kLR) {
          SightVideoTextureView.e(this.qXi).setVolume(0.0F, 0.0F);
        }
        for (;;)
        {
          SightVideoTextureView.e(this.qXi).setScreenOnWhilePlaying(true);
          SightVideoTextureView.e(this.qXi).setLooping(true);
          SightVideoTextureView.e(this.qXi).prepare();
          SightVideoTextureView.e(this.qXi).start();
          AppMethodBeat.o(25120);
          return;
          localException1 = localException1;
          ab.printErrStackTrace("MicroMsg.SightVideoTextureView", localException1, "", new Object[0]);
          ab.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
          break;
          this.qXi.cnu();
        }
        return;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", new Object[] { this.qXj, localException2.getMessage(), bo.l(localException2) });
        AppMethodBeat.o(25120);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25121);
    String str = super.toString() + "|playVideo";
    AppMethodBeat.o(25121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */