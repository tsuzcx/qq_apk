package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class q
{
  public HashMap<Integer, a> IyG;
  
  public q()
  {
    AppMethodBeat.i(30108);
    this.IyG = new HashMap();
    AppMethodBeat.o(30108);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(30109);
    Iterator localIterator = parama.fWe().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Log.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", new Object[] { Integer.valueOf(i), parama });
      this.IyG.put(Integer.valueOf(i), parama);
    }
    AppMethodBeat.o(30109);
  }
  
  public final a afj(int paramInt)
  {
    AppMethodBeat.i(30110);
    a locala = (a)this.IyG.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(30110);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.q
 * JD-Core Version:    0.7.0.1
 */