package com.tencent.mm.plugin.sport.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class k
  implements SensorEventListener
{
  private static long ptA = 0L;
  private static long ptB = 0L;
  private static long ptC = 0L;
  private static long ptD = 0L;
  private static long ptw = 0L;
  private static long ptx = 0L;
  private static long pty = 0L;
  private static long ptz = 0L;
  public c ptE;
  
  public k()
  {
    ptA = 0L;
    ptB = 0L;
    ptC = 0L;
    ptD = 0L;
    ptw = 0L;
    ptx = 0L;
    pty = 0L;
    ptz = 0L;
  }
  
  public static long bLs()
  {
    return pty;
  }
  
  public static long bLt()
  {
    return ptA;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    JSONObject localJSONObject = g.bLn();
    if (localJSONObject.optInt("deviceStepSwitch") != 1)
    {
      if (this.ptE != null) {
        this.ptE.bLl();
      }
      y.i("MicroMsg.Sport.SportStepDetector", "device step switch off");
    }
    int j;
    do
    {
      return;
      j = localJSONObject.optInt("stepCounterMaxStep5m", 3000);
      if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length <= 0)) {
        break;
      }
      y.i("MicroMsg.Sport.SportStepDetector", "Step change %f, accuracy %s, %s", new Object[] { Float.valueOf(paramSensorEvent.values[0]), Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
      l1 = bk.crX() / 10000L;
      if (ptA == 0L) {
        ptA = i.zl(202);
      }
      if (ptx == 0L) {
        ptx = i.zl(203);
      }
      if (pty == 0L) {
        pty = i.zl(201);
      }
      if (ptz == 0L) {
        ptz = pty;
      }
      if (ptB == 0L) {
        ptB = i.zl(204);
      }
      if (ptC == 0L) {
        ptC = ptB;
      }
      if (ptD == 0L) {
        ptD = i.zl(209);
      }
      y.i("MicroMsg.Sport.SportStepDetector", "currentVar: beginOfToday %d saveTodayTime %d preSensorStep %d currentTodayStep %d lastSaveSensorStep %d lastSaveStepTime %d preSysStepTime %d preSensorNanoTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(ptA), Long.valueOf(ptx), Long.valueOf(pty), Long.valueOf(ptz), Long.valueOf(ptB), Long.valueOf(ptC), Long.valueOf(ptD) });
      l2 = paramSensorEvent.values[0];
      ptw = l2;
    } while (l2 < 0L);
    long l4 = System.currentTimeMillis();
    long l5 = paramSensorEvent.timestamp;
    if (ptA != l1)
    {
      y.i("MicroMsg.Sport.SportStepDetector", "new day beginOfToday: %s saveTodayTime: %s, ", new Object[] { n.ce(10000L * l1), n.ce(ptA * 10000L) });
      i.S(202, l1);
      i.S(201, 0L);
      i.S(204, l4);
      i.S(209, paramSensorEvent.timestamp);
      i.S(203, (int)ptw);
      ptx = ptw;
      pty = 0L;
      ptz = 0L;
      ptA = l1;
      ptB = l4;
      ptC = l4;
      ptD = l5;
      return;
    }
    long l2 = i.zl(205);
    long l1 = 0L;
    long l3 = (l4 - ptC) / 300000L;
    int i;
    long l6;
    label568:
    long l7;
    boolean bool1;
    if ((l4 - ptC) % 300000L > 0L)
    {
      i = 1;
      l6 = l3 + i;
      l3 = (l5 / 1000000L - ptD / 1000000L) / 300000L;
      if ((l5 / 1000000L - ptD / 1000000L) % 300000L <= 0L) {
        break label956;
      }
      i = 1;
      l7 = l3 + i;
      y.i("MicroMsg.Sport.SportStepDetector", "timesOf5Minute(%d, %d). rebootTime: %d %s", new Object[] { Long.valueOf(l7), Long.valueOf(l6), Long.valueOf(l2), n.ce(l2) });
      bool1 = false;
      paramSensorEvent = "";
      if (l2 <= ptB) {
        break label961;
      }
      l3 = ptw - ptz;
      if ((l3 <= 0L) || ((l3 >= j * l7) && (l3 >= j * l6))) {
        break label1283;
      }
      paramSensorEvent = "rebootIncrease Valid Step diffStep > 0";
    }
    label1283:
    for (l1 = l3;; l1 = 0L)
    {
      l2 = l1;
      Object localObject = paramSensorEvent;
      if (l3 < 0L) {
        if (ptw >= j * l7)
        {
          l2 = l1;
          localObject = paramSensorEvent;
          if (ptw >= j * l6) {}
        }
        else
        {
          l2 = ptw;
          localObject = "rebootIncrease Valid Step diffStep < 0";
        }
      }
      i.S(205, 0L);
      l1 = l2;
      paramSensorEvent = (SensorEvent)localObject;
      bool1 = true;
      for (;;)
      {
        label749:
        y.i("MicroMsg.Sport.SportStepDetector", "increase step %s %d %b", new Object[] { paramSensorEvent, Long.valueOf(l1), Boolean.valueOf(bool1) });
        pty += l1;
        if ((l4 - ptB > localJSONObject.optInt("stepCounterSaveInterval", 60000)) || (ptw - ptz > localJSONObject.optInt("stepCounterSaveStep")) || (bool1))
        {
          i.S(201, pty);
          i.S(203, ptw);
          i.S(204, l4);
          i.S(209, l5);
          y.i("MicroMsg.Sport.SportStepDetector", "save to [file] currentTodayStep %d lastSaveSensorStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[] { Long.valueOf(pty), Long.valueOf(ptz), Long.valueOf(ptC), Long.valueOf(ptB), Long.valueOf(ptD) });
          ptB = l4;
          ptz = ptw;
        }
        for (;;)
        {
          ptx = ptw;
          ptC = l4;
          ptD = l5;
          return;
          i = 0;
          break;
          label956:
          i = 0;
          break label568;
          label961:
          if (ptw < ptx)
          {
            y.i("MicroMsg.Sport.SportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[] { Long.valueOf(ptw), Long.valueOf(ptx), Long.valueOf(ptz) });
            l2 = ptw;
            ptx = l2;
            ptz = l2;
            bool1 = true;
          }
          if ((ptw - ptx >= l7 * j) && (ptw - ptx >= l6 * j)) {
            break label1277;
          }
          l1 = ptw - ptx;
          paramSensorEvent = "normalIncrease Valid Step";
          break label749;
          y.i("MicroMsg.Sport.SportStepDetector", "save to cache currentTodayStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[] { Long.valueOf(pty), Long.valueOf(ptC), Long.valueOf(ptB), Long.valueOf(ptD) });
        }
        if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
        {
          if (paramSensorEvent == null)
          {
            bool1 = true;
            if (paramSensorEvent == null) {
              break label1183;
            }
          }
          label1183:
          for (boolean bool2 = true;; bool2 = false)
          {
            y.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            return;
            bool1 = false;
            break;
          }
        }
        y.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[] { Integer.valueOf(paramSensorEvent.accuracy), Long.valueOf(paramSensorEvent.timestamp) });
        i = 0;
        paramSensorEvent = paramSensorEvent.values;
        int k = paramSensorEvent.length;
        j = 0;
        while (j < k)
        {
          y.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramSensorEvent[j]) });
          j += 1;
          i += 1;
        }
        break;
        label1277:
        paramSensorEvent = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.k
 * JD-Core Version:    0.7.0.1
 */