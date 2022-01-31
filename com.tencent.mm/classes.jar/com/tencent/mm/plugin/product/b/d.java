package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> puo;
  
  public d()
  {
    AppMethodBeat.i(43979);
    this.puo = new ArrayList();
    Kc();
    AppMethodBeat.o(43979);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(43980);
    this.puo.clear();
    g.RM();
    Object localObject = (String)g.RL().Ru().get(270340, "");
    ab.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bo.P(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bo.isNullOrNil(str)) {
        this.puo.add(str);
      }
    }
    AppMethodBeat.o(43980);
  }
  
  public final boolean cbo()
  {
    AppMethodBeat.i(43981);
    ab.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.puo.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.puo.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bo.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    ab.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.RM();
    g.RL().Ru().set(270340, localStringBuffer.toString());
    AppMethodBeat.o(43981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */