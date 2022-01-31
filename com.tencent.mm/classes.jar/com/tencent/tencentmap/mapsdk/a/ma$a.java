package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.map.lib.f;
import java.lang.ref.WeakReference;

class ma$a
  extends Handler
{
  private final WeakReference<ma> a;
  
  public ma$a(ma paramma)
  {
    this.a = new WeakReference(paramma);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((this.a == null) || (this.a.get() == null)) {}
    ma localma;
    pu localpu;
    do
    {
      return;
      localma = (ma)this.a.get();
      localpu = ma.j(localma);
    } while (localpu == null);
    if (localma.p == null)
    {
      if (paramMessage.what != 0) {
        break label127;
      }
      if (localma.n != null)
      {
        ma.a(localma, false);
        ma.b(localma, true);
        localma.n.a(localpu);
      }
    }
    for (;;)
    {
      if (ma.o(localma) != null) {
        ma.o(localma).d();
      }
      if (ma.p(localma) == null) {
        break;
      }
      if (localma.getMap() != null) {
        break label209;
      }
      ma.p(localma).a(localma.getMapRegion(), 0);
      return;
      label127:
      if (paramMessage.what == 1)
      {
        if (localma.n != null)
        {
          ma.a(localma, true);
          if ((ma.k(localma)) && (ma.l(localma) == 0))
          {
            ma.b(localma, false);
            localma.n.b(localpu);
          }
        }
        if ((ma.m(localma) != null) && (ma.n(localma))) {
          ma.m(localma).a();
        }
        localma.getMap().H();
      }
    }
    label209:
    ma.p(localma).a(localma.getMapRegion(), localma.getMap().e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma.a
 * JD-Core Version:    0.7.0.1
 */