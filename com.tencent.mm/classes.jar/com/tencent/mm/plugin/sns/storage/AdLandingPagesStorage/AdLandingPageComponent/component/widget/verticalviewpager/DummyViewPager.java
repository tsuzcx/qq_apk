package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b.a;
import java.io.Serializable;

public class DummyViewPager
  extends AdLandingViewPager
  implements Serializable
{
  protected int oJc;
  
  public DummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new a();
    if (Build.VERSION.SDK_INT >= 11) {
      if (this.Hj == null) {
        break label79;
      }
    }
    label79:
    for (int i = 1;; i = 0)
    {
      if (1 != i) {
        j = 1;
      }
      this.Hj = paramContext;
      setChildrenDrawingOrderEnabledCompat(true);
      this.Hl = 1;
      if (j != 0) {
        dm();
      }
      setOnPageChangeListener(new DummyViewPager.1(this));
      return;
    }
  }
  
  public int getBaseScrollX()
  {
    return this.oJc;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setBaseScrollX(int paramInt)
  {
    this.oJc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager
 * JD-Core Version:    0.7.0.1
 */