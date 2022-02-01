package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/model/PushStepChangeTask;", "Ljava/lang/Runnable;", "tickTime", "", "sensorStep", "sensorNanoTime", "process", "", "(JJJLjava/lang/String;)V", "getProcess", "()Ljava/lang/String;", "getSensorNanoTime", "()J", "getSensorStep", "getTickTime", "run", "", "Companion", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements Runnable
{
  public static final i.a SbO;
  private static volatile long SbS;
  private final long SbP;
  private final long SbQ;
  private final long SbR;
  private final String mzg;
  
  static
  {
    AppMethodBeat.i(263923);
    SbO = new i.a((byte)0);
    AppMethodBeat.o(263923);
  }
  
  public i(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(263919);
    this.SbP = paramLong1;
    this.SbQ = paramLong2;
    this.SbR = paramLong3;
    this.mzg = paramString;
    AppMethodBeat.o(263919);
  }
  
  public final void run()
  {
    AppMethodBeat.i(263932);
    if (SbS >= this.SbP)
    {
      Log.i("MicroMsg.Sport.PushSportTask", "PushStepChangeTask execute sync smaller nano time %s %s %s %s %s", new Object[] { Long.valueOf(this.SbQ), Long.valueOf(this.SbR), Long.valueOf(SbS), Long.valueOf(this.SbP), this.mzg });
      AppMethodBeat.o(263932);
      return;
    }
    Log.i("MicroMsg.Sport.PushSportTask", "PushStepChangeTask execute sync time sensorStep:" + this.SbQ + " sensorNanoTime:" + this.SbR + " lastTickTime:" + this.SbP + " process:" + this.mzg);
    SbS = this.SbP;
    Object localObject1;
    long l3;
    long l5;
    String str;
    JSONObject localJSONObject;
    int j;
    long l1;
    long l6;
    long l2;
    long l4;
    int i;
    long l7;
    label414:
    long l8;
    boolean bool;
    if (com.tencent.mm.kernel.h.az(PluginSport.class) != null)
    {
      localObject1 = ((PluginSport)com.tencent.mm.kernel.h.az(PluginSport.class)).getPushSportStepDetector();
      l3 = this.SbQ;
      l5 = this.SbR;
      str = this.mzg;
      localJSONObject = k.huj();
      if (localJSONObject.optInt("deviceStepSwitch") != 1)
      {
        ((h)localObject1).hue();
        Log.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
        AppMethodBeat.o(263932);
        return;
      }
      j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
      l1 = p.hut();
      if (l3 >= 0L)
      {
        l6 = cn.bDw();
        if (h.SbH != l1)
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", new Object[] { p.iY(l1), p.iY(h.SbH) });
          h.SbE = l3;
          h.SbF = 0L;
          h.SbG = 0L;
          h.SbH = l1;
          h.SbI = l6;
          h.SbJ = l6;
          h.SbK = l5;
          h.hug();
          AppMethodBeat.o(263932);
          return;
        }
        l2 = cn.bDw() - SystemClock.elapsedRealtime();
        l1 = 0L;
        l4 = (l6 - h.SbJ) / 300000L;
        if ((l6 - h.SbJ) % 300000L > 0L)
        {
          i = 1;
          l7 = l4 + i;
          l4 = (l5 / 1000000L - h.SbK / 1000000L) / 300000L;
          if ((l5 / 1000000L - h.SbK / 1000000L) % 300000L <= 0L) {
            break label800;
          }
          i = 1;
          l8 = l4 + i;
          bool = false;
          localObject1 = "";
          if (l2 <= h.SbI) {
            break label805;
          }
          Log.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", new Object[] { Long.valueOf(l2), p.iY(l2), Long.valueOf(h.SbI) });
          l4 = l3 - h.SbG;
          if ((l4 <= 0L) || ((l4 >= j * l8) && (l4 >= j * l7))) {
            break label946;
          }
          localObject1 = "rebootIncrease Valid Step diffStep > 0";
          l1 = l4;
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      l2 = l1;
      if (l4 < 0L) {
        if (l3 >= j * l8)
        {
          localObject2 = localObject1;
          l2 = l1;
          if (l3 >= j * l7) {}
        }
        else
        {
          localObject2 = "rebootIncrease Valid Step diffStep < 0";
          l2 = l3;
        }
      }
      bool = true;
      localObject1 = localObject2;
      for (;;)
      {
        Log.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", new Object[] { str, localObject1, Long.valueOf(l2), Boolean.valueOf(bool), Long.valueOf(h.SbL), Long.valueOf(h.SbF), Long.valueOf(h.SbG) });
        h.SbF += l2;
        h.SbL += l2;
        if ((l6 - h.SbI <= localJSONObject.optInt("stepCounterSaveInterval", 60000)) && (l3 - h.SbG <= localJSONObject.optInt("stepCounterSaveStep")) && (!bool)) {
          break label925;
        }
        h.SbI = l6;
        h.SbG = l3;
        h.SbE = l3;
        h.SbJ = l6;
        h.SbK = l5;
        h.hug();
        if (h.SbL < 500L) {
          break label940;
        }
        Log.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
        localObject1 = new Intent();
        ((Intent)localObject1).setPackage(MMApplicationContext.getContext().getPackageName());
        ((Intent)localObject1).setAction("com.tencent.mm.plugin.sport.uploadstep");
        MMApplicationContext.getContext().sendBroadcast((Intent)localObject1);
        h.SbL = 0L;
        AppMethodBeat.o(263932);
        return;
        i = 0;
        break;
        label800:
        i = 0;
        break label414;
        label805:
        if (l3 < h.SbE)
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(l3), Long.valueOf(h.SbE), Long.valueOf(h.SbG) });
          h.SbE = l3;
          h.SbG = l3;
          bool = true;
        }
        if ((l3 - h.SbE < l8 * j) || (l3 - h.SbE < j * l7))
        {
          l2 = l3 - h.SbE;
          localObject1 = "normalIncrease Valid Step";
        }
        else
        {
          Log.i("MicroMsg.Sport.PushSportStepDetector", "increase step too large, not like a person");
          l2 = l1;
        }
      }
      label925:
      h.SbE = l3;
      h.SbJ = l6;
      h.SbK = l5;
      label940:
      AppMethodBeat.o(263932);
      return;
      label946:
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.i
 * JD-Core Version:    0.7.0.1
 */