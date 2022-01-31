package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMDotView
  extends LinearLayout
{
  private int eeH;
  private int zjc;
  private int zjd;
  
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106528);
    this.eeH = 9;
    this.zjc = 2130839883;
    this.zjd = 2130839878;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(106528);
  }
  
  @TargetApi(11)
  public MMDotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106527);
    this.eeH = 9;
    this.zjc = 2130839883;
    this.zjd = 2130839878;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(106527);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(106529);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMDotView);
    int i = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    setDotCount(i);
    AppMethodBeat.o(106529);
  }
  
  public void setDarkStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.zjc = 2130839884;
      this.zjd = 2130839879;
      return;
    }
    this.zjc = 2130839883;
    this.zjd = 2130839878;
  }
  
  public void setDotCount(int paramInt)
  {
    AppMethodBeat.i(106531);
    ab.v("MicroMsg.MMDotView", "setDotCount:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(106531);
      return;
    }
    int i = paramInt;
    if (paramInt > this.eeH)
    {
      ab.i("MicroMsg.MMDotView", "large than max count");
      i = this.eeH;
    }
    removeAllViews();
    while (i != 0)
    {
      localImageView = (ImageView)View.inflate(getContext(), 2130970284, null);
      localImageView.setImageResource(this.zjc);
      addView(localImageView);
      i -= 1;
    }
    ImageView localImageView = (ImageView)getChildAt(0);
    if (localImageView != null) {
      localImageView.setImageResource(this.zjd);
    }
    AppMethodBeat.o(106531);
  }
  
  public void setInvertedStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.zjc = 2130839878;
      this.zjd = 2130839883;
      return;
    }
    this.zjc = 2130839883;
    this.zjd = 2130839878;
  }
  
  public void setMaxCount(int paramInt)
  {
    AppMethodBeat.i(106530);
    ab.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[] { Integer.valueOf(paramInt) });
    this.eeH = paramInt;
    AppMethodBeat.o(106530);
  }
  
  public void setSelectedDot(int paramInt)
  {
    AppMethodBeat.i(106532);
    ab.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt >= getChildCount()) {
      i = getChildCount() - 1;
    }
    for (;;)
    {
      ab.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", new Object[] { Integer.valueOf(i) });
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((ImageView)getChildAt(paramInt)).setImageResource(this.zjc);
        paramInt += 1;
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
    ImageView localImageView = (ImageView)getChildAt(i);
    if (localImageView != null) {
      localImageView.setImageResource(this.zjd);
    }
    AppMethodBeat.o(106532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMDotView
 * JD-Core Version:    0.7.0.1
 */