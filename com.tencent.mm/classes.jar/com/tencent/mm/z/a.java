package com.tencent.mm.z;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  implements Cloneable
{
  public static Path dHA;
  public static Path dHB;
  public static Paint dHC;
  public static Paint dHD;
  public static Paint dHE;
  public static Paint dHF;
  public static Paint dHG;
  private static int dHw = (int)ae.getResources().getDimension(a.c.box_line_width);
  private static int dHx = (int)ae.getResources().getDimension(a.c.box_gird_width);
  public static float dHy = ae.getResources().getDimension(a.c.corner_width);
  public static float dHz = ae.getResources().getDimension(a.c.corner_length);
  public static Rect hc;
  public Rect buk;
  public Rect dHH = new Rect();
  public Rect dHI = new Rect();
  public Matrix mMatrix = new Matrix();
  
  static
  {
    dHA = new Path();
    dHB = new Path();
    dHC = new Paint();
    dHD = new Paint();
    dHE = new Paint();
    dHF = new Paint();
    dHG = new Paint();
    hc = new Rect();
    dHE.setColor(-16777216);
    dHC.setColor(-1);
    dHC.setStrokeWidth(dHw);
    dHC.setStyle(Paint.Style.STROKE);
    dHC.setAntiAlias(true);
    dHF.set(dHC);
    dHF.setStrokeWidth(dHx);
    dHG.set(dHC);
    dHG.setStrokeWidth(dHy);
    dHD.set(dHC);
    dHD.setStrokeWidth(dHw * 7);
    dHD.setColor(549174203);
  }
  
  public a() {}
  
  public a(Rect paramRect)
  {
    this.buk = paramRect;
  }
  
  public static void hg(int paramInt)
  {
    dHG.setAlpha(paramInt);
    dHC.setAlpha(paramInt);
    dHF.setAlpha((int)(0.7058824F * paramInt));
  }
  
  public static void hh(int paramInt)
  {
    dHE.setAlpha((int)(0.9019608F * paramInt));
  }
  
  public final Object clone()
  {
    return super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.z.a
 * JD-Core Version:    0.7.0.1
 */