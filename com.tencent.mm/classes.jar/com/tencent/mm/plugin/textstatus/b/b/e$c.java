package com.tencent.mm.plugin.textstatus.b.b;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class e$c
  implements View.OnLongClickListener
{
  e$c(e parame, i parami, int paramInt) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(237307);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert$onBindViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
    paramView = this.MAD.MAw;
    if (paramView != null)
    {
      localObject = this.tDl.amk;
      p.j(localObject, "holder.itemView");
      paramView.c(localObject, Integer.valueOf(this.jEN), Long.valueOf(0L));
    }
    a.a(true, this, "com/tencent/mm/plugin/textstatus/convert/like/ReferenceItemConvert$onBindViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(237307);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.e.c
 * JD-Core Version:    0.7.0.1
 */