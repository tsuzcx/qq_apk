package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteNormalHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "setDateTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "plugin-story_release"})
public final class StoryFavoritePanel$g
  extends RecyclerView.v
{
  ImageView FyS;
  private TextView jUO;
  
  public StoryFavoritePanel$g(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119895);
    paramView = localObject.findViewById(2131308457);
    p.g(paramView, "itemView.findViewById(R.…lbum_fav_item_normal_img)");
    this.FyS = ((ImageView)paramView);
    paramView = localObject.findViewById(2131308458);
    p.g(paramView, "itemView.findViewById(R.…album_fav_item_normal_tv)");
    this.jUO = ((TextView)paramView);
    AppMethodBeat.o(119895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.g
 * JD-Core Version:    0.7.0.1
 */