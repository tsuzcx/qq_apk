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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d
  implements View.OnClickListener
{
  private Context context;
  private View kCO;
  private int mvB = b.mvB;
  private LinearLayout mvN;
  public LinearLayout mvO;
  public LinearLayout mvP;
  private int mvQ;
  private int mvR;
  private int mvS = b.mvv + b.mvu;
  private int mvT = b.mvv * 2 + b.mvu;
  private int mvU = b.mvv * 4;
  public int mvV;
  private int mvv = b.mvv;
  public int size = 0;
  
  public d(Activity paramActivity)
  {
    this.context = paramActivity.getBaseContext();
    int i = a.fj(this.context) - this.mvU * 2;
    this.mvQ = ((i - this.mvS * 10) / 5);
    this.mvR = ((i - this.mvT * 10) / 5);
    i = this.mvR;
    int j = this.mvv;
    this.kCO = paramActivity.findViewById(a.d.padding_view);
    this.kCO.getLayoutParams().height = (i * 2 + j * 12);
    this.mvN = ((LinearLayout)paramActivity.findViewById(a.d.avatar_container));
    paramActivity = (RelativeLayout.LayoutParams)this.mvN.getLayoutParams();
    paramActivity.topMargin = (this.mvv * 2);
    paramActivity.bottomMargin = (this.mvv * 2);
    paramActivity.leftMargin = this.mvU;
    paramActivity.rightMargin = this.mvU;
    this.mvN.setLayoutParams(paramActivity);
    this.mvO = new LinearLayout(this.context);
    this.mvP = new LinearLayout(this.context);
    paramActivity = new LinearLayout.LayoutParams(-2, -2);
    this.mvO.setLayoutParams(paramActivity);
    paramActivity = new RelativeLayout.LayoutParams(-2, -2);
    paramActivity.addRule(14);
    this.mvP.setLayoutParams(paramActivity);
    paramActivity = new LinearLayout.LayoutParams(-1, -2);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    localRelativeLayout.addView(this.mvP);
    localRelativeLayout.setLayoutParams(paramActivity);
    this.mvN.addView(this.mvO);
    this.mvN.addView(localRelativeLayout);
  }
  
  public final void IM(String paramString)
  {
    this.size += 1;
    ImageView localImageView = new ImageView(this.context);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localImageView.setTag(paramString);
    localImageView.setOnClickListener(this);
    a.b.a(localImageView, paramString, 0.1F, false);
    if (this.size <= 5) {
      this.mvO.addView(localImageView);
    }
    for (;;)
    {
      ut(this.size);
      uu(this.size);
      return;
      this.mvP.addView(localImageView);
    }
  }
  
  public final void onClick(View paramView)
  {
    this.mvV += 1;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.kCO.setVisibility(0);
      return;
    }
    this.kCO.setVisibility(8);
  }
  
  public final void ut(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mvO.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.mvP.getLayoutParams();
    if (paramInt <= 5)
    {
      localLayoutParams.height = this.mvQ;
      this.mvP.setVisibility(8);
      return;
    }
    localLayoutParams.height = this.mvR;
    localLayoutParams.topMargin = (this.mvv * 2);
    localLayoutParams.bottomMargin = (this.mvv * 2);
    this.mvP.setVisibility(0);
    localLayoutParams1.height = this.mvR;
    localLayoutParams1.topMargin = (this.mvv * 2);
    localLayoutParams1.bottomMargin = (this.mvv * 2);
  }
  
  public final void uu(int paramInt)
  {
    int k = 0;
    int j = 0;
    int i;
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt <= 5)
    {
      paramInt = 0;
      for (;;)
      {
        i = j;
        if (paramInt >= this.mvO.getChildCount()) {
          break;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.mvO.getChildAt(paramInt).getLayoutParams();
        localLayoutParams.width = this.mvQ;
        localLayoutParams.height = this.mvQ;
        localLayoutParams.rightMargin = this.mvS;
        localLayoutParams.leftMargin = this.mvS;
        paramInt += 1;
      }
      while (i < this.mvP.getChildCount())
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.mvP.getChildAt(i).getLayoutParams();
        localLayoutParams.width = this.mvR;
        localLayoutParams.height = this.mvR;
        localLayoutParams.rightMargin = this.mvS;
        localLayoutParams.leftMargin = this.mvS;
        i += 1;
      }
    }
    paramInt = 0;
    for (;;)
    {
      i = k;
      if (paramInt >= this.mvO.getChildCount()) {
        break;
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.mvO.getChildAt(paramInt).getLayoutParams();
      localLayoutParams.width = this.mvR;
      localLayoutParams.height = this.mvR;
      localLayoutParams.rightMargin = this.mvT;
      localLayoutParams.leftMargin = this.mvT;
      paramInt += 1;
    }
    while (i < this.mvP.getChildCount())
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.mvP.getChildAt(i).getLayoutParams();
      localLayoutParams.width = this.mvR;
      localLayoutParams.height = this.mvR;
      localLayoutParams.rightMargin = this.mvT;
      localLayoutParams.leftMargin = this.mvT;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */