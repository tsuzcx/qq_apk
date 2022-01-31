package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

class ma$d
  implements iq
{
  private final WeakReference<ma> a;
  
  public ma$d(ma paramma)
  {
    this.a = new WeakReference(paramma);
  }
  
  public void a(jo.c paramc)
  {
    if ((this.a == null) || (this.a.get() == null) || (paramc != jo.c.c)) {
      return;
    }
    ma.h((ma)this.a.get());
    ma.i((ma)this.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma.d
 * JD-Core Version:    0.7.0.1
 */