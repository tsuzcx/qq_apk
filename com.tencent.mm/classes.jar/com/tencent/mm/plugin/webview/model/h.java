package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int IXD;
  public int IXE;
  public int IXF;
  public final List<cfy> IXG;
  public int IXH;
  public long IXI;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.IXD = 20480;
    this.IXE = 30720;
    this.IXF = 51200;
    this.IXG = new LinkedList();
    this.IXH = 0;
    this.IXI = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void ii(List<cdi> paramList)
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
      cdi localcdi = (cdi)paramList.next();
      g localg = com.tencent.mm.plugin.webview.modeltools.g.gdx();
      int i = localcdi.Mjf;
      long l1 = Util.nowSecond();
      long l2 = localcdi.Mjg;
      localg.IXB.set(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    com.tencent.mm.plugin.webview.modeltools.g.gdx().gct();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h IXJ;
    
    static
    {
      AppMethodBeat.i(78861);
      IXJ = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */