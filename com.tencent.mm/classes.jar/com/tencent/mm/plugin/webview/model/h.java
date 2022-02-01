package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int DSF;
  public int DSG;
  public int DSH;
  public final List<bsl> DSI;
  public int DSJ;
  public long DSK;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.DSF = 20480;
    this.DSG = 30720;
    this.DSH = 51200;
    this.DSI = new LinkedList();
    this.DSJ = 0;
    this.DSK = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void gT(List<bpv> paramList)
  {
    AppMethodBeat.i(78863);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(78863);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bpv localbpv = (bpv)paramList.next();
      g localg = com.tencent.mm.plugin.webview.modeltools.g.eQW();
      int i = localbpv.GKy;
      long l1 = bt.aQJ();
      long l2 = localbpv.GKz;
      localg.DSD.I(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    com.tencent.mm.plugin.webview.modeltools.g.eQW().ePU();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h DSL;
    
    static
    {
      AppMethodBeat.i(78861);
      DSL = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */