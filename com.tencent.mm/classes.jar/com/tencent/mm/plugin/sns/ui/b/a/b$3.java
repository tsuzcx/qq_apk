package com.tencent.mm.plugin.sns.ui.b.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;

final class b$3
  implements f.a
{
  b$3(b paramb) {}
  
  public final void Op(String paramString)
  {
    if (!bk.bl(paramString))
    {
      paramString = c.decodeFile(paramString, null);
      if (paramString != null)
      {
        this.pmc.plZ.setVisibility(0);
        ImageView localImageView = (ImageView)this.pmc.plZ.findViewById(i.f.sns_ad_card_header_avatar);
        localImageView.setImageBitmap(paramString);
        localImageView.setVisibility(0);
      }
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.b.3
 * JD-Core Version:    0.7.0.1
 */