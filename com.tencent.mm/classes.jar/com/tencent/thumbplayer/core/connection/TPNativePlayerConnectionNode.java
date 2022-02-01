package com.tencent.thumbplayer.core.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPNativePlayerConnectionNode
{
  private HashMap<Integer, HashMap<Integer, Long>> mLongMap;
  
  public TPNativePlayerConnectionNode()
  {
    AppMethodBeat.i(189878);
    this.mLongMap = null;
    this.mLongMap = new HashMap();
    AppMethodBeat.o(189878);
  }
  
  public boolean addAction(int paramInt)
  {
    AppMethodBeat.i(189879);
    if (this.mLongMap.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(189879);
      return false;
    }
    HashMap localHashMap = new HashMap();
    this.mLongMap.put(Integer.valueOf(paramInt), localHashMap);
    AppMethodBeat.o(189879);
    return true;
  }
  
  public void removeAction(int paramInt)
  {
    AppMethodBeat.i(189880);
    if (this.mLongMap.containsKey(Integer.valueOf(paramInt))) {
      this.mLongMap.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(189880);
  }
  
  public boolean setLongActionConfig(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(189881);
    if (!this.mLongMap.containsKey(Integer.valueOf(paramInt1)))
    {
      AppMethodBeat.o(189881);
      return false;
    }
    ((HashMap)this.mLongMap.get(Integer.valueOf(paramInt1))).put(Integer.valueOf(paramInt2), Long.valueOf(paramLong));
    AppMethodBeat.o(189881);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */