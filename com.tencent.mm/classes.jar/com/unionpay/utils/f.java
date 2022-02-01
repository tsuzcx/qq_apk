package com.unionpay.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static int a(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(207311);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(207311);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.unionpay.utils.f
 * JD-Core Version:    0.7.0.1
 */