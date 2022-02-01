package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements Runnable
{
  a$1(View paramView1, ActionBar paramActionBar, y paramy, Menu paramMenu, View paramView2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(249133);
    Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView measuredWidth inside is %s, customView : %s .", new Object[] { Integer.valueOf(this.adtG.getMeasuredWidth()), this.adtG });
    Object localObject;
    int i;
    if (this.adtG != this.adtH.getCustomView())
    {
      Log.w("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView is not equals current actionbar's custom, customView width old = %s customView = %s， context : %s.", new Object[] { Integer.valueOf(this.adtG.getMeasuredWidth()), this.adtG, this.adtG.getContext() });
      if (this.adtH.getCustomView() != null) {
        Log.w("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView is not equals current actionbar's custom, customView width new = %s, customView = %s， context : %s.", new Object[] { Integer.valueOf(this.adtH.getCustomView().getMeasuredWidth()), this.adtH.getCustomView(), this.adtH.getCustomView().getContext() });
      }
    }
    else
    {
      localObject = this.adtG.getContext();
      i = a.ms((Context)localObject);
      if (!aw.jkS()) {
        break label369;
      }
      if ((!(localObject instanceof Activity)) || (((Activity)localObject).getWindow() == null) || (((Activity)localObject).getWindow().getDecorView() == null)) {
        break label785;
      }
      i = ((Activity)localObject).getWindow().getDecorView().getMeasuredWidth();
    }
    label772:
    label777:
    label780:
    label785:
    for (;;)
    {
      int j = this.adtG.getMeasuredWidth();
      int k = j;
      int m;
      if (j == 0)
      {
        k = j;
        if ("com.tencent.mm.ui.chatting.ChattingUIFragment".equals(this.adtI.Dy()))
        {
          m = 0;
          k = 0;
          j = m;
          if (this.adtJ != null)
          {
            j = m;
            if (this.adtJ.size() > 0)
            {
              m = 0;
              for (;;)
              {
                j = k;
                if (m >= this.adtJ.size()) {
                  break;
                }
                localObject = this.adtJ.getItem(m);
                j = k;
                if (localObject != null)
                {
                  j = k;
                  if (((MenuItem)localObject).isEnabled())
                  {
                    j = k;
                    if (((MenuItem)localObject).isVisible()) {
                      j = k + 1;
                    }
                  }
                }
                m += 1;
                k = j;
              }
              Log.w("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, actionBar.getCustomView() is null.");
              break;
              label369:
              i = a.ms((Context)localObject);
              continue;
            }
          }
          if (j <= 1) {
            break label780;
          }
        }
      }
      for (k = j;; k = 1)
      {
        m = (int)this.adtG.getContext().getResources().getDimension(a.e.Edge_5A) * k;
        k = i - m;
        Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, menu width is %s, defaultMenuWidth: %s.", new Object[] { Integer.valueOf(j * (int)this.adtG.getContext().getResources().getDimension(a.e.Edge_5A)), Integer.valueOf(m) });
        this.adtK.setVisibility(0);
        if ((this.adtK != null) && (k != 0))
        {
          localObject = this.adtG.findViewById(a.g.actionbar_up_indicator);
          j = (int)this.adtG.getResources().getDimension(a.e.Edge_6A);
          if (localObject == null) {
            break label777;
          }
          j = ((View)localObject).getMeasuredWidth();
        }
        for (;;)
        {
          if (!this.adtL)
          {
            localObject = this.adtG.findViewById(a.g.actionbar_operate_area);
            if (localObject != null)
            {
              localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
              localMarginLayoutParams.leftMargin = 0;
              ((View)localObject).setLayoutParams(localMarginLayoutParams);
            }
            localObject = (ViewGroup.MarginLayoutParams)this.adtK.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
            this.adtK.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(249133);
            return;
          }
          m = this.adtG.getLeft();
          int n = i - k - m;
          int i1 = Math.max(n - m, j);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.adtK.getLayoutParams();
          localMarginLayoutParams.width = (i - (i1 + m) * 2);
          localMarginLayoutParams.leftMargin = i1;
          this.adtK.setLayoutParams(localMarginLayoutParams);
          Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, backViewWidth: %s, menuAreaWidth: %s, leftMargin: %s, titleWidth: %s, activityWidth: %s, customMeasuredWidth: %s, customPadding: %s, customRealWidth: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(localMarginLayoutParams.width), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(this.adtG.getWidth()) });
          if (localObject != null) {
            if (i1 != 0) {
              break label772;
            }
          }
          for (;;)
          {
            this.adtK.setPadding(j, 0, j, 0);
            AppMethodBeat.o(249133);
            return;
            j = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.a.1
 * JD-Core Version:    0.7.0.1
 */