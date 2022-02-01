package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.as;

public final class FloatJumpCompHelper
  extends FloatCompHelperWithLifecycle<com.tencent.mm.plugin.sns.ad.landingpage.component.b.a, com.tencent.mm.plugin.sns.ad.landingpage.component.a.a>
{
  public int znQ = -1;
  
  public FloatJumpCompHelper(com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    super(parama, paramViewGroup);
  }
  
  private int dUR()
  {
    int i = 1;
    AppMethodBeat.i(219037);
    for (;;)
    {
      try
      {
        Context localContext = this.mContext;
        if (localContext != null)
        {
          if (localContext == null) {
            break label159;
          }
          DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
          int j = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          int k = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          if (k == 0)
          {
            ae.w("SnsAd.FloatJumpCompHelper", "the width is zero!!!");
            if (i != 0)
            {
              i = as.en(localContext);
              AppMethodBeat.o(219037);
              return i;
            }
          }
          else
          {
            float f = j / k;
            j = Float.compare(f, 1.777778F);
            ae.d("SnsAd.FloatJumpCompHelper", "shouldMindDeviceNavigationBar value is ".concat(String.valueOf(j)));
            if (j > 0) {
              continue;
            }
            i = 0;
            continue;
          }
          i = com.tencent.mm.cb.a.fromDPToPix(localContext, 12);
          AppMethodBeat.o(219037);
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        ae.e("SnsAd.FloatJumpCompHelper", "the getNavigationBarHeight has something wrong!!");
        AppMethodBeat.o(219037);
        return 0;
      }
      label159:
      i = 0;
    }
  }
  
  protected final void eL(View paramView)
  {
    AppMethodBeat.i(219036);
    try
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof RelativeLayout.LayoutParams))
      {
        paramView = (RelativeLayout.LayoutParams)paramView;
        paramView.addRule(12);
        paramView.addRule(14);
        paramView.bottomMargin += dUR();
      }
      AppMethodBeat.o(219036);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(219036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper
 * JD-Core Version:    0.7.0.1
 */