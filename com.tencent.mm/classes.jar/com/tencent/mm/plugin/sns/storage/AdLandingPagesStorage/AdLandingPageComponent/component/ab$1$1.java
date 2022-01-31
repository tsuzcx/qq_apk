package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class ab$1$1
  implements Html.ImageGetter
{
  ab$1$1(ab.1 param1) {}
  
  public final Drawable getDrawable(String paramString)
  {
    AppMethodBeat.i(37336);
    Object localObject = null;
    String str = h.gy("adId", paramString);
    int i;
    int j;
    if ((!bo.isNullOrNil(str)) && (e.cN(str)))
    {
      paramString = Drawable.createFromPath(str);
      if (paramString == null) {
        break label149;
      }
      if (paramString.getIntrinsicHeight() != 0)
      {
        i = paramString.getIntrinsicWidth() * (int)ab.a(this.rxY.rxX).textSize / paramString.getIntrinsicHeight();
        if (paramString.getIntrinsicHeight() == 0) {
          break label119;
        }
        j = (int)ab.a(this.rxY.rxX).textSize;
        label96:
        paramString.setBounds(0, 0, i, j);
      }
    }
    label149:
    for (;;)
    {
      AppMethodBeat.o(37336);
      return paramString;
      i = paramString.getIntrinsicWidth();
      break;
      label119:
      j = paramString.getIntrinsicHeight();
      break label96;
      h.c("adId", paramString, false, 0, new ab.1.1.1(this));
      paramString = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.1.1
 * JD-Core Version:    0.7.0.1
 */