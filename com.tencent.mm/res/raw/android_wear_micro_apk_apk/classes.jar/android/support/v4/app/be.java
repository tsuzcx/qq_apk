package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class be
  implements am, an
{
  private Bundle ew;
  private RemoteViews fe;
  private RemoteViews ff;
  private int fl;
  private Notification.Builder fs;
  
  public be(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews1, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean4, ArrayList<String> paramArrayList, Bundle paramBundle, String paramString1, boolean paramBoolean5, String paramString2, RemoteViews paramRemoteViews2, RemoteViews paramRemoteViews3, int paramInt5)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setShowWhen(paramBoolean2).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews1).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      paramBoolean2 = true;
      paramContext = paramContext.setOngoing(paramBoolean2);
      if ((paramNotification.flags & 0x8) == 0) {
        break label345;
      }
      paramBoolean2 = true;
      label117:
      paramContext = paramContext.setOnlyAlertOnce(paramBoolean2);
      if ((paramNotification.flags & 0x10) == 0) {
        break label351;
      }
      paramBoolean2 = true;
      label137:
      paramContext = paramContext.setAutoCancel(paramBoolean2).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label357;
      }
    }
    label345:
    label351:
    label357:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      this.fs = paramContext.setFullScreenIntent(paramPendingIntent2, paramBoolean2).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean3).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1).setLocalOnly(paramBoolean4).setGroup(paramString1).setGroupSummary(paramBoolean5).setSortKey(paramString2);
      this.ew = new Bundle();
      if (paramBundle != null) {
        this.ew.putAll(paramBundle);
      }
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        this.ew.putStringArray("android.people", (String[])paramArrayList.toArray(new String[paramArrayList.size()]));
      }
      this.fe = paramRemoteViews2;
      this.ff = paramRemoteViews3;
      this.fl = paramInt5;
      return;
      paramBoolean2 = false;
      break;
      paramBoolean2 = false;
      break label117;
      paramBoolean2 = false;
      break label137;
    }
  }
  
  private static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  public final void a(bm parambm)
  {
    bd.a(this.fs, parambm);
  }
  
  public final Notification.Builder ay()
  {
    return this.fs;
  }
  
  public final Notification build()
  {
    this.fs.setExtras(this.ew);
    Notification localNotification = this.fs.build();
    if (this.fe != null) {
      localNotification.contentView = this.fe;
    }
    if (this.ff != null) {
      localNotification.bigContentView = this.ff;
    }
    if (this.fl != 0)
    {
      if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (this.fl == 2)) {
        b(localNotification);
      }
      if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) == 0) && (this.fl == 1)) {
        b(localNotification);
      }
    }
    return localNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.be
 * JD-Core Version:    0.7.0.1
 */