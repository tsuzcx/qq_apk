package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> unZ;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.unZ = new HashSet();
    VP();
    AppMethodBeat.o(66658);
  }
  
  private void VP()
  {
    AppMethodBeat.i(66659);
    this.unZ.clear();
    g.afC();
    Iterator localIterator = bt.S(((String)g.afB().afk().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (!this.unZ.contains(str))) {
        this.unZ.add(str);
      }
    }
    g.afC();
    g.afB().afk().set(204817, Integer.valueOf(this.unZ.size()));
    ad.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.unZ.size());
    AppMethodBeat.o(66659);
  }
  
  public final void dac()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.unZ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bt.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.afC();
    g.afB().afk().set(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */