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

public class ScanMaskView
  extends View
{
  private Paint mPaint;
  private Path ppS;
  private float xeA;
  private float xeB;
  private Paint xeC;
  private ValueAnimator xeD;
  private a xeE;
  private Bitmap xed;
  private Bitmap xee;
  private Bitmap xef;
  private Bitmap xeg;
  int xeh;
  int xei;
  private boolean xej;
  private Rect xek;
  private Rect xel;
  private Rect xem;
  private Rect xen;
  private Rect xeo;
  private Rect xep;
  private Rect xeq;
  private Rect xer;
  private Rect xes;
  private Rect xet;
  private int xeu;
  private long xev;
  private boolean xew;
  private int xex;
  private float xey;
  private float xez;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.xed = null;
    this.xee = null;
    this.xef = null;
    this.xeg = null;
    this.xeh = 0;
    this.xei = 0;
    this.xej = false;
    this.xek = new Rect();
    this.xel = new Rect();
    this.xem = new Rect();
    this.xen = new Rect();
    this.xeo = new Rect();
    this.xep = new Rect();
    this.xeq = new Rect();
    this.xer = new Rect();
    this.xes = new Rect();
    this.ppS = new Path();
    this.xeu = 2131100819;
    this.xev = 0L;
    this.xew = false;
    this.xex = 300;
    this.xey = 0.0F;
    this.xez = 0.0F;
    this.xeA = 0.0F;
    this.xeB = 0.0F;
    this.xeD = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.xex;
  }
  
  public Rect getMaskRect()
  {
    return this.xet;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.xet == null) || (this.xej))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.la(18))
    {
      this.xep.left = 0;
      this.xep.top = this.xet.top;
      this.xep.right = this.xet.left;
      this.xep.bottom = this.xet.bottom;
      this.xeq.left = this.xet.left;
      this.xeq.top = 0;
      this.xeq.right = this.xet.right;
      this.xeq.bottom = this.xet.top;
      this.xer.left = this.xet.right;
      this.xer.top = this.xet.top;
      this.xer.right = getWidth();
      this.xer.bottom = this.xet.bottom;
      this.xes.left = this.xet.left;
      this.xes.top = this.xet.bottom;
      this.xes.right = this.xet.right;
      this.xes.bottom = getHeight();
      this.xel.left = 0;
      this.xel.top = 0;
      this.xel.right = this.xet.left;
      this.xel.bottom = this.xet.top;
      this.xem.left = this.xet.right;
      this.xem.top = 0;
      this.xem.right = getWidth();
      this.xem.bottom = this.xet.top;
      this.xen.left = 0;
      this.xen.top = this.xet.bottom;
      this.xen.right = this.xet.left;
      this.xen.bottom = getHeight();
      this.xeo.left = this.xet.right;
      this.xeo.top = this.xet.bottom;
      this.xeo.right = getWidth();
      this.xeo.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.xep, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xeq, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xer, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xes, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xel, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xem, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xen, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.xeo, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
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
      paramCanvas.drawRect(this.xet, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.xed, this.xet.left, this.xet.top, this.xeC);
      paramCanvas.drawBitmap(this.xee, this.xet.right - this.xeh, this.xet.top, this.xeC);
      paramCanvas.drawBitmap(this.xef, this.xet.left, this.xet.bottom - this.xei, this.xeC);
      paramCanvas.drawBitmap(this.xeg, this.xet.right - this.xeh, this.xet.bottom - this.xei, this.xeC);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.xet, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.xeu));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.xeE = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.xeu = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.xex = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */