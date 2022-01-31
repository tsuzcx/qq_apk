package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$3
  implements f.a
{
  j$3(j paramj, String paramString) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(145437);
    j.a(this.rCs, this.val$url);
    AppMethodBeat.o(145437);
  }
  
  public final void coe()
  {
    AppMethodBeat.i(145436);
    ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.val$url + "is error");
    j.a(this.rCs, this.val$url);
    AppMethodBeat.o(145436);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.3
 * JD-Core Version:    0.7.0.1
 */