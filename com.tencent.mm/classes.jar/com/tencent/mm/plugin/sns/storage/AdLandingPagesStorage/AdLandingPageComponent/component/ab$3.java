package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class ab$3
  implements f.a
{
  ab$3(ab paramab) {}
  
  public final void Op(String paramString)
  {
    try
    {
      ab.b(this.oIk, MMBitmapFactory.decodeFile(paramString));
      ab.a(this.oIk).countDown();
      return;
    }
    catch (Exception paramString)
    {
      y.e("AdlandingRadarChartComp", "%s" + bk.j(paramString));
    }
  }
  
  public final void bCF()
  {
    ab.b(this.oIk, null);
    ab.a(this.oIk).countDown();
  }
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.3
 * JD-Core Version:    0.7.0.1
 */