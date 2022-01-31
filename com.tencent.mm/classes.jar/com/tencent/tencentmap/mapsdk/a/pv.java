package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public final class pv
  implements px
{
  private pw a = null;
  private String b = "";
  private ou c = null;
  
  public pv(pw parampw, ou paramou, String paramString)
  {
    this.b = paramString;
    this.a = parampw;
    this.c = paramou;
  }
  
  public final List<kj> a()
  {
    if (this.c != null) {
      return this.c.b(this.b);
    }
    return null;
  }
  
  public final void a(double paramDouble)
  {
    if (paramDouble < 0.0D) {}
    while (this.c == null) {
      return;
    }
    this.c.a(this.b, paramDouble);
    this.a.a(paramDouble);
  }
  
  public final void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    this.c.a(this.b, paramFloat);
    this.a.a(paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.c.b(this.b, paramInt);
    this.a.a(paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.a(this.b, paramBoolean);
    this.a.a(paramBoolean);
  }
  
  public final boolean a(qc paramqc)
  {
    return lr.c(d(), paramqc) < e();
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
  
  public final void b(qc paramqc)
  {
    if (this.c == null) {
      return;
    }
    this.c.a(this.b, paramqc);
    this.a.a(paramqc);
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
  
  public final qc d()
  {
    return new qc(this.a.a().a, this.a.a().b);
  }
  
  public final double e()
  {
    return this.a.b();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof pv)) {
      return false;
    }
    paramObject = (pv)paramObject;
    return this.b.equals(paramObject.b);
  }
  
  public final float f()
  {
    return this.a.c();
  }
  
  public final int g()
  {
    return this.a.d();
  }
  
  public final int h()
  {
    return this.a.e();
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final float i()
  {
    return this.a.f();
  }
  
  public final boolean j()
  {
    return this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.pv
 * JD-Core Version:    0.7.0.1
 */