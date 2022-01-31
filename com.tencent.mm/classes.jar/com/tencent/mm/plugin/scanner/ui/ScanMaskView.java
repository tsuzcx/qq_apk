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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

public class ScanMaskView
  extends View
{
  private Path lwd;
  private Paint mPaint;
  private Rect qyA;
  private Rect qyB;
  private Rect qyC;
  private Rect qyD;
  private Rect qyE;
  private Rect qyF;
  private Rect qyG;
  private Rect qyH;
  private Rect qyI;
  private Rect qyJ;
  private PorterDuffXfermode qyK;
  private int qyL;
  private long qyM;
  private boolean qyN;
  private Rect qyO;
  private int qyP;
  private float qyQ;
  private float qyR;
  private float qyS;
  private float qyT;
  private Paint qyU;
  private ValueAnimator qyV;
  private ScanMaskView.a qyW;
  private Bitmap qyt;
  private Bitmap qyu;
  private Bitmap qyv;
  private Bitmap qyw;
  int qyx;
  int qyy;
  private boolean qyz;
  
  public ScanMaskView(Context paramContext, Rect paramRect)
  {
    super(paramContext);
    AppMethodBeat.i(81150);
    this.qyt = null;
    this.qyu = null;
    this.qyv = null;
    this.qyw = null;
    this.qyx = 0;
    this.qyy = 0;
    this.qyz = false;
    this.qyA = new Rect();
    this.qyB = new Rect();
    this.qyC = new Rect();
    this.qyD = new Rect();
    this.qyE = new Rect();
    this.qyF = new Rect();
    this.qyG = new Rect();
    this.qyH = new Rect();
    this.qyI = new Rect();
    this.lwd = new Path();
    this.qyL = 2131690409;
    this.qyM = 0L;
    this.qyN = false;
    this.qyP = 300;
    this.qyQ = 0.0F;
    this.qyR = 0.0F;
    this.qyS = 0.0F;
    this.qyT = 0.0F;
    this.qyV = null;
    this.qyJ = paramRect;
    getDrawingRect(this.qyA);
    this.mPaint = new Paint();
    this.qyt = a.decodeResource(getResources(), 2130840208);
    this.qyu = a.decodeResource(getResources(), 2130840209);
    this.qyv = a.decodeResource(getResources(), 2130840210);
    this.qyw = a.decodeResource(getResources(), 2130840211);
    this.qyx = this.qyt.getWidth();
    this.qyy = this.qyt.getHeight();
    this.qyU = new Paint();
    this.qyK = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    AppMethodBeat.o(81150);
  }
  
  public ScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(81149);
    this.qyt = null;
    this.qyu = null;
    this.qyv = null;
    this.qyw = null;
    this.qyx = 0;
    this.qyy = 0;
    this.qyz = false;
    this.qyA = new Rect();
    this.qyB = new Rect();
    this.qyC = new Rect();
    this.qyD = new Rect();
    this.qyE = new Rect();
    this.qyF = new Rect();
    this.qyG = new Rect();
    this.qyH = new Rect();
    this.qyI = new Rect();
    this.lwd = new Path();
    this.qyL = 2131690409;
    this.qyM = 0L;
    this.qyN = false;
    this.qyP = 300;
    this.qyQ = 0.0F;
    this.qyR = 0.0F;
    this.qyS = 0.0F;
    this.qyT = 0.0F;
    this.qyV = null;
    AppMethodBeat.o(81149);
  }
  
  public final void ciQ()
  {
    AppMethodBeat.i(81151);
    this.qyz = true;
    if (this.qyt != null)
    {
      ab.i("ScanMaskView", "bitmap recycle %s", new Object[] { this.qyt.toString() });
      this.qyt.recycle();
      this.qyt = null;
    }
    if (this.qyu != null)
    {
      ab.i("ScanMaskView", "bitmap recycle %s", new Object[] { this.qyu.toString() });
      this.qyu.recycle();
      this.qyu = null;
    }
    if (this.qyv != null)
    {
      ab.i("ScanMaskView", "bitmap recycle %s", new Object[] { this.qyv.toString() });
      this.qyv.recycle();
      this.qyv = null;
    }
    if (this.qyw != null)
    {
      ab.i("ScanMaskView", "bitmap recycle %s", new Object[] { this.qyw.toString() });
      this.qyw.recycle();
      this.qyw = null;
    }
    AppMethodBeat.o(81151);
  }
  
  public int getMaskAnimDuration()
  {
    return this.qyP;
  }
  
  public Rect getMaskRect()
  {
    return this.qyJ;
  }
  
  public final void l(Rect paramRect)
  {
    AppMethodBeat.i(81152);
    if ((paramRect.left == this.qyJ.left) && (paramRect.right == this.qyJ.right) && (paramRect.top == this.qyJ.top) && (paramRect.bottom == this.qyJ.bottom))
    {
      AppMethodBeat.o(81152);
      return;
    }
    this.qyQ = (paramRect.left - this.qyJ.left);
    this.qyR = (paramRect.right - this.qyJ.right);
    this.qyS = (paramRect.top - this.qyJ.top);
    this.qyT = (paramRect.bottom - this.qyJ.bottom);
    this.qyO = new Rect(this.qyJ.left, this.qyJ.top, this.qyJ.right, this.qyJ.bottom);
    this.qyN = true;
    this.qyV = new ValueAnimator();
    this.qyV.setFloatValues(new float[] { 0.0F, 1.0F });
    this.qyV.setDuration(this.qyP);
    this.qyV.addUpdateListener(new ScanMaskView.1(this));
    this.qyV.start();
    this.qyV.addListener(new ScanMaskView.2(this));
    AppMethodBeat.o(81152);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(81153);
    if ((this.qyJ == null) || (this.qyz))
    {
      AppMethodBeat.o(81153);
      return;
    }
    System.currentTimeMillis();
    System.currentTimeMillis();
    int i = paramCanvas.save();
    this.mPaint.reset();
    if (d.fw(18))
    {
      this.qyF.left = 0;
      this.qyF.top = this.qyJ.top;
      this.qyF.right = this.qyJ.left;
      this.qyF.bottom = this.qyJ.bottom;
      this.qyG.left = this.qyJ.left;
      this.qyG.top = 0;
      this.qyG.right = this.qyJ.right;
      this.qyG.bottom = this.qyJ.top;
      this.qyH.left = this.qyJ.right;
      this.qyH.top = this.qyJ.top;
      this.qyH.right = getWidth();
      this.qyH.bottom = this.qyJ.bottom;
      this.qyI.left = this.qyJ.left;
      this.qyI.top = this.qyJ.bottom;
      this.qyI.right = this.qyJ.right;
      this.qyI.bottom = getHeight();
      this.qyB.left = 0;
      this.qyB.top = 0;
      this.qyB.right = this.qyJ.left;
      this.qyB.bottom = this.qyJ.top;
      this.qyC.left = this.qyJ.right;
      this.qyC.top = 0;
      this.qyC.right = getWidth();
      this.qyC.bottom = this.qyJ.top;
      this.qyD.left = 0;
      this.qyD.top = this.qyJ.bottom;
      this.qyD.right = this.qyJ.left;
      this.qyD.bottom = getHeight();
      this.qyE.left = this.qyJ.right;
      this.qyE.top = this.qyJ.bottom;
      this.qyE.right = getWidth();
      this.qyE.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyF, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyG, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyH, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyI, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyB, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyC, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyD, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.clipRect(this.qyE, Region.Op.REPLACE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
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
      paramCanvas.drawRect(this.qyJ, this.mPaint);
      System.currentTimeMillis();
      System.currentTimeMillis();
      paramCanvas.drawBitmap(this.qyt, this.qyJ.left, this.qyJ.top, this.qyU);
      paramCanvas.drawBitmap(this.qyu, this.qyJ.right - this.qyx, this.qyJ.top, this.qyU);
      paramCanvas.drawBitmap(this.qyv, this.qyJ.left, this.qyJ.bottom - this.qyy, this.qyU);
      paramCanvas.drawBitmap(this.qyw, this.qyJ.right - this.qyx, this.qyJ.bottom - this.qyy, this.qyU);
      System.currentTimeMillis();
      super.onDraw(paramCanvas);
      System.currentTimeMillis();
      AppMethodBeat.o(81153);
      return;
      paramCanvas.clipRect(this.qyJ, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(getResources().getColor(this.qyL));
    }
  }
  
  public void setMaskAnimaListener(ScanMaskView.a parama)
  {
    this.qyW = parama;
  }
  
  public void setMaskColorRsid(int paramInt)
  {
    this.qyL = paramInt;
  }
  
  public void setMastAnimaDuration(int paramInt)
  {
    this.qyP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanMaskView
 * JD-Core Version:    0.7.0.1
 */