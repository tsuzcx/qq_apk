package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.ab;

final class aa$7
  implements View.OnClickListener
{
  aa$7(aa paramaa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37308);
    ab.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(this.rxT.rwF.isPlaying()) });
    if (this.rxT.rwF.isPlaying())
    {
      this.rxT.crn();
      this.rxT.rwX = 4;
      if (this.rxT.rrB)
      {
        paramView = this.rxT;
        paramView.rxa += 1;
      }
      AppMethodBeat.o(37308);
      return;
    }
    if (this.rxT.rwP) {
      this.rxT.cqy();
    }
    for (;;)
    {
      aa.b(this.rxT);
      this.rxT.rwX = 3;
      break;
      this.rxT.cqE();
      this.rxT.cqD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.7
 * JD-Core Version:    0.7.0.1
 */