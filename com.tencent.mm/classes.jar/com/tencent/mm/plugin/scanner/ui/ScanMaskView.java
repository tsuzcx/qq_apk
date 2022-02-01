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
  private Path oMy;
  private Rect vTA;
  private Rect vTB;
  private Rect vTC;
  private Rect vTD;
  private Rect vTE;
  private Rect vTF;
  private Rect vTG;
  private Rect vTH;
  private Rect vTI;
  private int vTJ;
  private long vTK;
  private boolean vTL;
  private int vTM;
  private float vTN;
  private float vTO;
  private float vTP;
  private float vTQ;
  private Paint vTR;
  private ValueAnimator vTS;
  private a vTT;
  private Bitmap vTs;
  private Bitmap vTt;
  private Bitmap vTu;
  private Bitmap vTv;
  int vTw;
  int vTx;
  private boolean vTy;
  private Rect vTz;
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51913);
    this.vTs = null;
    this.vTt = null;
    this.vTu = null;
    this.vTv = null;
    this.vTw = 0;
    this.vTx = 0;
    this.vTy = false;
    this.vTz = new Rect();
    this.vTA = new Rect();
    this.vTB = new Rect();
    this.vTC = new Rect();
    this.vTD = new Rect();
    this.vTE = new Rect();
    this.vTF = new Rect();
    this.vTG = new Rect();
    this.vTH = new Rect();
    this.oMy = new Path();
    this.vTJ = 2131100819;
    this.vTK = 0L;
    this.vTL = false;
    this.vTM = 300;
    this.vTN = 0.0F;
    this.vTO = 0.0F;
    this.vTP = 0.0F;
    this.vTQ = 0.0F;
    this.vTS = null;
    AppMethodBeat.o(51913);
  }
  
  public int getMaskAnimDuration()
  {
    return this.vTM;
  }
  
  public Rect getMaskRect()
  {
    return this.vTI;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51914);
    if ((this.vTI == null) || (this.vTy))
    {
      AppMethodBeat.o(51914);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.lg(18))
    {
      this.vTE.left = 0;
      this.vTE.top = this.vTI.top;
      this.vTE.right = this.vTI.left;
      this.vTE.bottom = this.vTI.bottom;
      this.vTF.left = this.vTI.left;
      this.vTF.top = 0;
      this.vTF.right = this.vTI.right;
      this.vTF.bottom = this.vTI.top;
      this.vTG.left = this.vTI.right;
      this.vTG.top = this.vTI.top;
      this.vTG.right = getWidth();
      this.vTG.bottom = this.vTI.bottom;
      this.vTH.left = this.vTI.left;
      this.vTH.top = this.vTI.bottom;
      this.vTH.right = this.vTI.right;
      this.vTH.bottom = getHeight();
      this.vTA.left = 0;
      this.vTA.top = 0;
      this.vTA.right = this.vTI.left;
      this.vTA.bottom = this.vTI.top;
      this.vTB.left = this.vTI.right;
      this.vTB.top = 0;
      this.vTB.right = getWidth();
      this.vTB.bottom = this.vTI.top;
      this.vTC.left = 0;
      this.vTC.top = this.vTI.bottom;
      this.vTC.right = this.vTI.left;
      this.vTC.bottom = getHeight();
      this.vTD.left = this.vTI.right;
      this.vTD.top = this.vTI.bottom;
      this.vTD.right = getWidth();
      this.vTD.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTE, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTF, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTG, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTH, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTA, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTB, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTC, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.vTD, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
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
      paramCanvas.drawRect(this.vTI, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.vTs, this.vTI.left, this.vTI.top, this.vTR);
      paramCanvas.drawBitmap(this.vTt, this.vTI.right - this.vTw, this.vTI.top, this.vTR);
      paramCanvas.drawBitmap(this.vTu, this.vTI.left, this.vTI.bottom - this.vTx, this.vTR);
      paramCanvas.drawBitmap(this.vTv, this.vTI.right - this.vTw, this.vTI.bottom - this.vTx, this.vTR);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(51914);
      return;
      paramCanvas.clipRect(this.vTI, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.vTJ));
    }
  }
  
  public void setMaskAnimaListener(a parama)
  {
    this.vTT = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.vTJ = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.vTM = paramInt;
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */