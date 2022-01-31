package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class ScanCameraLightDetector
  implements SensorEventListener
{
  public static final ScanCameraLightDetector qCZ;
  public ak handler;
  private float mhF = -1.0F;
  public long qDa = -1L;
  public Sensor qDb;
  public boolean qDc = false;
  public HandlerThread qDd;
  public SensorManager sensorManager;
  
  static
  {
    AppMethodBeat.i(81449);
    qCZ = new ScanCameraLightDetector();
    AppMethodBeat.o(81449);
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(81447);
    ab.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
    AppMethodBeat.o(81447);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent != null) && (paramSensorEvent.length > 0)) {
      this.mhF = paramSensorEvent[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */