package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int EkF;
  public int EkG;
  public int EkH;
  public final List<btf> EkI;
  public int EkJ;
  public long EkK;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.EkF = 20480;
    this.EkG = 30720;
    this.EkH = 51200;
    this.EkI = new LinkedList();
    this.EkJ = 0;
    this.EkK = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void hd(List<bqp> paramList)
  {
    AppMethodBeat.i(78863);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(78863);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bqp localbqp = (bqp)paramList.next();
      g localg = com.tencent.mm.plugin.webview.modeltools.g.eUI();
      int i = localbqp.HdZ;
      long l1 = bu.aRi();
      long l2 = localbqp.Hea;
      localg.EkD.I(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    com.tencent.mm.plugin.webview.modeltools.g.eUI().eTG();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h EkL;
    
    static
    {
      AppMethodBeat.i(78861);
      EkL = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */