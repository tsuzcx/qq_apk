package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AdlandingDummyViewPager
  extends DummyViewPager
{
  private a yrr;
  public Set<ViewPager.OnPageChangeListener> yrs;
  
  public AdlandingDummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97055);
    this.yrr = new a((byte)0);
    this.yrs = new HashSet();
    setOnPageChangeListener(this.yrr);
    AppMethodBeat.o(97055);
  }
  
  final class a
    implements ViewPager.OnPageChangeListener
  {
    private a() {}
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(97054);
      if (paramInt == 0) {
        AdlandingDummyViewPager.this.yru = AdlandingDummyViewPager.this.getScrollX();
      }
      Iterator localIterator = AdlandingDummyViewPager.a(AdlandingDummyViewPager.this).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
      AppMethodBeat.o(97054);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(97052);
      Iterator localIterator = AdlandingDummyViewPager.a(AdlandingDummyViewPager.this).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
      AppMethodBeat.o(97052);
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(97053);
      Iterator localIterator = AdlandingDummyViewPager.a(AdlandingDummyViewPager.this).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
      }
      AppMethodBeat.o(97053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager
 * JD-Core Version:    0.7.0.1
 */