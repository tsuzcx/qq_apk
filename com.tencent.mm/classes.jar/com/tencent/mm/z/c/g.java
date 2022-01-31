package com.tencent.mm.z.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.e;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private final Map<String, e> eGC;
  
  public g()
  {
    AppMethodBeat.i(115319);
    this.eGC = new HashMap();
    AppMethodBeat.o(115319);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(115320);
    this.eGC.put(parame.getName(), parame);
    AppMethodBeat.o(115320);
  }
  
  public final e mi(String paramString)
  {
    AppMethodBeat.i(115321);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(115321);
      return null;
    }
    paramString = (e)this.eGC.get(paramString);
    AppMethodBeat.o(115321);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.z.c.g
 * JD-Core Version:    0.7.0.1
 */