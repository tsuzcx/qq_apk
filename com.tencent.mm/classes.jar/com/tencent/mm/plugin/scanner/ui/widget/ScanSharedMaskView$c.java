package com.tencent.mm.plugin.scanner.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ScanSharedMaskView$c
  implements View.OnClickListener
{
  ScanSharedMaskView$c(ScanSharedMaskView paramScanSharedMaskView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(52449);
    View.OnClickListener localOnClickListener = ScanSharedMaskView.a(this.xkS);
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(paramView);
      AppMethodBeat.o(52449);
      return;
    }
    AppMethodBeat.o(52449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.c
 * JD-Core Version:    0.7.0.1
 */