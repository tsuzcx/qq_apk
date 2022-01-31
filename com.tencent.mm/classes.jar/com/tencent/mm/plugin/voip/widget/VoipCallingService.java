package com.tencent.mm.plugin.voip.widget;

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
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;

public class VoipCallingService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(140260);
    ab.i("MicroMsg.VoipCallingService", "VoipCalling onCreate");
    if ((d.iU(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label166;
      }
      Object localObject = new Intent(this, VideoActivity.class);
      ((Intent)localObject).setFlags(268435456);
      localObject = PendingIntent.getActivity(this, 0, (Intent)localObject, 134217728);
      s.c localc = new s.c(this, f.Mt());
      localc.mPriority = 1;
      localc.yu = "call";
      localObject = localc.g(System.currentTimeMillis()).Y(b.bYt()).b((PendingIntent)localObject);
      ((s.c)localObject).g(2, true);
      localObject = ((s.c)localObject).build();
      try
      {
        if (ah.dsZ()) {
          ab.i("MicroMsg.VoipCallingService", "current mmprocess is exits");
        }
        startForeground(41, (Notification)localObject);
        AppMethodBeat.o(140260);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.VoipCallingService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    label166:
    AppMethodBeat.o(140260);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(140261);
    ab.i("MicroMsg.VoipCallingService", "VoipCalling service onDestroy");
    ((a)g.G(a.class)).getNotification().cancel(41);
    stopForeground(true);
    AppMethodBeat.o(140261);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140258);
    int i;
    label82:
    Object localObject;
    PendingIntent localPendingIntent;
    RemoteViews localRemoteViews;
    if ((d.iU(28)) || (Build.VERSION.CODENAME.equals("Q")))
    {
      i = 1;
      if ((i != 0) && (paramIntent != null))
      {
        ab.i("MicroMsg.VoipCallingService", "voip calling service is on bind MicroMsg.VoipCallingService" + paramIntent.hasFileDescriptors());
        if ((!d.iU(28)) && (!Build.VERSION.CODENAME.equals("Q"))) {
          break label448;
        }
        i = 1;
        if ((i != 0) && (paramIntent != null))
        {
          ab.i("MicroMsg.VoipCallingService", "voip calling  service is on bind MicroMsg.VoipCallingService" + paramIntent.hasFileDescriptors());
          localObject = new Intent(this, VideoActivity.class);
          ((Intent)localObject).putExtra("Voip_User", paramIntent.getStringExtra("Voip_User"));
          ((Intent)localObject).putExtra("Voip_Outcall", paramIntent.getBooleanExtra("Voip_Outcall", true));
          ((Intent)localObject).putExtra("Voip_VideoCall", paramIntent.getBooleanExtra("Voip_VideoCall", true));
          ((Intent)localObject).putExtra("Voip_LastPage_Hash", paramIntent.getLongExtra("Voip_LastPage_Hash", 0L));
          ((Intent)localObject).setFlags(268435456);
          localPendingIntent = PendingIntent.getActivity(this, 0, (Intent)localObject, 134217728);
          localRemoteViews = new RemoteViews(ah.getPackageName(), 2130971107);
          localRemoteViews.setTextViewText(2131828819, s.nE(((j)g.E(j.class)).YA().arw(paramIntent.getStringExtra("Voip_User")).field_username));
          if (!paramIntent.getBooleanExtra("Voip_VideoCall", true)) {
            break label454;
          }
          localRemoteViews.setTextViewText(2131828820, getString(2131304700));
          localRemoteViews.setImageViewResource(2131828818, 2130840653);
        }
      }
    }
    for (;;)
    {
      localRemoteViews.setImageViewResource(2131822847, 2130840925);
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
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(140258);
      return paramInt1;
      i = 0;
      break;
      label448:
      i = 0;
      break label82;
      label454:
      localRemoteViews.setTextViewText(2131828820, getString(2131304699));
      localRemoteViews.setImageViewResource(2131828818, 2130840675);
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(140264);
    ab.i("MicroMsg.VoipCallingService", "onTaskRemoved: %s", new Object[] { paramIntent });
    super.onTaskRemoved(paramIntent);
    ((a)g.G(a.class)).getNotification().cancel(41);
    stopSelf();
    AppMethodBeat.o(140264);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(140262);
    ab.i("MicroMsg.VoipCallingService", "VoipCalling service onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(140262);
    return bool;
  }
  
  public boolean stopService(Intent paramIntent)
  {
    AppMethodBeat.i(140263);
    ((a)g.G(a.class)).getNotification().cancel(41);
    stopForeground(true);
    boolean bool = super.stopService(paramIntent);
    AppMethodBeat.o(140263);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipCallingService
 * JD-Core Version:    0.7.0.1
 */