package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class RemittanceDetailUI$8
  implements d.a
{
  RemittanceDetailUI$8(RemittanceDetailUI paramRemittanceDetailUI, Dialog paramDialog) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(45003);
    if (this.mwd != null) {
      this.mwd.dismiss();
    }
    ab.i("MicroMsg.RemittanceDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label68;
      }
    }
    label68:
    for (paramObject = paramObject.toString();; paramObject = this.qpY.getString(2131305218))
    {
      Toast.makeText(this.qpY, paramObject, 1).show();
      AppMethodBeat.o(45003);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.8
 * JD-Core Version:    0.7.0.1
 */