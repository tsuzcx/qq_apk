package com.tencent.mm.plugin.music.b.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public boolean Aiz;
  AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  AudioManager audioManager;
  
  public a()
  {
    AppMethodBeat.i(137145);
    this.Aiz = false;
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(137144);
        Log.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
          AppMethodBeat.o(137144);
          return;
        }
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
          AppMethodBeat.o(137144);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          Log.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
          if (a.this.audioManager != null) {
            a.this.audioManager.abandonAudioFocus(a.this.audioFocusChangeListener);
          }
          a.this.Aiz = false;
        }
        AppMethodBeat.o(137144);
      }
    };
    this.audioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    AppMethodBeat.o(137145);
  }
  
  public final void bLZ()
  {
    AppMethodBeat.i(137147);
    Log.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(137147);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    this.Aiz = false;
    AppMethodBeat.o(137147);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(137146);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(137146);
      return false;
    }
    int i = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i == 1) {
        this.Aiz = true;
      }
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(137146);
      return true;
    }
    AppMethodBeat.o(137146);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b.a
 * JD-Core Version:    0.7.0.1
 */