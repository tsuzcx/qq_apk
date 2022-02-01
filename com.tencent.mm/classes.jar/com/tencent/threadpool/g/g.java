package com.tencent.threadpool.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  public a ahBH;
  HashMap<String, Object> map;
  
  public g(a parama)
  {
    AppMethodBeat.i(183329);
    this.map = new HashMap();
    this.ahBH = parama;
    AppMethodBeat.o(183329);
  }
  
  public final void cG(String paramString, long paramLong)
  {
    AppMethodBeat.i(183331);
    this.map.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(183331);
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(183334);
    paramString = this.map.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183334);
      return paramLong;
    }
    paramLong = ((Long)paramString).longValue();
    AppMethodBeat.o(183334);
    return paramLong;
  }
  
  public final void jA(String paramString, int paramInt)
  {
    AppMethodBeat.i(183332);
    this.ahBH.ahBI.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(183332);
  }
  
  public final int jB(String paramString, int paramInt)
  {
    AppMethodBeat.i(183333);
    paramString = this.ahBH.ahBI.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183333);
      return paramInt;
    }
    paramInt = ((Integer)paramString).intValue();
    AppMethodBeat.o(183333);
    return paramInt;
  }
  
  public final int jZp()
  {
    AppMethodBeat.i(183330);
    int i = this.ahBH.ahBJ.get();
    AppMethodBeat.o(183330);
    return i;
  }
  
  public static final class a
  {
    public ConcurrentHashMap<String, Object> ahBI;
    public AtomicInteger ahBJ;
    public String key;
    
    public a(String paramString, AtomicInteger paramAtomicInteger)
    {
      AppMethodBeat.i(183328);
      this.ahBI = new ConcurrentHashMap();
      this.key = paramString;
      this.ahBJ = paramAtomicInteger;
      AppMethodBeat.o(183328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.g.g
 * JD-Core Version:    0.7.0.1
 */