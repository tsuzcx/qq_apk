package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;

final class m$a$g$2
  implements Runnable
{
  m$a$g$2(m.a.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(37130);
    m.c(this.rwa.rvU.rvI).setVisibility(8);
    m.d(this.rwa.rvU.rvI).setVisibility(0);
    m.d(this.rwa.rvU.rvI).setText(m.b(this.rwa.rvU.rvI).title);
    AppMethodBeat.o(37130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.g.2
 * JD-Core Version:    0.7.0.1
 */