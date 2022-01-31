package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class o$a
{
  private static a srb;
  private Map<Long, o> srd;
  
  public o$a()
  {
    AppMethodBeat.i(56493);
    this.srd = new HashMap();
    AppMethodBeat.o(56493);
  }
  
  public static a czC()
  {
    AppMethodBeat.i(56494);
    if (srb == null) {
      srb = new a();
    }
    a locala = srb;
    AppMethodBeat.o(56494);
    return locala;
  }
  
  public final void a(long paramLong, o paramo)
  {
    AppMethodBeat.i(56495);
    this.srd.put(Long.valueOf(paramLong), paramo);
    AppMethodBeat.o(56495);
  }
  
  public final o ms(long paramLong)
  {
    AppMethodBeat.i(56496);
    o localo = (o)this.srd.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(56496);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.o.a
 * JD-Core Version:    0.7.0.1
 */