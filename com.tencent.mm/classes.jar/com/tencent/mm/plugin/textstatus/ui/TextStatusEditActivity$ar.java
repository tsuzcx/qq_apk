package com.tencent.mm.plugin.textstatus.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.MaxHeightScrollView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class TextStatusEditActivity$ar
  implements Runnable
{
  TextStatusEditActivity$ar(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(235984);
    if (this.MMz.gmM() != null)
    {
      MaxHeightScrollView localMaxHeightScrollView = this.MMz.MLB;
      if (localMaxHeightScrollView != null)
      {
        Object localObject = this.MMz.gmM();
        if (localObject != null) {}
        for (localObject = Integer.valueOf(((ImageView)localObject).getMeasuredHeight());; localObject = null)
        {
          if (localObject == null) {
            p.iCn();
          }
          localMaxHeightScrollView.setMaxHeight(((Integer)localObject).intValue());
          AppMethodBeat.o(235984);
          return;
        }
      }
    }
    AppMethodBeat.o(235984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.ar
 * JD-Core Version:    0.7.0.1
 */