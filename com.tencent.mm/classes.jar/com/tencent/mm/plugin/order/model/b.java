package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> ANV;
  
  public b()
  {
    AppMethodBeat.i(66658);
    this.ANV = new HashSet();
    and();
    AppMethodBeat.o(66658);
  }
  
  private void and()
  {
    AppMethodBeat.i(66659);
    this.ANV.clear();
    g.aAi();
    Iterator localIterator = Util.stringsToList(((String)g.aAh().azQ().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (!this.ANV.contains(str))) {
        this.ANV.add(str);
      }
    }
    g.aAi();
    g.aAh().azQ().set(204817, Integer.valueOf(this.ANV.size()));
    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.ANV.size());
    AppMethodBeat.o(66659);
  }
  
  public final void Yy()
  {
    AppMethodBeat.i(66660);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.ANV.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.aAi();
    g.aAh().azQ().set(204803, localStringBuffer.toString());
    AppMethodBeat.o(66660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */