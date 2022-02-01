package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.a.d;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

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
        Log.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
          if (j.gnw().gnj().bLm())
          {
            j.gnw().gnj().gmh();
            AppMethodBeat.o(137438);
          }
        }
        else if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
          if (j.gnw().gnj().bLm())
          {
            j.gnw().gnj().resume();
            AppMethodBeat.o(137438);
          }
        }
        else if (paramAnonymousInt == -1)
        {
          Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
          if (j.gnw().gnj().bLm())
          {
            j.gnw().gnj().gmh();
            j.gnw();
            j.gnv();
            j.gnw().adx(600000);
          }
          if (a.this.audioManager != null) {
            a.this.audioManager.abandonAudioFocus(a.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(137438);
      }
    };
    this.audioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    AppMethodBeat.o(137439);
  }
  
  public final void cyG()
  {
    AppMethodBeat.i(137441);
    Log.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
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
      Log.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.a
 * JD-Core Version:    0.7.0.1
 */