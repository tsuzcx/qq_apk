package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  AudioManager audioManager;
  
  public a()
  {
    AppMethodBeat.i(137439);
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(137438);
        ad.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          ad.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
          if (k.dta().dsN().aJI())
          {
            k.dta().dsN().drJ();
            AppMethodBeat.o(137438);
          }
        }
        else if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          ad.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
          if (k.dta().dsN().aJI())
          {
            k.dta().dsN().resume();
            AppMethodBeat.o(137438);
          }
        }
        else if (paramAnonymousInt == -1)
        {
          ad.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
          if (k.dta().dsN().aJI())
          {
            k.dta().dsN().drJ();
            k.dta();
            k.dsZ();
            k.dta().Ln(600000);
          }
          if (a.this.audioManager != null) {
            a.this.audioManager.abandonAudioFocus(a.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(137438);
      }
    };
    this.audioManager = ((AudioManager)aj.getContext().getSystemService("audio"));
    AppMethodBeat.o(137439);
  }
  
  public final void bpH()
  {
    AppMethodBeat.i(137441);
    ad.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(137441);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(137441);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(137440);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(137440);
      return false;
    }
    int i = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(137440);
      return true;
    }
    AppMethodBeat.o(137440);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.a
 * JD-Core Version:    0.7.0.1
 */