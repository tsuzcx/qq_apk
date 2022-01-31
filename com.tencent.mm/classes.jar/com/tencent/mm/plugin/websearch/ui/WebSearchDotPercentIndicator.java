package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.y;

public class WebSearchDotPercentIndicator
  extends LinearLayout
{
  private LayoutInflater Lu;
  private int gCH;
  
  public WebSearchDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public WebSearchDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  public void setDotsNum(int paramInt)
  {
    if (paramInt > 1) {}
    for (;;)
    {
      this.gCH = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.gCH)
      {
        addView((ImageView)this.Lu.inflate(a.d.fts_web_dot_percent_indicator_dot, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
  }
  
  public void setPercent(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F)
    {
      paramFloat = f2;
      if (paramFloat <= 1.0F) {
        break label114;
      }
      paramFloat = f1;
    }
    int j;
    label114:
    for (;;)
    {
      int k = (int)Math.rint(this.gCH * paramFloat);
      y.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(k) });
      int i = 0;
      for (;;)
      {
        j = i;
        if (i >= k) {
          break;
        }
        j = i;
        if (i >= getChildCount()) {
          break;
        }
        ((ImageView)getChildAt(i)).setImageResource(a.b.fts_web_dot_percent_indicator_dot_on_shape);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(a.b.fts_web_dot_percent_indicator_dot_off_shape);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */