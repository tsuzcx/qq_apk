package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ab;

final class ContentFragment$9
  implements View.OnClickListener
{
  ContentFragment$9(ContentFragment paramContentFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(145329);
    paramView = this.rzA.getActivity();
    if ((paramView instanceof SnsAdNativeLandingPagesUI))
    {
      ab.i("ContentFragmentSphereImageView", "jumpNextPage");
      paramView = (SnsAdNativeLandingPagesUI)paramView;
      try
      {
        boolean bool = paramView.cuK();
        ab.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(bool)));
        if (bool) {
          paramView.rMv.setCurrentItem$2563266(paramView.rMv.getCurrentItem() + 1);
        }
        AppMethodBeat.o(145329);
        return;
      }
      catch (Exception paramView)
      {
        ab.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + paramView.toString());
      }
    }
    AppMethodBeat.o(145329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.9
 * JD-Core Version:    0.7.0.1
 */