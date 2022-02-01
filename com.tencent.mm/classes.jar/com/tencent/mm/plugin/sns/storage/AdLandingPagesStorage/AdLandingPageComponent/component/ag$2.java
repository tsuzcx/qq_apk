package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ag$2
  extends ViewOutlineProvider
{
  ag$2(ag paramag, float paramFloat) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(307065);
    if (paramView != null)
    {
      Log.d("AdLandingPagePureImageComponet", "getOutline, viewW=" + paramView.getWidth() + ", vewH=" + paramView.getHeight());
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.QRn);
    }
    AppMethodBeat.o(307065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag.2
 * JD-Core Version:    0.7.0.1
 */