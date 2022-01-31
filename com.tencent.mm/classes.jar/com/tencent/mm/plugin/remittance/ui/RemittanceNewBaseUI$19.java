package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceNewBaseUI$19
  implements a.a
{
  RemittanceNewBaseUI$19(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(142243);
    this.qqR.qlG = paramBoolean;
    if (!bo.isNullOrNil(paramString1))
    {
      this.qqR.mDesc = paramString1;
      if (!this.qqR.qlG)
      {
        if (bo.isNullOrNil(paramString2)) {
          break label119;
        }
        this.qqR.mName = paramString2;
        label53:
        if (bo.isNullOrNil(paramString3)) {
          break label130;
        }
        this.qqR.pqF = paramString3;
        label70:
        if (bo.isNullOrNil(paramString4)) {
          break label141;
        }
      }
    }
    label130:
    label141:
    for (this.qqR.qlF = paramString4;; this.qqR.qlF = null)
    {
      RemittanceNewBaseUI.c(this.qqR);
      RemittanceNewBaseUI.d(this.qqR);
      AppMethodBeat.o(142243);
      return true;
      this.qqR.mDesc = null;
      break;
      label119:
      this.qqR.mName = null;
      break label53;
      this.qqR.pqF = null;
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.19
 * JD-Core Version:    0.7.0.1
 */