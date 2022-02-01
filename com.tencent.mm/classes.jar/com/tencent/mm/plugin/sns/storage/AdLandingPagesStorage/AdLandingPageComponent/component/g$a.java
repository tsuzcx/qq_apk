package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.ae;

public final class g$a
{
  i zUr;
  
  public g$a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, long paramLong2, int paramInt4)
  {
    AppMethodBeat.i(219414);
    this.zUr = new i();
    try
    {
      i locali = new i();
      locali.h("cid", paramString);
      locali.S("exposureCount", paramInt3);
      locali.u("stayTime", paramLong2);
      locali.S("clickCount", paramInt4);
      this.zUr.S("exposureCount", paramInt1);
      this.zUr.u("stayTime", paramLong1);
      this.zUr.S("clickCount", paramInt2);
      this.zUr.h("btnInfo", locali);
      AppMethodBeat.o(219414);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("AdLandingFullScreenFloatBarComp", paramString.toString());
      AppMethodBeat.o(219414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g.a
 * JD-Core Version:    0.7.0.1
 */