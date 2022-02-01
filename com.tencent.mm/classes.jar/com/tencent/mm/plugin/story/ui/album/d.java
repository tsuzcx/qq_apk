package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.h;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"})
public final class d
  extends RecyclerView.a<b>
{
  public static final d.a AWD;
  private static final String TAG = "MicroMsg.StoryAlbumItemAdapter";
  final ArrayList<h> AWC;
  b<? super h, z> AWs;
  
  static
  {
    AppMethodBeat.i(119829);
    AWD = new d.a((byte)0);
    TAG = "MicroMsg.StoryAlbumItemAdapter";
    AppMethodBeat.o(119829);
  }
  
  public d()
  {
    AppMethodBeat.i(119828);
    this.AWC = new ArrayList();
    AppMethodBeat.o(119828);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119826);
    int i = this.AWC.size();
    AppMethodBeat.o(119826);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends RecyclerView.w
  {
    ImageView AWE;
    ImageView AWF;
    TextView hch;
    
    public b()
    {
      super();
      AppMethodBeat.i(119823);
      this$1 = localObject.findViewById(2131296614);
      p.g(d.this, "view.findViewById(R.id.album_story_item_media_img)");
      this.AWE = ((ImageView)d.this);
      this$1 = localObject.findViewById(2131296615);
      p.g(d.this, "view.findViewById(R.id.a…_story_item_multiple_tip)");
      this.AWF = ((ImageView)d.this);
      this$1 = localObject.findViewById(2131296608);
      p.g(d.this, "view.findViewById(R.id.album_story_item_count_tv)");
      this.hch = ((TextView)d.this);
      AppMethodBeat.o(119823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d
 * JD-Core Version:    0.7.0.1
 */