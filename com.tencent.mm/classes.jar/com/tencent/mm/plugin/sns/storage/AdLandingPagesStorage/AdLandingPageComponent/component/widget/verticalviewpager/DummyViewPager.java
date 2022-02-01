package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a;
import java.io.Serializable;

public class DummyViewPager
  extends AdLandingViewPager
  implements Serializable
{
  protected int Kvj;
  
  public DummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97057);
    a(new a());
    setOnPageChangeListener(new ViewPager.f()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(97056);
        super.onPageScrollStateChanged(paramAnonymousInt);
        if (paramAnonymousInt == 0) {
          DummyViewPager.this.Kvj = DummyViewPager.this.getScrollX();
        }
        AppMethodBeat.o(97056);
      }
    });
    AppMethodBeat.o(97057);
  }
  
  public int getBaseScrollX()
  {
    return this.Kvj;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setBaseScrollX(int paramInt)
  {
    this.Kvj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager
 * JD-Core Version:    0.7.0.1
 */