package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class a
{
  private Context mContext;
  View oJO;
  int oJP;
  FrameLayout.LayoutParams oJQ;
  
  public a(Activity paramActivity)
  {
    this.mContext = paramActivity;
    this.oJO = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.oJO.getViewTreeObserver().addOnGlobalLayoutListener(new a.1(this));
    this.oJQ = ((FrameLayout.LayoutParams)this.oJO.getLayoutParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a
 * JD-Core Version:    0.7.0.1
 */