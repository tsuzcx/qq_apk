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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class bp
  implements am, an
{
  private final Bundle ew;
  private RemoteViews fe;
  private RemoteViews ff;
  private Notification.Builder fs;
  private List<Bundle> fy = new ArrayList();
  
  public bp(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews1, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean3, Bundle paramBundle, String paramString1, boolean paramBoolean4, String paramString2, RemoteViews paramRemoteViews2, RemoteViews paramRemoteViews3)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews1).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    boolean bool;
    if ((paramNotification.flags & 0x2) != 0)
    {
      bool = true;
      paramContext = paramContext.setOngoing(bool);
      if ((paramNotification.flags & 0x8) == 0) {
        break label349;
      }
      bool = true;
      label123:
      paramContext = paramContext.setOnlyAlertOnce(bool);
      if ((paramNotification.flags & 0x10) == 0) {
        break label355;
      }
      bool = true;
      label143:
      paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label361;
      }
      bool = true;
      label202:
      this.fs = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
      this.ew = new Bundle();
      if (paramBundle != null) {
        this.ew.putAll(paramBundle);
      }
      if (paramBoolean3) {
        this.ew.putBoolean("android.support.localOnly", true);
      }
      if (paramString1 != null)
      {
        this.ew.putString("android.support.groupKey", paramString1);
        if (!paramBoolean4) {
          break label367;
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
      bool = false;
      break;
      label349:
      bool = false;
      break label123;
      label355:
      bool = false;
      break label143;
      label361:
      bool = false;
      break label202;
      label367:
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
    Notification localNotification = this.fs.build();
    Object localObject = bo.a(localNotification);
    Bundle localBundle = new Bundle(this.ew);
    Iterator localIterator = this.ew.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Bundle)localObject).containsKey(str)) {
        localBundle.remove(str);
      }
    }
    ((Bundle)localObject).putAll(localBundle);
    localObject = bo.b(this.fy);
    if (localObject != null) {
      bo.a(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
    }
    if (this.fe != null) {
      localNotification.contentView = this.fe;
    }
    if (this.ff != null) {
      localNotification.bigContentView = this.ff;
    }
    return localNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.bp
 * JD-Core Version:    0.7.0.1
 */