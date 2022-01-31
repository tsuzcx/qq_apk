package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.base.model.b;

final class NewBizInfoSettingUI$7
  implements Runnable
{
  NewBizInfoSettingUI$7(NewBizInfoSettingUI paramNewBizInfoSettingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(23919);
    if (this.pDY.isFinishing())
    {
      AppMethodBeat.o(23919);
      return;
    }
    b.Y(this.pDY, NewBizInfoSettingUI.a(this.pDY).field_username);
    b.x(this.pDY);
    AppMethodBeat.o(23919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.7
 * JD-Core Version:    0.7.0.1
 */