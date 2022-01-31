package com.tencent.mm.ui.voicesearch;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.storage.ad;

final class b$7
  implements Runnable
{
  b$7(b paramb, String paramString) {}
  
  public final void run()
  {
    if (b.b(this.wiQ).isHidden())
    {
      b.b(this.wiQ).AR();
      if (b.c(this.wiQ))
      {
        f localf = new f(this.wiR, 3);
        au.Dk().a(localf, 0);
        b.d(this.wiQ);
      }
      return;
    }
    b.b(this.wiQ).AQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.7
 * JD-Core Version:    0.7.0.1
 */