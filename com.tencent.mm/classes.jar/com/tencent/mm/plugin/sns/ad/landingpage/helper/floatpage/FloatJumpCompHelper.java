package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class FloatJumpCompHelper
  extends FloatCompHelperWithLifecycle<com.tencent.mm.plugin.sns.ad.landingpage.component.info.f, com.tencent.mm.plugin.sns.ad.landingpage.component.comp.f>
{
  public int PUq = -1;
  
  public FloatJumpCompHelper(com.tencent.mm.plugin.sns.ad.landingpage.component.info.f paramf, ViewGroup paramViewGroup)
  {
    super(paramf, paramViewGroup);
  }
  
  private int haZ()
  {
    int i = 1;
    AppMethodBeat.i(310854);
    for (;;)
    {
      try
      {
        Context localContext = this.mContext;
        if (localContext != null)
        {
          if (localContext == null) {
            break label177;
          }
          DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
          int j = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          int k = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
          if (k == 0)
          {
            Log.w("SnsAd.FloatJumpCompHelper", "the width is zero!!!");
            if (i != 0)
            {
              i = jM(localContext);
              AppMethodBeat.o(310854);
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
          AppMethodBeat.o(310854);
          return i;
        }
      }
      finally
      {
        Log.e("SnsAd.FloatJumpCompHelper", "the getNavigationBarHeight has something wrong!!, exp=" + localObject.toString());
        AppMethodBeat.o(310854);
        return 0;
      }
      label177:
      i = 0;
    }
  }
  
  private static int jM(Context paramContext)
  {
    AppMethodBeat.i(310864);
    int i;
    try
    {
      i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (i > 0)
      {
        i = Resources.getSystem().getDimensionPixelSize(i);
        AppMethodBeat.o(310864);
        return i;
      }
    }
    finally
    {
      Log.e("SnsAd.FloatJumpCompHelper", "getSysNavigationBarHeight, exp=" + localObject.toString());
      i = a.fromDPToPix(paramContext, 30);
      AppMethodBeat.o(310864);
    }
    return i;
  }
  
  protected final void jf(View paramView)
  {
    AppMethodBeat.i(310874);
    try
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof RelativeLayout.LayoutParams))
      {
        paramView = (RelativeLayout.LayoutParams)paramView;
        paramView.addRule(12);
        paramView.addRule(14);
        paramView.bottomMargin += haZ();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper
 * JD-Core Version:    0.7.0.1
 */