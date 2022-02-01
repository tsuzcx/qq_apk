package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.i.h;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"})
public final class d
  extends RecyclerView.a<b>
{
  public static final a LST;
  private static final String TAG = "MicroMsg.StoryAlbumItemAdapter";
  b<? super h, x> LSI;
  final ArrayList<h> LSS;
  
  static
  {
    AppMethodBeat.i(119829);
    LST = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumItemAdapter";
    AppMethodBeat.o(119829);
  }
  
  public d()
  {
    AppMethodBeat.i(119828);
    this.LSS = new ArrayList();
    AppMethodBeat.o(119828);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119826);
    int i = this.LSS.size();
    AppMethodBeat.o(119826);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView LSU;
    ImageView LSV;
    TextView kMp;
    
    public b()
    {
      super();
      AppMethodBeat.i(119823);
      this$1 = localObject.findViewById(a.d.Lzy);
      p.j(d.this, "view.findViewById(R.id.album_story_item_media_img)");
      this.LSU = ((ImageView)d.this);
      this$1 = localObject.findViewById(a.d.Lzz);
      p.j(d.this, "view.findViewById(R.id.a…_story_item_multiple_tip)");
      this.LSV = ((ImageView)d.this);
      this$1 = localObject.findViewById(a.d.Lzu);
      p.j(d.this, "view.findViewById(R.id.album_story_item_count_tv)");
      this.kMp = ((TextView)d.this);
      AppMethodBeat.o(119823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d
 * JD-Core Version:    0.7.0.1
 */