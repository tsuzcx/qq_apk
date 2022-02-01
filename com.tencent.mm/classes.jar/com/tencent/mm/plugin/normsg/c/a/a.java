package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Message;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements b.a
{
  private static final j<a> AEL;
  final b AEM;
  e AEN;
  final MMHandler luO;
  
  static
  {
    AppMethodBeat.i(187594);
    AEL = new j() {};
    AppMethodBeat.o(187594);
  }
  
  public a()
  {
    AppMethodBeat.i(187584);
    this.luO = new MMHandler("NormsgSensorEngineWorker")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(187583);
        try
        {
          localObject1 = a.this;
          i = paramAnonymousMessage.what;
          switch (i)
          {
          default: 
            AppMethodBeat.o(187583);
            return;
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          Log.e("MicroMsg.NormsgSensorEngine", "NormsgSensorEngineWorker handle msg error:" + paramAnonymousMessage.getMessage());
          AppMethodBeat.o(187583);
          return;
        }
        Log.d("MicroMsg.NormsgSensorEngine", "Start record sensor");
        Object localObject2 = (String)paramAnonymousMessage.obj;
        int i = paramAnonymousMessage.arg1;
        ((a)localObject1).luO.removeMessages(6);
        paramAnonymousMessage = ((a)localObject1).AEN;
        c.p.fa((String)localObject2, i, 200);
        if (paramAnonymousMessage.AEW) {
          c.p.fd();
        }
        localObject2 = paramAnonymousMessage.AEX.iterator();
        while (((Iterator)localObject2).hasNext()) {
          c.p.fe(((Integer)((Iterator)localObject2).next()).intValue());
        }
        paramAnonymousMessage = paramAnonymousMessage.AEY.iterator();
        while (paramAnonymousMessage.hasNext()) {
          c.p.ff(((Integer)paramAnonymousMessage.next()).intValue());
        }
        if (((a)localObject1).AEM.AEP.get())
        {
          Log.i("MicroMsg.NormsgSensorEngine", "SensorListener is already started");
          AppMethodBeat.o(187583);
          return;
        }
        paramAnonymousMessage = ((a)localObject1).AEM;
        paramAnonymousMessage.AER.clear();
        Object localObject1 = com.tencent.mm.plugin.normsg.c.a.a.b.AEZ;
        int k = localObject1.length;
        i = 0;
        label280:
        int m;
        if (i < k)
        {
          m = localObject1[i];
          if (com.tencent.mm.plugin.normsg.c.a.a.a.TO(m) != 0) {
            break label807;
          }
        }
        label800:
        label807:
        for (int j = 1;; j = 0)
        {
          if (j != 0)
          {
            Log.e("MicroMsg.NormsgSensorListener", "Unknown sensor type ".concat(String.valueOf(m)));
          }
          else
          {
            localObject2 = paramAnonymousMessage.mSensorManager.getDefaultSensor(m);
            j = com.tencent.mm.plugin.normsg.c.a.a.a.TO(m);
            if (localObject2 == null)
            {
              Log.i("MicroMsg.NormsgSensorListener", "Device has no sensor ".concat(String.valueOf(j)));
              paramAnonymousMessage.AEQ.hA(1, j);
            }
            else
            {
              c localc = new c((Sensor)localObject2);
              paramAnonymousMessage.AER.put(Integer.valueOf(j), localc);
              if (!paramAnonymousMessage.mSensorManager.registerListener(paramAnonymousMessage, (Sensor)localObject2, 0))
              {
                paramAnonymousMessage.AEQ.hA(2, j);
                break label800;
                if (paramAnonymousMessage.AER.isEmpty())
                {
                  paramAnonymousMessage.AEQ.hA(3, 0);
                  paramAnonymousMessage.AEP.set(false);
                  AppMethodBeat.o(187583);
                  return;
                }
                paramAnonymousMessage.AEP.set(true);
                AppMethodBeat.o(187583);
                return;
                i = paramAnonymousMessage.arg1;
                paramAnonymousMessage = (List)paramAnonymousMessage.obj;
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.isEmpty()))
                {
                  Log.e("MicroMsg.NormsgSensorEngine", "Sensor buffer is empty");
                  AppMethodBeat.o(187583);
                  return;
                }
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.isEmpty()))
                {
                  AppMethodBeat.o(187583);
                  return;
                }
                c.p.fb(i, paramAnonymousMessage);
                AppMethodBeat.o(187583);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Try stop record sensor");
                paramAnonymousMessage = (String)paramAnonymousMessage.obj;
                if (c.p.fg(paramAnonymousMessage))
                {
                  ((a)localObject1).aIV(paramAnonymousMessage);
                  AppMethodBeat.o(187583);
                  return;
                }
                i = c.p.fl(paramAnonymousMessage);
                if (i >= 0)
                {
                  c.p.fh(paramAnonymousMessage);
                  ((a)localObject1).a(4, paramAnonymousMessage, com.tencent.mm.plugin.normsg.c.a.a.b.TP(i));
                }
                AppMethodBeat.o(187583);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Stop record sensor immediate");
                ((a)localObject1).aIV((String)paramAnonymousMessage.obj);
                AppMethodBeat.o(187583);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Cancel record sensor");
                ((a)localObject1).aIW((String)paramAnonymousMessage.obj);
                AppMethodBeat.o(187583);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Stop sensor listener");
                if (((a)localObject1).AEM.AEP.get())
                {
                  paramAnonymousMessage = ((a)localObject1).AEM;
                  localObject2 = paramAnonymousMessage.AER.values().iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localc = (c)((Iterator)localObject2).next();
                    paramAnonymousMessage.mSensorManager.unregisterListener(paramAnonymousMessage, localc.pKK);
                  }
                  paramAnonymousMessage.AEP.set(false);
                  paramAnonymousMessage.AER.clear();
                }
                paramAnonymousMessage = ((a)localObject1).AEN;
                paramAnonymousMessage.AEW = false;
                paramAnonymousMessage.AEX.clear();
                paramAnonymousMessage.AEY.clear();
                c.p.fk();
                break;
              }
            }
          }
          i += 1;
          break label280;
        }
      }
    };
    this.AEM = new b(this);
    this.AEN = new e();
    AppMethodBeat.o(187584);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(187593);
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.obj = paramObject;
      this.luO.sendMessageDelayed(localMessage, paramLong);
      AppMethodBeat.o(187593);
      return;
    }
    catch (Throwable paramObject)
    {
      Log.e("MicroMsg.NormsgSensorEngine", "Send msg error: %s" + paramObject.getMessage());
      AppMethodBeat.o(187593);
    }
  }
  
  public static a exU()
  {
    AppMethodBeat.i(187585);
    a locala = (a)AEL.get();
    AppMethodBeat.o(187585);
    return locala;
  }
  
  private void exV()
  {
    AppMethodBeat.i(187590);
    a(6, 0, null, 0L);
    AppMethodBeat.o(187590);
  }
  
  public final void a(int paramInt, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(187592);
    a(paramInt, 0, paramObject, paramLong);
    AppMethodBeat.o(187592);
  }
  
  final void aIV(String paramString)
  {
    AppMethodBeat.i(187588);
    byte[] arrayOfByte = c.p.fi(paramString);
    if (arrayOfByte != null)
    {
      rz localrz = new rz();
      localrz.dYA.buffer = arrayOfByte;
      localrz.dYA.dYB = paramString;
      EventCenter.instance.publish(localrz);
    }
    for (;;)
    {
      aIW(paramString);
      AppMethodBeat.o(187588);
      return;
      Log.w("MicroMsg.NormsgSensorEngine", "Can't get encrypted sensor data: ".concat(String.valueOf(paramString)));
    }
  }
  
  final void aIW(String paramString)
  {
    AppMethodBeat.i(187589);
    c.p.fj(paramString);
    if (c.p.fc())
    {
      AppMethodBeat.o(187589);
      return;
    }
    exV();
    AppMethodBeat.o(187589);
  }
  
  public final void g(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(187591);
    a(paramInt1, paramInt2, paramObject, 0L);
    AppMethodBeat.o(187591);
  }
  
  public final void hA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187586);
    if (paramInt1 == 1)
    {
      this.AEN.AEY.add(Integer.valueOf(paramInt2));
      c.p.ff(paramInt2);
      AppMethodBeat.o(187586);
      return;
    }
    if (paramInt1 == 2)
    {
      this.AEN.AEX.add(Integer.valueOf(paramInt2));
      c.p.fe(paramInt2);
      AppMethodBeat.o(187586);
      return;
    }
    if (paramInt1 == 3)
    {
      this.AEN.AEW = true;
      c.p.fd();
    }
    AppMethodBeat.o(187586);
  }
  
  public final void p(int paramInt, List<com.tencent.mm.normsg.b> paramList)
  {
    AppMethodBeat.i(187587);
    g(2, paramInt, paramList);
    AppMethodBeat.o(187587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.a
 * JD-Core Version:    0.7.0.1
 */