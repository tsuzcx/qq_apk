package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int AWU;
  public int AWV;
  public int AWW;
  public final List<bkf> AWX;
  public int AWY;
  public long AWZ;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.AWU = 20480;
    this.AWV = 30720;
    this.AWW = 51200;
    this.AWX = new LinkedList();
    this.AWY = 0;
    this.AWZ = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void gw(List<bht> paramList)
  {
    AppMethodBeat.i(78863);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(78863);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bht localbht = (bht)paramList.next();
      g localg = com.tencent.mm.plugin.webview.modeltools.g.emH();
      int i = localbht.DFF;
      long l1 = bt.aGK();
      long l2 = localbht.DFG;
      localg.AWS.G(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    com.tencent.mm.plugin.webview.modeltools.g.emH().elG();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h AXa;
    
    static
    {
      AppMethodBeat.i(78861);
      AXa = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */