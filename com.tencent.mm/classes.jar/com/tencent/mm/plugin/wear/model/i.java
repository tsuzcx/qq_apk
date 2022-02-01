package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;

public final class i
{
  a Dxl;
  BroadcastReceiver Dxm;
  AudioManager audioManager;
  private h.a drm;
  private h.b drn;
  
  public i()
  {
    AppMethodBeat.i(30031);
    this.drm = new h.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(30028);
        i.this.Dxl.pyq.a(null);
        i.this.Dxl.pyq.a(null);
        i.this.b(i.this.Dxl);
        AppMethodBeat.o(30028);
      }
    };
    this.drn = new h.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(30029);
        i.this.Dxl.pyq.a(null);
        i.this.Dxl.pyq.a(null);
        i.this.b(i.this.Dxl);
        AppMethodBeat.o(30029);
      }
    };
    this.Dxm = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(30030);
        if ((paramAnonymousIntent.hasExtra("state")) && (paramAnonymousIntent.getIntExtra("state", 2) == 0)) {
          i.this.eKH();
        }
        AppMethodBeat.o(30030);
      }
    };
    this.audioManager = ((AudioManager)aj.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    aj.getContext().registerReceiver(this.Dxm, localIntentFilter);
    AppMethodBeat.o(30031);
  }
  
  private static a a(a parama)
  {
    AppMethodBeat.i(30033);
    if (parama != null)
    {
      parama.pyq.stop();
      parama.pyq.a(null);
      parama.pyq.a(null);
      parama.Dxo.clear();
    }
    AppMethodBeat.o(30033);
    return null;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(30034);
    while (parama != null) {
      if (parama.Dxo.size() > 0)
      {
        bu localbu = (bu)parama.Dxo.getLast();
        parama.Dxo.removeLast();
        s.ab(localbu);
        String str = s.getFullPath(localbu.field_imgPath);
        ad.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localbu.field_msgId), str });
        if (parama.pyq.a(str, true, true, -1))
        {
          parama.pyq.a(this.drm);
          parama.pyq.a(this.drn);
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
  
  public final void eKH()
  {
    AppMethodBeat.i(30032);
    a(this.Dxl);
    AppMethodBeat.o(30032);
  }
  
  final class a
  {
    LinkedList<bu> Dxo;
    h pyq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */