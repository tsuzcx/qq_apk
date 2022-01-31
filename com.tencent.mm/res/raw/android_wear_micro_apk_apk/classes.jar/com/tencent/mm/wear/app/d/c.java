package com.tencent.mm.wear.app.d;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.Notification.WearableExtender;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import com.tencent.mm.e.a.n;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.ui.message.ReplyLuckyUI;
import java.io.IOException;

public final class c
{
  private static int acZ = 10000;
  private int ada;
  private n adb;
  
  public c(n paramn)
  {
    acZ += 1;
    this.ada = acZ;
    this.adb = paramn;
  }
  
  private Intent y(Context paramContext)
  {
    paramContext = new Intent(paramContext, ReplyLuckyUI.class);
    try
    {
      paramContext.putExtra("key_data", this.adb.toByteArray());
      label25:
      paramContext.putExtra("key_notification_id", this.ada);
      return paramContext;
    }
    catch (IOException localIOException)
    {
      break label25;
    }
  }
  
  public final void mE()
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(MMApplication.getContext(), this.ada, y(MMApplication.getContext()), 134217728);
    Notification.Builder localBuilder = new Notification.Builder(MMApplication.getContext());
    localBuilder.setSmallIcon(2130837543);
    localBuilder.setLargeIcon(BitmapFactory.decodeResource(MMApplication.getContext().getResources(), 2130837579));
    localBuilder.setContentTitle(d.n(this.adb.VN, this.adb.Vw));
    localBuilder.setContentText(d.o(this.adb.VN, this.adb.Vx));
    localBuilder.setPriority(2);
    localBuilder.setVibrate(new long[] { 0L, 800L, 500L, 800L });
    localBuilder.extend(new Notification.WearableExtender().setContentIcon(2130837581).setHintHideIcon(true).setContentAction(0).addAction(new Notification.Action(2130837581, "", localPendingIntent)));
    f.a(MMApplication.getContext(), this.ada, localBuilder.build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.c
 * JD-Core Version:    0.7.0.1
 */