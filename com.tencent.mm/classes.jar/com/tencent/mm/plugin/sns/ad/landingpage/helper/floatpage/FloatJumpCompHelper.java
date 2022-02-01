package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.av;

public final class FloatJumpCompHelper
  extends FloatCompHelperWithLifecycle<com.tencent.mm.plugin.sns.ad.landingpage.component.b.d, com.tencent.mm.plugin.sns.ad.landingpage.component.a.d>
{
  public int Duc = -1;
  
  public FloatJumpCompHelper(com.tencent.mm.plugin.sns.ad.landingpage.component.b.d paramd, ViewGroup paramViewGroup)
  {
    super(paramd, paramViewGroup);
  }
  
  private int eXk()
  {
    int i = 1;
    AppMethodBeat.i(202008);
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
            Log.w("SnsAd.FloatJumpCompHelper", "the width is zero!!!");
            if (i != 0)
            {
              i = av.aD(localContext);
              AppMethodBeat.o(202008);
              return i;
            }
          }
          else
          {
            float f = j / k;
            j = Float.compare(f, 1.777778F);
            Log.d("SnsAd.FloatJumpCompHelper", "shouldMindDeviceNavigationBar value is ".concat(String.valueOf(j)));
            if (j > 0) {
              continue;
            }
            i = 0;
            continue;
          }
          i = a.fromDPToPix(localContext, 12);
          AppMethodBeat.o(202008);
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("SnsAd.FloatJumpCompHelper", "the getNavigationBarHeight has something wrong!!");
        AppMethodBeat.o(202008);
        return 0;
      }
      label159:
      i = 0;
    }
  }
  
  protected final void eX(View paramView)
  {
    AppMethodBeat.i(202007);
    try
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof RelativeLayout.LayoutParams))
      {
        paramView = (RelativeLayout.LayoutParams)paramView;
        paramView.addRule(12);
        paramView.addRule(14);
        paramView.bottomMargin += eXk();
      }
      AppMethodBeat.o(202007);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(202007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper
 * JD-Core Version:    0.7.0.1
 */