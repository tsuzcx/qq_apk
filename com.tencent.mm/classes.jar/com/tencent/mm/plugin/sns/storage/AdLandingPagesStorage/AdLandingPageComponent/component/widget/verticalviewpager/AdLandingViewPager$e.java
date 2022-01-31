package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AdLandingViewPager$e
  extends DataSetObserver
{
  private AdLandingViewPager$e(AdLandingViewPager paramAdLandingViewPager) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(37510);
    this.ryT.dataSetChanged();
    AppMethodBeat.o(37510);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(37511);
    this.ryT.dataSetChanged();
    AppMethodBeat.o(37511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.e
 * JD-Core Version:    0.7.0.1
 */