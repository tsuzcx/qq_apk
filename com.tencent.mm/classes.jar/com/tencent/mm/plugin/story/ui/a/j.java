package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.l.d;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter$StoryHeaderTipHolder;", "datas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getDatas", "()Ljava/util/ArrayList;", "setDatas", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "username", "", "isReply", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateDatas", "newDatas", "", "StoryHeaderTipHolder", "plugin-story_release"})
public final class j
  extends RecyclerView.a<j.a>
{
  public m<? super String, ? super Boolean, y> zEx;
  public ArrayList<l.d> zEy;
  
  private j(ArrayList<l.d> paramArrayList)
  {
    AppMethodBeat.i(119779);
    this.zEy = paramArrayList;
    AppMethodBeat.o(119779);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119777);
    int i = this.zEy.size();
    AppMethodBeat.o(119777);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(j paramj, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119775);
      k.g(paramView, "it");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.api.IStoryStateFetcher.StoryFetcherItemEntity");
        AppMethodBeat.o(119775);
        throw paramView;
      }
      boolean bool = ((l.d)paramView).dUR();
      paramView = this.zEA.zEx;
      if (paramView != null)
      {
        String str = this.gxu;
        k.g(str, "username");
        paramView.n(str, Boolean.valueOf(bool));
        AppMethodBeat.o(119775);
        return;
      }
      AppMethodBeat.o(119775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.j
 * JD-Core Version:    0.7.0.1
 */