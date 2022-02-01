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
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class h
  implements View.OnClickListener
{
  private Context context;
  private int rTi;
  private int size;
  private int vaB;
  private int vay;
  private LinearLayout vbb;
  private LinearLayout vbc;
  private LinearLayout vbd;
  private int vbe;
  private int vbf;
  private int vbg;
  private int vbh;
  public int vbi;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.rTi = f.rTi;
    this.vbg = (f.rTi + f.vas);
    this.vbh = (f.rTi * 2 + f.vas);
    this.vay = (f.rTi * 4);
    this.vaB = f.vaB;
    this.context = paramActivity.getBaseContext();
    int i = a.ig(this.context) - this.vay * 2;
    this.vbe = ((i - this.vbg * 10) / 5);
    this.vbf = ((i - this.vbh * 10) / 5);
    this.vbb = ((LinearLayout)paramActivity.findViewById(2131297002));
    paramActivity = (RelativeLayout.LayoutParams)this.vbb.getLayoutParams();
    paramActivity.topMargin = (this.rTi * 2);
    paramActivity.bottomMargin = (this.rTi * 2);
    paramActivity.leftMargin = this.vay;
    paramActivity.rightMargin = this.vay;
    this.vbb.setLayoutParams(paramActivity);
    this.vbc = new LinearLayout(this.context);
    this.vbd = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.vbc.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.vbd.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.vbd);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.vbb.addView(this.vbc);
    this.vbb.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void Jl(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vbc.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.vbd.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.vbe;
      this.vbd.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.vbf;
    localLayoutParams.topMargin = (this.rTi * 2);
    localLayoutParams.bottomMargin = (this.rTi * 2);
    this.vbd.setVisibility(0);
    localLayoutParams1.height = this.vbf;
    localLayoutParams1.topMargin = (this.rTi * 2);
    localLayoutParams1.bottomMargin = (this.rTi * 2);
    AppMethodBeat.o(114728);
  }
  
  private void Jm(int paramInt)
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
        if (paramInt >= this.vbc.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.vbc.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.vbe;
        localLayoutParams.height = this.vbe;
        localLayoutParams.rightMargin = this.vbg;
        localLayoutParams.leftMargin = this.vbg;
        paramInt += 1;
      }
      while (i < this.vbd.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.vbd.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.vbf;
        localLayoutParams.height = this.vbf;
        localLayoutParams.rightMargin = this.vbg;
        localLayoutParams.leftMargin = this.vbg;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.vbc.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.vbc.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.vbf;
      localLayoutParams.height = this.vbf;
      localLayoutParams.rightMargin = this.vbh;
      localLayoutParams.leftMargin = this.vbh;
      paramInt += 1;
    }
    while (i < this.vbd.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.vbd.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.vbf;
      localLayoutParams.height = this.vbf;
      localLayoutParams.rightMargin = this.vbh;
      localLayoutParams.leftMargin = this.vbh;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void amF(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.vbc.addView(localImageView);
    }
    for (;;)
    {
      Jl(this.size);
      Jm(this.size);
      AppMethodBeat.o(114727);
      return;
      this.vbd.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    this.vbi += 1;
    AppMethodBeat.o(114730);
  }
  
  public final void yD(String paramString)
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
    if (i < this.vbc.getChildCount()) {
      if (this.vbc.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.vbd.getChildCount()) {
          if (!this.vbd.getChildAt(j).getTag().equals(paramString)) {}
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
          this.vbd.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.vbc.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          Jl(this.size);
          Jm(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.vbc.removeViewAt(j);
          paramString = this.vbd.getChildAt(0);
          this.vbd.removeViewAt(0);
          this.vbc.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */