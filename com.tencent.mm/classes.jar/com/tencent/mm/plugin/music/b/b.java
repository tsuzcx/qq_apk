package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends com.tencent.mm.audio.mix.e.a
{
  public final com.tencent.mm.audio.mix.h.c b(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198134);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramb.iJQ != null) {
      localConcurrentHashMap.put(paramb.dvn, paramb.iJQ);
    }
    paramb = new c(new com.tencent.mm.plugin.music.g.a.a(localConcurrentHashMap), paramb);
    AppMethodBeat.o(198134);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.b
 * JD-Core Version:    0.7.0.1
 */