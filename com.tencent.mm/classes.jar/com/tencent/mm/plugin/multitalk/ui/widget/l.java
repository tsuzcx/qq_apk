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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class l
  implements View.OnClickListener
{
  private LinearLayout AwI;
  private int Grd;
  private int LtY;
  private int Lub;
  private LinearLayout Lvk;
  private LinearLayout Lvl;
  private int Lvm;
  private int Lvn;
  private int Lvo;
  private int Lvp;
  public int Lvq;
  private Context context;
  private int size;
  
  public l(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.Grd = f.Grd;
    this.Lvo = (f.Grd + f.LtR);
    this.Lvp = (f.Grd * 2 + f.LtR);
    this.LtY = (f.Grd * 4);
    this.Lub = f.Lub;
    this.context = paramActivity.getBaseContext();
    int i = com.tencent.mm.cd.a.ms(this.context) - this.LtY * 2;
    this.Lvm = ((i - this.Lvo * 10) / 5);
    this.Lvn = ((i - this.Lvp * 10) / 5);
    this.AwI = ((LinearLayout)paramActivity.findViewById(a.e.avatar_container));
    paramActivity = (RelativeLayout.LayoutParams)this.AwI.getLayoutParams();
    paramActivity.topMargin = (this.Grd * 2);
    paramActivity.bottomMargin = (this.Grd * 2);
    paramActivity.leftMargin = this.LtY;
    paramActivity.rightMargin = this.LtY;
    this.AwI.setLayoutParams(paramActivity);
    this.Lvk = new LinearLayout(this.context);
    this.Lvl = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.Lvk.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.Lvl.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.Lvl);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.AwI.addView(this.Lvk);
    this.AwI.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void abS(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Lvk.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.Lvl.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.Lvm;
      this.Lvl.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.Lvn;
    localLayoutParams.topMargin = (this.Grd * 2);
    localLayoutParams.bottomMargin = (this.Grd * 2);
    this.Lvl.setVisibility(0);
    localLayoutParams1.height = this.Lvn;
    localLayoutParams1.topMargin = (this.Grd * 2);
    localLayoutParams1.bottomMargin = (this.Grd * 2);
    AppMethodBeat.o(114728);
  }
  
  private void abT(int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(114729);
    int i;
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt <= 5)
    {
      paramInt = 0;
      for (;;)
      {
        i = j;
        if (paramInt >= this.Lvk.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.Lvk.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.Lvm;
        localLayoutParams.height = this.Lvm;
        localLayoutParams.rightMargin = this.Lvo;
        localLayoutParams.leftMargin = this.Lvo;
        paramInt += 1;
      }
      while (i < this.Lvl.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.Lvl.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.Lvn;
        localLayoutParams.height = this.Lvn;
        localLayoutParams.rightMargin = this.Lvo;
        localLayoutParams.leftMargin = this.Lvo;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.Lvk.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.Lvk.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.Lvn;
      localLayoutParams.height = this.Lvn;
      localLayoutParams.rightMargin = this.Lvp;
      localLayoutParams.leftMargin = this.Lvp;
      paramInt += 1;
    }
    while (i < this.Lvl.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.Lvl.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.Lvn;
      localLayoutParams.height = this.Lvn;
      localLayoutParams.rightMargin = this.Lvp;
      localLayoutParams.leftMargin = this.Lvp;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void Kf(String paramString)
  {
    int m = 1;
    AppMethodBeat.i(178927);
    if (this.size == 0)
    {
      AppMethodBeat.o(178927);
      return;
    }
    int j = -1;
    int i = 0;
    int k;
    if (i < this.Lvk.getChildCount()) {
      if (this.Lvk.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.Lvl.getChildCount()) {
          if (!this.Lvl.getChildAt(j).getTag().equals(paramString)) {}
        }
      }
      for (i = m;; i = m)
      {
        if (j < 0)
        {
          AppMethodBeat.o(178927);
          return;
          i += 1;
          break;
          j += 1;
          break label63;
        }
        if (i != 0)
        {
          this.Lvl.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.Lvk.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          abS(this.size);
          abT(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.Lvk.removeViewAt(j);
          paramString = this.Lvl.getChildAt(0);
          this.Lvl.removeViewAt(0);
          this.Lvk.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
  
  public final void aNE(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.g(localImageView, paramString);
    if (this.size <= 5) {
      this.Lvk.addView(localImageView);
    }
    for (;;)
    {
      abS(this.size);
      abT(this.size);
      AppMethodBeat.o(114727);
      return;
      this.Lvl.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Lvq += 1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(114730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.l
 * JD-Core Version:    0.7.0.1
 */