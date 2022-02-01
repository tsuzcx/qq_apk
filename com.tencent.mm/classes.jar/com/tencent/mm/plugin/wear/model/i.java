package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
{
  BroadcastReceiver WiY;
  AudioManager audioManager;
  private j.a hHh;
  private j.b hHi;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.hHh = new j.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        AppMethodBeat.o(30028);
        throw null;
      }
    };
    this.hHi = new j.b()
    {
      public final void atR()
      {
        AppMethodBeat.i(30029);
        AppMethodBeat.o(30029);
        throw null;
      }
    };
    this.WiY = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(30030);
        if (paramAnonymousIntent.hasExtra("state")) {
          paramAnonymousIntent.getIntExtra("state", 2);
        }
        AppMethodBeat.o(30030);
      }
    };
    this.audioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    MMApplicationContext.getContext().registerReceiver(this.WiY, localIntentFilter);
    AppMethodBeat.o(30031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */