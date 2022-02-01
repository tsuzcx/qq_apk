package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av.a;

final class VoipCSMainUI$16
  implements av.a
{
  VoipCSMainUI$16(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(125457);
    Object localObject = new Intent(aj.getContext(), VoipCSMainUI.class);
    localObject = PendingIntent.getActivity(aj.getContext(), 44, (Intent)localObject, 134217728);
    s.c localc = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(this.zDO.tickerText).f(this.zDO.title).g(this.zDO.doh);
    localc.Ew = ((PendingIntent)localObject);
    localc.f(2, true);
    localObject = localc.build();
    ((Notification)localObject).icon = com.tencent.mm.br.a.cYf();
    ((Notification)localObject).flags |= 0x20;
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
    AppMethodBeat.o(125457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.16
 * JD-Core Version:    0.7.0.1
 */