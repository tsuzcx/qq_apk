package com.tencent.mm.plugin.music.b.b;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements AudioManager.OnAudioFocusChangeListener
{
  a$1(a parama) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    y.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == -2) || (paramInt == -3)) {
      y.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
    }
    do
    {
      return;
      if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
      {
        y.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
        return;
      }
    } while (paramInt != -1);
    y.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
    if (this.mxT.dui != null) {
      this.mxT.dui.abandonAudioFocus(this.mxT.mxS);
    }
    this.mxT.mxR = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b.a.1
 * JD-Core Version:    0.7.0.1
 */