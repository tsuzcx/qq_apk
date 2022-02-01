package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class a$i
  implements o.f
{
  a$i(a parama, e parame) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(237359);
    this.nkZ.setFooterView(null);
    paramm.clear();
    Context localContext;
    if (a.b(this.BSH))
    {
      localContext = this.BSH.parent.getContext();
      p.g(localContext, "parent.context");
      paramm.d(0, (CharSequence)localContext.getResources().getString(2131758460));
    }
    if (a.c(this.BSH))
    {
      localContext = this.BSH.parent.getContext();
      p.g(localContext, "parent.context");
      paramm.d(2, (CharSequence)localContext.getResources().getString(2131758461));
    }
    if (a.d(this.BSH))
    {
      localContext = this.BSH.parent.getContext();
      p.g(localContext, "parent.context");
      paramm.d(1, (CharSequence)localContext.getResources().getString(2131758462));
    }
    AppMethodBeat.o(237359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.i
 * JD-Core Version:    0.7.0.1
 */