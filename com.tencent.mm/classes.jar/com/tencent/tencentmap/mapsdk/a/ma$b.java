package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.e;
import java.lang.ref.WeakReference;

class ma$b
  extends e
{
  private WeakReference<ma> a;
  
  public ma$b(ma paramma)
  {
    this.a = new WeakReference(paramma);
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public boolean b()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.b();
    }
    return ma.a((ma)this.a.get());
  }
  
  public boolean c()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.c();
    }
    return ma.b((ma)this.a.get());
  }
  
  public boolean d()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.d();
    }
    return ma.c((ma)this.a.get());
  }
  
  public boolean e()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.e();
    }
    return ma.d((ma)this.a.get());
  }
  
  public boolean f()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.f();
    }
    return ma.e((ma)this.a.get());
  }
  
  public boolean g()
  {
    return super.g();
  }
  
  public boolean h()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.h();
    }
    return ma.e((ma)this.a.get());
  }
  
  public boolean i()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return super.i();
    }
    return ma.e((ma)this.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma.b
 * JD-Core Version:    0.7.0.1
 */