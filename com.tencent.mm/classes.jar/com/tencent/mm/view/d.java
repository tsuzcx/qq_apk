package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static int e(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(234612);
    int i = (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(234612);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.d
 * JD-Core Version:    0.7.0.1
 */