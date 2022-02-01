package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  extends com.tencent.mm.audio.mix.d.a
{
  public final com.tencent.mm.audio.mix.g.c b(b paramb)
  {
    AppMethodBeat.i(270861);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramb.orv != null) {
      localConcurrentHashMap.put(paramb.hsg, paramb.orv);
    }
    paramb = new d(new com.tencent.mm.plugin.music.g.a.a(localConcurrentHashMap), paramb);
    AppMethodBeat.o(270861);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.c
 * JD-Core Version:    0.7.0.1
 */