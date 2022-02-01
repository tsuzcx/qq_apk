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

public final class l
  implements View.OnClickListener
{
  private Context context;
  private int size;
  private int wfQ;
  private int zSk;
  private int zSn;
  private LinearLayout zTA;
  private LinearLayout zTB;
  private LinearLayout zTC;
  private int zTD;
  private int zTE;
  private int zTF;
  private int zTG;
  public int zTH;
  
  public l(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.wfQ = f.wfQ;
    this.zTF = (f.wfQ + f.zSd);
    this.zTG = (f.wfQ * 2 + f.zSd);
    this.zSk = (f.wfQ * 4);
    this.zSn = f.zSn;
    this.context = paramActivity.getBaseContext();
    int i = com.tencent.mm.cb.a.jn(this.context) - this.zSk * 2;
    this.zTD = ((i - this.zTF * 10) / 5);
    this.zTE = ((i - this.zTG * 10) / 5);
    this.zTA = ((LinearLayout)paramActivity.findViewById(2131297128));
    paramActivity = (RelativeLayout.LayoutParams)this.zTA.getLayoutParams();
    paramActivity.topMargin = (this.wfQ * 2);
    paramActivity.bottomMargin = (this.wfQ * 2);
    paramActivity.leftMargin = this.zSk;
    paramActivity.rightMargin = this.zSk;
    this.zTA.setLayoutParams(paramActivity);
    this.zTB = new LinearLayout(this.context);
    this.zTC = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.zTB.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.zTC.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.zTC);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.zTA.addView(this.zTB);
    this.zTA.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void Rt(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.zTB.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.zTC.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.zTD;
      this.zTC.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.zTE;
    localLayoutParams.topMargin = (this.wfQ * 2);
    localLayoutParams.bottomMargin = (this.wfQ * 2);
    this.zTC.setVisibility(0);
    localLayoutParams1.height = this.zTE;
    localLayoutParams1.topMargin = (this.wfQ * 2);
    localLayoutParams1.bottomMargin = (this.wfQ * 2);
    AppMethodBeat.o(114728);
  }
  
  private void Ru(int paramInt)
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
        if (paramInt >= this.zTB.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.zTB.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.zTD;
        localLayoutParams.height = this.zTD;
        localLayoutParams.rightMargin = this.zTF;
        localLayoutParams.leftMargin = this.zTF;
        paramInt += 1;
      }
      while (i < this.zTC.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.zTC.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.zTE;
        localLayoutParams.height = this.zTE;
        localLayoutParams.rightMargin = this.zTF;
        localLayoutParams.leftMargin = this.zTF;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.zTB.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.zTB.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.zTE;
      localLayoutParams.height = this.zTE;
      localLayoutParams.rightMargin = this.zTG;
      localLayoutParams.leftMargin = this.zTG;
      paramInt += 1;
    }
    while (i < this.zTC.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.zTC.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.zTE;
      localLayoutParams.height = this.zTE;
      localLayoutParams.rightMargin = this.zTG;
      localLayoutParams.leftMargin = this.zTG;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void KK(String paramString)
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
    if (i < this.zTB.getChildCount()) {
      if (this.zTB.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.zTC.getChildCount()) {
          if (!this.zTC.getChildAt(j).getTag().equals(paramString)) {}
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
          this.zTC.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.zTB.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          Rt(this.size);
          Ru(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.zTB.removeViewAt(j);
          paramString = this.zTC.getChildAt(0);
          this.zTC.removeViewAt(0);
          this.zTB.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
  
  public final void aGw(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.zTB.addView(localImageView);
    }
    for (;;)
    {
      Rt(this.size);
      Ru(this.size);
      AppMethodBeat.o(114727);
      return;
      this.zTC.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.zTH += 1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(114730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.l
 * JD-Core Version:    0.7.0.1
 */