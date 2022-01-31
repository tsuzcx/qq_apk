package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceBaseUI$23
  implements View.OnClickListener
{
  RemittanceBaseUI$23(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44853);
    this.qmk.hideTenpayKB();
    RemittanceBaseUI.chq();
    h.qsU.e(12689, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
    Object localObject;
    if ((this.qmk.mScene == 1) || (this.qmk.mScene == 6))
    {
      localObject = this.qmk.getString(2131302515);
      paramView = this.qmk.getString(2131302541);
      h.qsU.e(14074, new Object[] { Integer.valueOf(1) });
    }
    String str1;
    String str2;
    do
    {
      do
      {
        a.a(this.qmk, (String)localObject, this.qmk.mDesc, paramView, 20, new RemittanceBaseUI.23.3(this), new RemittanceBaseUI.23.4(this));
        AppMethodBeat.o(44853);
        return;
        str1 = this.qmk.getString(2131302514);
        str2 = this.qmk.getString(2131302520);
        localObject = str1;
        paramView = str2;
      } while (!bo.hl(RemittanceBaseUI.a(this.qmk), 0));
      localObject = str1;
      paramView = str2;
    } while (!this.qmk.qlo);
    a.a(this.qmk, str1, this.qmk.mDesc, str2, this.qmk.qlG, this.qmk.mName, this.qmk.pqF, this.qmk.qlF, new RemittanceBaseUI.23.1(this), new RemittanceBaseUI.23.2(this));
    AppMethodBeat.o(44853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.23
 * JD-Core Version:    0.7.0.1
 */