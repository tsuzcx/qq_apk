package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.y;

public class MMDotView
  extends LinearLayout
{
  private int dng = 9;
  private int uUC = a.f.page_normal;
  private int uUD = a.f.page_active;
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMDotView);
    int i = paramContext.getResourceId(a.m.MMDotView_dot_count, 0);
    paramContext.recycle();
    setDotCount(i);
  }
  
  public void setDarkStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uUC = a.f.page_normal_dark;
      this.uUD = a.f.page_active_dark;
      return;
    }
    this.uUC = a.f.page_normal;
    this.uUD = a.f.page_active;
  }
  
  public void setDotCount(int paramInt)
  {
    y.v("MicroMsg.MMDotView", "setDotCount:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0) {}
    ImageView localImageView;
    do
    {
      return;
      int i = paramInt;
      if (paramInt > this.dng)
      {
        y.i("MicroMsg.MMDotView", "large than max count");
        i = this.dng;
      }
      removeAllViews();
      while (i != 0)
      {
        localImageView = (ImageView)View.inflate(getContext(), a.h.mmpage_control_image, null);
        localImageView.setImageResource(this.uUC);
        addView(localImageView);
        i -= 1;
      }
      localImageView = (ImageView)getChildAt(0);
    } while (localImageView == null);
    localImageView.setImageResource(this.uUD);
  }
  
  public void setInvertedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uUC = a.f.page_active;
      this.uUD = a.f.page_normal;
      return;
    }
    this.uUC = a.f.page_normal;
    this.uUD = a.f.page_active;
  }
  
  public void setMaxCount(int paramInt)
  {
    y.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(paramInt) });
    this.dng = paramInt;
  }
  
  public void setSelectedDot(int paramInt)
  {
    y.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt >= getChildCount()) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      y.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", new Object[] { Integer.valueOf(i) });
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((ImageView)getChildAt(paramInt)).setImageResource(this.uUC);
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    ImageView localImageView = (ImageView)getChildAt(i);
    if (localImageView != null) {
      localImageView.setImageResource(this.uUD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMDotView
 * JD-Core Version:    0.7.0.1
 */