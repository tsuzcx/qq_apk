package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;

public final class q
{
  public static void a(Context paramContext, ScrollView paramScrollView, View paramView1, View paramView2, View paramView3, float paramFloat)
  {
    AppMethodBeat.i(143219);
    a(paramContext, paramScrollView, paramView1, paramView2, paramView3, 24, paramFloat, false);
    AppMethodBeat.o(143219);
  }
  
  public static void a(Context paramContext, ScrollView paramScrollView, View paramView1, View paramView2, View paramView3, int paramInt)
  {
    AppMethodBeat.i(143218);
    a(paramContext, paramScrollView, paramView1, paramView2, paramView3, paramInt, 0.0F, false);
    AppMethodBeat.o(143218);
  }
  
  public static void a(final Context paramContext, final ScrollView paramScrollView, View paramView1, final View paramView2, final View paramView3, final int paramInt, final float paramFloat, final boolean paramBoolean)
  {
    AppMethodBeat.i(143220);
    if (paramScrollView == null)
    {
      AppMethodBeat.o(143220);
      return;
    }
    paramScrollView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143217);
        if ((this.Fxi == null) || (paramView3 == null))
        {
          AppMethodBeat.o(143217);
          return;
        }
        Object localObject2 = (ViewGroup.MarginLayoutParams)paramView3.getLayoutParams();
        int j = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
        int i = a.fromDPToPix(paramContext, paramInt);
        if ((this.Fxi.getMeasuredHeight() > 0) && (paramView2 != null))
        {
          k = (int)(ar.au(paramContext).y - ax.aB(paramContext) - paramFloat);
          Log.d("MicroMsg.ScrollViewHelper", "setViewToScrollViewBottom screenHeight:%s", new Object[] { Integer.valueOf(k) });
          localObject1 = new int[2];
          if (paramView2.getTag(paramView2.getId()) == null)
          {
            paramView2.getLocationOnScreen((int[])localObject1);
            paramView2.setTag(paramView2.getId(), localObject1);
            if ((paramScrollView == null) || (k < localObject1[1] + paramView2.getMeasuredHeight() + i + paramView3.getMeasuredHeight())) {
              break label482;
            }
            m = ax.at(paramContext);
            if (!paramBoolean) {
              break label268;
            }
          }
          label268:
          for (i = 0;; i = h.ew(paramContext))
          {
            i = k - m - i - paramView3.getMeasuredHeight();
            if (!Util.isEqual(j, i)) {
              break label279;
            }
            AppMethodBeat.o(143217);
            return;
            localObject1 = (int[])paramView2.getTag(paramView2.getId());
            break;
          }
          label279:
          localObject1 = (ViewGroup)paramScrollView.getChildAt(0);
          if (Util.isEqual(paramView3.getTag(), "no_first"))
          {
            ((ViewGroup)paramView3.getParent()).removeView(paramView3);
            ((ViewGroup)localObject1).addView(paramView3);
          }
          for (;;)
          {
            localObject1 = (ViewGroup.MarginLayoutParams)paramView3.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject1).topMargin = i;
            ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = 0;
            paramView3.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramView3.setVisibility(0);
            paramView3.setTag("no_first");
            paramScrollView.requestLayout();
            AppMethodBeat.o(143217);
            return;
            paramScrollView.removeView((View)localObject1);
            localObject2 = new ViewGroup.LayoutParams(-1, -2);
            localRelativeLayout = new RelativeLayout(paramContext);
            localRelativeLayout.addView((View)localObject1);
            localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramScrollView.addView(localRelativeLayout);
            ((ViewGroup)paramView3.getParent()).removeView(paramView3);
            localRelativeLayout.addView(paramView3);
          }
          label482:
          if (Util.isEqual(j, i))
          {
            AppMethodBeat.o(143217);
            return;
          }
          ((ViewGroup)paramView3.getParent()).removeView(paramView3);
          ((ViewGroup)paramView2.getParent()).addView(paramView3);
        }
        while (!Util.isEqual(j, i))
        {
          int k;
          Object localObject1;
          int m;
          RelativeLayout localRelativeLayout;
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = i;
          paramView3.setVisibility(0);
          paramView3.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramView3.requestLayout();
          AppMethodBeat.o(143217);
          return;
        }
        AppMethodBeat.o(143217);
      }
    });
    AppMethodBeat.o(143220);
  }
  
  public static void a(final Context paramContext, final NestedScrollView paramNestedScrollView, View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(195569);
    if (paramNestedScrollView == null)
    {
      AppMethodBeat.o(195569);
      return;
    }
    paramNestedScrollView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208548);
        if ((this.Fxi == null) || (paramView3 == null))
        {
          AppMethodBeat.o(208548);
          return;
        }
        Object localObject2 = (ViewGroup.MarginLayoutParams)paramView3.getLayoutParams();
        int j = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
        int i = a.fromDPToPix(paramContext, this.XTS);
        Object localObject1;
        if ((this.Fxi.getMeasuredHeight() > 0) && (paramView2 != null))
        {
          int k = (int)(((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight() - this.XTU);
          Log.d("MicroMsg.ScrollViewHelper", "setViewToScrollViewBottom screenHeight:%s", new Object[] { Integer.valueOf(k) });
          localObject1 = new int[2];
          int m;
          if (paramView2.getTag(paramView2.getId()) == null)
          {
            paramView2.getLocationOnScreen((int[])localObject1);
            paramView2.setTag(paramView2.getId(), localObject1);
            if ((paramNestedScrollView == null) || (k < localObject1[1] + paramView2.getMeasuredHeight() + i + paramView3.getMeasuredHeight())) {
              break label484;
            }
            m = ax.at(paramContext);
            if (!this.XTW) {
              break label270;
            }
          }
          label270:
          for (i = 0;; i = h.ew(paramContext))
          {
            i = k - m - i - paramView3.getMeasuredHeight();
            if (!Util.isEqual(j, i)) {
              break label281;
            }
            AppMethodBeat.o(208548);
            return;
            localObject1 = (int[])paramView2.getTag(paramView2.getId());
            break;
          }
          label281:
          localObject1 = (ViewGroup)paramNestedScrollView.getChildAt(0);
          if (Util.isEqual(paramView3.getTag(), "no_first"))
          {
            ((ViewGroup)paramView3.getParent()).removeView(paramView3);
            ((ViewGroup)localObject1).addView(paramView3);
          }
          for (;;)
          {
            localObject1 = (ViewGroup.MarginLayoutParams)paramView3.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject1).topMargin = i;
            ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = 0;
            paramView3.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramView3.setVisibility(0);
            paramView3.setTag("no_first");
            paramNestedScrollView.requestLayout();
            AppMethodBeat.o(208548);
            return;
            paramNestedScrollView.removeView((View)localObject1);
            localObject2 = new ViewGroup.LayoutParams(-1, -2);
            localObject3 = new RelativeLayout(paramContext);
            ((RelativeLayout)localObject3).addView((View)localObject1);
            ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramNestedScrollView.addView((View)localObject3);
            ((ViewGroup)paramView3.getParent()).removeView(paramView3);
            ((RelativeLayout)localObject3).addView(paramView3);
          }
          label484:
          if (Util.isEqual(j, i))
          {
            AppMethodBeat.o(208548);
            return;
          }
          Object localObject3 = paramView3.getParent();
          ((ViewGroup)paramView3.getParent()).removeView(paramView3);
          ((ViewGroup)paramView2.getParent()).addView(paramView3);
          localObject1 = localObject2;
          if ((paramView2.getParent() instanceof LinearLayout))
          {
            localObject1 = localObject2;
            if ((localObject3 instanceof RelativeLayout)) {
              localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
            }
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = i;
        }
        for (;;)
        {
          paramView3.setVisibility(0);
          paramView3.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramView3.requestLayout();
          AppMethodBeat.o(208548);
          return;
          if (Util.isEqual(j, i))
          {
            AppMethodBeat.o(208548);
            return;
          }
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = i;
          localObject1 = localObject2;
        }
      }
    });
    AppMethodBeat.o(195569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */