package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.e;

final class aa$1$1
  implements Html.ImageGetter
{
  aa$1$1(aa.1 param1) {}
  
  public final Drawable getDrawable(String paramString)
  {
    String str = h.eS("adId", paramString);
    if ((!bk.bl(str)) && (e.bK(str)))
    {
      paramString = Drawable.createFromPath(str);
      if (paramString != null)
      {
        int i;
        if (paramString.getIntrinsicHeight() != 0)
        {
          i = paramString.getIntrinsicWidth() * (int)aa.a(this.oId.oIc).dOB / paramString.getIntrinsicHeight();
          if (paramString.getIntrinsicHeight() == 0) {
            break label106;
          }
        }
        label106:
        for (int j = (int)aa.a(this.oId.oIc).dOB;; j = paramString.getIntrinsicHeight())
        {
          paramString.setBounds(0, 0, i, j);
          return paramString;
          i = paramString.getIntrinsicWidth();
          break;
        }
      }
    }
    else
    {
      h.c("adId", paramString, false, 0, new aa.1.1.1(this));
      return null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.1.1
 * JD-Core Version:    0.7.0.1
 */