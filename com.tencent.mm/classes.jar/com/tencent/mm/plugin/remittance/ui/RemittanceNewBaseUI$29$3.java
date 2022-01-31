package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.b;

final class RemittanceNewBaseUI$29$3
  implements h.b
{
  RemittanceNewBaseUI$29$3(RemittanceNewBaseUI.29 param29) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142258);
    if (!bo.isNullOrNil(paramCharSequence.toString()))
    {
      this.qqT.qqR.mDesc = paramCharSequence.toString();
      RemittanceNewBaseUI.d(this.qqT.qqR);
    }
    for (;;)
    {
      AppMethodBeat.o(142258);
      return true;
      this.qqT.qqR.mDesc = null;
      RemittanceNewBaseUI.d(this.qqT.qqR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.29.3
 * JD-Core Version:    0.7.0.1
 */