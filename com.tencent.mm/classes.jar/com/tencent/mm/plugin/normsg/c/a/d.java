package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class d
{
  public float[] hpa;
  public long timestamp;
  
  public d()
  {
    AppMethodBeat.i(261903);
    this.hpa = new float[3];
    this.timestamp = 0L;
    reset();
    AppMethodBeat.o(261903);
  }
  
  public d(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(261897);
    this.hpa = new float[3];
    this.timestamp = 0L;
    b(paramSensorEvent);
    AppMethodBeat.o(261897);
  }
  
  public final void b(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(261910);
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      reset();
      AppMethodBeat.o(261910);
      return;
    }
    if (paramSensorEvent.values.length > 0) {
      this.hpa[0] = paramSensorEvent.values[0];
    }
    if (paramSensorEvent.values.length > 1) {
      this.hpa[1] = paramSensorEvent.values[1];
    }
    if (paramSensorEvent.values.length > 2) {
      this.hpa[2] = paramSensorEvent.values[2];
    }
    this.timestamp = (paramSensorEvent.timestamp / 1000000L);
    AppMethodBeat.o(261910);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(261916);
    Arrays.fill(this.hpa, (0.0F / 0.0F));
    this.timestamp = 0L;
    AppMethodBeat.o(261916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.d
 * JD-Core Version:    0.7.0.1
 */