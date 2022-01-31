package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class BaseScanUI$14$1
  implements n.c
{
  BaseScanUI$14$1(BaseScanUI.14 param14) {}
  
  public final void a(l paraml)
  {
    paraml.fq(0, R.l.add_qrcode_as_shortcut);
    if (this.nJl.nJk != null) {
      paraml.fq(1, R.l.self_qrcode_gallery);
    }
    if (i.byw())
    {
      paraml.fq(2, R.l.scan_history_ttile);
      y.i("MicroMsg.scanner.BaseScanUI", "show history list");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.14.1
 * JD-Core Version:    0.7.0.1
 */