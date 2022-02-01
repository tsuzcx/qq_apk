package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.b;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  Sensor GxY;
  d GxZ;
  boolean Gya;
  List<b> Gyb;
  long Gyc;
  
  public c(Sensor paramSensor)
  {
    AppMethodBeat.i(257574);
    this.GxZ = new d();
    this.Gya = false;
    this.Gyb = new ArrayList();
    this.Gyc = 0L;
    this.GxY = paramSensor;
    AppMethodBeat.o(257574);
  }
  
  final void a(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(257575);
    a(new d(paramSensorEvent));
    AppMethodBeat.o(257575);
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(257576);
    b localb = new b();
    localb.fa = paramd.fkN[0];
    localb.fb = paramd.fkN[1];
    localb.fc = paramd.fkN[2];
    localb.fd = paramd.timestamp;
    this.Gyb.add(localb);
    this.Gyc = paramd.timestamp;
    this.GxZ.reset();
    AppMethodBeat.o(257576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.c
 * JD-Core Version:    0.7.0.1
 */