package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$14
  implements MMSlideDelView.f
{
  SnsMsgUI$14(SnsMsgUI paramSnsMsgUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.SnsMsgUI", "onItemDel object null");
      return;
    }
    try
    {
      int i = bk.ZR(paramObject.toString());
      SnsMsgUI.a(this.paq, i);
      return;
    }
    catch (Exception paramObject)
    {
      y.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
      y.printErrStackTrace("MicroMsg.SnsMsgUI", paramObject, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.14
 * JD-Core Version:    0.7.0.1
 */