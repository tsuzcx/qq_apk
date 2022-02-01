package com.tencent.mm.wear.app.d.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.h;

public final class a
{
  private AudioManager agP;
  private AudioManager.OnAudioFocusChangeListener agQ = new AudioManager.OnAudioFocusChangeListener()
  {
    public final void onAudioFocusChange(int paramAnonymousInt)
    {
      d.c("MicroMsg.WearAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3) || (paramAnonymousInt == -1))
      {
        d.d("MicroMsg.WearAudioFocusHelper", "audio focus lossTransient", new Object[0]);
        h.mQ().nh().ns();
      }
    }
  };
  
  public final void nr()
  {
    if (this.agP == null) {
      this.agP = ((AudioManager)MMApplication.getContext().getSystemService("audio"));
    }
    d.c("MicroMsg.WearAudioFocusHelper", "abandonFocus", new Object[0]);
    this.agP.abandonAudioFocus(this.agQ);
  }
  
  public final boolean requestFocus()
  {
    if (this.agP == null) {
      this.agP = ((AudioManager)MMApplication.getContext().getSystemService("audio"));
    }
    int i = this.agP.requestAudioFocus(this.agQ, 3, 2);
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