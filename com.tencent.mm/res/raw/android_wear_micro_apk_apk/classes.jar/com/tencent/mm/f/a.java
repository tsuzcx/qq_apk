package com.tencent.mm.f;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.i;

public final class a
{
  private static b WF = null;
  private static SparseIntArray WG = new SparseIntArray();
  private static float WH = 0.0F;
  private static float density = -1.0F;
  
  public static float w(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = i.getContext();
    }
    if (density < 0.0F) {
      density = localContext.getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static int x(Context paramContext)
  {
    return Math.round(w(paramContext) * 4.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.f.a
 * JD-Core Version:    0.7.0.1
 */