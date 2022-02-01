package com.tencent.mm.plugin.wallet.wecoin.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.ui.b.a;
import com.tencent.mm.plugin.wallet.wecoin.model.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class a$l
  implements b.a
{
  a$l(a parama) {}
  
  public final void gId()
  {
    AppMethodBeat.i(274189);
    if (!a.c(this.OGh))
    {
      a.d(this.OGh).amu(2);
      Object localObject = a.d(this.OGh).OEW;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject).OEH;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).p(3, -3, "");
          AppMethodBeat.o(274189);
          return;
        }
      }
    }
    AppMethodBeat.o(274189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a.l
 * JD-Core Version:    0.7.0.1
 */