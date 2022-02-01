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
  private int AOJ;
  private int FxM;
  private int FxP;
  private LinearLayout Fzc;
  private LinearLayout Fzd;
  private LinearLayout Fze;
  private int Fzf;
  private int Fzg;
  private int Fzh;
  private int Fzi;
  public int Fzj;
  private Context context;
  private int size;
  
  public l(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.AOJ = f.AOJ;
    this.Fzh = (f.AOJ + f.FxF);
    this.Fzi = (f.AOJ * 2 + f.FxF);
    this.FxM = (f.AOJ * 4);
    this.FxP = f.FxP;
    this.context = paramActivity.getBaseContext();
    int i = com.tencent.mm.ci.a.kr(this.context) - this.FxM * 2;
    this.Fzf = ((i - this.Fzh * 10) / 5);
    this.Fzg = ((i - this.Fzi * 10) / 5);
    this.Fzc = ((LinearLayout)paramActivity.findViewById(a.e.avatar_container));
    paramActivity = (RelativeLayout.LayoutParams)this.Fzc.getLayoutParams();
    paramActivity.topMargin = (this.AOJ * 2);
    paramActivity.bottomMargin = (this.AOJ * 2);
    paramActivity.leftMargin = this.FxM;
    paramActivity.rightMargin = this.FxM;
    this.Fzc.setLayoutParams(paramActivity);
    this.Fzd = new LinearLayout(this.context);
    this.Fze = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.Fzd.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.Fze.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.Fze);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.Fzc.addView(this.Fzd);
    this.Fzc.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void XI(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Fzd.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.Fze.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.Fzf;
      this.Fze.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.Fzg;
    localLayoutParams.topMargin = (this.AOJ * 2);
    localLayoutParams.bottomMargin = (this.AOJ * 2);
    this.Fze.setVisibility(0);
    localLayoutParams1.height = this.Fzg;
    localLayoutParams1.topMargin = (this.AOJ * 2);
    localLayoutParams1.bottomMargin = (this.AOJ * 2);
    AppMethodBeat.o(114728);
  }
  
  private void XJ(int paramInt)
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
        if (paramInt >= this.Fzd.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.Fzd.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.Fzf;
        localLayoutParams.height = this.Fzf;
        localLayoutParams.rightMargin = this.Fzh;
        localLayoutParams.leftMargin = this.Fzh;
        paramInt += 1;
      }
      while (i < this.Fze.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.Fze.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.Fzg;
        localLayoutParams.height = this.Fzg;
        localLayoutParams.rightMargin = this.Fzh;
        localLayoutParams.leftMargin = this.Fzh;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.Fzd.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.Fzd.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.Fzg;
      localLayoutParams.height = this.Fzg;
      localLayoutParams.rightMargin = this.Fzi;
      localLayoutParams.leftMargin = this.Fzi;
      paramInt += 1;
    }
    while (i < this.Fze.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.Fze.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.Fzg;
      localLayoutParams.height = this.Fzg;
      localLayoutParams.rightMargin = this.Fzi;
      localLayoutParams.leftMargin = this.Fzi;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void Sd(String paramString)
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
    if (i < this.Fzd.getChildCount()) {
      if (this.Fzd.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.Fze.getChildCount()) {
          if (!this.Fze.getChildAt(j).getTag().equals(paramString)) {}
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
          this.Fze.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.Fzd.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          XI(this.size);
          XJ(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.Fzd.removeViewAt(j);
          paramString = this.Fze.getChildAt(0);
          this.Fze.removeViewAt(0);
          this.Fzd.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
  
  public final void aQL(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.Fzd.addView(localImageView);
    }
    for (;;)
    {
      XI(this.size);
      XJ(this.size);
      AppMethodBeat.o(114727);
      return;
      this.Fze.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Fzj += 1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(114730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.l
 * JD-Core Version:    0.7.0.1
 */