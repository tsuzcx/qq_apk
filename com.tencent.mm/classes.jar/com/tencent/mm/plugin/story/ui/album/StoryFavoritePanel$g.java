package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteNormalHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "setDateTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFavoritePanel$g
  extends RecyclerView.v
{
  ImageView Svh;
  private TextView pIJ;
  
  public StoryFavoritePanel$g(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119895);
    paramView = localObject.findViewById(a.d.SdU);
    s.s(paramView, "itemView.findViewById(R.…lbum_fav_item_normal_img)");
    this.Svh = ((ImageView)paramView);
    paramView = localObject.findViewById(a.d.SdV);
    s.s(paramView, "itemView.findViewById(R.…album_fav_item_normal_tv)");
    this.pIJ = ((TextView)paramView);
    AppMethodBeat.o(119895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.g
 * JD-Core Version:    0.7.0.1
 */