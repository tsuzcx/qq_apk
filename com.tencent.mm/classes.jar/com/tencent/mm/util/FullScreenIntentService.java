package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.k.h;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.notification.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/FullScreenIntentService;", "Landroid/app/Service;", "()V", "getNotificationIconRs", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "flags", "startId", "onTaskRemoved", "rootIntent", "onUnbind", "", "prepareCallingIntent", "stopService", "name", "Companion", "FullScreenOperationReceiver", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FullScreenIntentService
  extends Service
{
  private static final String TAG;
  public static final FullScreenIntentService.a agsZ;
  
  static
  {
    AppMethodBeat.i(149840);
    agsZ = new FullScreenIntentService.a((byte)0);
    TAG = "MicroMsg.FullScreenIntentService";
    AppMethodBeat.o(149840);
  }
  
  private static int guX()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return c.d.notification_icon;
    }
    return c.d.notification_icon_gray;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(149836);
    s.u(paramIntent, "intent");
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
    f.MvN.cancel(41);
    stopForeground(true);
    AppMethodBeat.o(149835);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149833);
    int i;
    label89:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if ((d.rd(28)) || (s.p(Build.VERSION.CODENAME, "Q")))
    {
      i = 1;
      if ((i != 0) && (paramIntent != null))
      {
        Log.i(TAG, "FullScreenIntentService calling service is on bind " + TAG + paramIntent.hasFileDescriptors());
        if ((!d.rd(28)) && (!s.p(Build.VERSION.CODENAME, "Q"))) {
          break label442;
        }
        i = 1;
        if ((i != 0) && (paramIntent != null))
        {
          Log.i(TAG, "FullScreenIntentService calling  service is on bind " + TAG + paramIntent.hasFileDescriptors());
          localObject1 = getPackageName();
          localObject2 = paramIntent.getStringExtra(e.agtd);
          s.checkNotNull(localObject2);
          paramIntent.setClassName((String)localObject1, (String)localObject2);
          localObject3 = (RemoteViews)paramIntent.getParcelableExtra(e.agtb);
          localObject2 = paramIntent.getStringExtra(e.agtc);
          paramIntent.setFlags(268435456);
          Object localObject4 = paramIntent.getStringExtra(e.agte);
          bool = paramIntent.getBooleanExtra(e.agtf, false);
          localObject1 = PendingIntent.getActivity((Context)this, 0, paramIntent, 134217728);
          if (Build.VERSION.SDK_INT >= 26)
          {
            if (localObject3 == null) {
              break label448;
            }
            Context localContext = (Context)this;
            s.checkNotNull(localObject4);
            localObject4 = new f.d(localContext, (String)localObject4);
            ((f.d)localObject4).mPriority = 1;
            ((f.d)localObject4).boM = "call";
            localObject4 = ((f.d)localObject4).bt(System.currentTimeMillis());
            ((f.d)localObject4).boP = ((RemoteViews)localObject3);
            ((f.d)localObject4).boQ = ((RemoteViews)localObject3);
            localObject3 = ((f.d)localObject4).eb(guX());
            ((f.d)localObject3).bor = ((PendingIntent)localObject1);
            localObject1 = ((f.d)localObject3).l((CharSequence)getString(c.h.app_pushcontent_title)).m((CharSequence)localObject2).c((PendingIntent)localObject1);
            ((f.d)localObject1).q(2, true);
            localObject1 = ((f.d)localObject1).aC(true);
            s.s(localObject1, "Builder(this, channel!!)…     .setAutoCancel(true)");
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = ((f.d)localObject1).DA();
      s.s(localObject1, "builder.build()");
      if (bool) {
        ((Notification)localObject1).flags |= 0x4;
      }
      try
      {
        if (MMApplicationContext.isMMProcessExist()) {
          Log.i(TAG, "current mmprocess is exits");
        }
        f.MvN.c(41, (Notification)localObject1);
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
      label442:
      i = 0;
      break label89;
      label448:
      localObject3 = new f.d((Context)this, h.aQB());
      ((f.d)localObject3).mPriority = 1;
      ((f.d)localObject3).boM = "reminder";
      localObject2 = ((f.d)localObject3).bt(System.currentTimeMillis()).m((CharSequence)localObject2).l((CharSequence)getString(c.h.app_pushcontent_title)).eb(guX());
      ((f.d)localObject2).bor = ((PendingIntent)localObject1);
      localObject1 = ((f.d)localObject2).c((PendingIntent)localObject1);
      ((f.d)localObject1).q(2, true);
      localObject1 = ((f.d)localObject1).aC(true);
      s.s(localObject1, "Builder(this, Notificati…     .setAutoCancel(true)");
    }
  }
  
  public final void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(149839);
    s.u(paramIntent, "rootIntent");
    Log.i(TAG, "onTaskRemoved: %s", new Object[] { paramIntent });
    super.onTaskRemoved(paramIntent);
    f.MvN.cancel(41);
    stopSelf();
    AppMethodBeat.o(149839);
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(149837);
    s.u(paramIntent, "intent");
    Log.i(TAG, "FullScreenIntentService service onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(149837);
    return bool;
  }
  
  public final boolean stopService(Intent paramIntent)
  {
    AppMethodBeat.i(149838);
    s.u(paramIntent, "name");
    f.MvN.cancel(41);
    stopForeground(true);
    boolean bool = super.stopService(paramIntent);
    AppMethodBeat.o(149838);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.util.FullScreenIntentService
 * JD-Core Version:    0.7.0.1
 */