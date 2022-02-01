package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f<K, V>
{
  public Map<K, V> map;
  
  public f()
  {
    AppMethodBeat.i(222225);
    this.map = new HashMap();
    AppMethodBeat.o(222225);
  }
  
  public final f<K, V> L(K paramK, V paramV)
  {
    AppMethodBeat.i(222227);
    this.map.put(paramK, paramV);
    AppMethodBeat.o(222227);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.f
 * JD-Core Version:    0.7.0.1
 */