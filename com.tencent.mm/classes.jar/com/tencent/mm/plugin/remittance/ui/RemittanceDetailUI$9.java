package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;

final class RemittanceDetailUI$9
  implements d.a
{
  RemittanceDetailUI$9(RemittanceDetailUI paramRemittanceDetailUI, Dialog paramDialog) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(68132);
    if (this.rDo != null) {
      this.rDo.dismiss();
    }
    ae.i("MicroMsg.RemittanceDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label68;
      }
    }
    label68:
    for (paramObject = paramObject.toString();; paramObject = this.yuO.getString(2131765420))
    {
      Toast.makeText(this.yuO, paramObject, 1).show();
      AppMethodBeat.o(68132);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.9
 * JD-Core Version:    0.7.0.1
 */