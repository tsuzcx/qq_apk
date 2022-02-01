package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/util/FullScreenIntentService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "onTaskRemoved", "rootIntent", "onUnbind", "", "prepareCallingIntent", "stopService", "name", "Companion", "FullScreenOperationReceiver", "plugin-comm_release"})
public final class FullScreenIntentService
  extends Service
{
  private static final String TAG = "MicroMsg.FullScreenIntentService";
  public static final FullScreenIntentService.a YyB;
  
  static
  {
    AppMethodBeat.i(149840);
    YyB = new FullScreenIntentService.a((byte)0);
    TAG = "MicroMsg.FullScreenIntentService";
    AppMethodBeat.o(149840);
  }
  
  private static int fkG()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return c.d.notification_icon;
    }
    return c.d.notification_icon_gray;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(149836);
    p.k(paramIntent, "intent");
    AppMethodBeat.o(149836);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(149834);
    Log.i(TAG, "FullScreenIntentService onCreate");
    AppMethodBeat.o(149834);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149835);
    Log.i(TAG, "FullScreenIntentService service onDestroy");
    com.tencent.mm.plugin.notification.d.fjX().cancel(41);
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
    if ((com.tencent.mm.compatible.util.d.qX(28)) || (p.h(Build.VERSION.CODENAME, "Q")))
    {
      i = 1;
      if ((i != 0) && (paramIntent != null))
      {
        Log.i(TAG, "FullScreenIntentService calling service is on bind " + TAG + paramIntent.hasFileDescriptors());
        if ((!com.tencent.mm.compatible.util.d.qX(28)) && (!p.h(Build.VERSION.CODENAME, "Q"))) {
          break label381;
        }
        i = 1;
        if ((i != 0) && (paramIntent != null))
        {
          Log.i(TAG, "FullScreenIntentService calling  service is on bind " + TAG + paramIntent.hasFileDescriptors());
          paramIntent.setClassName(getPackageName(), paramIntent.getStringExtra(e.YyE));
          localObject = (RemoteViews)paramIntent.getParcelableExtra(e.YyC);
          str1 = paramIntent.getStringExtra(e.YyD);
          paramIntent.setFlags(268435456);
          String str2 = paramIntent.getStringExtra(e.YyF);
          bool = paramIntent.getBooleanExtra(e.YyG, false);
          localPendingIntent = PendingIntent.getActivity((Context)this, 0, paramIntent, 134217728);
          if (Build.VERSION.SDK_INT >= 26)
          {
            if (localObject == null) {
              break label387;
            }
            localObject = new e.d((Context)this, str2).gq().z("call").e(System.currentTimeMillis()).c((RemoteViews)localObject).d((RemoteViews)localObject).bn(fkG()).a(localPendingIntent).k((CharSequence)getString(c.h.app_pushcontent_title)).l((CharSequence)str1).c(localPendingIntent).gp().W(true);
            p.j(localObject, "NotificationCompat.Build…     .setAutoCancel(true)");
          }
        }
      }
    }
    for (;;)
    {
      localObject = ((e.d)localObject).gr();
      if (bool) {
        ((Notification)localObject).flags |= 0x4;
      }
      try
      {
        if (MMApplicationContext.isMMProcessExist()) {
          Log.i(TAG, "current mmprocess is exits");
        }
        com.tencent.mm.plugin.notification.d.fjX().c(41, (Notification)localObject);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i(TAG, "start foreground service happened error %s", new Object[] { localException.getMessage() });
        }
      }
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(149833);
      return paramInt1;
      i = 0;
      break;
      label381:
      i = 0;
      break label89;
      label387:
      localObject = new e.d((Context)this, g.awc()).gq().z("reminder").e(System.currentTimeMillis()).l((CharSequence)str1).k((CharSequence)getString(c.h.app_pushcontent_title)).bn(fkG()).a(localPendingIntent).c(localPendingIntent).gp().W(true);
      p.j(localObject, "NotificationCompat.Build…     .setAutoCancel(true)");
    }
  }
  
  public final void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(149839);
    p.k(paramIntent, "rootIntent");
    Log.i(TAG, "onTaskRemoved: %s", new Object[] { paramIntent });
    super.onTaskRemoved(paramIntent);
    com.tencent.mm.plugin.notification.d.fjX().cancel(41);
    stopSelf();
    AppMethodBeat.o(149839);
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(149837);
    p.k(paramIntent, "intent");
    Log.i(TAG, "FullScreenIntentService service onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(149837);
    return bool;
  }
  
  public final boolean stopService(Intent paramIntent)
  {
    AppMethodBeat.i(149838);
    p.k(paramIntent, "name");
    com.tencent.mm.plugin.notification.d.fjX().cancel(41);
    stopForeground(true);
    boolean bool = super.stopService(paramIntent);
    AppMethodBeat.o(149838);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.util.FullScreenIntentService
 * JD-Core Version:    0.7.0.1
 */