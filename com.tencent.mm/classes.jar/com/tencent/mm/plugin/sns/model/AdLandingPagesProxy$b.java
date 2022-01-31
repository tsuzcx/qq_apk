package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AdLandingPagesProxy$b
  implements a.c
{
  private String Ca;
  private String appId;
  private boolean rcN;
  
  public AdLandingPagesProxy$b(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.Ca = paramString2;
    this.appId = paramString1;
    this.rcN = paramBoolean;
  }
  
  public final void ZX(String paramString)
  {
    AppMethodBeat.i(35919);
    ab.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
    if (this.rcN) {
      a.e.rrx.reportDownloadInfo(4, this.appId);
    }
    a.e.rrx.reportDownloadInfo(5, this.appId);
    AppMethodBeat.o(35919);
  }
  
  public final void ZY(String paramString)
  {
    AppMethodBeat.i(35920);
    ab.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(this.Ca))) {
      this.rcM.deleteDeferredDeepLinkMM(paramString);
    }
    AppMethodBeat.o(35920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.b
 * JD-Core Version:    0.7.0.1
 */