package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class g
{
  public HashMap<String, Object> RzF;
  
  private g()
  {
    AppMethodBeat.i(117596);
    this.RzF = new HashMap();
    AppMethodBeat.o(117596);
  }
  
  public static g hoh()
  {
    try
    {
      AppMethodBeat.i(117597);
      g localg = a.hoi();
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
    if (this.RzF.containsKey(paramString))
    {
      paramString = this.RzF.get(paramString);
      AppMethodBeat.o(117598);
      return paramString;
    }
    AppMethodBeat.o(117598);
    return paramObject;
  }
  
  static final class a
  {
    private static final g RzG;
    
    static
    {
      AppMethodBeat.i(117595);
      RzG = new g((byte)0);
      AppMethodBeat.o(117595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.g
 * JD-Core Version:    0.7.0.1
 */