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
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.List;

final class e
  implements SensorEventListener
{
  private static int vZI = 2147483647;
  v gaZ;
  boolean hsj;
  private Context mContext;
  Camera.PreviewCallback mPreviewCallback;
  boolean vZG;
  private int vZH;
  private float vZK;
  private float vZL;
  private float vZM;
  private boolean vZZ;
  com.tencent.mm.pluginsdk.l.a zlr;
  a zls;
  
  public e()
  {
    AppMethodBeat.i(28778);
    this.hsj = false;
    this.gaZ = null;
    this.vZG = false;
    this.vZH = 0;
    this.vZK = 0.0F;
    this.vZL = 0.0F;
    this.vZM = 0.0F;
    this.mPreviewCallback = null;
    this.mContext = null;
    this.vZZ = false;
    this.zls = new a(Looper.getMainLooper());
    this.zlr = com.tencent.mm.pluginsdk.l.a.feX();
    AppMethodBeat.o(28778);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(28779);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.vZK - f1) > 3.0F) || (Math.abs(this.vZL - f2) > 3.0F) || (Math.abs(this.vZM - f3) > 3.0F))
    {
      ae.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[] { Float.valueOf(3.0F) });
      a.f(this.gaZ);
      this.vZK = f1;
      this.vZL = f2;
      this.vZM = f3;
    }
    AppMethodBeat.o(28779);
  }
  
  static final class a
    extends aq
  {
    static Camera.AutoFocusCallback hsq;
    static boolean waa;
    float gpg;
    float gph;
    int hsi = 0;
    boolean hsj = false;
    boolean hsk = false;
    boolean hsl = false;
    int hsm;
    int hsn;
    
    static
    {
      AppMethodBeat.i(28777);
      waa = true;
      hsq = new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(28771);
          ae.v("MicroMsg.SightCamera", "auto focus callback");
          e.a.waa = true;
          AppMethodBeat.o(28771);
        }
      };
      AppMethodBeat.o(28777);
    }
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private static int KM(int paramInt)
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
    
    private static Rect b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(28772);
      int i = Float.valueOf(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 72) * paramFloat3).intValue();
      Object localObject = new RectF();
      ((RectF)localObject).set((paramFloat1 - i / 2) * 2000.0F / paramInt1 - 1000.0F, (paramFloat2 - i / 2) * 2000.0F / paramInt2 - 1000.0F, (i / 2 + paramFloat1) * 2000.0F / paramInt1 - 1000.0F, (i / 2 + paramFloat2) * 2000.0F / paramInt2 - 1000.0F);
      localObject = new Rect(KM(Math.round(((RectF)localObject).left)), KM(Math.round(((RectF)localObject).top)), KM(Math.round(((RectF)localObject).right)), KM(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(28772);
      return localObject;
    }
    
    private static int e(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(28774);
      if (paramParameters == null)
      {
        AppMethodBeat.o(28774);
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
          ae.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      AppMethodBeat.o(28774);
      return i;
    }
    
    static int f(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(28775);
      int j = e(paramParameters) / 6;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      AppMethodBeat.o(28775);
      return i;
    }
    
    static void f(v paramv)
    {
      AppMethodBeat.i(28773);
      if (paramv == null) {
        ae.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
      }
      if (!waa)
      {
        ae.w("MicroMsg.SightCamera", "auto focus not back");
        AppMethodBeat.o(28773);
        return;
      }
      waa = false;
      try
      {
        paramv.autoFocus(hsq);
        AppMethodBeat.o(28773);
        return;
      }
      catch (Exception paramv)
      {
        ae.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[] { paramv.getMessage() });
        waa = true;
        AppMethodBeat.o(28773);
      }
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int j = 1;
      AppMethodBeat.i(28776);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(28776);
        return;
        paramMessage = (v)paramMessage.obj;
        if ((this.hsm == 0) || (this.hsm == 0) || (d.lB(14)))
        {
          f(paramMessage);
          AppMethodBeat.o(28776);
          return;
        }
        float f1 = this.gpg;
        float f2 = this.gph;
        int i = this.hsm;
        j = this.hsn;
        if (paramMessage == null) {
          ae.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (!waa)
        {
          ae.w("MicroMsg.SightCamera", "auto focus not back");
          AppMethodBeat.o(28776);
          return;
        }
        waa = false;
        Object localObject2;
        try
        {
          ae.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          localObject2 = b(f1, f2, 1.0F, i, j);
          localObject1 = b(f1, f2, 1.5F, i, j);
          ae.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
          paramMessage.autoFocus(hsq);
          AppMethodBeat.o(28776);
          return;
        }
        catch (Exception paramMessage)
        {
          ae.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          waa = true;
          AppMethodBeat.o(28776);
          return;
        }
        if (this.hsl)
        {
          AppMethodBeat.o(28776);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        ae.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.hsj), Integer.valueOf(this.hsi), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.hsi;
        if (this.hsj)
        {
          int k = e(localParameters);
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
          this.hsm = 0;
          this.hsn = 0;
          sendMessageDelayed(obtainMessage(4354, paramMessage.obj), 20L);
          continue;
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.hsk) {}
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
          if (this.hsk) {}
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
            ae.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.e
 * JD-Core Version:    0.7.0.1
 */