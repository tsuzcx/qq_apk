package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class q
{
  public HashMap<Integer, a> DxL;
  
  public q()
  {
    AppMethodBeat.i(30108);
    this.DxL = new HashMap();
    AppMethodBeat.o(30108);
  }
  
  public final a VW(int paramInt)
  {
    AppMethodBeat.i(30110);
    a locala = (a)this.DxL.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(30110);
    return locala;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(30109);
    Iterator localIterator = parama.eKN().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ad.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", new Object[] { Integer.valueOf(i), parama });
      this.DxL.put(Integer.valueOf(i), parama);
    }
    AppMethodBeat.o(30109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.q
 * JD-Core Version:    0.7.0.1
 */