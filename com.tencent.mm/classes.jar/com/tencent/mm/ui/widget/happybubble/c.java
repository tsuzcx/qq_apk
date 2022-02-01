package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.ui.ar;

public final class c
{
  public static int[] getScreenWH(Context paramContext)
  {
    AppMethodBeat.i(143558);
    if (ar.hIH()) {}
    for (int i = ar.getDeviceWidth();; i = a.kr(paramContext))
    {
      int j = a.ks(paramContext);
      AppMethodBeat.o(143558);
      return new int[] { i, j };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.c
 * JD-Core Version:    0.7.0.1
 */