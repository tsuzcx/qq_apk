package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;

final class AdLandingPagesProxy$2
  implements Runnable
{
  AdLandingPagesProxy$2(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString) {}
  
  public final void run()
  {
    if (!g.DN().Dc()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = af.bDF().OA(this.eHc);
      } while (localObject == null);
      localObject = ((n)localObject).bFZ();
    } while (localObject == null);
    AdLandingPagesProxy.Nk(((b)localObject).bEN());
    AdLandingPagesProxy.Nk(((b)localObject).bEO());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.2
 * JD-Core Version:    0.7.0.1
 */