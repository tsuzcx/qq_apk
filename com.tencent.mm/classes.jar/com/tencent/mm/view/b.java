package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static int e(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(193813);
    int i = (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(193813);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.b
 * JD-Core Version:    0.7.0.1
 */