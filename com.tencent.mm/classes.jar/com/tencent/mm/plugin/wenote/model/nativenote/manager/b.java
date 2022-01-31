package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class b
{
  private static float rHr = 3.4028235E+38F;
  private static float rHs = 3.4028235E+38F;
  private static int rHt = -1;
  public static float rHu = 48.0F;
  
  public static int Do(int paramInt)
  {
    return Math.round(paramInt * chV());
  }
  
  public static int Dp(int paramInt)
  {
    return Math.round(paramInt / chV());
  }
  
  private static float chU()
  {
    try
    {
      if (rHr == 3.4028235E+38F) {
        rHr = getDisplayMetrics().density;
      }
      float f = rHr;
      return f;
    }
    finally {}
  }
  
  private static float chV()
  {
    try
    {
      if (rHs == 3.4028235E+38F) {
        rHs = getDisplayMetrics().density * ae.getContext().getResources().getConfiguration().fontScale;
      }
      float f = rHs;
      return f;
    }
    finally {}
  }
  
  public static int chW()
  {
    if (rHt == -1) {
      rHt = Math.round(chU() * 30.0F);
    }
    return rHt;
  }
  
  private static DisplayMetrics getDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static float getTextSize()
  {
    return rHu;
  }
  
  public static void setTextSize(float paramFloat)
  {
    rHu = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.b
 * JD-Core Version:    0.7.0.1
 */