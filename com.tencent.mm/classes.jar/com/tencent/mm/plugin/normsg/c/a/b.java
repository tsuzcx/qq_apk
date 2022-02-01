package com.tencent.mm.plugin.normsg.c.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.c.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  implements SensorEventListener
{
  final AtomicBoolean AEP;
  a AEQ;
  final Map<Integer, c> AER;
  final SensorManager mSensorManager;
  
  public b(a parama)
  {
    AppMethodBeat.i(187595);
    this.AEP = new AtomicBoolean(false);
    this.AEQ = null;
    this.AER = new HashMap();
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("sensor"));
    this.AEQ = parama;
    AppMethodBeat.o(187595);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(187596);
    for (;;)
    {
      int j;
      c localc;
      int i;
      long l2;
      try
      {
        j = a.TO(paramSensorEvent.sensor.getType());
        localc = (c)this.AER.get(Integer.valueOf(j));
        if (localc == null)
        {
          AppMethodBeat.o(187596);
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
            l2 = l1 - localc.AEV;
            if (!com.tencent.mm.plugin.normsg.c.a.a.b.Hx(l2))
            {
              if (l2 != 20L) {
                continue;
              }
              localc.a(paramSensorEvent);
            }
          }
          i = localc.AEU.size();
          if (i >= 20) {
            break label306;
          }
          paramSensorEvent = null;
          if (paramSensorEvent != null) {
            break label332;
          }
          AppMethodBeat.o(187596);
        }
        else
        {
          if (localc.AET) {
            break label354;
          }
          localc.AET = true;
          i = 1;
          continue;
        }
        if (0L != localc.AES.timestamp)
        {
          i = 1;
          if (i == 0) {
            break label277;
          }
          l2 = localc.AEV + 20L;
          if (Math.abs(l2 - localc.AES.timestamp) >= Math.abs(l2 - l1)) {
            break label268;
          }
          localc.a(localc.AES);
          continue;
        }
        i = 0;
      }
      catch (Throwable paramSensorEvent)
      {
        Log.e("MicroMsg.NormsgSensorListener", "onSensorChanged() error:" + paramSensorEvent.toString());
        AppMethodBeat.o(187596);
        return;
      }
      continue;
      label268:
      localc.a(paramSensorEvent);
      continue;
      label277:
      if (com.tencent.mm.plugin.normsg.c.a.a.b.Hy(l2))
      {
        localc.a(paramSensorEvent);
      }
      else
      {
        localc.AES.b(paramSensorEvent);
        continue;
        label306:
        paramSensorEvent = new ArrayList(localc.AEU);
        localc.AEU.clear();
        continue;
        label332:
        this.AEQ.p(j, paramSensorEvent);
        AppMethodBeat.o(187596);
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
    public abstract void hA(int paramInt1, int paramInt2);
    
    public abstract void p(int paramInt, List<com.tencent.mm.normsg.b> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.b
 * JD-Core Version:    0.7.0.1
 */