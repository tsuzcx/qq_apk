package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.DisplayMetrics;

public final class b
{
  static boolean a(Layout paramLayout, int paramInt)
  {
    return (paramInt > 0) && (paramLayout.getLineForOffset(paramInt) == paramLayout.getLineForOffset(paramInt - 1) + 1);
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.b
 * JD-Core Version:    0.7.0.1
 */