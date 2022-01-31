package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.h.a.gc;
import com.tencent.mm.h.a.gc.a;
import com.tencent.mm.h.a.gc.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements h.a
{
  public c(Context paramContext)
  {
    gc localgc = new gc();
    localgc.bNr.opType = 3;
    localgc.bNr.context = paramContext;
    a.udP.m(localgc);
  }
  
  public final Bitmap a(h.a.b paramb)
  {
    gc localgc = new gc();
    localgc.bNr.opType = 2;
    localgc.bNr.bNy = false;
    if (paramb.bNw)
    {
      localgc.bNr.bNt = paramb.bNt;
      localgc.bNr.bNw = paramb.bNw;
    }
    for (;;)
    {
      a.udP.m(localgc);
      y.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[] { Long.valueOf(paramb.ntR), paramb.bNt.kgC, localgc.bNs.bNz, Boolean.valueOf(localgc.bNr.bNw) });
      return localgc.bNs.bNz;
      localgc.bNr.bNt = paramb.bNt;
      localgc.bNr.bIr = paramb.ntR;
      localgc.bNr.maxWidth = paramb.maxWidth;
      localgc.bNr.bNx = paramb.bNx;
    }
  }
  
  public final Bitmap a(h.a.c paramc)
  {
    gc localgc = new gc();
    localgc.bNr.opType = 0;
    localgc.bNr.bNt = paramc.bNt;
    localgc.bNr.bIr = paramc.ntR;
    a.udP.m(localgc);
    y.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[] { Long.valueOf(paramc.ntR), localgc.bNs.bNz });
    return localgc.bNs.bNz;
  }
  
  public final void a(h.a.a parama)
  {
    y.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[] { Long.valueOf(parama.ntR) });
    gc localgc = new gc();
    localgc.bNr.opType = 1;
    localgc.bNr.bNu = parama.bNu;
    localgc.bNr.bNt = parama.bNt;
    localgc.bNr.bIr = parama.ntR;
    localgc.bNr.bNv = parama.bNv;
    localgc.bNr.width = parama.width;
    localgc.bNr.height = parama.height;
    a.udP.m(localgc);
  }
  
  public final void bvC()
  {
    gc localgc = new gc();
    localgc.bNr.opType = 4;
    a.udP.m(localgc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.c
 * JD-Core Version:    0.7.0.1
 */