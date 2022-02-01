package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class VideoTextureView$7
  implements MediaPlayer.OnInfoListener
{
  VideoTextureView$7(VideoTextureView paramVideoTextureView) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134070);
    ad.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (VideoTextureView.l(this.CnQ) != null) {
      VideoTextureView.l(this.CnQ).dZ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(134070);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.7
 * JD-Core Version:    0.7.0.1
 */