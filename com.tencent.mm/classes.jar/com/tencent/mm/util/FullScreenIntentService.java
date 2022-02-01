package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.s.c;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.m.f;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.notification.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/util/FullScreenIntentService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "onTaskRemoved", "rootIntent", "onUnbind", "", "prepareCallingIntent", "stopService", "name", "Companion", "FullScreenOperationReceiver", "plugin-comm_release"})
public final class FullScreenIntentService
  extends Service
{
  public static final FullScreenIntentService.a HOF;
  private static final String TAG = "MicroMsg.FullScreenIntentService";
  
  static
  {
    AppMethodBeat.i(149840);
    HOF = new FullScreenIntentService.a((byte)0);
    TAG = "MicroMsg.FullScreenIntentService";
    AppMethodBeat.o(149840);
  }
  
  private static int cYf()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(149836);
    k.h(paramIntent, "intent");
    AppMethodBeat.o(149836);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(149834);
    ad.i(TAG, "FullScreenIntentService onCreate");
    AppMethodBeat.o(149834);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149835);
    ad.i(TAG, "FullScreenIntentService service onDestroy");
    c.cXx().cancel(41);
    stopForeground(true);
    AppMethodBeat.o(149835);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149833);
    int i;
    label89:
    Object localObject;
    String str1;
    boolean bool;
    PendingIntent localPendingIntent;
    if ((d.lh(28)) || (k.g(Build.VERSION.CODENAME, "Q")))
    {
      i = 1;
      if ((i != 0) && (paramIntent != null))
      {
        ad.i(TAG, "FullScreenIntentService calling service is on bind " + TAG + paramIntent.hasFileDescriptors());
        if ((!d.lh(28)) && (!k.g(Build.VERSION.CODENAME, "Q"))) {
          break label380;
        }
        i = 1;
        if ((i != 0) && (paramIntent != null))
        {
          ad.i(TAG, "FullScreenIntentService calling  service is on bind " + TAG + paramIntent.hasFileDescriptors());
          paramIntent.setClassName(getPackageName(), paramIntent.getStringExtra(b.HOI));
          localObject = (RemoteViews)paramIntent.getParcelableExtra(b.HOG);
          str1 = paramIntent.getStringExtra(b.HOH);
          paramIntent.setFlags(268435456);
          String str2 = paramIntent.getStringExtra(b.HOJ);
          bool = paramIntent.getBooleanExtra(b.HOK, false);
          localPendingIntent = PendingIntent.getActivity((Context)this, 0, paramIntent, 134217728);
          if (Build.VERSION.SDK_INT >= 26)
          {
            if (localObject == null) {
              break label386;
            }
            localObject = new s.c((Context)this, str2).dO().t("call").g(System.currentTimeMillis()).c((RemoteViews)localObject).d((RemoteViews)localObject).as(cYf()).a(localPendingIntent).f((CharSequence)getString(2131755866)).g((CharSequence)str1).c(localPendingIntent).dN().F(true);
            k.g(localObject, "NotificationCompat.Build…     .setAutoCancel(true)");
          }
        }
      }
    }
    for (;;)
    {
      localObject = ((s.c)localObject).build();
      if (bool) {
        ((Notification)localObject).flags |= 0x4;
      }
      try
      {
        if (aj.eFN()) {
          ad.i(TAG, "current mmprocess is exits");
        }
        c.cXx().notify(41, (Notification)localObject);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.i(TAG, "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(149833);
      return paramInt1;
      i = 0;
      break;
      label380:
      i = 0;
      break label89;
      label386:
      localObject = new s.c((Context)this, f.Ye()).dO().t("reminder").g(System.currentTimeMillis()).g((CharSequence)str1).f((CharSequence)getString(2131755866)).as(cYf()).a(localPendingIntent).c(localPendingIntent).dN().F(true);
      k.g(localObject, "NotificationCompat.Build…     .setAutoCancel(true)");
    }
  }
  
  public final void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(149839);
    k.h(paramIntent, "rootIntent");
    ad.i(TAG, "onTaskRemoved: %s", new Object[] { paramIntent });
    super.onTaskRemoved(paramIntent);
    c.cXx().cancel(41);
    stopSelf();
    AppMethodBeat.o(149839);
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(149837);
    k.h(paramIntent, "intent");
    ad.i(TAG, "FullScreenIntentService service onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(149837);
    return bool;
  }
  
  public final boolean stopService(Intent paramIntent)
  {
    AppMethodBeat.i(149838);
    k.h(paramIntent, "name");
    c.cXx().cancel(41);
    stopForeground(true);
    boolean bool = super.stopService(paramIntent);
    AppMethodBeat.o(149838);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.util.FullScreenIntentService
 * JD-Core Version:    0.7.0.1
 */