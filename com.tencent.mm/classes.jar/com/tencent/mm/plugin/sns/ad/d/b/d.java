package com.tencent.mm.plugin.sns.ad.d.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class d
{
  public a PPz;
  
  public d()
  {
    AppMethodBeat.i(310079);
    Context localContext = MMApplicationContext.getContext();
    Object localObject = (SensorManager)localContext.getSystemService("sensor");
    Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(4);
    if (localSensor != null)
    {
      this.PPz = new c(localContext, localSensor);
      h.OAn.kJ(1572, 10);
      AppMethodBeat.o(310079);
      return;
    }
    localObject = ((SensorManager)localObject).getDefaultSensor(9);
    if (localObject != null)
    {
      this.PPz = new b(localContext, (Sensor)localObject);
      h.OAn.kJ(1572, 11);
      AppMethodBeat.o(310079);
      return;
    }
    h.OAn.kJ(1572, 12);
    AppMethodBeat.o(310079);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(310083);
    if (this.PPz != null) {
      this.PPz.reset();
    }
    AppMethodBeat.o(310083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b.d
 * JD-Core Version:    0.7.0.1
 */