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
  private Path pZY;
  private float yIA;
  private float yIB;
  private float yIC;
  private float yID;
  private Paint yIE;
  private ValueAnimator yIF;
  private a yIG;
  private Bitmap yIf;
  private Bitmap yIg;
  private Bitmap yIh;
  private Bitmap yIi;
  int yIj;
  int yIk;
  private boolean yIl;
  private Rect yIm;
  private Rect yIn;
  private Rect yIo;
  private Rect yIp;
  private Rect yIq;
  private Rect yIr;
  private Rect yIs;
  private Rect yIt;
  private Rect yIu;
  private Rect yIv;
  private int yIw;
  private long yIx;
  private boolean yIy;
  private int yIz;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.yIf = null;
    this.yIg = null;
    this.yIh = null;
    this.yIi = null;
    this.yIj = 0;
    this.yIk = 0;
    this.yIl = false;
    this.yIm = new Rect();
    this.yIn = new Rect();
    this.yIo = new Rect();
    this.yIp = new Rect();
    this.yIq = new Rect();
    this.yIr = new Rect();
    this.yIs = new Rect();
    this.yIt = new Rect();
    this.yIu = new Rect();
    this.pZY = new Path();
    this.yIw = 2131100819;
    this.yIx = 0L;
    this.yIy = false;
    this.yIz = 300;
    this.yIA = 0.0F;
    this.yIB = 0.0F;
    this.yIC = 0.0F;
    this.yID = 0.0F;
    this.yIF = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.yIz;
  }
  
  public Rect getMaskRect()
  {
    return this.yIv;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.yIv == null) || (this.yIl))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.lB(18))
    {
      this.yIr.left = 0;
      this.yIr.top = this.yIv.top;
      this.yIr.right = this.yIv.left;
      this.yIr.bottom = this.yIv.bottom;
      this.yIs.left = this.yIv.left;
      this.yIs.top = 0;
      this.yIs.right = this.yIv.right;
      this.yIs.bottom = this.yIv.top;
      this.yIt.left = this.yIv.right;
      this.yIt.top = this.yIv.top;
      this.yIt.right = getWidth();
      this.yIt.bottom = this.yIv.bottom;
      this.yIu.left = this.yIv.left;
      this.yIu.top = this.yIv.bottom;
      this.yIu.right = this.yIv.right;
      this.yIu.bottom = getHeight();
      this.yIn.left = 0;
      this.yIn.top = 0;
      this.yIn.right = this.yIv.left;
      this.yIn.bottom = this.yIv.top;
      this.yIo.left = this.yIv.right;
      this.yIo.top = 0;
      this.yIo.right = getWidth();
      this.yIo.bottom = this.yIv.top;
      this.yIp.left = 0;
      this.yIp.top = this.yIv.bottom;
      this.yIp.right = this.yIv.left;
      this.yIp.bottom = getHeight();
      this.yIq.left = this.yIv.right;
      this.yIq.top = this.yIv.bottom;
      this.yIq.right = getWidth();
      this.yIq.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIr, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIs, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIt, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIu, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIn, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIo, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIp, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.yIq, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
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
      paramCanvas.drawRect(this.yIv, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.yIf, this.yIv.left, this.yIv.top, this.yIE);
      paramCanvas.drawBitmap(this.yIg, this.yIv.right - this.yIj, this.yIv.top, this.yIE);
      paramCanvas.drawBitmap(this.yIh, this.yIv.left, this.yIv.bottom - this.yIk, this.yIE);
      paramCanvas.drawBitmap(this.yIi, this.yIv.right - this.yIj, this.yIv.bottom - this.yIk, this.yIE);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.yIv, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.yIw));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.yIG = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.yIw = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.yIz = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */