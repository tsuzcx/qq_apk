package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.f;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a;
import java.io.Serializable;

public class DummyViewPager
  extends AdLandingViewPager
  implements Serializable
{
  protected int yru;
  
  public DummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97057);
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
      setOnPageChangeListener(new ViewPager.f()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(97056);
          super.onPageScrollStateChanged(paramAnonymousInt);
          if (paramAnonymousInt == 0) {
            DummyViewPager.this.yru = DummyViewPager.this.getScrollX();
          }
          AppMethodBeat.o(97056);
        }
      });
      AppMethodBeat.o(97057);
      return;
    }
  }
  
  public int getBaseScrollX()
  {
    return this.yru;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setBaseScrollX(int paramInt)
  {
    this.yru = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager
 * JD-Core Version:    0.7.0.1
 */