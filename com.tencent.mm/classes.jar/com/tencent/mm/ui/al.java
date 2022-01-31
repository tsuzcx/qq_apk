package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
{
  private static float density;
  private static float scale;
  private static SparseIntArray yiK;
  
  static
  {
    AppMethodBeat.i(112487);
    density = -1.0F;
    scale = 0.0F;
    yiK = new SparseIntArray();
    AppMethodBeat.o(112487);
  }
  
  public static int ap(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(112483);
    if (paramContext == null)
    {
      ak.e("WeUIResHelper", "get dimension pixel size, resId %d, but context is null".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(112483);
      return 0;
    }
    int j = yiK.get(paramInt, 0);
    int i = j;
    if (j == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(paramInt);
      yiK.put(paramInt, i);
    }
    AppMethodBeat.o(112483);
    return i;
  }
  
  public static float dr(Context paramContext)
  {
    AppMethodBeat.i(112485);
    if (scale == 0.0F) {
      if (paramContext != null) {
        break label32;
      }
    }
    label32:
    for (scale = 1.0F;; scale = paramContext.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0F))
    {
      float f = scale;
      AppMethodBeat.o(112485);
      return f;
    }
  }
  
  public static int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(112482);
    paramInt = Math.round(getDensity(paramContext) * paramInt);
    AppMethodBeat.o(112482);
    return paramInt;
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(112484);
    if ((paramContext != null) && (density < 0.0F)) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    float f = density;
    AppMethodBeat.o(112484);
    return f;
  }
  
  public static int hX(Context paramContext)
  {
    AppMethodBeat.i(112486);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130771970, localTypedValue, true);
    int i = localTypedValue.data;
    AppMethodBeat.o(112486);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.al
 * JD-Core Version:    0.7.0.1
 */