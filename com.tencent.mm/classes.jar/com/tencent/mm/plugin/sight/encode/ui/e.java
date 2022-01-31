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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class e
  implements SensorEventListener
{
  private static int mgA = 2147483647;
  Camera dwJ = null;
  private Context mContext = null;
  Camera.PreviewCallback mPreviewCallback = null;
  private float mgC = 0.0F;
  private float mgD = 0.0F;
  private float mgE = 0.0F;
  boolean mgx = false;
  boolean mgy = false;
  private int mgz = 0;
  private boolean mha = false;
  com.tencent.mm.pluginsdk.i.a oiw = com.tencent.mm.pluginsdk.i.a.clS();
  a oix = new a(Looper.getMainLooper());
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.mgC - f1) > 3.0F) || (Math.abs(this.mgD - f2) > 3.0F) || (Math.abs(this.mgE - f3) > 3.0F))
    {
      y.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[] { Float.valueOf(3.0F) });
      a.g(this.dwJ);
      this.mgC = f1;
      this.mgD = f2;
      this.mgE = f3;
    }
  }
  
  private static final class a
    extends ah
  {
    static boolean mhb = true;
    static Camera.AutoFocusCallback mhc = new e.a.1();
    float lvi;
    boolean mgx = false;
    int mhk = 0;
    boolean mhl = false;
    boolean mhm = false;
    float mhn;
    int mho;
    int mhp;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      int i = Float.valueOf(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 72) * paramFloat3).intValue();
      RectF localRectF = new RectF();
      localRectF.set((paramFloat1 - i / 2) * 2000.0F / paramInt1 - 1000.0F, (paramFloat2 - i / 2) * 2000.0F / paramInt2 - 1000.0F, (i / 2 + paramFloat1) * 2000.0F / paramInt1 - 1000.0F, (i / 2 + paramFloat2) * 2000.0F / paramInt2 - 1000.0F);
      return new Rect(tZ(Math.round(localRectF.left)), tZ(Math.round(localRectF.top)), tZ(Math.round(localRectF.right)), tZ(Math.round(localRectF.bottom)));
    }
    
    private static int c(Camera.Parameters paramParameters)
    {
      if (paramParameters == null) {
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
          y.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      return i;
    }
    
    static int e(Camera.Parameters paramParameters)
    {
      int j = c(paramParameters) / 6;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      return i;
    }
    
    static void g(Camera paramCamera)
    {
      if (paramCamera == null) {
        y.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
      }
      if (!mhb)
      {
        y.w("MicroMsg.SightCamera", "auto focus not back");
        return;
      }
      mhb = false;
      try
      {
        paramCamera.autoFocus(mhc);
        return;
      }
      catch (Exception paramCamera)
      {
        y.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[] { paramCamera.getMessage() });
        mhb = true;
      }
    }
    
    private static int tZ(int paramInt)
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
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        paramMessage = (Camera)paramMessage.obj;
        if ((this.mho == 0) || (this.mho == 0) || (d.gG(14)))
        {
          g(paramMessage);
          return;
        }
        float f1 = this.mhn;
        float f2 = this.lvi;
        int i = this.mho;
        j = this.mhp;
        if (paramMessage == null) {
          y.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (!mhb)
        {
          y.w("MicroMsg.SightCamera", "auto focus not back");
          return;
        }
        mhb = false;
        Object localObject2;
        try
        {
          y.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          localObject2 = a(f1, f2, 1.0F, i, j);
          localObject1 = a(f1, f2, 1.5F, i, j);
          y.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
          paramMessage.autoFocus(mhc);
          return;
        }
        catch (Exception paramMessage)
        {
          y.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          mhb = true;
          return;
        }
        if (this.mhm) {
          continue;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        y.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.mgx), Integer.valueOf(this.mhk), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.mhk;
        if (this.mgx)
        {
          int k = c(localParameters);
          if (i >= k)
          {
            i = k;
            label465:
            localParameters.setZoom(i);
          }
        }
        try
        {
          ((Camera)localObject1).setParameters(localParameters);
          if (j == 0) {
            continue;
          }
          this.mho = 0;
          this.mhp = 0;
          sendMessageDelayed(obtainMessage(4354, paramMessage.obj), 20L);
          return;
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.mhl) {}
          for (long l = 10L;; l = 20L)
          {
            sendMessageDelayed((Message)localObject2, l);
            j = 0;
            break;
          }
          if (i <= 0)
          {
            i = 0;
            break label465;
          }
          localObject2 = obtainMessage(4353, paramMessage.obj);
          if (this.mhl) {}
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
            y.printErrStackTrace("MicroMsg.SightCamera", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.e
 * JD-Core Version:    0.7.0.1
 */