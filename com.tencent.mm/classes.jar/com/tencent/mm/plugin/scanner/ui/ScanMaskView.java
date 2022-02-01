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
  private Bitmap CLS;
  private Bitmap CLT;
  private Bitmap CLU;
  private Bitmap CLV;
  int CLW;
  int CLX;
  private boolean CLY;
  private Rect CLZ;
  private Rect CMa;
  private Rect CMb;
  private Rect CMc;
  private Rect CMd;
  private Rect CMe;
  private Rect CMf;
  private Rect CMg;
  private Rect CMh;
  private Rect CMi;
  private int CMj;
  private long CMk;
  private boolean CMl;
  private int CMm;
  private float CMn;
  private float CMo;
  private float CMp;
  private float CMq;
  private Paint CMr;
  private ValueAnimator CMs;
  private a CMt;
  private Paint mPaint;
  private Path rqV;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.CLS = null;
    this.CLT = null;
    this.CLU = null;
    this.CLV = null;
    this.CLW = 0;
    this.CLX = 0;
    this.CLY = false;
    this.CLZ = new Rect();
    this.CMa = new Rect();
    this.CMb = new Rect();
    this.CMc = new Rect();
    this.CMd = new Rect();
    this.CMe = new Rect();
    this.CMf = new Rect();
    this.CMg = new Rect();
    this.CMh = new Rect();
    this.rqV = new Path();
    this.CMj = 2131101017;
    this.CMk = 0L;
    this.CMl = false;
    this.CMm = 300;
    this.CMn = 0.0F;
    this.CMo = 0.0F;
    this.CMp = 0.0F;
    this.CMq = 0.0F;
    this.CMs = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.CMm;
  }
  
  public Rect getMaskRect()
  {
    return this.CMi;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.CMi == null) || (this.CLY))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.oE(18))
    {
      this.CMe.left = 0;
      this.CMe.top = this.CMi.top;
      this.CMe.right = this.CMi.left;
      this.CMe.bottom = this.CMi.bottom;
      this.CMf.left = this.CMi.left;
      this.CMf.top = 0;
      this.CMf.right = this.CMi.right;
      this.CMf.bottom = this.CMi.top;
      this.CMg.left = this.CMi.right;
      this.CMg.top = this.CMi.top;
      this.CMg.right = getWidth();
      this.CMg.bottom = this.CMi.bottom;
      this.CMh.left = this.CMi.left;
      this.CMh.top = this.CMi.bottom;
      this.CMh.right = this.CMi.right;
      this.CMh.bottom = getHeight();
      this.CMa.left = 0;
      this.CMa.top = 0;
      this.CMa.right = this.CMi.left;
      this.CMa.bottom = this.CMi.top;
      this.CMb.left = this.CMi.right;
      this.CMb.top = 0;
      this.CMb.right = getWidth();
      this.CMb.bottom = this.CMi.top;
      this.CMc.left = 0;
      this.CMc.top = this.CMi.bottom;
      this.CMc.right = this.CMi.left;
      this.CMc.bottom = getHeight();
      this.CMd.left = this.CMi.right;
      this.CMd.top = this.CMi.bottom;
      this.CMd.right = getWidth();
      this.CMd.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMe, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMf, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMg, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMh, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMa, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMb, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMc, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.CMd, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
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
      paramCanvas.drawRect(this.CMi, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.CLS, this.CMi.left, this.CMi.top, this.CMr);
      paramCanvas.drawBitmap(this.CLT, this.CMi.right - this.CLW, this.CMi.top, this.CMr);
      paramCanvas.drawBitmap(this.CLU, this.CMi.left, this.CMi.bottom - this.CLX, this.CMr);
      paramCanvas.drawBitmap(this.CLV, this.CMi.right - this.CLW, this.CMi.bottom - this.CLX, this.CMr);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.CMi, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.CMj));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.CMt = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.CMj = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.CMm = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */