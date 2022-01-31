package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$8
  implements c.a
{
  j$8(j paramj, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab paramab) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(37769);
    com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesPreDownloadResHelper", " pre download " + this.rCw.rsB + "is error");
    j.a(this.rCs, this.rCw.rsB);
    AppMethodBeat.o(37769);
  }
  
  public final void dq(String paramString, int paramInt) {}
  
  public final void mP(String paramString)
  {
    AppMethodBeat.i(37770);
    j.a(this.rCs, this.rCw.rsB);
    AppMethodBeat.o(37770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.8
 * JD-Core Version:    0.7.0.1
 */