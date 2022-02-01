package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.secinforeport.a.d;
import java.util.WeakHashMap;

public final class a
{
  private WeakHashMap<Object, Boolean> JFW;
  
  public a()
  {
    AppMethodBeat.i(72880);
    this.JFW = new WeakHashMap();
    AppMethodBeat.o(72880);
  }
  
  public static a fAD()
  {
    try
    {
      a locala = a.JFX;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean em(Object paramObject)
  {
    AppMethodBeat.i(72881);
    if (com.tencent.mm.plugin.normsg.a.b.vor.du(paramObject))
    {
      if (this.JFW.containsKey(paramObject))
      {
        AppMethodBeat.o(72881);
        return false;
      }
      this.JFW.put(paramObject, Boolean.TRUE);
      e.wTc.idkeyStat(715L, 0L, 1L, false);
      if (((b.fAG()) || (g.YI())) && (b.fAE())) {
        d.xnP.Nw(-2147483648);
      }
      AppMethodBeat.o(72881);
      return false;
    }
    AppMethodBeat.o(72881);
    return true;
  }
  
  static final class a
  {
    static a JFX;
    
    static
    {
      AppMethodBeat.i(72879);
      JFX = new a();
      AppMethodBeat.o(72879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.a
 * JD-Core Version:    0.7.0.1
 */