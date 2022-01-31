package com.tencent.mm.plugin.nearby.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class NearbySayHiListUI$9
  implements MMSlideDelView.f
{
  NearbySayHiListUI$9(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(55503);
    if (paramObject == null)
    {
      ab.e("MicroMsg.SayHiListUI", "onItemDel object null");
      AppMethodBeat.o(55503);
      return;
    }
    g.RJ().QQ();
    ((j)g.E(j.class)).bPN().Te(paramObject.toString());
    NearbySayHiListUI.b(this.pdR).a(null, null);
    AppMethodBeat.o(55503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.9
 * JD-Core Version:    0.7.0.1
 */