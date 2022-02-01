package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> GHj;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.GHj = new HashSet();
    ate();
    AppMethodBeat.o(66658);
  }
  
  private void ate()
  {
    AppMethodBeat.i(66659);
    this.GHj.clear();
    h.aHH();
    Iterator localIterator = Util.stringsToList(((String)h.aHG().aHp().b(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (!this.GHj.contains(str))) {
        this.GHj.add(str);
      }
    }
    h.aHH();
    h.aHG().aHp().i(204817, Integer.valueOf(this.GHj.size()));
    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.GHj.size());
    AppMethodBeat.o(66659);
  }
  
  public final void adf()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.GHj.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    h.aHH();
    h.aHG().aHp().i(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */