package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static int e(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(206170);
    int i = (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(206170);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.d
 * JD-Core Version:    0.7.0.1
 */