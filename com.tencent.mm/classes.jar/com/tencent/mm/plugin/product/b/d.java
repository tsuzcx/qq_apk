package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> uwa;
  
  public d()
  {
    AppMethodBeat.i(66885);
    this.uwa = new ArrayList();
    VL();
    AppMethodBeat.o(66885);
  }
  
  private void VL()
  {
    AppMethodBeat.i(66886);
    this.uwa.clear();
    g.afC();
    Object localObject = (String)g.afB().afk().get(270340, "");
    ad.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = bt.S(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bt.isNullOrNil(str)) {
        this.uwa.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean dbD()
  {
    AppMethodBeat.i(66887);
    ad.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.uwa.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.uwa.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!bt.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    ad.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.afC();
    g.afB().afk().set(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */