package com.tencent.mm.plugin.shake.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class ShakeSayHiListUI$6
  implements MMSlideDelView.f
{
  ShakeSayHiListUI$6(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(24879);
    if (paramObject == null)
    {
      ab.e("MicroMsg.SayHiListUI", "onItemDel object null");
      AppMethodBeat.o(24879);
      return;
    }
    d.alk().Te(paramObject.toString());
    ShakeSayHiListUI.b(this.qRC).a(null, null);
    AppMethodBeat.o(24879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.6
 * JD-Core Version:    0.7.0.1
 */