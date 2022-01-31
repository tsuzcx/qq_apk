package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class AdLandingPagesProxy$c
  implements b.b
{
  private String cBO;
  
  public AdLandingPagesProxy$c(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString)
  {
    this.cBO = paramString;
  }
  
  public final void ZU(String paramString) {}
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35921);
    if ((!bo.Q(new String[] { paramString, this.cBO })) && (paramString.equals(this.cBO)))
    {
      this.rcM.CLIENT_CALL("onImgDownloadCallback", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      ag.cpa().b(this);
    }
    AppMethodBeat.o(35921);
  }
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.c
 * JD-Core Version:    0.7.0.1
 */