package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class p
{
  public static b zqo;
  public long key;
  public int zqn;
  
  public p(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.zqn = paramInt;
  }
  
  public static final class a
  {
    private static a zqp;
    private Map<Long, p> zqq;
    
    public a()
    {
      AppMethodBeat.i(118428);
      this.zqq = new HashMap();
      AppMethodBeat.o(118428);
    }
    
    public static a dUU()
    {
      AppMethodBeat.i(118429);
      if (zqp == null) {
        zqp = new a();
      }
      a locala = zqp;
      AppMethodBeat.o(118429);
      return locala;
    }
    
    public final void a(long paramLong, p paramp)
    {
      AppMethodBeat.i(118430);
      this.zqq.put(Long.valueOf(paramLong), paramp);
      AppMethodBeat.o(118430);
    }
    
    public final p yf(long paramLong)
    {
      AppMethodBeat.i(118431);
      p localp = (p)this.zqq.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(118431);
      return localp;
    }
  }
  
  public static abstract interface b
  {
    public abstract long a(List<String> paramList, String paramString, Map<String, ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt);
    
    public abstract long a(List<String> paramList, Map<String, ArrayList<Long>> paramMap, int paramInt);
    
    public abstract long b(List<String> paramList, String paramString, int paramInt);
    
    public abstract long t(List<String> paramList, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.p
 * JD-Core Version:    0.7.0.1
 */