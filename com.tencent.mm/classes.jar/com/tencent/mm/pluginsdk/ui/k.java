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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Random;

public final class k
  extends Drawable
{
  private int BWA;
  private float BWB;
  private float BWC;
  private int BWD;
  private int BWE;
  private RectF BWF;
  private Drawable BWs;
  private Interpolator BWt;
  private Interpolator BWu;
  private int BWv;
  private int BWw;
  private int BWx;
  private int BWy;
  private int BWz;
  private Context context;
  private int currentState;
  private float js;
  private float jt;
  private Paint paint;
  private ValueAnimator qT;
  private float rZb;
  private Random random;
  private int rxB;
  private int rxC;
  private int rxD;
  private int rxE;
  private int rxF;
  private int rxG;
  private int rxH;
  private boolean rxI;
  private int rxJ;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.BWs = null;
    this.rxB = 0;
    this.rxC = 0;
    this.paint = new Paint(1);
    this.BWt = new LinearInterpolator();
    this.BWu = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.rxH = 0;
    this.rZb = 0.0F;
    this.js = -90.0F;
    this.BWB = 0.0F;
    this.jt = 0.0F;
    this.BWC = 5.0F;
    this.rxI = false;
    this.currentState = 2;
    this.qT = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.qT.setInterpolator(this.BWt);
    this.qT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(31244);
        k.a(k.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        k.this.invalidateSelf();
        AppMethodBeat.o(31244);
      }
    });
    this.BWF = new RectF();
    this.context = paramContext;
    this.rxB = a.n(paramContext, 2131101171);
    this.rxC = a.n(paramContext, 2131100707);
    this.BWs = paramContext.getResources().getDrawable(2131691384);
    this.BWx = a.ap(paramContext, 2131166989);
    this.BWy = a.ap(paramContext, 2131166988);
    this.BWz = a.ap(paramContext, 2131166978);
    this.rxH = a.ap(paramContext, 2131166983);
    this.rxD = a.n(paramContext, 2131101078);
    this.BWw = a.ap(paramContext, 2131166980);
    this.BWA = a.ap(paramContext, 2131166979);
    this.rxG = a.n(paramContext, 2131101079);
    this.BWD = this.BWA;
    this.BWE = this.BWD;
    this.rxJ = a.ap(paramContext, 2131166982);
    this.rxE = a.ap(paramContext, 2131166982);
    this.rxF = a.ap(paramContext, 2131166981);
    this.BWv = a.ap(paramContext, 2131166990);
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
  
  public final void UF(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    ad.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.rxI = bool;
      invalidateSelf();
      AppMethodBeat.o(31250);
      return;
      bool = false;
    }
  }
  
  public final void cyr()
  {
    AppMethodBeat.i(31247);
    ad.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.qT.cancel();
    this.rZb = 0.0F;
    this.js = -90.0F;
    this.BWB = 0.0F;
    this.jt = 0.0F;
    this.BWC = 5.0F;
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
      this.paint.setColor(this.rxD);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.rxI)
      {
        this.rxJ -= 4;
        this.rxJ = Math.min(Math.max(this.rxE, this.rxJ), this.rxF);
        paramCanvas.drawCircle(i, j, this.rxJ, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.BWs != null) && (!l(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.rxB);
        this.paint.setStrokeWidth(this.BWv);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.BWF.left = (paramCanvas.getWidth() / 2 - this.BWA);
        this.BWF.top = (paramCanvas.getHeight() / 2 - this.BWA);
        this.BWF.right = (paramCanvas.getWidth() / 2 + this.BWA);
        this.BWF.bottom = (paramCanvas.getHeight() / 2 + this.BWA);
        paramCanvas.drawArc(this.BWF, this.js, this.jt, false, this.paint);
        this.js += this.BWB;
        this.jt += this.BWC;
        if (this.jt < 360.0F) {
          break label572;
        }
        this.BWC = (-this.BWC);
        this.BWB = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.rxG);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.rxH, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.rxJ += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.rxE, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.BWs.setColorFilter(this.rxC, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.BWs.setBounds(i - this.rxH, j - this.rxH, i + this.rxH, j + this.rxH);
        this.BWs.draw(paramCanvas);
        break;
        this.BWs.setColorFilter(this.rxB, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.jt <= 0.0F)
      {
        this.BWC = (-this.BWC);
        this.BWB = 0.0F;
        this.js = -90.0F;
        this.jt = 0.0F;
      }
    }
  }
  
  public final void exG()
  {
    AppMethodBeat.i(31246);
    ad.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.qT.cancel();
    this.rZb = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void exH()
  {
    AppMethodBeat.i(31248);
    ad.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.qT.cancel();
    this.rZb = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void exI()
  {
    AppMethodBeat.i(31251);
    ad.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.qT.cancel();
    this.rZb = 0.0F;
    this.qT.setInterpolator(new AccelerateDecelerateInterpolator());
    this.qT.setDuration(1000L);
    this.qT.setRepeatCount(-1);
    this.qT.start();
    AppMethodBeat.o(31251);
  }
  
  public final void exJ()
  {
    AppMethodBeat.i(31252);
    ad.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.qT.cancel();
    this.rZb = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.rxH * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.hV(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void tX(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    ad.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.rxI = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.k
 * JD-Core Version:    0.7.0.1
 */