package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.lang.ref.WeakReference;

class ma$c
  implements jp
{
  private final WeakReference<ma> a;
  
  public ma$c(ma paramma)
  {
    this.a = new WeakReference(paramma);
  }
  
  public void a(jo paramjo)
  {
    if ((this.a == null) || (this.a.get() == null) || (ma.f((ma)this.a.get()))) {}
    do
    {
      return;
      if (paramjo != null) {
        ((ma)this.a.get()).a(paramjo.i());
      }
    } while (ma.g((ma)this.a.get()) == null);
    ma.g((ma)this.a.get()).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma.c
 * JD-Core Version:    0.7.0.1
 */