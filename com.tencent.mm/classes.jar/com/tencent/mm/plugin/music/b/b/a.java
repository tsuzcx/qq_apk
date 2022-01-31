package com.tencent.mm.plugin.music.b.b;

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
  public boolean oYb;
  
  public a()
  {
    AppMethodBeat.i(137395);
    this.oYb = false;
    this.mHU = new a.1(this);
    this.elW = ((AudioManager)ah.getContext().getSystemService("audio"));
    AppMethodBeat.o(137395);
  }
  
  public final void bUj()
  {
    AppMethodBeat.i(137397);
    ab.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
    if (this.elW == null)
    {
      AppMethodBeat.o(137397);
      return;
    }
    this.elW.abandonAudioFocus(this.mHU);
    this.oYb = false;
    AppMethodBeat.o(137397);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(137396);
    if (this.elW == null)
    {
      AppMethodBeat.o(137396);
      return false;
    }
    int i = this.elW.requestAudioFocus(this.mHU, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i == 1) {
        this.oYb = true;
      }
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(137396);
      return true;
    }
    AppMethodBeat.o(137396);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b.a
 * JD-Core Version:    0.7.0.1
 */