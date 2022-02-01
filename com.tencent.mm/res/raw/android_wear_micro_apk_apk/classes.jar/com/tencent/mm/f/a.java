package com.tencent.mm.f;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.i;

public final class a
{
  private static b YA = null;
  private static SparseIntArray YB = new SparseIntArray();
  private static float YC = 0.0F;
  private static boolean YD = false;
  private static boolean YE = true;
  private static float density = -1.0F;
  
  public static float x(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = i.getContext();
    }
    float f = localContext.getResources().getDisplayMetrics().density;
    density = f;
    return f;
  }
  
  public static int y(Context paramContext)
  {
    return Math.round(x(paramContext) * 4.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.f.a
 * JD-Core Version:    0.7.0.1
 */