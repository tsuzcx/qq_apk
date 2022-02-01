package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class AdLandingPagesProxy$b
  implements a.c
{
  private String Lw;
  private String appId;
  private boolean pvh;
  
  public AdLandingPagesProxy$b(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.Lw = paramString2;
    this.appId = paramString1;
    this.pvh = paramBoolean;
  }
  
  public final void azM(String paramString)
  {
    AppMethodBeat.i(95219);
    ae.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
    if (this.pvh) {
      a.e.zPr.reportDownloadInfo(4, this.appId);
    }
    a.e.zPr.reportDownloadInfo(5, this.appId);
    AppMethodBeat.o(95219);
  }
  
  public final void azN(String paramString)
  {
    AppMethodBeat.i(95220);
    ae.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(this.Lw))) {
      this.zwg.deleteDeferredDeepLinkMM(paramString);
    }
    AppMethodBeat.o(95220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.b
 * JD-Core Version:    0.7.0.1
 */