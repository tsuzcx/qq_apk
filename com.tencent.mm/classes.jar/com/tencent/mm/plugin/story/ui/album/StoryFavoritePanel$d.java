package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavSelectHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "checkIcon", "Landroid/widget/CheckBox;", "getCheckIcon", "()Landroid/widget/CheckBox;", "setCheckIcon", "(Landroid/widget/CheckBox;)V", "clickArea", "getClickArea", "()Landroid/view/View;", "setClickArea", "(Landroid/view/View;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "mask", "getMask", "setMask", "plugin-story_release"})
public final class StoryFavoritePanel$d
  extends RecyclerView.w
{
  View nDl;
  ImageView qSK;
  CheckBox zFS;
  ImageView zFf;
  
  public StoryFavoritePanel$d(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119883);
    paramView = this.asD.findViewById(2131305258);
    k.g(paramView, "itemView.findViewById(R.…album_fav_select_item_iv)");
    this.zFf = ((ImageView)paramView);
    paramView = this.asD.findViewById(2131305257);
    k.g(paramView, "itemView.findViewById(R.…fav_select_item_check_iv)");
    this.zFS = ((CheckBox)paramView);
    paramView = this.asD.findViewById(2131305259);
    k.g(paramView, "itemView.findViewById(R.…_select_item_normal_mask)");
    this.qSK = ((ImageView)paramView);
    paramView = this.asD.findViewById(2131305256);
    k.g(paramView, "itemView.findViewById(R.…v_select_item_check_area)");
    this.nDl = paramView;
    AppMethodBeat.o(119883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.d
 * JD-Core Version:    0.7.0.1
 */