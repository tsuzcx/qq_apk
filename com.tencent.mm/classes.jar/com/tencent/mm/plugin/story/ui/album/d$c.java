package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.h;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$c
  implements View.OnClickListener
{
  d$c(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119824);
    k.g(paramView, "view");
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof h)))
    {
      b localb = this.zFh.zET;
      if (localb != null)
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
          AppMethodBeat.o(119824);
          throw paramView;
        }
        localb.ay((h)paramView);
        AppMethodBeat.o(119824);
        return;
      }
    }
    AppMethodBeat.o(119824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d.c
 * JD-Core Version:    0.7.0.1
 */