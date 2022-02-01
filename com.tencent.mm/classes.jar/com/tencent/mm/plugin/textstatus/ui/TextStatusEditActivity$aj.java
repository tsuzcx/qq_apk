package com.tencent.mm.plugin.textstatus.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.MaxHeightScrollView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class TextStatusEditActivity$aj
  implements Runnable
{
  TextStatusEditActivity$aj(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(258454);
    if (this.GeQ.fwt() != null)
    {
      MaxHeightScrollView localMaxHeightScrollView = this.GeQ.Gee;
      if (localMaxHeightScrollView != null)
      {
        Object localObject = this.GeQ.fwt();
        if (localObject != null) {}
        for (localObject = Integer.valueOf(((ImageView)localObject).getMeasuredHeight());; localObject = null)
        {
          if (localObject == null) {
            p.hyc();
          }
          localMaxHeightScrollView.setMaxHeight(((Integer)localObject).intValue());
          AppMethodBeat.o(258454);
          return;
        }
      }
    }
    AppMethodBeat.o(258454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.aj
 * JD-Core Version:    0.7.0.1
 */