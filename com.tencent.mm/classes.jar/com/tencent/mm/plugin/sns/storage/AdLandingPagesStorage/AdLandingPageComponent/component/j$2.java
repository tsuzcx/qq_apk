package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMWebView;

final class j$2
  implements Runnable
{
  j$2(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(176275);
    try
    {
      Object localObject = this.zDy.hJc;
      if ((localObject != null) && (((MMWebView)localObject).isAttachedToWindow()))
      {
        localObject = (ViewGroup)((MMWebView)localObject).getChildAt(0);
        if ((localObject != null) && (((ViewGroup)localObject).getChildCount() > 0))
        {
          ((ViewGroup)localObject).setPadding(0, 0, 0, 0);
          localObject = ((ViewGroup)localObject).getChildAt(0);
          if (localObject != null) {
            ((View)localObject).requestLayout();
          }
        }
      }
      AppMethodBeat.o(176275);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.w("AdLandingNewH5Comp", "there is something in wevView fix!");
      AppMethodBeat.o(176275);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.2
 * JD-Core Version:    0.7.0.1
 */