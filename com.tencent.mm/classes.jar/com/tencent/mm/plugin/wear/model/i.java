package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
{
  BroadcastReceiver Psl;
  AudioManager audioManager;
  private k.a fCs;
  private k.b fCt;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.fCs = new k.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        AppMethodBeat.o(30028);
        throw null;
      }
    };
    this.fCt = new k.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(30029);
        AppMethodBeat.o(30029);
        throw null;
      }
    };
    this.Psl = new BroadcastReceiver()
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
    MMApplicationContext.getContext().registerReceiver(this.Psl, localIntentFilter);
    AppMethodBeat.o(30031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */