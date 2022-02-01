package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class TwistDegreeView
  extends View
{
  protected RectF QjI;
  protected int QjJ;
  protected int QjK;
  protected int QjL;
  protected int QjM;
  protected int QjN;
  protected int QjO;
  protected Paint QjP;
  protected Paint QjQ;
  protected Paint QjR;
  protected Paint QjS;
  protected Paint QjT;
  protected Paint QjU;
  protected float QjV;
  protected int QjW;
  protected int cak;
  protected int cal;
  
  public TwistDegreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310314);
    this.QjV = 0.9F;
    this.QjW = 0;
    setLayerType(1, null);
    this.QjJ = a.fromDPToPix(paramContext, 50);
    this.QjK = a.fromDPToPix(paramContext, 7);
    this.QjL = a.fromDPToPix(paramContext, 7);
    this.QjO = a.fromDPToPix(paramContext, 14);
    this.QjN = a.fromDPToPix(paramContext, 4);
    this.QjM = a.fromDPToPix(paramContext, 3);
    this.cal = a.fromDPToPix(paramContext, 1);
    this.QjP = new Paint();
    this.QjP.setColor(Color.parseColor("#99FFFFFF"));
    this.QjP.setAntiAlias(true);
    this.QjP.setDither(true);
    this.QjP.setStyle(Paint.Style.STROKE);
    this.QjP.setStrokeCap(Paint.Cap.ROUND);
    this.QjP.setStrokeWidth(this.QjK);
    this.QjT = new Paint();
    this.QjT.setColor(Color.parseColor("#99FFFFFF"));
    this.QjT.setAntiAlias(true);
    this.QjT.setDither(true);
    this.QjQ = new Paint();
    this.QjQ.setColor(Color.parseColor("#4DFFFFFF"));
    this.QjQ.setAntiAlias(true);
    this.QjQ.setDither(true);
    this.QjR = new Paint();
    this.QjR.setColor(Color.parseColor("#FFFFFF"));
    this.QjR.setAntiAlias(true);
    this.QjR.setDither(true);
    this.QjR.setStyle(Paint.Style.STROKE);
    this.QjR.setStrokeCap(Paint.Cap.ROUND);
    this.QjR.setStrokeWidth(this.QjL);
    this.QjU = new Paint();
    this.QjU.setColor(Color.parseColor("#FFFFFF"));
    this.QjU.setAntiAlias(true);
    this.QjU.setDither(true);
    this.QjS = new Paint();
    this.QjS.setColor(Color.parseColor("#CCFFFFFF"));
    this.QjS.setAntiAlias(true);
    this.QjS.setDither(true);
    float f = this.QjK / 2;
    this.QjI = new RectF(f, f, this.QjJ * 2 - f, this.QjJ * 2 - f);
    AppMethodBeat.o(310314);
  }
  
  private void b(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(310324);
    Path localPath = hdQ();
    paramPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    paramCanvas.drawPath(localPath, paramPaint);
    AppMethodBeat.o(310324);
  }
  
  private Path hdQ()
  {
    AppMethodBeat.i(310330);
    double d1 = Math.toRadians(45.0D);
    if (this.QjW == 0) {
      d1 = Math.toRadians(135.0D);
    }
    int i = (int)(this.QjJ + (this.QjJ - this.QjK / 2) * Math.cos(d1));
    double d2 = this.QjJ;
    double d3 = this.QjJ - this.QjK / 2;
    int j = (int)(d2 - Math.sin(d1) * d3);
    int k = this.QjO / 2;
    Point localPoint2;
    Point localPoint1;
    if (this.QjW == 0)
    {
      localPoint2 = new Point(i - k, j + k);
      localPoint1 = new Point(i + k, j + k);
    }
    for (Point localPoint3 = new Point(i - k, j - k);; localPoint3 = new Point(i + k, j - k))
    {
      Path localPath = new Path();
      localPath.moveTo(localPoint2.x, localPoint2.y);
      localPath.lineTo(localPoint1.x, localPoint1.y);
      localPath.lineTo(localPoint3.x, localPoint3.y);
      localPath.close();
      AppMethodBeat.o(310330);
      return localPath;
      localPoint2 = new Point(i - k, j + k);
      localPoint1 = new Point(i + k, j + k);
    }
  }
  
  public final void hdP()
  {
    AppMethodBeat.i(310349);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310277);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { TwistDegreeView.this.QjV, 0.9F });
        localValueAnimator.setDuration(150L);
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(310267);
            TwistDegreeView.this.QjV = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            TwistDegreeView.this.invalidate();
            AppMethodBeat.o(310267);
          }
        });
        localValueAnimator.start();
        AppMethodBeat.o(310277);
      }
    });
    AppMethodBeat.o(310349);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(310364);
    float f;
    if (this.QjI != null)
    {
      paramCanvas.save();
      paramCanvas.translate(-this.cak, this.cal);
      paramCanvas.drawArc(this.QjI, 225.0F, 90.0F, false, this.QjP);
      b(paramCanvas, this.QjT);
      f = this.QjV;
      if (this.QjW != 0) {
        break label117;
      }
      paramCanvas.drawArc(this.QjI, 315.0F - f, f, false, this.QjR);
    }
    for (;;)
    {
      if (this.QjV >= 86.400002F) {
        b(paramCanvas, this.QjU);
      }
      paramCanvas.restore();
      AppMethodBeat.o(310364);
      return;
      label117:
      paramCanvas.drawArc(this.QjI, 225.0F, f, false, this.QjR);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310356);
    double d1 = Math.toRadians(45.0D);
    paramInt1 = (int)(this.QjJ * 2 * Math.cos(d1));
    paramInt2 = (int)(this.QjJ - this.QjJ * Math.sin(d1));
    double d2 = this.QjJ;
    double d3 = this.QjJ;
    this.cak = ((int)(d2 - Math.cos(d1) * d3 - this.QjK / 2));
    setMeasuredDimension(this.QjK + paramInt1, this.QjK + paramInt2 + this.cal * 2);
    invalidate();
    AppMethodBeat.o(310356);
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(310336);
    if (paramFloat <= 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.QjV = (paramFloat * 90.0F);
        if (this.QjV < 0.9F) {
          this.QjV = 0.9F;
        }
        invalidate();
        AppMethodBeat.o(310336);
        return;
      }
    }
  }
  
  public void setShowMode(int paramInt)
  {
    AppMethodBeat.i(310341);
    this.QjW = paramInt;
    postInvalidate();
    AppMethodBeat.o(310341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistDegreeView
 * JD-Core Version:    0.7.0.1
 */