package com.tencent.mm.plugin.music.h;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements AudioManager.OnAudioFocusChangeListener
{
  a$1(a parama) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    AppMethodBeat.i(137686);
    ab.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == -2) || (paramInt == -3))
    {
      ab.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
      if (k.bVH().bVu().aiy())
      {
        k.bVH().bVu().bUm();
        AppMethodBeat.o(137686);
      }
    }
    else if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
    {
      ab.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
      if (k.bVH().bVu().aiy())
      {
        k.bVH().bVu().resume();
        AppMethodBeat.o(137686);
      }
    }
    else if (paramInt == -1)
    {
      ab.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
      if (k.bVH().bVu().aiy())
      {
        k.bVH().bVu().bUm();
        k.bVH();
        k.bVG();
        k.bVH().Ai(600000);
      }
      if (this.pci.elW != null) {
        this.pci.elW.abandonAudioFocus(this.pci.mHU);
      }
    }
    AppMethodBeat.o(137686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.a.1
 * JD-Core Version:    0.7.0.1
 */