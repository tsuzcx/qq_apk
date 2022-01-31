package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.report.service.h;

final class AdLandingPagesProxy$d
  implements h.a
{
  private String cBO;
  
  public AdLandingPagesProxy$d(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString)
  {
    this.cBO = paramString;
  }
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(35925);
    if (paramString.equals(this.cBO))
    {
      h.qsU.cT(955, 30);
      this.rcM.CLIENT_CALL("onCdnVideoFinish", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(35925);
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35922);
    if (paramString.equals(this.cBO))
    {
      h.qsU.cT(955, 26);
      this.rcM.CLIENT_CALL("onCdnVideoMoovReady", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(35922);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35923);
    if (paramString.equals(this.cBO))
    {
      h.qsU.cT(955, 28);
      this.rcM.CLIENT_CALL("onCdnVideoDataAvailable", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(35923);
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35924);
    if (paramString.equals(this.cBO)) {
      this.rcM.CLIENT_CALL("onCdnVideoProgress", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(35924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.d
 * JD-Core Version:    0.7.0.1
 */