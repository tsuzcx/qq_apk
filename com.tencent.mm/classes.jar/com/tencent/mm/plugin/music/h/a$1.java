package com.tencent.mm.plugin.music.h;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements AudioManager.OnAudioFocusChangeListener
{
  a$1(a parama) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    y.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == -2) || (paramInt == -3))
    {
      y.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
      if (k.bnl().bmY().Pv()) {
        k.bnl().bmY().bmi();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
            break;
          }
          y.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
        } while (!k.bnl().bmY().Pv());
        k.bnl().bmY().resume();
        return;
      } while (paramInt != -1);
      y.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
      if (k.bnl().bmY().Pv())
      {
        k.bnl().bmY().bmi();
        k.bnl();
        k.bnk();
        k.bnl().uM(600000);
      }
    } while (this.mCr.dui == null);
    this.mCr.dui.abandonAudioFocus(this.mCr.mxS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.a.1
 * JD-Core Version:    0.7.0.1
 */