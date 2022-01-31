package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class w$1
  implements f.a
{
  w$1(w paramw) {}
  
  public final void Op(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.oHJ.K(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("AdLandingPagePureImageComponet", "%s" + bk.j(paramString));
    }
  }
  
  public final void bCF()
  {
    this.oHJ.frw.setVisibility(8);
  }
  
  public final void bFl()
  {
    this.oHJ.startLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w.1
 * JD-Core Version:    0.7.0.1
 */