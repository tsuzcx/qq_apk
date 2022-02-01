package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class VoipCSMainUI$16
  implements MTimerHandler.CallBack
{
  VoipCSMainUI$16(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(125457);
    Object localObject = new Intent(MMApplicationContext.getContext(), VoipCSMainUI.class);
    localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 44, (Intent)localObject, 134217728);
    e.d locald = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(this.Okq.Oko).k(this.Okq.Ig).l(this.Okq.wording);
    locald.Ip = ((PendingIntent)localObject);
    locald.e(2, true);
    localObject = locald.gr();
    ((Notification)localObject).icon = com.tencent.mm.bx.a.fkG();
    ((Notification)localObject).flags |= 0x20;
    ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
    AppMethodBeat.o(125457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.16
 * JD-Core Version:    0.7.0.1
 */