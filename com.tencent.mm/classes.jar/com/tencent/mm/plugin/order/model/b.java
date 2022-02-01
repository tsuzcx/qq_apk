package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> wCp;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.wCp = new HashSet();
    Zh();
    AppMethodBeat.o(66658);
  }
  
  private void Zh()
  {
    AppMethodBeat.i(66659);
    this.wCp.clear();
    g.ajD();
    Iterator localIterator = bt.U(((String)g.ajC().ajl().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (!this.wCp.contains(str))) {
        this.wCp.add(str);
      }
    }
    g.ajD();
    g.ajC().ajl().set(204817, Integer.valueOf(this.wCp.size()));
    ad.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.wCp.size());
    AppMethodBeat.o(66659);
  }
  
  public final void dyc()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.wCp.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bt.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.ajD();
    g.ajC().ajl().set(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */