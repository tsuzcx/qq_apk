package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class m$a$g$3
  implements Runnable
{
  m$a$g$3(m.a.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(37132);
    if (!NetStatusUtil.isWifi(this.rwa.rvU.rvI.context))
    {
      ab.i("LogStateTransitionState", "download not in wifi!");
      h.a(this.rwa.rvU.rvI.context, 2131305852, 2131305853, new m.a.g.3.1(this), null);
      AppMethodBeat.o(37132);
      return;
    }
    m.a(this.rwa.rvU.rvI).sendMessage(12);
    AppMethodBeat.o(37132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.g.3
 * JD-Core Version:    0.7.0.1
 */