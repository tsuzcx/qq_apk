package com.tencent.mm.plugin.voip.ui;

import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.plugin.voip.widget.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;

final class VideoActivity$9
  extends ah
{
  VideoActivity$9(VideoActivity paramVideoActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = new Intent();
    paramMessage.setClass(ae.getContext(), VoipForegroundService.class);
    paramMessage = PendingIntent.getService(ae.getContext(), 0, paramMessage, 134217728);
    paramMessage = d.a(new Notification.Builder(ae.getContext()).setContentIntent(paramMessage).setOngoing(true));
    paramMessage.icon = b.bSL();
    ((a)g.t(a.class)).getNotification().a(40, paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.9
 * JD-Core Version:    0.7.0.1
 */