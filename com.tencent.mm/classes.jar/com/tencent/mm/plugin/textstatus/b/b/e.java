package com.tencent.mm.plugin.textstatus.b.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.b.d;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/ReferenceItem;", "reportScene", "", "longClickCallback", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "(JLkotlin/jvm/functions/Function3;)V", "getLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "getReportScene", "()J", "setReportScene", "(J)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<d>
{
  public static final e.a MAC;
  long MAv;
  q<? super View, ? super Integer, ? super Long, Boolean> MAw;
  
  static
  {
    AppMethodBeat.i(235650);
    MAC = new e.a((byte)0);
    AppMethodBeat.o(235650);
  }
  
  public e(long paramLong, q<? super View, ? super Integer, ? super Long, Boolean> paramq)
  {
    this.MAv = paramLong;
    this.MAw = paramq;
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(235639);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(235639);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.e
 * JD-Core Version:    0.7.0.1
 */