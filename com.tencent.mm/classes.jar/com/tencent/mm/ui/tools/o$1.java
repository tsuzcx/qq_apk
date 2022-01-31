package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.am;

final class o$1
  implements Runnable
{
  o$1(View paramView1, Context paramContext, int paramInt, View paramView2, float paramFloat, View paramView3, ScrollView paramScrollView) {}
  
  public final void run()
  {
    AppMethodBeat.i(107751);
    Object localObject2 = (ViewGroup.MarginLayoutParams)this.AwO.getLayoutParams();
    int i = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
    int j = a.fromDPToPix(this.val$context, this.AwP);
    if (this.AwQ.getMeasuredHeight() > 0)
    {
      k = (int)(((WindowManager)this.val$context.getSystemService("window")).getDefaultDisplay().getHeight() - this.AwR);
      localObject1 = new int[2];
      if (this.AwS.getTag(this.AwS.getId()) == null)
      {
        this.AwS.getLocationOnScreen((int[])localObject1);
        this.AwS.setTag(this.AwS.getId(), localObject1);
      }
      while (k >= localObject1[1] + this.AwS.getMeasuredHeight() + this.AwP + this.AwO.getMeasuredHeight())
      {
        j = k - am.hY(this.val$context) - f.di(this.val$context) - this.AwO.getMeasuredHeight();
        if (bo.hl(i, j))
        {
          AppMethodBeat.o(107751);
          return;
          localObject1 = (int[])this.AwS.getTag(this.AwS.getId());
        }
        else
        {
          localObject1 = (ViewGroup)this.AwT.getChildAt(0);
          if (bo.z(this.AwO.getTag(), "no_first"))
          {
            ((ViewGroup)this.AwO.getParent()).removeView(this.AwO);
            ((ViewGroup)localObject1).addView(this.AwO);
          }
          for (;;)
          {
            localObject1 = (ViewGroup.MarginLayoutParams)this.AwO.getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject1).topMargin = j;
            ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = 0;
            this.AwO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.AwO.setVisibility(0);
            this.AwO.setTag("no_first");
            this.AwT.requestLayout();
            AppMethodBeat.o(107751);
            return;
            this.AwT.removeView((View)localObject1);
            localObject2 = new ViewGroup.LayoutParams(-1, -2);
            localRelativeLayout = new RelativeLayout(this.val$context);
            localRelativeLayout.addView((View)localObject1);
            localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.AwT.addView(localRelativeLayout);
            ((ViewGroup)this.AwO.getParent()).removeView(this.AwO);
            localRelativeLayout.addView(this.AwO);
          }
        }
      }
      if (bo.hl(i, j))
      {
        AppMethodBeat.o(107751);
        return;
      }
      ((ViewGroup)this.AwO.getParent()).removeView(this.AwO);
      ((ViewGroup)this.AwS.getParent()).addView(this.AwO);
    }
    while (!bo.hl(i, j))
    {
      int k;
      Object localObject1;
      RelativeLayout localRelativeLayout;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = j;
      this.AwO.setVisibility(0);
      this.AwO.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.AwO.requestLayout();
      AppMethodBeat.o(107751);
      return;
    }
    AppMethodBeat.o(107751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.o.1
 * JD-Core Version:    0.7.0.1
 */