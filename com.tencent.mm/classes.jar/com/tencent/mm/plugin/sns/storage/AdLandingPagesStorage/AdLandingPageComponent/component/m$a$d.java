package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;

final class m$a$d
  extends com.tencent.mm.sdk.d.b
{
  m$a$d(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37121);
    super.enter();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = m.b(this.rvU.rvI);
    int i;
    if ((localb.rrF == 0) || (localb.rrF == 2)) {
      i = 1;
    }
    while (i != 0) {
      if (AdLandingPagesProxy.getInstance().isApkExist(m.b(this.rvU.rvI).cwc))
      {
        this.rvU.b(this.rvU.rvO);
        AppMethodBeat.o(37121);
        return;
        i = 0;
      }
      else
      {
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(m.b(this.rvU.rvI).Ca))
        {
          this.rvU.b(this.rvU.rvP);
          AppMethodBeat.o(37121);
          return;
        }
        this.rvU.b(this.rvU.rvR);
        AppMethodBeat.o(37121);
        return;
      }
    }
    this.rvU.b(this.rvU.rvS);
    AppMethodBeat.o(37121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.d
 * JD-Core Version:    0.7.0.1
 */