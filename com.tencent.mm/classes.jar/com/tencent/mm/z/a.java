package com.tencent.mm.z;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements Cloneable
{
  public static Rect Ui;
  private static int hnT;
  private static int hnU;
  public static float hnV;
  public static float hnW;
  public static Path hnX;
  public static Path hnY;
  public static Paint hnZ;
  public static Paint hoa;
  public static Paint hob;
  public static Paint hoc;
  public static Paint hod;
  public Rect dgS;
  public Rect hoe;
  public Rect hof;
  public Matrix mMatrix;
  
  static
  {
    AppMethodBeat.i(9245);
    hnT = (int)MMApplicationContext.getResources().getDimension(2131165962);
    hnU = (int)MMApplicationContext.getResources().getDimension(2131165961);
    hnV = MMApplicationContext.getResources().getDimension(2131166116);
    hnW = MMApplicationContext.getResources().getDimension(2131166115);
    hnX = new Path();
    hnY = new Path();
    hnZ = new Paint();
    hoa = new Paint();
    hob = new Paint();
    hoc = new Paint();
    hod = new Paint();
    Ui = new Rect();
    hob.setColor(-16777216);
    hnZ.setColor(-1);
    hnZ.setStrokeWidth(hnT);
    hnZ.setStyle(Paint.Style.STROKE);
    hnZ.setAntiAlias(true);
    hoc.set(hnZ);
    hoc.setStrokeWidth(hnU);
    hod.set(hnZ);
    hod.setStrokeWidth(hnV);
    hoa.set(hnZ);
    hoa.setStrokeWidth(hnT * 7);
    hoa.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.hoe = new Rect();
    this.hof = new Rect();
    this.mMatrix = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.hoe = new Rect();
    this.hof = new Rect();
    this.mMatrix = new Matrix();
    this.dgS = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void pN(int paramInt)
  {
    AppMethodBeat.i(9242);
    hod.setAlpha(paramInt);
    hnZ.setAlpha(paramInt);
    hoc.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void pO(int paramInt)
  {
    AppMethodBeat.i(9243);
    hob.setAlpha((int)(0.9019608F * paramInt));
    AppMethodBeat.o(9243);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(9244);
    Object localObject = super.clone();
    AppMethodBeat.o(9244);
    return localObject;
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(204752);
    this.mMatrix.set(paramMatrix);
    AppMethodBeat.o(204752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.z.a
 * JD-Core Version:    0.7.0.1
 */