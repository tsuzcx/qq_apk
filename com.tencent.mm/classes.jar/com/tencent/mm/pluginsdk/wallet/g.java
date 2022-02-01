package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class g
{
  public HashMap<String, Object> DHh;
  
  private g()
  {
    AppMethodBeat.i(117596);
    this.DHh = new HashMap();
    AppMethodBeat.o(117596);
  }
  
  public static g eQA()
  {
    try
    {
      AppMethodBeat.i(117597);
      g localg = a.eQB();
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
    if (this.DHh.containsKey(paramString))
    {
      paramString = this.DHh.get(paramString);
      AppMethodBeat.o(117598);
      return paramString;
    }
    AppMethodBeat.o(117598);
    return paramObject;
  }
  
  static final class a
  {
    private static final g DHi;
    
    static
    {
      AppMethodBeat.i(117595);
      DHi = new g((byte)0);
      AppMethodBeat.o(117595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.g
 * JD-Core Version:    0.7.0.1
 */