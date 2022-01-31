package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class m$1
  implements f.a
{
  m$1(m paramm) {}
  
  public final void Op(String paramString)
  {
    m localm;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      localm = this.oFV;
      if (paramString == null)
      {
        y.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
        return;
      }
      if (localm.oFU == null)
      {
        y.e("AdLandingPageCircleImgComp", "when set image the img is null!");
        return;
      }
    }
    catch (Exception paramString)
    {
      y.e("AdLandingPageCircleImgComp", "%s" + bk.j(paramString));
      return;
    }
    if (paramString.getWidth() == 0)
    {
      y.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
      return;
    }
    localm.oFU.setImageBitmap(paramString);
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.1
 * JD-Core Version:    0.7.0.1
 */