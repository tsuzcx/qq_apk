package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import java.util.WeakHashMap;

public final class a
{
  private WeakHashMap<Object, Boolean> RuF;
  
  public a()
  {
    AppMethodBeat.i(72880);
    this.RuF = new WeakHashMap();
    AppMethodBeat.o(72880);
  }
  
  public static a hhH()
  {
    try
    {
      a locala = a.RuG;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean ew(Object paramObject)
  {
    AppMethodBeat.i(72881);
    if (com.tencent.mm.plugin.normsg.a.d.AEF.dH(paramObject))
    {
      if (this.RuF.containsKey(paramObject))
      {
        AppMethodBeat.o(72881);
        return false;
      }
      this.RuF.put(paramObject, Boolean.TRUE);
      e.Cxv.idkeyStat(715L, 0L, 1L, false);
      if (((b.hhK()) || (g.isMIUI())) && (b.hhI())) {
        com.tencent.mm.plugin.secinforeport.a.d.CWG.Xj(-2147483648);
      }
      AppMethodBeat.o(72881);
      return false;
    }
    AppMethodBeat.o(72881);
    return true;
  }
  
  static final class a
  {
    static a RuG;
    
    static
    {
      AppMethodBeat.i(72879);
      RuG = new a();
      AppMethodBeat.o(72879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.a
 * JD-Core Version:    0.7.0.1
 */