package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(11)
final class HorizontalListViewV2$b
{
  static
  {
    AppMethodBeat.i(141704);
    if (Build.VERSION.SDK_INT < 11)
    {
      RuntimeException localRuntimeException = new RuntimeException("sdk is >= 11!");
      AppMethodBeat.o(141704);
      throw localRuntimeException;
    }
    AppMethodBeat.o(141704);
  }
  
  public static void a(Scroller paramScroller)
  {
    AppMethodBeat.i(141703);
    if (paramScroller != null) {
      paramScroller.setFriction(0.009F);
    }
    AppMethodBeat.o(141703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.b
 * JD-Core Version:    0.7.0.1
 */