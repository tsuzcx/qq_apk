package com.tencent.mm.plugin.textstatus.b.d;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "limitTopicId", "", "clickPosListener", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$OnClickPosListener;", "sameFriendPageSource", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$OnClickPosListener;I)V", "getClickPosListener", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$OnClickPosListener;", "getLimitTopicId", "()Ljava/lang/String;", "setLimitTopicId", "(Ljava/lang/String;)V", "getSameFriendPageSource", "()I", "setSameFriendPageSource", "(I)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class b
  extends e<com.tencent.mm.plugin.textstatus.g.f.b>
{
  public static final b.a MAS;
  final TextStatusSameTopicsActivity.b MAR;
  private String MzN;
  private int MzO;
  
  static
  {
    AppMethodBeat.i(233407);
    MAS = new b.a((byte)0);
    AppMethodBeat.o(233407);
  }
  
  public b(String paramString, TextStatusSameTopicsActivity.b paramb, int paramInt)
  {
    AppMethodBeat.i(233406);
    this.MzN = paramString;
    this.MAR = paramb;
    this.MzO = paramInt;
    AppMethodBeat.o(233406);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(233404);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    Object localObject = parami.amk;
    if (localObject == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(233404);
      throw paramRecyclerView;
    }
    localObject = (RelativeLayout)localObject;
    r localr = r.gkV();
    localr.gkX().bek(this.MzN).ajg(this.MzO);
    paramRecyclerView = ((d)com.tencent.mm.kernel.h.ag(d.class)).getStatusCardView(paramRecyclerView.getContext(), localr);
    p.j(paramRecyclerView, "cardView");
    ((RelativeLayout)localObject).addView(paramRecyclerView.getView());
    parami.setTag(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getView();
    p.j(paramRecyclerView, "cardView.view");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(233404);
      throw paramRecyclerView;
    }
    ((RelativeLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(233404);
  }
  
  public final int getLayoutId()
  {
    return b.f.Mye;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237241);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/textstatus/convert/topic/SameTopicItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.MAT.MAR.ajn(this.jEN);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/topic/SameTopicItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.d.b
 * JD-Core Version:    0.7.0.1
 */