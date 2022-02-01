package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "datas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getDatas", "()Ljava/util/ArrayList;", "setDatas", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "username", "", "isReply", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateDatas", "newDatas", "", "StoryHeaderTipHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends RecyclerView.a<a>
{
  public m<? super String, ? super Boolean, ah> EUi;
  public ArrayList<l.d> SuC;
  
  private j(ArrayList<l.d> paramArrayList)
  {
    AppMethodBeat.i(119779);
    this.SuC = paramArrayList;
    AppMethodBeat.o(119779);
  }
  
  private static final void a(j paramj, String paramString, View paramView)
  {
    AppMethodBeat.i(367342);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.api.IStoryStateFetcher.StoryFetcherItemEntity");
      AppMethodBeat.o(367342);
      throw paramj;
    }
    boolean bool = ((l.d)paramView).hvb();
    paramj = paramj.EUi;
    if (paramj != null)
    {
      s.s(paramString, "username");
      paramj.invoke(paramString, Boolean.valueOf(bool));
    }
    a.a(new Object(), "com/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367342);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119777);
    int i = this.SuC.size();
    AppMethodBeat.o(119777);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;Landroid/view/View;)V", "avatarItem", "Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "getAvatarItem", "()Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    final StoryAvatarItemView SuD;
    
    public a()
    {
      super();
      AppMethodBeat.i(119774);
      this$1 = localObject.findViewById(a.d.SfF);
      s.s(j.this, "itemView.findViewById(R.…ory_header_tip_item_view)");
      this.SuD = ((StoryAvatarItemView)j.this);
      AppMethodBeat.o(119774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.j
 * JD-Core Version:    0.7.0.1
 */