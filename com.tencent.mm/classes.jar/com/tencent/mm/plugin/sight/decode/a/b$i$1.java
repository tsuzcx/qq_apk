package com.tencent.mm.plugin.sight.decode.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$i$1
  implements MediaPlayer.OnErrorListener
{
  b$i$1(b.i parami) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(this.ofj.oeY), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ofj.oeY.clear();
    if (b.b(this.ofj.oeY) != null) {
      b.b(this.ofj.oeY).d(this.ofj.oeY, -1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.i.1
 * JD-Core Version:    0.7.0.1
 */