package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.s.c;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.an;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.plugin.voip.widget.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;

public class MultiTalkCallingService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(140624);
    ab.i("MicroMsg.MultiTalkCallingService", "VoipForegroundService onCreate");
    if ((d.iU(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label178;
      }
      Object localObject1 = null;
      Object localObject2 = new Intent(ah.getContext(), MultiTalkMainUI.class);
      ((Intent)localObject2).setFlags(268435456);
      localObject2 = PendingIntent.getActivity(this, 0, (Intent)localObject2, 134217728);
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = new s.c(this, f.Mt());
        ((s.c)localObject1).mPriority = 1;
        ((s.c)localObject1).yu = "call";
        localObject1 = ((s.c)localObject1).g(System.currentTimeMillis()).Y(b.bYt()).b((PendingIntent)localObject2);
        ((s.c)localObject1).g(2, true);
        localObject1 = ((s.c)localObject1).build();
      }
      try
      {
        if (ah.dsZ()) {
          ab.i("MicroMsg.MultiTalkCallingService", "current mmprocess is exits");
        }
        startForeground(41, (Notification)localObject1);
        AppMethodBeat.o(140624);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MultiTalkCallingService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    label178:
    AppMethodBeat.o(140624);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(140625);
    ab.i("MicroMsg.MultiTalkCallingService", "VoipForegroundService onDestroy");
    ((a)g.G(a.class)).getNotification().cancel(41);
    stopForeground(true);
    AppMethodBeat.o(140625);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140622);
    if ((d.iU(28)) || (Build.VERSION.CODENAME.equals("Q")))
    {
      i = 1;
      if ((i != 0) && (paramIntent != null))
      {
        ab.i("MicroMsg.MultiTalkCallingService", "calling service is on bind MicroMsg.MultiTalkCallingService" + paramIntent.hasFileDescriptors());
        if ((!d.iU(28)) && (!Build.VERSION.CODENAME.equals("Q"))) {
          break label397;
        }
      }
    }
    label397:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramIntent != null))
      {
        ab.i("MicroMsg.MultiTalkCallingService", "multitalk calling  service is on bind MicroMsg.MultiTalkCallingService" + paramIntent.hasFileDescriptors());
        Object localObject = new Intent(ah.getContext(), MultiTalkMainUI.class);
        ((Intent)localObject).putExtra("Voip_User", paramIntent.getStringExtra("Voip_User"));
        ((Intent)localObject).setFlags(268435456);
        PendingIntent localPendingIntent = PendingIntent.getActivity(ah.getContext(), 43, (Intent)localObject, 134217728);
        RemoteViews localRemoteViews = new RemoteViews(getPackageName(), 2130971107);
        localRemoteViews.setTextViewText(2131828820, getString(2131301681));
        localRemoteViews.setTextViewText(2131828819, s.nE(((j)g.E(j.class)).YA().arw(paramIntent.getStringExtra("Voip_User")).field_username));
        localRemoteViews.setImageViewResource(2131822847, 2130840925);
        localRemoteViews.setImageViewResource(2131828818, 2130840675);
        localObject = null;
        if (Build.VERSION.SDK_INT >= 26)
        {
          localObject = new s.c(this, f.Mt());
          ((s.c)localObject).mPriority = 1;
          ((s.c)localObject).yu = "call";
          localObject = ((s.c)localObject).f(paramIntent.getStringExtra("Voip_User")).e(paramIntent.getStringExtra("Voip_User")).g(System.currentTimeMillis()).Y(b.bYt());
          ((s.c)localObject).yw = localRemoteViews;
          localObject = ((s.c)localObject).b(localPendingIntent);
          ((s.c)localObject).g(2, true);
        }
        localObject = ((s.c)localObject).build();
        ((a)g.G(a.class)).getNotification().a(41, (Notification)localObject, false);
      }
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(140622);
      return paramInt1;
      i = 0;
      break;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(140628);
    ab.i("MicroMsg.MultiTalkCallingService", "onTaskRemoved: %s", new Object[] { paramIntent });
    super.onTaskRemoved(paramIntent);
    ((a)g.G(a.class)).getNotification().cancel(41);
    stopSelf();
    AppMethodBeat.o(140628);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(140626);
    ab.i("MicroMsg.MultiTalkCallingService", "VoipForegroundService onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(140626);
    return bool;
  }
  
  public boolean stopService(Intent paramIntent)
  {
    AppMethodBeat.i(140627);
    ((a)g.G(a.class)).getNotification().cancel(41);
    stopForeground(true);
    boolean bool = super.stopService(paramIntent);
    AppMethodBeat.o(140627);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkCallingService
 * JD-Core Version:    0.7.0.1
 */