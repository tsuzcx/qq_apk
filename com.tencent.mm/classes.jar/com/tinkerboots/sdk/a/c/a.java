package com.tinkerboots.sdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public final Map<String, String> BLJ;
  
  public a()
  {
    AppMethodBeat.i(65533);
    this.BLJ = new HashMap();
    AppMethodBeat.o(65533);
  }
  
  public final a jl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65534);
    this.BLJ.put(paramString1, paramString2);
    AppMethodBeat.o(65534);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */