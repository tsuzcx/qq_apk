package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
public final class d$b
  extends RecyclerView.v
{
  TextView nUz;
  ImageView sJg;
  ImageView sJh;
  
  public d$b(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110161);
    paramView = localObject.findViewById(2131828247);
    j.p(paramView, "view.findViewById(R.id.album_story_item_media_img)");
    this.sJg = ((ImageView)paramView);
    paramView = localObject.findViewById(2131828248);
    j.p(paramView, "view.findViewById(R.id.a…_story_item_multiple_tip)");
    this.sJh = ((ImageView)paramView);
    paramView = localObject.findViewById(2131828249);
    j.p(paramView, "view.findViewById(R.id.album_story_item_count_tv)");
    this.nUz = ((TextView)paramView);
    AppMethodBeat.o(110161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d.b
 * JD-Core Version:    0.7.0.1
 */