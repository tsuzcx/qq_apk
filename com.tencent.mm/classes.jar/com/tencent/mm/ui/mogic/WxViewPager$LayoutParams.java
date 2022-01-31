package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class WxViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  float Hr = 0.0F;
  public boolean Ht;
  boolean Hu;
  int Hv;
  public int gravity;
  int position;
  
  public WxViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public WxViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, WxViewPager.bFK());
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */