package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryAlbumLoadingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFavoritePanel$b
  extends RecyclerView.v
{
  ViewGroup Sva;
  ImageView Svb;
  
  public StoryFavoritePanel$b(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119881);
    paramView = localObject.findViewById(a.d.loading_more_state);
    s.s(paramView, "view.findViewById(R.id.loading_more_state)");
    this.Sva = ((ViewGroup)paramView);
    paramView = localObject.findViewById(a.d.Sdf);
    s.s(paramView, "view.findViewById(R.id.album_is_all_view)");
    this.Svb = ((ImageView)paramView);
    AppMethodBeat.o(119881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.b
 * JD-Core Version:    0.7.0.1
 */