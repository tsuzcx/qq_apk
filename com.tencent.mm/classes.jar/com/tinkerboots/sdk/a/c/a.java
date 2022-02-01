package com.tinkerboots.sdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public final Map<String, String> MXz;
  
  public a()
  {
    AppMethodBeat.i(3440);
    this.MXz = new HashMap();
    AppMethodBeat.o(3440);
  }
  
  public final a nv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3441);
    this.MXz.put(paramString1, paramString2);
    AppMethodBeat.o(3441);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a.c.a
 * JD-Core Version:    0.7.0.1
 */