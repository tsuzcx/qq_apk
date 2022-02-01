package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public List<String> MQR;
  
  public c()
  {
    AppMethodBeat.i(66885);
    this.MQR = new ArrayList();
    aNi();
    AppMethodBeat.o(66885);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(66886);
    this.MQR.clear();
    h.baF();
    Object localObject = (String)h.baE().ban().d(270340, "");
    Log.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(localObject)));
    localObject = Util.stringsToList(((String)localObject).split(";")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(str)) {
        this.MQR.add(str);
      }
    }
    AppMethodBeat.o(66886);
  }
  
  public final boolean gAt()
  {
    AppMethodBeat.i(66887);
    Log.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.MQR.size());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.MQR.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!Util.isNullOrNil(str)) && (!str.contains(";"))) {
        localStringBuffer.append(str);
      }
    }
    Log.d("MicroMsg.MallNewsManager", "save data  : " + localStringBuffer.toString());
    h.baF();
    h.baE().ban().B(270340, localStringBuffer.toString());
    AppMethodBeat.o(66887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.c
 * JD-Core Version:    0.7.0.1
 */