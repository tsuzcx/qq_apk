package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$1
  extends Thread
{
  VideoTextureView$1(VideoTextureView paramVideoTextureView, MediaPlayer paramMediaPlayer) {}
  
  public final void run()
  {
    try
    {
      if (this.iHc != null)
      {
        y.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", new Object[] { Integer.valueOf(this.snF.hashCode()), this.iHc });
        this.iHc.stop();
        this.iHc.release();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */