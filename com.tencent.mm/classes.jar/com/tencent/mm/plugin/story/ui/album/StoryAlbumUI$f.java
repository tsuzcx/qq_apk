package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryAlbumUI$f
  implements View.OnClickListener
{
  StoryAlbumUI$f(StoryAlbumUI paramStoryAlbumUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119834);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    StoryAlbumUI.b(this.AWQ);
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI.f
 * JD-Core Version:    0.7.0.1
 */