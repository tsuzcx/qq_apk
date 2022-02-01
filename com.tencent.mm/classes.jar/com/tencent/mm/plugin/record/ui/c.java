package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hd;
import com.tencent.mm.f.a.hd.a;
import com.tencent.mm.f.a.hd.b;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    AppMethodBeat.i(27831);
    hd localhd = new hd();
    localhd.fDG.opType = 3;
    localhd.fDG.context = paramContext;
    EventCenter.instance.publish(localhd);
    AppMethodBeat.o(27831);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    AppMethodBeat.i(27834);
    hd localhd = new hd();
    localhd.fDG.opType = 2;
    localhd.fDG.fDN = false;
    if (paramb.fDL)
    {
      localhd.fDG.fDI = paramb.fDI;
      localhd.fDG.fDL = paramb.fDL;
    }
    for (;;)
    {
      EventCenter.instance.publish(localhd);
      Log.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.HEb), paramb.fDI.fEa, localhd.fDH.fDO, Boolean.valueOf(localhd.fDG.fDL) });
      paramb = localhd.fDH.fDO;
      AppMethodBeat.o(27834);
      return paramb;
      localhd.fDG.fDI = paramb.fDI;
      localhd.fDG.fyE = paramb.HEb;
      localhd.fDG.maxWidth = paramb.maxWidth;
      localhd.fDG.fDM = paramb.fDM;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    AppMethodBeat.i(27833);
    hd localhd = new hd();
    localhd.fDG.opType = 0;
    localhd.fDG.fDI = paramc.fDI;
    localhd.fDG.fyE = paramc.HEb;
    EventCenter.instance.publish(localhd);
    Log.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.HEb), localhd.fDH.fDO });
    paramc = localhd.fDH.fDO;
    AppMethodBeat.o(27833);
    return paramc;
  }
  
  public final void a(h.a.a parama)
  {
    AppMethodBeat.i(27832);
    Log.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.HEb) });
    hd localhd = new hd();
    localhd.fDG.opType = 1;
    localhd.fDG.fDJ = parama.fDJ;
    localhd.fDG.fDI = parama.fDI;
    localhd.fDG.fyE = parama.HEb;
    localhd.fDG.fDK = parama.fDK;
    localhd.fDG.width = parama.width;
    localhd.fDG.height = parama.height;
    EventCenter.instance.publish(localhd);
    AppMethodBeat.o(27832);
  }
  
  public final void fuw()
  {
    AppMethodBeat.i(27835);
    hd localhd = new hd();
    localhd.fDG.opType = 4;
    EventCenter.instance.publish(localhd);
    AppMethodBeat.o(27835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */