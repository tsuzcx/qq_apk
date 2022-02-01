package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int WKG;
  public int WKH;
  public int WKI;
  public final List<dfo> WKJ;
  public int WKK;
  public long WKL;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.WKG = 20480;
    this.WKH = 30720;
    this.WKI = 51200;
    this.WKJ = new LinkedList();
    this.WKK = 0;
    this.WKL = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void mh(List<dco> paramList)
  {
    AppMethodBeat.i(78863);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(78863);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dco localdco = (dco)paramList.next();
      g localg = com.tencent.mm.plugin.webview.modeltools.g.iwb();
      int i = localdco.ZsX;
      long l1 = Util.nowSecond();
      long l2 = localdco.aaIw;
      localg.WKE.set(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    com.tencent.mm.plugin.webview.modeltools.g.iwb().iuZ();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h WKM;
    
    static
    {
      AppMethodBeat.i(78861);
      WKM = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */