package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> AZp;
  
  public d()
  {
    AppMethodBeat.i(66885);
    this.AZp = new ArrayList();
    amZ();
    AppMethodBeat.o(66885);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(66886);
    this.AZp.clear();
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(270340, "");
    Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(str)) {
        this.AZp.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean eDw()
  {
    AppMethodBeat.i(66887);
    Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.AZp.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.AZp.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    Log.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    g.aAi();
    g.aAh().azQ().set(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */