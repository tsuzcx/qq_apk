package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.sdk.platformtools.ab;

final class ContentFragment$7$1
  implements ViewTreeObserver.OnPreDrawListener
{
  ContentFragment$7$1(ContentFragment.7 param7) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(37624);
    if (ContentFragment.a(this.rzE.rzA).rzJ.getHeight() > 0)
    {
      ContentFragment.a(this.rzE.rzA).rzJ.getViewTreeObserver().removeOnPreDrawListener(this);
      ContentFragment.b(this.rzE.rzA, ContentFragment.a(this.rzE.rzA).rzJ.getHeight());
      if (ContentFragment.l(this.rzE.rzA) < ContentFragment.f(this.rzE.rzA)) {
        ContentFragment.b(this.rzE.rzA, ContentFragment.f(this.rzE.rzA));
      }
      Object localObject = (FrameLayout.LayoutParams)ContentFragment.a(this.rzE.rzA).rzF.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = ContentFragment.l(this.rzE.rzA);
      ContentFragment.a(this.rzE.rzA).rzF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ab.i("ContentFragment", "set bgIV height " + ContentFragment.a(this.rzE.rzA).rzJ.getHeight() + ", count " + ContentFragment.a(this.rzE.rzA).rzJ.getChildCount());
      int i = 0;
      while (i < ContentFragment.a(this.rzE.rzA).rzJ.getChildCount())
      {
        localObject = ContentFragment.a(this.rzE.rzA).rzJ.getChildAt(i).getTag();
        if ((localObject instanceof h)) {
          ((h)localObject).cqz();
        }
        i += 1;
      }
      ContentFragment.a(this.rzE.rzA).rzJ.removeAllViews();
      ContentFragment.a(this.rzE.rzA).rzJ.setVisibility(8);
    }
    AppMethodBeat.o(37624);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.7.1
 * JD-Core Version:    0.7.0.1
 */