package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> vwV;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.vwV = new HashSet();
    WN();
    AppMethodBeat.o(66658);
  }
  
  private void WN()
  {
    AppMethodBeat.i(66659);
    this.vwV.clear();
    g.agS();
    Iterator localIterator = bs.S(((String)g.agR().agA().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bs.isNullOrNil(str)) && (!this.vwV.contains(str))) {
        this.vwV.add(str);
      }
    }
    g.agS();
    g.agR().agA().set(204817, Integer.valueOf(this.vwV.size()));
    ac.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.vwV.size());
    AppMethodBeat.o(66659);
  }
  
  public final void dnK()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.vwV.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bs.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.agS();
    g.agR().agA().set(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */