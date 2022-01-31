package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

public final class br
  implements am, an
{
  private Bundle ew;
  private RemoteViews fe;
  private RemoteViews ff;
  private Notification.Builder fs;
  private List<Bundle> fy = new ArrayList();
  
  public br(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews1, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean4, ArrayList<String> paramArrayList, Bundle paramBundle, String paramString1, boolean paramBoolean5, String paramString2, RemoteViews paramRemoteViews2, RemoteViews paramRemoteViews3)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setShowWhen(paramBoolean2).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews1).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      paramBoolean2 = true;
      paramContext = paramContext.setOngoing(paramBoolean2);
      if ((paramNotification.flags & 0x8) == 0) {
        break label392;
      }
      paramBoolean2 = true;
      label128:
      paramContext = paramContext.setOnlyAlertOnce(paramBoolean2);
      if ((paramNotification.flags & 0x10) == 0) {
        break label398;
      }
      paramBoolean2 = true;
      label148:
      paramContext = paramContext.setAutoCancel(paramBoolean2).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label404;
      }
      paramBoolean2 = true;
      label207:
      this.fs = paramContext.setFullScreenIntent(paramPendingIntent2, paramBoolean2).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean3).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
      this.ew = new Bundle();
      if (paramBundle != null) {
        this.ew.putAll(paramBundle);
      }
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        this.ew.putStringArray("android.people", (String[])paramArrayList.toArray(new String[paramArrayList.size()]));
      }
      if (paramBoolean4) {
        this.ew.putBoolean("android.support.localOnly", true);
      }
      if (paramString1 != null)
      {
        this.ew.putString("android.support.groupKey", paramString1);
        if (!paramBoolean5) {
          break label410;
        }
        this.ew.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramString2 != null) {
        this.ew.putString("android.support.sortKey", paramString2);
      }
      this.fe = paramRemoteViews2;
      this.ff = paramRemoteViews3;
      return;
      paramBoolean2 = false;
      break;
      label392:
      paramBoolean2 = false;
      break label128;
      label398:
      paramBoolean2 = false;
      break label148;
      label404:
      paramBoolean2 = false;
      break label207;
      label410:
      this.ew.putBoolean("android.support.useSideChannel", true);
    }
  }
  
  public final void a(bm parambm)
  {
    this.fy.add(bo.b(this.fs, parambm));
  }
  
  public final Notification.Builder ay()
  {
    return this.fs;
  }
  
  public final Notification build()
  {
    Object localObject = bo.b(this.fy);
    if (localObject != null) {
      this.ew.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
    }
    this.fs.setExtras(this.ew);
    localObject = this.fs.build();
    if (this.fe != null) {
      ((Notification)localObject).contentView = this.fe;
    }
    if (this.ff != null) {
      ((Notification)localObject).bigContentView = this.ff;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.br
 * JD-Core Version:    0.7.0.1
 */