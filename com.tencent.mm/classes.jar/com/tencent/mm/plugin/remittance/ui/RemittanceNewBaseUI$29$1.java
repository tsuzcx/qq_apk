package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceNewBaseUI$29$1
  implements a.a
{
  RemittanceNewBaseUI$29$1(RemittanceNewBaseUI.29 param29) {}
  
  public final boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(142255);
    this.qqT.qqR.qlG = paramBoolean;
    if (!bo.isNullOrNil(paramString1))
    {
      this.qqT.qqR.mDesc = paramString1;
      if (this.qqT.qqR.qlG) {
        break label188;
      }
      if (bo.isNullOrNil(paramString2)) {
        break label146;
      }
      this.qqT.qqR.mName = paramString2;
      label65:
      if (bo.isNullOrNil(paramString3)) {
        break label160;
      }
      this.qqT.qqR.pqF = paramString3;
      label85:
      if (bo.isNullOrNil(paramString4)) {
        break label174;
      }
      this.qqT.qqR.qlF = paramString4;
    }
    for (;;)
    {
      RemittanceNewBaseUI.c(this.qqT.qqR);
      RemittanceNewBaseUI.d(this.qqT.qqR);
      AppMethodBeat.o(142255);
      return true;
      this.qqT.qqR.mDesc = null;
      break;
      label146:
      this.qqT.qqR.mName = null;
      break label65;
      label160:
      this.qqT.qqR.pqF = null;
      break label85;
      label174:
      this.qqT.qqR.qlF = null;
      continue;
      label188:
      this.qqT.qqR.mName = null;
      this.qqT.qqR.pqF = null;
      this.qqT.qqR.qlF = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.29.1
 * JD-Core Version:    0.7.0.1
 */