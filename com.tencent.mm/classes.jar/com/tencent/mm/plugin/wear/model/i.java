package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class i
{
  private h.a ctA;
  private h.b ctB;
  AudioManager elW;
  i.a uHt;
  BroadcastReceiver uHu;
  
  public i()
  {
    AppMethodBeat.i(26349);
    this.ctA = new h.a()
    {
      public final void Es()
      {
        AppMethodBeat.i(26346);
        i.this.uHt.mtU.a(null);
        i.this.uHt.mtU.a(null);
        i.this.b(i.this.uHt);
        AppMethodBeat.o(26346);
      }
    };
    this.ctB = new i.2(this);
    this.uHu = new i.3(this);
    this.elW = ((AudioManager)ah.getContext().getSystemService("audio"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    ah.getContext().registerReceiver(this.uHu, localIntentFilter);
    AppMethodBeat.o(26349);
  }
  
  private static i.a a(i.a parama)
  {
    AppMethodBeat.i(26351);
    if (parama != null)
    {
      parama.mtU.stop();
      parama.mtU.a(null);
      parama.mtU.a(null);
      parama.uHw.clear();
    }
    AppMethodBeat.o(26351);
    return null;
  }
  
  final void b(i.a parama)
  {
    AppMethodBeat.i(26352);
    while (parama != null) {
      if (parama.uHw.size() > 0)
      {
        bi localbi = (bi)parama.uHw.getLast();
        parama.uHw.removeLast();
        s.M(localbi);
        String str = s.getFullPath(localbi.field_imgPath);
        ab.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localbi.field_msgId), str });
        if (parama.mtU.a(str, true, true, -1))
        {
          parama.mtU.a(this.ctA);
          parama.mtU.a(this.ctB);
          AppMethodBeat.o(26352);
        }
      }
      else
      {
        a(parama);
      }
    }
    AppMethodBeat.o(26352);
  }
  
  public final void cYF()
  {
    AppMethodBeat.i(26350);
    a(this.uHt);
    AppMethodBeat.o(26350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */