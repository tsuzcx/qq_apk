package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.ContentValues;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ey;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ai;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.view.recyclerview.f<k>
{
  private static final void a(k paramk, View paramView)
  {
    AppMethodBeat.i(278125);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/DemoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramk, "$item");
    paramView = com.tencent.mm.plugin.ac.a.MnH;
    paramView = (p)((f)a.a.bW(f.class)).bV(p.class);
    localObject = new ContentValues();
    ((ContentValues)localObject).put("id", paramk.OwO.field_id);
    paramk = ah.aiuX;
    paramk = (s)paramView.a((ContentValues)localObject, ai.cz(s.class));
    if (paramk != null)
    {
      paramk.gW(cn.bDw());
      paramView = com.tencent.mm.plugin.ac.a.MnH;
      g.a(((f)a.a.bW(f.class)).bV(p.class), (IAutoDBItem)paramk);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/DemoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278125);
  }
  
  private static final void b(k paramk, View paramView)
  {
    AppMethodBeat.i(278138);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/DemoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramk, "$item");
    paramView = com.tencent.mm.plugin.ac.a.MnH;
    g.b(((f)a.a.bW(f.class)).bV(p.class), (IAutoDBItem)paramk.OwO, false, false, 6);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/DemoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278138);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(278161);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    AppMethodBeat.o(278161);
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.d
 * JD-Core Version:    0.7.0.1
 */