package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.secinforeport.a.d;
import java.util.WeakHashMap;

public final class a
{
  private WeakHashMap<Object, Boolean> Lza;
  
  public a()
  {
    AppMethodBeat.i(72880);
    this.Lza = new WeakHashMap();
    AppMethodBeat.o(72880);
  }
  
  public static a fRN()
  {
    try
    {
      a locala = a.Lzb;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean ep(Object paramObject)
  {
    AppMethodBeat.i(72881);
    if (com.tencent.mm.plugin.normsg.a.b.wtJ.dx(paramObject))
    {
      if (this.Lza.containsKey(paramObject))
      {
        AppMethodBeat.o(72881);
        return false;
      }
      this.Lza.put(paramObject, Boolean.TRUE);
      e.ygI.idkeyStat(715L, 0L, 1L, false);
      if (((b.fRQ()) || (g.abk())) && (b.fRO())) {
        d.yBQ.OY(-2147483648);
      }
      AppMethodBeat.o(72881);
      return false;
    }
    AppMethodBeat.o(72881);
    return true;
  }
  
  static final class a
  {
    static a Lzb;
    
    static
    {
      AppMethodBeat.i(72879);
      Lzb = new a();
      AppMethodBeat.o(72879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.a
 * JD-Core Version:    0.7.0.1
 */