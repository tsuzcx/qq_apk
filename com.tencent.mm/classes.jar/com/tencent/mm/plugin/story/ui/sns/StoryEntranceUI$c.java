package com.tencent.mm.plugin.story.ui.sns;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
public final class StoryEntranceUI$c
  extends RecyclerView.a<StoryEntranceUI.c.a>
{
  m<? super Integer, ? super StoryEntranceUI.b, y> sHB;
  final ArrayList<StoryEntranceUI.b> sKy;
  
  public StoryEntranceUI$c()
  {
    AppMethodBeat.i(110257);
    this.sKy = new ArrayList();
    AppMethodBeat.o(110257);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110253);
    int i = this.sKy.size();
    AppMethodBeat.o(110253);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(110255);
    paramInt = ((StoryEntranceUI.b)this.sKy.get(paramInt)).type;
    AppMethodBeat.o(110255);
    return paramInt;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
  public final class b
    extends StoryEntranceUI.c.a
  {
    private final TextView gMp;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(110249);
      this$1 = localObject.findViewById(2131821071);
      j.p(StoryEntranceUI.c.this, "itemView.findViewById(R.id.tip_tv)");
      this.gMp = ((TextView)StoryEntranceUI.c.this);
      localObject.setOnClickListener((View.OnClickListener)StoryEntranceUI.c.b.1.sKB);
      AppMethodBeat.o(110249);
    }
    
    public final void a(StoryEntranceUI.b paramb)
    {
      AppMethodBeat.i(110248);
      j.q(paramb, "data");
      this.gMp.setText(2131303968);
      AppMethodBeat.o(110248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c
 * JD-Core Version:    0.7.0.1
 */