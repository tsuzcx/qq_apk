package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Random;

public final class l
  extends Drawable
{
  private Drawable Fmi;
  private Interpolator Fmj;
  private Interpolator Fmk;
  private int Fml;
  private int Fmm;
  private int Fmn;
  private int Fmo;
  private int Fmp;
  private int Fmq;
  private float Fmr;
  private float Fms;
  private int Fmt;
  private int Fmu;
  private RectF Fmv;
  private ValueAnimator animator;
  private Context context;
  private int currentState;
  private float mh;
  private float mi;
  private Paint paint;
  private Random random;
  private int tOd;
  private int tOe;
  private int tOf;
  private int tOg;
  private int tOh;
  private int tOi;
  private int tOj;
  private boolean tOk;
  private int tOl;
  private float upR;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.Fmi = null;
    this.tOd = 0;
    this.tOe = 0;
    this.paint = new Paint(1);
    this.Fmj = new LinearInterpolator();
    this.Fmk = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.tOj = 0;
    this.upR = 0.0F;
    this.mh = -90.0F;
    this.Fmr = 0.0F;
    this.mi = 0.0F;
    this.Fms = 5.0F;
    this.tOk = false;
    this.currentState = 2;
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.animator.setInterpolator(this.Fmj);
    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(31244);
        l.a(l.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        l.this.invalidateSelf();
        AppMethodBeat.o(31244);
      }
    });
    this.Fmv = new RectF();
    this.context = paramContext;
    this.tOd = a.n(paramContext, 2131101171);
    this.tOe = a.n(paramContext, 2131100707);
    this.Fmi = paramContext.getResources().getDrawable(2131691384);
    this.Fmn = a.ay(paramContext, 2131166989);
    this.Fmo = a.ay(paramContext, 2131166988);
    this.Fmp = a.ay(paramContext, 2131166978);
    this.tOj = a.ay(paramContext, 2131166983);
    this.tOf = a.n(paramContext, 2131101078);
    this.Fmm = a.ay(paramContext, 2131166980);
    this.Fmq = a.ay(paramContext, 2131166979);
    this.tOi = a.n(paramContext, 2131101079);
    this.Fmt = this.Fmq;
    this.Fmu = this.Fmt;
    this.tOl = a.ay(paramContext, 2131166982);
    this.tOg = a.ay(paramContext, 2131166982);
    this.tOh = a.ay(paramContext, 2131166981);
    this.Fml = a.ay(paramContext, 2131166990);
    AppMethodBeat.o(31245);
  }
  
  private static boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(31255);
    if ((paramCanvas == null) || (paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0))
    {
      AppMethodBeat.o(31255);
      return true;
    }
    AppMethodBeat.o(31255);
    return false;
  }
  
  public final void Zr(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    ae.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.tOk = bool;
      invalidateSelf();
      AppMethodBeat.o(31250);
      return;
      bool = false;
    }
  }
  
  public final void cWB()
  {
    AppMethodBeat.i(31247);
    ae.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.animator.cancel();
    this.upR = 0.0F;
    this.mh = -90.0F;
    this.Fmr = 0.0F;
    this.mi = 0.0F;
    this.Fms = 5.0F;
    invalidateSelf();
    AppMethodBeat.o(31247);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(31253);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.tOf);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.tOk)
      {
        this.tOl -= 4;
        this.tOl = Math.min(Math.max(this.tOg, this.tOl), this.tOh);
        paramCanvas.drawCircle(i, j, this.tOl, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.Fmi != null) && (!l(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.tOd);
        this.paint.setStrokeWidth(this.Fml);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.Fmv.left = (paramCanvas.getWidth() / 2 - this.Fmq);
        this.Fmv.top = (paramCanvas.getHeight() / 2 - this.Fmq);
        this.Fmv.right = (paramCanvas.getWidth() / 2 + this.Fmq);
        this.Fmv.bottom = (paramCanvas.getHeight() / 2 + this.Fmq);
        paramCanvas.drawArc(this.Fmv, this.mh, this.mi, false, this.paint);
        this.mh += this.Fmr;
        this.mi += this.Fms;
        if (this.mi < 360.0F) {
          break label572;
        }
        this.Fms = (-this.Fms);
        this.Fmr = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.tOi);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.tOj, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.tOl += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.tOg, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.Fmi.setColorFilter(this.tOe, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.Fmi.setBounds(i - this.tOj, j - this.tOj, i + this.tOj, j + this.tOj);
        this.Fmi.draw(paramCanvas);
        break;
        this.Fmi.setColorFilter(this.tOd, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.mi <= 0.0F)
      {
        this.Fms = (-this.Fms);
        this.Fmr = 0.0F;
        this.mh = -90.0F;
        this.mi = 0.0F;
      }
    }
  }
  
  public final void ffN()
  {
    AppMethodBeat.i(31246);
    ae.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.animator.cancel();
    this.upR = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void ffO()
  {
    AppMethodBeat.i(31248);
    ae.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.animator.cancel();
    this.upR = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void ffP()
  {
    AppMethodBeat.i(31251);
    ae.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.animator.cancel();
    this.upR = 0.0F;
    this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.animator.setDuration(1000L);
    this.animator.setRepeatCount(-1);
    this.animator.start();
    AppMethodBeat.o(31251);
  }
  
  public final void ffQ()
  {
    AppMethodBeat.i(31252);
    ae.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.animator.cancel();
    this.upR = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.tOj * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.iu(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void vR(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    ae.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.tOk = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */