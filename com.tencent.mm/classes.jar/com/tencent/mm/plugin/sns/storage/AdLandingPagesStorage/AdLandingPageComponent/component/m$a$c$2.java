package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;

final class m$a$c$2
  implements Runnable
{
  m$a$c$2(m.a.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(37112);
    m.c(this.rvX.rvU.rvI).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(m.b(this.rvX.rvU.rvI).cwc));
    AppMethodBeat.o(37112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.c.2
 * JD-Core Version:    0.7.0.1
 */