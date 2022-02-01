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
  final AtomicBoolean GxT;
  a GxU;
  final Map<Integer, c> GxV;
  HandlerThread GxW;
  Handler GxX;
  final SensorManager mSensorManager;
  
  public b(a parama)
  {
    AppMethodBeat.i(257833);
    this.GxT = new AtomicBoolean(false);
    this.GxU = null;
    this.GxV = new HashMap();
    this.GxW = null;
    this.GxX = null;
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("sensor"));
    this.GxU = parama;
    AppMethodBeat.o(257833);
  }
  
  public final void bSq()
  {
    AppMethodBeat.i(257834);
    Iterator localIterator = this.GxV.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      this.mSensorManager.unregisterListener(this, localc.GxY);
    }
    this.GxT.set(false);
    this.GxV.clear();
    if (this.GxW != null) {
      this.GxW.quit();
    }
    AppMethodBeat.o(257834);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(257836);
    for (;;)
    {
      int j;
      c localc;
      int i;
      long l2;
      try
      {
        j = a.aaB(paramSensorEvent.sensor.getType());
        localc = (c)this.GxV.get(Integer.valueOf(j));
        if (localc == null)
        {
          AppMethodBeat.o(257836);
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
            l2 = l1 - localc.Gyc;
            if (!com.tencent.mm.plugin.normsg.c.a.a.b.OR(l2))
            {
              if (l2 != 20L) {
                continue;
              }
              localc.a(paramSensorEvent);
            }
          }
          i = localc.Gyb.size();
          if (i >= 20) {
            break label306;
          }
          paramSensorEvent = null;
          if (paramSensorEvent != null) {
            break label332;
          }
          AppMethodBeat.o(257836);
        }
        else
        {
          if (localc.Gya) {
            break label354;
          }
          localc.Gya = true;
          i = 1;
          continue;
        }
        if (0L != localc.GxZ.timestamp)
        {
          i = 1;
          if (i == 0) {
            break label277;
          }
          l2 = localc.Gyc + 20L;
          if (Math.abs(l2 - localc.GxZ.timestamp) >= Math.abs(l2 - l1)) {
            break label268;
          }
          localc.a(localc.GxZ);
          continue;
        }
        i = 0;
      }
      catch (Throwable paramSensorEvent)
      {
        Log.e("MicroMsg.NormsgSensorListener", "onSensorChanged() error:" + paramSensorEvent.toString());
        AppMethodBeat.o(257836);
        return;
      }
      continue;
      label268:
      localc.a(paramSensorEvent);
      continue;
      label277:
      if (com.tencent.mm.plugin.normsg.c.a.a.b.OS(l2))
      {
        localc.a(paramSensorEvent);
      }
      else
      {
        localc.GxZ.b(paramSensorEvent);
        continue;
        label306:
        paramSensorEvent = new ArrayList(localc.Gyb);
        localc.Gyb.clear();
        continue;
        label332:
        this.GxU.s(j, paramSensorEvent);
        AppMethodBeat.o(257836);
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
    public abstract void iF(int paramInt1, int paramInt2);
    
    public abstract void s(int paramInt, List<com.tencent.mm.normsg.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.b
 * JD-Core Version:    0.7.0.1
 */