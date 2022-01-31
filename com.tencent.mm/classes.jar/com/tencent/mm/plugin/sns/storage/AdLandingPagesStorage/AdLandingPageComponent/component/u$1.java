package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class u$1
  implements f.a
{
  u$1(u paramu) {}
  
  public final void Op(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.oHE.setImage(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bk.j(paramString));
    }
  }
  
  public final void bCF()
  {
    this.oHE.frw.setVisibility(8);
  }
  
  public final void bFl()
  {
    this.oHE.startLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.1
 * JD-Core Version:    0.7.0.1
 */