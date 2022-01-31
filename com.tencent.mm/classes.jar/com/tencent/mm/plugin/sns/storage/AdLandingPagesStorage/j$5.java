package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.sdk.platformtools.ab;

final class j$5
  implements f.a
{
  j$5(j paramj, o paramo) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37764);
    j.a(this.rCs, this.rCr.rsw);
    AppMethodBeat.o(37764);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37763);
    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rCr.rsw + "is error");
    j.a(this.rCs, this.rCr.rsw);
    AppMethodBeat.o(37763);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.5
 * JD-Core Version:    0.7.0.1
 */