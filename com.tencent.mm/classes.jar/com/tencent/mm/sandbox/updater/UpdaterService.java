package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class UpdaterService
  extends Service
{
  private static UpdaterService udC = null;
  static final long udE = 1800000L;
  private boolean euf = false;
  Map<Integer, a> udD = new HashMap();
  private am udF = new am(new UpdaterService.1(this), true);
  private UpdaterService.a udG = null;
  
  public static UpdaterService cqg()
  {
    return udC;
  }
  
  private boolean cqh()
  {
    if (this.udD.size() > 0)
    {
      Iterator localIterator = this.udD.values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          y.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
          return false;
        }
      }
    }
    y.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
    ai.l(new UpdaterService.2(this), 10000L);
    return true;
  }
  
  public static void dx()
  {
    y.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
    if (udC != null) {
      udC.cqh();
    }
  }
  
  private void e(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      a locala;
      do
      {
        return;
        int i = paramIntent.getIntExtra("intent_extra_download_type", 0);
        y.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[] { Integer.valueOf(i) });
        locala = (a)this.udD.get(Integer.valueOf(i));
      } while (locala == null);
      bool = locala.aj(paramIntent);
      y.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[] { Boolean.valueOf(bool) });
    } while (bool);
    cqh();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.UpdaterService", "onCreate");
    c.j(hashCode(), this);
    udC = this;
    this.udD.put(Integer.valueOf(0), j.a.udB);
    this.udD.put(Integer.valueOf(1), d.cpO());
    this.udD.put(Integer.valueOf(2), d.cpO());
    this.udD.put(Integer.valueOf(4), k.a.udI);
    this.udD.put(Integer.valueOf(5), k.a.udI);
    MMActivity.initLanguage(this);
    Object localObject = this.udF;
    long l = udE;
    ((am)localObject).S(l, l);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.udG = new UpdaterService.a();
    registerReceiver(this.udG, (IntentFilter)localObject);
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.UpdaterService", "onDestroy");
    this.udF.stopTimer();
    if (this.udG != null) {
      unregisterReceiver(this.udG);
    }
    if (this.euf) {
      stopForeground(true);
    }
    Iterator localIterator = this.udD.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onDestroy();
    }
    this.udD.clear();
    udC = null;
    c.k(hashCode(), this);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    y.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[] { paramIntent });
    e(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[] { paramIntent });
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
        break label111;
      }
      y.i("MicroMsg.UpdaterService", "runServiceInForground");
      PendingIntent localPendingIntent = PendingIntent.getService(this, 0, new Intent(), 0);
      startForeground(0, new Notification.Builder(this).setTicker("updater service running forground").setWhen(System.currentTimeMillis()).setContentTitle("Updater Service").setContentText("updater service running forground").setContentIntent(localPendingIntent).getNotification());
    }
    for (this.euf = true;; this.euf = true)
    {
      label111:
      do
      {
        e(paramIntent);
        return 2;
      } while ((Build.VERSION.SDK_INT >= 18) || (this.euf));
      startForeground(-1314, new Notification());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService
 * JD-Core Version:    0.7.0.1
 */