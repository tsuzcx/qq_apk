package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class d
{
  public float[] fkN;
  public long timestamp;
  
  public d()
  {
    AppMethodBeat.i(257857);
    this.fkN = new float[3];
    this.timestamp = 0L;
    reset();
    AppMethodBeat.o(257857);
  }
  
  public d(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(257855);
    this.fkN = new float[3];
    this.timestamp = 0L;
    b(paramSensorEvent);
    AppMethodBeat.o(257855);
  }
  
  public final void b(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(257859);
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null))
    {
      reset();
      AppMethodBeat.o(257859);
      return;
    }
    if (paramSensorEvent.values.length > 0) {
      this.fkN[0] = paramSensorEvent.values[0];
    }
    if (paramSensorEvent.values.length > 1) {
      this.fkN[1] = paramSensorEvent.values[1];
    }
    if (paramSensorEvent.values.length > 2) {
      this.fkN[2] = paramSensorEvent.values[2];
    }
    this.timestamp = (paramSensorEvent.timestamp / 1000000L);
    AppMethodBeat.o(257859);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(257861);
    Arrays.fill(this.fkN, (0.0F / 0.0F));
    this.timestamp = 0L;
    AppMethodBeat.o(257861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.d
 * JD-Core Version:    0.7.0.1
 */