package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
public final class d$b
  extends RecyclerView.w
{
  TextView gIx;
  ImageView zFf;
  ImageView zFg;
  
  public d$b(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(119823);
    paramView = localObject.findViewById(2131296614);
    k.g(paramView, "view.findViewById(R.id.album_story_item_media_img)");
    this.zFf = ((ImageView)paramView);
    paramView = localObject.findViewById(2131296615);
    k.g(paramView, "view.findViewById(R.id.a…_story_item_multiple_tip)");
    this.zFg = ((ImageView)paramView);
    paramView = localObject.findViewById(2131296608);
    k.g(paramView, "view.findViewById(R.id.album_story_item_count_tv)");
    this.gIx = ((TextView)paramView);
    AppMethodBeat.o(119823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d.b
 * JD-Core Version:    0.7.0.1
 */