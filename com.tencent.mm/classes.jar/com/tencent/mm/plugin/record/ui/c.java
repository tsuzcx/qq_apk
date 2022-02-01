package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    gw localgw = new gw();
    localgw.dKR.opType = 3;
    localgw.dKR.context = paramContext;
    EventCenter.instance.publish(localgw);
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    gw localgw = new gw();
    localgw.dKR.opType = 2;
    localgw.dKR.dKY = false;
    if (paramb.dKW)
    {
      localgw.dKR.dKT = paramb.dKT;
      localgw.dKR.dKW = paramb.dKW;
    }
    for (;;)
    {
      EventCenter.instance.publish(localgw);
      Log.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.BHU), paramb.dKT.dLl, localgw.dKS.dKZ, Boolean.valueOf(localgw.dKR.dKW) });
      paramb = localgw.dKS.dKZ;
      AppMethodBeat.o(27834);
      return paramb;
      localgw.dKR.dKT = paramb.dKT;
      localgw.dKR.dFW = paramb.BHU;
      localgw.dKR.maxWidth = paramb.maxWidth;
      localgw.dKR.dKX = paramb.dKX;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    gw localgw = new gw();
    localgw.dKR.opType = 0;
    localgw.dKR.dKT = paramc.dKT;
    localgw.dKR.dFW = paramc.BHU;
    EventCenter.instance.publish(localgw);
    Log.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.BHU), localgw.dKS.dKZ });
    paramc = localgw.dKS.dKZ;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    Log.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.BHU) });
    gw localgw = new gw();
    localgw.dKR.opType = 1;
    localgw.dKR.dKU = parama.dKU;
    localgw.dKR.dKT = parama.dKT;
    localgw.dKR.dFW = parama.BHU;
    localgw.dKR.dKV = parama.dKV;
    localgw.dKR.width = parama.width;
    localgw.dKR.height = parama.height;
    EventCenter.instance.publish(localgw);
    AppMethodBeat.o(27832);
  }
  
  public final void eIr()
  {
    AppMethodBeat.i(27835);
    gw localgw = new gw();
    localgw.dKR.opType = 4;
    EventCenter.instance.publish(localgw);
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */