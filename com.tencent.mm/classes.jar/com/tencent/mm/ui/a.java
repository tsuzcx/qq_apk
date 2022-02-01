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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;

public final class a
{
  public static void a(final ActionBar paramActionBar, final boolean paramBoolean, final w paramw, final Menu paramMenu)
  {
    AppMethodBeat.i(218544);
    Object localObject = i.YyX;
    if (i.a(b.a.Yyu, 1) != 1)
    {
      AppMethodBeat.o(218544);
      return;
    }
    localObject = paramActionBar.getCustomView();
    if (localObject == null)
    {
      AppMethodBeat.o(218544);
      return;
    }
    final View localView = ((View)localObject).findViewById(a.g.actionbar_center_layout);
    if (localView == null)
    {
      Log.d("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, centerLayout is null");
      AppMethodBeat.o(218544);
      return;
    }
    Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView measuredWidth outside is %s, isActionbarCenterLayoutMode is %s, customView: %s， context: %s.", new Object[] { Integer.valueOf(((View)localObject).getMeasuredWidth()), Boolean.valueOf(paramBoolean), localObject, ((View)localObject).getContext() });
    ((View)localObject).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198944);
        Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView measuredWidth inside is %s, customView : %s .", new Object[] { Integer.valueOf(this.VPB.getMeasuredWidth()), this.VPB });
        Object localObject;
        int i;
        if (this.VPB != paramActionBar.getCustomView())
        {
          Log.w("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView is not equals current actionbar's custom, customView width old = %s customView = %s， context : %s.", new Object[] { Integer.valueOf(this.VPB.getMeasuredWidth()), this.VPB, this.VPB.getContext() });
          if (paramActionBar.getCustomView() != null) {
            Log.w("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView is not equals current actionbar's custom, customView width new = %s, customView = %s， context : %s.", new Object[] { Integer.valueOf(paramActionBar.getCustomView().getMeasuredWidth()), paramActionBar.getCustomView(), paramActionBar.getCustomView().getContext() });
          }
        }
        else
        {
          localObject = this.VPB.getContext();
          i = com.tencent.mm.ci.a.kr((Context)localObject);
          if (!ar.hIH()) {
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
          int j = this.VPB.getMeasuredWidth();
          int k = j;
          int m;
          if (j == 0)
          {
            k = j;
            if ("com.tencent.mm.ui.chatting.ChattingUIFragment".equals(paramw.bpE()))
            {
              m = 0;
              k = 0;
              j = m;
              if (paramMenu != null)
              {
                j = m;
                if (paramMenu.size() > 0)
                {
                  m = 0;
                  for (;;)
                  {
                    j = k;
                    if (m >= paramMenu.size()) {
                      break;
                    }
                    localObject = paramMenu.getItem(m);
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
                  i = com.tencent.mm.ci.a.kr((Context)localObject);
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
            m = (int)this.VPB.getContext().getResources().getDimension(a.e.Edge_5A) * k;
            k = i - m;
            Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, menu width is %s, defaultMenuWidth: %s.", new Object[] { Integer.valueOf(j * (int)this.VPB.getContext().getResources().getDimension(a.e.Edge_5A)), Integer.valueOf(m) });
            localView.setVisibility(0);
            if ((localView != null) && (k != 0))
            {
              localObject = this.VPB.findViewById(a.g.actionbar_up_indicator);
              j = (int)this.VPB.getResources().getDimension(a.e.Edge_6A);
              if (localObject == null) {
                break label777;
              }
              j = ((View)localObject).getMeasuredWidth();
            }
            for (;;)
            {
              if (!paramBoolean)
              {
                localObject = this.VPB.findViewById(a.g.actionbar_operate_area);
                if (localObject != null)
                {
                  localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
                  localMarginLayoutParams.leftMargin = 0;
                  ((View)localObject).setLayoutParams(localMarginLayoutParams);
                }
                localObject = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
                ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
                localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
                AppMethodBeat.o(198944);
                return;
              }
              m = this.VPB.getLeft();
              int n = i - k - m;
              int i1 = Math.max(n - m, j);
              ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
              localMarginLayoutParams.width = (i - (i1 + m) * 2);
              localMarginLayoutParams.leftMargin = i1;
              localView.setLayoutParams(localMarginLayoutParams);
              Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, backViewWidth: %s, menuAreaWidth: %s, leftMargin: %s, titleWidth: %s, activityWidth: %s, customMeasuredWidth: %s, customPadding: %s, customRealWidth: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(localMarginLayoutParams.width), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(this.VPB.getWidth()) });
              if (localObject != null) {
                if (i1 != 0) {
                  break label772;
                }
              }
              for (;;)
              {
                localView.setPadding(j, 0, j, 0);
                AppMethodBeat.o(198944);
                return;
                j = 0;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(218544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */