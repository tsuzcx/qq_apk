package com.tencent.mm.z;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  implements Cloneable
{
  public static Rect TW;
  private static int gBe;
  private static int gBf;
  public static float gBg;
  public static float gBh;
  public static Path gBi;
  public static Path gBj;
  public static Paint gBk;
  public static Paint gBl;
  public static Paint gBm;
  public static Paint gBn;
  public static Paint gBo;
  public Rect cQy;
  public Rect gBp;
  public Rect gBq;
  public Matrix mMatrix;
  
  static
  {
    AppMethodBeat.i(9245);
    gBe = (int)ak.getResources().getDimension(2131165935);
    gBf = (int)ak.getResources().getDimension(2131165934);
    gBg = ak.getResources().getDimension(2131166075);
    gBh = ak.getResources().getDimension(2131166074);
    gBi = new Path();
    gBj = new Path();
    gBk = new Paint();
    gBl = new Paint();
    gBm = new Paint();
    gBn = new Paint();
    gBo = new Paint();
    TW = new Rect();
    gBm.setColor(-16777216);
    gBk.setColor(-1);
    gBk.setStrokeWidth(gBe);
    gBk.setStyle(Paint.Style.STROKE);
    gBk.setAntiAlias(true);
    gBn.set(gBk);
    gBn.setStrokeWidth(gBf);
    gBo.set(gBk);
    gBo.setStrokeWidth(gBg);
    gBl.set(gBk);
    gBl.setStrokeWidth(gBe * 7);
    gBl.setColor(549174203);
    AppMethodBeat.o(9245);
  }
  
  public a()
  {
    AppMethodBeat.i(9241);
    this.gBp = new Rect();
    this.gBq = new Rect();
    this.mMatrix = new Matrix();
    AppMethodBeat.o(9241);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(9240);
    this.gBp = new Rect();
    this.gBq = new Rect();
    this.mMatrix = new Matrix();
    this.cQy = paramRect;
    AppMethodBeat.o(9240);
  }
  
  public static void mA(int paramInt)
  {
    AppMethodBeat.i(9242);
    gBo.setAlpha(paramInt);
    gBk.setAlpha(paramInt);
    gBn.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(9242);
  }
  
  public static void mB(int paramInt)
  {
    AppMethodBeat.i(9243);
    gBm.setAlpha((int)(0.9019608F * paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.a
 * JD-Core Version:    0.7.0.1
 */