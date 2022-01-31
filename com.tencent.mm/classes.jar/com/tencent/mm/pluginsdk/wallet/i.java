package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class i
{
  public HashMap<String, Object> wgO;
  
  private i()
  {
    AppMethodBeat.i(141118);
    this.wgO = new HashMap();
    AppMethodBeat.o(141118);
  }
  
  public static i dpR()
  {
    try
    {
      AppMethodBeat.i(141119);
      i locali = a.dpS();
      AppMethodBeat.o(141119);
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(141120);
    if (this.wgO.containsKey(paramString))
    {
      paramString = this.wgO.get(paramString);
      AppMethodBeat.o(141120);
      return paramString;
    }
    AppMethodBeat.o(141120);
    return paramObject;
  }
  
  static final class a
  {
    private static final i wgP;
    
    static
    {
      AppMethodBeat.i(141117);
      wgP = new i((byte)0);
      AppMethodBeat.o(141117);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.i
 * JD-Core Version:    0.7.0.1
 */