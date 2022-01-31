package com.tencent.mm.plugin.sns.ui.c;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements f.a
{
  b$1(b paramb, b.a parama) {}
  
  public final void Op(String paramString)
  {
    y.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramString });
    if ((!bk.H(new String[] { (String)this.pnH.plZ.getTag(), paramString })) && (paramString.equals(h.eS("adId", (String)this.pnH.plZ.getTag()))))
    {
      paramString = c.decodeFile(paramString, null);
      if (paramString != null)
      {
        this.pnH.plZ.setVisibility(0);
        this.pnH.pnQ.setImageBitmap(paramString);
        this.pnH.pnQ.setVisibility(0);
      }
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.b.1
 * JD-Core Version:    0.7.0.1
 */