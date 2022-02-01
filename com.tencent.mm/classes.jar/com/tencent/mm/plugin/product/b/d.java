package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> xbN;
  
  public d()
  {
    AppMethodBeat.i(66885);
    this.xbN = new ArrayList();
    Zm();
    AppMethodBeat.o(66885);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(66886);
    this.xbN.clear();
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(270340, "");
    ae.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bu.U(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bu.isNullOrNil(str)) {
        this.xbN.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean dDe()
  {
    AppMethodBeat.i(66887);
    ae.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.xbN.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.xbN.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bu.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    ae.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.ajS();
    g.ajR().ajA().set(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */