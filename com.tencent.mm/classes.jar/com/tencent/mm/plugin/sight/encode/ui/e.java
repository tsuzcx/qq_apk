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
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;

final class e
  implements SensorEventListener
{
  private static int KUY = 2147483647;
  boolean KUV;
  boolean KUW;
  int KUX;
  private float KVa;
  private float KVb;
  private float KVc;
  private boolean KVp;
  com.tencent.mm.pluginsdk.l.a PJl;
  Camera.PreviewCallback PJm;
  a PJn;
  w lTN;
  private Context mContext;
  
  public e()
  {
    AppMethodBeat.i(28778);
    this.KUV = false;
    this.lTN = null;
    this.KUW = false;
    this.KUX = 0;
    this.KVa = 0.0F;
    this.KVb = 0.0F;
    this.KVc = 0.0F;
    this.PJm = null;
    this.mContext = null;
    this.KVp = false;
    this.PJn = new a(Looper.getMainLooper());
    this.PJl = com.tencent.mm.pluginsdk.l.a.iJR();
    AppMethodBeat.o(28778);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(28779);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.KVa - f1) > 3.0F) || (Math.abs(this.KVb - f2) > 3.0F) || (Math.abs(this.KVc - f3) > 3.0F))
    {
      Log.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[] { Float.valueOf(3.0F) });
      a.h(this.lTN);
      this.KVa = f1;
      this.KVb = f2;
      this.KVc = f3;
    }
    AppMethodBeat.o(28779);
  }
  
  static final class a
    extends MMHandler
  {
    static boolean KVq;
    static Camera.AutoFocusCallback nuM;
    boolean KUV = false;
    int KVx = 0;
    boolean KVy = false;
    float mkm;
    float mkn;
    boolean nGA = false;
    int nGM;
    int nGN;
    
    static
    {
      AppMethodBeat.i(28777);
      KVq = true;
      nuM = new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(28771);
          Log.v("MicroMsg.SightCamera", "auto focus callback");
          e.a.KVq = true;
          AppMethodBeat.o(28771);
        }
      };
      AppMethodBeat.o(28777);
    }
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(28772);
      int i = Float.valueOf(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 72) * paramFloat3).intValue();
      Object localObject = new RectF();
      ((RectF)localObject).set((paramFloat1 - i / 2) * 2000.0F / paramInt1 - 1000.0F, (paramFloat2 - i / 2) * 2000.0F / paramInt2 - 1000.0F, (i / 2 + paramFloat1) * 2000.0F / paramInt1 - 1000.0F, (i / 2 + paramFloat2) * 2000.0F / paramInt2 - 1000.0F);
      localObject = new Rect(abd(Math.round(((RectF)localObject).left)), abd(Math.round(((RectF)localObject).top)), abd(Math.round(((RectF)localObject).right)), abd(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(28772);
      return localObject;
    }
    
    private static int abd(int paramInt)
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
    
    static void h(w paramw)
    {
      AppMethodBeat.i(28773);
      if (paramw == null) {
        Log.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
      }
      if (!KVq)
      {
        Log.w("MicroMsg.SightCamera", "auto focus not back");
        AppMethodBeat.o(28773);
        return;
      }
      KVq = false;
      try
      {
        paramw.a(nuM);
        AppMethodBeat.o(28773);
        return;
      }
      catch (Exception paramw)
      {
        Log.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[] { paramw.getMessage() });
        KVq = true;
        AppMethodBeat.o(28773);
      }
    }
    
    private static int i(Camera.Parameters paramParameters)
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
          Log.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      AppMethodBeat.o(28774);
      return i;
    }
    
    static int j(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(28775);
      int j = i(paramParameters) / 6;
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
        paramMessage = (w)paramMessage.obj;
        if ((this.nGM == 0) || (this.nGM == 0) || (d.rc(14)))
        {
          h(paramMessage);
          AppMethodBeat.o(28776);
          return;
        }
        float f1 = this.mkm;
        float f2 = this.mkn;
        int i = this.nGM;
        j = this.nGN;
        if (paramMessage == null) {
          Log.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (!KVq)
        {
          Log.w("MicroMsg.SightCamera", "auto focus not back");
          AppMethodBeat.o(28776);
          return;
        }
        KVq = false;
        Object localObject2;
        try
        {
          Log.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          localObject2 = a(f1, f2, 1.0F, i, j);
          localObject1 = a(f1, f2, 1.5F, i, j);
          Log.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
          localParameters = paramMessage.aPy();
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
          paramMessage.c(localParameters);
          paramMessage.a(nuM);
          AppMethodBeat.o(28776);
          return;
        }
        catch (Exception paramMessage)
        {
          Log.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          KVq = true;
          AppMethodBeat.o(28776);
          return;
        }
        if (this.nGA)
        {
          AppMethodBeat.o(28776);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        Log.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.KUV), Integer.valueOf(this.KVx), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.KVx;
        if (this.KUV)
        {
          int k = i(localParameters);
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
          this.nGM = 0;
          this.nGN = 0;
          sendMessageDelayed(obtainMessage(4354, paramMessage.obj), 20L);
          continue;
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.KVy) {}
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
          if (this.KVy) {}
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
            Log.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.e
 * JD-Core Version:    0.7.0.1
 */