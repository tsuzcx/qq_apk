package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.lang.ref.WeakReference;

class ma$e
  implements is
{
  private final WeakReference<ma> a;
  
  public ma$e(ma paramma)
  {
    this.a = new WeakReference(paramma);
  }
  
  public void a()
  {
    ma localma = (ma)this.a.get();
    if ((localma == null) || (ma.g(localma) == null) || (ma.f(localma))) {
      return;
    }
    ma.g(localma).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma.e
 * JD-Core Version:    0.7.0.1
 */