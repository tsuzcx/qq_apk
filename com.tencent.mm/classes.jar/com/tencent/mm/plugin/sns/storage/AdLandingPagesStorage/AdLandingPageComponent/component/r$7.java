package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.ab;

final class r$7
  implements View.OnClickListener
{
  r$7(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37210);
    ab.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(this.rxh.rwF.isPlaying()) });
    if (this.rxh.rwF.isPlaying())
    {
      this.rxh.crn();
      this.rxh.rwX = 4;
      if (this.rxh.rrB)
      {
        paramView = this.rxh;
        paramView.rxa += 1;
      }
      AppMethodBeat.o(37210);
      return;
    }
    if (this.rxh.rwP) {
      this.rxh.cqy();
    }
    for (;;)
    {
      r.b(this.rxh);
      this.rxh.rwX = 3;
      break;
      this.rxh.cqE();
      this.rxh.cqD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.7
 * JD-Core Version:    0.7.0.1
 */