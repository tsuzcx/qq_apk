package com.tencent.mm.plugin.remittance.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.d;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.ui.base.t;

final class RemittanceBusiUI$8
  implements d
{
  RemittanceBusiUI$8(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void a(int paramInt1, int paramInt2, g paramg)
  {
    AppMethodBeat.i(142181);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramg.qja.koj != 0)
      {
        t.makeText(this.qoF.getContext(), paramg.qja.kok, 0).show();
        AppMethodBeat.o(142181);
      }
    }
    else {
      t.makeText(this.qoF.getContext(), this.qoF.getString(2131305032), 0).show();
    }
    AppMethodBeat.o(142181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.8
 * JD-Core Version:    0.7.0.1
 */