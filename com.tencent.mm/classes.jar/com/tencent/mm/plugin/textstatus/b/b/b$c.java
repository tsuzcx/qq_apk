package com.tencent.mm.plugin.textstatus.b.b;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class b$c
  implements View.OnLongClickListener
{
  b$c(b paramb, i parami, int paramInt) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(232469);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = this.MAy.MAw;
    if (paramView != null)
    {
      localObject = this.tDl.amk;
      p.j(localObject, "holder.itemView");
      paramView.c(localObject, Integer.valueOf(this.jEN), Long.valueOf(0L));
    }
    a.a(true, this, "com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(232469);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b.b.c
 * JD-Core Version:    0.7.0.1
 */