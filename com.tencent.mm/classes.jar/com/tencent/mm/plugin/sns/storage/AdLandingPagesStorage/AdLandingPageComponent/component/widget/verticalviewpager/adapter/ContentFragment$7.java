package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.ui.al;
import java.util.LinkedList;

final class ContentFragment$7
  implements Runnable
{
  ContentFragment$7(ContentFragment paramContentFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(37625);
    if (ContentFragment.a(this.rzA) == null)
    {
      AppMethodBeat.o(37625);
      return;
    }
    if (((ContentFragment.d(this.rzA).rCf) || (!TextUtils.isEmpty(ContentFragment.d(this.rzA).rCe))) && (!ContentFragment.j(this.rzA)))
    {
      ContentFragment.k(this.rzA);
      ContentFragment.a(this.rzA).rzJ.setVisibility(0);
      ContentFragment.a(this.rzA).rzF.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ContentFragment.a(this.rzA).rzJ.getViewTreeObserver().addOnPreDrawListener(new ContentFragment.7.1(this));
      a locala = ContentFragment.m(this.rzA);
      LinearLayout localLinearLayout = ContentFragment.a(this.rzA).rzJ;
      int i = 0;
      while (i < locala.rzb.rCg.size())
      {
        Object localObject = (t)locala.rzb.rCg.get(i);
        localObject = al.a(localLinearLayout.getContext(), (t)localObject, localLinearLayout, locala.bgColor);
        if (localObject != null)
        {
          if ((((h)localObject).getView().getParent() != null) && ((((h)localObject).getView().getParent() instanceof ViewGroup))) {
            ((ViewGroup)((h)localObject).getView().getParent()).removeView(((h)localObject).getView());
          }
          ((h)localObject).getView().setTag(localObject);
          localLinearLayout.addView(((h)localObject).getView());
        }
        i += 1;
      }
    }
    AppMethodBeat.o(37625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.7
 * JD-Core Version:    0.7.0.1
 */