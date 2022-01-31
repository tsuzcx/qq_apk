package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$11
  implements f.a
{
  j$11(j paramj, String paramString) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(145441);
    j.a(this.rCs, this.rCy);
    ab.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl succ, url=" + this.rCy);
    AppMethodBeat.o(145441);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(145440);
    ab.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineImageUrl err, url=" + this.rCy);
    j.a(this.rCs, this.rCy);
    AppMethodBeat.o(145440);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(145439);
    ab.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineImageUrl");
    AppMethodBeat.o(145439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.11
 * JD-Core Version:    0.7.0.1
 */