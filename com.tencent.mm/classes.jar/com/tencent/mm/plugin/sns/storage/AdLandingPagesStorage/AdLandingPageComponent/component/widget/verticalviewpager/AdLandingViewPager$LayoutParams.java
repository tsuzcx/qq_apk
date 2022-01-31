package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class AdLandingViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  float Hr = 0.0F;
  public boolean Ht;
  boolean Hu;
  int Hv;
  public int gravity;
  int position;
  
  public AdLandingViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public AdLandingViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, AdLandingViewPager.bFK());
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */