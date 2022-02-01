package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "datas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getDatas", "()Ljava/util/ArrayList;", "setDatas", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "username", "", "isReply", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateDatas", "newDatas", "", "StoryHeaderTipHolder", "plugin-story_release"})
public final class j
  extends RecyclerView.a<a>
{
  public m<? super String, ? super Boolean, x> LSm;
  public ArrayList<l.d> LSn;
  
  private j(ArrayList<l.d> paramArrayList)
  {
    AppMethodBeat.i(119779);
    this.LSn = paramArrayList;
    AppMethodBeat.o(119779);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119777);
    int i = this.LSn.size();
    AppMethodBeat.o(119777);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;Landroid/view/View;)V", "avatarItem", "Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "getAvatarItem", "()Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final StoryAvatarItemView LSo;
    
    public a()
    {
      super();
      AppMethodBeat.i(119774);
      this$1 = localObject.findViewById(a.d.LBU);
      p.j(j.this, "itemView.findViewById(R.…ory_header_tip_item_view)");
      this.LSo = ((StoryAvatarItemView)j.this);
      AppMethodBeat.o(119774);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(j paramj, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119775);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      p.j(paramView, "it");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.api.IStoryStateFetcher.StoryFetcherItemEntity");
        AppMethodBeat.o(119775);
        throw paramView;
      }
      boolean bool = ((l.d)paramView).gbI();
      paramView = this.LSp.LSm;
      if (paramView != null)
      {
        localObject = this.kyF;
        p.j(localObject, "username");
        paramView.invoke(localObject, Boolean.valueOf(bool));
      }
      a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.j
 * JD-Core Version:    0.7.0.1
 */