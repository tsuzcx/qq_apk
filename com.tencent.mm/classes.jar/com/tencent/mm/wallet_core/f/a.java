package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.f;
import java.util.WeakHashMap;

public final class a
{
  private WeakHashMap<Object, Boolean> YWd;
  
  public a()
  {
    AppMethodBeat.i(72880);
    this.YWd = new WeakHashMap();
    AppMethodBeat.o(72880);
  }
  
  public static a iji()
  {
    try
    {
      a locala = a.YWe;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean eC(Object paramObject)
  {
    AppMethodBeat.i(72881);
    if (com.tencent.mm.plugin.normsg.a.d.GxJ.dK(paramObject))
    {
      if (this.YWd.containsKey(paramObject))
      {
        AppMethodBeat.o(72881);
        return false;
      }
      this.YWd.put(paramObject, Boolean.TRUE);
      f.Iyx.idkeyStat(715L, 0L, 1L, false);
      if (((b.ijl()) || (g.isMIUI())) && (b.ijj())) {
        com.tencent.mm.plugin.secinforeport.a.d.Jcm.aeh(-2147483648);
      }
      AppMethodBeat.o(72881);
      return false;
    }
    AppMethodBeat.o(72881);
    return true;
  }
  
  static final class a
  {
    static a YWe;
    
    static
    {
      AppMethodBeat.i(72879);
      YWe = new a();
      AppMethodBeat.o(72879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.a
 * JD-Core Version:    0.7.0.1
 */