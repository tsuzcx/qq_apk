package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.b;

final class RemittanceBaseUI$23$3
  implements h.b
{
  RemittanceBaseUI$23$3(RemittanceBaseUI.23 param23) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(44850);
    if (!bo.isNullOrNil(paramCharSequence.toString()))
    {
      this.qmp.qmk.mDesc = paramCharSequence.toString();
      RemittanceBaseUI.d(this.qmp.qmk);
    }
    for (;;)
    {
      AppMethodBeat.o(44850);
      return true;
      this.qmp.qmk.mDesc = null;
      RemittanceBaseUI.d(this.qmp.qmk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.23.3
 * JD-Core Version:    0.7.0.1
 */