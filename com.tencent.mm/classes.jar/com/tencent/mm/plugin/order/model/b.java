package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> wSa;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.wSa = new HashSet();
    Zq();
    AppMethodBeat.o(66658);
  }
  
  private void Zq()
  {
    AppMethodBeat.i(66659);
    this.wSa.clear();
    g.ajS();
    Iterator localIterator = bu.U(((String)g.ajR().ajA().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bu.isNullOrNil(str)) && (!this.wSa.contains(str))) {
        this.wSa.add(str);
      }
    }
    g.ajS();
    g.ajR().ajA().set(204817, Integer.valueOf(this.wSa.size()));
    ae.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.wSa.size());
    AppMethodBeat.o(66659);
  }
  
  public final void dBs()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.wSa.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bu.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.ajS();
    g.ajR().ajA().set(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */