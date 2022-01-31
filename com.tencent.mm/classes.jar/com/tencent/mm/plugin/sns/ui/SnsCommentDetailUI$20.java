package com.tencent.mm.plugin.sns.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class SnsCommentDetailUI$20
  implements f.a
{
  SnsCommentDetailUI$20(SnsCommentDetailUI paramSnsCommentDetailUI, ImageView paramImageView) {}
  
  public final void Op(String paramString)
  {
    y.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramString });
    if ((!bk.H(new String[] { (String)this.oWY.getTag(i.f.sns_prefer_avatar_url), paramString })) && (paramString.equals(h.eS("adId", (String)this.oWY.getTag(i.f.sns_prefer_avatar_url)))))
    {
      paramString = c.decodeFile(paramString, null);
      if (paramString != null) {
        this.oWY.setImageBitmap(paramString);
      }
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.20
 * JD-Core Version:    0.7.0.1
 */