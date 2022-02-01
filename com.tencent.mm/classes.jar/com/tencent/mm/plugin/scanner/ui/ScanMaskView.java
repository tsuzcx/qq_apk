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
  private Path pTt;
  private float ysA;
  private float ysB;
  private float ysC;
  private float ysD;
  private Paint ysE;
  private ValueAnimator ysF;
  private a ysG;
  private Bitmap ysf;
  private Bitmap ysg;
  private Bitmap ysh;
  private Bitmap ysi;
  int ysj;
  int ysk;
  private boolean ysl;
  private Rect ysm;
  private Rect ysn;
  private Rect yso;
  private Rect ysp;
  private Rect ysq;
  private Rect ysr;
  private Rect yss;
  private Rect yst;
  private Rect ysu;
  private Rect ysv;
  private int ysw;
  private long ysx;
  private boolean ysy;
  private int ysz;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.ysf = null;
    this.ysg = null;
    this.ysh = null;
    this.ysi = null;
    this.ysj = 0;
    this.ysk = 0;
    this.ysl = false;
    this.ysm = new Rect();
    this.ysn = new Rect();
    this.yso = new Rect();
    this.ysp = new Rect();
    this.ysq = new Rect();
    this.ysr = new Rect();
    this.yss = new Rect();
    this.yst = new Rect();
    this.ysu = new Rect();
    this.pTt = new Path();
    this.ysw = 2131100819;
    this.ysx = 0L;
    this.ysy = false;
    this.ysz = 300;
    this.ysA = 0.0F;
    this.ysB = 0.0F;
    this.ysC = 0.0F;
    this.ysD = 0.0F;
    this.ysF = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.ysz;
  }
  
  public Rect getMaskRect()
  {
    return this.ysv;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.ysv == null) || (this.ysl))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.lz(18))
    {
      this.ysr.left = 0;
      this.ysr.top = this.ysv.top;
      this.ysr.right = this.ysv.left;
      this.ysr.bottom = this.ysv.bottom;
      this.yss.left = this.ysv.left;
      this.yss.top = 0;
      this.yss.right = this.ysv.right;
      this.yss.bottom = this.ysv.top;
      this.yst.left = this.ysv.right;
      this.yst.top = this.ysv.top;
      this.yst.right = getWidth();
      this.yst.bottom = this.ysv.bottom;
      this.ysu.left = this.ysv.left;
      this.ysu.top = this.ysv.bottom;
      this.ysu.right = this.ysv.right;
      this.ysu.bottom = getHeight();
      this.ysn.left = 0;
      this.ysn.top = 0;
      this.ysn.right = this.ysv.left;
      this.ysn.bottom = this.ysv.top;
      this.yso.left = this.ysv.right;
      this.yso.top = 0;
      this.yso.right = getWidth();
      this.yso.bottom = this.ysv.top;
      this.ysp.left = 0;
      this.ysp.top = this.ysv.bottom;
      this.ysp.right = this.ysv.left;
      this.ysp.bottom = getHeight();
      this.ysq.left = this.ysv.right;
      this.ysq.top = this.ysv.bottom;
      this.ysq.right = getWidth();
      this.ysq.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.ysr, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yss, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yst, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.ysu, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.ysn, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yso, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.ysp, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.ysq, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
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
      paramCanvas.drawRect(this.ysv, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.ysf, this.ysv.left, this.ysv.top, this.ysE);
      paramCanvas.drawBitmap(this.ysg, this.ysv.right - this.ysj, this.ysv.top, this.ysE);
      paramCanvas.drawBitmap(this.ysh, this.ysv.left, this.ysv.bottom - this.ysk, this.ysE);
      paramCanvas.drawBitmap(this.ysi, this.ysv.right - this.ysj, this.ysv.bottom - this.ysk, this.ysE);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.ysv, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.ysw));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.ysG = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.ysw = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.ysz = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */