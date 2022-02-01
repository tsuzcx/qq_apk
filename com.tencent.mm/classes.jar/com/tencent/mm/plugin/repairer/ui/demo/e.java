package com.tencent.mm.plugin.repairer.ui.demo;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoConvert1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem1;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f<l>
{
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(278102);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/DemoConvert1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "$item");
    paraml.OwP.gW(cn.bDw());
    paramView = v.gNl();
    if (paramView != null) {
      g.a((g)paramView, (IAutoDBItem)paraml.OwP);
    }
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/DemoConvert1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278102);
  }
  
  private static final void b(l paraml, View paramView)
  {
    AppMethodBeat.i(278114);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/DemoConvert1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "$item");
    paramView = v.gNl();
    if (paramView != null) {
      g.b((g)paramView, (IAutoDBItem)paraml.OwP, false, false, 6);
    }
    a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/DemoConvert1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278114);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(278146);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(278146);
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.e
 * JD-Core Version:    0.7.0.1
 */