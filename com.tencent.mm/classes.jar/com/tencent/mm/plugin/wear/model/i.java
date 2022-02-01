package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;

public final class i
{
  a DOQ;
  BroadcastReceiver DOR;
  AudioManager audioManager;
  private h.a dsr;
  private h.b dss;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.dsr = new h.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        i.this.DOQ.pEU.a(null);
        i.this.DOQ.pEU.a(null);
        i.this.b(i.this.DOQ);
        AppMethodBeat.o(30028);
      }
    };
    this.dss = new h.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(30029);
        i.this.DOQ.pEU.a(null);
        i.this.DOQ.pEU.a(null);
        i.this.b(i.this.DOQ);
        AppMethodBeat.o(30029);
      }
    };
    this.DOR = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(30030);
        if ((paramAnonymousIntent.hasExtra("state")) && (paramAnonymousIntent.getIntExtra("state", 2) == 0)) {
          i.this.eOp();
        }
        AppMethodBeat.o(30030);
      }
    };
    this.audioManager = ((AudioManager)ak.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    ak.getContext().registerReceiver(this.DOR, localIntentFilter);
    AppMethodBeat.o(30031);
  }
  
  private static a a(a parama)
  {
    AppMethodBeat.i(30033);
    if (parama != null)
    {
      parama.pEU.stop();
      parama.pEU.a(null);
      parama.pEU.a(null);
      parama.DOT.clear();
    }
    AppMethodBeat.o(30033);
    return null;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(30034);
    while (parama != null) {
      if (parama.DOT.size() > 0)
      {
        bv localbv = (bv)parama.DOT.getLast();
        parama.DOT.removeLast();
        s.aa(localbv);
        String str = s.getFullPath(localbv.field_imgPath);
        ae.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localbv.field_msgId), str });
        if (parama.pEU.a(str, true, true, -1))
        {
          parama.pEU.a(this.dsr);
          parama.pEU.a(this.dss);
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
  
  public final void eOp()
  {
    AppMethodBeat.i(30032);
    a(this.DOQ);
    AppMethodBeat.o(30032);
  }
  
  final class a
  {
    LinkedList<bv> DOT;
    h pEU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */