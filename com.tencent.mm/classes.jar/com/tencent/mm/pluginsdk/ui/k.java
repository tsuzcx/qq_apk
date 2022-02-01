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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Random;

public final class k
  extends Drawable
{
  private Drawable DoJ;
  private Interpolator DoK;
  private Interpolator DoL;
  private int DoM;
  private int DoN;
  private int DoO;
  private int DoP;
  private int DoQ;
  private int DoR;
  private float DoS;
  private float DoT;
  private int DoU;
  private int DoV;
  private RectF DoW;
  private Context context;
  private int currentState;
  private float kr;
  private float ks;
  private Paint paint;
  private ValueAnimator rT;
  private Random random;
  private boolean sGA;
  private int sGB;
  private int sGt;
  private int sGu;
  private int sGv;
  private int sGw;
  private int sGx;
  private int sGy;
  private int sGz;
  private float tgT;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.DoJ = null;
    this.sGt = 0;
    this.sGu = 0;
    this.paint = new Paint(1);
    this.DoK = new LinearInterpolator();
    this.DoL = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.sGz = 0;
    this.tgT = 0.0F;
    this.kr = -90.0F;
    this.DoS = 0.0F;
    this.ks = 0.0F;
    this.DoT = 5.0F;
    this.sGA = false;
    this.currentState = 2;
    this.rT = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.rT.setInterpolator(this.DoK);
    this.rT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(31244);
        k.a(k.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        k.this.invalidateSelf();
        AppMethodBeat.o(31244);
      }
    });
    this.DoW = new RectF();
    this.context = paramContext;
    this.sGt = a.n(paramContext, 2131101171);
    this.sGu = a.n(paramContext, 2131100707);
    this.DoJ = paramContext.getResources().getDrawable(2131691384);
    this.DoO = a.av(paramContext, 2131166989);
    this.DoP = a.av(paramContext, 2131166988);
    this.DoQ = a.av(paramContext, 2131166978);
    this.sGz = a.av(paramContext, 2131166983);
    this.sGv = a.n(paramContext, 2131101078);
    this.DoN = a.av(paramContext, 2131166980);
    this.DoR = a.av(paramContext, 2131166979);
    this.sGy = a.n(paramContext, 2131101079);
    this.DoU = this.DoR;
    this.DoV = this.DoU;
    this.sGB = a.av(paramContext, 2131166982);
    this.sGw = a.av(paramContext, 2131166982);
    this.sGx = a.av(paramContext, 2131166981);
    this.DoM = a.av(paramContext, 2131166990);
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
  
  public final void WP(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    ac.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.sGA = bool;
      invalidateSelf();
      AppMethodBeat.o(31250);
      return;
      bool = false;
    }
  }
  
  public final void cLD()
  {
    AppMethodBeat.i(31247);
    ac.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.rT.cancel();
    this.tgT = 0.0F;
    this.kr = -90.0F;
    this.DoS = 0.0F;
    this.ks = 0.0F;
    this.DoT = 5.0F;
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
      this.paint.setColor(this.sGv);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.sGA)
      {
        this.sGB -= 4;
        this.sGB = Math.min(Math.max(this.sGw, this.sGB), this.sGx);
        paramCanvas.drawCircle(i, j, this.sGB, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.DoJ != null) && (!l(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.sGt);
        this.paint.setStrokeWidth(this.DoM);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.DoW.left = (paramCanvas.getWidth() / 2 - this.DoR);
        this.DoW.top = (paramCanvas.getHeight() / 2 - this.DoR);
        this.DoW.right = (paramCanvas.getWidth() / 2 + this.DoR);
        this.DoW.bottom = (paramCanvas.getHeight() / 2 + this.DoR);
        paramCanvas.drawArc(this.DoW, this.kr, this.ks, false, this.paint);
        this.kr += this.DoS;
        this.ks += this.DoT;
        if (this.ks < 360.0F) {
          break label572;
        }
        this.DoT = (-this.DoT);
        this.DoS = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.sGy);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.sGz, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.sGB += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.sGw, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.DoJ.setColorFilter(this.sGu, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.DoJ.setBounds(i - this.sGz, j - this.sGz, i + this.sGz, j + this.sGz);
        this.DoJ.draw(paramCanvas);
        break;
        this.DoJ.setColorFilter(this.sGt, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.ks <= 0.0F)
      {
        this.DoT = (-this.DoT);
        this.DoS = 0.0F;
        this.kr = -90.0F;
        this.ks = 0.0F;
      }
    }
  }
  
  public final void eNa()
  {
    AppMethodBeat.i(31246);
    ac.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.rT.cancel();
    this.tgT = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void eNb()
  {
    AppMethodBeat.i(31248);
    ac.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.rT.cancel();
    this.tgT = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void eNc()
  {
    AppMethodBeat.i(31251);
    ac.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.rT.cancel();
    this.tgT = 0.0F;
    this.rT.setInterpolator(new AccelerateDecelerateInterpolator());
    this.rT.setDuration(1000L);
    this.rT.setRepeatCount(-1);
    this.rT.start();
    AppMethodBeat.o(31251);
  }
  
  public final void eNd()
  {
    AppMethodBeat.i(31252);
    ac.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.rT.cancel();
    this.tgT = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.sGz * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.ig(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void uY(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    ac.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.sGA = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.k
 * JD-Core Version:    0.7.0.1
 */