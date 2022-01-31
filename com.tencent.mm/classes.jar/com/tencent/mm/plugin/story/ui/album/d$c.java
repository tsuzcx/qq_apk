package com.tencent.mm.plugin.story.ui.album;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$c
  implements View.OnClickListener
{
  d$c(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110162);
    j.p(paramView, "view");
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof h)))
    {
      b localb = this.sJi.sIT;
      if (localb != null)
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
          AppMethodBeat.o(110162);
          throw paramView;
        }
        localb.S((h)paramView);
        AppMethodBeat.o(110162);
        return;
      }
    }
    AppMethodBeat.o(110162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d.c
 * JD-Core Version:    0.7.0.1
 */