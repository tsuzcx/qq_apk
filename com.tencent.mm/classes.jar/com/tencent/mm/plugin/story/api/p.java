package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class p
{
  public static b LEL;
  public int LEK;
  public long key;
  
  public p(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.LEK = paramInt;
  }
  
  public static final class a
  {
    private static a LEM;
    private Map<Long, p> LEN;
    
    public a()
    {
      AppMethodBeat.i(118428);
      this.LEN = new HashMap();
      AppMethodBeat.o(118428);
    }
    
    public static a gbL()
    {
      AppMethodBeat.i(118429);
      if (LEM == null) {
        LEM = new a();
      }
      a locala = LEM;
      AppMethodBeat.o(118429);
      return locala;
    }
    
    public final p RA(long paramLong)
    {
      AppMethodBeat.i(118431);
      p localp = (p)this.LEN.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(118431);
      return localp;
    }
    
    public final void a(long paramLong, p paramp)
    {
      AppMethodBeat.i(118430);
      this.LEN.put(Long.valueOf(paramLong), paramp);
      AppMethodBeat.o(118430);
    }
  }
  
  public static abstract interface b
  {
    public abstract long C(List<String> paramList, int paramInt);
    
    public abstract long a(List<String> paramList, String paramString, int paramInt);
    
    public abstract long a(List<String> paramList, String paramString, Map<String, ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt);
    
    public abstract long a(List<String> paramList, Map<String, ArrayList<Long>> paramMap, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.p
 * JD-Core Version:    0.7.0.1
 */