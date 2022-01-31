package com.tencent.mm.plugin.sport;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.sport.c.a;
import com.tencent.mm.plugin.sport.c.g.a;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Calendar;
import java.util.Random;

final class PluginSport$1
  implements g.a
{
  PluginSport$1(PluginSport paramPluginSport) {}
  
  public final void aYu()
  {
    if (PluginSport.access$000(this.psY) != null) {
      PluginSport.access$000(this.psY).bLi();
    }
    Context localContext;
    Object localObject2;
    Object localObject3;
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if ((n.ej(ae.getContext())) && (n.bKY()))
    {
      localContext = ae.getContext();
      localObject2 = (AlarmManager)ae.getContext().getSystemService("alarm");
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(12, 0);
      ((Calendar)localObject3).set(13, 0);
      ((Calendar)localObject3).set(14, 0);
      Random localRandom = new Random();
      ((Calendar)localObject3).set(11, 6);
      l1 = ((Calendar)localObject3).getTimeInMillis() + localRandom.nextInt(1800000);
      ((Calendar)localObject3).set(11, 12);
      l2 = ((Calendar)localObject3).getTimeInMillis() + localRandom.nextInt(1800000);
      ((Calendar)localObject3).set(11, 18);
      l3 = ((Calendar)localObject3).getTimeInMillis() + localRandom.nextInt(1800000);
      ((Calendar)localObject3).set(11, 21);
      l4 = ((Calendar)localObject3).getTimeInMillis() + localRandom.nextInt(1800000);
      ((Calendar)localObject3).set(11, 24);
      l5 = ((Calendar)localObject3).getTimeInMillis() + localRandom.nextInt(1800000);
      localObject3 = new Intent(localContext, SportService.class);
      ((Intent)localObject3).setFlags(268435456);
    }
    for (;;)
    {
      try
      {
        ((AlarmManager)localObject2).setRepeating(0, l1, 86400000L, PendingIntent.getService(localContext, 20481, (Intent)localObject3, 134217728));
        ((AlarmManager)localObject2).setRepeating(0, l2, 86400000L, PendingIntent.getService(localContext, 20482, (Intent)localObject3, 134217728));
        ((AlarmManager)localObject2).setRepeating(0, l3, 86400000L, PendingIntent.getService(localContext, 20483, (Intent)localObject3, 134217728));
        ((AlarmManager)localObject2).setRepeating(0, l4, 86400000L, PendingIntent.getService(localContext, 20484, (Intent)localObject3, 134217728));
        ((AlarmManager)localObject2).setRepeating(0, l5, 86400000L, PendingIntent.getService(localContext, 20485, (Intent)localObject3, 134217728));
        y.i("MicroMsg.Sport.SportAlarmLogic", "start sport alarm %s %s %s %s %s", new Object[] { n.ce(l1), n.ce(l2), n.ce(l3), n.ce(l4), n.ce(l5) });
        return;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", localException1, "startSportAlarm", new Object[0]);
        return;
      }
      Object localObject1 = ae.getContext();
      y.i("MicroMsg.Sport.SportAlarmLogic", "stop sport alarm");
      localObject2 = new Intent((Context)localObject1, SportService.class);
      try
      {
        localObject3 = PendingIntent.getService((Context)localObject1, 20481, (Intent)localObject2, 134217728);
        if (localObject3 != null) {
          ((PendingIntent)localObject3).cancel();
        }
        localObject3 = PendingIntent.getService((Context)localObject1, 20482, (Intent)localObject2, 134217728);
        if (localObject3 != null) {
          ((PendingIntent)localObject3).cancel();
        }
        localObject3 = PendingIntent.getService((Context)localObject1, 20483, (Intent)localObject2, 134217728);
        if (localObject3 != null) {
          ((PendingIntent)localObject3).cancel();
        }
        localObject3 = PendingIntent.getService((Context)localObject1, 20484, (Intent)localObject2, 134217728);
        if (localObject3 != null) {
          ((PendingIntent)localObject3).cancel();
        }
        localObject1 = PendingIntent.getService((Context)localObject1, 20485, (Intent)localObject2, 134217728);
        if (localObject1 != null)
        {
          ((PendingIntent)localObject1).cancel();
          return;
        }
      }
      catch (Exception localException2)
      {
        y.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", localException2, "stopSportAlarm", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport.1
 * JD-Core Version:    0.7.0.1
 */