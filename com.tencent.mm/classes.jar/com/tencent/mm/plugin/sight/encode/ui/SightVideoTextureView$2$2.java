package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class SightVideoTextureView$2$2
  implements MediaPlayer.OnErrorListener
{
  SightVideoTextureView$2$2(SightVideoTextureView.2 param2) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SightVideoTextureView", "play %s error", new Object[] { this.oiX.oiW });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.2.2
 * JD-Core Version:    0.7.0.1
 */