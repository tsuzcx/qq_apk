package com.tencent.ttpic.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoadItemManager$LOAD_TYPE
{
  static
  {
    AppMethodBeat.i(81807);
    LOAD_ALL = new LOAD_TYPE("LOAD_ALL", 0);
    LOAD_PRE = new LOAD_TYPE("LOAD_PRE", 1);
    $VALUES = new LOAD_TYPE[] { LOAD_ALL, LOAD_PRE };
    AppMethodBeat.o(81807);
  }
  
  private LoadItemManager$LOAD_TYPE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE
 * JD-Core Version:    0.7.0.1
 */