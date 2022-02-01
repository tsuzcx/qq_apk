package com.tencent.mm.plugin.scanner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class ScanCodeSheetItemLogic$7
  implements View.OnClickListener
{
  ScanCodeSheetItemLogic$7(ScanCodeSheetItemLogic paramScanCodeSheetItemLogic, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203813);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    long l = System.currentTimeMillis();
    localObject = Util.safeFormatString("%d,%d", new Object[] { Integer.valueOf(this.IFZ), Long.valueOf(l) });
    Log.i("MicroMsg.ScanCodeSheetItemLogic", "18684 report:".concat(String.valueOf(localObject)));
    h.IzE.kvStat(18684, (String)localObject);
    this.IGa.onClick(paramView);
    a.a(this, "com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.7
 * JD-Core Version:    0.7.0.1
 */