package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$i$1
  implements MediaPlayer.OnErrorListener
{
  b$i$1(b.i parami) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37425);
    ab.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(this.ryC.ryy), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ryC.ryy.clear();
    if (b.b(this.ryC.ryy) != null) {
      b.b(this.ryC.ryy).Eh(-1);
    }
    AppMethodBeat.o(37425);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.i.1
 * JD-Core Version:    0.7.0.1
 */