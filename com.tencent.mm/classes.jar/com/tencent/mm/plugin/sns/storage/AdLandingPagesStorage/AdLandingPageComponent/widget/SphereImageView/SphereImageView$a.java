package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class SphereImageView$a
  implements SensorEventListener
{
  public boolean rBt;
  WeakReference<SphereImageView> rBu;
  public long timestamp;
  
  public SphereImageView$a(SphereImageView paramSphereImageView)
  {
    AppMethodBeat.i(145409);
    this.timestamp = 0L;
    this.rBt = true;
    this.rBu = new WeakReference(paramSphereImageView);
    AppMethodBeat.o(145409);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(145410);
    SphereImageView localSphereImageView = (SphereImageView)this.rBu.get();
    if (localSphereImageView == null)
    {
      AppMethodBeat.o(145410);
      return;
    }
    if ((Build.VERSION.SDK_INT < 24) && (!this.rBt))
    {
      AppMethodBeat.o(145410);
      return;
    }
    if (paramSensorEvent.sensor.getType() == 4)
    {
      if (this.timestamp != 0L)
      {
        long l = System.currentTimeMillis();
        float f1 = (float)(l - this.timestamp) / 1000.0F;
        if (f1 < 0.012D)
        {
          AppMethodBeat.o(145410);
          return;
        }
        this.timestamp = l;
        Object localObject = SphereImageView.a(localSphereImageView);
        localObject[0] += paramSensorEvent.values[0] * f1;
        localObject = SphereImageView.a(localSphereImageView);
        localObject[1] += paramSensorEvent.values[1] * f1;
        localObject = SphereImageView.a(localSphereImageView);
        float f2 = localObject[2];
        localObject[2] = (f1 * paramSensorEvent.values[2] + f2);
        f1 = (float)Math.toDegrees(SphereImageView.a(localSphereImageView)[0]);
        f2 = (float)Math.toDegrees(SphereImageView.a(localSphereImageView)[1]);
        float f3 = (float)Math.toDegrees(SphereImageView.a(localSphereImageView)[2]);
        paramSensorEvent = new SphereImageView.c();
        paramSensorEvent.rBv = f2;
        paramSensorEvent.rBw = f1;
        paramSensorEvent.rBx = f3;
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramSensorEvent;
        localSphereImageView.mHandler.sendMessage((Message)localObject);
        AppMethodBeat.o(145410);
        return;
      }
      this.timestamp = System.currentTimeMillis();
    }
    AppMethodBeat.o(145410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.a
 * JD-Core Version:    0.7.0.1
 */