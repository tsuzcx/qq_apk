package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class FavRecordDetailUI$2$2$1
  implements DialogInterface.OnClickListener
{
  FavRecordDetailUI$2$2$1(FavRecordDetailUI.2.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = h.b(this.ntH.ntG.ntD.mController.uMN, this.ntH.ntG.ntD.getString(R.l.app_delete_tips), false, null);
    gf localgf = new gf();
    localgf.bNF.type = 12;
    localgf.bNF.bIr = FavRecordDetailUI.a(this.ntH.ntG.ntD);
    localgf.bNF.bNK = new FavRecordDetailUI.2.2.1.1(this, paramDialogInterface);
    a.udP.m(localgf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2.1
 * JD-Core Version:    0.7.0.1
 */