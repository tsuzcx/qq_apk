package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
final class HorizontalListViewV2$c
{
  static
  {
    AppMethodBeat.i(141706);
    if (Build.VERSION.SDK_INT < 14)
    {
      RuntimeException localRuntimeException = new RuntimeException("sdk is >= 14!");
      AppMethodBeat.o(141706);
      throw localRuntimeException;
    }
    AppMethodBeat.o(141706);
  }
  
  public static float b(Scroller paramScroller)
  {
    AppMethodBeat.i(141705);
    float f = paramScroller.getCurrVelocity();
    AppMethodBeat.o(141705);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.c
 * JD-Core Version:    0.7.0.1
 */