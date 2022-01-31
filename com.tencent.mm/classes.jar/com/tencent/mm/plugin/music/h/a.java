package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  AudioManager elW;
  AudioManager.OnAudioFocusChangeListener mHU;
  
  public a()
  {
    AppMethodBeat.i(137687);
    this.mHU = new a.1(this);
    this.elW = ((AudioManager)ah.getContext().getSystemService("audio"));
    AppMethodBeat.o(137687);
  }
  
  public final void bUj()
  {
    AppMethodBeat.i(137689);
    ab.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
    if (this.elW == null)
    {
      AppMethodBeat.o(137689);
      return;
    }
    this.elW.abandonAudioFocus(this.mHU);
    AppMethodBeat.o(137689);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(137688);
    if (this.elW == null)
    {
      AppMethodBeat.o(137688);
      return false;
    }
    int i = this.elW.requestAudioFocus(this.mHU, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(137688);
      return true;
    }
    AppMethodBeat.o(137688);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.a
 * JD-Core Version:    0.7.0.1
 */