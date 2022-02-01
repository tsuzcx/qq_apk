package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public List<String> GTn;
  
  public d()
  {
    AppMethodBeat.i(66885);
    this.GTn = new ArrayList();
    ata();
    AppMethodBeat.o(66885);
  }
  
  private void ata()
  {
    AppMethodBeat.i(66886);
    this.GTn.clear();
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(270340, "");
    Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(str)) {
        this.GTn.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean fpp()
  {
    AppMethodBeat.i(66887);
    Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.GTn.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.GTn.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    Log.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    h.aHH();
    h.aHG().aHp().i(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.d
 * JD-Core Version:    0.7.0.1
 */