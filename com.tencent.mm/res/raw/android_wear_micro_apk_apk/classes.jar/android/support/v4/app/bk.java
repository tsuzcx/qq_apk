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

public final class bk
  implements am, an
{
  private Notification.Builder ft;
  
  bk(Context paramContext, Notification paramNotification1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews1, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean4, String paramString1, ArrayList<String> paramArrayList, Bundle paramBundle, int paramInt5, int paramInt6, Notification paramNotification2, String paramString2, boolean paramBoolean5, String paramString3, CharSequence[] paramArrayOfCharSequence, RemoteViews paramRemoteViews2, RemoteViews paramRemoteViews3, RemoteViews paramRemoteViews4, String paramString4, int paramInt7, String paramString5, long paramLong, boolean paramBoolean6, boolean paramBoolean7, int paramInt8)
  {
    paramContext = new Notification.Builder(paramContext, paramString4).setWhen(paramNotification1.when).setShowWhen(paramBoolean2).setSmallIcon(paramNotification1.icon, paramNotification1.iconLevel).setContent(paramNotification1.contentView).setTicker(paramNotification1.tickerText, paramRemoteViews1).setSound(paramNotification1.sound, paramNotification1.audioStreamType).setVibrate(paramNotification1.vibrate).setLights(paramNotification1.ledARGB, paramNotification1.ledOnMS, paramNotification1.ledOffMS);
    if ((paramNotification1.flags & 0x2) != 0)
    {
      paramBoolean2 = true;
      paramContext = paramContext.setOngoing(paramBoolean2);
      if ((paramNotification1.flags & 0x8) == 0) {
        break label417;
      }
      paramBoolean2 = true;
      label119:
      paramContext = paramContext.setOnlyAlertOnce(paramBoolean2);
      if ((paramNotification1.flags & 0x10) == 0) {
        break label423;
      }
      paramBoolean2 = true;
      label139:
      paramContext = paramContext.setAutoCancel(paramBoolean2).setDefaults(paramNotification1.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification1.deleteIntent);
      if ((paramNotification1.flags & 0x80) == 0) {
        break label429;
      }
    }
    label417:
    label423:
    label429:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      this.ft = paramContext.setFullScreenIntent(paramPendingIntent2, paramBoolean2).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean3).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1).setLocalOnly(paramBoolean4).setExtras(paramBundle).setGroup(paramString2).setGroupSummary(paramBoolean5).setSortKey(paramString3).setCategory(paramString1).setColor(paramInt5).setVisibility(paramInt6).setPublicVersion(paramNotification2).setRemoteInputHistory(paramArrayOfCharSequence).setChannelId(paramString4).setBadgeIconType(paramInt7).setShortcutId(paramString5).setTimeoutAfter(paramLong).setGroupAlertBehavior(paramInt8);
      if (paramBoolean7) {
        this.ft.setColorized(paramBoolean6);
      }
      if (paramRemoteViews2 != null) {
        this.ft.setCustomContentView(paramRemoteViews2);
      }
      if (paramRemoteViews3 != null) {
        this.ft.setCustomBigContentView(paramRemoteViews3);
      }
      if (paramRemoteViews4 != null) {
        this.ft.setCustomHeadsUpContentView(paramRemoteViews4);
      }
      paramContext = paramArrayList.iterator();
      while (paramContext.hasNext())
      {
        paramNotification1 = (String)paramContext.next();
        this.ft.addPerson(paramNotification1);
      }
      paramBoolean2 = false;
      break;
      paramBoolean2 = false;
      break label119;
      paramBoolean2 = false;
      break label139;
    }
  }
  
  public final void a(bm parambm)
  {
    bh.a(this.ft, parambm);
  }
  
  public final Notification.Builder ay()
  {
    return this.ft;
  }
  
  public final Notification build()
  {
    return this.ft.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.bk
 * JD-Core Version:    0.7.0.1
 */