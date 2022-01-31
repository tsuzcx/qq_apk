package com.tencent.mm.plugin.remittance.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiUI$4
  implements Runnable
{
  RemittanceBusiUI$4(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(142177);
    RemittanceBusiUI.B(this.qoF).setText(RemittanceBusiUI.A(this.qoF));
    String str2 = e.eZ(e.nE(RemittanceBusiUI.C(this.qoF)), 10);
    String str1 = str2;
    if (!bo.isNullOrNil(RemittanceBusiUI.D(this.qoF))) {
      str1 = this.qoF.getString(2131302534, new Object[] { str2, RemittanceBusiUI.D(this.qoF) });
    }
    RemittanceBusiUI.E(this.qoF).setText(j.b(this.qoF, str1, RemittanceBusiUI.E(this.qoF).getTextSize()));
    if (RemittanceBusiUI.i(this.qoF) != null) {
      if (RemittanceBusiUI.i(this.qoF).qiM == 1)
      {
        if (!bo.isNullOrNil(RemittanceBusiUI.i(this.qoF).qiN))
        {
          if (RemittanceBusiUI.i(this.qoF).qiV == 1) {
            RemittanceBusiUI.F(this.qoF).setRoundCorner(true);
          }
          for (;;)
          {
            int i = BackwardSupportUtil.b.b(this.qoF, 36.0F);
            RemittanceBusiUI.F(this.qoF).o(RemittanceBusiUI.i(this.qoF).qiN, i, i, -1);
            AppMethodBeat.o(142177);
            return;
            RemittanceBusiUI.F(this.qoF).setRoundCorner(false);
          }
        }
        if (!bo.isNullOrNil(RemittanceBusiUI.C(this.qoF)))
        {
          if (RemittanceBusiUI.i(this.qoF).qiV == 1)
          {
            a.b.s(RemittanceBusiUI.F(this.qoF), RemittanceBusiUI.C(this.qoF));
            AppMethodBeat.o(142177);
            return;
          }
          a.b.c(RemittanceBusiUI.F(this.qoF), RemittanceBusiUI.C(this.qoF));
          AppMethodBeat.o(142177);
        }
      }
      else
      {
        RemittanceBusiUI.F(this.qoF).setVisibility(8);
        AppMethodBeat.o(142177);
        return;
      }
    }
    RemittanceBusiUI.F(this.qoF).setVisibility(8);
    AppMethodBeat.o(142177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.4
 * JD-Core Version:    0.7.0.1
 */