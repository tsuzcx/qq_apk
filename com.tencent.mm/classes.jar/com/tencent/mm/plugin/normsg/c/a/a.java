package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.e.f.j;
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
  private static final j<a> MtV;
  final b MtY;
  e MtZ;
  final MMHandler rtv;
  
  static
  {
    AppMethodBeat.i(261924);
    MtV = new j() {};
    AppMethodBeat.o(261924);
  }
  
  public a()
  {
    AppMethodBeat.i(261898);
    this.rtv = new MMHandler("NormsgSensorEngineWorker")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(261925);
        try
        {
          localObject1 = a.this;
          i = paramAnonymousMessage.what;
          switch (i)
          {
          default: 
            AppMethodBeat.o(261925);
            return;
          }
        }
        finally
        {
          Log.e("MicroMsg.NormsgSensorEngine", "NormsgSensorEngineWorker handle msg error:" + paramAnonymousMessage.getMessage());
          AppMethodBeat.o(261925);
          return;
        }
        Log.d("MicroMsg.NormsgSensorEngine", "Start record sensor");
        Object localObject2 = (com.tencent.mm.plugin.normsg.c.a.a.b)paramAnonymousMessage.obj;
        int i = paramAnonymousMessage.arg1;
        ((a)localObject1).rtv.removeMessages(6);
        paramAnonymousMessage = ((a)localObject1).MtZ;
        c.p.fa(((com.tencent.mm.plugin.normsg.c.a.a.b)localObject2).Mur, i, ((com.tencent.mm.plugin.normsg.c.a.a.b)localObject2).Mup);
        if (paramAnonymousMessage.Mul) {
          c.p.fd();
        }
        localObject2 = paramAnonymousMessage.Mum.iterator();
        while (((Iterator)localObject2).hasNext()) {
          c.p.fe(((Integer)((Iterator)localObject2).next()).intValue());
        }
        paramAnonymousMessage = paramAnonymousMessage.Mun.iterator();
        while (paramAnonymousMessage.hasNext()) {
          c.p.ff(((Integer)paramAnonymousMessage.next()).intValue());
        }
        if (((a)localObject1).MtY.Mub.get())
        {
          Log.i("MicroMsg.NormsgSensorEngine", "SensorListener is already started");
          AppMethodBeat.o(261925);
          return;
        }
        paramAnonymousMessage = ((a)localObject1).MtY;
        paramAnonymousMessage.Mud.clear();
        paramAnonymousMessage.Mue = new HandlerThread("NSL");
        paramAnonymousMessage.Mue.start();
        paramAnonymousMessage.Muf = new Handler(paramAnonymousMessage.Mue.getLooper());
        Object localObject1 = com.tencent.mm.plugin.normsg.c.a.a.b.Muo;
        int k = localObject1.length;
        i = 0;
        label323:
        int m;
        if (i < k)
        {
          m = localObject1[i];
          if (com.tencent.mm.plugin.normsg.c.a.a.a.aeU(m) != 0) {
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
            j = com.tencent.mm.plugin.normsg.c.a.a.a.aeU(m);
            if (localObject2 == null)
            {
              Log.i("MicroMsg.NormsgSensorListener", "Device has no sensor ".concat(String.valueOf(j)));
              paramAnonymousMessage.Muc.kl(1, j);
            }
            else
            {
              c localc = new c((Sensor)localObject2);
              paramAnonymousMessage.Mud.put(Integer.valueOf(j), localc);
              if (!paramAnonymousMessage.mSensorManager.registerListener(paramAnonymousMessage, (Sensor)localObject2, 0, paramAnonymousMessage.Muf))
              {
                paramAnonymousMessage.Muc.kl(2, j);
                break label795;
                if (paramAnonymousMessage.Mud.isEmpty())
                {
                  paramAnonymousMessage.Muc.kl(3, 0);
                  paramAnonymousMessage.Mub.set(false);
                  if (paramAnonymousMessage.Mue != null)
                  {
                    paramAnonymousMessage.Mue.quit();
                    AppMethodBeat.o(261925);
                  }
                }
                else
                {
                  paramAnonymousMessage.Mub.set(true);
                }
                AppMethodBeat.o(261925);
                return;
                i = paramAnonymousMessage.arg1;
                paramAnonymousMessage = (List)paramAnonymousMessage.obj;
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.isEmpty()))
                {
                  Log.e("MicroMsg.NormsgSensorEngine", "Sensor buffer is empty");
                  AppMethodBeat.o(261925);
                  return;
                }
                if ((paramAnonymousMessage == null) || (paramAnonymousMessage.isEmpty()))
                {
                  AppMethodBeat.o(261925);
                  return;
                }
                c.p.fb(i, paramAnonymousMessage);
                AppMethodBeat.o(261925);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Try stop record sensor");
                paramAnonymousMessage = (String)paramAnonymousMessage.obj;
                if (c.p.fg(paramAnonymousMessage))
                {
                  ((a)localObject1).aQr(paramAnonymousMessage);
                  AppMethodBeat.o(261925);
                  return;
                }
                i = c.p.fl(paramAnonymousMessage);
                if (i >= 0)
                {
                  c.p.fh(paramAnonymousMessage);
                  ((a)localObject1).a(4, paramAnonymousMessage, com.tencent.mm.plugin.normsg.c.a.a.b.aeV(i));
                }
                AppMethodBeat.o(261925);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Stop record sensor immediate");
                ((a)localObject1).aQr((String)paramAnonymousMessage.obj);
                AppMethodBeat.o(261925);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Cancel record sensor");
                ((a)localObject1).aQs((String)paramAnonymousMessage.obj);
                AppMethodBeat.o(261925);
                return;
                Log.d("MicroMsg.NormsgSensorEngine", "Stop sensor listener");
                if (((a)localObject1).MtY.Mub.get()) {
                  ((a)localObject1).MtY.csv();
                }
                paramAnonymousMessage = ((a)localObject1).MtZ;
                paramAnonymousMessage.Mul = false;
                paramAnonymousMessage.Mum.clear();
                paramAnonymousMessage.Mun.clear();
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
    this.MtY = new b(this);
    this.MtZ = new e();
    AppMethodBeat.o(261898);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(261922);
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.obj = paramObject;
      this.rtv.sendMessageDelayed(localMessage, paramLong);
      AppMethodBeat.o(261922);
      return;
    }
    finally
    {
      Log.e("MicroMsg.NormsgSensorEngine", "Send msg error: %s" + paramObject.getMessage());
      AppMethodBeat.o(261922);
    }
  }
  
  public static a gtR()
  {
    AppMethodBeat.i(261904);
    a locala = (a)MtV.get();
    AppMethodBeat.o(261904);
    return locala;
  }
  
  private void gtS()
  {
    AppMethodBeat.i(261911);
    a(6, 0, null, 0L);
    AppMethodBeat.o(261911);
  }
  
  private void i(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(261918);
    a(paramInt1, paramInt2, paramObject, 0L);
    AppMethodBeat.o(261918);
  }
  
  public final void N(int paramInt, List<com.tencent.mm.normsg.b> paramList)
  {
    AppMethodBeat.i(261934);
    i(2, paramInt, paramList);
    AppMethodBeat.o(261934);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.normsg.c.a.a.b paramb)
  {
    AppMethodBeat.i(261928);
    i(1, paramInt, paramb);
    a(3, paramb.Mur, paramb.Muq);
    AppMethodBeat.o(261928);
  }
  
  final void a(int paramInt, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(261939);
    a(paramInt, 0, paramObject, paramLong);
    AppMethodBeat.o(261939);
  }
  
  final void aQr(String paramString)
  {
    AppMethodBeat.i(261936);
    byte[] arrayOfByte = c.p.fi(paramString);
    if (arrayOfByte != null) {
      d.Pmb.asyncReportSensorSceneInfoThroughCgi(paramString, arrayOfByte);
    }
    for (;;)
    {
      aQs(paramString);
      AppMethodBeat.o(261936);
      return;
      Log.w("MicroMsg.NormsgSensorEngine", "Can't get encrypted sensor data: ".concat(String.valueOf(paramString)));
    }
  }
  
  final void aQs(String paramString)
  {
    AppMethodBeat.i(261938);
    c.p.fj(paramString);
    if (c.p.fc())
    {
      AppMethodBeat.o(261938);
      return;
    }
    gtS();
    AppMethodBeat.o(261938);
  }
  
  public final void kl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261931);
    if (paramInt1 == 1)
    {
      this.MtZ.Mun.add(Integer.valueOf(paramInt2));
      c.p.ff(paramInt2);
      AppMethodBeat.o(261931);
      return;
    }
    if (paramInt1 == 2)
    {
      this.MtZ.Mum.add(Integer.valueOf(paramInt2));
      c.p.fe(paramInt2);
      AppMethodBeat.o(261931);
      return;
    }
    if (paramInt1 == 3)
    {
      this.MtZ.Mul = true;
      c.p.fd();
    }
    AppMethodBeat.o(261931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.a
 * JD-Core Version:    0.7.0.1
 */