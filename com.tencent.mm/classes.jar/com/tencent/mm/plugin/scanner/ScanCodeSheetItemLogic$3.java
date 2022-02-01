package com.tencent.mm.plugin.scanner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class ScanCodeSheetItemLogic$3
  implements View.OnClickListener
{
  ScanCodeSheetItemLogic$3(ScanCodeSheetItemLogic paramScanCodeSheetItemLogic, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151568);
    long l = System.currentTimeMillis();
    String str = bs.u("%d,%d", new Object[] { Integer.valueOf(this.wVO), Long.valueOf(l) });
    ac.i("MicroMsg.ScanCodeSheetItemLogic", "18684 report:".concat(String.valueOf(str)));
    h.wUl.kvStat(18684, str);
    this.wVP.onClick(paramView);
    AppMethodBeat.o(151568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.3
 * JD-Core Version:    0.7.0.1
 */