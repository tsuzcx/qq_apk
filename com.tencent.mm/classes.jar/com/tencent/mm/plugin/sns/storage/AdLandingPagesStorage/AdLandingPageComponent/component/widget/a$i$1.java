package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$i$1
  implements MediaPlayer.OnErrorListener
{
  a$i$1(a.i parami) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { a.a(this.oIE.oIA), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oIE.oIA.clear();
    if (a.b(this.oIE.oIA) != null) {
      a.b(this.oIE.oIA).yi(-1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.i.1
 * JD-Core Version:    0.7.0.1
 */