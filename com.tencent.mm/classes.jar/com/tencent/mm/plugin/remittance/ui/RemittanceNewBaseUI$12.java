package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class RemittanceNewBaseUI$12
  implements View.OnClickListener
{
  RemittanceNewBaseUI$12(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142236);
    if (this.qqR.mPayScene == 33)
    {
      this.qqR.a(this.qqR.mDesc, RemittanceNewBaseUI.a(this.qqR), this.qqR.mName, this.qqR.pqF, this.qqR.qlF, this.qqR.qlH, "", null);
      if (RemittanceNewBaseUI.b(this.qqR) == 0.0D)
      {
        if (this.qqR.mScene != 1) {
          break label306;
        }
        h.qsU.e(12689, new Object[] { Integer.valueOf(15), Integer.valueOf(1) });
      }
    }
    for (;;)
    {
      if ((this.qqR.mScene == 1) && (!bo.isNullOrNil(this.qqR.mDesc))) {
        h.qsU.e(14074, new Object[] { Integer.valueOf(2) });
      }
      AppMethodBeat.o(142236);
      return;
      this.qqR.qlk = bo.getDouble(this.qqR.kRl.getText(), 0.0D);
      if (!this.qqR.kRl.asv())
      {
        t.makeText(this.qqR.getContext(), 2131304847, 0).show();
        break;
      }
      if (this.qqR.qlk < 0.01D)
      {
        this.qqR.chh();
        break;
      }
      this.qqR.hideWcKb();
      RemittanceNewBaseUI.chB();
      this.qqR.a(this.qqR.mDesc, RemittanceNewBaseUI.a(this.qqR), this.qqR.mName, this.qqR.pqF, this.qqR.qlF, null, "", null);
      break;
      label306:
      h.qsU.e(12689, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.12
 * JD-Core Version:    0.7.0.1
 */