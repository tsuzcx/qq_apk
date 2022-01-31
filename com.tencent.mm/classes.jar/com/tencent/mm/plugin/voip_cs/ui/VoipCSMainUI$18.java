package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am.a;

final class VoipCSMainUI$18
  implements am.a
{
  VoipCSMainUI$18(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final boolean tC()
  {
    Object localObject = new Intent(ae.getContext(), VoipCSMainUI.class);
    localObject = PendingIntent.getActivity(ae.getContext(), 44, (Intent)localObject, 134217728);
    localObject = new Notification.Builder(ae.getContext()).setTicker(this.qeX.tickerText).setContentTitle(this.qeX.title).setContentText(this.qeX.bQZ).setContentIntent((PendingIntent)localObject).setOngoing(true).getNotification();
    ((Notification)localObject).icon = com.tencent.mm.bq.a.bSL();
    ((Notification)localObject).flags |= 0x20;
    ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.18
 * JD-Core Version:    0.7.0.1
 */