package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavSelectHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "checkIcon", "Landroid/widget/CheckBox;", "getCheckIcon", "()Landroid/widget/CheckBox;", "setCheckIcon", "(Landroid/widget/CheckBox;)V", "clickArea", "getClickArea", "()Landroid/view/View;", "setClickArea", "(Landroid/view/View;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "mask", "getMask", "setMask", "plugin-story_release"})
public final class StoryFavoritePanel$d
  extends RecyclerView.v
{
  View jYu;
  ImageView mCA;
  CheckBox sJU;
  ImageView sJg;
  
  public StoryFavoritePanel$d(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(151144);
    paramView = this.aku.findViewById(2131828232);
    j.p(paramView, "itemView.findViewById(R.…album_fav_select_item_iv)");
    this.sJg = ((ImageView)paramView);
    paramView = this.aku.findViewById(2131828235);
    j.p(paramView, "itemView.findViewById(R.…fav_select_item_check_iv)");
    this.sJU = ((CheckBox)paramView);
    paramView = this.aku.findViewById(2131828233);
    j.p(paramView, "itemView.findViewById(R.…_select_item_normal_mask)");
    this.mCA = ((ImageView)paramView);
    paramView = this.aku.findViewById(2131828234);
    j.p(paramView, "itemView.findViewById(R.…v_select_item_check_area)");
    this.jYu = paramView;
    AppMethodBeat.o(151144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.d
 * JD-Core Version:    0.7.0.1
 */