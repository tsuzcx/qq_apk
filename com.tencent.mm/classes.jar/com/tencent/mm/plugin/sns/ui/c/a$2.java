package com.tencent.mm.plugin.sns.ui.c;

import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements f.a
{
  a$2(a parama, a.c paramc) {}
  
  public final void Op(String paramString)
  {
    y.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramString });
    if ((!bk.H(new String[] { (String)this.oNY.doU.getTag(i.f.sns_prefer_avatar_url), paramString })) && (paramString.equals(h.eS("adId", (String)this.oNY.doU.getTag(i.f.sns_prefer_avatar_url)))))
    {
      paramString = c.decodeFile(paramString, null);
      if (paramString != null) {
        this.oNY.doU.setImageBitmap(paramString);
      }
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.2
 * JD-Core Version:    0.7.0.1
 */