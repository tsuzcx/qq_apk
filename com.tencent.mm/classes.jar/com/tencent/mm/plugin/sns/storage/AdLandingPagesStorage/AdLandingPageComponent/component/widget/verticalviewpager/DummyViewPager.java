package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a;
import java.io.Serializable;

public class DummyViewPager
  extends AdLandingViewPager
  implements Serializable
{
  protected int ryX;
  
  public DummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37594);
    paramContext = new a();
    if (Build.VERSION.SDK_INT >= 11) {
      if (this.mPageTransformer == null) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      if (1 != i) {
        j = 1;
      }
      this.mPageTransformer = paramContext;
      setChildrenDrawingOrderEnabledCompat(true);
      this.mDrawingOrder = 1;
      if (j != 0) {
        populate();
      }
      setOnPageChangeListener(new DummyViewPager.1(this));
      AppMethodBeat.o(37594);
      return;
    }
  }
  
  public int getBaseScrollX()
  {
    return this.ryX;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setBaseScrollX(int paramInt)
  {
    this.ryX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager
 * JD-Core Version:    0.7.0.1
 */