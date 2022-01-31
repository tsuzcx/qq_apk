package com.tencent.mm.y;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  implements Cloneable
{
  private static int eFb;
  private static int eFc;
  public static float eFd;
  public static float eFe;
  public static Path eFf;
  public static Path eFg;
  public static Paint eFh;
  public static Paint eFi;
  public static Paint eFj;
  public static Paint eFk;
  public static Paint eFl;
  public static Rect hV;
  public Rect bVv;
  public Rect eFm;
  public Rect eFn;
  public Matrix mMatrix;
  
  static
  {
    AppMethodBeat.i(116269);
    eFb = (int)ah.getResources().getDimension(2131428145);
    eFc = (int)ah.getResources().getDimension(2131428144);
    eFd = ah.getResources().getDimension(2131428262);
    eFe = ah.getResources().getDimension(2131428261);
    eFf = new Path();
    eFg = new Path();
    eFh = new Paint();
    eFi = new Paint();
    eFj = new Paint();
    eFk = new Paint();
    eFl = new Paint();
    hV = new Rect();
    eFj.setColor(-16777216);
    eFh.setColor(-1);
    eFh.setStrokeWidth(eFb);
    eFh.setStyle(Paint.Style.STROKE);
    eFh.setAntiAlias(true);
    eFk.set(eFh);
    eFk.setStrokeWidth(eFc);
    eFl.set(eFh);
    eFl.setStrokeWidth(eFd);
    eFi.set(eFh);
    eFi.setStrokeWidth(eFb * 7);
    eFi.setColor(549174203);
    AppMethodBeat.o(116269);
  }
  
  public a()
  {
    AppMethodBeat.i(116265);
    this.eFm = new Rect();
    this.eFn = new Rect();
    this.mMatrix = new Matrix();
    AppMethodBeat.o(116265);
  }
  
  public a(Rect paramRect)
  {
    AppMethodBeat.i(116264);
    this.eFm = new Rect();
    this.eFn = new Rect();
    this.mMatrix = new Matrix();
    this.bVv = paramRect;
    AppMethodBeat.o(116264);
  }
  
  public static void jw(int paramInt)
  {
    AppMethodBeat.i(116266);
    eFl.setAlpha(paramInt);
    eFh.setAlpha(paramInt);
    eFk.setAlpha((int)(0.7058824F * paramInt));
    AppMethodBeat.o(116266);
  }
  
  public static void jx(int paramInt)
  {
    AppMethodBeat.i(116267);
    eFj.setAlpha((int)(0.9019608F * paramInt));
    AppMethodBeat.o(116267);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(116268);
    Object localObject = super.clone();
    AppMethodBeat.o(116268);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.y.a
 * JD-Core Version:    0.7.0.1
 */