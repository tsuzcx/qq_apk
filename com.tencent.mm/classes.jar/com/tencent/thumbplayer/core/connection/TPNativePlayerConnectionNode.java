package com.tencent.thumbplayer.core.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPNativePlayerConnectionNode
{
  private HashMap<Integer, HashMap<Integer, Long>> mLongMap;
  
  public TPNativePlayerConnectionNode()
  {
    AppMethodBeat.i(227321);
    this.mLongMap = null;
    this.mLongMap = new HashMap();
    AppMethodBeat.o(227321);
  }
  
  public boolean addAction(int paramInt)
  {
    AppMethodBeat.i(227332);
    if (this.mLongMap.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(227332);
      return false;
    }
    HashMap localHashMap = new HashMap();
    this.mLongMap.put(Integer.valueOf(paramInt), localHashMap);
    AppMethodBeat.o(227332);
    return true;
  }
  
  public void removeAction(int paramInt)
  {
    AppMethodBeat.i(227342);
    if (this.mLongMap.containsKey(Integer.valueOf(paramInt))) {
      this.mLongMap.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(227342);
  }
  
  public boolean setLongActionConfig(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(227359);
    if (!this.mLongMap.containsKey(Integer.valueOf(paramInt1)))
    {
      AppMethodBeat.o(227359);
      return false;
    }
    ((HashMap)this.mLongMap.get(Integer.valueOf(paramInt1))).put(Integer.valueOf(paramInt2), Long.valueOf(paramLong));
    AppMethodBeat.o(227359);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */