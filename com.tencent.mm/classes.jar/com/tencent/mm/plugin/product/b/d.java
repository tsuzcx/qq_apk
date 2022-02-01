package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> vET;
  
  public d()
  {
    AppMethodBeat.i(66885);
    this.vET = new ArrayList();
    WJ();
    AppMethodBeat.o(66885);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(66886);
    this.vET.clear();
    g.agS();
    Object localObject = (String)g.agR().agA().get(270340, "");
    ac.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bs.S(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bs.isNullOrNil(str)) {
        this.vET.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean dpl()
  {
    AppMethodBeat.i(66887);
    ac.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.vET.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.vET.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bs.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    ac.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.agS();
    g.agR().agA().set(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */