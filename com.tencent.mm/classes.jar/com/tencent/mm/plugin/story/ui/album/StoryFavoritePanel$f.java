package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAddHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFavoritePanel$f
  extends RecyclerView.v
{
  ImageView dpM;
  
  public StoryFavoritePanel$f(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119894);
    paramView = localObject.findViewById(a.d.SdT);
    s.s(paramView, "itemView.findViewById(R.…y_album_fav_item_add_img)");
    this.dpM = ((ImageView)paramView);
    AppMethodBeat.o(119894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.f
 * JD-Core Version:    0.7.0.1
 */