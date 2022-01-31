package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a
  extends h
{
  public a(Context paramContext, c paramc, ViewGroup paramViewGroup)
  {
    super(paramContext, paramc, paramViewGroup);
  }
  
  protected final void a(LinearLayout paramLinearLayout)
  {
    Object localObject = (c)this.rve;
    if (paramLinearLayout == null) {
      return;
    }
    int i = Double.compare(((c)localObject).rrR, ((c)localObject).rrS);
    int m = (int)((c)localObject).rrR;
    int n = (int)((c)localObject).rrS;
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
      ab.i("AdLandingBorderedComp", "border width top %d,bottom %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      if (i > 0)
      {
        localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
        localLinearLayout.setBackgroundColor(((c)localObject).borderColor);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, i);
        localLayoutParams.gravity = 48;
        paramLinearLayout.addView(localLinearLayout, 0, localLayoutParams);
      }
      if (k <= 0) {
        break;
      }
      LinearLayout localLinearLayout = new LinearLayout(paramLinearLayout.getContext());
      localLinearLayout.setBackgroundColor(((c)localObject).borderColor);
      localObject = new LinearLayout.LayoutParams(-1, k);
      ((LinearLayout.LayoutParams)localObject).gravity = 80;
      paramLinearLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
      return;
      int j = m;
      if (m == 0)
      {
        j = m;
        if (((c)localObject).rrR != 0.0D) {
          j = 1;
        }
      }
      k = n;
      i = j;
      if (n == 0)
      {
        k = n;
        i = j;
        if (((c)localObject).rrS != 0.0D)
        {
          k = 1;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a
 * JD-Core Version:    0.7.0.1
 */