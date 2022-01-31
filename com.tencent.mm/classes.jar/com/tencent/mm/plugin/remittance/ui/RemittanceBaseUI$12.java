package com.tencent.mm.plugin.remittance.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class RemittanceBaseUI$12
  extends com.tencent.mm.ui.t
{
  RemittanceBaseUI$12(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(44836);
    RemittanceBaseUI localRemittanceBaseUI;
    String str;
    if (this.qmk.mPayScene == 33)
    {
      localRemittanceBaseUI = this.qmk;
      str = this.qmk.mDesc;
      RemittanceBaseUI.a(this.qmk);
      localRemittanceBaseUI.Yl(str);
      if (RemittanceBaseUI.b(this.qmk) == 0.0D)
      {
        if (this.qmk.mScene != 1) {
          break label260;
        }
        h.qsU.e(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
      }
    }
    for (;;)
    {
      if ((this.qmk.mScene == 1) && (!bo.isNullOrNil(this.qmk.mDesc))) {
        h.qsU.e(14074, new Object[] { Integer.valueOf(2) });
      }
      AppMethodBeat.o(44836);
      return;
      this.qmk.qlk = bo.getDouble(this.qmk.kRl.getText(), 0.0D);
      if (!this.qmk.kRl.asv())
      {
        com.tencent.mm.ui.base.t.makeText(this.qmk.getContext(), 2131304847, 0).show();
        break;
      }
      if (this.qmk.qlk < 0.01D)
      {
        this.qmk.chh();
        break;
      }
      this.qmk.hideTenpayKB();
      RemittanceBaseUI.chq();
      localRemittanceBaseUI = this.qmk;
      str = this.qmk.mDesc;
      RemittanceBaseUI.a(this.qmk);
      localRemittanceBaseUI.Yl(str);
      break;
      label260:
      h.qsU.e(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.12
 * JD-Core Version:    0.7.0.1
 */