package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.d.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements b.a
{
  private static final j<a> GxP;
  final b GxQ;
  e GxR;
  final MMHandler opL;
  
  static
  {
    AppMethodBeat.i(257635);
    GxP = new j() {};
    AppMethodBeat.o(257635);
  }
  
  public a()
  {
    AppMethodBeat.i(257620);
    this.opL = new MMHandler("NormsgSensorEngineWorker")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(257823);
        try
        {
          localObject1 = a.this;
          i = paramAnonymousMessage.what;
          switch (i)
          {
          default: 
            AppMethodBeat.o(257823);
            return;
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          Log.e("MicroMsg.NormsgSensorEngine", "NormsgSensorEngineWorker handle msg error:" + paramAnonymousMessage.getMessage());
          AppMethodBeat.o(257823);
          return;
        }
        Log.d("MicroMsg.NormsgSensorEngine", "Start record sensor");
        Object localObject2 = (com.tencent.mm.plugin.normsg.c.a.a.b)paramAnonymousMessage.obj;
        int i = paramAnonymousMessage.arg1;
        ((a)localObject1).opL.removeMessages(6);
        paramAnonymousMessage = ((a)localObject1).GxR;
        c.p.fa(((com.tencent.mm.plugin.normsg.c.a.a.b)localObject2).Gyj, i, ((com.tencent.mm.plugin.normsg.c.a.a.b)localObject2).Gyh);
        if (paramAnonymousMessage.Gyd) {
          c.p.fd();
        }
        localObject2 = paramAnonymousMessage.Gye.iterator();
        while (((Iterator)localObject2).hasNext()) {
          c.p.fe(((Integer)((Iterator)localObject2).next()).intValue());
        }
        paramAnonymousMessage = paramAnonymousMessage.Gyf.iterator();
        while (paramAnonymousMessage.hasNext()) {
          c.p.ff(((Integer)paramAnonymousMessage.next()).intValue());
        }
        if (((a)localObject1).GxQ.GxT.get())
        {
          Log.i("MicroMsg.NormsgSensorEngine", "SensorListener is already started");
          AppMethodBeat.o(257823);
          return;
        }
        paramAnonymousMessage = ((a)localObject1).GxQ;
        paramAnonymousMessage.GxV.clear();
        paramAnonymousMessage.GxW = new HandlerThread("NSL");
        paramAnonymousMessage.GxW.start();
        paramAnonymousMessage.GxX = new Handler(paramAnonymousMessage.GxW.getLooper());
        Object localObject1 = com.tencent.mm.plugin.normsg.c.a.a.b.Gyg;
        int k = localObject1.length;
        i = 0;
        label323:
        int m;
        if (i < k)
        {
          m = localObject1[i];
          if (com.tencent.mm.plugin.normsg.c.a.a.a.aaB(m) != 0) {
            break label802;
          }
        }
        label795:
        label802:
        for (int j = 1;; j = 0)
        {
          if (j != 0)
          {
            Log.e("MicroMsg.NormsgSensorListener", "Unknown sensor type ".concat(String.valueOf(m)));
          }
          else
          {
            localObject2 = paramAnonymousMessage.mSensorManager.getDefaultSensor(m);
            j = com.tencent.mm.plugin.normsg.c.a.a.a.aaB(m);
            if (localObject2 == null)
            {
              Log.i("MicroMsg.NormsgSensorListener", "Device has no sensor ".concat(String.valueOf(j)));
              paramAnonymousMessage.GxU.iF(1, j);
            }
            else
            {
              c localc = new c((Sensor)localObject2);
              paramAnonymousMessage.GxV.put(Integer.valueOf(j), localc);
              if (!paramAnonymousMessage.mSensorManager.registerListener(paramAnonymousMessage, (Sensor)localObject2, 0, paramAnonymousMessage.GxX))
              {
                paramAnonymousMessage.GxU.iF(2, j);
                break label795;
                if (paramAnonymousMessage.GxV.isEmpty())
                {
                  paramAnonymousMessage.GxU.iF(3, 0);
                  paramAnonymousMessage.GxT.set(false);
                  if (paramAnonymousMessage.GxW != null)
                  {
                    paramAnonymousMessage.GxW.quit();
                    AppMethodBeat.o(257823);
                  }
                }
                else
                {
                  paramAnonymousMessage.GxT.set(true);
                }
                AppMethodBeat.o(257823);
                return;
                i = paramAnonymousMessage.arg1;
                paramAnonymousMessage = (List)paramAnonymousMessage.obj;
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.isEmpty()))
                {
                  Log.e("MicroMsg.NormsgSensorEngine", "Sensor buffer is empty");
                  AppMethodBeat.o(257823);
                  return;
                }
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.isEmpty()))
                {
                  AppMethodBeat.o(257823);
                  return;
                }
                c.p.fb(i, paramAnonymousMessage);
                AppMethodBeat.o(257823);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Try stop record sensor");
                paramAnonymousMessage = (String)paramAnonymousMessage.obj;
                if (c.p.fg(paramAnonymousMessage))
                {
                  ((a)localObject1).aTr(paramAnonymousMessage);
                  AppMethodBeat.o(257823);
                  return;
                }
                i = c.p.fl(paramAnonymousMessage);
                if (i >= 0)
                {
                  c.p.fh(paramAnonymousMessage);
                  ((a)localObject1).a(4, paramAnonymousMessage, com.tencent.mm.plugin.normsg.c.a.a.b.aaC(i));
                }
                AppMethodBeat.o(257823);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Stop record sensor immediate");
                ((a)localObject1).aTr((String)paramAnonymousMessage.obj);
                AppMethodBeat.o(257823);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Cancel record sensor");
                ((a)localObject1).aTs((String)paramAnonymousMessage.obj);
                AppMethodBeat.o(257823);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Stop sensor listener");
                if (((a)localObject1).GxQ.GxT.get()) {
                  ((a)localObject1).GxQ.bSq();
                }
                paramAnonymousMessage = ((a)localObject1).GxR;
                paramAnonymousMessage.Gyd = false;
                paramAnonymousMessage.Gye.clear();
                paramAnonymousMessage.Gyf.clear();
                c.p.fk();
                break;
              }
            }
          }
          i += 1;
          break label323;
        }
      }
    };
    this.GxQ = new b(this);
    this.GxR = new e();
    AppMethodBeat.o(257620);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(257634);
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.obj = paramObject;
      this.opL.sendMessageDelayed(localMessage, paramLong);
      AppMethodBeat.o(257634);
      return;
    }
    catch (Throwable paramObject)
    {
      Log.e("MicroMsg.NormsgSensorEngine", "Send msg error: %s" + paramObject.getMessage());
      AppMethodBeat.o(257634);
    }
  }
  
  public static a fjy()
  {
    AppMethodBeat.i(257622);
    a locala = (a)GxP.get();
    AppMethodBeat.o(257622);
    return locala;
  }
  
  private void fjz()
  {
    AppMethodBeat.i(257630);
    a(6, 0, null, 0L);
    AppMethodBeat.o(257630);
  }
  
  public final void a(int paramInt, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(257633);
    a(paramInt, 0, paramObject, paramLong);
    AppMethodBeat.o(257633);
  }
  
  final void aTr(String paramString)
  {
    AppMethodBeat.i(257627);
    byte[] arrayOfByte = c.p.fi(paramString);
    if (arrayOfByte != null) {
      d.Jcm.asyncReportSensorSceneInfoThroughCgi(paramString, arrayOfByte);
    }
    for (;;)
    {
      aTs(paramString);
      AppMethodBeat.o(257627);
      return;
      Log.w("MicroMsg.NormsgSensorEngine", "Can't get encrypted sensor data: ".concat(String.valueOf(paramString)));
    }
  }
  
  final void aTs(String paramString)
  {
    AppMethodBeat.i(257628);
    c.p.fj(paramString);
    if (c.p.fc())
    {
      AppMethodBeat.o(257628);
      return;
    }
    fjz();
    AppMethodBeat.o(257628);
  }
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(257631);
    a(paramInt1, paramInt2, paramObject, 0L);
    AppMethodBeat.o(257631);
  }
  
  public final void iF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257624);
    if (paramInt1 == 1)
    {
      this.GxR.Gyf.add(Integer.valueOf(paramInt2));
      c.p.ff(paramInt2);
      AppMethodBeat.o(257624);
      return;
    }
    if (paramInt1 == 2)
    {
      this.GxR.Gye.add(Integer.valueOf(paramInt2));
      c.p.fe(paramInt2);
      AppMethodBeat.o(257624);
      return;
    }
    if (paramInt1 == 3)
    {
      this.GxR.Gyd = true;
      c.p.fd();
    }
    AppMethodBeat.o(257624);
  }
  
  public final void s(int paramInt, List<com.tencent.mm.normsg.b> paramList)
  {
    AppMethodBeat.i(257626);
    h(2, paramInt, paramList);
    AppMethodBeat.o(257626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.a
 * JD-Core Version:    0.7.0.1
 */