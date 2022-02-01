package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.h;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"})
public final class d
  extends RecyclerView.a<b>
{
  private static final String TAG = "MicroMsg.StoryAlbumItemAdapter";
  public static final a yrH;
  final ArrayList<h> yrG;
  b<? super h, y> yrw;
  
  static
  {
    AppMethodBeat.i(119829);
    yrH = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumItemAdapter";
    AppMethodBeat.o(119829);
  }
  
  public d()
  {
    AppMethodBeat.i(119828);
    this.yrG = new ArrayList();
    AppMethodBeat.o(119828);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119826);
    int i = this.yrG.size();
    AppMethodBeat.o(119826);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends RecyclerView.v
  {
    TextView sIt;
    ImageView yrI;
    ImageView yrJ;
    
    public b()
    {
      super();
      AppMethodBeat.i(119823);
      this$1 = localObject.findViewById(2131296614);
      k.g(d.this, "view.findViewById(R.id.album_story_item_media_img)");
      this.yrI = ((ImageView)d.this);
      this$1 = localObject.findViewById(2131296615);
      k.g(d.this, "view.findViewById(R.id.a…_story_item_multiple_tip)");
      this.yrJ = ((ImageView)d.this);
      this$1 = localObject.findViewById(2131296608);
      k.g(d.this, "view.findViewById(R.id.album_story_item_count_tv)");
      this.sIt = ((TextView)d.this);
      AppMethodBeat.o(119823);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119824);
      k.g(paramView, "view");
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof h)))
      {
        b localb = this.yrK.yrw;
        if (localb != null)
        {
          paramView = paramView.getTag();
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
            AppMethodBeat.o(119824);
            throw paramView;
          }
          localb.aA((h)paramView);
          AppMethodBeat.o(119824);
          return;
        }
      }
      AppMethodBeat.o(119824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.d
 * JD-Core Version:    0.7.0.1
 */