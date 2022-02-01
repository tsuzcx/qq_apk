package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.notification.b.b;
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
    f.d locald = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(this.UYN.UYL).l(this.UYN.title).m(this.UYN.wording);
    locald.bor = ((PendingIntent)localObject);
    locald.q(2, true);
    localObject = locald.DA();
    ((Notification)localObject).icon = a.guX();
    ((Notification)localObject).flags |= 0x20;
    ((b)h.az(b.class)).getNotification().a(44, (Notification)localObject, false);
    AppMethodBeat.o(125457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.16
 * JD-Core Version:    0.7.0.1
 */