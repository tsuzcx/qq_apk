package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
{
  private static SparseIntArray csc;
  private static float density;
  private static float scale;
  
  static
  {
    AppMethodBeat.i(159132);
    density = -1.0F;
    scale = 0.0F;
    csc = new SparseIntArray();
    AppMethodBeat.o(159132);
  }
  
  public static int E(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(198197);
    paramInt = Math.round(paramInt / getDensity(paramContext));
    AppMethodBeat.o(198197);
    return paramInt;
  }
  
  public static int aH(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159126);
    if (paramContext == null)
    {
      as.e("WeUIResHelper", "get dimension pixel size, resId %d, but context is null".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(159126);
      return 0;
    }
    int j = csc.get(paramInt, 0);
    int i = j;
    if (j == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(paramInt);
      csc.put(paramInt, i);
    }
    AppMethodBeat.o(159126);
    return i;
  }
  
  public static Drawable aN(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159129);
    paramContext = paramContext.obtainStyledAttributes(new int[] { paramInt });
    Drawable localDrawable = paramContext.getDrawable(0);
    paramContext.recycle();
    AppMethodBeat.o(159129);
    return localDrawable;
  }
  
  public static int aO(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159130);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.data;
    AppMethodBeat.o(159130);
    return paramInt;
  }
  
  public static float ez(Context paramContext)
  {
    AppMethodBeat.i(159128);
    if (scale == 0.0F) {
      if (paramContext != null) {
        break label32;
      }
    }
    label32:
    for (scale = 1.0F;; scale = paramContext.getSharedPreferences("com.tencent.mm_preferences", 0).getFloat("text_size_scale_key", 1.0F))
    {
      float f = scale;
      AppMethodBeat.o(159128);
      return f;
    }
  }
  
  public static int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159125);
    paramInt = Math.round(getDensity(paramContext) * paramInt);
    AppMethodBeat.o(159125);
    return paramInt;
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(159127);
    if ((paramContext != null) && (density < 0.0F)) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    float f = density;
    AppMethodBeat.o(159127);
    return f;
  }
  
  public static ColorStateList jW(Context paramContext)
  {
    AppMethodBeat.i(159131);
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130969164, localTypedValue, true);
    paramContext = b.m(paramContext, localTypedValue.resourceId);
    AppMethodBeat.o(159131);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.at
 * JD-Core Version:    0.7.0.1
 */