package com.tencent.toybrick.e;

import com.tencent.toybrick.d.a.a;
import java.lang.ref.WeakReference;

public final class b$1
  implements Runnable
{
  public b$1(b paramb) {}
  
  public final void run()
  {
    com.tencent.toybrick.b.b localb = (com.tencent.toybrick.b.b)this.xbx.xbv.get();
    if (localb != null) {
      a.cRa().execute(new b.b(this.xbx, localb.xar.xbp, localb.xan, localb.xam));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.e.b.1
 * JD-Core Version:    0.7.0.1
 */