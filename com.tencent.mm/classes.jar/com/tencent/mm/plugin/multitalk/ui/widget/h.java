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
import com.tencent.mm.pluginsdk.ui.a.b;

public final class h
  implements View.OnClickListener
{
  private Context context;
  private int size;
  private int tbf;
  private LinearLayout wvN;
  private LinearLayout wvO;
  private LinearLayout wvP;
  private int wvQ;
  private int wvR;
  private int wvS;
  private int wvT;
  public int wvU;
  private int wvk;
  private int wvn;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.tbf = f.tbf;
    this.wvS = (f.tbf + f.wve);
    this.wvT = (f.tbf * 2 + f.wve);
    this.wvk = (f.tbf * 4);
    this.wvn = f.wvn;
    this.context = paramActivity.getBaseContext();
    int i = com.tencent.mm.cb.a.iu(this.context) - this.wvk * 2;
    this.wvQ = ((i - this.wvS * 10) / 5);
    this.wvR = ((i - this.wvT * 10) / 5);
    this.wvN = ((LinearLayout)paramActivity.findViewById(2131297002));
    paramActivity = (RelativeLayout.LayoutParams)this.wvN.getLayoutParams();
    paramActivity.topMargin = (this.tbf * 2);
    paramActivity.bottomMargin = (this.tbf * 2);
    paramActivity.leftMargin = this.wvk;
    paramActivity.rightMargin = this.wvk;
    this.wvN.setLayoutParams(paramActivity);
    this.wvO = new LinearLayout(this.context);
    this.wvP = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.wvO.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.wvP.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.wvP);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.wvN.addView(this.wvO);
    this.wvN.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void Lr(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.wvO.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.wvP.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.wvQ;
      this.wvP.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.wvR;
    localLayoutParams.topMargin = (this.tbf * 2);
    localLayoutParams.bottomMargin = (this.tbf * 2);
    this.wvP.setVisibility(0);
    localLayoutParams1.height = this.wvR;
    localLayoutParams1.topMargin = (this.tbf * 2);
    localLayoutParams1.bottomMargin = (this.tbf * 2);
    AppMethodBeat.o(114728);
  }
  
  private void Ls(int paramInt)
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
        if (paramInt >= this.wvO.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.wvO.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.wvQ;
        localLayoutParams.height = this.wvQ;
        localLayoutParams.rightMargin = this.wvS;
        localLayoutParams.leftMargin = this.wvS;
        paramInt += 1;
      }
      while (i < this.wvP.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.wvP.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.wvR;
        localLayoutParams.height = this.wvR;
        localLayoutParams.rightMargin = this.wvS;
        localLayoutParams.leftMargin = this.wvS;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.wvO.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.wvO.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.wvR;
      localLayoutParams.height = this.wvR;
      localLayoutParams.rightMargin = this.wvT;
      localLayoutParams.leftMargin = this.wvT;
      paramInt += 1;
    }
    while (i < this.wvP.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.wvP.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.wvR;
      localLayoutParams.height = this.wvR;
      localLayoutParams.rightMargin = this.wvT;
      localLayoutParams.leftMargin = this.wvT;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void Ce(String paramString)
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
    if (i < this.wvO.getChildCount()) {
      if (this.wvO.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.wvP.getChildCount()) {
          if (!this.wvP.getChildAt(j).getTag().equals(paramString)) {}
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
          this.wvP.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.wvO.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          Lr(this.size);
          Ls(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.wvO.removeViewAt(j);
          paramString = this.wvP.getChildAt(0);
          this.wvP.removeViewAt(0);
          this.wvO.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
  
  public final void asT(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.wvO.addView(localImageView);
    }
    for (;;)
    {
      Lr(this.size);
      Ls(this.size);
      AppMethodBeat.o(114727);
      return;
      this.wvP.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.wvU += 1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(114730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */