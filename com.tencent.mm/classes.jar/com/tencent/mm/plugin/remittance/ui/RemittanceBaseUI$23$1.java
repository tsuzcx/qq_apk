package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceBaseUI$23$1
  implements a.a
{
  RemittanceBaseUI$23$1(RemittanceBaseUI.23 param23) {}
  
  public final boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(44847);
    this.qmp.qmk.qlG = paramBoolean;
    if (!bo.isNullOrNil(paramString1))
    {
      this.qmp.qmk.mDesc = paramString1;
      if (this.qmp.qmk.qlG) {
        break label188;
      }
      if (bo.isNullOrNil(paramString2)) {
        break label146;
      }
      this.qmp.qmk.mName = paramString2;
      label65:
      if (bo.isNullOrNil(paramString3)) {
        break label160;
      }
      this.qmp.qmk.pqF = paramString3;
      label85:
      if (bo.isNullOrNil(paramString4)) {
        break label174;
      }
      this.qmp.qmk.qlF = paramString4;
    }
    for (;;)
    {
      RemittanceBaseUI.c(this.qmp.qmk);
      RemittanceBaseUI.d(this.qmp.qmk);
      AppMethodBeat.o(44847);
      return true;
      this.qmp.qmk.mDesc = null;
      break;
      label146:
      this.qmp.qmk.mName = null;
      break label65;
      label160:
      this.qmp.qmk.pqF = null;
      break label85;
      label174:
      this.qmp.qmk.qlF = null;
      continue;
      label188:
      this.qmp.qmk.mName = null;
      this.qmp.qmk.pqF = null;
      this.qmp.qmk.qlF = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.23.1
 * JD-Core Version:    0.7.0.1
 */