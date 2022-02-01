package com.tencent.mm.plugin.story.ui.album;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.h.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.a<b>
{
  public static final d.a Svf;
  private static final String TAG;
  kotlin.g.a.b<? super h, ah> SuX;
  final ArrayList<h> Svg;
  
  static
  {
    AppMethodBeat.i(119829);
    Svf = new d.a((byte)0);
    TAG = "MicroMsg.StoryAlbumItemAdapter";
    AppMethodBeat.o(119829);
  }
  
  public d()
  {
    AppMethodBeat.i(119828);
    this.Svg = new ArrayList();
    AppMethodBeat.o(119828);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(367281);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof h)))
    {
      paramd = paramd.SuX;
      if (paramd != null)
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
          AppMethodBeat.o(367281);
          throw paramd;
        }
        paramd.invoke((h)paramView);
      }
    }
    a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367281);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119826);
    int i = this.Svg.size();
    AppMethodBeat.o(119826);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    ImageView Svh;
    ImageView Svi;
    TextView noi;
    
    public b()
    {
      super();
      AppMethodBeat.i(119823);
      this$1 = localObject.findViewById(a.d.Sdl);
      s.s(d.this, "view.findViewById(R.id.album_story_item_media_img)");
      this.Svh = ((ImageView)d.this);
      this$1 = localObject.findViewById(a.d.Sdm);
      s.s(d.this, "view.findViewById(R.id.a…_story_item_multiple_tip)");
      this.Svi = ((ImageView)d.this);
      this$1 = localObject.findViewById(a.d.Sdh);
      s.s(d.this, "view.findViewById(R.id.album_story_item_count_tv)");
      this.noi = ((TextView)d.this);
      AppMethodBeat.o(119823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d
 * JD-Core Version:    0.7.0.1
 */