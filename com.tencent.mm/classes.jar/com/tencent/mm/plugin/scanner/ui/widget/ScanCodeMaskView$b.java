package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.g;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ScanCodeMaskView$b
  implements View.OnClickListener
{
  ScanCodeMaskView$b(Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(170044);
    h.wUl.f(11264, new Object[] { Integer.valueOf(3) });
    g.dyX().bE(this.cgl);
    AppMethodBeat.o(170044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.b
 * JD-Core Version:    0.7.0.1
 */