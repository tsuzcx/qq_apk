package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class p
{
  public static b AZL;
  public int AZK;
  public long key;
  
  public p(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.AZK = paramInt;
  }
  
  public static final class a
  {
    private static a AZM;
    private Map<Long, p> AZN;
    
    public a()
    {
      AppMethodBeat.i(118428);
      this.AZN = new HashMap();
      AppMethodBeat.o(118428);
    }
    
    public static a ekR()
    {
      AppMethodBeat.i(118429);
      if (AZM == null) {
        AZM = new a();
      }
      a locala = AZM;
      AppMethodBeat.o(118429);
      return locala;
    }
    
    public final p Bb(long paramLong)
    {
      AppMethodBeat.i(118431);
      p localp = (p)this.AZN.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(118431);
      return localp;
    }
    
    public final void a(long paramLong, p paramp)
    {
      AppMethodBeat.i(118430);
      this.AZN.put(Long.valueOf(paramLong), paramp);
      AppMethodBeat.o(118430);
    }
  }
  
  public static abstract interface b
  {
    public abstract long a(List<String> paramList, String paramString, int paramInt);
    
    public abstract long a(List<String> paramList, String paramString, Map<String, ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt);
    
    public abstract long a(List<String> paramList, Map<String, ArrayList<Long>> paramMap, int paramInt);
    
    public abstract long w(List<String> paramList, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.p
 * JD-Core Version:    0.7.0.1
 */