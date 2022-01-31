package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class k$2
  implements Runnable
{
  k$2(k paramk) {}
  
  public final void run()
  {
    a locala = k.c(this.vTA);
    y.i("MicroMsg.BannerHelper", "destroyBanner");
    a.es(locala.vOV);
    a.es(locala.vOW);
    a.es(locala.vOX);
    a.es(locala.vOY);
    Iterator localIterator = locala.vOZ.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.destroy();
      }
    }
    au.b(locala.nIV);
    com.tencent.mm.sdk.b.a.udP.d(locala.vPa);
    com.tencent.mm.sdk.b.a.udP.d(locala.vPb);
    if (au.DK())
    {
      au.Hx();
      c.b(locala);
    }
    locala.context = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.2
 * JD-Core Version:    0.7.0.1
 */