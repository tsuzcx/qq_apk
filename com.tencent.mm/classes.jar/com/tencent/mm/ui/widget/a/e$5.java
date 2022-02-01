package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomScrollView.a;

final class e$5
  implements CustomScrollView.a
{
  e$5(e parame) {}
  
  public final void a(ScrollView paramScrollView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251641);
    if (paramScrollView.getChildAt(0).getMeasuredHeight() - (paramScrollView.getHeight() + paramScrollView.getScrollY()) < 50)
    {
      e.d(this.Ynn).setVisibility(8);
      AppMethodBeat.o(251641);
      return;
    }
    e.d(this.Ynn).setVisibility(0);
    AppMethodBeat.o(251641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.5
 * JD-Core Version:    0.7.0.1
 */