package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.v;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryGalleryView$g$e
  implements Runnable
{
  StoryGalleryView$g$e(StoryGalleryView.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(110795);
    StoryGalleryView localStoryGalleryView = this.sUa.sTX;
    Object localObject1 = null;
    if (localStoryGalleryView.sSN == m.a.sqR) {
      localObject1 = ac.a.yLy;
    }
    if (localObject1 != null)
    {
      Object localObject2 = g.RL();
      j.p(localObject2, "storage()");
      if (!((e)localObject2).Ru().getBoolean((ac.a)localObject1, false))
      {
        localObject1 = localStoryGalleryView.sTt.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(110795);
          throw ((Throwable)localObject1);
        }
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        am.hY(localStoryGalleryView.getContext());
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (-localStoryGalleryView.getTop());
        localStoryGalleryView.sTt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localStoryGalleryView.sTt.setVisibility(0);
        localObject1 = localStoryGalleryView.sTt;
        localObject2 = localStoryGalleryView.getResources().getString(2131304189);
        j.p(localObject2, "resources.getString(R.string.story_pull_hint)");
        ((TextView)localObject1).setText((CharSequence)StoryGalleryView.a.m((CharSequence)localObject2, localStoryGalleryView.sTt.getCurrentTextColor()));
      }
    }
    AppMethodBeat.o(110795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.g.e
 * JD-Core Version:    0.7.0.1
 */