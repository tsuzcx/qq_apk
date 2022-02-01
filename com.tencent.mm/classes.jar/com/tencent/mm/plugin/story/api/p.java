package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class p
{
  public static b Siw;
  public int Siv;
  public long key;
  
  public p(long paramLong, int paramInt)
  {
    this.key = paramLong;
    this.Siv = paramInt;
  }
  
  public static final class a
  {
    private static a Six;
    public Map<Long, p> Siy;
    
    public a()
    {
      AppMethodBeat.i(118428);
      this.Siy = new HashMap();
      AppMethodBeat.o(118428);
    }
    
    public static a hvc()
    {
      AppMethodBeat.i(118429);
      if (Six == null) {
        Six = new a();
      }
      a locala = Six;
      AppMethodBeat.o(118429);
      return locala;
    }
    
    public final void a(long paramLong, p paramp)
    {
      AppMethodBeat.i(118430);
      this.Siy.put(Long.valueOf(paramLong), paramp);
      AppMethodBeat.o(118430);
    }
  }
  
  public static abstract interface b
  {
    public abstract long U(List<String> paramList, int paramInt);
    
    public abstract long a(List<String> paramList, String paramString, int paramInt);
    
    public abstract long a(List<String> paramList, String paramString, Map<String, ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt);
    
    public abstract long a(List<String> paramList, Map<String, ArrayList<Long>> paramMap, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.p
 * JD-Core Version:    0.7.0.1
 */