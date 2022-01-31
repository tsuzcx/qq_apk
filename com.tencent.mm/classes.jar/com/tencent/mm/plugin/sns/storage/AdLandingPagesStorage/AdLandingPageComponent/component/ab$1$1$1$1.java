package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class ab$1$1$1$1
  implements Html.ImageGetter
{
  ab$1$1$1$1(ab.1.1.1 param1) {}
  
  public final Drawable getDrawable(String paramString)
  {
    AppMethodBeat.i(37333);
    Object localObject = null;
    String str = h.gy("adId", paramString);
    paramString = localObject;
    int i;
    if (!bo.isNullOrNil(str))
    {
      paramString = localObject;
      if (e.cN(str))
      {
        paramString = Drawable.createFromPath(str);
        if (paramString != null)
        {
          if (paramString.getIntrinsicHeight() == 0) {
            break label129;
          }
          i = paramString.getIntrinsicWidth() * (int)ab.a(this.rya.rxZ.rxY.rxX).textSize / paramString.getIntrinsicHeight();
          if (paramString.getIntrinsicHeight() == 0) {
            break label137;
          }
        }
      }
    }
    label129:
    label137:
    for (int j = (int)ab.a(this.rya.rxZ.rxY.rxX).textSize;; j = paramString.getIntrinsicHeight())
    {
      paramString.setBounds(0, 0, i, j);
      AppMethodBeat.o(37333);
      return paramString;
      i = paramString.getIntrinsicWidth();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */