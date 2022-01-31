package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

public final class ba
  implements an
{
  private Notification.Builder mBuilder;
  
  ba(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      bool = true;
      paramContext = paramContext.setOngoing(bool);
      if ((paramNotification.flags & 0x8) == 0) {
        break label224;
      }
      bool = true;
      label112:
      paramContext = paramContext.setOnlyAlertOnce(bool);
      if ((paramNotification.flags & 0x10) == 0) {
        break label230;
      }
      bool = true;
      label132:
      paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label236;
      }
    }
    label224:
    label230:
    label236:
    for (boolean bool = true;; bool = false)
    {
      this.mBuilder = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setProgress(paramInt2, paramInt3, paramBoolean);
      return;
      bool = false;
      break;
      bool = false;
      break label112;
      bool = false;
      break label132;
    }
  }
  
  public final Notification.Builder ay()
  {
    return this.mBuilder;
  }
  
  public final Notification build()
  {
    return this.mBuilder.getNotification();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ba
 * JD-Core Version:    0.7.0.1
 */