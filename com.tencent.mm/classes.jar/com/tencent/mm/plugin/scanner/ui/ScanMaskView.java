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
  private Rect IRA;
  private Rect IRB;
  private Rect IRC;
  private Rect IRD;
  private Rect IRE;
  private Rect IRF;
  private Rect IRG;
  private Rect IRH;
  private Rect IRI;
  private int IRJ;
  private long IRK;
  private boolean IRL;
  private int IRM;
  private float IRN;
  private float IRO;
  private float IRP;
  private float IRQ;
  private Paint IRR;
  private ValueAnimator IRS;
  private a IRT;
  private Bitmap IRs;
  private Bitmap IRt;
  private Bitmap IRu;
  private Bitmap IRv;
  int IRw;
  int IRx;
  private boolean IRy;
  private Rect IRz;
  private Paint mPaint;
  private Path uWB;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.IRs = null;
    this.IRt = null;
    this.IRu = null;
    this.IRv = null;
    this.IRw = 0;
    this.IRx = 0;
    this.IRy = false;
    this.IRz = new Rect();
    this.IRA = new Rect();
    this.IRB = new Rect();
    this.IRC = new Rect();
    this.IRD = new Rect();
    this.IRE = new Rect();
    this.IRF = new Rect();
    this.IRG = new Rect();
    this.IRH = new Rect();
    this.uWB = new Path();
    this.IRJ = l.c.scan_mask_bg_color;
    this.IRK = 0L;
    this.IRL = false;
    this.IRM = 300;
    this.IRN = 0.0F;
    this.IRO = 0.0F;
    this.IRP = 0.0F;
    this.IRQ = 0.0F;
    this.IRS = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.IRM;
  }
  
  public Rect getMaskRect()
  {
    return this.IRI;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.IRI == null) || (this.IRy))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.qW(18))
    {
      this.IRE.left = 0;
      this.IRE.top = this.IRI.top;
      this.IRE.right = this.IRI.left;
      this.IRE.bottom = this.IRI.bottom;
      this.IRF.left = this.IRI.left;
      this.IRF.top = 0;
      this.IRF.right = this.IRI.right;
      this.IRF.bottom = this.IRI.top;
      this.IRG.left = this.IRI.right;
      this.IRG.top = this.IRI.top;
      this.IRG.right = getWidth();
      this.IRG.bottom = this.IRI.bottom;
      this.IRH.left = this.IRI.left;
      this.IRH.top = this.IRI.bottom;
      this.IRH.right = this.IRI.right;
      this.IRH.bottom = getHeight();
      this.IRA.left = 0;
      this.IRA.top = 0;
      this.IRA.right = this.IRI.left;
      this.IRA.bottom = this.IRI.top;
      this.IRB.left = this.IRI.right;
      this.IRB.top = 0;
      this.IRB.right = getWidth();
      this.IRB.bottom = this.IRI.top;
      this.IRC.left = 0;
      this.IRC.top = this.IRI.bottom;
      this.IRC.right = this.IRI.left;
      this.IRC.bottom = getHeight();
      this.IRD.left = this.IRI.right;
      this.IRD.top = this.IRI.bottom;
      this.IRD.right = getWidth();
      this.IRD.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRE, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRF, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRG, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRH, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRA, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRB, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRC, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.IRD, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
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
      paramCanvas.drawRect(this.IRI, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.IRs, this.IRI.left, this.IRI.top, this.IRR);
      paramCanvas.drawBitmap(this.IRt, this.IRI.right - this.IRw, this.IRI.top, this.IRR);
      paramCanvas.drawBitmap(this.IRu, this.IRI.left, this.IRI.bottom - this.IRx, this.IRR);
      paramCanvas.drawBitmap(this.IRv, this.IRI.right - this.IRw, this.IRI.bottom - this.IRx, this.IRR);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.IRI, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.IRJ));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.IRT = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.IRJ = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.IRM = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */