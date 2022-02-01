package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class p
{
  public static p.b FkJ;
  public int FkI;
  public long key;
  
  public p(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.FkI = paramInt;
  }
  
  public static final class a
  {
    private static a FkK;
    private Map<Long, p> FkL;
    
    public a()
    {
      AppMethodBeat.i(118428);
      this.FkL = new HashMap();
      AppMethodBeat.o(118428);
    }
    
    public static a fns()
    {
      AppMethodBeat.i(118429);
      if (FkK == null) {
        FkK = new a();
      }
      a locala = FkK;
      AppMethodBeat.o(118429);
      return locala;
    }
    
    public final p Kg(long paramLong)
    {
      AppMethodBeat.i(118431);
      p localp = (p)this.FkL.remove(Long.valueOf(paramLong));
      AppMethodBeat.o(118431);
      return localp;
    }
    
    public final void a(long paramLong, p paramp)
    {
      AppMethodBeat.i(118430);
      this.FkL.put(Long.valueOf(paramLong), paramp);
      AppMethodBeat.o(118430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.p
 * JD-Core Version:    0.7.0.1
 */