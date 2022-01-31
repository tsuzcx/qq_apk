package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$2
  implements f.a
{
  j$2(j paramj, String paramString) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(145435);
    j.a(this.rCs, this.rCt);
    ab.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl succ, url=" + this.rCt);
    AppMethodBeat.o(145435);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(145434);
    ab.e("AdLandingPagesPreDownloadResHelper.SphereImageView", " pre download timeLineThumbUrl err, url=" + this.rCt);
    j.a(this.rCs, this.rCt);
    AppMethodBeat.o(145434);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(145433);
    ab.i("AdLandingPagesPreDownloadResHelper.SphereImageView", "pre download timeLineThumbUrl");
    AppMethodBeat.o(145433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.2
 * JD-Core Version:    0.7.0.1
 */