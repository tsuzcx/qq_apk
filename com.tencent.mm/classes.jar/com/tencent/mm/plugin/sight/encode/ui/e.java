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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.List;

final class e
  implements SensorEventListener
{
  private static int uKz = 2147483647;
  v fFt;
  boolean gXp;
  private Context mContext;
  Camera.PreviewCallback mPreviewCallback;
  private float uKB;
  private float uKC;
  private float uKD;
  private boolean uKQ;
  boolean uKx;
  private int uKy;
  com.tencent.mm.pluginsdk.j.a xGx;
  a xGy;
  
  public e()
  {
    AppMethodBeat.i(28778);
    this.gXp = false;
    this.fFt = null;
    this.uKx = false;
    this.uKy = 0;
    this.uKB = 0.0F;
    this.uKC = 0.0F;
    this.uKD = 0.0F;
    this.mPreviewCallback = null;
    this.mContext = null;
    this.uKQ = false;
    this.xGy = new a(Looper.getMainLooper());
    this.xGx = com.tencent.mm.pluginsdk.j.a.eMm();
    AppMethodBeat.o(28778);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(28779);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.uKB - f1) > 3.0F) || (Math.abs(this.uKC - f2) > 3.0F) || (Math.abs(this.uKD - f3) > 3.0F))
    {
      ac.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[] { Float.valueOf(3.0F) });
      a.f(this.fFt);
      this.uKB = f1;
      this.uKC = f2;
      this.uKD = f3;
    }
    AppMethodBeat.o(28779);
  }
  
  static final class a
    extends ao
  {
    static Camera.AutoFocusCallback gXw;
    static boolean uKR;
    float fTg;
    float fTh;
    int gXo = 0;
    boolean gXp = false;
    boolean gXq = false;
    boolean gXr = false;
    int gXs;
    int gXt;
    
    static
    {
      AppMethodBeat.i(28777);
      uKR = true;
      gXw = new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(28771);
          ac.v("MicroMsg.SightCamera", "auto focus callback");
          e.a.uKR = true;
          AppMethodBeat.o(28771);
        }
      };
      AppMethodBeat.o(28777);
    }
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private static int IP(int paramInt)
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
      int i = Float.valueOf(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 72) * paramFloat3).intValue();
      Object localObject = new RectF();
      ((RectF)localObject).set((paramFloat1 - i / 2) * 2000.0F / paramInt1 - 1000.0F, (paramFloat2 - i / 2) * 2000.0F / paramInt2 - 1000.0F, (i / 2 + paramFloat1) * 2000.0F / paramInt1 - 1000.0F, (i / 2 + paramFloat2) * 2000.0F / paramInt2 - 1000.0F);
      localObject = new Rect(IP(Math.round(((RectF)localObject).left)), IP(Math.round(((RectF)localObject).top)), IP(Math.round(((RectF)localObject).right)), IP(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(28772);
      return localObject;
    }
    
    static void f(v paramv)
    {
      AppMethodBeat.i(28773);
      if (paramv == null) {
        ac.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
      }
      if (!uKR)
      {
        ac.w("MicroMsg.SightCamera", "auto focus not back");
        AppMethodBeat.o(28773);
        return;
      }
      uKR = false;
      try
      {
        paramv.autoFocus(gXw);
        AppMethodBeat.o(28773);
        return;
      }
      catch (Exception paramv)
      {
        ac.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[] { paramv.getMessage() });
        uKR = true;
        AppMethodBeat.o(28773);
      }
    }
    
    private static int g(Camera.Parameters paramParameters)
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
          ac.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      AppMethodBeat.o(28774);
      return i;
    }
    
    static int h(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(28775);
      int j = g(paramParameters) / 6;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      AppMethodBeat.o(28775);
      return i;
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
        if ((this.gXs == 0) || (this.gXs == 0) || (d.la(14)))
        {
          f(paramMessage);
          AppMethodBeat.o(28776);
          return;
        }
        float f1 = this.fTg;
        float f2 = this.fTh;
        int i = this.gXs;
        j = this.gXt;
        if (paramMessage == null) {
          ac.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (!uKR)
        {
          ac.w("MicroMsg.SightCamera", "auto focus not back");
          AppMethodBeat.o(28776);
          return;
        }
        uKR = false;
        Object localObject2;
        try
        {
          ac.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          localObject2 = b(f1, f2, 1.0F, i, j);
          localObject1 = b(f1, f2, 1.5F, i, j);
          ac.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
          paramMessage.autoFocus(gXw);
          AppMethodBeat.o(28776);
          return;
        }
        catch (Exception paramMessage)
        {
          ac.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          uKR = true;
          AppMethodBeat.o(28776);
          return;
        }
        if (this.gXr)
        {
          AppMethodBeat.o(28776);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        ac.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.gXp), Integer.valueOf(this.gXo), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.gXo;
        if (this.gXp)
        {
          int k = g(localParameters);
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
          this.gXs = 0;
          this.gXt = 0;
          sendMessageDelayed(obtainMessage(4354, paramMessage.obj), 20L);
          continue;
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.gXq) {}
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
          if (this.gXq) {}
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
            ac.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.e
 * JD-Core Version:    0.7.0.1
 */