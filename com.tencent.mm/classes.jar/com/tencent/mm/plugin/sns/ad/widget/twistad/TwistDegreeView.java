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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class TwistDegreeView
  extends View
{
  protected int JOA;
  protected Paint JOB;
  protected Paint JOC;
  protected Paint JOD;
  protected Paint JOE;
  protected Paint JOF;
  protected Paint JOG;
  protected float JOH;
  protected int JOI;
  protected RectF JOu;
  protected int JOv;
  protected int JOw;
  protected int JOx;
  protected int JOy;
  protected int JOz;
  protected int alK;
  protected int alL;
  
  public TwistDegreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(222416);
    this.JOH = 0.9F;
    this.JOI = 0;
    setLayerType(1, null);
    this.JOv = a.fromDPToPix(paramContext, 50);
    this.JOw = a.fromDPToPix(paramContext, 7);
    this.JOx = a.fromDPToPix(paramContext, 7);
    this.JOA = a.fromDPToPix(paramContext, 14);
    this.JOz = a.fromDPToPix(paramContext, 4);
    this.JOy = a.fromDPToPix(paramContext, 3);
    this.alL = a.fromDPToPix(paramContext, 1);
    this.JOB = new Paint();
    this.JOB.setColor(Color.parseColor("#99FFFFFF"));
    this.JOB.setAntiAlias(true);
    this.JOB.setDither(true);
    this.JOB.setStyle(Paint.Style.STROKE);
    this.JOB.setStrokeCap(Paint.Cap.ROUND);
    this.JOB.setStrokeWidth(this.JOw);
    this.JOF = new Paint();
    this.JOF.setColor(Color.parseColor("#99FFFFFF"));
    this.JOF.setAntiAlias(true);
    this.JOF.setDither(true);
    this.JOC = new Paint();
    this.JOC.setColor(Color.parseColor("#4DFFFFFF"));
    this.JOC.setAntiAlias(true);
    this.JOC.setDither(true);
    this.JOD = new Paint();
    this.JOD.setColor(Color.parseColor("#FFFFFF"));
    this.JOD.setAntiAlias(true);
    this.JOD.setDither(true);
    this.JOD.setStyle(Paint.Style.STROKE);
    this.JOD.setStrokeCap(Paint.Cap.ROUND);
    this.JOD.setStrokeWidth(this.JOx);
    this.JOG = new Paint();
    this.JOG.setColor(Color.parseColor("#FFFFFF"));
    this.JOG.setAntiAlias(true);
    this.JOG.setDither(true);
    this.JOE = new Paint();
    this.JOE.setColor(Color.parseColor("#CCFFFFFF"));
    this.JOE.setAntiAlias(true);
    this.JOE.setDither(true);
    float f = this.JOw / 2;
    this.JOu = new RectF(f, f, this.JOv * 2 - f, this.JOv * 2 - f);
    AppMethodBeat.o(222416);
  }
  
  private void b(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(222443);
    Path localPath = fMJ();
    paramPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    paramCanvas.drawPath(localPath, paramPaint);
    AppMethodBeat.o(222443);
  }
  
  private Path fMJ()
  {
    AppMethodBeat.i(222456);
    double d1 = Math.toRadians(45.0D);
    if (this.JOI == 0) {
      d1 = Math.toRadians(135.0D);
    }
    int i = (int)(this.JOv + (this.JOv - this.JOw / 2) * Math.cos(d1));
    double d2 = this.JOv;
    double d3 = this.JOv - this.JOw / 2;
    int j = (int)(d2 - Math.sin(d1) * d3);
    int k = this.JOA / 2;
    Point localPoint2;
    Point localPoint1;
    if (this.JOI == 0)
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
      AppMethodBeat.o(222456);
      return localPath;
      localPoint2 = new Point(i - k, j + k);
      localPoint1 = new Point(i + k, j + k);
    }
  }
  
  public final void fMI()
  {
    AppMethodBeat.i(222422);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198254);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { TwistDegreeView.this.JOH, 0.9F });
        localValueAnimator.setDuration(150L);
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(257540);
            TwistDegreeView.this.JOH = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            TwistDegreeView.this.invalidate();
            AppMethodBeat.o(257540);
          }
        });
        localValueAnimator.start();
        AppMethodBeat.o(198254);
      }
    });
    AppMethodBeat.o(222422);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(222438);
    float f;
    if (this.JOu != null)
    {
      paramCanvas.save();
      paramCanvas.translate(-this.alK, this.alL);
      paramCanvas.drawArc(this.JOu, 225.0F, 90.0F, false, this.JOB);
      b(paramCanvas, this.JOF);
      f = this.JOH;
      if (this.JOI != 0) {
        break label117;
      }
      paramCanvas.drawArc(this.JOu, 315.0F - f, f, false, this.JOD);
    }
    for (;;)
    {
      if (this.JOH >= 86.400002F) {
        b(paramCanvas, this.JOG);
      }
      paramCanvas.restore();
      AppMethodBeat.o(222438);
      return;
      label117:
      paramCanvas.drawArc(this.JOu, 225.0F, f, false, this.JOD);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222428);
    double d1 = Math.toRadians(45.0D);
    paramInt1 = (int)(this.JOv * 2 * Math.cos(d1));
    paramInt2 = (int)(this.JOv - this.JOv * Math.sin(d1));
    double d2 = this.JOv;
    double d3 = this.JOv;
    this.alK = ((int)(d2 - Math.cos(d1) * d3 - this.JOw / 2));
    setMeasuredDimension(this.JOw + paramInt1, this.JOw + paramInt2 + this.alL * 2);
    invalidate();
    AppMethodBeat.o(222428);
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(222419);
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
        this.JOH = (paramFloat * 90.0F);
        if (this.JOH < 0.9F) {
          this.JOH = 0.9F;
        }
        invalidate();
        AppMethodBeat.o(222419);
        return;
      }
    }
  }
  
  public void setShowMode(int paramInt)
  {
    AppMethodBeat.i(222420);
    this.JOI = paramInt;
    postInvalidate();
    AppMethodBeat.o(222420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistDegreeView
 * JD-Core Version:    0.7.0.1
 */