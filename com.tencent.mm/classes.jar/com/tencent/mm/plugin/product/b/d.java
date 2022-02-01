package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> wLZ;
  
  public d()
  {
    AppMethodBeat.i(66885);
    this.wLZ = new ArrayList();
    Zd();
    AppMethodBeat.o(66885);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(66886);
    this.wLZ.clear();
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(270340, "");
    ad.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bt.U(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bt.isNullOrNil(str)) {
        this.wLZ.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean dzN()
  {
    AppMethodBeat.i(66887);
    ad.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.wLZ.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.wLZ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    ad.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.ajD();
    g.ajC().ajl().set(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */