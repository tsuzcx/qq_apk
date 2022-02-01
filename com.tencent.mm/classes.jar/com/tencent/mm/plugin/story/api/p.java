package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class p
{
  public static b AIi;
  public int AIh;
  public long key;
  
  public p(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.AIh = paramInt;
  }
  
  public static final class a
  {
    private static a AIj;
    private Map<Long, p> AIk;
    
    public a()
    {
      AppMethodBeat.i(118428);
      this.AIk = new HashMap();
      AppMethodBeat.o(118428);
    }
    
    public static a ehj()
    {
      AppMethodBeat.i(118429);
      if (AIj == null) {
        AIj = new a();
      }
      a locala = AIj;
      AppMethodBeat.o(118429);
      return locala;
    }
    
    public final p AD(long paramLong)
    {
      AppMethodBeat.i(118431);
      p localp = (p)this.AIk.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(118431);
      return localp;
    }
    
    public final void a(long paramLong, p paramp)
    {
      AppMethodBeat.i(118430);
      this.AIk.put(Long.valueOf(paramLong), paramp);
      AppMethodBeat.o(118430);
    }
  }
  
  public static abstract interface b
  {
    public abstract long a(List<String> paramList, String paramString, Map<String, ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt);
    
    public abstract long a(List<String> paramList, Map<String, ArrayList<Long>> paramMap, int paramInt);
    
    public abstract long b(List<String> paramList, String paramString, int paramInt);
    
    public abstract long v(List<String> paramList, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.p
 * JD-Core Version:    0.7.0.1
 */