package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> MEa;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.MEa = new HashSet();
    aNm();
    AppMethodBeat.o(66658);
  }
  
  private void aNm()
  {
    AppMethodBeat.i(66659);
    this.MEa.clear();
    h.baF();
    Iterator localIterator = Util.stringsToList(((String)h.baE().ban().d(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (!this.MEa.contains(str))) {
        this.MEa.add(str);
      }
    }
    h.baF();
    h.baE().ban().B(204817, Integer.valueOf(this.MEa.size()));
    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.MEa.size());
    AppMethodBeat.o(66659);
  }
  
  public final void aFe()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.MEa.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    h.baF();
    h.baE().ban().B(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */