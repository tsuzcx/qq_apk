package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d
  implements View.OnClickListener
{
  private Context context;
  private View mYK;
  private LinearLayout oVF;
  public LinearLayout oVG;
  public LinearLayout oVH;
  private int oVI;
  private int oVJ;
  private int oVK;
  private int oVL;
  private int oVM;
  public int oVN;
  private int oVn;
  private int oVt;
  public int size;
  
  public d(Activity paramActivity)
  {
    AppMethodBeat.i(54192);
    this.size = 0;
    this.oVn = b.oVn;
    this.oVK = (b.oVn + b.oVm);
    this.oVL = (b.oVn * 2 + b.oVm);
    this.oVM = (b.oVn * 4);
    this.oVt = b.oVt;
    this.context = paramActivity.getBaseContext();
    int i = a.gw(this.context) - this.oVM * 2;
    this.oVI = ((i - this.oVK * 10) / 5);
    this.oVJ = ((i - this.oVL * 10) / 5);
    i = this.oVJ;
    int j = this.oVn;
    this.mYK = paramActivity.findViewById(2131820910);
    this.mYK.getLayoutParams().height = (i * 2 + j * 12);
    this.oVF = ((LinearLayout)paramActivity.findViewById(2131826440));
    paramActivity = (RelativeLayout.LayoutParams)this.oVF.getLayoutParams();
    paramActivity.topMargin = (this.oVn * 2);
    paramActivity.bottomMargin = (this.oVn * 2);
    paramActivity.leftMargin = this.oVM;
    paramActivity.rightMargin = this.oVM;
    this.oVF.setLayoutParams(paramActivity);
    this.oVG = new LinearLayout(this.context);
    this.oVH = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.oVG.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.oVH.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.oVH);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.oVF.addView(this.oVG);
    this.oVF.addView(localRelativeLayout);
    AppMethodBeat.o(54192);
  }
  
  public final void UC(String paramString)
  {
    AppMethodBeat.i(54194);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.oVG.addView(localImageView);
    }
    for (;;)
    {
      zJ(this.size);
      zK(this.size);
      AppMethodBeat.o(54194);
      return;
      this.oVH.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    this.oVN += 1;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(54193);
    if (paramBoolean)
    {
      this.mYK.setVisibility(0);
      AppMethodBeat.o(54193);
      return;
    }
    this.mYK.setVisibility(8);
    AppMethodBeat.o(54193);
  }
  
  public final void zJ(int paramInt)
  {
    AppMethodBeat.i(54195);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.oVG.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.oVH.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.oVI;
      this.oVH.setVisibility(8);
      AppMethodBeat.o(54195);
      return;
    }
    localLayoutParams.height = this.oVJ;
    localLayoutParams.topMargin = (this.oVn * 2);
    localLayoutParams.bottomMargin = (this.oVn * 2);
    this.oVH.setVisibility(0);
    localLayoutParams1.height = this.oVJ;
    localLayoutParams1.topMargin = (this.oVn * 2);
    localLayoutParams1.bottomMargin = (this.oVn * 2);
    AppMethodBeat.o(54195);
  }
  
  public final void zK(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(54196);
    int i;
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt <= 5)
    {
      paramInt = 0;
      for (;;)
      {
        i = j;
        if (paramInt >= this.oVG.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.oVG.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.oVI;
        localLayoutParams.height = this.oVI;
        localLayoutParams.rightMargin = this.oVK;
        localLayoutParams.leftMargin = this.oVK;
        paramInt += 1;
      }
      while (i < this.oVH.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.oVH.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.oVJ;
        localLayoutParams.height = this.oVJ;
        localLayoutParams.rightMargin = this.oVK;
        localLayoutParams.leftMargin = this.oVK;
        i += 1;
      }
      AppMethodBeat.o(54196);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.oVG.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.oVG.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.oVJ;
      localLayoutParams.height = this.oVJ;
      localLayoutParams.rightMargin = this.oVL;
      localLayoutParams.leftMargin = this.oVL;
      paramInt += 1;
    }
    while (i < this.oVH.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.oVH.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.oVJ;
      localLayoutParams.height = this.oVJ;
      localLayoutParams.rightMargin = this.oVL;
      localLayoutParams.leftMargin = this.oVL;
      i += 1;
    }
    AppMethodBeat.o(54196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */