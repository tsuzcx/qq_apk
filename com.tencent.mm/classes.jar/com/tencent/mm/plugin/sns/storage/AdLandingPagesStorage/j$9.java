package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$9
  implements f.a
{
  j$9(j paramj, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab paramab) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37772);
    j.a(this.rCs, this.rCw.rtl);
    AppMethodBeat.o(37772);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37771);
    com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rCw.rtl + "is error");
    j.a(this.rCs, this.rCw.rsB);
    AppMethodBeat.o(37771);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.9
 * JD-Core Version:    0.7.0.1
 */