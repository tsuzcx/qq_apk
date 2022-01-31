package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aj
{
  public static boolean Ow(int paramInt)
  {
    AppMethodBeat.i(112474);
    if (1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.3D)
    {
      AppMethodBeat.o(112474);
      return true;
    }
    AppMethodBeat.o(112474);
    return false;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  public static int dS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112470);
    if ((paramInt2 < 0) || (paramInt2 > 100))
    {
      ak.e("alphaColor", "alpha must be between 0 and 100", new Object[0]);
      AppMethodBeat.o(112470);
      return paramInt1;
    }
    paramInt2 = (int)(paramInt2 * 0.01D * 255.0D);
    AppMethodBeat.o(112470);
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  public static Drawable e(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(112473);
    if (paramDrawable != null) {
      paramDrawable.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
    }
    AppMethodBeat.o(112473);
    return paramDrawable;
  }
  
  public static Drawable g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112472);
    paramContext = paramContext.getResources().getDrawable(paramInt1);
    if (paramContext != null) {
      paramContext.setColorFilter(new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_ATOP));
    }
    AppMethodBeat.o(112472);
    return paramContext;
  }
  
  private static int hs(int paramInt1, int paramInt2)
  {
    return 255 - (255 - paramInt2) * (255 - paramInt1) / 255;
  }
  
  public static int n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112471);
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = hs(j, i);
    paramInt1 = Color.argb(k, b(Color.red(paramInt1), j, Color.red(paramInt2), i, k), b(Color.green(paramInt1), j, Color.green(paramInt2), i, k), b(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
    AppMethodBeat.o(112471);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.aj
 * JD-Core Version:    0.7.0.1
 */