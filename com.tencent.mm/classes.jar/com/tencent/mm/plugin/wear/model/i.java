package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;

public final class i
{
  a BWS;
  BroadcastReceiver BWT;
  AudioManager audioManager;
  private com.tencent.mm.ak.i.a dfQ;
  private i.b dfR;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.dfQ = new com.tencent.mm.ak.i.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        i.this.BWS.oUG.a(null);
        i.this.BWS.oUG.a(null);
        i.this.b(i.this.BWS);
        AppMethodBeat.o(30028);
      }
    };
    this.dfR = new i.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(30029);
        i.this.BWS.oUG.a(null);
        i.this.BWS.oUG.a(null);
        i.this.b(i.this.BWS);
        AppMethodBeat.o(30029);
      }
    };
    this.BWT = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(30030);
        if ((paramAnonymousIntent.hasExtra("state")) && (paramAnonymousIntent.getIntExtra("state", 2) == 0)) {
          i.this.ewB();
        }
        AppMethodBeat.o(30030);
      }
    };
    this.audioManager = ((AudioManager)ai.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    ai.getContext().registerReceiver(this.BWT, localIntentFilter);
    AppMethodBeat.o(30031);
  }
  
  private static a a(a parama)
  {
    AppMethodBeat.i(30033);
    if (parama != null)
    {
      parama.oUG.stop();
      parama.oUG.a(null);
      parama.oUG.a(null);
      parama.BWV.clear();
    }
    AppMethodBeat.o(30033);
    return null;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(30034);
    while (parama != null) {
      if (parama.BWV.size() > 0)
      {
        bo localbo = (bo)parama.BWV.getLast();
        parama.BWV.removeLast();
        s.Y(localbo);
        String str = s.getFullPath(localbo.field_imgPath);
        ac.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localbo.field_msgId), str });
        if (parama.oUG.a(str, true, true, -1))
        {
          parama.oUG.a(this.dfQ);
          parama.oUG.a(this.dfR);
          AppMethodBeat.o(30034);
        }
      }
      else
      {
        a(parama);
      }
    }
    AppMethodBeat.o(30034);
  }
  
  public final void ewB()
  {
    AppMethodBeat.i(30032);
    a(this.BWS);
    AppMethodBeat.o(30032);
  }
  
  final class a
  {
    LinkedList<bo> BWV;
    com.tencent.mm.ak.i oUG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */