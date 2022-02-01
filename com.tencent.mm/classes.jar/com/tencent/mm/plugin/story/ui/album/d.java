package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.h;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"})
public final class d
  extends RecyclerView.a<b>
{
  public static final a FyR;
  private static final String TAG = "MicroMsg.StoryAlbumItemAdapter";
  b<? super h, x> FyG;
  final ArrayList<h> FyQ;
  
  static
  {
    AppMethodBeat.i(119829);
    FyR = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumItemAdapter";
    AppMethodBeat.o(119829);
  }
  
  public d()
  {
    AppMethodBeat.i(119828);
    this.FyQ = new ArrayList();
    AppMethodBeat.o(119828);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119826);
    int i = this.FyQ.size();
    AppMethodBeat.o(119826);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView FyS;
    ImageView FyT;
    TextView hXK;
    
    public b()
    {
      super();
      AppMethodBeat.i(119823);
      this$1 = localObject.findViewById(2131296691);
      p.g(d.this, "view.findViewById(R.id.album_story_item_media_img)");
      this.FyS = ((ImageView)d.this);
      this$1 = localObject.findViewById(2131296692);
      p.g(d.this, "view.findViewById(R.id.a…_story_item_multiple_tip)");
      this.FyT = ((ImageView)d.this);
      this$1 = localObject.findViewById(2131296685);
      p.g(d.this, "view.findViewById(R.id.album_story_item_count_tv)");
      this.hXK = ((TextView)d.this);
      AppMethodBeat.o(119823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d
 * JD-Core Version:    0.7.0.1
 */