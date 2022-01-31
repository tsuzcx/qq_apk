package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  public int uVo;
  public int uVp;
  public int uVq;
  public final List<ayx> uVr;
  public int uVs;
  public long uVt;
  
  private f()
  {
    AppMethodBeat.i(6580);
    this.uVo = 20480;
    this.uVp = 30720;
    this.uVq = 51200;
    this.uVr = new LinkedList();
    this.uVs = 0;
    this.uVt = 0L;
    AppMethodBeat.o(6580);
  }
  
  public static void ef(List<awo> paramList)
  {
    AppMethodBeat.i(6581);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(6581);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      awo localawo = (awo)paramList.next();
      e locale = g.dcG();
      int i = localawo.xme;
      long l1 = bo.aox();
      long l2 = localawo.xmf;
      locale.uVm.x(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    g.dcG().dbI();
    AppMethodBeat.o(6581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.f
 * JD-Core Version:    0.7.0.1
 */