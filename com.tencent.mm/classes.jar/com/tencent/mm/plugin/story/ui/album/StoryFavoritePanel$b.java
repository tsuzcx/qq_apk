package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryAlbumLoadingHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "plugin-story_release"})
public final class StoryFavoritePanel$b
  extends RecyclerView.v
{
  ViewGroup sIY;
  ImageView sIZ;
  
  public StoryFavoritePanel$b(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(138883);
    paramView = localObject.findViewById(2131822311);
    j.p(paramView, "view.findViewById(R.id.loading_more_state)");
    this.sIY = ((ViewGroup)paramView);
    paramView = localObject.findViewById(2131828246);
    j.p(paramView, "view.findViewById(R.id.album_is_all_view)");
    this.sIZ = ((ImageView)paramView);
    AppMethodBeat.o(138883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.b
 * JD-Core Version:    0.7.0.1
 */