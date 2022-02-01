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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Random;

public final class l
  extends Drawable
{
  private Drawable ETN;
  private Interpolator ETO;
  private Interpolator ETP;
  private int ETQ;
  private int ETR;
  private int ETS;
  private int ETT;
  private int ETU;
  private int ETV;
  private float ETW;
  private float ETX;
  private int ETY;
  private int ETZ;
  private RectF EUa;
  private ValueAnimator animator;
  private Context context;
  private int currentState;
  private float mh;
  private float mi;
  private Paint paint;
  private Random random;
  private int tDm;
  private int tDn;
  private int tDo;
  private int tDp;
  private int tDq;
  private int tDr;
  private int tDs;
  private boolean tDt;
  private int tDu;
  private float ueK;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.ETN = null;
    this.tDm = 0;
    this.tDn = 0;
    this.paint = new Paint(1);
    this.ETO = new LinearInterpolator();
    this.ETP = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.tDs = 0;
    this.ueK = 0.0F;
    this.mh = -90.0F;
    this.ETW = 0.0F;
    this.mi = 0.0F;
    this.ETX = 5.0F;
    this.tDt = false;
    this.currentState = 2;
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.animator.setInterpolator(this.ETO);
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
    this.EUa = new RectF();
    this.context = paramContext;
    this.tDm = a.n(paramContext, 2131101171);
    this.tDn = a.n(paramContext, 2131100707);
    this.ETN = paramContext.getResources().getDrawable(2131691384);
    this.ETS = a.ay(paramContext, 2131166989);
    this.ETT = a.ay(paramContext, 2131166988);
    this.ETU = a.ay(paramContext, 2131166978);
    this.tDs = a.ay(paramContext, 2131166983);
    this.tDo = a.n(paramContext, 2131101078);
    this.ETR = a.ay(paramContext, 2131166980);
    this.ETV = a.ay(paramContext, 2131166979);
    this.tDr = a.n(paramContext, 2131101079);
    this.ETY = this.ETV;
    this.ETZ = this.ETY;
    this.tDu = a.ay(paramContext, 2131166982);
    this.tDp = a.ay(paramContext, 2131166982);
    this.tDq = a.ay(paramContext, 2131166981);
    this.ETQ = a.ay(paramContext, 2131166990);
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
  
  public final void YL(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    ad.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.tDt = bool;
      invalidateSelf();
      AppMethodBeat.o(31250);
      return;
      bool = false;
    }
  }
  
  public final void cTW()
  {
    AppMethodBeat.i(31247);
    ad.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.animator.cancel();
    this.ueK = 0.0F;
    this.mh = -90.0F;
    this.ETW = 0.0F;
    this.mi = 0.0F;
    this.ETX = 5.0F;
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
      this.paint.setColor(this.tDo);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.tDt)
      {
        this.tDu -= 4;
        this.tDu = Math.min(Math.max(this.tDp, this.tDu), this.tDq);
        paramCanvas.drawCircle(i, j, this.tDu, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.ETN != null) && (!l(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.tDm);
        this.paint.setStrokeWidth(this.ETQ);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.EUa.left = (paramCanvas.getWidth() / 2 - this.ETV);
        this.EUa.top = (paramCanvas.getHeight() / 2 - this.ETV);
        this.EUa.right = (paramCanvas.getWidth() / 2 + this.ETV);
        this.EUa.bottom = (paramCanvas.getHeight() / 2 + this.ETV);
        paramCanvas.drawArc(this.EUa, this.mh, this.mi, false, this.paint);
        this.mh += this.ETW;
        this.mi += this.ETX;
        if (this.mi < 360.0F) {
          break label572;
        }
        this.ETX = (-this.ETX);
        this.ETW = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!l(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.tDr);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.tDs, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.tDu += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.tDp, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.ETN.setColorFilter(this.tDn, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.ETN.setBounds(i - this.tDs, j - this.tDs, i + this.tDs, j + this.tDs);
        this.ETN.draw(paramCanvas);
        break;
        this.ETN.setColorFilter(this.tDm, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.mi <= 0.0F)
      {
        this.ETX = (-this.ETX);
        this.ETW = 0.0F;
        this.mh = -90.0F;
        this.mi = 0.0F;
      }
    }
  }
  
  public final void fbZ()
  {
    AppMethodBeat.i(31246);
    ad.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.animator.cancel();
    this.ueK = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void fca()
  {
    AppMethodBeat.i(31248);
    ad.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.animator.cancel();
    this.ueK = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void fcb()
  {
    AppMethodBeat.i(31251);
    ad.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.animator.cancel();
    this.ueK = 0.0F;
    this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.animator.setDuration(1000L);
    this.animator.setRepeatCount(-1);
    this.animator.start();
    AppMethodBeat.o(31251);
  }
  
  public final void fcc()
  {
    AppMethodBeat.i(31252);
    ad.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.animator.cancel();
    this.ueK = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.tDs * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.ip(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    ad.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.tDt = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */