package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SelfQRCodeUI$10
  implements n.c
{
  SelfQRCodeUI$10(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(154170);
    boolean bool1 = t.nI(SelfQRCodeUI.d(this.qGz));
    boolean bool2 = f.rX(SelfQRCodeUI.d(this.qGz));
    if ((!bool2) && (!bool1)) {
      paraml.hx(2, 2131303079);
    }
    paraml.hx(1, 2131303083);
    if (!bool2) {
      paraml.hx(3, 2131303099);
    }
    if (SelfQRCodeUI.e(this.qGz)) {
      paraml.hx(4, 2131303098);
    }
    AppMethodBeat.o(154170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.10
 * JD-Core Version:    0.7.0.1
 */