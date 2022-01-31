package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

final class e
  implements SensorEventListener
{
  private static int oGV = 2147483647;
  boolean eZZ;
  u eoH;
  private Context mContext;
  Camera.PreviewCallback mPreviewCallback;
  boolean oGT;
  private int oGU;
  private float oGX;
  private float oGY;
  private float oGZ;
  private boolean oHm;
  com.tencent.mm.pluginsdk.i.a qWJ;
  a qWK;
  
  public e()
  {
    AppMethodBeat.i(25106);
    this.eZZ = false;
    this.eoH = null;
    this.oGT = false;
    this.oGU = 0;
    this.oGX = 0.0F;
    this.oGY = 0.0F;
    this.oGZ = 0.0F;
    this.mPreviewCallback = null;
    this.mContext = null;
    this.oHm = false;
    this.qWK = new a(Looper.getMainLooper());
    this.qWJ = com.tencent.mm.pluginsdk.i.a.dmG();
    AppMethodBeat.o(25106);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(25107);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.oGX - f1) > 3.0F) || (Math.abs(this.oGY - f2) > 3.0F) || (Math.abs(this.oGZ - f3) > 3.0F))
    {
      ab.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[] { Float.valueOf(3.0F) });
      a.f(this.eoH);
      this.oGX = f1;
      this.oGY = f2;
      this.oGZ = f3;
    }
    AppMethodBeat.o(25107);
  }
  
  static final class a
    extends ak
  {
    static Camera.AutoFocusCallback fah;
    static boolean oHn;
    int eZY = 0;
    boolean eZZ = false;
    boolean faa = false;
    boolean fab = false;
    float fac;
    float fad;
    int fae;
    int faf;
    
    static
    {
      AppMethodBeat.i(25105);
      oHn = true;
      fah = new e.a.1();
      AppMethodBeat.o(25105);
    }
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private static Rect b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(25100);
      int i = Float.valueOf(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 72) * paramFloat3).intValue();
      Object localObject = new RectF();
      ((RectF)localObject).set((paramFloat1 - i / 2) * 2000.0F / paramInt1 - 1000.0F, (paramFloat2 - i / 2) * 2000.0F / paramInt2 - 1000.0F, (i / 2 + paramFloat1) * 2000.0F / paramInt1 - 1000.0F, (i / 2 + paramFloat2) * 2000.0F / paramInt2 - 1000.0F);
      localObject = new Rect(zs(Math.round(((RectF)localObject).left)), zs(Math.round(((RectF)localObject).top)), zs(Math.round(((RectF)localObject).right)), zs(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(25100);
      return localObject;
    }
    
    private static int f(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(25102);
      if (paramParameters == null)
      {
        AppMethodBeat.o(25102);
        return 0;
      }
      try
      {
        int j = paramParameters.getMaxZoom() / 2;
        i = j;
        if (j <= 0) {
          i = paramParameters.getMaxZoom();
        }
      }
      catch (Exception paramParameters)
      {
        for (;;)
        {
          ab.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      AppMethodBeat.o(25102);
      return i;
    }
    
    static void f(u paramu)
    {
      AppMethodBeat.i(25101);
      if (paramu == null) {
        ab.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
      }
      if (!oHn)
      {
        ab.w("MicroMsg.SightCamera", "auto focus not back");
        AppMethodBeat.o(25101);
        return;
      }
      oHn = false;
      try
      {
        paramu.autoFocus(fah);
        AppMethodBeat.o(25101);
        return;
      }
      catch (Exception paramu)
      {
        ab.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[] { paramu.getMessage() });
        oHn = true;
        AppMethodBeat.o(25101);
      }
    }
    
    static int h(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(25103);
      int j = f(paramParameters) / 6;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      AppMethodBeat.o(25103);
      return i;
    }
    
    private static int zs(int paramInt)
    {
      int i;
      if (paramInt > 1000) {
        i = 1000;
      }
      do
      {
        return i;
        i = paramInt;
      } while (paramInt >= -1000);
      return -1000;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int j = 1;
      AppMethodBeat.i(25104);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(25104);
        return;
        paramMessage = (u)paramMessage.obj;
        if ((this.fae == 0) || (this.fae == 0) || (d.fw(14)))
        {
          f(paramMessage);
          AppMethodBeat.o(25104);
          return;
        }
        float f1 = this.fac;
        float f2 = this.fad;
        int i = this.fae;
        j = this.faf;
        if (paramMessage == null) {
          ab.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (!oHn)
        {
          ab.w("MicroMsg.SightCamera", "auto focus not back");
          AppMethodBeat.o(25104);
          return;
        }
        oHn = false;
        Object localObject2;
        try
        {
          ab.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          localObject2 = b(f1, f2, 1.0F, i, j);
          localObject1 = b(f1, f2, 1.5F, i, j);
          ab.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
          localParameters = paramMessage.getParameters();
          Object localObject3 = localParameters.getSupportedFocusModes();
          if ((localObject3 != null) && (((List)localObject3).contains("auto"))) {
            localParameters.setFocusMode("auto");
          }
          if (localParameters.getMaxNumFocusAreas() > 0)
          {
            localObject3 = new ArrayList(1);
            ((ArrayList)localObject3).add(new Camera.Area((Rect)localObject2, 1000));
            localParameters.setFocusAreas((List)localObject3);
          }
          if (localParameters.getMaxNumMeteringAreas() > 0)
          {
            localObject2 = new ArrayList(1);
            ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
            localParameters.setMeteringAreas((List)localObject2);
          }
          paramMessage.setParameters(localParameters);
          paramMessage.autoFocus(fah);
          AppMethodBeat.o(25104);
          return;
        }
        catch (Exception paramMessage)
        {
          ab.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          oHn = true;
          AppMethodBeat.o(25104);
          return;
        }
        if (this.fab)
        {
          AppMethodBeat.o(25104);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        ab.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.eZZ), Integer.valueOf(this.eZY), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.eZY;
        if (this.eZZ)
        {
          int k = f(localParameters);
          if (i >= k)
          {
            i = k;
            label511:
            localParameters.setZoom(i);
          }
        }
        try
        {
          ((Camera)localObject1).setParameters(localParameters);
          if (j == 0) {
            continue;
          }
          this.fae = 0;
          this.faf = 0;
          sendMessageDelayed(obtainMessage(4354, paramMessage.obj), 20L);
          continue;
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.faa) {}
          for (long l = 10L;; l = 20L)
          {
            sendMessageDelayed((Message)localObject2, l);
            j = 0;
            break;
          }
          if (i <= 0)
          {
            i = 0;
            break label511;
          }
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.faa) {}
          for (l = 10L;; l = 20L)
          {
            sendMessageDelayed((Message)localObject2, l);
            j = 0;
            break;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.e
 * JD-Core Version:    0.7.0.1
 */