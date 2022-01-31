package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public final class qk
  implements px
{
  private ql a = null;
  private String b = "";
  private og c = null;
  
  public qk(ql paramql, og paramog, String paramString)
  {
    this.b = paramString;
    this.a = paramql;
    this.c = paramog;
  }
  
  public final List<kj> a()
  {
    return this.c.b(this.b);
  }
  
  public final void a(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 1.0F;
    }
    this.c.a(this.b, f);
    this.a.a(f);
  }
  
  public final void a(int paramInt)
  {
    this.c.a(this.b, paramInt);
    this.a.a(paramInt);
  }
  
  public final void a(pr parampr)
  {
    this.c.a(this.b, parampr);
  }
  
  public final void a(List<qc> paramList)
  {
    this.c.a(this.b, paramList);
    this.a.a(paramList);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.a(this.b, paramBoolean);
    this.a.a(paramBoolean);
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
    this.c.b(this.b, Math.max(0, paramInt));
    this.a.c(Math.max(0, paramInt));
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final List<qc> d()
  {
    return this.a.d();
  }
  
  public final float e()
  {
    return this.a.e();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof qk)) {
      return false;
    }
    paramObject = (qk)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public final int f()
  {
    return this.a.f();
  }
  
  public final int g()
  {
    return this.a.h();
  }
  
  public final boolean h()
  {
    return this.a.j();
  }
  
  public final int hashCode()
  {
    return this.b.hashCode();
  }
  
  public final List<Integer> i()
  {
    return this.a.v();
  }
  
  public final boolean j()
  {
    if (this.a != null) {
      return this.a.u();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qk
 * JD-Core Version:    0.7.0.1
 */