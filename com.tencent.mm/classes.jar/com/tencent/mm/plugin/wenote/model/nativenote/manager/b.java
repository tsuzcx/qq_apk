package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class b
{
  private static float bLI = 3.4028235E+38F;
  private static float vxZ = 3.4028235E+38F;
  private static int vya = -1;
  public static float vyb = 48.0F;
  
  public static int Lh(int paramInt)
  {
    return Math.round(paramInt * dil());
  }
  
  public static int Li(int paramInt)
  {
    return Math.round(paramInt / dil());
  }
  
  private static float dik()
  {
    try
    {
      if (bLI == 3.4028235E+38F) {
        bLI = getDisplayMetrics().density;
      }
      float f = bLI;
      return f;
    }
    finally {}
  }
  
  private static float dil()
  {
    try
    {
      if (vxZ == 3.4028235E+38F) {
        vxZ = getDisplayMetrics().density * ah.getContext().getResources().getConfiguration().fontScale;
      }
      float f = vxZ;
      return f;
    }
    finally {}
  }
  
  public static int dim()
  {
    if (vya == -1) {
      vya = Math.round(dik() * 30.0F);
    }
    return vya;
  }
  
  private static DisplayMetrics getDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static float getTextSize()
  {
    return vyb;
  }
  
  public static void setTextSize(float paramFloat)
  {
    vyb = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.b
 * JD-Core Version:    0.7.0.1
 */