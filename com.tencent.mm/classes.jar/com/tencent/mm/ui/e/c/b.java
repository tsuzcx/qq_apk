package com.tencent.mm.ui.e.c;

import android.content.Context;

public final class b
{
  private static a vVB = null;
  
  public static void a(a parama)
  {
    vVB = parama;
  }
  
  public static int bs(String paramString, int paramInt)
  {
    int i = paramInt;
    if (vVB != null) {
      i = vVB.bs(paramString, paramInt);
    }
    return i;
  }
  
  public static CharSequence c(CharSequence paramCharSequence, int paramInt)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (vVB != null) {
      localCharSequence = vVB.c(paramCharSequence, paramInt);
    }
    return localCharSequence;
  }
  
  public static CharSequence d(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    paramContext = paramCharSequence;
    if (vVB != null) {
      paramContext = vVB.b(paramCharSequence, paramFloat);
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e.c.b
 * JD-Core Version:    0.7.0.1
 */