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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class TwistDegreeView
  extends View
{
  protected RectF DCb;
  protected int DCc;
  protected int DCd;
  protected int DCe;
  protected int DCf;
  protected int DCg;
  protected int DCh;
  protected Paint DCi;
  protected Paint DCj;
  protected Paint DCk;
  protected Paint DCl;
  protected Paint DCm;
  protected Paint DCn;
  protected float DCo;
  protected int DCp;
  protected int atS;
  protected int atT;
  
  public TwistDegreeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202528);
    this.DCo = 0.9F;
    this.DCp = 0;
    setLayerType(1, null);
    this.DCc = a.fromDPToPix(paramContext, 50);
    this.DCd = a.fromDPToPix(paramContext, 7);
    this.DCe = a.fromDPToPix(paramContext, 7);
    this.DCh = a.fromDPToPix(paramContext, 14);
    this.DCg = a.fromDPToPix(paramContext, 4);
    this.DCf = a.fromDPToPix(paramContext, 3);
    this.atT = a.fromDPToPix(paramContext, 1);
    this.DCi = new Paint();
    this.DCi.setColor(Color.parseColor("#99FFFFFF"));
    this.DCi.setAntiAlias(true);
    this.DCi.setDither(true);
    this.DCi.setStyle(Paint.Style.STROKE);
    this.DCi.setStrokeCap(Paint.Cap.ROUND);
    this.DCi.setStrokeWidth(this.DCd);
    this.DCm = new Paint();
    this.DCm.setColor(Color.parseColor("#99FFFFFF"));
    this.DCm.setAntiAlias(true);
    this.DCm.setDither(true);
    this.DCj = new Paint();
    this.DCj.setColor(Color.parseColor("#4DFFFFFF"));
    this.DCj.setAntiAlias(true);
    this.DCj.setDither(true);
    this.DCk = new Paint();
    this.DCk.setColor(Color.parseColor("#FFFFFF"));
    this.DCk.setAntiAlias(true);
    this.DCk.setDither(true);
    this.DCk.setStyle(Paint.Style.STROKE);
    this.DCk.setStrokeCap(Paint.Cap.ROUND);
    this.DCk.setStrokeWidth(this.DCe);
    this.DCn = new Paint();
    this.DCn.setColor(Color.parseColor("#FFFFFF"));
    this.DCn.setAntiAlias(true);
    this.DCn.setDither(true);
    this.DCl = new Paint();
    this.DCl.setColor(Color.parseColor("#CCFFFFFF"));
    this.DCl.setAntiAlias(true);
    this.DCl.setDither(true);
    float f = this.DCd / 2;
    this.DCb = new RectF(f, f, this.DCc * 2 - f, this.DCc * 2 - f);
    AppMethodBeat.o(202528);
  }
  
  private void b(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(202534);
    Path localPath = getTriangle$191b16f3();
    paramPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    paramCanvas.drawPath(localPath, paramPaint);
    AppMethodBeat.o(202534);
  }
  
  private Path getTriangle$191b16f3()
  {
    AppMethodBeat.i(202535);
    double d1 = Math.toRadians(45.0D);
    if (this.DCp == 0) {
      d1 = Math.toRadians(135.0D);
    }
    int i = (int)(this.DCc + (this.DCc - this.DCd / 2) * Math.cos(d1));
    double d2 = this.DCc;
    double d3 = this.DCc - this.DCd / 2;
    int j = (int)(d2 - Math.sin(d1) * d3);
    int k = this.DCh / 2;
    Point localPoint2;
    Point localPoint1;
    if (this.DCp == 0)
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
      AppMethodBeat.o(202535);
      return localPath;
      localPoint2 = new Point(i - k, j + k);
      localPoint1 = new Point(i + k, j + k);
    }
  }
  
  public final void eYR()
  {
    AppMethodBeat.i(202531);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202527);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { TwistDegreeView.this.DCo, 0.9F });
        localValueAnimator.setDuration(150L);
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(202526);
            TwistDegreeView.this.DCo = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
            TwistDegreeView.this.invalidate();
            AppMethodBeat.o(202526);
          }
        });
        localValueAnimator.start();
        AppMethodBeat.o(202527);
      }
    });
    AppMethodBeat.o(202531);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202533);
    float f;
    if (this.DCb != null)
    {
      paramCanvas.save();
      paramCanvas.translate(-this.atS, this.atT);
      paramCanvas.drawArc(this.DCb, 225.0F, 90.0F, false, this.DCi);
      b(paramCanvas, this.DCm);
      f = this.DCo;
      if (this.DCp != 0) {
        break label117;
      }
      paramCanvas.drawArc(this.DCb, 315.0F - f, f, false, this.DCk);
    }
    for (;;)
    {
      if (this.DCo >= 86.400002F) {
        b(paramCanvas, this.DCn);
      }
      paramCanvas.restore();
      AppMethodBeat.o(202533);
      return;
      label117:
      paramCanvas.drawArc(this.DCb, 225.0F, f, false, this.DCk);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202532);
    double d1 = Math.toRadians(45.0D);
    paramInt1 = (int)(this.DCc * 2 * Math.cos(d1));
    paramInt2 = (int)(this.DCc - this.DCc * Math.sin(d1));
    double d2 = this.DCc;
    double d3 = this.DCc;
    this.atS = ((int)(d2 - Math.cos(d1) * d3 - this.DCd / 2));
    setMeasuredDimension(this.DCd + paramInt1, this.DCd + paramInt2 + this.atT * 2);
    invalidate();
    AppMethodBeat.o(202532);
  }
  
  public void setProgress(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(202529);
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
        this.DCo = (paramFloat * 90.0F);
        if (this.DCo < 0.9F) {
          this.DCo = 0.9F;
        }
        invalidate();
        AppMethodBeat.o(202529);
        return;
      }
    }
  }
  
  public void setShowMode(int paramInt)
  {
    AppMethodBeat.i(202530);
    this.DCp = paramInt;
    postInvalidate();
    AppMethodBeat.o(202530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistDegreeView
 * JD-Core Version:    0.7.0.1
 */