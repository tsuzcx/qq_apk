package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f<K, V>
{
  public Map<K, V> map;
  
  public f()
  {
    AppMethodBeat.i(227104);
    this.map = new HashMap();
    AppMethodBeat.o(227104);
  }
  
  public final f<K, V> X(K paramK, V paramV)
  {
    AppMethodBeat.i(227114);
    this.map.put(paramK, paramV);
    AppMethodBeat.o(227114);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.f
 * JD-Core Version:    0.7.0.1
 */