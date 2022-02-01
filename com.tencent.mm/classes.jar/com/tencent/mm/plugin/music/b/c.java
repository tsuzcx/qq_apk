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
    AppMethodBeat.i(257483);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramb.lzU != null) {
      localConcurrentHashMap.put(paramb.fnV, paramb.lzU);
    }
    paramb = new d(new com.tencent.mm.plugin.music.g.a.a(localConcurrentHashMap), paramb);
    AppMethodBeat.o(257483);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.c
 * JD-Core Version:    0.7.0.1
 */