package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements f.a
{
  f$1(f paramf) {}
  
  public final void Op(String paramString)
  {
    f localf;
    try
    {
      this.oFy.stopLoading();
      paramString = BitmapFactory.decodeFile(paramString);
      localf = this.oFy;
      if (paramString == null)
      {
        y.e("AdLandingImageComp", "when set image the bmp is null!");
        return;
      }
      if (localf.bNu == null)
      {
        y.e("AdLandingImageComp", "when set image the imageView is null!");
        return;
      }
    }
    catch (Exception paramString)
    {
      y.e("AdLandingImageComp", "%s" + bk.j(paramString));
      return;
    }
    if (paramString.getWidth() == 0)
    {
      y.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
      return;
    }
    localf.bNu.setImageBitmap(paramString);
    localf.frw.setVisibility(8);
  }
  
  public final void bCF()
  {
    this.oFy.stopLoading();
  }
  
  public final void bFl()
  {
    this.oFy.startLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f.1
 * JD-Core Version:    0.7.0.1
 */