package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.ab;

final class x$3$1
  implements f.a
{
  x$3$1(x.3 param3) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37275);
    ab.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + this.rxH.rxG.contentView.getHeight() + ", player height " + x.a(this.rxH.rxG).getHeight());
    x.a(this.rxH.rxG, false);
    x.a(this.rxH.rxG, paramString);
    x.a(this.rxH.rxG).Oh(paramString);
    x.c(this.rxH.rxG);
    AppMethodBeat.o(37275);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37274);
    ab.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
    x.a(this.rxH.rxG, true);
    AppMethodBeat.o(37274);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.3.1
 * JD-Core Version:    0.7.0.1
 */