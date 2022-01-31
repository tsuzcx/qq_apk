package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.CountDownLatch;

final class ac$3
  implements f.a
{
  ac$3(ac paramac) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37350);
    try
    {
      ac.b(this.ryf, MMBitmapFactory.decodeFile(paramString));
      ac.a(this.ryf).countDown();
      AppMethodBeat.o(37350);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("AdlandingRadarChartComp", "%s" + bo.l(paramString));
      AppMethodBeat.o(37350);
    }
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37349);
    ac.b(this.ryf, null);
    ac.a(this.ryf).countDown();
    AppMethodBeat.o(37349);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.3
 * JD-Core Version:    0.7.0.1
 */