package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.scanner.l.c;

public class ScanMaskView
  extends View
{
  private Rect PaA;
  private Rect PaB;
  private Rect PaC;
  private Rect PaD;
  private int PaE;
  private long PaF;
  private boolean PaG;
  private int PaH;
  private float PaI;
  private float PaJ;
  private float PaK;
  private float PaL;
  private Paint PaM;
  private ValueAnimator PaN;
  private a PaO;
  private Bitmap Pan;
  private Bitmap Pao;
  private Bitmap Pap;
  private Bitmap Paq;
  int Par;
  int Pas;
  private boolean Pat;
  private Rect Pau;
  private Rect Pav;
  private Rect Paw;
  private Rect Pax;
  private Rect Pay;
  private Rect Paz;
  private Paint mPaint;
  private Path yjb;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Par = 0;
    this.Pas = 0;
    this.Pat = false;
    this.Pau = new Rect();
    this.Pav = new Rect();
    this.Paw = new Rect();
    this.Pax = new Rect();
    this.Pay = new Rect();
    this.Paz = new Rect();
    this.PaA = new Rect();
    this.PaB = new Rect();
    this.PaC = new Rect();
    this.yjb = new Path();
    this.PaE = l.c.scan_mask_bg_color;
    this.PaF = 0L;
    this.PaG = false;
    this.PaH = 300;
    this.PaI = 0.0F;
    this.PaJ = 0.0F;
    this.PaK = 0.0F;
    this.PaL = 0.0F;
    this.PaN = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.PaH;
  }
  
  public Rect getMaskRect()
  {
    return this.PaD;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.PaD == null) || (this.Pat))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.rc(18))
    {
      this.Paz.left = 0;
      this.Paz.top = this.PaD.top;
      this.Paz.right = this.PaD.left;
      this.Paz.bottom = this.PaD.bottom;
      this.PaA.left = this.PaD.left;
      this.PaA.top = 0;
      this.PaA.right = this.PaD.right;
      this.PaA.bottom = this.PaD.top;
      this.PaB.left = this.PaD.right;
      this.PaB.top = this.PaD.top;
      this.PaB.right = getWidth();
      this.PaB.bottom = this.PaD.bottom;
      this.PaC.left = this.PaD.left;
      this.PaC.top = this.PaD.bottom;
      this.PaC.right = this.PaD.right;
      this.PaC.bottom = getHeight();
      this.Pav.left = 0;
      this.Pav.top = 0;
      this.Pav.right = this.PaD.left;
      this.Pav.bottom = this.PaD.top;
      this.Paw.left = this.PaD.right;
      this.Paw.top = 0;
      this.Paw.right = getWidth();
      this.Paw.bottom = this.PaD.top;
      this.Pax.left = 0;
      this.Pax.top = this.PaD.bottom;
      this.Pax.right = this.PaD.left;
      this.Pax.bottom = getHeight();
      this.Pay.left = this.PaD.right;
      this.Pay.top = this.PaD.bottom;
      this.Pay.right = getWidth();
      this.Pay.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.Paz, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.PaA, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.PaB, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.PaC, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.Pav, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.Paw, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.Pax, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.Pay, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
      paramCanvas.restore();
    }
    for (;;)
    {
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.restoreToCount(i);
      this.mPaint.reset();
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(1.0F);
      this.mPaint.setColor(-3355444);
      this.mPaint.setAntiAlias(true);
      paramCanvas.drawRect(this.PaD, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.Pan, this.PaD.left, this.PaD.top, this.PaM);
      paramCanvas.drawBitmap(this.Pao, this.PaD.right - this.Par, this.PaD.top, this.PaM);
      paramCanvas.drawBitmap(this.Pap, this.PaD.left, this.PaD.bottom - this.Pas, this.PaM);
      paramCanvas.drawBitmap(this.Paq, this.PaD.right - this.Par, this.PaD.bottom - this.Pas, this.PaM);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.PaD, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.PaE));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.PaO = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.PaE = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.PaH = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */