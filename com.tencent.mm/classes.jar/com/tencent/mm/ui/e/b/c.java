package com.tencent.mm.ui.e.b;

import android.graphics.drawable.Drawable;

public final class c
{
  private static b vVA = null;
  
  public static void a(b paramb)
  {
    vVA = paramb;
  }
  
  public static Drawable gy(String paramString1, String paramString2)
  {
    if (vVA != null)
    {
      paramString1 = vVA.cI(paramString1, paramString2);
      if ((paramString1 instanceof Drawable)) {
        return (Drawable)paramString1;
      }
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.e.b.c
 * JD-Core Version:    0.7.0.1
 */