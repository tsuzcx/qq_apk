package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.b;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  d AES;
  boolean AET;
  List<b> AEU;
  long AEV;
  Sensor pKK;
  
  public c(Sensor paramSensor)
  {
    AppMethodBeat.i(187597);
    this.AES = new d();
    this.AET = false;
    this.AEU = new ArrayList();
    this.AEV = 0L;
    this.pKK = paramSensor;
    AppMethodBeat.o(187597);
  }
  
  final void a(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(187598);
    a(new d(paramSensorEvent));
    AppMethodBeat.o(187598);
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(187599);
    b localb = new b();
    localb.fa = paramd.values[0];
    localb.fb = paramd.values[1];
    localb.fc = paramd.values[2];
    localb.fd = paramd.timestamp;
    this.AEU.add(localb);
    this.AEV = paramd.timestamp;
    this.AES.reset();
    AppMethodBeat.o(187599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a.c
 * JD-Core Version:    0.7.0.1
 */