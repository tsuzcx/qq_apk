package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.story.i.h;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$c
  implements View.OnClickListener
{
  d$c(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119824);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    p.g(paramView, "view");
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof h)))
    {
      localObject = this.AWG.AWs;
      if (localObject != null)
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
          AppMethodBeat.o(119824);
          throw paramView;
        }
        ((d.g.a.b)localObject).invoke((h)paramView);
      }
    }
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d.c
 * JD-Core Version:    0.7.0.1
 */