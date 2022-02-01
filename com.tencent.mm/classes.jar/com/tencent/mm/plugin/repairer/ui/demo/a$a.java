package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.ContentValues;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.p.d.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.ab;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$a
  implements View.OnClickListener
{
  a$a(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(227461);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/DemoConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = com.tencent.mm.plugin.p.d.EiT;
    paramView = (g)((b)d.a.bj(b.class)).bi(g.class);
    localObject = new ContentValues();
    ((ContentValues)localObject).put("id", this.Ixo.Ixp.field_id);
    paramView = (h)paramView.a((ContentValues)localObject, ab.bO(h.class));
    if (paramView != null)
    {
      paramView.field_timestamp = cm.bfE();
      localObject = com.tencent.mm.plugin.p.d.EiT;
      com.tencent.mm.plugin.p.h.a((g)((b)d.a.bj(b.class)).bi(g.class), (IAutoDBItem)paramView);
    }
    a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/DemoConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(227461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.a.a
 * JD-Core Version:    0.7.0.1
 */