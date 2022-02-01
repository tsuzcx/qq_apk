package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$13
  implements MMSlideDelView.f
{
  SnsMsgUI$13(SnsMsgUI paramSnsMsgUI) {}
  
  public final void es(Object paramObject)
  {
    AppMethodBeat.i(308507);
    if (paramObject == null)
    {
      Log.e("MicroMsg.SnsMsgUI", "onItemDel object null");
      AppMethodBeat.o(308507);
      return;
    }
    try
    {
      int i = Util.safeParseInt(paramObject.toString());
      SnsMsgUI.a(this.RtY, i);
      AppMethodBeat.o(308507);
      return;
    }
    catch (Exception paramObject)
    {
      Log.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
      Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramObject, "", new Object[0]);
      AppMethodBeat.o(308507);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.13
 * JD-Core Version:    0.7.0.1
 */