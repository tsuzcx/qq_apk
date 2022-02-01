package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class AdLandingPagesProxy$b
  implements a.c
{
  private String JG;
  private String appId;
  private boolean oKT;
  
  public AdLandingPagesProxy$b(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.JG = paramString2;
    this.appId = paramString1;
    this.oKT = paramBoolean;
  }
  
  public final void atq(String paramString)
  {
    AppMethodBeat.i(95219);
    ac.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
    if (this.oKT) {
      a.e.yhL.reportDownloadInfo(4, this.appId);
    }
    a.e.yhL.reportDownloadInfo(5, this.appId);
    AppMethodBeat.o(95219);
  }
  
  public final void atr(String paramString)
  {
    AppMethodBeat.i(95220);
    ac.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals(this.JG))) {
      this.xPx.deleteDeferredDeepLinkMM(paramString);
    }
    AppMethodBeat.o(95220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.b
 * JD-Core Version:    0.7.0.1
 */