package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;

public final class i
{
  a AEy;
  BroadcastReceiver AEz;
  AudioManager audioManager;
  private com.tencent.mm.al.i.a div;
  private i.b diw;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.div = new com.tencent.mm.al.i.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        i.this.AEy.org.a(null);
        i.this.AEy.org.a(null);
        i.this.b(i.this.AEy);
        AppMethodBeat.o(30028);
      }
    };
    this.diw = new i.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(30029);
        i.this.AEy.org.a(null);
        i.this.AEy.org.a(null);
        i.this.b(i.this.AEy);
        AppMethodBeat.o(30029);
      }
    };
    this.AEz = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(30030);
        if ((paramAnonymousIntent.hasExtra("state")) && (paramAnonymousIntent.getIntExtra("state", 2) == 0)) {
          i.this.ehh();
        }
        AppMethodBeat.o(30030);
      }
    };
    this.audioManager = ((AudioManager)aj.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    aj.getContext().registerReceiver(this.AEz, localIntentFilter);
    AppMethodBeat.o(30031);
  }
  
  private static a a(a parama)
  {
    AppMethodBeat.i(30033);
    if (parama != null)
    {
      parama.org.stop();
      parama.org.a(null);
      parama.org.a(null);
      parama.AEB.clear();
    }
    AppMethodBeat.o(30033);
    return null;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(30034);
    while (parama != null) {
      if (parama.AEB.size() > 0)
      {
        bl localbl = (bl)parama.AEB.getLast();
        parama.AEB.removeLast();
        s.Y(localbl);
        String str = s.getFullPath(localbl.field_imgPath);
        ad.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localbl.field_msgId), str });
        if (parama.org.a(str, true, true, -1))
        {
          parama.org.a(this.div);
          parama.org.a(this.diw);
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
  
  public final void ehh()
  {
    AppMethodBeat.i(30032);
    a(this.AEy);
    AppMethodBeat.o(30032);
  }
  
  final class a
  {
    LinkedList<bl> AEB;
    com.tencent.mm.al.i org;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */