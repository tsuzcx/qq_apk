package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ab;

final class ContentFragment$8
  extends BroadcastReceiver
{
  ContentFragment$8(ContentFragment paramContentFragment) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(145328);
    paramContext = paramIntent.getAction();
    ab.i("ContentFragmentSphereImageView", "onReceive, action=" + paramContext + ", isSphereCom=" + this.rzA.rzw + ", isFullScreen=" + this.rzA.rzx);
    if ("com.tencent.mm.adlanding.sphereimage.next_page_view_show".equals(paramContext))
    {
      paramContext = this.rzA.getActivity();
      if ((paramContext instanceof SnsAdNativeLandingPagesUI))
      {
        boolean bool = ((SnsAdNativeLandingPagesUI)paramContext).cuK();
        ab.i("ContentFragmentSphereImageView", "hasNextPage=".concat(String.valueOf(bool)));
        if (bool)
        {
          ContentFragment.a(this.rzA).rzH.setVisibility(0);
          paramContext = new AlphaAnimation(0.0F, 1.0F);
          paramContext.setDuration(500L);
          ContentFragment.a(this.rzA).rzH.startAnimation(paramContext);
        }
      }
      AppMethodBeat.o(145328);
      return;
    }
    if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none".equals(paramContext))
    {
      if (ContentFragment.a(this.rzA).rzH.getVisibility() == 0)
      {
        paramContext = ObjectAnimator.ofFloat(ContentFragment.a(this.rzA).rzH, "alpha", new float[] { 0.5F, 1.0F });
        paramContext.setDuration(300L);
        paramContext.start();
        AppMethodBeat.o(145328);
      }
    }
    else if ("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half".equals(paramContext))
    {
      if (ContentFragment.a(this.rzA).rzH.getVisibility() == 0)
      {
        paramContext = ObjectAnimator.ofFloat(ContentFragment.a(this.rzA).rzH, "alpha", new float[] { 1.0F, 0.5F });
        paramContext.setDuration(300L);
        paramContext.start();
        AppMethodBeat.o(145328);
      }
    }
    else if (("com.tencent.mm.adlanding.sphereimage.next_page_view_hide".equals(paramContext)) && (ContentFragment.a(this.rzA).rzH.getVisibility() == 0))
    {
      paramContext = new AlphaAnimation(1.0F, 0.0F);
      paramContext.setDuration(250L);
      paramContext.setFillAfter(true);
      ContentFragment.a(this.rzA).rzH.startAnimation(paramContext);
    }
    AppMethodBeat.o(145328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.8
 * JD-Core Version:    0.7.0.1
 */