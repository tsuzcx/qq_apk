package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.sdk.platformtools.ab;

final class j$4
  implements f.a
{
  j$4(j paramj, n paramn) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37762);
    j.a(this.rCs, this.rCu.rsw);
    AppMethodBeat.o(37762);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37761);
    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rCu.rsw + "is error");
    j.a(this.rCs, this.rCu.rsw);
    AppMethodBeat.o(37761);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.4
 * JD-Core Version:    0.7.0.1
 */