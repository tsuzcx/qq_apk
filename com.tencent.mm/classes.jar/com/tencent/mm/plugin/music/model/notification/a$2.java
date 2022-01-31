package com.tencent.mm.plugin.music.model.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  extends BroadcastReceiver
{
  a$2(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (bk.bl(paramIntent.getAction()))) {}
    com.tencent.mm.plugin.music.model.e.a locala;
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("mm_music_notification_action_key");
      if (bk.bl(paramContext))
      {
        y.e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
        return;
      }
      y.i("MicroMsg.Music.MMMusicNotification", "action:%s", new Object[] { paramContext });
      paramIntent = k.bnl().bmY();
      if (paramIntent == null)
      {
        y.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
        return;
      }
      locala = ((e)b.Q(e.class)).bna();
      if (locala == null)
      {
        y.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
        return;
      }
      if (paramContext.equals("mm_music_notification_action_play"))
      {
        paramIntent.resume();
        com.tencent.mm.plugin.music.model.d.d.a(2, locala);
        return;
      }
      if (paramContext.equals("mm_music_notification_action_pause"))
      {
        paramIntent.bmi();
        k.bnn().bmh();
        com.tencent.mm.plugin.music.model.d.d.a(3, locala);
        return;
      }
      if (paramContext.equals("mm_music_notification_action_pre"))
      {
        if (locala.field_musicType != 11) {
          if (((e)b.Q(e.class)).getMode() == 2) {
            ((e)b.Q(e.class)).bnf();
          }
        }
        for (;;)
        {
          a.a(locala, 13, paramIntent.bmk());
          com.tencent.mm.plugin.music.model.d.d.a(1, locala);
          return;
          paramIntent.iV(0);
          paramIntent.resume();
          continue;
          k.bnl().hR(true);
        }
      }
      if (paramContext.equals("mm_music_notification_action_next"))
      {
        if (locala.field_musicType != 11) {
          if (((e)b.Q(e.class)).getMode() == 2) {
            ((e)b.Q(e.class)).bne();
          }
        }
        for (;;)
        {
          a.a(locala, 14, paramIntent.bmk());
          com.tencent.mm.plugin.music.model.d.d.a(4, locala);
          return;
          paramIntent.iV(0);
          paramIntent.resume();
          continue;
          k.bnl().hR(true);
        }
      }
    } while (!paramContext.equals("mm_music_notification_action_close"));
    ai.d(this.mzP.mzN);
    paramIntent.stopPlay();
    com.tencent.mm.plugin.music.model.d.d.a(5, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a.2
 * JD-Core Version:    0.7.0.1
 */