package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ai.f;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SelfQRCodeUI$8
  implements n.c
{
  SelfQRCodeUI$8(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void a(l paraml)
  {
    boolean bool1 = s.gZ(SelfQRCodeUI.c(this.nSB));
    boolean bool2 = f.lc(SelfQRCodeUI.c(this.nSB));
    if ((!bool2) && (!bool1)) {
      paraml.fq(2, a.i.self_qrcode_change);
    }
    paraml.fq(1, a.i.self_qrcode_save);
    if (!bool2) {
      paraml.fq(3, a.i.self_qrcode_to_scan);
    }
    if (SelfQRCodeUI.d(this.nSB)) {
      paraml.fq(4, a.i.self_qrcode_to_revoke);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.8
 * JD-Core Version:    0.7.0.1
 */