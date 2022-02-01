package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;

final class q$a$g$2
  implements Runnable
{
  q$a$g$2(q.a.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(96538);
    q.c(this.ynU.ynN.ynC).setVisibility(8);
    q.d(this.ynU.ynN.ynC).setVisibility(0);
    q.d(this.ynU.ynN.ynC).setText(q.b(this.ynU.ynN.ynC).title);
    AppMethodBeat.o(96538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.a.g.2
 * JD-Core Version:    0.7.0.1
 */