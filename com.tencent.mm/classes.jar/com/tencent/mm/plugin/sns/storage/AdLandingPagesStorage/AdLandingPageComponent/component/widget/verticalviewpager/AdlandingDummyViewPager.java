package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class AdlandingDummyViewPager
  extends DummyViewPager
{
  private AdlandingDummyViewPager.a ryU;
  public Set<ViewPager.OnPageChangeListener> ryV;
  
  public AdlandingDummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37592);
    this.ryU = new AdlandingDummyViewPager.a(this, (byte)0);
    this.ryV = new HashSet();
    setOnPageChangeListener(this.ryU);
    AppMethodBeat.o(37592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager
 * JD-Core Version:    0.7.0.1
 */