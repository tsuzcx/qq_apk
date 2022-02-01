package com.tencent.mm.wallet_core.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.f;
import java.util.WeakHashMap;

public final class a
{
  private WeakHashMap<Object, Boolean> agTX;
  
  public a()
  {
    AppMethodBeat.i(72880);
    this.agTX = new WeakHashMap();
    AppMethodBeat.o(72880);
  }
  
  public static a jPd()
  {
    try
    {
      a locala = a.agTY;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean gY(Object paramObject)
  {
    AppMethodBeat.i(72881);
    if (com.tencent.mm.plugin.normsg.a.d.MtP.ge(paramObject))
    {
      if (this.agTX.containsKey(paramObject))
      {
        AppMethodBeat.o(72881);
        return false;
      }
      this.agTX.put(paramObject, Boolean.TRUE);
      f.Ozc.idkeyStat(715L, 0L, 1L, false);
      if (((b.jPg()) || (g.isMIUI())) && (b.jPe())) {
        com.tencent.mm.plugin.secinforeport.a.d.Pmb.aiM(-2147483648);
      }
      AppMethodBeat.o(72881);
      return false;
    }
    AppMethodBeat.o(72881);
    return true;
  }
  
  static final class a
  {
    static a agTY;
    
    static
    {
      AppMethodBeat.i(72879);
      agTY = new a();
      AppMethodBeat.o(72879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a
 * JD-Core Version:    0.7.0.1
 */