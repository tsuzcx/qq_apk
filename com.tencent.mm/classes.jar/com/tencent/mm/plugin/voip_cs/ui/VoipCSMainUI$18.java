package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoipCSMainUI$18
  implements ap.a
{
  VoipCSMainUI$18(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(135406);
    Object localObject = new Intent(ah.getContext(), VoipCSMainUI.class);
    localObject = PendingIntent.getActivity(ah.getContext(), 44, (Intent)localObject, 134217728);
    s.c localc = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(this.tLK.tickerText).e(this.tLK.title).f(this.tLK.cyA);
    localc.ya = ((PendingIntent)localObject);
    localc.g(2, true);
    localObject = localc.build();
    ((Notification)localObject).icon = com.tencent.mm.bp.a.bYt();
    ((Notification)localObject).flags |= 0x20;
    ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
    AppMethodBeat.o(135406);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.18
 * JD-Core Version:    0.7.0.1
 */