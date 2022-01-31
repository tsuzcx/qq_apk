package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ContentFragment$6
  implements f.a
{
  ContentFragment$6(ContentFragment paramContentFragment) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37623);
    ab.d("ContentFragment", "onDownloaded nextBtn");
    ContentFragment.a(this.rzA, paramString, ContentFragment.a(this.rzA).rzG);
    this.rzA.crJ();
    AppMethodBeat.o(37623);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37622);
    ab.d("ContentFragment", "onDownloadError nextBtn");
    AppMethodBeat.o(37622);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.6
 * JD-Core Version:    0.7.0.1
 */