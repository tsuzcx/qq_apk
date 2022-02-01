package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e<K, V>
{
  public Map<K, V> map;
  
  public e()
  {
    AppMethodBeat.i(188230);
    this.map = new HashMap();
    AppMethodBeat.o(188230);
  }
  
  public final e<K, V> O(K paramK, V paramV)
  {
    AppMethodBeat.i(188231);
    this.map.put(paramK, paramV);
    AppMethodBeat.o(188231);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.e
 * JD-Core Version:    0.7.0.1
 */