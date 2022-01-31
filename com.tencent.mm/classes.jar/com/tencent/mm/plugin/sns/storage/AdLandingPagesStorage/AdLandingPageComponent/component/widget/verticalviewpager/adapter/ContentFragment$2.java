package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ContentFragment$2
  implements f.a
{
  ContentFragment$2(ContentFragment paramContentFragment, String paramString) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37616);
    ContentFragment.a(this.rzA, paramString, "adId", this.hZk);
    AppMethodBeat.o(37616);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37615);
    ab.i("ContentFragment", "download img fail %s", new Object[] { this.hZk });
    ContentFragment.c(this.rzA);
    AppMethodBeat.o(37615);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.2
 * JD-Core Version:    0.7.0.1
 */