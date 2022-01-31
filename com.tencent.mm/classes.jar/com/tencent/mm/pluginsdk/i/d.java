package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public final class d
{
  private SensorManager vPg;
  private d.a vPh;
  
  public d()
  {
    AppMethodBeat.i(151624);
    this.vPg = ((SensorManager)ah.getContext().getSystemService("sensor"));
    AppMethodBeat.o(151624);
  }
  
  private boolean dmM()
  {
    AppMethodBeat.i(79655);
    if (this.vPg == null)
    {
      ab.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
      AppMethodBeat.o(79655);
      return false;
    }
    List localList = this.vPg.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      AppMethodBeat.o(79655);
      return true;
    }
    AppMethodBeat.o(79655);
    return false;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(79652);
    bjf();
    if (dmM())
    {
      this.vPh = parama;
      this.vPg.registerListener(this.vPh, this.vPg.getDefaultSensor(1), 1);
      AppMethodBeat.o(79652);
      return;
    }
    ab.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    AppMethodBeat.o(79652);
  }
  
  public final void bjf()
  {
    AppMethodBeat.i(79653);
    if (this.vPh != null)
    {
      this.vPh.onRelease();
      this.vPg.unregisterListener(this.vPh, this.vPg.getDefaultSensor(1));
      this.vPh = null;
    }
    AppMethodBeat.o(79653);
  }
  
  public final boolean dmJ()
  {
    return this.vPh != null;
  }
  
  public final void dmK()
  {
    AppMethodBeat.i(79651);
    if (this.vPh != null) {
      this.vPh.reset();
    }
    AppMethodBeat.o(79651);
  }
  
  public final boolean dmL()
  {
    AppMethodBeat.i(79654);
    if (dmM())
    {
      AppMethodBeat.o(79654);
      return true;
    }
    AppMethodBeat.o(79654);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.d
 * JD-Core Version:    0.7.0.1
 */