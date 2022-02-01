package com.tencent.mm.plugin.sport.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/model/SportSensorListener;", "Landroid/hardware/SensorEventListener;", "originListener", "(Landroid/hardware/SensorEventListener;)V", "listenerRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements SensorEventListener
{
  private final WeakReference<SensorEventListener> HpN;
  
  public o(SensorEventListener paramSensorEventListener)
  {
    AppMethodBeat.i(263901);
    this.HpN = new WeakReference(paramSensorEventListener);
    AppMethodBeat.o(263901);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(263906);
    SensorEventListener localSensorEventListener = (SensorEventListener)this.HpN.get();
    if (localSensorEventListener != null) {
      localSensorEventListener.onAccuracyChanged(paramSensor, paramInt);
    }
    AppMethodBeat.o(263906);
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(263904);
    SensorEventListener localSensorEventListener = (SensorEventListener)this.HpN.get();
    if (localSensorEventListener != null) {
      localSensorEventListener.onSensorChanged(paramSensorEvent);
    }
    AppMethodBeat.o(263904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.o
 * JD-Core Version:    0.7.0.1
 */