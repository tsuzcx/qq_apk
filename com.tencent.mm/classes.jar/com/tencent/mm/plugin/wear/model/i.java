package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class i
{
  private h.a bMf = new h.a()
  {
    public final void ug()
    {
      i.this.qSm.jZC.a(null);
      i.this.qSm.jZC.a(null);
      i.this.b(i.this.qSm);
    }
  };
  private h.b bMg = new i.2(this);
  AudioManager dui = (AudioManager)ae.getContext().getSystemService("audio");
  i.a qSm;
  BroadcastReceiver qSn = new i.3(this);
  
  public i()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    ae.getContext().registerReceiver(this.qSn, localIntentFilter);
  }
  
  private static i.a a(i.a parama)
  {
    if (parama != null)
    {
      parama.jZC.stop();
      parama.jZC.a(null);
      parama.jZC.a(null);
      parama.qSp.clear();
    }
    return null;
  }
  
  final void b(i.a parama)
  {
    while (parama != null)
    {
      if (parama.qSp.size() <= 0) {
        break label113;
      }
      bi localbi = (bi)parama.qSp.getLast();
      parama.qSp.removeLast();
      q.H(localbi);
      String str = q.getFullPath(localbi.field_imgPath);
      y.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[] { Long.valueOf(localbi.field_msgId), str });
      if (parama.jZC.a(str, true, true, -1))
      {
        parama.jZC.a(this.bMf);
        parama.jZC.a(this.bMg);
      }
    }
    return;
    label113:
    a(parama);
  }
  
  public final void bYS()
  {
    a(this.qSm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i
 * JD-Core Version:    0.7.0.1
 */