package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class i
{
  a Iyg;
  BroadcastReceiver Iyh;
  AudioManager audioManager;
  private k.a dJD;
  private k.b dJE;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.dJD = new k.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        i.this.Iyg.qUl.a(null);
        i.this.Iyg.qUl.a(null);
        i.this.b(i.this.Iyg);
        AppMethodBeat.o(30028);
      }
    };
    this.dJE = new k.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(30029);
        i.this.Iyg.qUl.a(null);
        i.this.Iyg.qUl.a(null);
        i.this.b(i.this.Iyg);
        AppMethodBeat.o(30029);
      }
    };
    this.Iyh = new i.3(this);
    this.audioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    MMApplicationContext.getContext().registerReceiver(this.Iyh, localIntentFilter);
    AppMethodBeat.o(30031);
  }
  
  private static a a(a parama)
  {
    AppMethodBeat.i(30033);
    if (parama != null)
    {
      parama.qUl.stop();
      parama.qUl.a(null);
      parama.qUl.a(null);
      parama.Iyj.clear();
    }
    AppMethodBeat.o(30033);
    return null;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(30034);
    while (parama != null) {
      if (parama.Iyj.size() > 0)
      {
        ca localca = (ca)parama.Iyj.getLast();
        parama.Iyj.removeLast();
        s.ak(localca);
        String str = s.getFullPath(localca.field_imgPath);
        Log.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localca.field_msgId), str });
        if (parama.qUl.a(str, true, true, -1))
        {
          parama.qUl.a(this.dJD);
          parama.qUl.a(this.dJE);
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
  
  public final void fVY()
  {
    AppMethodBeat.i(30032);
    a(this.Iyg);
    AppMethodBeat.o(30032);
  }
  
  final class a
  {
    LinkedList<ca> Iyj;
    k qUl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */