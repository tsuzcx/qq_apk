package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p$1
  implements View.OnLayoutChangeListener
{
  p$1(View paramView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(70413);
    paramInt1 = paramInt4 - paramInt2;
    if ((paramInt1 > 0) && (paramInt8 - paramInt6 != paramInt1)) {
      paramView.post(new p.1.1(this, paramView));
    }
    AppMethodBeat.o(70413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p.1
 * JD-Core Version:    0.7.0.1
 */