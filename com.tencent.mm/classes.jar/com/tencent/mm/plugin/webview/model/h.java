package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int Cph;
  public int Cpi;
  public int Cpj;
  public final List<bnz> Cpk;
  public int Cpl;
  public long Cpm;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.Cph = 20480;
    this.Cpi = 30720;
    this.Cpj = 51200;
    this.Cpk = new LinkedList();
    this.Cpl = 0;
    this.Cpm = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void gH(List<bll> paramList)
  {
    AppMethodBeat.i(78863);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(78863);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bll localbll = (bll)paramList.next();
      g localg = com.tencent.mm.plugin.webview.modeltools.g.eCc();
      int i = localbll.FaZ;
      long l1 = bs.aNx();
      long l2 = localbll.Fba;
      localg.Cpf.G(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    com.tencent.mm.plugin.webview.modeltools.g.eCc().eBc();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h Cpn;
    
    static
    {
      AppMethodBeat.i(78861);
      Cpn = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */