package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceBaseUI$16
  implements a.a
{
  RemittanceBaseUI$16(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(142148);
    this.qmk.qlG = paramBoolean;
    if (!bo.isNullOrNil(paramString1))
    {
      this.qmk.mDesc = paramString1;
      if (!this.qmk.qlG)
      {
        if (bo.isNullOrNil(paramString2)) {
          break label119;
        }
        this.qmk.mName = paramString2;
        label53:
        if (bo.isNullOrNil(paramString3)) {
          break label130;
        }
        this.qmk.pqF = paramString3;
        label70:
        if (bo.isNullOrNil(paramString4)) {
          break label141;
        }
      }
    }
    label130:
    label141:
    for (this.qmk.qlF = paramString4;; this.qmk.qlF = null)
    {
      RemittanceBaseUI.c(this.qmk);
      RemittanceBaseUI.d(this.qmk);
      AppMethodBeat.o(142148);
      return true;
      this.qmk.mDesc = null;
      break;
      label119:
      this.qmk.mName = null;
      break label53;
      this.qmk.pqF = null;
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.16
 * JD-Core Version:    0.7.0.1
 */