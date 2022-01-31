package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$10
  implements f.a
{
  j$10(j paramj, String paramString) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37774);
    j.a(this.rCs, this.rCx);
    ab.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl succ, url=" + this.rCx);
    AppMethodBeat.o(37774);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37773);
    ab.e("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl err, url=" + this.rCx);
    j.a(this.rCs, this.rCx);
    AppMethodBeat.o(37773);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(145438);
    ab.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download adLanding sphereImageUrl");
    AppMethodBeat.o(145438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.10
 * JD-Core Version:    0.7.0.1
 */