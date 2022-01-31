package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public final class bg
  implements am, an
{
  private Bundle ew;
  private RemoteViews fe;
  private RemoteViews ff;
  private RemoteViews fg;
  private int fl;
  private Notification.Builder fs;
  
  public bg(Context paramContext, Notification paramNotification1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews1, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean4, String paramString1, ArrayList<String> paramArrayList, Bundle paramBundle, int paramInt5, int paramInt6, Notification paramNotification2, String paramString2, boolean paramBoolean5, String paramString3, RemoteViews paramRemoteViews2, RemoteViews paramRemoteViews3, RemoteViews paramRemoteViews4, int paramInt7)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification1.when).setShowWhen(paramBoolean2).setSmallIcon(paramNotification1.icon, paramNotification1.iconLevel).setContent(paramNotification1.contentView).setTicker(paramNotification1.tickerText, paramRemoteViews1).setSound(paramNotification1.sound, paramNotification1.audioStreamType).setVibrate(paramNotification1.vibrate).setLights(paramNotification1.ledARGB, paramNotification1.ledOnMS, paramNotification1.ledOffMS);
    if ((paramNotification1.flags & 0x2) != 0)
    {
      paramBoolean2 = true;
      paramContext = paramContext.setOngoing(paramBoolean2);
      if ((paramNotification1.flags & 0x8) == 0) {
        break label345;
      }
      paramBoolean2 = true;
      label117:
      paramContext = paramContext.setOnlyAlertOnce(paramBoolean2);
      if ((paramNotification1.flags & 0x10) == 0) {
        break label351;
      }
      paramBoolean2 = true;
      label137:
      paramContext = paramContext.setAutoCancel(paramBoolean2).setDefaults(paramNotification1.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification1.deleteIntent);
      if ((paramNotification1.flags & 0x80) == 0) {
        break label357;
      }
    }
    label345:
    label351:
    label357:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      this.fs = paramContext.setFullScreenIntent(paramPendingIntent2, paramBoolean2).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean3).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1).setLocalOnly(paramBoolean4).setGroup(paramString2).setGroupSummary(paramBoolean5).setSortKey(paramString3).setCategory(paramString1).setColor(paramInt5).setVisibility(paramInt6).setPublicVersion(paramNotification2);
      this.ew = new Bundle();
      if (paramBundle != null) {
        this.ew.putAll(paramBundle);
      }
      paramContext = paramArrayList.iterator();
      while (paramContext.hasNext())
      {
        paramNotification1 = (String)paramContext.next();
        this.fs.addPerson(paramNotification1);
      }
      paramBoolean2 = false;
      break;
      paramBoolean2 = false;
      break label117;
      paramBoolean2 = false;
      break label137;
    }
    this.fe = paramRemoteViews2;
    this.ff = paramRemoteViews3;
    this.fg = paramRemoteViews4;
    this.fl = paramInt7;
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
    if (this.fg != null) {
      localNotification.headsUpContentView = this.fg;
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
 * Qualified Name:     android.support.v4.app.bg
 * JD-Core Version:    0.7.0.1
 */