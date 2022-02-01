package com.tencent.mm.z;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
  implements Cloneable
{
  public static Rect Sh;
  private static int geN;
  private static int geO;
  public static float geP;
  public static float geQ;
  public static Path geR;
  public static Path geS;
  public static Paint geT;
  public static Paint geU;
  public static Paint geV;
  public static Paint geW;
  public static Paint geX;
  public Rect cEJ;
  public Rect geY;
  public Rect geZ;
  public Matrix mMatrix;
  
  static
  {
    AppMethodBeat.i(9245);
    geN = (int)ai.getResources().getDimension(2131165935);
    geO = (int)ai.getResources().getDimension(2131165934);
    geP = ai.getResources().getDimension(2131166075);
    geQ = ai.getResources().getDimension(2131166074);
    geR = new Path();
    geS = new Path();
    geT = new Paint();
    geU = new Paint();
    geV = new Paint();
    geW = new Paint();
    geX = new Paint();
    Sh = new Rect();
    geV.setColor(-16777216);
    geT.setColor(-1);
    geT.setStrokeWidth(geN);
    geT.setStyle(Paint.Style.STROKE);
    geT.setAntiAlias(true);
    geW.set(geT);
    geW.setStrokeWidth(geO);
    geX.set(geT);
    geX.setStrokeWidth(geP);
    geU.set(geT);
    geU.setStrokeWidth(geN * 7);
    geU.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.geY = new Rect();
    this.geZ = new Rect();
    this.mMatrix = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.geY = new Rect();
    this.geZ = new Rect();
    this.mMatrix = new Matrix();
    this.cEJ = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void lY(int paramInt)
  {
    AppMethodBeat.i(9242);
    geX.setAlpha(paramInt);
    geT.setAlpha(paramInt);
    geW.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void lZ(int paramInt)
  {
    AppMethodBeat.i(9243);
    geV.setAlpha((int)(0.9019608F * paramInt));
    AppMethodBeat.o(9243);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(9244);
    Object localObject = super.clone();
    AppMethodBeat.o(9244);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.a
 * JD-Core Version:    0.7.0.1
 */