package com.tencent.mm.plugin.scanner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class ScanCodeSheetItemLogic$6
  implements View.OnClickListener
{
  ScanCodeSheetItemLogic$6(ScanCodeSheetItemLogic paramScanCodeSheetItemLogic, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(218781);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    long l = System.currentTimeMillis();
    localObject = bu.x("%d,%d", new Object[] { Integer.valueOf(this.yzr), Long.valueOf(l) });
    ae.i("MicroMsg.ScanCodeSheetItemLogic", "18684 report:".concat(String.valueOf(localObject)));
    g.yxI.kvStat(18684, (String)localObject);
    this.yzs.onClick(paramView);
    a.a(this, "com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(218781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.6
 * JD-Core Version:    0.7.0.1
 */