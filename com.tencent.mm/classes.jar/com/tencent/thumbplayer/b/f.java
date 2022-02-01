package com.tencent.thumbplayer.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public int KeQ = -1;
  public a KeR;
  public b KeS;
  public e KeT;
  public c KeU;
  public d KeV;
  public int key;
  
  public final f aK(int paramInt, long paramLong)
  {
    AppMethodBeat.i(187826);
    this.KeQ = 2;
    this.key = paramInt;
    this.KeS = new b();
    this.KeS.value = paramLong;
    AppMethodBeat.o(187826);
    return this;
  }
  
  public final String toString()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(187827);
    Object localObject1 = new StringBuilder();
    switch (this.KeQ)
    {
    default: 
      ((StringBuilder)localObject1).append("type:unkonw");
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(187827);
      return localObject1;
      ((StringBuilder)localObject1).append("type:long, , key:" + this.key + ", value:" + this.KeR.value);
      continue;
      ((StringBuilder)localObject1).append("type:long, , key:" + this.key + ", value:" + this.KeS.value + "param1, :" + this.KeS.KeW + ", param2:" + this.KeS.KeX);
      continue;
      ((StringBuilder)localObject1).append("type:string, , key:" + this.key + ", value:" + this.KeT.value + "param1, :" + this.KeT.Kfa + ", param2:" + this.KeT.Kfb);
      continue;
      ((StringBuilder)localObject1).append("type:quint_int, , key:" + this.key + ", value:");
      if (this.KeU.KeY != null)
      {
        Object localObject2 = this.KeU.KeY;
        j = localObject2.length;
        int k;
        while (i < j)
        {
          k = localObject2[i];
          ((StringBuilder)localObject1).append(k + ", ");
          i += 1;
        }
        ((StringBuilder)localObject1).append("type:quint_string, , key:" + this.key + ", value:");
        if (this.KeV.KeZ != null)
        {
          localObject2 = this.KeV.KeZ;
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
    public long KeW;
    public long KeX;
    public long value;
  }
  
  public static final class c
  {
    public int[] KeY;
  }
  
  public static final class d
  {
    public String[] KeZ;
  }
  
  public static final class e
  {
    public String Kfa;
    public String Kfb;
    public String value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.b.f
 * JD-Core Version:    0.7.0.1
 */