package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c<K, V>
{
  public Map<K, V> map;
  
  public c()
  {
    AppMethodBeat.i(194833);
    this.map = new HashMap();
    AppMethodBeat.o(194833);
  }
  
  public final c<K, V> P(K paramK, V paramV)
  {
    AppMethodBeat.i(194834);
    this.map.put(paramK, paramV);
    AppMethodBeat.o(194834);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.c
 * JD-Core Version:    0.7.0.1
 */