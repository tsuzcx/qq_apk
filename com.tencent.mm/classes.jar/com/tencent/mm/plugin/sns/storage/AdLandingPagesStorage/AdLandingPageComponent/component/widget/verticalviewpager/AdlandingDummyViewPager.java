package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;

public class AdlandingDummyViewPager
  extends DummyViewPager
{
  private AdlandingDummyViewPager.a oIZ = new AdlandingDummyViewPager.a(this, (byte)0);
  public Set<ViewPager.e> oJa = new HashSet();
  
  public AdlandingDummyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnPageChangeListener(this.oIZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager
 * JD-Core Version:    0.7.0.1
 */