package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusLikeListActivity$e$1
  implements View.OnClickListener
{
  TextStatusLikeListActivity$e$1(TextStatusLikeListActivity.e parame, WxRecyclerAdapter paramWxRecyclerAdapter, g.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216631);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    TextStatusLikeListActivity.e.a(this.GfB);
    g.b(this.uMv, this.GfC.lT());
    this.GfB.epE();
    paramView = com.tencent.mm.plugin.textstatus.k.a.UsD;
    com.tencent.mm.plugin.textstatus.k.a.Rk(11L);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.e.1
 * JD-Core Version:    0.7.0.1
 */