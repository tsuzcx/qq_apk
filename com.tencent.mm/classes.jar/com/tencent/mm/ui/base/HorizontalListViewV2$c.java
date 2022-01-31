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
    AppMethodBeat.i(106340);
    if (Build.VERSION.SDK_INT < 14)
    {
      RuntimeException localRuntimeException = new RuntimeException("sdk is >= 14!");
      AppMethodBeat.o(106340);
      throw localRuntimeException;
    }
    AppMethodBeat.o(106340);
  }
  
  public static float b(Scroller paramScroller)
  {
    AppMethodBeat.i(106339);
    float f = paramScroller.getCurrVelocity();
    AppMethodBeat.o(106339);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.c
 * JD-Core Version:    0.7.0.1
 */