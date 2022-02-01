package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class g
{
  public HashMap<String, Object> Fmo;
  
  private g()
  {
    AppMethodBeat.i(117596);
    this.Fmo = new HashMap();
    AppMethodBeat.o(117596);
  }
  
  public static g ffE()
  {
    try
    {
      AppMethodBeat.i(117597);
      g localg = a.ffF();
      AppMethodBeat.o(117597);
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(117598);
    if (this.Fmo.containsKey(paramString))
    {
      paramString = this.Fmo.get(paramString);
      AppMethodBeat.o(117598);
      return paramString;
    }
    AppMethodBeat.o(117598);
    return paramObject;
  }
  
  static final class a
  {
    private static final g Fmp;
    
    static
    {
      AppMethodBeat.i(117595);
      Fmp = new g((byte)0);
      AppMethodBeat.o(117595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.g
 * JD-Core Version:    0.7.0.1
 */