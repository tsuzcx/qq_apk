package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class a$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a$1(a parama) {}
  
  public final void onGlobalLayout()
  {
    a locala = this.oJR;
    Rect localRect = new Rect();
    locala.oJO.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.bottom;
    int j;
    int k;
    if (i != locala.oJP)
    {
      j = locala.oJO.getRootView().getHeight();
      k = j - i;
      if (k <= j / 4) {
        break label89;
      }
    }
    label89:
    for (locala.oJQ.height = (j - k);; locala.oJQ.height = i)
    {
      locala.oJO.requestLayout();
      locala.oJP = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a.1
 * JD-Core Version:    0.7.0.1
 */