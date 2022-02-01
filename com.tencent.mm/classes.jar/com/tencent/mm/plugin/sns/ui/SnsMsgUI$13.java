package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$13
  implements MMSlideDelView.f
{
  SnsMsgUI$13(SnsMsgUI paramSnsMsgUI) {}
  
  public final void cP(Object paramObject)
  {
    AppMethodBeat.i(198369);
    if (paramObject == null)
    {
      ad.e("MicroMsg.SnsMsgUI", "onItemDel object null");
      AppMethodBeat.o(198369);
      return;
    }
    try
    {
      int i = bt.aRe(paramObject.toString());
      SnsMsgUI.a(this.AfF, i);
      AppMethodBeat.o(198369);
      return;
    }
    catch (Exception paramObject)
    {
      ad.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
      ad.printErrStackTrace("MicroMsg.SnsMsgUI", paramObject, "", new Object[0]);
      AppMethodBeat.o(198369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.13
 * JD-Core Version:    0.7.0.1
 */