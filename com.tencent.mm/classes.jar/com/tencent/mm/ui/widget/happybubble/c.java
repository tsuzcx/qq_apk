package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.aw;

public final class c
{
  public static int[] getScreenWH(Context paramContext)
  {
    AppMethodBeat.i(143558);
    if (aw.jkS()) {}
    for (int i = aw.getDeviceWidth();; i = a.ms(paramContext))
    {
      int j = a.mt(paramContext);
      AppMethodBeat.o(143558);
      return new int[] { i, j };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.c
 * JD-Core Version:    0.7.0.1
 */