package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;

final class NewBizInfoSettingUI$2
  implements DialogInterface.OnClickListener
{
  NewBizInfoSettingUI$2(NewBizInfoSettingUI paramNewBizInfoSettingUI, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23913);
    this.car.field_hadAlert = 1;
    this.car.field_brandFlag |= 0x4;
    NewBizInfoSettingUI.a(this.pDY, this.car, true);
    c.cZ(NewBizInfoSettingUI.a(this.pDY).field_username, 906);
    AppMethodBeat.o(23913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.2
 * JD-Core Version:    0.7.0.1
 */