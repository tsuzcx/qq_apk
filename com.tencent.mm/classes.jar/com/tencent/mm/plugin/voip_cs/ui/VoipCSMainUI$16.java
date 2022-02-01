package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au.a;

final class VoipCSMainUI$16
  implements au.a
{
  VoipCSMainUI$16(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(125457);
    Object localObject = new Intent(ai.getContext(), VoipCSMainUI.class);
    localObject = PendingIntent.getActivity(ai.getContext(), 44, (Intent)localObject, 134217728);
    s.c localc = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(this.AWb.tickerText).f(this.AWb.title).g(this.AWb.dlQ);
    localc.Fu = ((PendingIntent)localObject);
    localc.f(2, true);
    localObject = localc.build();
    ((Notification)localObject).icon = com.tencent.mm.bq.a.dlN();
    ((Notification)localObject).flags |= 0x20;
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
    AppMethodBeat.o(125457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.16
 * JD-Core Version:    0.7.0.1
 */