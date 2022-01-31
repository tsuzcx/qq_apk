package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;

final class AdLandingPagesProxy$3
  implements Runnable
{
  AdLandingPagesProxy$3(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(35918);
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(35918);
      return;
    }
    Object localObject = ag.cpf().abu(this.fWS);
    if (localObject != null)
    {
      localObject = ((n)localObject).csb();
      if (localObject != null)
      {
        AdLandingPagesProxy.ZW(((b)localObject).cqt());
        AdLandingPagesProxy.ZW(((b)localObject).cqu());
      }
    }
    AppMethodBeat.o(35918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.3
 * JD-Core Version:    0.7.0.1
 */