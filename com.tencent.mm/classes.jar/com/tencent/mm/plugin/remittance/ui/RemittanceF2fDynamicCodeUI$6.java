package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class RemittanceF2fDynamicCodeUI$6
  implements q.f
{
  RemittanceF2fDynamicCodeUI$6(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(68185);
    paramo.clear();
    paramo.mn(0, a.i.remittance_scan_qrcode);
    AppMethodBeat.o(68185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.6
 * JD-Core Version:    0.7.0.1
 */