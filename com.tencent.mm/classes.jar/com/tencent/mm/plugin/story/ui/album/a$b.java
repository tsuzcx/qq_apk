package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
public final class a$b
  extends a.e
{
  public a$b(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(110142);
    AppMethodBeat.o(110142);
  }
  
  public final void Ge(int paramInt)
  {
    AppMethodBeat.i(110141);
    this.aku.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(110141);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138861);
      paramView = this.sIX.sIW.sIU;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(138861);
        return;
      }
      AppMethodBeat.o(138861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a.b
 * JD-Core Version:    0.7.0.1
 */