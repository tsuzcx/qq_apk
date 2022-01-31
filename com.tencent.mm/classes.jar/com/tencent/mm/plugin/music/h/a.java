package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  AudioManager dui = (AudioManager)ae.getContext().getSystemService("audio");
  AudioManager.OnAudioFocusChangeListener mxS = new a.1(this);
  
  public final void bmh()
  {
    y.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
    if (this.dui == null) {
      return;
    }
    this.dui.abandonAudioFocus(this.mxS);
  }
  
  public final boolean requestFocus()
  {
    if (this.dui == null) {
      return false;
    }
    int i = this.dui.requestAudioFocus(this.mxS, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.a
 * JD-Core Version:    0.7.0.1
 */