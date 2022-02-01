package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.as;

public final class FloatJumpCompHelper
  extends FloatCompHelperWithLifecycle<com.tencent.mm.plugin.sns.ad.landingpage.component.b.a, com.tencent.mm.plugin.sns.ad.landingpage.component.a.a>
{
  public FloatJumpCompHelper(com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    super(parama, paramViewGroup);
  }
  
  private int dRt()
  {
    int i = 1;
    AppMethodBeat.i(197576);
    try
    {
      Context localContext = this.mContext;
      if (localContext != null)
      {
        int j;
        int k;
        if (localContext != null)
        {
          DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
          j = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          k = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          if (k == 0) {
            ad.w("SnsAd.FloatJumpCompHelper", "the width is zero!!!");
          }
        }
        while (i != 0)
        {
          i = as.ej(localContext);
          AppMethodBeat.o(197576);
          return i;
          float f = j / k;
          j = Float.compare(f, 1.777778F);
          ad.d("SnsAd.FloatJumpCompHelper", "shouldMindDeviceNavigationBar value is ".concat(String.valueOf(j)));
          if (j <= 0)
          {
            i = 0;
            continue;
            i = 0;
          }
        }
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      ad.e("SnsAd.FloatJumpCompHelper", "the getNavigationBarHeight has something wrong!!");
      AppMethodBeat.o(197576);
    }
  }
  
  protected final void eL(View paramView)
  {
    AppMethodBeat.i(197575);
    try
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof RelativeLayout.LayoutParams))
      {
        paramView = (RelativeLayout.LayoutParams)paramView;
        paramView.addRule(12);
        paramView.addRule(14);
        paramView.bottomMargin += dRt();
      }
      AppMethodBeat.o(197575);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(197575);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper
 * JD-Core Version:    0.7.0.1
 */