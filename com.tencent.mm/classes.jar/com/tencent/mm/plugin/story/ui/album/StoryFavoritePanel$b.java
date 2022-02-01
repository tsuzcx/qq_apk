package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryAlbumLoadingHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "plugin-story_release"})
public final class StoryFavoritePanel$b
  extends RecyclerView.v
{
  ViewGroup yrB;
  ImageView yrC;
  
  public StoryFavoritePanel$b(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119881);
    paramView = localObject.findViewById(2131301504);
    k.g(paramView, "view.findViewById(R.id.loading_more_state)");
    this.yrB = ((ViewGroup)paramView);
    paramView = localObject.findViewById(2131296584);
    k.g(paramView, "view.findViewById(R.id.album_is_all_view)");
    this.yrC = ((ImageView)paramView);
    AppMethodBeat.o(119881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.b
 * JD-Core Version:    0.7.0.1
 */