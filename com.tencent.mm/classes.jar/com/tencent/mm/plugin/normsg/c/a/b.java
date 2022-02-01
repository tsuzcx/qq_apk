package com.tencent.mm.plugin.normsg.c.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.c.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  implements SensorEventListener
{
  final AtomicBoolean Mub;
  a Muc;
  final Map<Integer, c> Mud;
  HandlerThread Mue;
  Handler Muf;
  final SensorManager mSensorManager;
  
  public b(a parama)
  {
    AppMethodBeat.i(261900);
    this.Mub = new AtomicBoolean(false);
    this.Muc = null;
    this.Mud = new HashMap();
    this.Mue = null;
    this.Muf = null;
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("sensor"));
    this.Muc = parama;
    AppMethodBeat.o(261900);
  }
  
  public final void csv()
  {
    AppMethodBeat.i(261909);
    Iterator localIterator = this.Mud.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      this.mSensorManager.unregisterListener(this, localc.Mug);
    }
    this.Mub.set(false);
    this.Mud.clear();
    if (this.Mue != null) {
      this.Mue.quit();
    }
    AppMethodBeat.o(261909);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(261921);
    for (;;)
    {
      int j;
      c localc;
      int i;
      long l2;
      try
      {
        j = a.aeU(paramSensorEvent.sensor.getType());
        localc = (c)this.Mud.get(Integer.valueOf(j));
        if (localc == null)
        {
          AppMethodBeat.o(261921);
          return;
        }
        if ((paramSensorEvent == null) || (paramSensorEvent.values == null)) {
          break label349;
        }
        long l1;
        if (paramSensorEvent.timestamp <= 0L)
        {
          break label349;
          if (i == 0)
          {
            l1 = paramSensorEvent.timestamp / 1000000L;
            l2 = l1 - localc.Muk;
            if (!com.tencent.mm.plugin.normsg.c.a.a.b.sU(l2))
            {
              if (l2 != 20L) {
                continue;
              }
              localc.a(paramSensorEvent);
            }
          }
          i = localc.Muj.size();
          if (i >= 20) {
            break label306;
          }
          paramSensorEvent = null;
          if (paramSensorEvent != null) {
            break label332;
          }
          AppMethodBeat.o(261921);
        }
        else
        {
          if (localc.Mui) {
            break label354;
          }
          localc.Mui = true;
          i = 1;
          continue;
        }
        if (0L != localc.Muh.timestamp)
        {
          i = 1;
          if (i == 0) {
            break label277;
          }
          l2 = localc.Muk + 20L;
          if (Math.abs(l2 - localc.Muh.timestamp) >= Math.abs(l2 - l1)) {
            break label268;
          }
          localc.a(localc.Muh);
          continue;
        }
        i = 0;
      }
      finally
      {
        Log.e("MicroMsg.NormsgSensorListener", "onSensorChanged() error:" + paramSensorEvent.toString());
        AppMethodBeat.o(261921);
        return;
      }
      continue;
      label268:
      localc.a(paramSensorEvent);
      continue;
      label277:
      if (com.tencent.mm.plugin.normsg.c.a.a.b.sV(l2))
      {
        localc.a(paramSensorEvent);
      }
      else
      {
        localc.Muh.b(paramSensorEvent);
        continue;
        label306:
        paramSensorEvent = new ArrayList(localc.Muj);
        localc.Muj.clear();
        continue;
        label332:
        this.Muc.N(j, paramSensorEvent);
        AppMethodBeat.o(261921);
        return;
        label349:
        i = 1;
        continue;
        label354:
        i = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void N(int paramInt, List<com.tencent.mm.normsg.b> paramList);
    
    public abstract void kl(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.b
 * JD-Core Version:    0.7.0.1
 */