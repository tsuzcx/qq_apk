package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView
  extends View
{
  private Path jkG = new Path();
  private Paint mPaint;
  private Bitmap nKO = null;
  private Bitmap nKP = null;
  private Bitmap nKQ = null;
  private Bitmap nKR = null;
  int nKS = 0;
  int nKT = 0;
  private boolean nKU = false;
  private Rect nKV = new Rect();
  private Rect nKW = new Rect();
  private Rect nKX = new Rect();
  private Rect nKY = new Rect();
  private Rect nKZ = new Rect();
  private Rect nLa = new Rect();
  private Rect nLb = new Rect();
  private Rect nLc = new Rect();
  private Rect nLd = new Rect();
  Rect nLe;
  private PorterDuffXfermode nLf;
  private int nLg = R.e.scan_mask_bg_color;
  private long nLh = 0L;
  boolean nLi = false;
  Rect nLj;
  int nLk = 300;
  float nLl = 0.0F;
  float nLm = 0.0F;
  float nLn = 0.0F;
  float nLo = 0.0F;
  private Paint nLp;
  ValueAnimator nLq = null;
  private ScanMaskView.a nLr;
  
  public ScanMaskView(Context paramContext, Rect paramRect)
  {
    super(paramContext);
    this.nLe = paramRect;
    getDrawingRect(this.nKV);
    this.mPaint = new Paint();
    this.nKO = a.decodeResource(getResources(), R.g.scanqr1);
    this.nKP = a.decodeResource(getResources(), R.g.scanqr2);
    this.nKQ = a.decodeResource(getResources(), R.g.scanqr3);
    this.nKR = a.decodeResource(getResources(), R.g.scanqr4);
    this.nKS = this.nKO.getWidth();
    this.nKT = this.nKO.getHeight();
    this.nLp = new Paint();
    this.nLf = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  }
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void bxP()
  {
    this.nKU = true;
    if (this.nKO != null)
    {
      this.nKO.recycle();
      this.nKO = null;
    }
    if (this.nKP != null)
    {
      this.nKP.recycle();
      this.nKP = null;
    }
    if (this.nKQ != null)
    {
      this.nKQ.recycle();
      this.nKQ = null;
    }
    if (this.nKR != null)
    {
      this.nKR.recycle();
      this.nKR = null;
    }
  }
  
  public int getMaskAnimDuration()
  {
    return this.nLk;
  }
  
  public Rect getMaskRect()
  {
    return this.nLe;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.nLe == null) || (this.nKU)) {
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.gG(18))
    {
      this.nLa.left = 0;
      this.nLa.top = this.nLe.top;
      this.nLa.right = this.nLe.left;
      this.nLa.bottom = this.nLe.bottom;
      this.nLb.left = this.nLe.left;
      this.nLb.top = 0;
      this.nLb.right = this.nLe.right;
      this.nLb.bottom = this.nLe.top;
      this.nLc.left = this.nLe.right;
      this.nLc.top = this.nLe.top;
      this.nLc.right = getWidth();
      this.nLc.bottom = this.nLe.bottom;
      this.nLd.left = this.nLe.left;
      this.nLd.top = this.nLe.bottom;
      this.nLd.right = this.nLe.right;
      this.nLd.bottom = getHeight();
      this.nKW.left = 0;
      this.nKW.top = 0;
      this.nKW.right = this.nLe.left;
      this.nKW.bottom = this.nLe.top;
      this.nKX.left = this.nLe.right;
      this.nKX.top = 0;
      this.nKX.right = getWidth();
      this.nKX.bottom = this.nLe.top;
      this.nKY.left = 0;
      this.nKY.top = this.nLe.bottom;
      this.nKY.right = this.nLe.left;
      this.nKY.bottom = getHeight();
      this.nKZ.left = this.nLe.right;
      this.nKZ.top = this.nLe.bottom;
      this.nKZ.right = getWidth();
      this.nKZ.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.nLa, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nLb, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nLc, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nLd, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nKW, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nKX, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nKY, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.nKZ, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
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
      paramCanvas.drawRect(this.nLe, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.nKO, this.nLe.left, this.nLe.top, this.nLp);
      paramCanvas.drawBitmap(this.nKP, this.nLe.right - this.nKS, this.nLe.top, this.nLp);
      paramCanvas.drawBitmap(this.nKQ, this.nLe.left, this.nLe.bottom - this.nKT, this.nLp);
      paramCanvas.drawBitmap(this.nKR, this.nLe.right - this.nKS, this.nLe.bottom - this.nKT, this.nLp);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      return;
      paramCanvas.clipRect(this.nLe, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.nLg));
    }
  }
  
  public void setMaskAnimaListener(ScanMaskView.a parama)
  {
    this.nLr = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.nLg = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.nLk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */