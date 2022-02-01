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
  private int sPS;
  private int size;
  private int wfH;
  private int wfK;
  private LinearLayout wgk;
  private LinearLayout wgl;
  private LinearLayout wgm;
  private int wgn;
  private int wgo;
  private int wgp;
  private int wgq;
  public int wgr;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.sPS = f.sPS;
    this.wgp = (f.sPS + f.wfB);
    this.wgq = (f.sPS * 2 + f.wfB);
    this.wfH = (f.sPS * 4);
    this.wfK = f.wfK;
    this.context = paramActivity.getBaseContext();
    int i = com.tencent.mm.cc.a.ip(this.context) - this.wfH * 2;
    this.wgn = ((i - this.wgp * 10) / 5);
    this.wgo = ((i - this.wgq * 10) / 5);
    this.wgk = ((LinearLayout)paramActivity.findViewById(2131297002));
    paramActivity = (RelativeLayout.LayoutParams)this.wgk.getLayoutParams();
    paramActivity.topMargin = (this.sPS * 2);
    paramActivity.bottomMargin = (this.sPS * 2);
    paramActivity.leftMargin = this.wfH;
    paramActivity.rightMargin = this.wfH;
    this.wgk.setLayoutParams(paramActivity);
    this.wgl = new LinearLayout(this.context);
    this.wgm = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.wgl.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.wgm.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.wgm);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.wgk.addView(this.wgl);
    this.wgk.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void KM(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.wgl.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.wgm.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.wgn;
      this.wgm.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.wgo;
    localLayoutParams.topMargin = (this.sPS * 2);
    localLayoutParams.bottomMargin = (this.sPS * 2);
    this.wgm.setVisibility(0);
    localLayoutParams1.height = this.wgo;
    localLayoutParams1.topMargin = (this.sPS * 2);
    localLayoutParams1.bottomMargin = (this.sPS * 2);
    AppMethodBeat.o(114728);
  }
  
  private void KN(int paramInt)
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
        if (paramInt >= this.wgl.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.wgl.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.wgn;
        localLayoutParams.height = this.wgn;
        localLayoutParams.rightMargin = this.wgp;
        localLayoutParams.leftMargin = this.wgp;
        paramInt += 1;
      }
      while (i < this.wgm.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.wgm.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.wgo;
        localLayoutParams.height = this.wgo;
        localLayoutParams.rightMargin = this.wgp;
        localLayoutParams.leftMargin = this.wgp;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.wgl.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.wgl.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.wgo;
      localLayoutParams.height = this.wgo;
      localLayoutParams.rightMargin = this.wgq;
      localLayoutParams.leftMargin = this.wgq;
      paramInt += 1;
    }
    while (i < this.wgm.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.wgm.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.wgo;
      localLayoutParams.height = this.wgo;
      localLayoutParams.rightMargin = this.wgq;
      localLayoutParams.leftMargin = this.wgq;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void BC(String paramString)
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
    if (i < this.wgl.getChildCount()) {
      if (this.wgl.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.wgm.getChildCount()) {
          if (!this.wgm.getChildAt(j).getTag().equals(paramString)) {}
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
          this.wgm.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.wgl.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          KM(this.size);
          KN(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.wgl.removeViewAt(j);
          paramString = this.wgm.getChildAt(0);
          this.wgm.removeViewAt(0);
          this.wgl.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
  
  public final void arG(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.wgl.addView(localImageView);
    }
    for (;;)
    {
      KM(this.size);
      KN(this.size);
      AppMethodBeat.o(114727);
      return;
      this.wgm.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.wgr += 1;
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(114730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */