package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public HashSet<String> poZ;
  
  public b()
  {
    AppMethodBeat.i(43750);
    this.poZ = new HashSet();
    Kg();
    AppMethodBeat.o(43750);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(43751);
    this.poZ.clear();
    g.RM();
    Iterator localIterator = bo.P(((String)g.RL().Ru().get(204803, "")).split(";")).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bo.isNullOrNil(str)) && (!this.poZ.contains(str))) {
        this.poZ.add(str);
      }
    }
    g.RM();
    g.RL().Ru().set(204817, Integer.valueOf(this.poZ.size()));
    ab.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.poZ.size());
    AppMethodBeat.o(43751);
  }
  
  public final void cao()
  {
    AppMethodBeat.i(43752);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.poZ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bo.isNullOrNil(str)) {
        localStringBuffer.append(str + ";");
      }
    }
    g.RM();
    g.RL().Ru().set(204803, localStringBuffer.toString());
    AppMethodBeat.o(43752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.b
 * JD-Core Version:    0.7.0.1
 */