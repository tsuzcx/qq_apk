package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.proto.bn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroidx/recyclerview/widget/RecyclerView;", "getContentRv", "()Landroidx/recyclerview/widget/RecyclerView;", "exceptionTipRl", "Landroid/widget/LinearLayout;", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "rootSv", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView;", "getRootSv", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiGridScrollView;", "subType", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.v
{
  private final RecyclerView Jph;
  private final a TkC;
  private final TextStatusEmojiGridScrollView TkD;
  private LinearLayout TkE;
  private f TkF;
  
  public d(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(290796);
    this.TkC = parama;
    parama = paramView.findViewById(a.e.root_view);
    s.s(parama, "itemView.findViewById(R.id.root_view)");
    this.TkD = ((TextStatusEmojiGridScrollView)parama);
    parama = paramView.findViewById(a.e.root);
    s.s(parama, "itemView.findViewById(R.id.root)");
    this.Jph = ((RecyclerView)parama);
    paramView = paramView.findViewById(a.e.emoji_exception_tip_rl);
    s.s(paramView, "itemView.findViewById(R.id.emoji_exception_tip_rl)");
    this.TkE = ((LinearLayout)paramView);
    AppMethodBeat.o(290796);
  }
  
  private static final void a(d paramd, NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(290810);
    s.u(paramd, "this$0");
    s.u(paramNestedScrollView, "nestedScrollView");
    Log.d("WxIme.ImeEmojiContentAdapter", "scrollX:" + paramInt1 + " scrollY:" + paramInt2 + " oldScrollX:" + paramInt3 + " oldScrollY:" + paramInt4);
    paramd = paramd.Jph.getLayoutManager();
    if (paramd == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.emoji.TextStatusEmojiLayoutManager");
      AppMethodBeat.o(290810);
      throw paramd;
    }
    ((TextStatusEmojiLayoutManager)paramd).aoq(paramInt2);
    AppMethodBeat.o(290810);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(290834);
    s.u(paramContext, "context");
    s.u(paramf, "subTypeData");
    Log.d("WxIme.ImeEmojiContentAdapter", s.X("fillContent ", paramf.typeName));
    this.TkF = paramf;
    this.TkE.setVisibility(4);
    this.Jph.setLayoutManager((RecyclerView.LayoutManager)new TextStatusEmojiLayoutManager(paramContext));
    RecyclerView localRecyclerView = this.Jph;
    Object localObject = m.TkV;
    localObject = m.V(paramContext, "emoji", paramf.typeName).Trs;
    s.s(localObject, "TextStatusEmojiUtil.getA…a.typeName).emojiDataList");
    localRecyclerView.setAdapter((RecyclerView.a)new j(paramContext, (LinkedList)localObject, paramf.typeName, this.TkC));
    this.TkD.setOnScrollChangeListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(290834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.d
 * JD-Core Version:    0.7.0.1
 */