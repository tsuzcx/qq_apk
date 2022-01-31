package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$2
  implements Runnable
{
  u$2(u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(37247);
    int i = this.rxu.cuM.getMeasuredWidth();
    if (i > this.rxu.iiW)
    {
      u localu = this.rxu;
      localu.rxm = ((i - localu.iiW) / 2);
      this.rxu.rxp.scrollBy(this.rxu.rxm, 0);
    }
    AppMethodBeat.o(37247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.2
 * JD-Core Version:    0.7.0.1
 */