package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class d
{
  public long timestamp;
  public float[] values;
  
  public d()
  {
    AppMethodBeat.i(187601);
    this.values = new float[3];
    this.timestamp = 0L;
    reset();
    AppMethodBeat.o(187601);
  }
  
  public d(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(187600);
    this.values = new float[3];
    this.timestamp = 0L;
    b(paramSensorEvent);
    AppMethodBeat.o(187600);
  }
  
  public final void b(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(187602);
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      reset();
      AppMethodBeat.o(187602);
      return;
    }
    if (paramSensorEvent.values.length > 0) {
      this.values[0] = paramSensorEvent.values[0];
    }
    if (paramSensorEvent.values.length > 1) {
      this.values[1] = paramSensorEvent.values[1];
    }
    if (paramSensorEvent.values.length > 2) {
      this.values[2] = paramSensorEvent.values[2];
    }
    this.timestamp = (paramSensorEvent.timestamp / 1000000L);
    AppMethodBeat.o(187602);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187603);
    Arrays.fill(this.values, (0.0F / 0.0F));
    this.timestamp = 0L;
    AppMethodBeat.o(187603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.d
 * JD-Core Version:    0.7.0.1
 */