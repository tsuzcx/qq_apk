package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bb
{
  public static boolean aAF(int paramInt)
  {
    AppMethodBeat.i(159117);
    if (1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.3D)
    {
      AppMethodBeat.o(159117);
      return true;
    }
    AppMethodBeat.o(159117);
    return false;
  }
  
  public static boolean aAG(int paramInt)
  {
    AppMethodBeat.i(249387);
    if ((Color.red(paramInt) > 200) && (Color.blue(paramInt) > 200) && (Color.green(paramInt) > 200))
    {
      AppMethodBeat.o(249387);
      return true;
    }
    AppMethodBeat.o(249387);
    return false;
  }
  
  public static int av(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159113);
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = oa(j, i);
    paramInt1 = Color.argb(k, f(Color.red(paramInt1), j, Color.red(paramInt2), i, k), f(Color.green(paramInt1), j, Color.green(paramInt2), i, k), f(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
    AppMethodBeat.o(159113);
    return paramInt1;
  }
  
  public static Drawable c(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(159116);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(159116);
      return null;
    }
    paramDrawable = a.s(paramDrawable);
    a.a(paramDrawable, paramColorStateList);
    AppMethodBeat.o(159116);
    return paramDrawable;
  }
  
  public static Drawable e(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(159115);
    if (paramDrawable != null) {
      paramDrawable.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
    }
    AppMethodBeat.o(159115);
    return paramDrawable;
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  public static int gy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159112);
    if ((paramInt2 < 0) || (paramInt2 > 100))
    {
      bc.e("alphaColor", "alpha must be between 0 and 100", new Object[0]);
      AppMethodBeat.o(159112);
      return paramInt1;
    }
    paramInt2 = (int)(paramInt2 * 0.01D * 255.0D);
    AppMethodBeat.o(159112);
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  public static Drawable m(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159114);
    paramContext = paramContext.getResources().getDrawable(paramInt1);
    if (paramContext != null) {
      if (paramInt2 == 0) {
        break label73;
      }
    }
    label73:
    for (paramInt1 = 0xFFFFFF & paramInt2 | 0xFF000000;; paramInt1 = paramInt2)
    {
      int i = Color.alpha(paramInt2);
      PorterDuffColorFilter localPorterDuffColorFilter = new PorterDuffColorFilter(paramInt1, PorterDuff.Mode.SRC_ATOP);
      paramContext.mutate().setColorFilter(localPorterDuffColorFilter);
      if (paramInt2 != 0) {
        paramContext.setAlpha(i);
      }
      AppMethodBeat.o(159114);
      return paramContext;
    }
  }
  
  private static int oa(int paramInt1, int paramInt2)
  {
    return 255 - (255 - paramInt2) * (255 - paramInt1) / 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bb
 * JD-Core Version:    0.7.0.1
 */