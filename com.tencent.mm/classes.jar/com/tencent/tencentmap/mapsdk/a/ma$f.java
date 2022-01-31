package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.f;
import java.lang.ref.WeakReference;

class ma$f
  implements ah.f
{
  private final WeakReference<ma> a;
  
  public ma$f(ma paramma)
  {
    this.a = new WeakReference(paramma);
  }
  
  private boolean b()
  {
    return (this.a == null) || (this.a.get() == null);
  }
  
  public boolean a()
  {
    if (b()) {
      return false;
    }
    Object localObject = (ma)this.a.get();
    ((ma)localObject).a();
    if (ma.q((ma)localObject) != null) {
      ma.q((ma)localObject).a();
    }
    localObject = ma.r((ma)localObject);
    if (localObject != null) {
      ((mq)localObject).b(true);
    }
    return true;
  }
  
  public boolean a(py parampy)
  {
    if (b()) {
      return false;
    }
    ma localma = (ma)this.a.get();
    localma.a(parampy);
    if (ma.q(localma) != null) {
      ma.q(localma).a(parampy);
    }
    mq localmq = ma.r(localma);
    if ((localmq != null) && (localmq.b()) && (localma.getMap().h() >= 16)) {
      localmq.a(parampy);
    }
    return true;
  }
  
  public boolean d()
  {
    if (b()) {
      return false;
    }
    Object localObject = (ma)this.a.get();
    ((ma)localObject).d();
    if (ma.q((ma)localObject) != null) {
      ma.q((ma)localObject).d();
    }
    localObject = ma.r((ma)localObject);
    if (localObject != null) {
      ((mq)localObject).b(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma.f
 * JD-Core Version:    0.7.0.1
 */