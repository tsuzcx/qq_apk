package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteNormalHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "setDateTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "plugin-story_release"})
public final class StoryFavoritePanel$g
  extends RecyclerView.v
{
  private TextView gpp;
  ImageView sJg;
  
  public StoryFavoritePanel$g(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110205);
    paramView = localObject.findViewById(2131828228);
    j.p(paramView, "itemView.findViewById(R.…lbum_fav_item_normal_img)");
    this.sJg = ((ImageView)paramView);
    paramView = localObject.findViewById(2131828229);
    j.p(paramView, "itemView.findViewById(R.…album_fav_item_normal_tv)");
    this.gpp = ((TextView)paramView);
    AppMethodBeat.o(110205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.g
 * JD-Core Version:    0.7.0.1
 */