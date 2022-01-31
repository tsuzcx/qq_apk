package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;

final class NewBizInfoSettingUI$3
  implements DialogInterface.OnClickListener
{
  NewBizInfoSettingUI$3(NewBizInfoSettingUI paramNewBizInfoSettingUI, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23914);
    this.car.field_hadAlert = 1;
    NewBizInfoSettingUI.a(this.pDY, this.car, false);
    AppMethodBeat.o(23914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.3
 * JD-Core Version:    0.7.0.1
 */