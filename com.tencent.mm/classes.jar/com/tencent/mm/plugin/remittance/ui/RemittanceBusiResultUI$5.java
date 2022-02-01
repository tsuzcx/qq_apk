package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, py parampy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67994);
    ac.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.wOC.type) });
    if (this.wOC.type == 1)
    {
      RemittanceBusiResultUI.i(this.wOz);
      paramView = new ut();
      paramView.dxt.userName = this.wOC.EgC;
      paramView.dxt.dxv = bs.bG(this.wOC.EgD, "");
      paramView.dxt.scene = 1034;
      paramView.dxt.dxw = 0;
      a.GpY.l(paramView);
      AppMethodBeat.o(67994);
      return;
    }
    if (this.wOC.type == 2)
    {
      RemittanceBusiResultUI.i(this.wOz);
      e.o(this.wOz.getContext(), this.wOC.url, true);
    }
    AppMethodBeat.o(67994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */