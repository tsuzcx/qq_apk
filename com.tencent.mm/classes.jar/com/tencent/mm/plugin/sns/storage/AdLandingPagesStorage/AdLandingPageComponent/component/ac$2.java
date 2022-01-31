package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.CountDownLatch;

final class ac$2
  implements f.a
{
  ac$2(ac paramac) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37348);
    try
    {
      paramString = MMBitmapFactory.decodeFile(paramString);
      ac.a(this.ryf, paramString);
      ac.a(this.ryf).countDown();
      AppMethodBeat.o(37348);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("AdlandingRadarChartComp", "%s" + bo.l(paramString));
      AppMethodBeat.o(37348);
    }
  }
  
  public final void coe()
  {
    AppMethodBeat.i(37347);
    ac.a(this.ryf, null);
    ac.a(this.ryf).countDown();
    AppMethodBeat.o(37347);
  }
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.2
 * JD-Core Version:    0.7.0.1
 */