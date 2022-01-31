package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public final class qi
  implements px
{
  private qj a = null;
  private String b = "";
  private oe c = null;
  
  public qi(qj paramqj, oe paramoe, String paramString)
  {
    this.b = paramString;
    this.a = paramqj;
    this.c = paramoe;
  }
  
  public final List<kj> a()
  {
    if (this.c != null) {
      return this.c.b(this.b);
    }
    return null;
  }
  
  public final void a(float paramFloat)
  {
    this.c.a(this.b, paramFloat);
    this.a.a(paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.c.b(this.b, paramInt);
    this.a.a(paramInt);
  }
  
  public final void a(List<qc> paramList)
  {
    if (this.c == null) {
      return;
    }
    this.c.a(this.b, paramList);
    this.a.a(paramList);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.a(this.b, paramBoolean);
    this.a.a(paramBoolean);
  }
  
  public final boolean a(qc paramqc)
  {
    List localList = d();
    boolean bool;
    if ((localList == null) || (localList.size() < 3) || (paramqc == null)) {
      bool = false;
    }
    int j;
    int i;
    int k;
    do
    {
      return bool;
      j = localList.size() - 1;
      i = 0;
      while (i < localList.size())
      {
        if (((qc)localList.get(i)).equals(paramqc)) {
          return true;
        }
        i += 1;
      }
      i = 0;
      k = 0;
      bool = k;
    } while (i >= localList.size());
    if (((((qc)localList.get(i)).a < paramqc.a) && (((qc)localList.get(j)).a >= paramqc.a)) || ((((qc)localList.get(j)).a < paramqc.a) && (((qc)localList.get(i)).a >= paramqc.a) && ((((qc)localList.get(i)).b <= paramqc.b) || (((qc)localList.get(j)).b <= paramqc.b))))
    {
      double d1 = ((qc)localList.get(i)).b;
      double d2 = (paramqc.a - ((qc)localList.get(i)).a) / (((qc)localList.get(j)).a - ((qc)localList.get(i)).a);
      if ((((qc)localList.get(j)).b - ((qc)localList.get(i)).b) * d2 + d1 <= paramqc.b)
      {
        j = 1;
        label365:
        k ^= j;
      }
    }
    for (;;)
    {
      j = i;
      i += 1;
      break;
      j = 0;
      break label365;
    }
  }
  
  public final void b()
  {
    if (this.c == null) {
      return;
    }
    this.c.a(this.b);
  }
  
  public final void b(int paramInt)
  {
    this.c.a(this.b, paramInt);
    this.a.b(paramInt);
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final void c(int paramInt)
  {
    this.c.b(this.b, paramInt);
    this.a.c(paramInt);
  }
  
  public final List<qc> d()
  {
    return this.a.a();
  }
  
  public final float e()
  {
    return this.a.b();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof qi)) {
      return false;
    }
    paramObject = (qi)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public final int f()
  {
    return this.a.c();
  }
  
  public final int g()
  {
    return this.a.d();
  }
  
  public final float h()
  {
    return this.a.e();
  }
  
  public final int hashCode()
  {
    return this.b.hashCode();
  }
  
  public final boolean i()
  {
    return this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qi
 * JD-Core Version:    0.7.0.1
 */