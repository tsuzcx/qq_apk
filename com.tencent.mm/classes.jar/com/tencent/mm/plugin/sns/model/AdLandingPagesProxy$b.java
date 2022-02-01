package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class AdLandingPagesProxy$b
  implements a.c
{
  private String IK;
  private String appId;
  private boolean oht;
  
  public AdLandingPagesProxy$b(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.IK = paramString2;
    this.appId = paramString1;
    this.oht = paramBoolean;
  }
  
  public final void aoe(String paramString)
  {
    AppMethodBeat.i(95219);
    ad.i("AdLandingPagesProxy", "pkg %s installed", new Object[] { paramString });
    if (this.oht) {
      a.e.wUX.reportDownloadInfo(4, this.appId);
    }
    a.e.wUX.reportDownloadInfo(5, this.appId);
    AppMethodBeat.o(95219);
  }
  
  public final void aof(String paramString)
  {
    AppMethodBeat.i(95220);
    ad.i("AdLandingPagesProxy", "pkg %s removed", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.IK))) {
      this.wDc.deleteDeferredDeepLinkMM(paramString);
    }
    AppMethodBeat.o(95220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.b
 * JD-Core Version:    0.7.0.1
 */