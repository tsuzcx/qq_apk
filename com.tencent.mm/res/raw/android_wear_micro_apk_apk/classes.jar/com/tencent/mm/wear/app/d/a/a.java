package com.tencent.mm.wear.app.d.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;

public final class a
{
  private AudioManager adn;
  private AudioManager.OnAudioFocusChangeListener ado = new AudioManager.OnAudioFocusChangeListener()
  {
    public final void onAudioFocusChange(int paramAnonymousInt)
    {
      d.c("MicroMsg.WearAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3) || (paramAnonymousInt == -1))
      {
        d.e("MicroMsg.WearAudioFocusHelper", "audio focus lossTransient", new Object[0]);
        h.md().mv().mG();
      }
    }
  };
  
  public final void mF()
  {
    if (this.adn == null) {
      this.adn = ((AudioManager)MMApplication.getContext().getSystemService("audio"));
    }
    d.c("MicroMsg.WearAudioFocusHelper", "abandonFocus", new Object[0]);
    this.adn.abandonAudioFocus(this.ado);
  }
  
  public final boolean requestFocus()
  {
    if (this.adn == null) {
      this.adn = ((AudioManager)MMApplication.getContext().getSystemService("audio"));
    }
    int i = this.adn.requestAudioFocus(this.ado, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      d.c("MicroMsg.WearAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a
 * JD-Core Version:    0.7.0.1
 */