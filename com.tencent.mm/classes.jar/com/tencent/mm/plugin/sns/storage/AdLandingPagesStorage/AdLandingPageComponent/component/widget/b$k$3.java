package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$k$3
  implements Runnable
{
  b$k$3(b.k paramk, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(37432);
    ab.v("MicroMsg.SightPlayController", "set background drawable null");
    this.guT.setBackgroundDrawable(null);
    AppMethodBeat.o(37432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.k.3
 * JD-Core Version:    0.7.0.1
 */