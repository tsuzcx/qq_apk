package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.sdk.platformtools.y;

public abstract class b
  extends i
{
  public b(Context paramContext, c paramc, ViewGroup paramViewGroup)
  {
    super(paramContext, paramc, paramViewGroup);
  }
  
  protected final void a(LinearLayout paramLinearLayout)
  {
    Object localObject = (c)this.oFE;
    if (paramLinearLayout == null) {
      return;
    }
    int i = Double.compare(((c)localObject).oCs, ((c)localObject).oCt);
    int m = (int)((c)localObject).oCs;
    int n = (int)((c)localObject).oCt;
    int k;
    if (i == 0)
    {
      k = n;
      i = m;
      if (m == 0)
      {
        k = 1;
        i = 1;
      }
    }
    for (;;)
    {
      y.i("AdLandingBorderedComp", "border width top %d,bottom %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      if (i > 0)
      {
        localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
        localLinearLayout.setBackgroundColor(((c)localObject).guu);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, i);
        localLayoutParams.gravity = 48;
        paramLinearLayout.addView(localLinearLayout, 0, localLayoutParams);
      }
      if (k <= 0) {
        break;
      }
      LinearLayout localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
      localLinearLayout.setBackgroundColor(((c)localObject).guu);
      localObject = new LinearLayout.LayoutParams(-1, k);
      ((LinearLayout.LayoutParams)localObject).gravity = 80;
      paramLinearLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
      return;
      int j = m;
      if (m == 0)
      {
        j = m;
        if (((c)localObject).oCs != 0.0D) {
          j = 1;
        }
      }
      k = n;
      i = j;
      if (n == 0)
      {
        k = n;
        i = j;
        if (((c)localObject).oCt != 0.0D)
        {
          k = 1;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */