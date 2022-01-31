package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$14
  implements MMSlideDelView.f
{
  SnsMsgUI$14(SnsMsgUI paramSnsMsgUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(39080);
    if (paramObject == null)
    {
      ab.e("MicroMsg.SnsMsgUI", "onItemDel object null");
      AppMethodBeat.o(39080);
      return;
    }
    try
    {
      int i = bo.apV(paramObject.toString());
      SnsMsgUI.a(this.rSU, i);
      AppMethodBeat.o(39080);
      return;
    }
    catch (Exception paramObject)
    {
      ab.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
      ab.printErrStackTrace("MicroMsg.SnsMsgUI", paramObject, "", new Object[0]);
      AppMethodBeat.o(39080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.14
 * JD-Core Version:    0.7.0.1
 */