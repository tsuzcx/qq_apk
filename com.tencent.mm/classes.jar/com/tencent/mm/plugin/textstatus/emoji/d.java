package com.tencent.mm.plugin.textstatus.emoji;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroidx/recyclerview/widget/RecyclerView;", "getContentRv", "()Landroidx/recyclerview/widget/RecyclerView;", "exceptionTipRl", "Landroid/widget/LinearLayout;", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "rootSv", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView;", "getRootSv", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView;", "subType", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "plugin-textstatus_release"})
public final class d
  extends RecyclerView.v
{
  final RecyclerView Dwa;
  final TextStatusEmojiGridScrollView MAV;
  LinearLayout MAW;
  f MAX;
  final a MAY;
  
  public d(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(232620);
    this.MAY = parama;
    parama = paramView.findViewById(b.e.root_view);
    p.j(parama, "itemView.findViewById(R.id.root_view)");
    this.MAV = ((TextStatusEmojiGridScrollView)parama);
    parama = paramView.findViewById(b.e.root);
    p.j(parama, "itemView.findViewById(R.id.root)");
    this.Dwa = ((RecyclerView)parama);
    paramView = paramView.findViewById(b.e.emoji_exception_tip_rl);
    p.j(paramView, "itemView.findViewById(R.id.emoji_exception_tip_rl)");
    this.MAW = ((LinearLayout)paramView);
    AppMethodBeat.o(232620);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "onScrollChange"})
  static final class a
    implements NestedScrollView.b
  {
    a(d paramd) {}
    
    public final void a(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(238051);
      p.k(paramNestedScrollView, "nestedScrollView");
      Log.d("WxIme.ImeEmojiContentAdapter", "scrollX:" + paramInt1 + " scrollY:" + paramInt2 + " oldScrollX:" + paramInt3 + " oldScrollY:" + paramInt4);
      paramNestedScrollView = this.MAZ.Dwa.getLayoutManager();
      if (paramNestedScrollView == null)
      {
        paramNestedScrollView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiLayoutManager");
        AppMethodBeat.o(238051);
        throw paramNestedScrollView;
      }
      ((TextStatusEmojiLayoutManager)paramNestedScrollView).aji(paramInt2);
      AppMethodBeat.o(238051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.d
 * JD-Core Version:    0.7.0.1
 */