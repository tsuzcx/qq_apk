package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.view.Surface;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightVideoTextureView$3
  implements Runnable
{
  SightVideoTextureView$3(SightVideoTextureView paramSightVideoTextureView) {}
  
  public final void run()
  {
    try
    {
      this.oiV.bBU();
      SightVideoTextureView.e(this.oiV).stop();
      SightVideoTextureView.e(this.oiV).release();
      if ((SightVideoTextureView.f(this.oiV) != null) && (SightVideoTextureView.f(this.oiV).isValid()))
      {
        SightVideoTextureView.f(this.oiV).release();
        SightVideoTextureView.a(this.oiV, null);
      }
      SightVideoTextureView.a(this.oiV, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", new Object[] { localException.getMessage(), bk.j(localException) });
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|stopPlayVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.3
 * JD-Core Version:    0.7.0.1
 */