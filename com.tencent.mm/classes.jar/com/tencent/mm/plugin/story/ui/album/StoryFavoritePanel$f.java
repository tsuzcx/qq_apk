package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAddHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "plugin-story_release"})
public final class StoryFavoritePanel$f
  extends RecyclerView.v
{
  ImageView iTH;
  
  public StoryFavoritePanel$f(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110204);
    paramView = localObject.findViewById(2131828226);
    j.p(paramView, "itemView.findViewById(R.…y_album_fav_item_add_img)");
    this.iTH = ((ImageView)paramView);
    AppMethodBeat.o(110204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.f
 * JD-Core Version:    0.7.0.1
 */