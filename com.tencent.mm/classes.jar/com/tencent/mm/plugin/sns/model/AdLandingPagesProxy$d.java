package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.report.service.g;

final class AdLandingPagesProxy$d
  implements h.a
{
  private String mediaId;
  
  public AdLandingPagesProxy$d(AdLandingPagesProxy paramAdLandingPagesProxy, String paramString)
  {
    this.mediaId = paramString;
  }
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(95225);
    if (paramString.equals(this.mediaId))
    {
      g.yhR.dD(955, 30);
      this.zfr.CLIENT_CALL("onCdnVideoFinish", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(95225);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(197823);
    if (paramString1.equals(this.mediaId))
    {
      g.yhR.dD(955, 26);
      this.zfr.CLIENT_CALL("onCdnVideoMoovReady", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 });
    }
    AppMethodBeat.o(197823);
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95224);
    if (paramString.equals(this.mediaId)) {
      this.zfr.CLIENT_CALL("onCdnVideoProgress", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(95224);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95223);
    if (paramString.equals(this.mediaId))
    {
      g.yhR.dD(955, 28);
      this.zfr.CLIENT_CALL("onCdnVideoDataAvailable", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(95223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.d
 * JD-Core Version:    0.7.0.1
 */