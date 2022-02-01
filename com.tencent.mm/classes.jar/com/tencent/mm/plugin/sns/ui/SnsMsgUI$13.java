package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$13
  implements MMSlideDelView.f
{
  SnsMsgUI$13(SnsMsgUI paramSnsMsgUI) {}
  
  public final void cQ(Object paramObject)
  {
    AppMethodBeat.i(219907);
    if (paramObject == null)
    {
      ae.e("MicroMsg.SnsMsgUI", "onItemDel object null");
      AppMethodBeat.o(219907);
      return;
    }
    try
    {
      int i = bu.aSB(paramObject.toString());
      SnsMsgUI.a(this.AwR, i);
      AppMethodBeat.o(219907);
      return;
    }
    catch (Exception paramObject)
    {
      ae.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
      ae.printErrStackTrace("MicroMsg.SnsMsgUI", paramObject, "", new Object[0]);
      AppMethodBeat.o(219907);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.13
 * JD-Core Version:    0.7.0.1
 */