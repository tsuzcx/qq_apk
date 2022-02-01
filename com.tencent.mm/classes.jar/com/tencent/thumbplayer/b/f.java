package com.tencent.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public int LYM = -1;
  public a LYN;
  public b LYO;
  public e LYP;
  public c LYQ;
  public d LYR;
  public int key;
  
  public final f aU(int paramInt, long paramLong)
  {
    AppMethodBeat.i(191847);
    this.LYM = 2;
    this.key = paramInt;
    this.LYO = new b();
    this.LYO.value = paramLong;
    AppMethodBeat.o(191847);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(191848);
    Object localObject1 = new StringBuilder();
    switch (this.LYM)
    {
    default: 
      ((StringBuilder)localObject1).append("type:unkonw");
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(191848);
      return localObject1;
      ((StringBuilder)localObject1).append("type:long, , key:" + this.key + ", value:" + this.LYN.value);
      continue;
      ((StringBuilder)localObject1).append("type:long, , key:" + this.key + ", value:" + this.LYO.value + "param1, :" + this.LYO.LYS + ", param2:" + this.LYO.LYT);
      continue;
      ((StringBuilder)localObject1).append("type:string, , key:" + this.key + ", value:" + this.LYP.value + "param1, :" + this.LYP.LYW + ", param2:" + this.LYP.LYX);
      continue;
      ((StringBuilder)localObject1).append("type:quint_int, , key:" + this.key + ", value:");
      if (this.LYQ.LYU != null)
      {
        Object localObject2 = this.LYQ.LYU;
        j = localObject2.length;
        int k;
        while (i < j)
        {
          k = localObject2[i];
          ((StringBuilder)localObject1).append(k + ", ");
          i += 1;
        }
        ((StringBuilder)localObject1).append("type:quint_string, , key:" + this.key + ", value:");
        if (this.LYR.LYV != null)
        {
          localObject2 = this.LYR.LYV;
          k = localObject2.length;
          i = j;
          while (i < k)
          {
            String str = localObject2[i];
            ((StringBuilder)localObject1).append(str + ", ");
            i += 1;
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public boolean value;
  }
  
  public static final class b
  {
    public long LYS;
    public long LYT;
    public long value;
  }
  
  public static final class c
  {
    public int[] LYU;
  }
  
  public static final class d
  {
    public String[] LYV;
  }
  
  public static final class e
  {
    public String LYW;
    public String LYX;
    public String value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.b.f
 * JD-Core Version:    0.7.0.1
 */