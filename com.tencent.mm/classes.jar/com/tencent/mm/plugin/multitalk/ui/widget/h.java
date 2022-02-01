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
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class h
  implements View.OnClickListener
{
  private Context context;
  private int size;
  private int tRL;
  private int tRR;
  private int tRU;
  private int tSA;
  public int tSB;
  private LinearLayout tSu;
  private LinearLayout tSv;
  private LinearLayout tSw;
  private int tSx;
  private int tSy;
  private int tSz;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(114726);
    this.size = 0;
    this.tRL = f.tRL;
    this.tSz = (f.tRL + f.tRK);
    this.tSA = (f.tRL * 2 + f.tRK);
    this.tRR = (f.tRL * 4);
    this.tRU = f.tRU;
    this.context = paramActivity.getBaseContext();
    int i = a.hV(this.context) - this.tRR * 2;
    this.tSx = ((i - this.tSz * 10) / 5);
    this.tSy = ((i - this.tSA * 10) / 5);
    this.tSu = ((LinearLayout)paramActivity.findViewById(2131297002));
    paramActivity = (RelativeLayout.LayoutParams)this.tSu.getLayoutParams();
    paramActivity.topMargin = (this.tRL * 2);
    paramActivity.bottomMargin = (this.tRL * 2);
    paramActivity.leftMargin = this.tRR;
    paramActivity.rightMargin = this.tRR;
    this.tSu.setLayoutParams(paramActivity);
    this.tSv = new LinearLayout(this.context);
    this.tSw = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.tSv.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.tSw.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.tSw);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.tSu.addView(this.tSv);
    this.tSu.addView(localRelativeLayout);
    AppMethodBeat.o(114726);
  }
  
  private void Hn(int paramInt)
  {
    AppMethodBeat.i(114728);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.tSv.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.tSw.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.tSx;
      this.tSw.setVisibility(8);
      AppMethodBeat.o(114728);
      return;
    }
    localLayoutParams.height = this.tSy;
    localLayoutParams.topMargin = (this.tRL * 2);
    localLayoutParams.bottomMargin = (this.tRL * 2);
    this.tSw.setVisibility(0);
    localLayoutParams1.height = this.tSy;
    localLayoutParams1.topMargin = (this.tRL * 2);
    localLayoutParams1.bottomMargin = (this.tRL * 2);
    AppMethodBeat.o(114728);
  }
  
  private void Ho(int paramInt)
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
        if (paramInt >= this.tSv.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.tSv.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.tSx;
        localLayoutParams.height = this.tSx;
        localLayoutParams.rightMargin = this.tSz;
        localLayoutParams.leftMargin = this.tSz;
        paramInt += 1;
      }
      while (i < this.tSw.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.tSw.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.tSy;
        localLayoutParams.height = this.tSy;
        localLayoutParams.rightMargin = this.tSz;
        localLayoutParams.leftMargin = this.tSz;
        i += 1;
      }
      AppMethodBeat.o(114729);
      return;
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.tSv.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.tSv.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.tSy;
      localLayoutParams.height = this.tSy;
      localLayoutParams.rightMargin = this.tSA;
      localLayoutParams.leftMargin = this.tSA;
      paramInt += 1;
    }
    while (i < this.tSw.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.tSw.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.tSy;
      localLayoutParams.height = this.tSy;
      localLayoutParams.rightMargin = this.tSA;
      localLayoutParams.leftMargin = this.tSA;
      i += 1;
    }
    AppMethodBeat.o(114729);
  }
  
  public final void ahK(String paramString)
  {
    AppMethodBeat.i(114727);
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.c(localImageView, paramString);
    if (this.size <= 5) {
      this.tSv.addView(localImageView);
    }
    for (;;)
    {
      Hn(this.size);
      Ho(this.size);
      AppMethodBeat.o(114727);
      return;
      this.tSw.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114730);
    this.tSB += 1;
    AppMethodBeat.o(114730);
  }
  
  public final void ux(String paramString)
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
    if (i < this.tSv.getChildCount()) {
      if (this.tSv.getChildAt(i).getTag().equals(paramString)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        j = 0;
        label63:
        if (j < this.tSw.getChildCount()) {
          if (!this.tSw.getChildAt(j).getTag().equals(paramString)) {}
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
          this.tSw.removeViewAt(j);
          this.size -= 1;
        }
        if (k != 0)
        {
          if (this.size > 5) {
            break label194;
          }
          this.tSv.removeViewAt(j);
        }
        for (this.size -= 1;; this.size -= 1)
        {
          Hn(this.size);
          Ho(this.size);
          AppMethodBeat.o(178927);
          return;
          label194:
          this.tSv.removeViewAt(j);
          paramString = this.tSw.getChildAt(0);
          this.tSw.removeViewAt(0);
          this.tSv.addView(paramString);
        }
        m = 0;
        j = i;
      }
      k = 0;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */