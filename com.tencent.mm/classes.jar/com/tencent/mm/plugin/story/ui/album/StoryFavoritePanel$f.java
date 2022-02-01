package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAddHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "plugin-story_release"})
public final class StoryFavoritePanel$f
  extends RecyclerView.v
{
  ImageView kc;
  
  public StoryFavoritePanel$f(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119894);
    paramView = localObject.findViewById(2131308455);
    p.g(paramView, "itemView.findViewById(R.…y_album_fav_item_add_img)");
    this.kc = ((ImageView)paramView);
    AppMethodBeat.o(119894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.f
 * JD-Core Version:    0.7.0.1
 */