package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class j$3
  implements f.a
{
  j$3(j paramj, ImageView paramImageView) {}
  
  public final void Op(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.oFQ.setImageBitmap(paramString);
      this.oFQ.setVisibility(0);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bk.j(paramString));
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.3
 * JD-Core Version:    0.7.0.1
 */