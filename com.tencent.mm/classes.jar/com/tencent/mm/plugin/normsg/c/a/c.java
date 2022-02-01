package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.b;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  Sensor Mug;
  d Muh;
  boolean Mui;
  List<b> Muj;
  long Muk;
  
  public c(Sensor paramSensor)
  {
    AppMethodBeat.i(261902);
    this.Muh = new d();
    this.Mui = false;
    this.Muj = new ArrayList();
    this.Muk = 0L;
    this.Mug = paramSensor;
    AppMethodBeat.o(261902);
  }
  
  final void a(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(261907);
    a(new d(paramSensorEvent));
    AppMethodBeat.o(261907);
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(261915);
    b localb = new b();
    localb.fa = paramd.hpa[0];
    localb.fb = paramd.hpa[1];
    localb.fc = paramd.hpa[2];
    localb.fd = paramd.timestamp;
    this.Muj.add(localb);
    this.Muk = paramd.timestamp;
    this.Muh.reset();
    AppMethodBeat.o(261915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.c
 * JD-Core Version:    0.7.0.1
 */