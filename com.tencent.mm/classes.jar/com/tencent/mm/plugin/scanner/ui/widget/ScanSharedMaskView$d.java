package com.tencent.mm.plugin.scanner.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ScanSharedMaskView$d
  implements View.OnClickListener
{
  ScanSharedMaskView$d(ScanSharedMaskView paramScanSharedMaskView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(52450);
    View.OnClickListener localOnClickListener = ScanSharedMaskView.b(this.xkS);
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(paramView);
      AppMethodBeat.o(52450);
      return;
    }
    AppMethodBeat.o(52450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.d
 * JD-Core Version:    0.7.0.1
 */